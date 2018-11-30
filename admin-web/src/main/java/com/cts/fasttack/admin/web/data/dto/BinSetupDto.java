package com.cts.fasttack.admin.web.data.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.admin.web.rest.BinSetupRestClient;
import com.cts.fasttack.admin.web.validation.common.UniqueIdentifier;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;

/**
 * DTO конфигурационного параметра bin
 *
 * @author n.bizin
 */
public class BinSetupDto {

    @NotEmpty(message = "{bin.invalid}")
    @Pattern(regexp = "\\d+", message = "{bin.invalid}")
    @UniqueIdentifier(groups = EntityCreateOperation.class, service = BinSetupRestClient.class, message = "{bin.validation.exist.bin}")
    private String bin;

    private boolean sendAsv;

    private boolean sendCardTokenized;

    private boolean sendGetCustomerId;

    @NotEmpty(message = "{bin.cvcAttempt.empty}")
    @Pattern(regexp = "\\d+", message = "{bin.cvcAttempt.invalid}")
    private String cvcAttempt;

    private boolean prepaid;

    @Pattern(regexp = "\\d+", message = "{bin.maxTokensPerCard.invalid}")
    private String maxTokensPerCard;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public boolean isSendAsv() {
        return sendAsv;
    }

    public void setSendAsv(boolean sendAsv) {
        this.sendAsv = sendAsv;
    }

    public boolean isSendCardTokenized() {
        return sendCardTokenized;
    }

    public void setSendCardTokenized(boolean sendCardTokenized) {
        this.sendCardTokenized = sendCardTokenized;
    }

    public boolean isSendGetCustomerId() {
        return sendGetCustomerId;
    }

    public void setSendGetCustomerId(boolean sendGetCustomerId) {
        this.sendGetCustomerId = sendGetCustomerId;
    }

    public String getCvcAttempt() {
        return cvcAttempt;
    }

    public void setCvcAttempt(String cvcAttempt) {
        this.cvcAttempt = cvcAttempt;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

    public String getMaxTokensPerCard() {
        return maxTokensPerCard;
    }

    public void setMaxTokensPerCard(String maxTokensPerCard) {
        this.maxTokensPerCard = maxTokensPerCard;
    }
}
