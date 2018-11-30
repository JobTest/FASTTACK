package com.cts.fasttack.core.util;

import com.cts.fasttack.common.core.dict.MdesTokenStatus;
import com.cts.fasttack.common.core.dict.VtsTokenStatus;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.converter.TokenStatusConvert;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenParameters;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.CardProductDto;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.filter.TokenHistoryFilter;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.service.TokenRequestorService;
import com.cts.fasttack.core.service.CardProductService;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.dto.TokenSearchJmsMessage;
import com.cts.fasttack.jms.dto.JmsTokenInquiryDto;
import com.cts.fasttack.jms.dto.JmsTokenSearchRequestDto;
import com.cts.fasttack.jms.dto.JmsAuditInfoDto;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;
import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class TokenHelper {

    private Logger logger = LogManager.getLogger(TokenHelper.class);

    public static final int DIFF_HOURS_NULL = 8760; // `max value`

    public static final String WINDOW_PERIOD_NULL = "0-0"; // `min value`

    public static final String LAST_FOUR_OF_PAN_DEFAULT = "";

    public static final String MASKED_PAN_DELIMITER = "_";

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private TokenRequestorService tokenRequestorService;

    @Autowired
    private TokenParameters tokenParameters;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private CardProductService cardProductService;

    @Value("${spring.customer.notify.token.activated:false}")
    public Boolean isCustomerNotifyToken;

    @Value("${spring.customerPhoneIsRequired.notify.token.activated:true}")
    public Boolean isRequiredCustomerPhone;

    public boolean isSendOnlyForRequestors(String tokenRequestorId) {
        return tokenRequestorService.getOptional(tokenRequestorId)
                .map(tokenRequestorDto -> tokenParameters.getSendOnlyForRequestors().contains(tokenRequestorDto.getTokenRequestorTitle()))
                .orElse(false);
    }

    public JmsTokenInfoResponseDto getCurrentTokenStatus(TokenInfoDto token) throws ServiceException {
        if (token.getIps().isVisa()) {
            HeadersJmsMessage jmsMessage = new TokenInquiryJmsMessage()
                    .tokenInquiryRequestDto(createJmsTokenInquiryDto(token))
                    .originator(tokenParameters.getOriginator());
            return integrationBus.inOut(() -> "VTS", "tokenInfo", jmsMessage, JmsTokenInfoResponseDto.class);
        }

        HeadersJmsMessage jmsMessage = new TokenSearchJmsMessage()
                .jmsTokenSearchRequestDto(createJmsTokenSearchRequestDto(token))
                .originator(tokenParameters.getOriginator());
        return integrationBus.inOut(() -> "MDES", "tokenInfo", jmsMessage, JmsTokenInfoResponseDto.class);
    }

    public JmsTokenInquiryDto createJmsTokenInquiryDto(TokenInfoDto token) {
        String requestID = UUID.randomUUID().toString().replace("-", "");
        JmsTokenInquiryDto tokenInquiryDto = new JmsTokenInquiryDto();
        tokenInquiryDto.setRequestID(requestID);
        tokenInquiryDto.setTokenReferenceID(token.getId().getTokenRefId());
        tokenInquiryDto.setOperatorID(tokenParameters.getOperatorID());
        tokenInquiryDto.setTokenRequestorID(token.getId().getTokenRequestorId());
        return tokenInquiryDto;
    }

    public JmsTokenSearchRequestDto createJmsTokenSearchRequestDto(TokenInfoDto token) {
        JmsTokenSearchRequestDto tokenSearchRequestDto = new JmsTokenSearchRequestDto();
        tokenSearchRequestDto.setTokenUniqueReference(token.getId().getTokenRefId());

        JmsAuditInfoDto auditInfoDto = new JmsAuditInfoDto();
        auditInfoDto.setUserId(tokenParameters.getUserId());
        auditInfoDto.setUserName(tokenParameters.getUserName());
        fePropService.getOptional(FEPropService.PROPERTY_ORG_NAME)
                .ifPresent(fePropDto -> auditInfoDto.setOrganization(fePropDto.getPropValue()));
        auditInfoDto.setPhone(token.getCustomerPhone());
        tokenSearchRequestDto.setAuditInfo(auditInfoDto);
        return tokenSearchRequestDto;
    }

    public JmsSendNotificationToCustomerRequestDto createJmsSendNotificationToCustomerRequestDto(TokenInfoDto tokenInfoDto, String notificationType) {
        JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto = new JmsSendNotificationToCustomerRequestDto();
        jmsSendNotificationToCustomerRequestDto.setRequestId(UUID.randomUUID().toString());
        jmsSendNotificationToCustomerRequestDto.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
        jmsSendNotificationToCustomerRequestDto.setTokenRefId(tokenInfoDto.getId().getTokenRefId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalId(tokenInfoDto.getPanInternalId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalGUID(tokenInfoDto.getPanInternalGuid());
        jmsSendNotificationToCustomerRequestDto.setNotificationType(notificationType);
        jmsSendNotificationToCustomerRequestDto.setLastFourOfPAN(getLastFourOfPAN(tokenInfoDto.getMaskedPan()));
        jmsSendNotificationToCustomerRequestDto.setReminderPeriod(tokenInfoDto.getReminderPeriod());
        jmsSendNotificationToCustomerRequestDto.setCustomerPhone(tokenInfoDto.getCustomerPhone());
        String deviceType = deviceInfoService.getOptional(tokenInfoDto.getId().getTokenRefId())
                .map(deviceInfoDto -> deviceInfoDto.getDeviceType())
                .orElse(null);
        jmsSendNotificationToCustomerRequestDto.setDeviceType(deviceType);

        return jmsSendNotificationToCustomerRequestDto;
    }

    public JmsSendNotificationToCustomerRequestDto createJmsSendNotificationToCustomerRequestDto(TokenInfoDto tokenInfoDto, String notificationType, String customerPhone) {
        JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto = new JmsSendNotificationToCustomerRequestDto();
        jmsSendNotificationToCustomerRequestDto.setRequestId(UUID.randomUUID().toString());
        jmsSendNotificationToCustomerRequestDto.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
        jmsSendNotificationToCustomerRequestDto.setTokenRefId(tokenInfoDto.getId().getTokenRefId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalId(tokenInfoDto.getPanInternalId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalGUID(tokenInfoDto.getPanInternalGuid());
        jmsSendNotificationToCustomerRequestDto.setNotificationType(notificationType);
        jmsSendNotificationToCustomerRequestDto.setLastFourOfPAN(getLastFourOfPAN(tokenInfoDto.getMaskedPan()));
        jmsSendNotificationToCustomerRequestDto.setReminderPeriod(tokenInfoDto.getReminderPeriod());
        jmsSendNotificationToCustomerRequestDto.setCustomerPhone(customerPhone);
        String deviceType = deviceInfoService.getOptional(tokenInfoDto.getId().getTokenRefId())
                .map(deviceInfoDto -> deviceInfoDto.getDeviceType())
                .orElse(null);
        jmsSendNotificationToCustomerRequestDto.setDeviceType(deviceType);

        return jmsSendNotificationToCustomerRequestDto;
    }

    public JmsSendNotificationToCustomerRequestDto createJmsSendCreateNotificationToCustomerRequestDto(TokenInfoDto tokenInfoDto, String notificationType, String customerPhone) {
        JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto = new JmsSendNotificationToCustomerRequestDto();
        jmsSendNotificationToCustomerRequestDto.setRequestId(UUID.randomUUID().toString());
        jmsSendNotificationToCustomerRequestDto.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
        jmsSendNotificationToCustomerRequestDto.setTokenRefId(tokenInfoDto.getId().getTokenRefId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalId(tokenInfoDto.getPanInternalId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalGUID(tokenInfoDto.getPanInternalGuid());
        jmsSendNotificationToCustomerRequestDto.setNotificationType(notificationType);
        jmsSendNotificationToCustomerRequestDto.setLastFourOfPAN(getLastFourOfPAN(tokenInfoDto.getMaskedPan()));
        jmsSendNotificationToCustomerRequestDto.setCustomerPhone(customerPhone);
        String deviceType = deviceInfoService.getOptional(tokenInfoDto.getId().getTokenRefId())
                .map(deviceInfoDto -> deviceInfoDto.getDeviceType())
                .orElse(null);
        jmsSendNotificationToCustomerRequestDto.setDeviceType(deviceType);

        return jmsSendNotificationToCustomerRequestDto;
    }

    public JmsSendNotificationToCustomerRequestDto createJmsSendCreateNotificationToCustomerRequestDto(TokenInfoDto tokenInfoDto, String notificationType) {
        JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto = new JmsSendNotificationToCustomerRequestDto();
        jmsSendNotificationToCustomerRequestDto.setRequestId(UUID.randomUUID().toString());
        jmsSendNotificationToCustomerRequestDto.setTokenRequestorId(tokenInfoDto.getId().getTokenRequestorId());
        jmsSendNotificationToCustomerRequestDto.setTokenRefId(tokenInfoDto.getId().getTokenRefId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalId(tokenInfoDto.getPanInternalId());
        jmsSendNotificationToCustomerRequestDto.setPanInternalGUID(tokenInfoDto.getPanInternalGuid());
        jmsSendNotificationToCustomerRequestDto.setNotificationType(notificationType);
        jmsSendNotificationToCustomerRequestDto.setLastFourOfPAN(getLastFourOfPAN(tokenInfoDto.getMaskedPan()));
        jmsSendNotificationToCustomerRequestDto.setCustomerPhone(tokenInfoDto.getCustomerPhone());
        String deviceType = deviceInfoService.getOptional(tokenInfoDto.getId().getTokenRefId())
                .map(deviceInfoDto -> deviceInfoDto.getDeviceType())
                .orElse(null);
        jmsSendNotificationToCustomerRequestDto.setDeviceType(deviceType);

        return jmsSendNotificationToCustomerRequestDto;
    }

    public String getDiffWindowReminderPeriod(Date startDate) {
        return getDiffWindowReminderPeriod(getDiffHours(startDate));
    }

    public String getDiffWindowReminderPeriod(int diffHours) {
        return tokenParameters.getWindowReminderPeriods().stream()
                .filter(wrp -> wrp.getStart() <= diffHours && diffHours <= wrp.getEnd())
                .map(wrp -> wrp.toString())
                .findFirst()
                .orElse(WINDOW_PERIOD_NULL);
    }

    public int getDiffHours(Date start) {
        return getDiffHours(start, Instant.now());
    }

    public int getDiffHours(Date start, Instant end) {
        return Optional.ofNullable(start)
                .map(tokenStatusUpdate -> new Interval(tokenStatusUpdate.getTime(), Timestamp.from(end).getTime()).toDuration().toStandardHours().getHours())
                .orElse(DIFF_HOURS_NULL);
    }

    public String getLastFourOfPAN(String maskedPan) {
        maskedPan = Optional.ofNullable(maskedPan).orElse(MASKED_PAN_DELIMITER);

        String[] lastFourOfPANs = maskedPan.split(MASKED_PAN_DELIMITER);

        return 1<lastFourOfPANs.length
                ? lastFourOfPANs[1]
                : LAST_FOUR_OF_PAN_DEFAULT;
    }

    public TokenInfoId getTokenInfoId(String tokenUniqueReference, String tokenRequestorId) {
        return new TokenInfoId(tokenUniqueReference, tokenRequestorId);
    }

    public boolean isReminderPeriodToken(TokenInfoDto token, String diffWindowReminderPeriod, boolean isTokenStatus) {
        boolean      isNullReminderPeriod = token.getReminderPeriod() == null;
        boolean   isNotNullReminderPeriod = token.getReminderPeriod() != null;
        boolean isNotEqualsReminderPeriod = isNotNullReminderPeriod && !token.getReminderPeriod().equals(diffWindowReminderPeriod);
        boolean          isReminderPeriod = isNotNullReminderPeriod && isNotEqualsReminderPeriod;

        return isTokenStatus && (isNullReminderPeriod || isReminderPeriod);
    }

    public boolean isApproveReminderPeriodToken(TokenInfoDto token, String reminderPeriod) {
        return getTokenHistories(token, reminderPeriod).getObjects().size() == 0
                ? true
                : false;
    }

    public boolean isWindowReminderPeriod(TokenInfo token, String diffWindowReminderPeriod) {
        return !diffWindowReminderPeriod.equals(WINDOW_PERIOD_NULL) && (token.getReminderPeriod() == null || (token.getReminderPeriod() != null && !token.getReminderPeriod().equals(diffWindowReminderPeriod)));
    }

    public boolean isAfterReminderPeriod(TokenInfo token) {
        return tokenParameters.getDeactivatePeriod() < getDiffHours(token.getTokenStatusUpdate());
    }

    public boolean equalsTokenInfoId(JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto, JmsTokenResponseDto jmsTokenResponseDto) {
        if (jmsSendNotificationToCustomerRequestDto == null) return false;
        if (jmsTokenResponseDto == null) return false;

        TokenInfoId tokenInfoIdRequest = getTokenInfoId(jmsSendNotificationToCustomerRequestDto.getTokenRefId(), jmsSendNotificationToCustomerRequestDto.getTokenRequestorId());
        TokenInfoId tokenInfoIdResponse = getTokenInfoId(jmsTokenResponseDto.getTokenUniqueReference(), jmsTokenResponseDto.getTokenRequestorId());

        return tokenInfoIdRequest.equals(tokenInfoIdResponse);
    }

    public boolean equalsTokenStatus(TokenInfoDto token, TokenInfoDto responseToken, String currentStatusCode) {
        responseToken.setTokenStatus(token.getIps().isMdes()
                ? new TokenStatusConvert().convert(MdesTokenStatus.valueOfCode(currentStatusCode))
                : new TokenStatusConvert().convert(VtsTokenStatus.valueOfCode(currentStatusCode)));

        return responseToken.getTokenStatus() != null && token.getTokenStatus() == responseToken.getTokenStatus();
    }


    public boolean isSendNotificationToCustomer(TokenInfoDto currentTokenInfoDto, TokenInfoDto tokenInfoDto, String customerPhone) {
        if (currentTokenInfoDto.getTokenStatus() == TokenStatus.I && tokenInfoDto.getTokenStatus() == TokenStatus.A) {
            boolean isCurrentCustomerPhone = StringUtils.isNotBlank(currentTokenInfoDto.getCustomerPhone());
            boolean isRestCustomerPhone = StringUtils.isNotBlank(customerPhone);
            if (isRequiredCustomerPhone && (isCurrentCustomerPhone || isRestCustomerPhone))
                return isCustomerNotifyToken;
            else if (!isRequiredCustomerPhone)
                return isCustomerNotifyToken;
        }
        return false;
    }

    //todo visa - currentTokenInfoDto is empty...
    public boolean isSendNotificationToCustomer(TokenInfoDto tokenInfoDto, String customerPhone) {
        if (tokenInfoDto.getTokenStatus() == TokenStatus.A) {
            boolean isCustomerPhone = StringUtils.isNotBlank(customerPhone);
            if (isRequiredCustomerPhone && isCustomerPhone)
                return isCustomerNotifyToken;
            else if (!isRequiredCustomerPhone)
                return isCustomerNotifyToken;
        }
        return false;
    }

    public void tokenUpdateReminderPeriodAndSave(TokenInfoDto token, TokenInfoDto responseToken) {
        token.setTokenExpdate(responseToken.getTokenExpdate());
        token.setTokenStatus(responseToken.getTokenStatus());
        token.setTokenType(responseToken.getTokenType());
        token.setDigitizeDate(responseToken.getDigitizeDate());
        token.setTokenStatusUpdate(responseToken.getTokenStatusUpdate());
        token.setClientWalletAccountId(responseToken.getClientWalletAccountId());
        tokenInfoService.save(token);
    }

    public void saveTokenHistory(String requestId, TokenInfoDto token, String actionCode, String tokenEventType, String reminderPeriod) {
        TokenHistoryDto tokenHistoryDto = GenericBuilder.of(TokenHistoryDto::new)
                .with(TokenHistoryDto::setWprequestId, requestId)
                .with(TokenHistoryDto::setTokenRequestorId, token.getId().getTokenRequestorId())
                .with(TokenHistoryDto::setTokenRefId, token.getId().getTokenRefId())
                .with(TokenHistoryDto::setTokenEventType, tokenEventType)
                .with(TokenHistoryDto::setEventRef, UUID.randomUUID().toString())
                .with(TokenHistoryDto::setTokenEventSource, TokenEventSource.SM.name())
                .with(TokenHistoryDto::setTokenEventDate, new Date())
                .with(TokenHistoryDto::setSuccess, "00".equals(actionCode))
                .with(TokenHistoryDto::setTokenStatus, token.getTokenStatus())
                .with(TokenHistoryDto::setTokenExpdate, token.getTokenExpdate())
                .with(TokenHistoryDto::setReminderPeriod, reminderPeriod)
                .build();
        tokenHistoryService.save(tokenHistoryDto);
    }

    public void saveAlertLog(String originator, String data, String event) {
        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                .with(AlertLogDto::setEvent, event)
                .with(AlertLogDto::setOriginator, originator)
                .with(AlertLogDto::setData, data)
                .with(AlertLogDto::setDate, new Date())
                .build();

        alertLogService.save(alertLogDto);
    }

    public CardProductDto getProductConfigId(Long pan) {
        List<CardProductDto> cardProductDtos = cardProductService.listAll()
                .stream()
                .collect(Collectors.toList());

        Collections.sort(cardProductDtos, new Comparator<CardProductDto>() {
            @Override
            public int compare(CardProductDto o1, CardProductDto o2) {
                if ((o1.getBeginRange() <= o2.getBeginRange() && o2.getEndRange() < o1.getEndRange())
                        || (o1.getBeginRange() < o2.getBeginRange() && o2.getEndRange() <= o1.getEndRange()))
                    return 1;
                if ((o2.getBeginRange() <= o1.getBeginRange() && o1.getEndRange() < o2.getEndRange())
                        || (o2.getBeginRange() < o1.getBeginRange() && o1.getEndRange() <= o2.getEndRange()))
                    return -1;
                return 0;
            }});

        for (CardProductDto cardProductDto : cardProductDtos) {
            if (cardProductDto.getBeginRange() < pan && pan < cardProductDto.getEndRange()) return cardProductDto;
        }
        return null;
    }

    private QueryResult<TokenHistoryList> getTokenHistories(TokenInfoDto token, String reminderPeriod) {
        TokenHistoryFilter tokenHistoryFilter = new TokenHistoryFilter();
        tokenHistoryFilter.setTokenRefId(token.getId().getTokenRefId());
        tokenHistoryFilter.setTokenRequestorId(token.getId().getTokenRequestorId());
        tokenHistoryFilter.setReminderPeriod(reminderPeriod);

        return tokenHistoryService.listTokenHistory(tokenHistoryFilter);
    }
}
