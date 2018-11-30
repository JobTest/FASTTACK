package com.cts.fasttack.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import com.cts.fasttack.common.core.data.Identifiable;

/**
 * Конфигурационный параметр завязанный на BIN карты
 *
 * @author n.bizin
 */
@Entity
@Table(name = "BIN_SETUP")
public class BinSetup implements Identifiable<Long> {

    @Id
    @Column(name = "BIN")
    private Long bin;

    /** Отправлять ASV запрос при получении запроса Authorize Service */
    @Type(type = "boolean")
    @Column(name = "SEND_ASV")
    private boolean sendAsv;

    /** Отправлять Card Tokenized нотификацию в систему банка */
    @Type(type = "boolean")
    @Column(name = "SEND_CARD_TOKENIZED")
    private boolean sendCardTokenized;

    /**
     * Отправлять запрос Get Customer Id
     */
    @Type(type = "boolean")
    @Column(name = "SEND_GET_CUSTOMER_ID")
    private boolean sendGetCustomerId;

    /**
     * Количество попыток ввода CVC кода
     */
    @Column(name="CVC_ATTEMPT")
    private Integer cvcAttempt;

    /**
     * Предназначен ли данный BIN для выпуска предоплаченных карт
     */
    @Type(type = "boolean")
    @Column(name="PREPAID")
    private boolean prepaid;

    /**
     * Максимально разрешенное количество токенизаций для одной карты
     */
    @Column(name="MAX_TOKENS_PER_CARD")
    private Integer maxTokensPerCard;

    @Override
    public Long getId() {
        return bin;
    }

    @Override
    public boolean isNew() {
        return bin == null || bin < 1;
    }

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
}
