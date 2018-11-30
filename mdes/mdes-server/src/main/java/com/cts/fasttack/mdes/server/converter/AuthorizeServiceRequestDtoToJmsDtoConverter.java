package com.cts.fasttack.mdes.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceDto;
import com.cts.fasttack.mdes.server.dto.AuthorizeServiceRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class AuthorizeServiceRequestDtoToJmsDtoConverter extends AbstractConverter<AuthorizeServiceRequestDto, JmsAuthorizeServiceDto> {
    @Override
    protected JmsAuthorizeServiceDto generateTarget() {
        return new JmsAuthorizeServiceDto();
    }

    @Override
    protected void lightConvert(AuthorizeServiceRequestDto source, JmsAuthorizeServiceDto target) {
        target.setAccountIdHash(source.getAccountIdHash());
        if (source.getWalletProviderDecisioningInfo() != null) {
            target.setAccountScore(source.getWalletProviderDecisioningInfo().getAccountScore());
            target.setDeviceScore(source.getWalletProviderDecisioningInfo().getDeviceScore());
            target.setPhoneNumberScore(source.getWalletProviderDecisioningInfo().getPhoneNumberScore());
            target.setRecommendationReasons(source.getWalletProviderDecisioningInfo().getRecommendationReasons());
            target.setRecommendationStandardVersion(source.getWalletProviderDecisioningInfo().getRecommendationStandardVersion());
            target.setRecommendedDecision(source.getWalletProviderDecisioningInfo().getRecommendedDecision());
        }
        target.setActiveTokenCount(source.getActiveTokenCount());
        target.setCorrelationId(source.getCorrelationId());
        target.setEncryptedData(source.getCardInfo().getEncryptedData());
        target.setEncryptedKey(source.getCardInfo().getEncryptedKey());
        target.setIv(source.getCardInfo().getIv());
        target.setMobileNumberSuffix(source.getMobileNumberSuffix());
        target.setOaepHashingAlgorithm(source.getCardInfo().getOaepHashingAlgorithm());
        target.setPanUniqueReference(source.getCardInfo().getPanUniqueReference());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setPublicKeyFingerprint(source.getCardInfo().getPublicKeyFingerprint());
        target.setServices(source.getServices());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenType(source.getTokenType());
        target.setWalletId(source.getWalletId());
        target.setRequestId(source.getRequestId());
        if (source.getDeviceInfo() != null) {
            target.setDeviceName(source.getDeviceInfo().getDeviceName());
            target.setFormFactor(source.getDeviceInfo().getFormFactor());
            target.setImei(source.getDeviceInfo().getImei());
            target.setIsoDeviceType(source.getDeviceInfo().getIsoDeviceType());
            target.setMsisdn(source.getDeviceInfo().getMsisdn());
            target.setOsName(source.getDeviceInfo().getOsName());
            target.setOsVersion(source.getDeviceInfo().getOsVersion());
            target.setPaymentTypes(source.getDeviceInfo().getPaymentTypes());
            target.setSerialNumber(source.getDeviceInfo().getSerialNumber());
            target.setStorageTechnology(source.getDeviceInfo().getStorageTechnology());
        }
    }
}
