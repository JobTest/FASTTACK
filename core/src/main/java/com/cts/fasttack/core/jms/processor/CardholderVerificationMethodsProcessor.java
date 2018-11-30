package com.cts.fasttack.core.jms.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.converter.CardholderVerificationMethodsDtoToDeviceInfoConverter;
import com.cts.fasttack.core.converter.CardholderVerificationMethodsDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.CardholderVerificationMethodsDtoToTokenInfoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.CardholderVerificationMethodService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.crypto.client.dto.VisaCryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;
import com.cts.fasttack.jms.dto.CardholderVerificationMethodsJmsMessage;
import com.cts.fasttack.jms.dto.CardholderVerificationMethodsJmsResponse;
import com.cts.fasttack.jms.dto.CvmJmsDto;
import com.cts.fasttack.jms.dto.CvmJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;
import com.cts.fasttack.jms.dto.JmsCvmDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsProcessor extends AbstractCamelProcessor<CardholderVerificationMethodsJmsMessage, CardholderVerificationMethodsJmsResponse> {

    private Logger logger = LogManager.getLogger(CardholderVerificationMethodsProcessor.class);

    @Autowired
    private CardholderVerificationMethodsDtoToTokenInfoConverter cardholderVerificationMethodsDtoToTokenInfoConverter;

    @Autowired
    private CardholderVerificationMethodsDtoToDeviceInfoConverter cardholderVerificationMethodsDtoToDeviceInfoConverter;

    @Autowired
    private CardholderVerificationMethodsDtoToTokenHistoryConverter cardholderVerificationMethodsDtoToTokenHistoryConverter;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    @Autowired
    private AlertLogService alertLogService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, CardholderVerificationMethodsJmsMessage.class, request -> {
            JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto = request.getCardholderVerificationMethodsDto();

            VisaCryptoResponseDto cryptoResponse;
            CardholderVerificationMethodsJmsResponse responseDto = new CardholderVerificationMethodsJmsResponse();
            cryptoResponse = visaCryptoRestClient.decryptWith3desAlgorithm(jmsCardholderVerificationMethodsDto.getEncryptedData(), jmsCardholderVerificationMethodsDto.getEncryptionKeyIndex());

            if(StringUtils.isBlank(cryptoResponse.getText()) || !cryptoResponse.getText().contains("pan")) {
                throw new CryptographyException();
            }
            Map<String, String> decryptedMap = parseDecrypted(cryptoResponse.getText());

            String pan = decryptedMap.get("pan");
            String exp = decryptedMap.get("expdt");

            JmsConfirmProvisioningResponseDto cpResponse = sendConfirmProvisioning(jmsCardholderVerificationMethodsDto, pan, exp, request.getOriginator());
            List<CvmJmsDto> methods = createCardholderVerificationMethods(cpResponse, jmsCardholderVerificationMethodsDto, request.getMessageHistoryId().toString(), pan);
            responseDto.setCardholderVerificationMethod(methods);

            TokenInfoDto tokenInfoDto = saveOrUpdateTokenInfo(jmsCardholderVerificationMethodsDto, request.getOriginator(), pan);

            saveDeviceInfo(jmsCardholderVerificationMethodsDto);

            saveTokenHistory(jmsCardholderVerificationMethodsDto);

            responseDto.setMaskedPan(tokenInfoDto.getMaskedPan());
            responseDto.setPanInternalId(cpResponse.getPanInternalId());
            responseDto.setPanInternalGuid(cpResponse.getPanInternalGUID());

            return responseDto;
        });
    }

    private Map<String, String> parseDecrypted(String decrypted){
        Map<String, String> map = new HashMap<>();
        String[] blocks = decrypted.split(";");
        Arrays.stream(blocks).forEach(s -> {
            String[] values = s.split("=");
            map.put(values[0], values[1]);
        });
        return map;
    }

    private List<CvmJmsDto> createCardholderVerificationMethods(JmsConfirmProvisioningResponseDto cpResponse, JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto, String idenfier, String pan){
        List<CvmJmsDto> methods = new ArrayList<>();
        CvmJmsDto method;
        if(StringUtils.isNoneBlank(cpResponse.getCustomerPhone()) && !jmsCardholderVerificationMethodsDto.isOtpMaxReached()){
            method = new CvmJmsDto();
            method.setIdentifier(idenfier);
            method.setType("cell_phone");
            method.setValue(StringUtil.maskPhoneNumber(cpResponse.getCustomerPhone()));
            methods.add(method);
            saveCardholderVerificationMethod(cpResponse, jmsCardholderVerificationMethodsDto, idenfier, pan);
        }
        method = new CvmJmsDto();
        method.setIdentifier("1");
        method.setType("customer_service");
        method.setValue(fePropService.get(FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER).getPropValue());
        methods.add(method);
        return methods;
    }

    private void saveCardholderVerificationMethod(JmsConfirmProvisioningResponseDto cpResponse, JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto, String identifier, String pan) {
        jmsCardholderVerificationMethodsDto.setCvmIdentifierOtp(identifier);
        cardholderVerificationMethodService.saveOrUpdateByConfirmProvisionResponse(cpResponse, jmsCardholderVerificationMethodsDto, pan);
    }

    private TokenInfoDto saveOrUpdateTokenInfo(JmsCardholderVerificationMethodsDto serviceDto, String originator, String pan) throws ServiceException {
    	TokenInfoDto tokenInfoDto = cardholderVerificationMethodsDtoToTokenInfoConverter.convert(serviceDto);
        tokenInfoDto.setMaskedPan(StringUtil.displayPanOrToken(pan));

        CardholderVerificationMethodDto cvmDto = cardholderVerificationMethodService.getByTokenRefIdAndRequestorId(serviceDto.getTokenReferenceID(), serviceDto.getTokenRequestorID()).orElse(null);
        if (cvmDto != null) {
            tokenInfoDto.setPanInternalGuid(cvmDto.getPanInternalGUID());
            tokenInfoDto.setPanInternalId(cvmDto.getPanInternalId());
            tokenInfoDto.setCustomerPhone(cvmDto.getCellPhone());
        } else {
            AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                    .with(AlertLogDto::setEvent, "CVM_NOT_EXISTS")
                    .with(AlertLogDto::setOriginator, originator)
                    .with(AlertLogDto::setData, "Can't find cardholderVerificationMethod by tokenReferenceId " + tokenInfoDto.getId().getTokenRefId() + " and tokenRequestorId "
                            + tokenInfoDto.getId().getTokenRequestorId())
                    .with(AlertLogDto::setDate, new Date())
                    .build();

            alertLogService.save(alertLogDto);
            logger.info(alertLogDto.getData());
        }

        TokenInfoDto currentTokenInfoDto = tokenInfoService.getOptional(new TokenInfoId(serviceDto.getTokenReferenceID(), serviceDto.getTokenRequestorID())).orElse(null);
        if (currentTokenInfoDto != null) {
        	if (currentTokenInfoDto.getIps() == null) {
        		currentTokenInfoDto.setIps(tokenInfoDto.getIps());
        	}
        	if (currentTokenInfoDto.getPanRefId() == null) {
        		currentTokenInfoDto.setPanRefId(tokenInfoDto.getPanRefId());
        	}
        	if (currentTokenInfoDto.getLifecycleTraceId() == null) {
        		currentTokenInfoDto.setLifecycleTraceId(tokenInfoDto.getLifecycleTraceId());
        	}
        	if (currentTokenInfoDto.getMaskedToken() == null) {
        		currentTokenInfoDto.setMaskedToken(tokenInfoDto.getMaskedToken());
        	}
        	if (currentTokenInfoDto.getPanSource() == null) {
        		currentTokenInfoDto.setPanSource(tokenInfoDto.getPanSource());
        	}
        	if (currentTokenInfoDto.getMaskedPan() == null) {
        		currentTokenInfoDto.setMaskedPan(tokenInfoDto.getMaskedPan());
        	}
        	if (currentTokenInfoDto.getPanInternalGuid() == null) {
        		currentTokenInfoDto.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());
        	}
        	if (currentTokenInfoDto.getPanInternalId() == null) {
        		currentTokenInfoDto.setPanInternalId(tokenInfoDto.getPanInternalId());
        	}
        	if (currentTokenInfoDto.getCustomerPhone() == null) {
        		currentTokenInfoDto.setCustomerPhone(tokenInfoDto.getCustomerPhone());
        	}
            currentTokenInfoDto.setTokenizationPath(tokenInfoDto.getTokenizationPath());
            currentTokenInfoDto.setWpDeviceScore(tokenInfoDto.getWpDeviceScore());
            currentTokenInfoDto.setWpAccountScore(tokenInfoDto.getWpAccountScore());
            currentTokenInfoDto.setWpPhonenumberScore(tokenInfoDto.getWpPhonenumberScore());
            currentTokenInfoDto.setWpReasonCodes(tokenInfoDto.getWpReasonCodes());
            currentTokenInfoDto.setClrTokenizationStandardVer(tokenInfoDto.getClrTokenizationStandardVer());

            tokenInfoDto = currentTokenInfoDto;
        }

        if (tokenInfoDto.getDigitizeDate()==null) {
            tokenInfoDto.setDigitizeDate(new Date());
        }

        return tokenInfoService.save(tokenInfoDto);
    }

    private DeviceInfoDto saveDeviceInfo(JmsCardholderVerificationMethodsDto serviceDto){
        DeviceInfoDto deviceInfoDto = cardholderVerificationMethodsDtoToDeviceInfoConverter.convert(serviceDto);
        return deviceInfoService.save(deviceInfoDto);
    }

    private TokenHistoryDto saveTokenHistory(JmsCardholderVerificationMethodsDto serviceDto){
        TokenHistoryDto tokenHistoryDto = cardholderVerificationMethodsDtoToTokenHistoryConverter.convert(serviceDto);
        return tokenHistoryService.save(tokenHistoryDto);
    }

    private JmsConfirmProvisioningResponseDto sendConfirmProvisioning(JmsCardholderVerificationMethodsDto methodsDto, String pan, String exp, String originator) throws ServiceException {
        JmsCvmDto jmsCvmDto = new JmsCvmDto();
        jmsCvmDto.setRequestId(methodsDto.getWpRequestId());
        jmsCvmDto.setConversationId(methodsDto.getWpConversationId());
        jmsCvmDto.setPan(pan);
        if(StringUtils.isNotBlank(exp)) {
            jmsCvmDto.setExpiryMonth(exp.substring(2, 4));
            jmsCvmDto.setExpiryYear(exp.substring(0, 2));
        }
        jmsCvmDto.setLang("en");
        PanSourceType cvmPanSource = PanSourceType.fromVisaIwsiPanSource(methodsDto.getPanSource());
        if (cvmPanSource != null) {
            jmsCvmDto.setPanSource(cvmPanSource.name());
        } else {
            jmsCvmDto.setPanSource("K");
        }
        jmsCvmDto.setIps(InternationalPaymentSystem.V.name());
        jmsCvmDto.setPaymentAppInstId(methodsDto.getWalletAccountID());
        jmsCvmDto.setTokenRefId(methodsDto.getTokenReferenceID());
        jmsCvmDto.setTokenRequestorId(methodsDto.getTokenRequestorID());
        jmsCvmDto.setWpReasonCodes(methodsDto.getWpReasonCodes());
        jmsCvmDto.setDeviceName(methodsDto.getDeviceName());
        return integrationBus.inOut(() -> originator, "getCardholderVerificationMethods",
                new CvmJmsMessage().cvmDto(jmsCvmDto)
                        .originator(originator), JmsConfirmProvisioningResponseDto.class);
    }
}
