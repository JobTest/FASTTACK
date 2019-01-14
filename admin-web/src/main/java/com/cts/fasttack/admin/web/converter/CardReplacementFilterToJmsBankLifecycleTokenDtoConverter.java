package com.cts.fasttack.admin.web.converter;

import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;
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
public class CardReplacementFilterToJmsBankLifecycleTokenDtoConverter extends AbstractConverter<CardReplacementFilter, JmsBankLifecycleTokenDto>{

    private Logger logger = LogManager.getLogger(CardReplacementFilterToJmsBankLifecycleTokenDtoConverter.class);

    public static final String LIFECYCLE_TOKEN_ACTION = "UPDATE_PAN";

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;

    @Override
    protected JmsBankLifecycleTokenDto generateTarget() {
        return new JmsBankLifecycleTokenDto();
    }

    @Override
    protected void lightConvert(CardReplacementFilter source, JmsBankLifecycleTokenDto target) {

        try {
            JmsGetCardInfoShortResponseDto getCardInfoShort = getCardInfoShort(source.getOldPan());

            target.setPanInternalId( getCardInfoShort.getCardID() );
            target.setPanInternalGUID( getCardInfoShort.getCardGUID() );
            target.setCommentText( source.getComment() );
            target.setReasonCode( getReason(source.getTokenReason()) );
            target.setUserId( getCurrentUser().getUsername() );
            target.setUserName( getCurrentUser().getName() );
            target.setPan( StringUtils.isNotBlank(source.getNewPan()) ? source.getNewPan() : source.getOldPan() );
            target.setIps( "V" );
            target.setAction(LIFECYCLE_TOKEN_ACTION);
        } catch (ServiceException ex) {
            logger.error("Timeout or no response from server. Error code: '{}'.", ex.getErrorCode());
        }
    }

    private String getReason(String tokenReason) throws ServiceException {
        return StringUtils.isNotBlank(tokenReason)
                ? tokenReasonRestClient.get(Long.valueOf(tokenReason)).getReason()
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
