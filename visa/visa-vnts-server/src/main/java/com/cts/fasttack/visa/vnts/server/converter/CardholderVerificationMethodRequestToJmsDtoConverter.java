package com.cts.fasttack.visa.vnts.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import com.cts.fasttack.visa.vnts.server.dict.DeviceType;
import com.cts.fasttack.visa.vnts.server.dto.CardholderVerificationMethodsRequestDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodRequestToJmsDtoConverter extends AbstractConverter<CardholderVerificationMethodsRequestDto, JmsCardholderVerificationMethodsDto> {

    @Override
    protected JmsCardholderVerificationMethodsDto generateTarget() {
        return new JmsCardholderVerificationMethodsDto();
    }

    @Override
    protected void lightConvert(CardholderVerificationMethodsRequestDto source, JmsCardholderVerificationMethodsDto target) {
    	if (source.getDeviceInfo() != null) {
            target.setDeviceName(source.getDeviceInfo().getDeviceName());
            target.setDeviceNumber(source.getDeviceInfo().getDeviceNumber());
            target.setSecureElementID(source.getDeviceInfo().getSecureElementID());
            if (isInteger(source.getDeviceInfo().getDeviceType())) {
                target.setDeviceType( DeviceType.valueOfType(Integer.parseInt(source.getDeviceInfo().getDeviceType())).name() );
            }
            target.setDeviceName(source.getDeviceInfo().getDeviceName());
    	}

        target.setEncryptedData(source.getCardholderInfo().getEncryptedData());
        target.setEncryptionKeyIndex(source.getCardholderInfo().getEncryptionKeyIndex());
        target.setVersion(source.getCardholderInfo().getVersion());

        target.setLifeCycleTraceID(source.getLifeCycleTraceID());
        target.setPanReferenceID(source.getPanReferenceID());
        target.setToken(source.getToken());
        target.setTokenReferenceID(source.getTokenReferenceID());
        target.setTokenRequestorID(source.getWalletProviderMsgTracing().getTokenRequestorID());
        target.setWalletAccountID(source.getWalletAccountID());
        target.setWpConversationId(UUID.randomUUID().toString());
        target.setWpRequestId(source.getWalletProviderMsgTracing().getWpRequestId());

        target.setIssuerSpecialConditionCodes(source.getIssuerSpecialConditionCodes());
        target.setOtpReason(source.getOtpReason());
        target.setOtpMaxReached(source.isOtpMaxReached());

        if(source.getRiskInformation() != null) {
            target.setWpReasonCodes(source.getRiskInformation().getWpReasonCodes());
            target.setPanSource(source.getRiskInformation().getPanSource());
            target.setWpDeviceScore(source.getRiskInformation().getWpDeviceScore());
            target.setWpAccountScore(source.getRiskInformation().getWpAccountScore());
            target.setRiskAssessmentScore(source.getRiskInformation().getRiskAssessmentScore());
            target.setTokenProvisioningScore(source.getRiskInformation().getTokenProvisioningScore());
        }
    }

    private boolean isInteger(Object obj) {
        if(obj instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(obj.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }
}
