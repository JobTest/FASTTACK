package com.cts.fasttack.bank.client.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioning;
import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsConfirmProvisioningDtoToDomainConverter extends AbstractConverter<JmsConfirmProvisioningDto, ConfirmProvisioning> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Value("${spring.client.ws.confirmProvisioning.usePaymentAppInstId}")
    private boolean usePaymentAppInstId;

    @Value("${spring.client.ws.confirmProvisioning.useTokenRequestorId}")
    private boolean useTokenRequestorId;

    @Value("${spring.client.ws.confirmProvisioning.useTokenRefId}")
    private boolean useTokenRefId;

    @Value("${spring.client.ws.confirmProvisioning.useDeviceName:false}")
    private Boolean useDeviceName;

    @Override
    protected ConfirmProvisioning generateTarget() {
        return OBJECT_FACTORY.createConfirmProvisioning();
    }

    @Override
    protected void lightConvert(JmsConfirmProvisioningDto source, ConfirmProvisioning target) {
        target.setRequestId(source.getRequestId());
        target.setConversationId(source.getConversationId());
        target.setLang(source.getLang());
        target.setPanSource(source.getPanSource());
        target.setPan(source.getPan());
        target.setExpiryYear(source.getExpiryYear());
        target.setExpiryMonth(source.getExpiryMonth());
        target.setIps(source.getIps());
        target.setTokenizationPath(source.getTokenizationPath());
        if(useTokenRefId) {
            target.setTokenRefId(source.getTokenRefId());
        }
        if(useTokenRequestorId) {
            target.setTokenRequestorId(source.getTokenRequestorId());
        }
        if(usePaymentAppInstId) {
            target.setPaymentAppInstId(source.getPaymentAppInstId());
        }
        if(useDeviceName) {
            target.setDeviceName(source.getDeviceName());
        }
    }
}
