package com.cts.fasttack.visa.vnts.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsSendPasscodeDto;
import com.cts.fasttack.visa.vnts.server.dict.DeviceType;
import com.cts.fasttack.visa.vnts.server.dto.SendPasscodeRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class SendPasscodeRequestToJmsDtoConverter extends AbstractConverter<SendPasscodeRequestDto, JmsSendPasscodeDto> {

    @Override
    protected JmsSendPasscodeDto generateTarget() {
        return new JmsSendPasscodeDto();
    }

    @Override
    protected void lightConvert(SendPasscodeRequestDto source, JmsSendPasscodeDto target) {
    	if (source.getDeviceInfo() != null) {
            target.setDeviceName(source.getDeviceInfo().getDeviceName());
            target.setDeviceNumber(source.getDeviceInfo().getDeviceNumber());
            target.setDeviceType(source.getDeviceInfo().getDeviceType());
            target.setSecureElementID(source.getDeviceInfo().getSecureElementID());
            if (isInteger(source.getDeviceInfo().getDeviceType())) {
                target.setDeviceType( DeviceType.valueOfType(Integer.parseInt(source.getDeviceInfo().getDeviceType())).name() );
            }
    	}

        target.setEncryptedData(source.getCardholderInfo().getEncryptedData());
        target.setEncryptionKeyIndex(source.getCardholderInfo().getEncryptionKeyIndex());
        target.setLifeCycleTraceID(source.getLifeCycleTraceID());
        target.setOtpCode(source.getOtpCode());
        target.setOtpCodeExp(source.getOtpCodeExp());
        target.setOtpMethodIdentifier(source.getOtpMethodIdentifier());
        target.setPanReferenceID(source.getPanReferenceID());
        target.setToken(source.getToken());
        target.setTokenReferenceID(source.getTokenReferenceID());
        target.setTokenRequestorID(source.getWalletProviderMsgTracing().getTokenRequestorID());
        target.setVersion(source.getCardholderInfo().getVersion());
        target.setWalletAccountID(source.getWalletAccountID());
        target.setWpConversationId(source.getWalletProviderMsgTracing().getWpConversationId());
        target.setWpRequestId(source.getWalletProviderMsgTracing().getWpRequestId());
    }

    private boolean isInteger(Object obj) {
        if (obj==null) {
            return false;
        }
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
