package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;
import com.cts.fasttack.jms.dto.JmsTokenNotificationDto;
import com.cts.fasttack.jms.dto.JmsVisaEncryptedDataDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationDtoToJmsDtoConverter {

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    public JmsTokenNotificationDto convert(TokenNotificationRequestDto source,
                                           String tokenReferenceID,
                                           String tokenRequestorID,
                                           EventType eventType,
                                           String eventID) throws ServiceException {
        JmsTokenNotificationDto target = new JmsTokenNotificationDto();
        target.setEventID(eventID);
        target.setEventType(eventType.name());
        target.setTokenReferenceID(tokenReferenceID);
        target.setTokenRequestorID(tokenRequestorID);
        target.setMessageReasonCode(source.getMessageReasonCode());
        target.setMessageReason(source.getMessageReason());
        target.setDateTimeOfEvent(DateFormatUtil.stringToDate(DateFormatEnum.VTS_DATETIMEOFEVENT_FORMAT, source.getDateTimeOfEvent()));
        target.setDeviceID(source.getDeviceID());
        target.setPanReferenceID(source.getPanReferenceID());

        String decryptedJson = visaCryptoRestClient.decrypt(source.getEncryptedData()).getText();
        try {
            target.setEncryptedData(JsonUtil.fromJson(decryptedJson, JmsVisaEncryptedDataDto.class));
        } catch (Exception ex) {
        	throw new ServiceException(StandardErrorCodes.INVALID_JSON, "encryptedData");
        }

        return target;

    }
}
