package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.logging.domain.dict.LogSeverity;
import com.cts.fasttack.logging.dto.ChangeLogMessage;
import com.cts.fasttack.logging.service.ChangeLogger;

/**
 * It works for methods marked with the annotation{@link ChangeLoggable}
 * and add record to CHANGELOG.
 */
@Component
public class ChangeLoggableInterceptor implements MethodInterceptor {

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @Autowired
    private ChangeLogger changeLogger;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(invocation.getThis());
        if (targetClass == null && invocation.getThis() != null) {
            targetClass = invocation.getThis().getClass();
        }
        Method method = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
        ChangeLoggable a = AnnotationUtils.getAnnotation(method, ChangeLoggable.class);

        try {
            Object result = invocation.proceed();
            log(a, method, targetClass, invocation.getArguments(), result, null, LogSeverity.INFO);
            return result;
        } catch (Throwable e) {
            String errorMessage = e.getClass().getSimpleName() + ": " + e.getMessage();
            log(a, method, targetClass, invocation.getArguments(), null, errorMessage, LogSeverity.ERROR);
            throw e;
        }
    }

    private void log(ChangeLoggable a, Method method, Class<?> targetClass, Object[] args, Object result, String message, LogSeverity severity) throws ServiceException {
        EvaluationContext evaluationContext = evaluator.createEvaluationContext(method, args, result, targetClass);
        String itemId = evaluator.evaluateExpression(a.itemId(), method, evaluationContext).toString();
        String[] fields = evaluator.fields(a.fields(), method, evaluationContext);
        ChangeLogMessage changeLogMessage = new ChangeLogMessage(a.itemType(), itemId, message).fields(fields);
        String action = StringUtils.isNotBlank(a.action()) ? a.action() : makeActionFromMethodName(method.getName());
        changeLogger.log(action, changeLogMessage, severity);
    }

    /**
     * Преобразовывает название метода в upper case: 'createMpa' -> 'CREATE_MPA'
     */
    String makeActionFromMethodName(String name) {
        // конвертируем строку типа 'aCamelString' в [a, Camel, String]
        String[] words = name.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
        StringBuilder result = new StringBuilder(name.length() + words.length);
        for (int i = 0; i < words.length; i++) {
            result.append(words[i].toUpperCase());
            if (i < words.length - 1) {
                result.append("_");
            }
        }
        return result.toString();
    }

}
