package com.cts.fasttack.jms.dto;

/**
 * JMS message DTO for getting token info by wallet info.
 *
 * @author v.semerkov
 */
public class JmsGetTokenByWalletIdMessageDto {

    /**
     * Wallet on device account identifier
     */
    private String clientWalletAccountId;

    /**
     * Customer identifier of the digital wallet provider.
     * Identifier is the initiator ID of the token request (TRID),
     * which is issued to the wallet provider within the onboarding process.
     * Example value: "40000000047"
     */
    private String clientWalletProvider;

    public String getClientWalletAccountId() {
        return clientWalletAccountId;
    }

    public void setClientWalletAccountId(String clientWalletAccountId) {
        this.clientWalletAccountId = clientWalletAccountId;
    }

    public String getClientWalletProvider() {
        return clientWalletProvider;
    }

    public void setClientWalletProvider(String clientWalletProvider) {
        this.clientWalletProvider = clientWalletProvider;
    }
}
