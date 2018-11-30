package com.cts.fasttack.crypto.client.dto;

/**
 * @author a.lipavets
 */
public class VisaCryptoResponseDto {

    private String text;

    public VisaCryptoResponseDto() {}

    public VisaCryptoResponseDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
