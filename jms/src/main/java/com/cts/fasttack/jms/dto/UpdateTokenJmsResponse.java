package com.cts.fasttack.jms.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Koval
 */
public class UpdateTokenJmsResponse {

    private String codeStatus = "00";

    private String message;

    private List<JmsTokenInfoEventRefDto> tokensInfo = new ArrayList<>();

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addTokenInfo(JmsTokenInfoEventRefDto tokenInfo){
        this.tokensInfo.add(tokenInfo);
    }

    public List<JmsTokenInfoEventRefDto> getTokensInfo() {
        return tokensInfo;
    }

    public void setTokensInfo(List<JmsTokenInfoEventRefDto> tokensInfo) {
        this.tokensInfo = tokensInfo;
    }
}
