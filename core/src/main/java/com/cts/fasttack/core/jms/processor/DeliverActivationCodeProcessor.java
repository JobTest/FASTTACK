package com.cts.fasttack.core.jms.processor;

import java.util.Date;
import java.util.Optional;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.util.TokenHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.service.CardholderVerificationMethodService;
import com.cts.fasttack.core.service.DCProgressService;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.ActivationCodeJmsMessage;
import com.cts.fasttack.jms.dto.CommonMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsSendOtpDto;
import com.cts.fasttack.jms.dto.SendOtpJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class DeliverActivationCodeProcessor extends AbstractCamelProcessor<ActivationCodeJmsMessage, CommonMdesJmsResponseDto> {

    private Logger logger = LogManager.getLogger(DeliverActivationCodeProcessor.class);

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private DCProgressService dcProgressService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenHelper tokenHelper;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, ActivationCodeJmsMessage.class, request -> {
            CommonMdesJmsResponseDto cmjResponse = new CommonMdesJmsResponseDto();
            CardholderVerificationMethodDto cvmDto = cardholderVerificationMethodService.getByCorrelationId(request.getDeliverActivationDto().getCorrelationId()).orElse(null);

            Optional<DCProgressDto> dcProgressDto = Optional.empty();

            if(cvmDto == null){
                AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                        .with(AlertLogDto::setEvent, "CVM_NOT_EXISTS")
                        .with(AlertLogDto::setOriginator, request.getOriginator())
                        .with(AlertLogDto::setData, "Can't find cardholderVerificationMethod by correlationId "
                                + request.getDeliverActivationDto().getCorrelationId())
                        .with(AlertLogDto::setDate, new Date())
                        .build();

                alertLogService.save(alertLogDto);
                logger.info(alertLogDto.getData());
            } else {
                JmsSendOtpDto sendOtpDto = GenericBuilder.of(JmsSendOtpDto::new)
                        .with(JmsSendOtpDto::setConversationId, cvmDto.getRequestId())
                        .with(JmsSendOtpDto::setCustomerPhone, cvmDto.getCellPhone())
                        .with(JmsSendOtpDto::setPanInternalGuid, cvmDto.getPanInternalGUID())
                        .with(JmsSendOtpDto::setPanInternalId, cvmDto.getPanInternalId())
                        .with(JmsSendOtpDto::setOtp, request.getDeliverActivationDto().getActivationCode())
                        .with(JmsSendOtpDto::setRequestId, request.getDeliverActivationDto().getRequestId())
                        .with(JmsSendOtpDto::setTokenRefId, request.getDeliverActivationDto().getTokenUniqueReference())
                        .with(JmsSendOtpDto::setMaskedPan, cvmDto.getMaskedPan())
                        .with(JmsSendOtpDto::setDeviceType, cvmDto.getDeviceType())
                        .with(JmsSendOtpDto::setTokenRequestorId, cvmDto.getTokenRequestorId())
                        .with(JmsSendOtpDto::setLastFourOfPAN, tokenHelper.getLastFourOfPAN(cvmDto.getMaskedPan()))
                        .build();
                dcProgressDto = dcProgressService.get(request.getDeliverActivationDto().getCorrelationId());
                dcProgressDto.ifPresent(dc -> {
                    sendOtpDto.setConversationId(dc.getRequestId());
                });

                cvmDto.setTokenRefId(request.getDeliverActivationDto().getTokenUniqueReference());
                cardholderVerificationMethodService.saveOrUpdate(cvmDto);

                TokenInfoDto tokenInfoDto = tokenInfoService.getWithDeviceInfo(new TokenInfoId(cvmDto.getTokenRefId(), cvmDto.getTokenRequestorId()));
                if (tokenInfoDto==null) {
                    tokenInfoDto = new TokenInfoDto();
                    tokenInfoDto.setId(new TokenInfoId(cvmDto.getTokenRefId(), cvmDto.getTokenRequestorId()));
                    tokenInfoDto.setPanInternalId(cvmDto.getPanInternalId());
                    tokenInfoDto.setPanInternalGuid(cvmDto.getPanInternalGUID());
                    tokenInfoDto.setMaskedPan(cvmDto.getMaskedPan());
                    tokenInfoDto.setTokenStatusUpdate(new Date());
                    tokenInfoDto.setTokenStatus(TokenStatus.I);
                    if (dcProgressDto.isPresent()) {
                        DCProgressDto getDCProgressDto = dcProgressDto.get();
                        tokenInfoDto.setCustomerPhone(getDCProgressDto.getCustomerPhone());
                        tokenInfoDto.setIps(InternationalPaymentSystem.M); //todo tokenInfoDto.setIps(getDCProgressDto.getIps());
                    }
                }
                tokenInfoDto.setTokenizationPath(cvmDto.getTokenizationPath());
                tokenInfoDto.setWpReasonCodes(cvmDto.getWpReasonCodes());
                tokenInfoDto.setWpAccountScore(cvmDto.getWpAccountScore());
                tokenInfoDto.setWpDeviceScore(cvmDto.getWpDeviceScore());
                tokenInfoDto.setWpPhonenumberScore(cvmDto.getWpPhonenumberScore());
                tokenInfoDto.setClrTokenizationStandardVer(cvmDto.getColorTokenizationStandardVersion());

                if (tokenInfoDto.getDigitizeDate()==null) {
                    tokenInfoDto.setDigitizeDate(new Date());
                }

                tokenInfoService.save(tokenInfoDto);


                HeadersJmsMessage jmsMessage = new SendOtpJmsMessage()
                        .sendOtpDto(sendOtpDto)
                        .originator(request.getOriginator());

                cmjResponse = integrationBus.inOut(() -> Constants.ORIGINATOR, "sendOtp", jmsMessage, CommonMdesJmsResponseDto.class);
                
                cmjResponse.setMaskedPan(cvmDto.getMaskedPan());
                cmjResponse.setPanInternalId(cvmDto.getPanInternalId());
                cmjResponse.setPanInternalGuid(cvmDto.getPanInternalGUID());
            }
            return cmjResponse;
        });

    }
}
