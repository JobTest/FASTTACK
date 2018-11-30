package com.cts.fasttack.sms.server.service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.cts.fasttack.sms.server.config.SmsConnectionConfiguration;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsmpp.bean.BindType;
import org.jsmpp.bean.ESMClass;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.RegisteredDelivery;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.extra.SessionState;
import org.jsmpp.session.BindParameter;
import org.jsmpp.session.SMPPSession;
import org.jsmpp.util.AbsoluteTimeFormatter;
import org.jsmpp.util.TimeFormatter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;
import com.cts.fasttack.sms.server.dto.SmsMessageDto;
import com.cts.fasttack.sms.server.listener.SmsMessageReceiverListener;
import com.cts.fasttack.sms.server.listener.SmsMessageSenderListener;
import com.cts.fasttack.sms.server.util.GeneralDataCodingWithText;
import com.cts.fasttack.sms.server.util.SmsMessageDataCodingResolver;

/**
 * Service for sending SMS messages
 * @author Anton Leliuk
 */
@Service
public class SmsMessageServiceClientImpl implements SmsMessageServiceClient, SmartLifecycle, InitializingBean {

    private final Logger log = LogManager.getLogger(getClass());

    private static TimeFormatter timeFormatter = new AbsoluteTimeFormatter();

    @Autowired
    private SmsConnectionConfiguration configuration;

    @Autowired
    private SmsMessageService smsMessageService;

    @Autowired
    private SmsMessageTemplateService smsMessageTemplateService;

    @Autowired
    private SmsMessageReceiverListener smsMessageReceiverListener;

    private boolean running = false;

    private SMPPSession session = null;

    private BindParameter bindParameter = null;

    private Timer reconnectTimer = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        bindParameter = new BindParameter(BindType.BIND_TRX, configuration.getSystemId(), configuration.getPassword(), configuration.getSystemType(), TypeOfNumber.UNKNOWN, NumberingPlanIndicator.UNKNOWN, null);
    }

    @Override
    public void send(final String type, final String phone, final Map<String, Object> parametersTemplate, final SmsMessageSenderListener listener) throws ServiceException {
        if(running){
            RegisteredDelivery registeredDelivery = new RegisteredDelivery();
            registeredDelivery.setSMSCDeliveryReceipt(configuration.getDeliveryReceipt());
            SmsMessageDto smsMessageDto = new SmsMessageDto();
            smsMessageDto.setType(type);
            smsMessageDto.setPhone(phone);
            smsMessageDto.setDateCreate(new Date());
            try {
                String messageText = smsMessageTemplateService.evaluateTemplate(type, parametersTemplate);
                smsMessageDto.setText(messageText);
                GeneralDataCodingWithText dataCoding = SmsMessageDataCodingResolver.resolve(messageText);
                String messageId = getSession().submitShortMessage(
                        configuration.getSystemType(),
                        configuration.getSourceTypeOfNumber(),
                        configuration.getSourceNumberingPlanIndicator(),
                        configuration.getFrom(),
                        configuration.getDestinationTypeOfNumber(),
                        configuration.getDestinationNumberingPlanIndicator(),
                        phone,
                        new ESMClass(),
                        (byte) 0,
                        (byte) 0,
                        timeFormatter.format(new Date()),
                        null,
                        registeredDelivery,
                        (byte) 0,
                        dataCoding,
                        (byte) 0,
                        dataCoding.getText());
                if (log.isInfoEnabled()) {
                    log.info("Sent SMS on phone number '" + phone + "'");
                }
                smsMessageDto.setMessageId(messageId);
                smsMessageDto.setStatus(SmsMessageStatus.SENDING);
            } catch (Exception e) {
                log.error("Error sending SMS", e);
                smsMessageDto.setStatus(SmsMessageStatus.ERROR);
                smsMessageDto.setDescription(ExceptionUtils.getMessage(e));
                throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
            } finally {
                smsMessageDto.setDateSend(new Date());
                try {
                    smsMessageService.save(smsMessageDto);
                } catch (Exception e) {
                    log.error("Unexpected error sending sms!", e);
                    throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                }
                if(!smsMessageDto.getStatus().isError()){
                    listener.onMessageSuccessSend(smsMessageDto);
                }
            }
        } else {
            log.error("SMS message service is not running");
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }
    }

    @Override
    public void send(String type, String phone, Map<String, Object> parametersTemplate) throws ServiceException {
        this.send(type, phone, parametersTemplate, SmsMessageSenderListener.NoOpSmsMessageSenderListener.INSTANCE);
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }

    @Override
    public void start() {
        try {
            session = newSession();
            running = true;
        } catch (IOException e) {
            log.error("Error connecting to the SMS Gate. " + ExceptionUtils.getMessage(e));
            running = false;
        } finally {
            reconnectTimer = new Timer("JSMPP reconnect timer");
            reconnectTimer.scheduleAtFixedRate(new ReconnectSessionTimerTask(), configuration.getReconnectDelay(), configuration.getReconnectInterval());
        }
    }

    @Override
    public void stop() {
        if (session != null) {
            session.unbindAndClose();
        }
        reconnectTimer.cancel();
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }

    private SMPPSession getSession() throws IOException {
        if (session == null) {
            session = newSession();
        } else if (!session.getSessionState().isBound()) {
            throw new IOException("We have no valid session yet");
        }
        return session;
    }

    private SMPPSession newSession() throws IOException {
        SMPPSession newSession = new SMPPSession();
        if(configuration.getEnquireLink() != null && configuration.getEnquireLink() > 0){
            newSession.setEnquireLinkTimer(configuration.getEnquireLink());
        }
        if(configuration.getTransactionTimer() != null && configuration.getTransactionTimer() > 0){
            newSession.setTransactionTimer(configuration.getTransactionTimer());
        }
        newSession.setMessageReceiverListener(smsMessageReceiverListener);

        newSession.connectAndBind(configuration.getHost(), configuration.getPort(), bindParameter);

        return newSession;
    }

    /**
     * Timer for reconnect session
     */
    private class ReconnectSessionTimerTask extends TimerTask {

        @Override
        public void run() {
            if(session == null || session.getSessionState() == SessionState.CLOSED){
                try {
                    session = newSession();
                    running = true;
                } catch (IOException e) {
                    running = false;
                    session = null;
                }
            }
        }
    }
}
