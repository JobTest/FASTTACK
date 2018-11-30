package com.cts.fasttack.jms.processor;

import com.cts.fasttack.common.core.exception.CryptographyException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.SimpleErrorCode;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.rest.JmsCryptoRestClient;
import com.cts.fasttack.jms.data.JmsMessage;
import com.cts.fasttack.jms.data.JmsResponseMessage;
import com.cts.fasttack.logging.interceptor.MessageHistoryInterceptor;
import com.cts.fasttack.logging.service.CallingContext;

/**
 * @author Anton Leliuk
 */
public abstract class AbstractCamelProcessor<IN extends JmsMessage, OUT> implements Processor {

    protected final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private JmsCryptoRestClient jmsCryptoRestClient;

    protected void execute(Exchange exchange, Class<IN> requestClass, ProcessorCallback<IN, OUT> callback) throws ServiceException {
        JmsResponseMessage<OUT> response = new JmsResponseMessage<>();
        String encryptedJson = String.valueOf(exchange.getIn().getBody());

        log.info("Received message from JMS " + exchange.getFromEndpoint() + ": " + encryptedJson);

        String decryptedJson = jmsCryptoRestClient.decrypt(encryptedJson).getText();

        IN request = JsonUtil.fromJson(decryptedJson, requestClass);

        setContextParameters(request);

        try{
            OUT out = callback.execute(request);
            response.setRawMessage(out);
        } catch (ServiceException | CryptographyException e ) {
            response.setHttpStatus(e.getHttpStatus());
            response.setErrorCode(new SimpleErrorCode(e.getErrorCode().name()));
            response.setParams(e.getParams());
        } catch (Exception e){
            log.error(ExceptionUtils.getMessage(e), e);
            response.setErrorCode(new SimpleErrorCode(StandardErrorCodes.INTERNAL_SERVICE_FAILURE.name()));
        }
        decryptedJson = JsonUtil.toJson(response);
        encryptedJson = jmsCryptoRestClient.encrypt(decryptedJson).getText();
        exchange.getOut().setBody(encryptedJson);
    }

    private void setContextParameters(IN request) {
        if (request.getOriginator() != null) {
            callingContext.setContext(request.getOriginator());
        }
        if (request.getMessageHistoryId() != null) {
            MessageHistoryInterceptor.PARENT_ID.set(request.getMessageHistoryId());
        }
    }

    public interface ProcessorCallback<IN, OUT> {

        OUT execute(IN request) throws ServiceException;
    }
}
