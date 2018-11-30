package com.cts.fasttack.core.data.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.dict.TokenStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Anton Leliuk
 */
public class TokenInfoViewListFilter extends ListFilter<TokenInfoList> {

    private String pan;

    private String panInternalId;
    private String panInternalGuid;

    private String taxId;
    private String contragentId;
    private String docSr;
    private String docNo;
    private String sName;
    private String name;
    private String tokenRefId;
    private String paymentAppId;
    private boolean showAll;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateTill;

    private List<TokenStatus> statuses = new ArrayList<>();

    private List<String> customerIds = new ArrayList<>();

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getContragentId() {
        return contragentId;
    }

    public void setContragentId(String contragentId) {
        this.contragentId = contragentId;
    }

    public String getDocSr() {
        return docSr;
    }

    public void setDocSr(String docSr) {
        this.docSr = docSr;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getPaymentAppId() {
        return paymentAppId;
    }

    public void setPaymentAppId(String paymentAppId) {
        this.paymentAppId = paymentAppId;
    }

    public boolean isShowAll() {
        return showAll;
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    public List<TokenStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TokenStatus> statuses) {
        this.statuses = statuses;
    }

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTill() {
        return dateTill;
    }

    public void setDateTill(Date dateTill) {
        this.dateTill = dateTill;
    }
}
