package com.cts.fasttack.core.jms.processor;

import java.util.Date;

import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.util.TokenHelper;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.CardholderVerificationMethodService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsSendOtpDto;
import com.cts.fasttack.jms.dto.JmsSendPasscodeDto;
import com.cts.fasttack.jms.dto.SendOtpJmsMessage;
import com.cts.fasttack.jms.dto.SendPasscodeJmsMessage;
import com.cts.fasttack.jms.dto.SendPasscodeJmsResponse;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * @author a.lipavets
 */
@Component
public class SendPasscodeProcessor extends AbstractCamelProcessor<SendPasscodeJmsMessage, SendPasscodeJmsResponse> {

    private Logger logger = LogManager.getLogger(SendPasscodeProcessor.class);

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private TokenHelper tokenHelper;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, SendPasscodeJmsMessage.class, request -> {

            JmsSendPasscodeDto jmsSendPasscodeDto = request.getSendPasscodeDto();
            SendPasscodeJmsResponse spResponse = new SendPasscodeJmsResponse();

            TokenInfoDto tokenInfoDto = tokenInfoService.getOptional(new TokenInfoId(jmsSendPasscodeDto.getTokenReferenceID(), jmsSendPasscodeDto.getTokenRequestorID())).orElse(null);
            if(tokenInfoDto == null){
                AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                        .with(AlertLogDto::setEvent, "TOKEN_NOT_EXISTS")
                        .with(AlertLogDto::setOriginator, request.getOriginator())
                        .with(AlertLogDto::setData, "Can't find tokenInfo by tokenReferenceId " + jmsSendPasscodeDto.getTokenReferenceID() + " and tokenRequestorId "
                                + jmsSendPasscodeDto.getTokenRequestorID())
                        .with(AlertLogDto::setDate, new Date())
                        .build();

                alertLogService.save(alertLogDto);
                logger.info(alertLogDto.getData());
                spResponse.setCode(VisaErrorCode.Codes.TOKEN_REFERENCE_ID_IS_NOT_VALID);
                return spResponse;
            }

            CardholderVerificationMethodDto cvmDto = cardholderVerificationMethodService.getByTokenRefIdAndRequestorId(jmsSendPasscodeDto.getTokenReferenceID(), jmsSendPasscodeDto.getTokenRequestorID()).orElse(null);
            if(cvmDto == null){
                AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                        .with(AlertLogDto::setEvent, "CVM_NOT_EXISTS")
                        .with(AlertLogDto::setOriginator, request.getOriginator())
                        .with(AlertLogDto::setData, "Can't find cardholderVerificationMethod by tokenReferenceId " + jmsSendPasscodeDto.getTokenReferenceID() + " and tokenRequestorId "
                                + jmsSendPasscodeDto.getTokenRequestorID())
                        .with(AlertLogDto::setDate, new Date())
                        .build();

                alertLogService.save(alertLogDto);
                logger.info(alertLogDto.getData());
                spResponse.setCode(VisaErrorCode.Codes.DATA_ELEMENT_NOT_VALID);
                return spResponse;
            }

            if (!jmsSendPasscodeDto.getOtpMethodIdentifier().equals(cvmDto.getCvmIdentifierOtp())) {
                spResponse.setCode(VisaErrorCode.Codes.RESOLUTION_METHOD_ID_IS_NOT_VALID);
                return spResponse;
            }

            JmsSendOtpDto sendOtpDto = GenericBuilder.of(JmsSendOtpDto::new)
                    .with(JmsSendOtpDto::setRequestId, jmsSendPasscodeDto.getWpRequestId())
                    .with(JmsSendOtpDto::setConversationId, cvmDto.getCorrelationId())
                    .with(JmsSendOtpDto::setCustomerPhone, cvmDto.getCellPhone())
                    .with(JmsSendOtpDto::setPanInternalGuid, tokenInfoDto.getPanInternalGuid())
                    .with(JmsSendOtpDto::setPanInternalId, tokenInfoDto.getPanInternalId())
                    .with(JmsSendOtpDto::setOtp, jmsSendPasscodeDto.getOtpCode())
                    .with(JmsSendOtpDto::setTokenRefId, cvmDto.getTokenRefId())
                    .with(JmsSendOtpDto::setMaskedPan, cvmDto.getMaskedPan())
                    .with(JmsSendOtpDto::setDeviceType, jmsSendPasscodeDto.getDeviceType())
                    .with(JmsSendOtpDto::setTokenRequestorId, cvmDto.getTokenRequestorId())
                    .with(JmsSendOtpDto::setLastFourOfPAN, tokenHelper.getLastFourOfPAN(cvmDto.getMaskedPan()))
                    .build();

            HeadersJmsMessage jmsMessage = new SendOtpJmsMessage()
                    .sendOtpDto(sendOtpDto)
                    .originator(request.getOriginator());

            spResponse = integrationBus.inOut(() -> Constants.ORIGINATOR, "sendOtp", jmsMessage, SendPasscodeJmsResponse.class);

            if (!"0".equals(spResponse.getCode())) {
            	if ("2".equals(spResponse.getCode())) {
            		spResponse.setCode(VisaErrorCode.Codes.RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE);
            	} else {
            	    spResponse.setCode(VisaErrorCode.Codes.INTERNAL_SERVICE_FAILURE);
            	}
            }
            spResponse.setPanInternalId(tokenInfoDto.getPanInternalId());
            spResponse.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());
            spResponse.setMaskedPan(cvmDto.getMaskedPan());

            return spResponse;
        });
    }
}
