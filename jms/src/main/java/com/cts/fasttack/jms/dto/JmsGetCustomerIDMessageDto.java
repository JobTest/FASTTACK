package com.cts.fasttack.jms.dto;

/**
 * DTO for JMS message for getting customer ID either by cardID, cardNum, hashNum or cardGUID.
 *
 * @author v.semerkov
 */
public class JmsGetCustomerIDMessageDto {

    /**
     * Card identifier
     */
    private String cardID;

    /**
     * Card number (PAN)
     */
    private String cardNum;

    /**
     * Card hash
     */
    private String hashNum;

    /**
     * Unique card identifier at the bank system
     */
    private String cardGUID;

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getHashNum() {
        return hashNum;
    }

    public void setHashNum(String hashNum) {
        this.hashNum = hashNum;
    }

    public String getCardGUID() {
        return cardGUID;
    }

    public void setCardGUID(String cardGUID) {
        this.cardGUID = cardGUID;
    }
}
