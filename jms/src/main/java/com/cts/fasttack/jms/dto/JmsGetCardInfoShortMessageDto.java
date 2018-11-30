package com.cts.fasttack.jms.dto;

/**
 * JMS message DTO for getting card info.
 *
 * @author v.semerkov
 */
public class JmsGetCardInfoShortMessageDto {

    private String pan;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
