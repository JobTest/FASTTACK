package com.cts.fasttack.bank.server.pushprovisioning.dto;

import com.cts.fasttack.bank.server.pushprovisioning.dict.Intent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public class PaymentInstrumentProvider {

    private Intent intent;
    private String clientWalletProvider;
    private String clientWalletAccountID;
    private String clientDeviceID;
    private String clientAppID;

    private boolean isIDnV;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getClientWalletProvider() {
        return clientWalletProvider;
    }

    public void setClientWalletProvider(String clientWalletProvider) {
        this.clientWalletProvider = clientWalletProvider;
    }

    public String getClientWalletAccountID() {
        return clientWalletAccountID;
    }

    public void setClientWalletAccountID(String clientWalletAccountID) {
        this.clientWalletAccountID = clientWalletAccountID;
    }

    public String getClientDeviceID() {
        return clientDeviceID;
    }

    public void setClientDeviceID(String clientDeviceID) {
        this.clientDeviceID = clientDeviceID;
    }

    public String getClientAppID() {
        return clientAppID;
    }

    public void setClientAppID(String clientAppID) {
        this.clientAppID = clientAppID;
    }

    @JsonProperty("isIDnV")
    public boolean isIDnV() {
        return isIDnV;
    }

    public void setIDnV(boolean IDnV) {
        isIDnV = IDnV;
    }
}
