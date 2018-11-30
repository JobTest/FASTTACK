package com.cts.fasttack.jms.converter;

import com.cts.fasttack.common.core.converter.RecommendationReasonsConverter;
import com.cts.fasttack.common.core.util.TokenizationPathUtil;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningDto;
import com.cts.fasttack.jms.dto.JmsCvmDto;

/**
 * @author a.lipavets
 */
@Component
public class JmsCvmDtoConfirmProvisioningConverter extends AbstractConverter<JmsCvmDto, JmsConfirmProvisioningDto> {
    @Override
    protected JmsConfirmProvisioningDto generateTarget() {
        return new JmsConfirmProvisioningDto();
    }

    @Override
    protected void lightConvert(JmsCvmDto source, JmsConfirmProvisioningDto target) {

        target.setRequestId(source.getRequestId());
        target.setConversationId(source.getConversationId());
        target.setPan(source.getPan());
        target.setExpiryMonth(source.getExpiryMonth());
        target.setExpiryYear(source.getExpiryYear());
        target.setLang(source.getLang());
        target.setPanSource(source.getPanSource());
        target.setIps(source.getIps());
        target.setPaymentAppInstId(source.getPaymentAppInstId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        if (source.getWpReasonCodes() != null) target.setTokenizationPath(TokenizationPathUtil.identify(new RecommendationReasonsConverter().convertToReasons(source.getWpReasonCodes())).getValues());
        target.setDeviceType(source.getDeviceType());
        target.setDeviceName(source.getDeviceName());
    }
}
