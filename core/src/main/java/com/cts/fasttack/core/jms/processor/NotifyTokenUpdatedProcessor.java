package com.cts.fasttack.core.jms.processor;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.NotifyServiceUpdatedToTokenHistoryConverter;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.data.JmsMessage;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.dto.CommonMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsNotifyTokenUpdatedDto;
import com.cts.fasttack.jms.dto.JmsTokenDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import com.cts.fasttack.jms.dto.NotifyTokenUpdatedJmsMessage;
import com.cts.fasttack.jms.dto.TokenStatusUpdatedJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * @author a.lipavets
 */
@Component
public class NotifyTokenUpdatedProcessor extends AbstractCamelProcessor<NotifyTokenUpdatedJmsMessage, CommonMdesJmsResponseDto> {

    private Logger logger = LogManager.getLogger(NotifyTokenUpdatedProcessor.class);

    @Value("${spring.notify.token.updated}")
    private boolean notifyTokenUpdated;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private NotifyServiceUpdatedToTokenHistoryConverter notifyServiceUpdatedToTokenHistoryConverter;

    @Autowired
    private AlertLogService alertLogService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, NotifyTokenUpdatedJmsMessage.class, request -> {
            JmsNotifyTokenUpdatedDto tokenUpdatedDto = request.getNotifyTokenUpdatedDto();

            return updateTokensAndSendMessage(tokenUpdatedDto, request.getOriginator());

        });
    }

    private CommonMdesJmsResponseDto updateTokensAndSendMessage(JmsNotifyTokenUpdatedDto tokenUpdatedDto, String originator) throws ServiceException{
        TokenHistoryDto tokenHistoryDto = notifyServiceUpdatedToTokenHistoryConverter.convert(tokenUpdatedDto);
        CommonMdesJmsResponseDto cmjResponse = new CommonMdesJmsResponseDto();
        for (JmsTokenDto token : tokenUpdatedDto.getTokens()) {

            List<TokenInfoDto> tokenInfoDtos =  tokenInfoService.listByTokenRefId(token.getTokenUniqueReference());
            if(CollectionUtils.isEmpty(tokenInfoDtos)){
                AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                        .with(AlertLogDto::setEvent, "TOKEN_INFO_NOT_EXISTS")
                        .with(AlertLogDto::setOriginator, originator)
                        .with(AlertLogDto::setData, "Can't find tokenInfo by tokenRefId "
                                + token.getTokenUniqueReference())
                        .with(AlertLogDto::setDate, new Date())
                        .build();

                alertLogService.save(alertLogDto);
                logger.info(alertLogDto.getData());
            } else {
                for(TokenInfoDto tokenInfoDto : tokenInfoDtos) {
                    cmjResponse.setMaskedPan(tokenInfoDto.getMaskedPan());
                    cmjResponse.setPanInternalId(tokenInfoDto.getPanInternalId());
                    cmjResponse.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());
                    cmjResponse.setPanSource(tokenInfoDto.getPanSource() != null ? tokenInfoDto.getPanSource().name() : null);
                    if(InternationalPaymentSystem.M.equals(tokenInfoDto.getIps())) {
                        JmsMessage jmsMessage = new TokenStatusUpdatedJmsMessage()
                                .jmsTokenStatusUpdatedDto(createJmsTokenStatusUpdatedDto(tokenUpdatedDto, tokenInfoDto, token))
                                .originator(originator);

                        if (StringUtils.isNotBlank(token.getStatus())) {
                            tokenInfoDto.setTokenStatus(TokenStatus.valueOfFirstWord(token.getStatus()));
                        }
                        tokenInfoDto.setTokenStatusUpdate(new Date());
                        if (token.getTokenExpiry() != null) {
                            tokenInfoDto.setTokenExpdate(DateFormatUtil.expiryDate(DateFormatUtil.stringToDate(DateFormatEnum.BOG_DATE, token.getTokenExpiry())));
                        }
                        tokenInfoService.save(tokenInfoDto);

                        tokenHistoryDto.setTokenRefId(token.getTokenUniqueReference());
                        tokenHistoryDto.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
                        tokenHistoryDto.setTokenStatus(tokenInfoDto.getTokenStatus());
                        tokenHistoryDto.setTokenExpdate(tokenInfoDto.getTokenExpdate());
                        tokenHistoryService.save(tokenHistoryDto);

                        if (notifyTokenUpdated) {
                            integrationBus.inOut(() -> Constants.ORIGINATOR, "notifyTokenUpdated", jmsMessage, BankJmsResponseDto.class);
                        }
                    } else {
                        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                                .with(AlertLogDto::setEvent, "TOKEN_IPS_NOT_VALID")
                                .with(AlertLogDto::setOriginator, originator)
                                .with(AlertLogDto::setData, "Token with tokenRefId = " + tokenInfoDto.getId().getTokenRefId()
                                        + " and tokenRequestorId = " + tokenInfoDto.getId().getTokenRequestorId()
                                        + " has invalid IPS " + tokenInfoDto.getIps().name() + " for this request")
                                .with(AlertLogDto::setDate, new Date())
                                .build();
                        alertLogService.save(alertLogDto);
                        logger.info(alertLogDto.getData());
                    }
                }
            }
        }
        return cmjResponse;
    }

    private JmsTokenStatusUpdatedDto createJmsTokenStatusUpdatedDto(JmsNotifyTokenUpdatedDto tokenUpdatedDto, TokenInfoDto tokenInfoDto, JmsTokenDto jmsTokenDto){
        JmsTokenStatusUpdatedDto target = new JmsTokenStatusUpdatedDto();
        target.setRequestId(tokenUpdatedDto.getRequestId());
        target.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
        target.setTokenRefId(tokenInfoDto.getId().getTokenRefId());

        String status = StringUtils.isNotBlank(jmsTokenDto.getStatus()) ? TokenStatus.valueOfFirstWord(jmsTokenDto.getStatus()).name() : tokenInfoDto.getTokenStatus().name();
        if (StringUtils.isNotBlank(status)) {
            target.setStatus(status);
        }
        target.setPanInternalId(tokenInfoDto.getPanInternalId());
        target.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());

        String expDate = StringUtils.isNotBlank(jmsTokenDto.getTokenExpiry()) ? jmsTokenDto.getTokenExpiry()
                : DateFormatUtil.dateToString(DateFormatEnum.BOG_DATE, tokenInfoDto.getTokenExpdate());
        if(expDate != null) {
            target.setTokenExpiryMonth(expDate.substring(0, 2));
            target.setTokenExpiryYear(expDate.substring(2, 4));
        }

        target.setIps(tokenInfoDto.getIps().name());
        target.setMessageReasonCode(tokenUpdatedDto.getReasonCode());
        return target;
    }
}
