package com.cts.fasttack.admin.web.data.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Pattern;

import com.cts.fasttack.admin.web.validation.token.ValidateTokensDateFilter;
import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.admin.web.data.dict.TokenStatus;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.validation.token.ValidateTokensStatusFilter;
import com.cts.fasttack.common.core.list.ListFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Anton Leliuk
 */
@ValidateTokensStatusFilter(message = "{tokens.status-filter.fill.message}")
@ValidateTokensDateFilter(message = "{tokens.date-filter.fill.message}")
public class TokenListFilter extends ListFilter<TokenInfoListDto> {

    @Pattern(regexp = "^([\\d]{16}|[\\d]{19})$", message = "{token.accountPan.invalid}")
    private String pan;

    private List<TokenStatus> statuses = new ArrayList<>();

    @Pattern(regexp = "\\d+", message = "{token.taxId.invalid}")
    private String taxId;

    private String contragentId;

    private String docSr;

    private String docNo;

    private String sName;

    private String name;

    private boolean showAll;

    private String tokenRefId;

    private String paymentAppId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateTill;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public List<TokenStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TokenStatus> statuses) {
        this.statuses = statuses;
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

    public boolean isShowAll() {
        return showAll;
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    public String getPaymentAppId() {
        return paymentAppId;
    }

    public void setPaymentAppId(String paymentAppId) {
        this.paymentAppId = paymentAppId;
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
