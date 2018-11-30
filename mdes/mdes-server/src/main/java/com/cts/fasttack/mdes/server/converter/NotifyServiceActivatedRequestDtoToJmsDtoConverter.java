package com.cts.fasttack.mdes.server.converter;

import java.util.Date;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import com.cts.fasttack.mdes.server.dict.TokenEventType;
import com.cts.fasttack.mdes.server.dto.NotifyServiceActivatedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyServiceActivatedRequestDtoToJmsDtoConverter extends AbstractConverter<NotifyServiceActivatedRequestDto, JmsNotifyServiceDto> {

    @Autowired
    private DeviceInfoToJmsDeviceInfoDtoConverter deviceInfoToJmsDeviceInfoDtoConverter;

    @Override
    protected JmsNotifyServiceDto generateTarget() {
        return new JmsNotifyServiceDto();
    }

    @Override
    protected void lightConvert(NotifyServiceActivatedRequestDto source, JmsNotifyServiceDto target) {
        target.setRequestId(source.getRequestId());
        target.setAccountPanSuffix(source.getAccountPanSuffix());
        target.setConsumerLanguage(source.getConsumerLanguage());
        target.setCorrelationId(source.getCorrelationId());
        target.setDecision(source.getDecision());
        target.setDecisionMadeBy(source.getDecisionMadeBy());

        target.setEncryptedData(source.getCardAndToken​().getEncryptedData());
        target.setEncryptedKey(source.getCardAndToken​().getEncryptedKey());
        target.setIv(source.getCardAndToken​().getIv());
        target.setNumberOfActivationAttempts(source.getNumberOfActivationAttempts());
        target.setNumberOfActiveTokens(source.getNumberOfActiveTokens());
        target.setOaepHashingAlgorithm(source.getCardAndToken​().getOaepHashingAlgorithm());
        target.setPanUniqueReference(source.getCardAndToken​().getPanUniqueReference());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setProductConfigurationId(source.getProductConfigurationId());
        target.setPublicKeyFingerprint(source.getCardAndToken​().getPublicKeyFingerprint());
        target.setSecureElementId(source.getSecureElementId());
        target.setServiceRequestDateTime(source.getServiceRequestDateTime());
        target.setServices(source.getServices());
        target.setTermsAndConditionsAcceptedTimestamp(source.getTermsAndConditionsAcceptedTimestamp());
        target.setTermsAndConditionsAssetId(source.getTermsAndConditionsAssetId());
        target.setTokenActivatedDateTime(source.getTokenActivatedDateTime());
        target.setTokenAssuranceLevel(source.getTokenAssuranceLevel());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenType(source.getTokenType());
        target.setTokenUniqueReference(source.getCardAndToken​().getTokenUniqueReference());
        target.setWalletId(source.getWalletId());
        target.setTokenEventType(TokenEventType.TOKEN_CREATED.name());
        target.setTokenEventDate(new Date());

        if (source.getDeviceInfo() != null) {
            target.setDeviceInfo(deviceInfoToJmsDeviceInfoDtoConverter.convert(source.getDeviceInfo()));
        }
    }
}
