package com.cts.fasttack.crypto.client.dto;

/**
 * @author d.ishchenko
 */
public class CreateInAppProvisioningDataCryptoResponse {

    private String encryptedPassData;
    private String activationData;
    private String ephemeralPublicKey;
    private String authcode;

    public String getEncryptedPassData() {
        return encryptedPassData;
    }

    public void setEncryptedPassData(String encryptedPassData) {
        this.encryptedPassData = encryptedPassData;
    }

    public String getActivationData() {
        return activationData;
    }

    public void setActivationData(String activationData) {
        this.activationData = activationData;
    }

    public String getEphemeralPublicKey() {
        return ephemeralPublicKey;
    }

    public void setEphemeralPublicKey(String ephemeralPublicKey) {
        this.ephemeralPublicKey = ephemeralPublicKey;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

}
