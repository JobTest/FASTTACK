package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsTokenInquiryResponseDto {

    private String actionCode;

    private String errorCode;

    private List<JmsTokenDetailsDto> tokenDetails;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<JmsTokenDetailsDto> getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(List<JmsTokenDetailsDto> tokenDetails) {
        this.tokenDetails = tokenDetails;
    }
}
