package com.cts.fasttack.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.cts.fasttack.common.core.converter.RecommendationReasonsConverter;
import com.cts.fasttack.core.converter.CardholderVerificationMethodDtoToTokenInfoDtoConverter;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.CardInfoDataDto;
import com.cts.fasttack.core.dto.Timestamp;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.core.dto.CardProductDto;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.CvcAttemptDto;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.common.core.util.TokenizationPathUtil;
import com.cts.fasttack.core.util.TokenHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.converter.JmsAuthorizeServiceToDCProgressDtoConverter;
import com.cts.fasttack.core.converter.JmsAuthorizeServiceDtoToDeviceInfoConverter;
import com.cts.fasttack.core.dict.DCProgressStatus;
import com.cts.fasttack.core.dict.ProvisioningDecision;
import com.cts.fasttack.core.dict.Source;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.MdesCryptoRestClient;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.ActivationMethodDto;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.dto.ConfirmProvisioningJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceDto;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceResponseDto;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationDto;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningDto;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;
import com.cts.fasttack.logging.service.CallingContext;

/**
 * @author a.lipavets
 */
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthorizeServiceImpl implements AuthorizeService {

    private final Logger log = LogManager.getLogger(getClass());

    private static final int ONE_SECOND = 1;

    private final Lock lock = new ReentrantLock();

    private final Condition condition  = lock.newCondition();

    private static final String CVC_ATTEMPTS_ERROR = "CVC_ATTEMPTS_ERROR";
    private static final String CVC_RESULT_ERROR = "CVC_RESULT_ERROR";

    private static String PAN_FROM_CONFIRM_PROVISIONING;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private MdesCryptoRestClient mdesCryptoRestClient;

    @Autowired
    private DCProgressService dcProgressService;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private JmsAuthorizeServiceToDCProgressDtoConverter jmsAuthorizeServiceToDCProgressDtoConverter;

    @Autowired
    private CardholderVerificationMethodDtoToTokenInfoDtoConverter cardholderVerificationMethodDtoToTokenInfoDtoConverter;

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    @Autowired
    private JmsAuthorizeServiceDtoToDeviceInfoConverter jmsAuthorizeServiceDtoToDeviceInfoConverter;

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    private CvcAttemptService cvcAttemptService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private TokenHelper tokenHelper;

    @Value("${spring.authorize.waiting-for-request-finishing}")
    private Timestamp waitingForRequestFinishing;

    @Value("${spring.authorize.source.cardOnFileAsCardAddedManually}")
    private boolean cardOnFileAsCardAddedManually;

    @Value("${spring.binSetup.defaultSendAsv}")
    private boolean defaultSendAsv;

    @Value("${spring.binSetup.defaultCvcAttempt}")
    private int defaultCvcAttempt;

    @Value("${spring.binSetup.defaultPrepaid}")
    private boolean defaultPrepaid;

    @Value("${spring.binSetup.defaultMaxTokensPerCard}")
    private int defaultMaxTokensPerCard;

    @Override
    @ChangeLoggable(action = AuthorizeService.AUTHORIZE, itemType = AuthorizeService.AUTHORIZE, itemId = "#authorizeServiceDto.paymentAppInstanceId")
    public JmsAuthorizeServiceResponseDto authorize(JmsAuthorizeServiceDto authorizeServiceDto, Long messageHistoryId) throws ServiceException {
        CryptoResponseDto mdesCryptoResponseDto = mdesCryptoRestClient.decryptWithMdesCustomerPriv(authorizeServiceDto.getEncryptedData(),
                authorizeServiceDto.getEncryptedKey(),
                authorizeServiceDto.getPublicKeyFingerprint(), authorizeServiceDto.getOaepHashingAlgorithm(),
                authorizeServiceDto.getIv());
        CardInfoDataDto cardInfoDataDto = JsonUtil.fromJson(mdesCryptoResponseDto.getText(), CardInfoDataDto.class);

        if(cardInfoDataDto.getDataValidUntilTimestamp() != null && cardInfoDataDto.getDataValidUntilTimestamp().getTime() < new Date().getTime()){
            DCProgressDto dcProgressDto = jmsAuthorizeServiceToDCProgressDtoConverter.convert(authorizeServiceDto);
            dcProgressDto.setProvisioningDecision(ProvisioningDecision.DECL);
            dcProgressService.save(dcProgressDto);
            log.info("Save DCPROGRESS with provisioningDecision - DECLINED, cause CardInfoData considered invalid");
            return GenericBuilder.of(JmsAuthorizeServiceResponseDto::new)
                    .with(JmsAuthorizeServiceResponseDto::setDecision, ProvisioningDecision.DECL.getCaption())
                    .with(JmsAuthorizeServiceResponseDto::setMaskedPan, StringUtil.displayPanOrToken(cardInfoDataDto.getAccountNumber()))
                    .with(JmsAuthorizeServiceResponseDto::setPanSource, Source.getSource(cardInfoDataDto.getSource().name()))
                    .build();
        }

        DCProgressDto dcProgressDto = dcProgressService.getOrCreate(authorizeServiceDto.getRequestId(), authorizeServiceDto.getCorrelationId(), authorizeServiceDto.getTokenRequestorId());
        jmsAuthorizeServiceToDCProgressDtoConverter.convert(authorizeServiceDto, dcProgressDto);

        /*
         * If dcProgressDto.finished then returns response to MDES
         * If dcProgressDto.finished == false then current request is waiting for response from first request max {@link waitingForRequestFinishing} seconds
         *      if first request was finished then is sending response to MDES
         *      if first request not finished for {@link waitingForRequestFinishing} seconds then second request is continue processing
         */
        boolean hasError = false;
        try {
            lock.lock();
            JmsAuthorizeServiceResponseDto responseDto = isRequestFinished(dcProgressDto, authorizeServiceDto, cardInfoDataDto, 0);
            if (responseDto != null) {
                log.info("Returns the response to MDES. Request is finished.");
                responseDto.setMaskedPan(StringUtil.displayPanOrToken(cardInfoDataDto.getAccountNumber()));
                responseDto.setPanSource(Source.getSource(cardInfoDataDto.getSource().name()));
                return responseDto;
            }

            final String tokenizationPath = isWalletProviderDecisioningInfo(authorizeServiceDto)
                    ? TokenizationPathUtil.identify(authorizeServiceDto.getRecommendedDecision(), authorizeServiceDto.getRecommendationReasons()).getValues()
                    : null;

            if (cardInfoDataDto.getSource().isCardAddedManually() || (cardOnFileAsCardAddedManually && cardInfoDataDto.getSource().isCardOnFile())) {
                log.info("Start working Confirm Provisioning and Account Status Verification");
                try {
                    String originator = callingContext.getOriginator();
                    Thread threadConfirmProvisioning = new Thread(taskConfirmProvisioning(dcProgressDto, cardInfoDataDto, originator, messageHistoryId, PanSourceType.K, authorizeServiceDto.getPaymentAppInstanceId(), tokenizationPath, authorizeServiceDto.getDeviceName()));
                    Thread threadVerifyCardStatus = new Thread(taskVerifyCardStatus(cardInfoDataDto, authorizeServiceDto, dcProgressDto, originator, messageHistoryId));

                    threadConfirmProvisioning.start();
                    threadVerifyCardStatus.start();
                    threadConfirmProvisioning.join();
                    threadVerifyCardStatus.join();
                } catch (Exception e) {
                    log.error("Error while async process confirmProvisioning and verifyCardStatus", e);
                    throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                }
                log.info("Finish working Confirm Provisioning and Account Status Verification");
            } else if (cardInfoDataDto.getSource().isCardAddedViaApplication()) {
                confirmProvisioning(dcProgressDto, cardInfoDataDto, callingContext.getOriginator(), messageHistoryId, PanSourceType.M, authorizeServiceDto.getPaymentAppInstanceId(), tokenizationPath, authorizeServiceDto.getDeviceName());
            } else {
                throw new ServiceException(StandardErrorCodes.UNABLE_TO_ASSESS);
            }

            if ((dcProgressDto.getAsvStatus() != null && dcProgressDto.getAsvStatus().isDecline()) ||
                    (dcProgressDto.getProvisioningDecision() != null && dcProgressDto.getProvisioningDecision().isDeclined())) {
                log.info("DCPROGRESS: AsvStatus - " + dcProgressDto.getAsvStatus() + " and ProvisioningDecision - " + dcProgressDto.getProvisioningDecision() + ". Response: DECLINE");
                return createResponse(dcProgressDto, authorizeServiceDto, cardInfoDataDto);
            }

            if (dcProgressDto.getProvisioningDecision() != null && (dcProgressDto.getProvisioningDecision().isAuth()) || dcProgressDto.getProvisioningDecision().isApproved()) {
                CardholderVerificationMethodDto cardholderVerificationMethodDto = null;
                if (isWalletProviderDecisioningInfo(authorizeServiceDto)) {
                    cardholderVerificationMethodDto = cardholderVerificationMethodService.saveOrUpdate(dcProgressDto, cardInfoDataDto.getAccountNumber(),
                            tokenizationPath,
                            new RecommendationReasonsConverter().convertToReasonCodes(authorizeServiceDto.getRecommendationReasons()),
                            String.valueOf(authorizeServiceDto.getDeviceScore()),
                            authorizeServiceDto.getPhoneNumberScore(),
                            authorizeServiceDto.getAccountScore(),
                            authorizeServiceDto.getRecommendationStandardVersion(),
                            authorizeServiceDto.getFormFactor(),
                            authorizeServiceDto.getDeviceName());
                } else {
                    cardholderVerificationMethodDto = cardholderVerificationMethodService.saveOrUpdate(dcProgressDto, cardInfoDataDto.getAccountNumber());
                }
                TokenInfoDto tokenInfoDto = createTokenInfoDto(cardholderVerificationMethodDto, authorizeServiceDto, cardInfoDataDto);
                tokenInfoService.save(tokenInfoDto);

                DeviceInfoDto deviceInfoDto = jmsAuthorizeServiceDtoToDeviceInfoConverter.convert(authorizeServiceDto);
                deviceInfoDto.setTokenRefId(cardholderVerificationMethodDto.getTokenRefId());
                deviceInfoService.save(deviceInfoDto);
            }

            if (StringUtils.isNotBlank(PAN_FROM_CONFIRM_PROVISIONING)) {
                CardProductDto cardProductDto = tokenHelper.getProductConfigId(Long.valueOf(PAN_FROM_CONFIRM_PROVISIONING));
                if (cardProductDto!=null) {
                    dcProgressDto.setProductConfigID(cardProductDto.getProductConfigId() );
                }
            }
        } catch (ServiceException | BusinessLogicException e) {
            hasError = true;
            throw e;
        } finally {
            dcProgressDto.setLock(false);
            condition.signalAll();
            if (!hasError && dcProgressDto.getProvisioningDecision() != null && !dcProgressDto.getProvisioningDecision().isDeclined()) {
                dcProgressDto.setFinished(true);
            }
            lock.unlock();
            dcProgressService.save(dcProgressDto);
        }

        return createResponse(dcProgressDto, authorizeServiceDto, cardInfoDataDto);
    }

    private TokenInfoDto createTokenInfoDto(CardholderVerificationMethodDto cardholderVerificationMethodDto, JmsAuthorizeServiceDto authorizeServiceDto, CardInfoDataDto cardInfoDataDto) {
        TokenInfoDto tokenInfoDto = cardholderVerificationMethodDtoToTokenInfoDtoConverter.convert(cardholderVerificationMethodDto);
        tokenInfoDto.setPanRefId(authorizeServiceDto.getPanUniqueReference()); //todo:  replace value from authorizeService
        tokenInfoDto.setClientWalletAccountId(authorizeServiceDto.getPaymentAppInstanceId());
        tokenInfoDto.setPanSource(PanSourceType.getInstance(Source.getSource(cardInfoDataDto.getSource().name())));
        BinSetupDto binSetupDto = binSetupService.getSuitableBin(cardInfoDataDto.getAccountNumber()).orElse(null);
        if (binSetupDto != null) tokenInfoDto.setBin(binSetupDto.getBin());
        tokenInfoDto.setTokenStatus(TokenStatus.I);
        tokenInfoDto.setTokenStatusUpdate(new Date());
        return tokenInfoDto;
    }

    private boolean isWalletProviderDecisioningInfo(JmsAuthorizeServiceDto authorizeServiceDto) {
        return !(authorizeServiceDto.getAccountScore() == null
                && authorizeServiceDto.getDeviceScore() == null
                && authorizeServiceDto.getPhoneNumberScore() == null
                && authorizeServiceDto.getRecommendationReasons() == null
                && authorizeServiceDto.getRecommendationStandardVersion() == null
                && authorizeServiceDto.getRecommendedDecision() == null);
    }

    private JmsAuthorizeServiceResponseDto isRequestFinished(DCProgressDto dcProgressDto, JmsAuthorizeServiceDto authorizeServiceDto, CardInfoDataDto cardInfoDataDto, int counter) throws ServiceException{
        if (!dcProgressDto.getFinished()) {

            boolean locked = dcProgressService.tryLock(dcProgressDto.getId());
            if (locked) {
                log.info("DCProgress locked change on true.");
                return null;
            }
            while(counter < waitingForRequestFinishing.getDuration() && dcProgressService.get(dcProgressDto.getId()).getLock()) {
                try {
                    counter++;
                    condition.await(ONE_SECOND, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    log.warn(StandardErrorCodes.INTERNAL_SERVICE_FAILURE.name() + " was happened in isRequestFinished() method.");
                    throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                }
            }
            if(dcProgressService.get(dcProgressDto.getId()).getLock()){
                return createResponse(dcProgressDto, authorizeServiceDto, cardInfoDataDto);
            } else {
                log.info("Previous request is still processing after waiting for " + waitingForRequestFinishing.getDuration() + " " + waitingForRequestFinishing.getTimeUnit().name());
                return null;
            }
        } else {
            return createResponse(dcProgressDto, authorizeServiceDto, cardInfoDataDto);
        }
    }

    private JmsAuthorizeServiceResponseDto createResponse(DCProgressDto dcProgressDto, JmsAuthorizeServiceDto authorizeServiceDto, CardInfoDataDto cardInfoDataDto) throws ServiceException{
        log.info("Start forming response, AsvStatus - " + dcProgressDto.getAsvStatus() + "; ProvisioningDecision - " + dcProgressDto.getProvisioningDecision());
        JmsAuthorizeServiceResponseDto responseDto = new JmsAuthorizeServiceResponseDto();
        responseDto.setResponseId(dcProgressDto.getRequestId());
        responseDto.setServices(authorizeServiceDto.getServices().toArray(new String[]{}));
        DCProgressStatus asvStatus = dcProgressDto.getAsvStatus();
        ProvisioningDecision provisioningDecision = dcProgressDto.getProvisioningDecision();
        responseDto.setDecision(
        		provisioningDecision == null ?
                        ProvisioningDecision.DECL.getCaption() : provisioningDecision.isDeclined() || (asvStatus != null && asvStatus.isDecline()) ?
                        ProvisioningDecision.DECL.getCaption() : (asvStatus != null && asvStatus.isSuccess()) && provisioningDecision.isAuth() ?
                        		provisioningDecision.getCaption() : asvStatus == null ?
                        				provisioningDecision.getCaption() : ProvisioningDecision.APPR.getCaption());

        log.info("Continue forming response, intermediate Decision - " + responseDto.getDecision());

        responseDto.setMaskedPan(StringUtil.displayPanOrToken(cardInfoDataDto.getAccountNumber()));
        responseDto.setPanSource(Source.getSource(cardInfoDataDto.getSource().name()));
        responseDto.setPanInternalId(dcProgressDto.getPanInternalId());
        responseDto.setPanInternalGuid(dcProgressDto.getPanInternalGUID());

        setCvcResponse(dcProgressDto, responseDto, provisioningDecision);

        if (!ProvisioningDecision.DECL.getCaption().equals(responseDto.getDecision())) {
        	BinSetupDto binSetupDto = binSetupService.getSuitableBin(cardInfoDataDto.getAccountNumber()).orElse(null);

        	boolean prepaid = defaultPrepaid;
        	int maxTokensPerCard = defaultMaxTokensPerCard;
        	if (binSetupDto != null) {
        		prepaid = binSetupDto.isPrepaid();
				if (binSetupDto.getMaxTokensPerCard() != null) {
					maxTokensPerCard = binSetupDto.getMaxTokensPerCard();
				}
        	}
        	
        	adjustResponseDecisionForTokenizationLimit(responseDto, maxTokensPerCard);

        	if (prepaid) {
        	    if (ProvisioningDecision.AUTH.getCaption().equals(responseDto.getDecision())) {
        	    	responseDto.setDecision(ProvisioningDecision.APPR.getCaption());
        	        log.info("Continue forming response, the card is prepaid, Decision changed - " + responseDto.getDecision());
        	    }
        	}
        }

        if (ProvisioningDecision.DECL.getCaption().equals(responseDto.getDecision())) {
            log.info("Finish forming response, final Decision - " + responseDto.getDecision() + "; CvcResponse - " + responseDto.getCvcResponse());
            return responseDto;
        }

        responseDto.setIssuerProductConfigId(dcProgressDto.getProductConfigID());

        if(provisioningDecision != null && provisioningDecision.isAuth() &&
        		ProvisioningDecision.AUTH.getCaption().equals(responseDto.getDecision())){
            List<ActivationMethodDto> activationMethodDtos = new ArrayList<>();
            if (!StringUtils.isBlank(dcProgressDto.getCustomerPhone())) {
                ActivationMethodDto customPhone = new ActivationMethodDto();
                customPhone.setType("TEXT_TO_CARDHOLDER_NUMBER");
                customPhone.setValue(StringUtil.maskPhoneNumber(dcProgressDto.getCustomerPhone()));
                activationMethodDtos.add(customPhone);
            }
            ActivationMethodDto callNumber = new ActivationMethodDto();
            callNumber.setType("CARDHOLDER_TO_CALL_AUTOMATED_NUMBER");
            callNumber.setValue(fePropService.get(FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER).getPropValue());
            activationMethodDtos.add(callNumber);

            responseDto.setActivationMethods(activationMethodDtos);
        }
        log.info("Finish forming response, final Decision - " + responseDto.getDecision() + "; CvcResponse - " + responseDto.getCvcResponse());
        return responseDto;
    }

    /** Checks if total number of tokens created for the card with given panInternalId and/or panInternalGUID is greater or equal
     * to the limit passed in maxTokensPerCard. If it is then sets Decision in the responseDto to DECLINED.
     * Counts only tokens with non-empty status.
     */
    private void adjustResponseDecisionForTokenizationLimit(JmsAuthorizeServiceResponseDto responseDto, int maxTokensPerCard) throws ServiceException {
    	List<TokenInfoDto> cardTokens = tokenInfoService.listByPanInternalIdOrGUID(responseDto.getPanInternalId(), responseDto.getPanInternalGuid());
    	
    	int tokenCount = 0;
    	
    	for (TokenInfoDto token : cardTokens) {
    		if (token.getTokenStatus() != null) {
    			++tokenCount;
    		}
    	}
    	
    	if (tokenCount >= maxTokensPerCard) {
    		responseDto.setDecision(ProvisioningDecision.DECL.getCaption());
            log.info("Continue forming response, MAX_TOKENS_PER_CARD (" + maxTokensPerCard + ") reached, Decision changed - " + responseDto.getDecision());
    	}
    }

    private Runnable taskConfirmProvisioning(DCProgressDto dcProgressDto, CardInfoDataDto cardInfoDataDto, String originator, Long messageHistoryId, PanSourceType panSourceType, String paymentAppInstId, String tokenizationPath, String deviceName) {
        return () -> {
            try {
                confirmProvisioning(dcProgressDto, cardInfoDataDto, originator, messageHistoryId, panSourceType, paymentAppInstId, tokenizationPath, deviceName);
            } catch (ServiceException e) {
                log.error("Error while async process confirmProvisioning", e);
            }
        };
    }

    private void confirmProvisioning(DCProgressDto dcProgressDto, CardInfoDataDto cardInfoDataDto, String originator, Long messageHistoryId, PanSourceType panSourceType, String paymentAppInstId, String tokenizationPath, String deviceName) throws ServiceException {
        JmsConfirmProvisioningResponseDto jmsConfirmProvisioningResponseDto = null;
        synchronized(dcProgressDto) {
            try {
                jmsConfirmProvisioningResponseDto = sendConfirmProvisioning(dcProgressDto, cardInfoDataDto, originator, messageHistoryId, panSourceType, paymentAppInstId, tokenizationPath, deviceName);
                if ("0".equals(jmsConfirmProvisioningResponseDto.getCode())) {
                    dcProgressDto.setProvisioningDecision(ProvisioningDecision.getInstanceByCaption(jmsConfirmProvisioningResponseDto.getDecision()));
                    dcProgressDto.setProvisioningStatus(StringUtils.isNumeric(jmsConfirmProvisioningResponseDto.getCode()) ? DCProgressStatus.values()[Integer.parseInt(jmsConfirmProvisioningResponseDto.getCode())] : null);
                    dcProgressDto.setPanInternalId(jmsConfirmProvisioningResponseDto.getPanInternalId());
                    dcProgressDto.setPanInternalGUID(jmsConfirmProvisioningResponseDto.getPanInternalGUID());
                    dcProgressDto.setCustomerPhone(jmsConfirmProvisioningResponseDto.getCustomerPhone());
                    dcProgressDto.setProductConfigID(jmsConfirmProvisioningResponseDto.getProductConfigID());
                }
            } catch (ServiceException e) {
                dcProgressDto.setProvisioningDecision(ProvisioningDecision.DECL);
                dcProgressDto.setProvisioningError(StandardErrorCodes.valueOf(e.getErrorCode().name()));
            }
        }
        if (jmsConfirmProvisioningResponseDto != null && ("1".equals(jmsConfirmProvisioningResponseDto.getCode()) || "3".equals(jmsConfirmProvisioningResponseDto.getCode()))) {
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }

    }


    private JmsConfirmProvisioningResponseDto sendConfirmProvisioning(DCProgressDto dcProgressDto, CardInfoDataDto cardInfoDataDto, String originator, Long messageHistoryId, PanSourceType panSourceType, String paymentAppInstId, String tokenizationPath, String deviceName) throws ServiceException {
        JmsConfirmProvisioningDto jmsConfirmProvisioningDto = new JmsConfirmProvisioningDto();
        jmsConfirmProvisioningDto.setRequestId(dcProgressDto.getRequestId());
        jmsConfirmProvisioningDto.setConversationId(dcProgressDto.getCorrelationId());
        jmsConfirmProvisioningDto.setPan(cardInfoDataDto.getAccountNumber());
        jmsConfirmProvisioningDto.setExpiryMonth(cardInfoDataDto.getExpiryMonth());
        jmsConfirmProvisioningDto.setExpiryYear(cardInfoDataDto.getExpiryYear());
        jmsConfirmProvisioningDto.setLang("en");
        jmsConfirmProvisioningDto.setPanSource(panSourceType.name());
        jmsConfirmProvisioningDto.setIps(InternationalPaymentSystem.M.name());
        jmsConfirmProvisioningDto.setPaymentAppInstId(paymentAppInstId);
        jmsConfirmProvisioningDto.setTokenRequestorId(dcProgressDto.getTokenRequestorId());
        jmsConfirmProvisioningDto.setTokenizationPath(tokenizationPath);
        jmsConfirmProvisioningDto.setDeviceName(deviceName);

        PAN_FROM_CONFIRM_PROVISIONING = jmsConfirmProvisioningDto.getPan();

        return integrationBus.inOut(() -> originator, "confirmProvisioning",
                new ConfirmProvisioningJmsMessage().confirmProvisioningDto(jmsConfirmProvisioningDto)
                        .originator(originator).messageHistoryId(messageHistoryId), JmsConfirmProvisioningResponseDto.class);
    }

    private Runnable taskVerifyCardStatus(CardInfoDataDto cardInfoDataDto, JmsAuthorizeServiceDto authorizeServiceDto, DCProgressDto dcProgressDto, String originator, Long messageHistoryId) {
        return () -> verifyCardStatus(cardInfoDataDto, authorizeServiceDto, dcProgressDto, originator, messageHistoryId);
    }

    /**
     * Verifies card status.
     */
    private void verifyCardStatus(CardInfoDataDto cardInfoDataDto, JmsAuthorizeServiceDto authorizeServiceDto, DCProgressDto dcProgressDto, String originator, Long messageHistoryId) {
        BinSetupDto binSetupDto = binSetupService.getSuitableBin(cardInfoDataDto.getAccountNumber()).orElse(null);
        boolean sendAsv = defaultSendAsv;
        if(binSetupDto != null){
            sendAsv = binSetupDto.isSendAsv();
        }
        log.info("Start sending ASV request...");
        if(!sendAsv){
            log.warn("ASV request didn't send - BIN_SETUP.sendAsv = false and defaultSendAsv = false");
        }
        if(sendAsv){
            Map<String, String> propertyMap = fePropService.getPropertyMapByNameList(Arrays.asList(FEPropService.PROPERTY_MERCHANT_ID, FEPropService.PROPERTY_TERMINAL_ID));

            JmsCardStatusVerificationDto jmsCardStatusVerificationDto = new JmsCardStatusVerificationDto();
            jmsCardStatusVerificationDto.setMerchantId(propertyMap.get(FEPropService.PROPERTY_MERCHANT_ID));
            jmsCardStatusVerificationDto.setTerminalId(propertyMap.get(FEPropService.PROPERTY_TERMINAL_ID));
            jmsCardStatusVerificationDto.setOrderID(authorizeServiceDto.getPaymentAppInstanceId());
            jmsCardStatusVerificationDto.setCardNum(Long.valueOf(cardInfoDataDto.getAccountNumber()));
            jmsCardStatusVerificationDto.setExpYear("20" + cardInfoDataDto.getExpiryYear());
            jmsCardStatusVerificationDto.setExpMonth(cardInfoDataDto.getExpiryMonth());
            jmsCardStatusVerificationDto.setCvNum(cardInfoDataDto.getSecurityCode());
            jmsCardStatusVerificationDto.setRequestId(authorizeServiceDto.getRequestId());

            HeadersJmsMessage jmsMessage = new CardStatusVerificationJmsMessage()
                    .cardStatusVerificationDto(jmsCardStatusVerificationDto).messageHistoryId(messageHistoryId)
                    .originator(originator);

            synchronized(dcProgressDto) {
                try {
                    Optional<CvcAttemptDto> cvcAttemptDto = Optional.empty();
                    if (StringUtils.isNotBlank(dcProgressDto.getPanInternalId()) && StringUtils.isNotBlank(dcProgressDto.getPanInternalGUID())) {
                        cvcAttemptDto = cvcAttemptService.getByPanInternalIdAndGUID(dcProgressDto.getPanInternalId(), dcProgressDto.getPanInternalGUID());
                    }
                    int cvcAttempt = defaultCvcAttempt;
                    if (binSetupDto != null) {
                        if (binSetupDto.getCvcAttempt() != null) {
                            cvcAttempt = binSetupDto.getCvcAttempt();
                        }
                    }
                    if (!cvcAttemptDto.isPresent() || (cvcAttemptDto.get().getFailures() <= cvcAttempt) || !DateUtils.isSameDay(new Date(), cvcAttemptDto.get().getLastDate())) {
                        if (cvcAttemptDto.isPresent() && (cvcAttemptDto.get().getFailures() >= cvcAttempt) && DateUtils.isSameDay(new Date(), cvcAttemptDto.get().getLastDate())) {
                            log.warn("ASV request not send - CVC_ATTEMPTS didn't pass");
                            dcProgressDto.setAsvStatus(DCProgressStatus.DECLINE);
                            dcProgressDto.setAsvErr(CVC_ATTEMPTS_ERROR);
                            return;
                        }

                        log.info("Sending ASV request");
                        JmsCardStatusVerificationResponseDto jmsCardStatusVerificationResponseDto = integrationBus.inOut(jmsMessage::getOriginator, "cardStatusVerification", jmsMessage, JmsCardStatusVerificationResponseDto.class);

                        // Set ASV_STATUS
                        if ("000".equals(jmsCardStatusVerificationResponseDto.getHostCode()) && "M".equals(jmsCardStatusVerificationResponseDto.getCvResult())) {
                            dcProgressDto.setAsvStatus(DCProgressStatus.SUCCESS);
                        }
                        if (("000".equals(jmsCardStatusVerificationResponseDto.getTranCode()) && "N".equals(jmsCardStatusVerificationResponseDto.getCvResult()))
                                || !"000".equals(jmsCardStatusVerificationResponseDto.getHostCode())) {
                            dcProgressDto.setAsvStatus(DCProgressStatus.DECLINE);
                        }

                        if (jmsCardStatusVerificationResponseDto.getErrorCode() != null) {
                            if (!"000".equals(jmsCardStatusVerificationResponseDto.getErrorCode())) {
                                dcProgressDto.setAsvStatus(DCProgressStatus.DECLINE);
                                dcProgressDto.setAsvErr(CVC_RESULT_ERROR);
                                return;
                            }
                        }

                        if ("000".equals(jmsCardStatusVerificationResponseDto.getTranCode()) && "P".equals(jmsCardStatusVerificationResponseDto.getCvResult())) {
                            dcProgressDto.setAsvStatus(DCProgressStatus.DECLINE);
                            dcProgressDto.setAsvErr(CVC_RESULT_ERROR);
                            return;
                        }

                        if ((cvcAttemptDto.isPresent() && "M".equals(jmsCardStatusVerificationResponseDto.getCvResult())) || (cvcAttemptDto.isPresent() && !DateUtils.isSameDay(new Date(), cvcAttemptDto.get().getLastDate()))) {
                            cvcAttemptService.delete(cvcAttemptDto.get().getId());
                        }
                        if ("N".equals(jmsCardStatusVerificationResponseDto.getCvResult())) {
                            if (!cvcAttemptDto.isPresent()) {
                                String hostCode = jmsCardStatusVerificationResponseDto.getHostCode();
                                boolean isHostCode = hostCode.equals("005");
                                if (!isHostCode) {
                                    cvcAttemptService.save(new CvcAttemptDto(dcProgressDto.getPanInternalId(), dcProgressDto.getPanInternalGUID(), new Date(), 1));
                                }
                            } else {
                                if (DateUtils.isSameDay(new Date(), cvcAttemptDto.get().getLastDate())) {
                                    cvcAttemptDto.get().setFailures(cvcAttemptDto.get().getFailures() + 1);
                                } else {
                                    cvcAttemptDto.get().setLastDate(new Date());
                                    cvcAttemptDto.get().setFailures(1);
                                }
                                cvcAttemptService.save(cvcAttemptDto.get());
                            }
                        }
                    }
                } catch (ServiceException e) {
                    dcProgressDto.setAsvStatus(DCProgressStatus.DECLINE);
                    dcProgressDto.setAsvErr(e.getErrorCode().name());
                }
            }
        }
    }


    private void setCvcResponse(DCProgressDto dcProgressDto, JmsAuthorizeServiceResponseDto responseDto, ProvisioningDecision provisioningDecision) {

        // AsvStatus = SUCCESS And Confirm Provisioning - Host Not Available or Host Timeout
        if (dcProgressDto.getAsvStatus() != null && dcProgressDto.getAsvStatus().isSuccess()
                && dcProgressDto.getProvisioningError() != null && (dcProgressDto.getProvisioningError().isHostNotAvailable() || dcProgressDto.getProvisioningError().isHostTimeout())) {
            responseDto.setCvcResponse("MATCH");
            return;
        }

        if (dcProgressDto.getProvisioningError() != null
                || dcProgressDto.getAsvStatus() == null
                || (dcProgressDto.getAsvErr() != null && dcProgressDto.getAsvErr().equals(CVC_ATTEMPTS_ERROR))
                || (dcProgressDto.getAsvErr() != null && dcProgressDto.getAsvErr().equals(CVC_RESULT_ERROR))) {
            responseDto.setCvcResponse("NOT_PROCESSED");
        } else if ((provisioningDecision != null && provisioningDecision.isDeclined()) || dcProgressDto.getAsvStatus().isDecline()) {
            responseDto.setCvcResponse("INVALID");
        } else if (provisioningDecision != null && !provisioningDecision.isDeclined()) {
            responseDto.setCvcResponse("MATCH");
        }
    }
}
