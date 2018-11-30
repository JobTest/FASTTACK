package com.cts.fasttack.jms.dto;

/**
 * Response DTO for getting card info.
 *
 * @author v.semerkov
 */
public class JmsGetCardInfoShortResponseDto {

    /**
     * Card identifier
     */
    private String cardID;

    /**
     * Unique card identifier at the bank system
     */
    private String cardGUID;

    /**
     * Customer phone number
     */
    private String phoneNumber;

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardGUID() {
        return cardGUID;
    }

    public void setCardGUID(String cardGUID) {
        this.cardGUID = cardGUID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
