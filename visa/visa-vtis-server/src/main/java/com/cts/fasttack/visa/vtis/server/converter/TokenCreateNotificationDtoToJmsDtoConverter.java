package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsVisaEncryptedDataDto;
import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenCreateNotificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationDtoToJmsDtoConverter {

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    @Autowired
    private VisaDeviceInfoToJmsConverter visaDeviceInfoToJmsConverter;

    @Autowired
    private TermsAndConditionsToJmsDtoConverter termsAndConditionsToJmsDtoConverter;


    public JmsTokenCreateNotificationDto convert(TokenCreateNotificationRequestDto source,
                                                 String tokenReferenceID,
                                                 String tokenRequestorID,
                                                 EventType eventType,
                                                 String eventID) throws ServiceException {
        JmsTokenCreateNotificationDto target = new JmsTokenCreateNotificationDto();
        target.setMessageReason(source.getMessageReason());
        target.setMessageReasonCode(source.getMessageReasonCode());
        target.setDateTimeOfEvent(DateFormatUtil.stringToDate(DateFormatEnum.VTS_DATETIMEOFEVENT_FORMAT, source.getDateTimeOfEvent()));
        target.setPanReferenceID(source.getPanReferenceID());
        target.setWalletAccountEmailAddressHash(source.getWalletAccountEmailAddressHash());
        target.setClientWalletAccountID(source.getClientWalletAccountID());
        target.setVisaTokenScore(source.getVisaTokenScore());
        target.setVisaTokenDecisioning(source.getVisaTokenDecisioning());
        target.setPanSource(source.getPanSource());
        target.setAddressVerificationResultCode(source.getAddressVerificationResultCode());
        target.setCvv2ResultsCode(source.getCvv2ResultsCode());
        target.setConsumerEntryMode(source.getConsumerEntryMode());
        target.setLocale(source.getLocale());
        if (source.getDeviceInfo() != null) {
            target.setDeviceInfo(visaDeviceInfoToJmsConverter.convert(source.getDeviceInfo()));
        }
        if (source.getTermsAndConditions() != null) {
            target.setTermsAndConditions(termsAndConditionsToJmsDtoConverter.convert(source.getTermsAndConditions()));
        }
        target.setTokenReferenceID(tokenReferenceID);
        target.setTokenRequestorID(tokenRequestorID);
        target.setEventType(eventType.name());
        target.setEventID(eventID);

        String decryptedJson = visaCryptoRestClient.decrypt(source.getEncryptedData()).getText();
        try {
            target.setEncryptedData(JsonUtil.fromJson(decryptedJson, JmsVisaEncryptedDataDto.class));
        } catch (Exception ex) {
        	throw new ServiceException(StandardErrorCodes.INVALID_JSON, "encryptedData");
        }

        return target;
    }
}
