package com.cts.fasttack.core.scheduler;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.TokenInfoToDtoConverter;
import com.cts.fasttack.core.data.TokenParameters;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.util.TokenHelper;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.jms.dto.SendNotificationToCustomerJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Scheduler to periodically notify tokens by status
 */
@ConditionalOnExpression("'${spring.core.scheduled.token.notify-status:false}' != 'false'")
@Component
public class TokenDeactivateNotificationScheduler {

    private Logger logger = LogManager.getLogger(TokenDeactivateNotificationScheduler.class);

    public static final String TOKEN_ACTIVATION_REMINDER = "TOKEN_ACTIVATION_REMINDER";

    private final static long DELAY_AFTER_SEND_JMS = 500L;

    @Autowired
    private TokenParameters tokenParameters;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenHelper tokenHelper;

    @Scheduled(cron = "${spring.core.scheduled.token.notify-status}")
    public List<TokenInfoDto> doTokenNotify() throws ServiceException {
        List<TokenInfoDto> tokenDtos = listByTokenStatus(Arrays.asList(TokenStatus.I));

        logger.info("Found notify Tokens = {};", tokenDtos.size());

        for (TokenInfoDto token: tokenDtos) {
            HeadersJmsMessage jmsMessage = new SendNotificationToCustomerJmsMessage()
                    .jmsSendNotificationToCustomerRequestDto(tokenHelper.createJmsSendNotificationToCustomerRequestDto(token, TOKEN_ACTIVATION_REMINDER))
                    .originator(tokenParameters.getOriginator());
            integrationBus.inOut(() -> Constants.ORIGINATOR, "tokenDeactivateNotification", jmsMessage, JmsSendNotificationToCustomerResponseDto.class);
            try { Thread.sleep(DELAY_AFTER_SEND_JMS); } catch (InterruptedException e) { }
        }
        return tokenDtos;
    }

    private List<TokenInfoDto> listByTokenStatus(List<TokenStatus> tokenStatuses) throws ServiceException {
        return tokenInfoService.listByTokenStatus(tokenStatuses, true).stream()
                .filter(tokenInfo -> tokenHelper.isSendOnlyForRequestors(tokenInfo.getId().getTokenRequestorId()))
                .filter(tokenInfo -> tokenHelper.isWindowReminderPeriod(tokenInfo, tokenHelper.getDiffWindowReminderPeriod(tokenInfo.getTokenStatusUpdate())))
                .map(tokenInfo -> new TokenInfoToDtoConverter().convert(tokenInfo)).collect(Collectors.toList());
    }
}
