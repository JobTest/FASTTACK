package com.cts.fasttack.bank.server.converter;

import com.cts.fasttack.bank.server.dto.TokenLifecycleRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenLifecycleRequestToJmsConverter extends AbstractConverter<TokenLifecycleRequestDto, JmsBankLifecycleTokenDto>  {

    @Override
    protected JmsBankLifecycleTokenDto generateTarget() {
        return new JmsBankLifecycleTokenDto();
    }

    @Override
    protected void lightConvert(TokenLifecycleRequestDto source, JmsBankLifecycleTokenDto target) {
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setPanInternalId(source.getPanInternalId());
        target.setRequestId(source.getRequestId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setAction(source.getAction());
        target.setCommentText(source.getCommentText());
        target.setReasonCode(source.getReasonCode());
        target.setUserId(source.getAuditInfo().getUserId());
        target.setUserName(source.getAuditInfo().getUserName());
        target.setPan(source.getPan());
        target.setIps(source.getIps());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
    }
}
