package com.cts.fasttack.core.jms.processor;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.converter.JmsTokenResponseDtoToTokenInfoDtoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenParameters;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.util.TokenHelper;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import com.cts.fasttack.jms.dto.SendNotificationToCustomerJmsMessage;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenDeactivateNotificationProcessor extends AbstractCamelProcessor<SendNotificationToCustomerJmsMessage, JmsSendNotificationToCustomerResponseDto> {

    private Logger logger = LogManager.getLogger(TokenDeactivateNotificationProcessor.class);

    public static final String TOKEN_ACTIVATION_REMINDER = "TOKEN_ACTIVATION_REMINDER";

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenParameters tokenParameters;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private JmsTokenResponseDtoToTokenInfoDtoConverter jmsTokenResponseDtoToTokenInfoDtoConverter;

    @Autowired
    private TokenHelper tokenHelper;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, SendNotificationToCustomerJmsMessage.class, request -> {
                    JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto = request.getJmsSendNotificationToCustomerRequestDto();
                    TokenInfoDto token = tokenInfoService.get(new TokenInfoId(jmsSendNotificationToCustomerRequestDto.getTokenRefId(), jmsSendNotificationToCustomerRequestDto.getTokenRequestorId()));

                    try {
                        JmsTokenInfoResponseDto jmsTokenInfoResponseDto = tokenHelper.getCurrentTokenStatus(token);

                        if ("00".equals(jmsTokenInfoResponseDto.getActionCode())) {
                            for (JmsTokenResponseDto jmsTokenResponseDto : jmsTokenInfoResponseDto.getTokens()) {
                                if (!tokenHelper.equalsTokenInfoId(jmsSendNotificationToCustomerRequestDto, jmsTokenResponseDto)) {
                                    String alertLogData = "A response with an inappropriate token ref ID was received."
                                            + " Action code: '" + jmsTokenInfoResponseDto.getActionCode() + "'.";

                                    logger.error(alertLogData);
                                    tokenHelper.saveAlertLog(tokenParameters.getOriginator(), alertLogData, "TOKEN_INFO_NOT_EXISTS");
                                    return new JmsSendNotificationToCustomerResponseDto(null, "2", alertLogData);
                                }

                                TokenInfoDto      tokenResponseDto = jmsTokenResponseDtoToTokenInfoDtoConverter.convert(jmsTokenResponseDto);
                                TokenInfoDto matchTokenResponseDto = tokenInfoService.get(new TokenInfoId(jmsTokenResponseDto.getTokenUniqueReference(), jmsTokenResponseDto.getTokenRequestorId()));
                                final boolean    equalsTokenStatus = tokenHelper.equalsTokenStatus(token, tokenResponseDto, jmsTokenResponseDto.getCurrentStatusCode());
                                if (!equalsTokenStatus) {
                                    tokenHelper.tokenUpdateReminderPeriodAndSave(token, tokenResponseDto);
                                    tokenHelper.saveTokenHistory(jmsTokenResponseDto.getTokenRequestorId(), matchTokenResponseDto, jmsTokenInfoResponseDto.getActionCode(), "TOKEN_STATUS_UPDATED", null);

                                    String logData = "A token status has been updated. (RequestorId = '"
                                            + matchTokenResponseDto.getId().getTokenRequestorId() + "' ReferenceId = '"
                                            + matchTokenResponseDto.getId().getTokenRefId() + "')";
                                    logger.info(logData);
                                    return new JmsSendNotificationToCustomerResponseDto(null, "0", logData);
                                }

                                try {
                                    final String      diffWindowReminderPeriod = tokenHelper.getDiffWindowReminderPeriod(token.getTokenStatusUpdate());
                                    final boolean        isReminderPeriodToken = tokenHelper.isReminderPeriodToken(token, diffWindowReminderPeriod, equalsTokenStatus);
                                    final boolean isApproveReminderPeriodToken = tokenHelper.isApproveReminderPeriodToken(token, diffWindowReminderPeriod);
                                    if (isReminderPeriodToken && isApproveReminderPeriodToken) {
                                        if ("0".equals(sendNotifyTokenNotActivate(matchTokenResponseDto).getCode())) {
                                            tokenUpdateReminderPeriodAndSave(matchTokenResponseDto, diffWindowReminderPeriod);
                                            tokenHelper.saveTokenHistory(jmsTokenResponseDto.getTokenRequestorId(), matchTokenResponseDto, jmsTokenInfoResponseDto.getActionCode(), "TOKEN_ACTIVATION_REMINDER", diffWindowReminderPeriod);

                                            String logData = "Sending notification with a reminder about token activation to the customer. (RequestorId = '"
                                                    + matchTokenResponseDto.getId().getTokenRequestorId() + "' ReferenceId = '"
                                                    + matchTokenResponseDto.getId().getTokenRefId() + "')";

                                            logger.info(logData);
                                            return new JmsSendNotificationToCustomerResponseDto(null, "0", "");
                                        }
                                    }
                                } catch (ServiceException se) {
                                    String alertLogData = "Can't send notification token reminder because of timeout or no response from server."
                                            + " Error code: '" + se.getErrorCode() + "'.";

                                    logger.error(alertLogData);
                                    tokenHelper.saveAlertLog(tokenParameters.getOriginator(), alertLogData, "TOKEN_ACTIVATION_REMINDER");
                                }
                            }
                        } else {
                            String alertLogData = "tokenInfo not available because of errorCode (Action code = '"
                                    + jmsTokenInfoResponseDto.getActionCode() + "') in response.";

                            logger.error(alertLogData);
                            tokenHelper.saveAlertLog(tokenParameters.getOriginator(), alertLogData, "TOKEN_INFO_NOT_EXISTS");
                        }
                    } catch (ServiceException se) {
                        String alertLogData = "Can't get token status because of timeout or no response from server."
                                + " Error code: '" + se.getErrorCode() + "'.";

                        logger.error(alertLogData);
                        tokenHelper.saveAlertLog(tokenParameters.getOriginator(), alertLogData, "TOKEN_ACTIVATION_REMINDER");
                    }
                    return new JmsSendNotificationToCustomerResponseDto(null, "1", "");
        });
    }

    private JmsSendNotificationToCustomerResponseDto sendNotifyTokenNotActivate(TokenInfoDto tokenInfoDto) throws ServiceException {
        tokenInfoDto.setReminderPeriod(String.valueOf(tokenHelper.getDiffHours(tokenInfoDto.getTokenStatusUpdate())));
        HeadersJmsMessage jmsMessage = new SendNotificationToCustomerJmsMessage()
                .jmsSendNotificationToCustomerRequestDto(tokenHelper.createJmsSendNotificationToCustomerRequestDto(tokenInfoDto, TOKEN_ACTIVATION_REMINDER))
                .originator(tokenParameters.getOriginator());

        return integrationBus.inOut(() -> "BANK", "sendNotificationToCustomer", jmsMessage, JmsSendNotificationToCustomerResponseDto.class);
    }

    private void tokenUpdateReminderPeriodAndSave(TokenInfoDto token, String reminderPeriod) {
        token.setReminderPeriod(reminderPeriod);
        tokenInfoService.save(token);
    }
}
