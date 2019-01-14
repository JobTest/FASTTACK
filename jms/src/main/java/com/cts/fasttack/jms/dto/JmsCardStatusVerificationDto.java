package com.cts.fasttack.jms.dto;

/**
 * DTO for JMS message for card status verification.
 *
 * @author v.semerkov
 */
public class JmsCardStatusVerificationDto {

    private String requestId;

    /**
     * Merchant unique ID
     */
    private String merchantId;

    /**
     * Terminal unique ID
     */
    private String terminalId;

    /**
     * ID value from message history
     */
    private String orderID;

    /**
     * The Account PAN of the card associated with the service or the token PAN
     */
    private Long cardNum;

    /**
     * The month of the expiration date of the card to be digitized
     */
    private String expMonth;

    /**
     * The year of the expiration date of the card to be digitized
     */
    private String expYear;

    /**
     * CVV2/CVC code
     */
    private String cvNum;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getCvNum() {
        return cvNum;
    }

    public void setCvNum(String cvNum) {
        this.cvNum = cvNum;
    }
}
