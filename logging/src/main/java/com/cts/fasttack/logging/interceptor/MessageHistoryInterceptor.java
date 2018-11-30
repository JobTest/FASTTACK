package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.common.core.util.XmlUtil;
import com.cts.fasttack.logging.dto.LoggingMessage;
import com.cts.fasttack.logging.dto.MessageHistoryDto;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.logging.service.MessageHistoryService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class MessageHistoryInterceptor implements MethodInterceptor {

    public static final ThreadLocal<Long> PARENT_ID = new ThreadLocal<>();

    private static final SpelExpressionParser SPEL_EXPRESSION_PARSER = new SpelExpressionParser(new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null));

    private static final ParameterNameDiscoverer PARAMETER_NAME_DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private MessageHistoryService messageHistoryService;

    @Override
    public Object invoke(MethodInvocation i) throws Throwable {
        Class<?> c = AopProxyUtils.ultimateTargetClass(i.getThis());
        if (c == null && i.getThis() != null) {
            c = i.getThis().getClass();
        }

        Method m = ClassUtils.getMostSpecificMethod(i.getMethod(), c);
        MessageHistoryOperation a = AnnotationUtils.getAnnotation(m, MessageHistoryOperation.class);

        MessageHistoryDto mh = null;
        try {
            String requestId = UUID.randomUUID().toString();

            // save in
            mh = createMessageHistory(a, m, i, requestId);

            // proceed
            Object r = i.proceed();

            // save out
            if (r != null) {
                LoggingMessage responseMessage = new LoggingMessage(requestId);
                MediaType mediaType = MediaType.parseMediaType(a.responseMediaType());
                if(mediaType.isCompatibleWith(MediaType.APPLICATION_XML)){
                    responseMessage.resetPayload(XmlUtil.toXml(r));
                } else {
                    responseMessage.resetPayload(JsonUtil.toJson(r));
                }

                ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
                if (requestAttributes != null) {
                    HttpServletResponse response = requestAttributes.getResponse();
                    responseMessage.responseCode(response.getStatus())
                            .message(HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
                }

                mh.setMsgRawOut(responseMessage.toString());
                Class<?> targetClass = AopProxyUtils.ultimateTargetClass(i.getThis());

                EvaluationContext context;
                if(r instanceof ResponseEntity) {
                    context = evaluator.createEvaluationContext(m, i.getArguments(), ((ResponseEntity<?>) r).getBody(), targetClass);
                } else {
                    context = evaluator.createEvaluationContext(m, i.getArguments(), r, targetClass);
                }

                if (StringUtils.isNotEmpty(a.decision())) {
                    mh.setDecision(parseEl(context, a.decision()));
                }

                if (StringUtils.isNotEmpty(a.errorCode())) {
                    mh.setErrorCode(parseEl(context, a.errorCode()));
                }

                if (StringUtils.isNotEmpty(a.cvcResp())) {
                    mh.setCvcResp(parseEl(context, a.cvcResp()));
                }

                if (StringUtils.isNotEmpty(a.panInternalId())) {
                    String panInternalId = parseEl(context, a.panInternalId());
                    if(StringUtils.isNotBlank(panInternalId)) {
                        mh.setPanInternalId(panInternalId);
                    }
                }

                if (StringUtils.isNotEmpty(a.panInternalGuid())) {
                    String panInternalGuid = parseEl(context, a.panInternalGuid());
                    if(StringUtils.isNotBlank(panInternalGuid)) {
                        mh.setPanInternalGuid(panInternalGuid);
                    }
                }

                if (StringUtils.isNotEmpty(a.maskedPan())) {
                    String maskedPan = parseEl(context, a.maskedPan());
                    if(StringUtils.isNotBlank(maskedPan)) {
                        mh.setMaskedPan(maskedPan);
                    }
                }

                if (StringUtils.isNotEmpty(a.panSource())) {
                    String panSource = parseEl(context, a.panSource());
                    if(StringUtils.isNotBlank(panSource)) {
                        mh.setPanSource(panSource);
                    }
                }
            }

            return r;
        } catch (Exception e) {
            if (mh != null) {
                mh.setMsgRawOut(JsonUtil.toJson(ExceptionUtils.getMessage(e)));
            }
            throw e;
        } finally {
            if (mh != null) {
                mh.setMsgDateOut(new Date());
                messageHistoryService.update(mh);
            }

            // after all stack clear parent id from thread local
            PARENT_ID.remove();
        }
    }

    private String parseEl(EvaluationContext context, String expression){
        return SPEL_EXPRESSION_PARSER.parseExpression(expression).getValue(context, String.class);
    }

    private MessageHistoryDto createMessageHistory(MessageHistoryOperation a, Method m, MethodInvocation i, String requestId) throws ServiceException {
        StandardEvaluationContext elContext = new StandardEvaluationContext(i.getArguments());

        String[] parameterNames = PARAMETER_NAME_DISCOVERER.getParameterNames(m);
        if (parameterNames != null) {
            for (int j = 0; j < parameterNames.length; j++) {
                elContext.setVariable(parameterNames[j], i.getArguments()[j]);
            }
        }

        MessageHistoryDto mh = new MessageHistoryDto();

        LoggingMessage requestMessage = new LoggingMessage(requestId);
        if(StringUtils.isNotEmpty(a.rawIn())){
            requestMessage.resetPayload(JsonUtil.toJson(SPEL_EXPRESSION_PARSER.parseExpression(a.rawIn()).getValue(elContext)));
        }

        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            requestMessage.address(request.getRequestURL().toString())
                    .httpMethod(request.getMethod())
                    .contentType(request.getContentType());
        }

        mh.setMsgRawIn(StringUtil.sensitiveFieldsHiding(requestMessage.toString()));
        mh.setMsgDateIn(new Date());

        if (StringUtils.isNotEmpty(a.tokenId())) {
            mh.setTokenId(parseEl(elContext, a.tokenId()));
        }

        if (StringUtils.isNotEmpty(a.maskedPan())) {
            mh.setMaskedPan(parseEl(elContext, a.maskedPan()));
        }

        if (StringUtils.isNotEmpty(a.panInternalId())) {
            mh.setPanInternalId(parseEl(elContext, a.panInternalId()));
        }

        if (StringUtils.isNotEmpty(a.panInternalGuid())) {
            mh.setPanInternalGuid(parseEl(elContext, a.panInternalGuid()));
        }

        if (StringUtils.isNotEmpty(a.panSource())) {
            mh.setPanSource(parseEl(elContext, a.panSource()));
        }

        if (StringUtils.isNotEmpty(a.msgType())) {
            mh.setMsgType(a.msgType());
        } else {
            mh.setMsgType(StringUtil.toUppercaseWordsWithUnderscores(m.getName()));
        }

        if (StringUtils.isNotEmpty(a.connectorClient())) {
            mh.setConnectorClient(a.connectorClient());
        } else {
            mh.setConnectorClient(callingContext.getOriginator());
        }

        mh.setParentId(PARENT_ID.get());

        mh = messageHistoryService.save(mh);

        PARENT_ID.set(mh.getId());

        return mh;
    }

}
