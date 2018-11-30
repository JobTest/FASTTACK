package com.cts.fasttack.core.dto;

import com.cts.fasttack.common.core.dto.IdentifierDto;

/**
 * DTO конфигурационного параметра bin
 *
 * @author n.bizin
 */
public class BinSetupDto extends IdentifierDto<Long> {

    private Long bin;

    private boolean sendAsv;

    private boolean sendCardTokenized;

    private boolean sendGetCustomerId;

    private Integer cvcAttempt;
    
    private boolean prepaid;
    
    private Integer maxTokensPerCard;

    private boolean isNew = false;

    public Long getBin() {
        return bin;
    }

    public void setBin(Long bin) {
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

    public Integer getCvcAttempt() {
        return cvcAttempt;
    }

    public void setCvcAttempt(Integer cvcAttempt) {
        this.cvcAttempt = cvcAttempt;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

    public Integer getMaxTokensPerCard() {
        return maxTokensPerCard;
    }

    public void setMaxTokensPerCard(Integer maxTokensPerCard) {
        this.maxTokensPerCard = maxTokensPerCard;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

}
