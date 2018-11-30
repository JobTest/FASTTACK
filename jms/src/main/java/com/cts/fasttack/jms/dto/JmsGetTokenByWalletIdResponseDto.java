package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * Response DTO for getting token info by wallet info.
 *
 * @author v.semerkov
 */
public class JmsGetTokenByWalletIdResponseDto {

    private List<JmsCardAndTokenResponseDto> cardAndTokenList;

    public List<JmsCardAndTokenResponseDto> getCardAndTokenList() {
        return cardAndTokenList;
    }

    public void setCardAndTokenList(List<JmsCardAndTokenResponseDto> cardAndTokenList) {
        this.cardAndTokenList = cardAndTokenList;
    }
}
