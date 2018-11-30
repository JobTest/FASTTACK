package com.cts.fasttack.visa.vtis.server.converter;


import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.VisaEncryptedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationRequestToDtoConverter {

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    public TokenNotificationDto convert(TokenNotificationRequestDto source, String tokenRequestorID, String tokenReferenceID, String eventType, String eventID) throws ServiceException {
        TokenNotificationDto target = new TokenNotificationDto();
        target.setMessageReason(source.getMessageReason());
        target.setDateTimeOfEvent(DateFormatUtil.stringToDate(DateFormatEnum.VTS_DATETIMEOFEVENT_FORMAT, source.getDateTimeOfEvent()));
        target.setDeviceID(source.getDeviceID());
        target.setPanReferenceID(source.getPanReferenceID());
        target.setMessageReasonCode(source.getMessageReasonCode());
        target.setTokenRequestorID(tokenRequestorID);
        target.setTokenReferenceID(tokenReferenceID);
        target.setEventType(eventType);
        target.setEventID(eventID);
        target.setEncryptedData(JsonUtil.fromJson(visaCryptoRestClient.decrypt(source.getEncryptedData()).getText(), VisaEncryptedData.class));
        return target;
    }
}
