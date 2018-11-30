package com.cts.fasttack.core.jms.processor;

import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoMessageDto;
import com.cts.fasttack.jms.dto.TokenInfoJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CardDataUpdateProcessor extends AbstractCamelProcessor<TokenInfoJmsMessage, JmsCardDataUpdateResponseDto> {

    private Logger logger = LogManager.getLogger(CardDataUpdateProcessor.class);

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private AlertLogService alertLogService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenInfoJmsMessage.class, request -> {

            JmsTokenInfoMessageDto jmsTokenInfoMessageDto = request.getTokenInfoMessageDto();
            TokenInfoId tokenInfoId = new TokenInfoId(jmsTokenInfoMessageDto.getTokenRefId(), jmsTokenInfoMessageDto.getTokenRequestorId());

            JmsCardDataUpdateResponseDto jmsCardDataUpdateResponseDto = new JmsCardDataUpdateResponseDto();
            jmsCardDataUpdateResponseDto.setRequestId( request.getTokenInfoMessageDto().getRequestId() );

            if (tokenInfoService.isExists(tokenInfoId)) {
                TokenInfoDto tokenInfoDto = tokenInfoService.get(tokenInfoId);

                if (StringUtils.isNotBlank(jmsTokenInfoMessageDto.getPan())) {
                    String maskedPan = StringUtil.displayPanOrToken(jmsTokenInfoMessageDto.getPan());
                    tokenInfoDto.setMaskedPan( maskedPan );
                }

                if (StringUtils.isNotBlank(jmsTokenInfoMessageDto.getPanInternalId())) {
                    tokenInfoDto.setPanInternalId(jmsTokenInfoMessageDto.getPanInternalId());
                }

                if (StringUtils.isNotBlank(jmsTokenInfoMessageDto.getPanInternalGUID())) {
                    tokenInfoDto.setPanInternalGuid(jmsTokenInfoMessageDto.getPanInternalGUID());
                }
                tokenInfoService.save(tokenInfoDto);

                jmsCardDataUpdateResponseDto.setCode("0");
                String logData = "Token card data updated: tokenRefId = '" +
                        tokenInfoId.getTokenRefId() + "', tokenRequestorId = '" + tokenInfoId.getTokenRequestorId() + "'";

                logger.info(logData);
            } else {
                jmsCardDataUpdateResponseDto.setCode("1");
                String alertLogData = "tokenInfo not available because of not found: tokenRefId = '" +
                        tokenInfoId.getTokenRefId() + "', tokenRequestorId = '" + tokenInfoId.getTokenRequestorId() + "'";

                logger.error(alertLogData);
                saveAlertLog("BANK", alertLogData, "TOKEN_INFO_NOT_EXISTS");
            }

            return jmsCardDataUpdateResponseDto;
        });
    }

    private void saveAlertLog(String originator, String data, String event) {
        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                .with(AlertLogDto::setEvent, event)
                .with(AlertLogDto::setOriginator, originator)
                .with(AlertLogDto::setData, data)
                .with(AlertLogDto::setDate, new Date())
                .build();

        alertLogService.save(alertLogDto);
    }
}
