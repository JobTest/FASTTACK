package com.cts.fasttack.sms.server.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsmpp.bean.AlertNotification;
import org.jsmpp.bean.DataSm;
import org.jsmpp.bean.DeliverSm;
import org.jsmpp.bean.DeliveryReceipt;
import org.jsmpp.bean.MessageType;
import org.jsmpp.extra.ProcessRequestException;
import org.jsmpp.session.DataSmResult;
import org.jsmpp.session.MessageReceiverListener;
import org.jsmpp.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;
import com.cts.fasttack.sms.server.service.SmsMessageService;

/**
 * SMS message listener for update message status if we have delivery receipt
 * @author Anton Leliuk
 */
@Component
public class SmsMessageReceiverListener implements MessageReceiverListener {

    private final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private SmsMessageService smsMessageService;

    @Override
    public void onAcceptDeliverSm(DeliverSm deliverSm) throws ProcessRequestException {
        if(MessageType.SMSC_DEL_RECEIPT.containedIn(deliverSm.getEsmClass())){
            try {
                DeliveryReceipt deliveryReceipt = deliverSm.getShortMessageAsDeliveryReceipt();
                String messageId = deliveryReceipt.getId();

                int updateCount = smsMessageService.updateStatus(messageId, SmsMessageStatus.RECEIVED);
                if(updateCount == 0){
                    log.warn("Not found SMS message by messageId = " + messageId);
                }
            } catch (Exception e) {
                log.error("Unexpected error on accept deliver sm",e);
            }
        }
    }

    @Override
    public void onAcceptAlertNotification(AlertNotification alertNotification) {}

    @Override
    public DataSmResult onAcceptDataSm(DataSm dataSm, Session source) throws ProcessRequestException {
        return null;
    }
}
