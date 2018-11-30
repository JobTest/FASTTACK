package com.cts.fasttack.core.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.data.list.TokenInfoViewListFilter;
import com.cts.fasttack.core.dict.OsName;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.dto.TokenInfoRestDto;
import com.cts.fasttack.common.core.util.CriteriaUtil;

/**
 * @author a.lipavets
 */
@Repository("tokenInfoDao")
public class TokenInfoDaoImpl extends GenericDaoImpl<TokenInfoId, TokenInfo> implements TokenInfoDao {
    @Override
    public Class<TokenInfo> getEntityClass() {
        return TokenInfo.class;
    }

    @Override
    public List<TokenInfo> listByTokenRefId(String tokenRefId) {
        return ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("id.tokenRefId", tokenRefId))
                .list());
    }

    @Override
    public List<TokenInfo> listTokensByWalletId(String clientWalletAccountId, String clientWalletProvider) {
        return ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("clientWalletAccountId", clientWalletAccountId))
                .add(Restrictions.eq("id.tokenRequestorId", clientWalletProvider))
                .add(Restrictions.in("tokenStatus", TokenStatus.STATUSES_WITHOUT_DELETED))
                .add(Restrictions.or(
                        Restrictions.isNotNull("panInternalId"),
                        Restrictions.isNotNull("panInternalGuid")
                )).list());
    }

    @Override
    public TokenInfoRestDto getWithDeviceInfo(TokenInfoId tokenInfoId) {
        SQLQuery queryTokenInfo = getSession().createSQLQuery(
                "SELECT ti.token_ref_id AS tokenRefId, ti.tokenrequestor_id AS tokenRequestorId, " +
                        "ti.pan_internal_id AS panInternalId, " +
                        "ti.pan_internal_guid AS panInternalGuid, " +
                        "ti.pan_ref_id AS panRefId, " +
                        "ti.masked_pan AS maskedPan, " +
                        "ti.masked_token AS maskedToken, " +
                        "ti.token_expdate AS tokenExpdate, " +
                        "ti.lifecycle_trace_id AS lifecycleTraceId, " +
                        "ti.pan_source AS panSource, " +
                        "ti.active_token_count AS activeTokenCount, " +
                        "ti.token_type AS tokenType, " +
                        "ti.token_status AS tokenStatus, " +
                        "ti.digitize_date AS digitizeDate, " +
                        "ti.token_status_update AS tokenStatusUpdate, " +
                        "ti.customer_id AS customerId, " +
                        "ti.customer_phone AS customerPhone, " +
                        "ti.ips AS ips, " +
                        "ti.client_wallet_account_id AS clientWalletAccountId, " +
                        "ti.bin AS bin, " +
                        "ti.reminder_period AS reminderPeriod, " +
                        "ti.tokenization_path AS tokenizationPath, " +
                        "ti.wp_device_score AS wpDeviceScore, " +
                        "ti.wp_account_score AS wpAccountScore, " +
                        "ti.wp_phonenumber_score AS wpPhonenumberScore, " +
                        "ti.wp_reason_codes AS wpReasonCodes, " +
                        "ti.clr_tokenization_standard_ver AS clrTokenizationStandardVer, " +
                        "di.device_name AS deviceName, " +
                        "di.serial_number AS serialNumber, " +
                        "di.os_name AS osName, " +
                        "di.os_version AS osVersion, " +
                        "di.device_type AS deviceType, " +
                        "di.storage_technology AS storageTechnology, " +
                        "di.imei AS imei FROM token_info ti " +
                        "LEFT JOIN device_info di ON ti.token_ref_id = di.token_ref_id " +
                        "WHERE ti.token_ref_id=:tokenRefId AND ti.tokenrequestor_id=:tokenRequestorId");
        queryTokenInfo.setParameter("tokenRefId", tokenInfoId.getTokenRefId());
        queryTokenInfo.setParameter("tokenRequestorId", tokenInfoId.getTokenRequestorId());
        return (TokenInfoRestDto) queryTokenInfo
                .setResultTransformer(new ResultTransformer() {
					private static final long serialVersionUID = 564348269434999734L;

					@Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        int i = 0;
                        TokenInfoRestDto tokenInfoDto = new TokenInfoRestDto();
                        TokenInfoId tokenInfoId = new TokenInfoId();
                        tokenInfoId.setTokenRefId((String) tuple[i++]);
                        tokenInfoId.setTokenRequestorId((String) tuple[i++]);
                        tokenInfoDto.setId(tokenInfoId);
                        tokenInfoDto.setPanInternalId((String) tuple[i++]);
                        tokenInfoDto.setPanInternalGuid((String) tuple[i++]);
                        tokenInfoDto.setPanRefId((String) tuple[i++]);
                        tokenInfoDto.setMaskedPan((String) tuple[i++]);
                        tokenInfoDto.setMaskedToken((String) tuple[i++]);
                        tokenInfoDto.setTokenExpdate((Date) tuple[i++]);
                        tokenInfoDto.setLifecycleTraceId((String) tuple[i++]);
                        tokenInfoDto.setPanSource(PanSourceType.getInstance((String) tuple[i++]));
                        tokenInfoDto.setActiveTokenCount((String) tuple[i++]);
                        tokenInfoDto.setTokenType(TokenType.getInstance((String) tuple[i++]));
                        tokenInfoDto.setTokenStatus(TokenStatus.getInstance((String) tuple[i++]));
                        tokenInfoDto.setDigitizeDate((Date) tuple[i++]);
                        tokenInfoDto.setTokenStatusUpdate((Date) tuple[i++]);
                        tokenInfoDto.setCustomerId((String) tuple[i++]);
                        tokenInfoDto.setCustomerPhone((String) tuple[i++]);
                        tokenInfoDto.setIps(InternationalPaymentSystem.getInstance((String) tuple[i++]));
                        tokenInfoDto.setClientWalletAccountId((String) tuple[i++]);
                        Object binTuple = tuple[i++];
                        tokenInfoDto.setBin(binTuple != null ? ((BigDecimal) binTuple).longValue() : null);
                        tokenInfoDto.setReminderPeriod((String) tuple[i++]);
                        tokenInfoDto.setTokenizationPath((String) tuple[i++]);
                        tokenInfoDto.setWpDeviceScore((String) tuple[i++]);
                        tokenInfoDto.setWpAccountScore((String) tuple[i++]);
                        tokenInfoDto.setWpPhonenumberScore((String) tuple[i++]);
                        tokenInfoDto.setWpReasonCodes((String) tuple[i++]);
                        tokenInfoDto.setClrTokenizationStandardVer((String) tuple[i++]);
                        DeviceInfoDto deviceInfoDto = new DeviceInfoDto();
                        deviceInfoDto.setTokenRefId(tokenInfoId.getTokenRefId());
                        deviceInfoDto.setDeviceName((String) tuple[i++]);
                        deviceInfoDto.setSerialNumber((String) tuple[i++]);
                        deviceInfoDto.setOsName(OsName.getInstance((String) tuple[i++]));
                        deviceInfoDto.setOsVersion((String) tuple[i++]);
                        deviceInfoDto.setDeviceType((String) tuple[i++]);
                        deviceInfoDto.setStorageTechnology((String) tuple[i++]);
                        deviceInfoDto.setImei((String) tuple[i]);
                        tokenInfoDto.setDeviceInfo(deviceInfoDto);
                        return tokenInfoDto;
                    }

                    @SuppressWarnings("rawtypes")
					@Override
                    public List transformList(List collection) {
                        return collection;
                    }
                }).uniqueResult();
    }
    @Override
    public List<TokenInfoList> listTokens(TokenInfoViewListFilter filter) {
        PageCriteria criteria = createPageCriteria(TokenInfoList.class);
        if(StringUtils.isNotBlank(filter.getPanInternalId())){
            criteria.add(Restrictions.eq("panInternalId", filter.getPanInternalId()));
        }
        if(StringUtils.isNotBlank(filter.getPanInternalGuid())){
            criteria.add(Restrictions.eq("panInternalGuid", filter.getPanInternalGuid()));
        }
        if(StringUtils.isNotBlank(filter.getTokenRefId())) {
            if(filter.isShowAll()) {
                DetachedCriteria dc = DetachedCriteria.forClass(TokenInfo.class);
                dc.setProjection(Projections.property("customerId"));
                dc.add(Restrictions.eq("id.tokenRefId", filter.getTokenRefId()));
                criteria.add(Property.forName("customerId").in(dc));
            } else {
                criteria.add(Restrictions.eq("id.tokenRefId", filter.getTokenRefId()));
            }
        }
        if(StringUtils.isNotBlank(filter.getPaymentAppId())){
            if(filter.isShowAll()) {
                DetachedCriteria dc = DetachedCriteria.forClass(TokenInfo.class);
                dc.setProjection(Projections.property("customerId"))
                        .add(Restrictions.eq("clientWalletAccountId", filter.getPaymentAppId()));
                criteria.add(Property.forName("customerId").in(dc));
            } else {
                criteria.add(Restrictions.eq("clientWalletAccountId", filter.getPaymentAppId()));
            }
        }
        if(!CollectionUtils.isEmpty(filter.getStatuses())){
            criteria.add(Restrictions.in("tokenStatus", filter.getStatuses()));
        }
        if(!CollectionUtils.isEmpty(filter.getCustomerIds())){
            criteria.add(Restrictions.in("customerId", filter.getCustomerIds()));
        }

        if(filter.getDateFrom()!=null && filter.getDateTill()!=null) {
            CriteriaUtil.dateBetween(criteria, "digitizeDate", filter.getDateFrom(), filter.getDateTill());
        }
        return criteria.list(filter);
    }

    @Override
    public List<TokenInfo> listNotDeletedByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) {
        Criteria criteria = createCriteriaByPanInternalIdOrGUID(panInternalId, panInternalGuid);

        return ObjectUtil.uncheckedCast(criteria
                .add(Restrictions.or(Restrictions.isNull("tokenStatus"), Restrictions.in("tokenStatus", TokenStatus.STATUSES_WITHOUT_DELETED)))
                .list());
    }

    @Override
    public List<TokenInfo> listByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) {
        return ObjectUtil.uncheckedCast(createCriteriaByPanInternalIdOrGUID(panInternalId, panInternalGuid).list());
    }

    @Override
    public List<TokenInfo> listByIpsAndPanInternalIdOrGUID(InternationalPaymentSystem ips, String panInternalId, String panInternalGuid) {
        return ObjectUtil.uncheckedCast(createCriteriaByIpsAndPanInternalIdOrGUID(ips, panInternalId, panInternalGuid).list());
    }

    @Override
    public List<TokenInfoList> listTokenInfoId(List<TokenInfoId> tokenInfoIds) {
        return ObjectUtil.uncheckedCast(getSession().createCriteria(TokenInfoList.class)
                .add(Restrictions.in("tokenId", tokenInfoIds))
                .list());
    }

    @Override
    public List<TokenInfo> listByTokenStatus(List<TokenStatus> tokenStatuses, boolean isNull) {
        return ObjectUtil.uncheckedCast(createCriteriaByTokenStatusOrIsNull(tokenStatuses, isNull).list());
    }

    /**
     * Creates criteria by pan internal identifier and/or GUID.
     *
     * @param panInternalId   pan internal identifier
     * @param panInternalGuid pan internal GUID
     * @return {@link Criteria}
     */
    private Criteria createCriteriaByPanInternalIdOrGUID(String panInternalId, String panInternalGuid) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        if (StringUtils.isNotBlank(panInternalId)) {
            criteria.add(Restrictions.eq("panInternalId", panInternalId));
        }
        if (StringUtils.isNotBlank(panInternalGuid)) {
            criteria.add(Restrictions.eq("panInternalGuid", panInternalGuid));
        }
        return criteria;
    }

    /**
     * Creates criteria by ips and pan internal identifier and/or GUID.
     *
     * @param ips
     * @param panInternalId
     * @param panInternalGuid
     * @return {@link Criteria}
     */
    private Criteria createCriteriaByIpsAndPanInternalIdOrGUID(InternationalPaymentSystem ips, String panInternalId, String panInternalGuid) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        if (ips!=null) {
            criteria.add(Restrictions.eq("ips", ips));
        }
        if (StringUtils.isNotBlank(panInternalId)) {
            criteria.add(Restrictions.eq("panInternalId", panInternalId));
        }
        if (StringUtils.isNotBlank(panInternalGuid)) {
            criteria.add(Restrictions.eq("panInternalGuid", panInternalGuid));
        }
        return criteria;
    }

    /**
     Creates criteria by tokenStatus(es) and/or tokenStatus=isNull.
     *
     * @param tokenStatuses
     * @param isNull
     * @return
     */
    private Criteria createCriteriaByTokenStatusOrIsNull(List<TokenStatus> tokenStatuses, boolean isNull) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        if (!tokenStatuses.isEmpty()) {
            if (isNull) {
                criteria.add(Restrictions.or( Restrictions.isNull("tokenStatus"),
                        Restrictions.in("tokenStatus", tokenStatuses)) );
            } else {
                criteria.add(Restrictions.in("tokenStatus", tokenStatuses));
            }
        }
        return criteria;
    }
}
