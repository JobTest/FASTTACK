package com.cts.fasttack.core.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.dict.TokenStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.TokenInfoDtoToDomainConverter;
import com.cts.fasttack.core.converter.TokenInfoToDtoConverter;
import com.cts.fasttack.core.dao.TokenInfoDao;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.data.list.TokenInfoViewListFilter;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.TokenInfoRestDto;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.GetCustomerIDJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.jms.dto.JmsSearchContragent2Dto;
import com.cts.fasttack.jms.dto.JmsSearchContragent2ResponseDto;
import com.cts.fasttack.jms.dto.SearchContragent2JmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;

/**
 * @author a.lipavets
 */
@Service("tokenInfoService")
public class TokenInfoServiceImpl extends GenericServiceImpl<TokenInfoId, TokenInfoDto, TokenInfo, TokenInfoDao> implements TokenInfoService {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenRequestorService tokenRequestorService;

    @Autowired
    public TokenInfoServiceImpl(TokenInfoDao dao, TokenInfoToDtoConverter domainToDtoConverter, TokenInfoDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoDto> listByTokenRefId(String tokenRefId) {
        return domainToDtoConverter.convert(dao.listByTokenRefId(tokenRefId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoDto> listTokensByWalletId(String clientWalletAccountId, String clientWalletProvider) {
        return domainToDtoConverter.convert(dao.listTokensByWalletId(clientWalletAccountId, clientWalletProvider));
    }

    @Override
    @Transactional(readOnly = true)
    public TokenInfoRestDto getWithDeviceInfo(TokenInfoId tokenInfoId) {
        TokenInfoRestDto getWithDeviceInfo = dao.getWithDeviceInfo(tokenInfoId);

        if (getWithDeviceInfo!=null) {
            String tokenRequestorTitle = tokenRequestorService.getOptional(getWithDeviceInfo.getId().getTokenRequestorId())
                    .map(tokenRequestorDto -> tokenRequestorDto.getTokenRequestorTitle())
                    .orElse(null);
            getWithDeviceInfo.setTokenRequestorTitle(tokenRequestorTitle);
        }
        return getWithDeviceInfo;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<TokenInfoList> listTokens(TokenInfoViewListFilter filter) throws ServiceException {
        if(StringUtils.isNotBlank(filter.getPan())){
            if(filter.isShowAll()) {
                JmsGetCustomerIDMessageDto getCustomerIDMessageDto = new JmsGetCustomerIDMessageDto();
                getCustomerIDMessageDto.setCardNum(filter.getPan());
                HeadersJmsMessage jmsMessage = new GetCustomerIDJmsMessage()
                        .getCustomerIdentifier(getCustomerIDMessageDto)
                        .originator(Constants.ORIGINATOR);
                JmsGetCustomerIDResponseDto jmsGetCustomerIDResponseDto = integrationBus.inOut(() -> Constants.ORIGINATOR, "customerIdentifier", jmsMessage, JmsGetCustomerIDResponseDto.class);
                if(StringUtils.isBlank(jmsGetCustomerIDResponseDto.getCustomerID())) {
                    return new QueryResult<>(new ArrayList<>(), filter);
                }
                filter.setCustomerIds(Collections.singletonList(jmsGetCustomerIDResponseDto.getCustomerID()));
            } else {
                JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
                jmsGetCardInfoShortMessageDto.setPan(filter.getPan());
                HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                        .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                        .originator(Constants.ORIGINATOR);
                JmsGetCardInfoShortResponseDto res = integrationBus.inOut(() -> Constants.ORIGINATOR, "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);
                if(StringUtils.isBlank(res.getCardGUID()) && StringUtils.isBlank(res.getCardID())){
                    return new QueryResult<>(new ArrayList<>(), filter);
                }
                filter.setPanInternalId(res.getCardID());
                filter.setPanInternalGuid(res.getCardGUID());
            }
        }


        if(StringUtils.isNotBlank(filter.getTaxId()) || StringUtils.isNotBlank(filter.getDocNo()) || StringUtils.isNotBlank(filter.getContragentId())) {
            JmsSearchContragent2Dto jmsDto = new JmsSearchContragent2Dto();
            jmsDto.setTaxId(filter.getTaxId());
            jmsDto.setContragentCategory("3");
            jmsDto.setContragentId(filter.getContragentId());
            jmsDto.setDocNo(filter.getDocNo());
            jmsDto.setDocSr(filter.getDocSr());
            jmsDto.setName(filter.getName());
            jmsDto.setsName(filter.getsName());
            HeadersJmsMessage jmsMessage = new SearchContragent2JmsMessage()
                    .searchContragent2Dto(jmsDto)
                    .originator(Constants.ORIGINATOR);
            JmsSearchContragent2ResponseDto res = integrationBus.inOut(() -> Constants.ORIGINATOR, "searchContragent2", jmsMessage, JmsSearchContragent2ResponseDto.class);
            if(CollectionUtils.isEmpty(res.getContragentId())){
                return new QueryResult<>(new ArrayList<>(), filter);
            }
            filter.setCustomerIds(res.getContragentId());
        }

        final List<TokenInfoList> listTokens = dao.listTokens(filter);
        for (TokenInfoList listToken: listTokens) {
            String tokenRequestorTitle = tokenRequestorService.getOptional(listToken.getTokenId().getTokenRequestorId())
                    .map(tokenRequestorDto -> tokenRequestorDto.getTokenRequestorTitle())
                    .orElse(null);
            listToken.setTokenRequestorTitle(tokenRequestorTitle);
        }
        return new QueryResult<>(listTokens, filter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoDto> listNotDeletedByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) throws ServiceException {
        return domainToDtoConverter.convert(dao.listNotDeletedByPanInternalIdOrGUID(panInternalId, panInternalGuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoDto> listByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) throws ServiceException {
        return domainToDtoConverter.convert(dao.listByPanInternalIdOrGUID(panInternalId, panInternalGuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoDto> listByIpsAndPanInternalIdOrGUID(String ips, String panInternalId, String panInternalGuid) throws ServiceException {
        return domainToDtoConverter.convert(dao.listByIpsAndPanInternalIdOrGUID(InternationalPaymentSystem.getInstance(ips), panInternalId, panInternalGuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfoList> listTokenInfoId(List<TokenInfoId> tokenInfoIds) {
        return dao.listTokenInfoId(tokenInfoIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses) throws ServiceException {
        return listByTokenStatus(tokenStatuses, false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses, boolean isNull) throws ServiceException {
        return dao.listByTokenStatus(tokenStatuses, isNull);
    }
}
