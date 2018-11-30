package com.cts.fasttack.admin.web.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenReasonDto;
import com.cts.fasttack.admin.web.data.dto.TokenUpdateDto;
import com.cts.fasttack.admin.web.data.dto.TokensUpdateDto;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokensUpdateToJmsMessageConverter extends AbstractConverter<TokensUpdateDto, JmsUpdateTokenDto>{

    private Logger logger = LogManager.getLogger(TokensUpdateToJmsMessageConverter.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;

    @Override
    protected JmsUpdateTokenDto generateTarget() {
        return new JmsUpdateTokenDto();
    }

    @Override
    protected void lightConvert(TokensUpdateDto source, JmsUpdateTokenDto target) {
        TokenUpdateDto tokenInfoId = source.getTokens().get(0);
        UserAuthoritiesDto user = userService.getCurrentUser();

        target.setUsername(user.getName());
        target.setUserId(user.getUsername());
        target.setComment(source.getComment());


        TokenReasonDto reason = null;
        try {
            reason = tokenReasonRestClient.get(Long.valueOf(source.getTokenReason()));
            target.setTokenReason(reason.getReason());
        } catch (ServiceException e) {
            target.setTokenReason(null);
            logger.warn("Token Reason not found with ID - " + source.getTokenReason());
        }

        target.setNewPan(source.getNewPan());
        target.setNewExpDate(source.getNewExpDate());
        target.setPanInternalGuid(tokenInfoId.getPanInternalGuid());
        target.setPanInternalId(tokenInfoId.getPanInternalId());
        target.setUpdateWalletProviderIndicator(source.isUpdateWalletProviderIndicator() ? "1" : "0");

        target.setSkipOldPan(true);
    }
}
