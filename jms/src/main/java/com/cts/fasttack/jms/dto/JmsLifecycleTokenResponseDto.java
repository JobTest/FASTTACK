package com.cts.fasttack.jms.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsLifecycleTokenResponseDto {

    private String requestId;

    private String code = "0";

    private String errorMessage;

    private List<JmsTokenInfoEventRefDto> tokensInfo = new ArrayList<>();

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<JmsTokenInfoEventRefDto> getTokensInfo() {
        return tokensInfo;
    }

    public void setTokensInfo(List<JmsTokenInfoEventRefDto> tokensInfo) {
        this.tokensInfo = tokensInfo;
    }

    public void addTokenInfo(JmsTokenInfoEventRefDto tokenInfo) {
        this.tokensInfo.add(tokenInfo);
    }
}
