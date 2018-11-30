package com.cts.fasttack.crypto.client.dto;

/**
 * @author Anton Leliuk
 */
public class CryptoRequestDto implements CryptoRequest {

    private String text;

    public CryptoRequestDto() {}

    public CryptoRequestDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
