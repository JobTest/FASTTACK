package com.cts.fasttack.admin.web.data.dto;

import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Dmitry Koval
 */
public class TokensUpdateDto {

    @Size(min = 1, message = "{token.list.empty}")
    private List<TokenUpdateDto> tokens;

    @Pattern(regexp = "^([\\d]{16}|[\\d]{19})$", message = "{token.update.pan.invalid}")
    private String newPan;

    @NotEmpty(message = "{token.update.expDate.invalid}")
    @Pattern(regexp = "^(0[1-9]|1[0-2])[0-9][0-9]$", message = "{token.update.expDate.incorrect}")
    private String newExpDate;

    private String tokenReason;

    private String comment;

    private boolean updateWalletProviderIndicator;

    public List<TokenUpdateDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenUpdateDto> tokens) {
        this.tokens = tokens;
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

    public boolean isUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(boolean updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }
}
