package com.cts.fasttack.admin.web.data.list;

import com.cts.fasttack.admin.web.data.dto.CardReplacementDto;
import com.cts.fasttack.admin.web.util.CustomJsonExpDateDeserializer;
import com.cts.fasttack.admin.web.validation.cardReplacement.ValidateCardReplacement;
import com.cts.fasttack.admin.web.validation.cardReplacement.ValidateCardReplacementExists;
import com.cts.fasttack.admin.web.validation.operation.CardReplacementExistsOperation;
import com.cts.fasttack.common.core.list.ListFilter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@ValidateCardReplacement(message = "{card.replacement.fields.invalid}")
public class CardReplacementFilter extends ListFilter<CardReplacementDto> {

    @NotEmpty(message = "{card.replacement.field.invalid}")
    @Pattern(regexp = "^([\\d]{16}|[\\d]{19})$", message = "{card.accountPan.invalid}")
    @ValidateCardReplacementExists(groups = {CardReplacementExistsOperation.class})
    private String oldPan;

    @JsonDeserialize(using = CustomJsonExpDateDeserializer.class)
    @Pattern(regexp = "^(0[1-9]|1[0-2])[0-9][0-9]$", message = "{card.replacement.expDate.incorrect}")
    private String oldExpDate;

    @Pattern(regexp = "^([\\d]{16}|[\\d]{19})$", message = "{card.accountPan.invalid}")
    @ValidateCardReplacementExists(groups = {CardReplacementExistsOperation.class})
    private String newPan;

    @JsonDeserialize(using = CustomJsonExpDateDeserializer.class)
    @Pattern(regexp = "^(0[1-9]|1[0-2])[0-9][0-9]$", message = "{card.replacement.expDate.incorrect}")
    private String newExpDate;

    @NotEmpty(message = "{card.replacement.ips.invalid}")
    private String ips;

    private String tokenReason;

    private String comment;

    private Boolean updateWalletProviderIndicator;

    private String userId;

    private String userName;

    public String getOldPan() {
        return oldPan;
    }

    public void setOldPan(String oldPan) {
        this.oldPan = oldPan;
    }

    public String getOldExpDate() {
        return oldExpDate;
    }

    public void setOldExpDate(String oldExpDate) {
        this.oldExpDate = oldExpDate;
    }

    public String getNewPan() {
        return newPan;
    }

    public void setNewPan(String newPan) {
        this.newPan = newPan;
    }

    public String getNewExpDate() {
        return newExpDate;
    }

    public void setNewExpDate(String newExpDate) {
        this.newExpDate = newExpDate;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(Boolean updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
