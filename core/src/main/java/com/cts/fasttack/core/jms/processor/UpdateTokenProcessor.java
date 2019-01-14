package com.cts.fasttack.core.jms.processor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Date;

import com.cts.fasttack.core.Constants;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.converter.UpdateTokenDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.UpdateTokenJmsMessageToTokenLifecycleIpsConverter;
import com.cts.fasttack.core.converter.UpdateTokenJmsMessageToTokenUpdateMdesConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;
import com.cts.fasttack.jms.dto.JmsCardHolderInfoRequestDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoEventRefDto;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleResponseDto;
import com.cts.fasttack.jms.dto.TokenLifecycleVtsJmsResponseDto;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsMessage;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class UpdateTokenProcessor extends AbstractCamelProcessor<UpdateTokenJmsMessage, UpdateTokenJmsResponse> {

    private Logger logger = LogManager.getLogger(UpdateTokenProcessor.class);

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private UpdateTokenJmsMessageToTokenLifecycleIpsConverter updateTokenJmsMessageToTokenLifecycleIpsConverter;

    @Autowired
    private UpdateTokenDtoToTokenHistoryConverter updateTokenDtoToTokenHistoryConverter;

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private UpdateTokenJmsMessageToTokenUpdateMdesConverter updateTokenJmsMessageToTokenUpdateMdesConverter;


    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, UpdateTokenJmsMessage.class, (UpdateTokenJmsMessage request) -> {
            JmsUpdateTokenDto updateTokenDto = request.getUpdateTokenDto();
            Map<String, String> properties = fePropService.getPropertyMapByNameList(Arrays.asList(FEPropService.PROPERTY_ORG_NAME, FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER));
            if (StringUtils.isNotBlank(updateTokenDto.getTokenRefId())) {
                TokenInfoDto tokenInfoDto = tokenInfoService.getWithDeviceInfo(new TokenInfoId(updateTokenDto.getTokenRefId(), updateTokenDto.getTokenRequestorId()));
                return tokenUpdate(tokenInfoDto, request, properties);
            } else if(StringUtils.isNotBlank(updateTokenDto.getPanInternalId()) || StringUtils.isNotBlank(updateTokenDto.getPanInternalGuid())) {
                List<TokenInfoDto> tokens = tokenInfoService.listNotDeletedByPanInternalIdOrGUID(updateTokenDto.getPanInternalId(), updateTokenDto.getPanInternalGuid());

                if (tokens != null && !tokens.isEmpty()) {
                    UpdateTokenJmsResponse response = new UpdateTokenJmsResponse();
                    InternationalPaymentSystem ips = tokens.get(0).getIps();
                    if (ips.isVisa() && tokens.stream().anyMatch(item -> item.getTokenStatus().isDelete())) {
                        throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND);
                    } else if (ips.isMdes()
                            && (StringUtils.isNotBlank(updateTokenDto.getOldPan())
                            && (StringUtils.isNotBlank(updateTokenDto.getPanInternalId())
                            || StringUtils.isNotBlank(updateTokenDto.getPanInternalGuid()))) && !updateTokenDto.isSkipOldPan()) {
                        throw new ServiceException(StandardErrorCodes.INCOMPATIBLE_FIELDS);
                    }

                    for (TokenInfoDto tokenInfoDto : tokens) {
                        UpdateTokenJmsResponse responseDto = tokenUpdate(tokenInfoDto, request, properties);
                        if ("01".equals(responseDto.getCodeStatus())) {
                            return responseDto;
                        } else {
                            response.getTokensInfo().addAll(responseDto.getTokensInfo());
                        }
                    }
                    return response;
                }
            }

            throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND);
        });
    }


    private UpdateTokenJmsResponse tokenUpdate(TokenInfoDto tokenInfoDto, UpdateTokenJmsMessage request, Map<String, String> properties) throws ServiceException {
        JmsUpdateTokenDto updateTokenDto = request.getUpdateTokenDto();
        if (tokenInfoDto != null) {
            JmsGetCardInfoShortResponseDto bankResponseByPan = getBankResponseByPan(request.getUpdateTokenDto().getNewPan());
            if (bankResponseByPan.getCardID() != null) {
                updateTokenDto.setNewPanInternalId(bankResponseByPan.getCardID());
            }
            if (bankResponseByPan.getCardGUID() != null) {
                updateTokenDto.setNewPanInternalGuid(bankResponseByPan.getCardGUID());
            }

            UpdateTokenJmsResponse response = new UpdateTokenJmsResponse();
            if (tokenInfoDto.getIps().isVisa()) {
                TokenLifecycleVtsJmsResponseDto updateResult = null;

                if (StringUtils.isNotBlank(updateTokenDto.getNewPan())) {

                    updateResult = integrationBus.inOut(() -> "VTS", "tokenLifecycle", createUpdatePan(request, properties), TokenLifecycleVtsJmsResponseDto.class);

                } else if (StringUtils.isNotBlank(updateTokenDto.getNewExpDate())) {

                    updateResult = integrationBus.inOut(() -> "VTS", "tokenLifecycle", createUpdateExpDate(request, properties), TokenLifecycleVtsJmsResponseDto.class);

                } else {
                    response.setCodeStatus("01");
                    response.setMessage(messageSourceService.getMessage("VSE40000"));
                    return response;
                }
                if (updateResult != null) {
                    response.setCodeStatus(updateResult.getActionCode().equals("00") ? "00" : "01");
                    response.setMessage(StringUtils.isNotBlank(updateResult.getErrorCode()) ?
                                        messageSourceService.getMessage(updateResult.getErrorCode()) : null);
                    if (StringUtils.isBlank(updateResult.getErrorCode())) {
                        tokenInfoDto.setMaskedPan(StringUtil.displayPanOrToken(updateTokenDto.getNewPan()));
                        if (updateTokenDto.getNewPanInternalId() != null) {
                            tokenInfoDto.setPanInternalId(updateTokenDto.getNewPanInternalId());
                        }
                        if (updateTokenDto.getNewPanInternalGuid() != null) {
                            tokenInfoDto.setPanInternalGuid(updateTokenDto.getNewPanInternalGuid());
                        }
                        tokenInfoService.save(tokenInfoDto);
                        String eventRef = UUID.randomUUID().toString();
                        tokenHistoryService.save(updateTokenDtoToTokenHistoryConverter.convert(tokenInfoDto, String.valueOf(request.getMessageHistoryId()), eventRef, updateTokenDto.getTokenEventStatus()));
                        response.addTokenInfo(new JmsTokenInfoEventRefDto(tokenInfoDto.getId().getTokenRefId(), tokenInfoDto.getId().getTokenRequestorId(), eventRef));
                    }
                }
                return response;
            } else {
                TokenUpdateMdesJmsResponseDto mdesResponse = integrationBus.inOut(() -> "MDES", "tokenUpdate", createTokenUpdateMdes(request, properties, tokenInfoDto), TokenUpdateMdesJmsResponseDto.class);
                if(mdesResponse != null && mdesResponse.getTokens() != null) {
                    for (TokenLifecycleResponseDto t : mdesResponse.getTokens().getToken()) {
                        List<TokenInfoDto> tokensRes = tokenInfoService.listByTokenRefId(t.getTokenUniqueReference());
                        tokensRes.forEach(tokenInfoDto1 -> {
                            tokenInfoDto1.setMaskedPan(StringUtil.displayPanOrToken(updateTokenDto.getNewPan()));
                            if (updateTokenDto.getNewPanInternalId() != null) {
                                tokenInfoDto1.setPanInternalId(updateTokenDto.getNewPanInternalId());
                            }
                            if (updateTokenDto.getNewPanInternalGuid() != null) {
                                tokenInfoDto1.setPanInternalGuid(updateTokenDto.getNewPanInternalGuid());
                            }
                            if (bankResponseByPan.getPhoneNumber()!= null) {
                                tokenInfoDto1.setCustomerPhone(bankResponseByPan.getPhoneNumber());
                            }
                            tokenInfoDto1.setTokenStatusUpdate(new Date());
                            tokenInfoService.save(tokenInfoDto1);
                        });
                    }
                }
                String eventRef = UUID.randomUUID().toString();
                tokenHistoryService.save(updateTokenDtoToTokenHistoryConverter.convert(tokenInfoDto, String.valueOf(request.getMessageHistoryId()), eventRef, updateTokenDto.getTokenEventStatus()));
                response.addTokenInfo(new JmsTokenInfoEventRefDto(tokenInfoDto.getId().getTokenRefId(), tokenInfoDto.getId().getTokenRequestorId(), eventRef));
                return response;
            }
        } else {
            throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND);
        }
    }

    private JmsCardHolderInfoRequestDto createCardHolderInfo(JmsUpdateTokenDto jmsUpdateTokenDto, TokenStatus tokenStatus) {
        JmsCardHolderInfoRequestDto cardHolderInfoRequestDto = new JmsCardHolderInfoRequestDto();

        String newExpDate;

        StringBuilder data = new StringBuilder();
        switch (tokenStatus) {
            case U_P:
                logger.trace("Start forming encrypted data by event 'Update PAN'");
                if (StringUtils.isNotBlank(jmsUpdateTokenDto.getOldPan())) {
                    data.append("pan=").append(jmsUpdateTokenDto.getOldPan()).append(";");
                    logger.trace("Old PAN: " + jmsUpdateTokenDto.getOldPan());
                }
                if(StringUtils.isNotBlank(jmsUpdateTokenDto.getOldExpDate())) {
                	String oldExpDate = jmsUpdateTokenDto.getOldExpDate().substring(2) + jmsUpdateTokenDto.getOldExpDate().substring(0, 2);
                    data.append("expdt=").append(oldExpDate).append(";");
                    logger.trace("Old Expiry Date: " + oldExpDate);
                }

                if(StringUtils.isNotBlank(jmsUpdateTokenDto.getNewExpDate())) {
            	    newExpDate = jmsUpdateTokenDto.getNewExpDate().substring(2) + jmsUpdateTokenDto.getNewExpDate().substring(0, 2);
                    data.append("expdt2=").append(newExpDate).append(";");
                    logger.trace("New Expiry Date: " + newExpDate);
                }

                data.append("pan2=").append(jmsUpdateTokenDto.getNewPan());
                logger.trace("New PAN: " + jmsUpdateTokenDto.getNewPan());

                logger.trace("Finish forming encrypted data by event 'Update PAN'. Result: '" + data.toString() + "'");
                break;
            case U_EX:
                logger.trace("Start forming encrypted data by event 'Update Expiry Date'");
                if (StringUtils.isNotBlank(jmsUpdateTokenDto.getOldPan())) {
                    data.append("pan=").append(jmsUpdateTokenDto.getOldPan()).append(";");
                    logger.trace("Old PAN: " + jmsUpdateTokenDto.getOldPan());
                }
                if (StringUtils.isNotBlank(jmsUpdateTokenDto.getOldExpDate())) {
                	String oldExpDate = jmsUpdateTokenDto.getOldExpDate().substring(2) + jmsUpdateTokenDto.getOldExpDate().substring(0, 2);
                    data.append("expdt=").append(oldExpDate).append(";");
                    logger.trace("Old Expiry Date: " + oldExpDate);
                }

            	newExpDate = jmsUpdateTokenDto.getNewExpDate().substring(2) + jmsUpdateTokenDto.getNewExpDate().substring(0, 2);
                data.append("expdt2=").append(newExpDate);
                logger.trace("New Expiry Date: " + newExpDate);

                logger.trace("Finish forming encrypted data by event 'Update Expiry Date'. Result: '" + data.toString() + "'");
                break;
            default:
                logger.warn("FIXME: TokenStatus value '" + tokenStatus.name() + "' not supposed to be found here", new Exception());
                break;
        }

        EncryptWithTripleDESCryptoResponseDto responseDto;
        try {
            responseDto = visaCryptoRestClient.encryptWith3desAlgorithm(data.toString());
        } catch (ServiceException e) {
            return cardHolderInfoRequestDto;
        }
        cardHolderInfoRequestDto.setEncryptedData(responseDto.getEncryptedData());
        cardHolderInfoRequestDto.setEncryptionKeyIndex(responseDto.getEncryptionKeyIndex());
        cardHolderInfoRequestDto.setVersion("ws1");
        return cardHolderInfoRequestDto;
    }

    private TokenLifecycleIpsJmsMessage createUpdatePan(UpdateTokenJmsMessage request, Map<String, String> properties) {
        return updateTokenJmsMessageToTokenLifecycleIpsConverter.convert(request, properties, createCardHolderInfo(request.getUpdateTokenDto(), TokenStatus.U_P), TokenStatus.U_P);
    }


    private TokenLifecycleIpsJmsMessage createUpdateExpDate(UpdateTokenJmsMessage request, Map<String, String> properties) {
        return updateTokenJmsMessageToTokenLifecycleIpsConverter.convert(request, properties, createCardHolderInfo(request.getUpdateTokenDto(), TokenStatus.U_EX), TokenStatus.U_EX);
    }


    private TokenUpdateMdesJmsMessage createTokenUpdateMdes(UpdateTokenJmsMessage request, Map<String, String> properties, TokenInfoDto tokenInfoDto) {
        return updateTokenJmsMessageToTokenUpdateMdesConverter.convert(request, properties, tokenInfoDto);
    }

    private JmsGetCardInfoShortResponseDto getBankResponseByPan(String newPan) throws ServiceException {
        JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
        jmsGetCardInfoShortMessageDto.setPan(newPan);
        HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                .originator(Constants.ORIGINATOR);
        return integrationBus.inOut(() -> Constants.ORIGINATOR, "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);
    }
}
