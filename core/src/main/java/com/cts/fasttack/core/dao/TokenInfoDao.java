package com.cts.fasttack.core.dao;

import java.util.List;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.data.list.TokenInfoViewListFilter;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoRestDto;

/**
 * @author a.lipavets
 */
public interface TokenInfoDao extends GenericDao<TokenInfoId, TokenInfo> {

    List<TokenInfo> listByTokenRefId(String tokenRefId);

    /**
     * Returns token info list by wallet info.
     *
     * @param clientWalletAccountId wallet on device account identifier
     * @param clientWalletProvider  customer identifier of the digital wallet provider
     * @return token info list where tokens isn't deleted/deactivated and have card ID or GUID
     */
    List<TokenInfo> listTokensByWalletId(String clientWalletAccountId, String clientWalletProvider);

    List<TokenInfoList> listTokens(TokenInfoViewListFilter filter);

    TokenInfoRestDto getWithDeviceInfo(TokenInfoId tokenInfoId);

    List<TokenInfo> listNotDeletedByPanInternalIdOrGUID(String panInternalId, String panInternalGuid);

    List<TokenInfo> listByPanInternalIdOrGUID(String panInternalId, String panInternalGuid);

    List<TokenInfo> listByIpsAndPanInternalIdOrGUID(InternationalPaymentSystem ips, String panInternalId, String panInternalGuid);

    List<TokenInfoList> listTokenInfoId(List<TokenInfoId> tokenInfoIds);

    List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses, boolean isNull);
}
