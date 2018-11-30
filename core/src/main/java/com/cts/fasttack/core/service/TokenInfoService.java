package com.cts.fasttack.core.service;

import java.util.List;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.data.list.TokenInfoViewListFilter;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.TokenInfoRestDto;

/**
 * @author a.lipavets
 */
public interface TokenInfoService extends GenericService<TokenInfoId, TokenInfoDto, TokenInfo> {

    List<TokenInfoDto> listByTokenRefId(String tokenRefId);

    /**
     * Returns token info list by wallet info.
     *
     * @param clientWalletAccountId wallet on device account identifier
     * @param clientWalletProvider  customer identifier of the digital wallet provider
     * @return token info list where tokens isn't deleted/deactivated and have card ID or GUID
     */
    List<TokenInfoDto> listTokensByWalletId(String clientWalletAccountId, String clientWalletProvider);

    /**
     * Return Token Info with Device Info
     *
     * @param tokenInfoId
     * @return
     */
    TokenInfoRestDto getWithDeviceInfo(TokenInfoId tokenInfoId);

    QueryResult<TokenInfoList> listTokens(TokenInfoViewListFilter filter) throws ServiceException;

    List<TokenInfoDto> listNotDeletedByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) throws ServiceException;

    List<TokenInfoDto> listByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) throws ServiceException;

    List<TokenInfoDto> listByIpsAndPanInternalIdOrGUID(String ips, String panInternalId, String panInternalGuid) throws ServiceException;

    List<TokenInfoList> listTokenInfoId(List<TokenInfoId> tokenInfoIds);

    List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses) throws ServiceException;

    List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses, boolean isNull) throws ServiceException;
}
