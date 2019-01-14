package com.cts.fasttack.admin.web.converter;

import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardReplacementFilterToJmsUpdateTokenDtoConverter extends AbstractConverter<CardReplacementFilter, JmsUpdateTokenDto>{

    private Logger logger = LogManager.getLogger(CardReplacementFilterToJmsUpdateTokenDtoConverter.class);

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;

    @Override
    protected JmsUpdateTokenDto generateTarget() {
        return new JmsUpdateTokenDto();
    }

    @Override
    protected void lightConvert(CardReplacementFilter source, JmsUpdateTokenDto target) {

        target.setSkipOldPan( true );
        target.setOldPan( source.getOldPan() );
        try {
            JmsGetCardInfoShortResponseDto getCardInfoShortOldPan = getCardInfoShort(source.getOldPan());

            target.setPanInternalId( getCardInfoShortOldPan.getCardID() );
            target.setPanInternalGuid( getCardInfoShortOldPan.getCardGUID() );
            target.setOldExpDate( source.getOldExpDate() );
            target.setNewExpDate( source.getNewExpDate() );
            target.setTokenReason( getReason(source.getTokenReason()) );
            target.setComment( source.getComment() );
            target.setUpdateWalletProviderIndicator( isUpdateWalletProviderIndicator(source.isUpdateWalletProviderIndicator()) );
            target.setUserId( getCurrentUser().getUsername() );
            target.setUsername( getCurrentUser().getName() );
            if (StringUtils.isNotBlank(source.getNewPan())) {
                JmsGetCardInfoShortResponseDto getCardInfoShortNewPan = getCardInfoShort(source.getNewPan());

                target.setNewPan( source.getNewPan());
                target.setNewPanInternalId( getCardInfoShortNewPan.getCardID() );
                target.setNewPanInternalGuid( getCardInfoShortNewPan.getCardGUID() );
            }
        } catch (ServiceException ex) {
            logger.error("Timeout or no response from server. Error code: '{}'.", ex.getErrorCode());
        }
    }

    private String isUpdateWalletProviderIndicator(Boolean updateWalletProviderIndicator) {
        boolean isUpdateWalletProviderIndicator = updateWalletProviderIndicator != null ? updateWalletProviderIndicator : false;
        return isUpdateWalletProviderIndicator
                ? "1"
                : "0";
    }

    private String getReason(String tokenReason) throws ServiceException {
        return StringUtils.isNotBlank(tokenReason)
                ? tokenReasonRestClient.get(Long.valueOf(tokenReason)).getMdesReason()
                : null;
    }

    private UserAuthoritiesDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    private JmsGetCardInfoShortResponseDto getCardInfoShort(String pan) throws ServiceException {
        JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
        jmsGetCardInfoShortMessageDto.setPan(pan);
        HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                .originator("CORE");

        return integrationBus.inOut(() -> "CORE", "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);
    }
}
