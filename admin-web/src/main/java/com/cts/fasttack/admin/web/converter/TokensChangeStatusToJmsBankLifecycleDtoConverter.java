package com.cts.fasttack.admin.web.converter;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokenReasonDto;
import com.cts.fasttack.admin.web.data.dto.TokensChangeStatusDto;
import com.cts.fasttack.admin.web.rest.TokenInfoRestClient;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokensChangeStatusToJmsBankLifecycleDtoConverter extends AbstractConverter<TokensChangeStatusDto, JmsBankLifecycleTokenDto> {

    private Logger logger = LogManager.getLogger(TokensChangeStatusToJmsBankLifecycleDtoConverter.class);

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenInfoRestClient tokenInfoRestClient;

    @Override
    protected JmsBankLifecycleTokenDto generateTarget() {
        return new JmsBankLifecycleTokenDto();
    }

    @Override
    protected void lightConvert(TokensChangeStatusDto source, JmsBankLifecycleTokenDto target) {
        TokenChangeStatusDto token = source.getTokens().get(0);
        target.setPanInternalId(token.getPanInternalId());
        target.setPanInternalGUID(token.getPanInternalGuid());

        target.setRequestId(UUID.randomUUID().toString());
        target.setAction(source.getTokenEventStatus().name());
        target.setCommentText(source.getComment());
        target.setIps(token.getIps());

        TokenReasonDto reason = null;
        try {
            reason = tokenReasonRestClient.get(Long.valueOf(source.getTokenReason()));
            target.setReasonCode("M".equals(token.getIps()) ? reason.getMdesReason() : reason.getReason());
        } catch (ServiceException e) {
            target.setReasonCode(null);
            logger.warn("Token Reason not found with ID - " + source.getTokenReason() + ". Token Event Status: " + source.getTokenEventStatus());
        }


        UserAuthoritiesDto user = userService.getCurrentUser();
        target.setUserId(user.getUsername());
        target.setUserName(user.getName());

        if(!(source.getTokenEventStatus().isActive() || source.getTokenEventStatus().isResume())) {
            try {
                target.setPaymentAppInstanceId(tokenInfoRestClient.get(token.getTokenRefId(), token.getTokenRequestorId()).getClientWalletAccountId());
            } catch (ServiceException e) {
                target.setPaymentAppInstanceId(null);
                logger.warn("Token Info not found with tokenRefID - " + token.getTokenRefId() + " and tokenRequestorID - " + token.getTokenRequestorId() + ". Token Event Status: " + source.getTokenEventStatus());
            }
        }
    }
}
