package com.cts.fasttack.crypto.client.dto;

/**
 * @author d.ishchenko
 */
public class TextWithIvAndKeyIndexCryptoRequestDto implements CryptoRequest {

    private String text;
    private String iv;
    private String keyIndex;

    public TextWithIvAndKeyIndexCryptoRequestDto() {}

    public TextWithIvAndKeyIndexCryptoRequestDto(String text, String iv, String keyIndex) {
        this.text = text;
        this.iv = iv;
        this.keyIndex = keyIndex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

	public String getKeyIndex() {
		return keyIndex;
	}

	public void setKeyIndex(String keyIndex) {
		this.keyIndex = keyIndex;
	}

}
