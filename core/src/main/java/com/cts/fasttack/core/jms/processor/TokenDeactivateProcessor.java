package com.cts.fasttack.core.jms.processor;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.core.converter.JmsTokenResponseDtoToTokenInfoDtoConverter;
import com.cts.fasttack.core.converter.TokenInfoDtoToJmsBankLifecycleTokenDtoConverter;
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
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.BankLifecycleTokenJmsMessage;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenDeactivateProcessor extends AbstractCamelProcessor<SendNotificationToCustomerJmsMessage, JmsSendNotificationToCustomerResponseDto> {

    private Logger logger = LogManager.getLogger(TokenDeactivateProcessor.class);

    public static final String LIFECYCLE_TOKEN_REASON_CODE = "Z"; // `Other`

    public static final String LIFECYCLE_TOKEN_ACTION = "Deactivate";

    public static final String MDES_DEACTIVATE_CURRENT_STATUS_CODE = "U";

    public static final String VTS_DEACTIVATE_CURRENT_STATUS_CODE = "I";

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenParameters tokenParameters;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private TokenInfoDtoToJmsBankLifecycleTokenDtoConverter tokenInfoDtoToJmsBankLifecycleTokenDtoConverter;

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
                            final boolean isDeactivateToken = isDeactivateToken(token, matchTokenResponseDto, jmsTokenResponseDto.getCurrentStatusCode());
                            if (isDeactivateToken) {
                                if ("0".equals(doDeactivateToken(token).getCode())) {
                                    String logData = "Token deactivated to the customer. (RequestorId = '"
                                            + matchTokenResponseDto.getId().getTokenRequestorId() + "' ReferenceId = '"
                                            + matchTokenResponseDto.getId().getTokenRefId() + "')";

                                    logger.info(logData);
                                    return new JmsSendNotificationToCustomerResponseDto(null, "0", "");
                                }
                            }
                        } catch (ServiceException se) {
                            String alertLogData = "Can't deactivate token because of timeout or no response from server."
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

    private boolean isDeactivateToken(TokenInfoDto token, TokenInfoDto responseToken, String currentStatusCode) {
        int             deactivatePeriod = tokenParameters.getDeactivatePeriod();
        int                    diffHours = tokenHelper.getDiffHours(token.getTokenStatusUpdate());
        boolean      isNullResponseToken = responseToken != null;
        boolean       isDeactivatePeriod = deactivatePeriod < diffHours;
        boolean      isCurrentStatusCode = responseToken.getIps().isMdes()
                ? currentStatusCode != null && currentStatusCode.equals(MDES_DEACTIVATE_CURRENT_STATUS_CODE)
                : currentStatusCode != null && currentStatusCode.equals(VTS_DEACTIVATE_CURRENT_STATUS_CODE);

        return isNullResponseToken && isCurrentStatusCode && isDeactivatePeriod;
    }

    private JmsLifecycleTokenResponseDto doDeactivateToken(TokenInfoDto token) throws ServiceException {
        HeadersJmsMessage jmsMessage = new BankLifecycleTokenJmsMessage()
                .activateTokenDto(getTokenInfoDtoToJmsBankLifecycleTokenDtoConverter(tokenInfoDtoToJmsBankLifecycleTokenDtoConverter.convert(token)))
                .originator(tokenParameters.getOriginator());
        JmsLifecycleTokenResponseDto response = integrationBus.inOut(() -> "BANK", "lifecycleToken", jmsMessage, JmsLifecycleTokenResponseDto.class);

        if("VSE40001".equals(response.getErrorMessage()) || "VSE40003".equals(response.getErrorMessage())){
            response.setCode("2");
            response.setErrorMessage(messageSourceService.getMessage(response.getErrorMessage()));
        } else if("VSE40002".equals(response.getErrorMessage())) {
            response.setCode("0");
            response.setErrorMessage(messageSourceService.getMessage(response.getErrorMessage()));
        } else if (!response.getTokensInfo().isEmpty() && ("0".equals(response.getCode()) || "VSE40002".equals(response.getErrorMessage()))) {

        } else {
            response.setCode(response.getCode());
            response.setErrorMessage(messageSourceService.getMessage(response.getErrorMessage()));
        }

        return response;
    }

    private JmsBankLifecycleTokenDto getTokenInfoDtoToJmsBankLifecycleTokenDtoConverter(JmsBankLifecycleTokenDto jmsBankLifecycleTokenDto) {
        jmsBankLifecycleTokenDto.setCommentText(tokenParameters.getComment());
        jmsBankLifecycleTokenDto.setUserId(tokenParameters.getUserId());
        jmsBankLifecycleTokenDto.setUserName(tokenParameters.getUserName());
        jmsBankLifecycleTokenDto.setAction(LIFECYCLE_TOKEN_ACTION);
        jmsBankLifecycleTokenDto.setReasonCode(LIFECYCLE_TOKEN_REASON_CODE);
//        target.setPan(); // Optional
//        target.setPaymentAppInstanceId();
        return jmsBankLifecycleTokenDto;
    }
}
