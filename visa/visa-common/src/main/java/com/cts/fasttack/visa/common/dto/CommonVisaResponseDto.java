package com.cts.fasttack.visa.common.dto;

import com.cts.fasttack.visa.common.dict.ActionCode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Common Visa response
 *
 * @author a.lipavets
 */
public class CommonVisaResponseDto {

    /**
     * 00 – Success
     * 01 – Failure
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String actionCode = ActionCode.SUCCESS.getCode();

    /**
     * Populate Error code associated with the Action Code
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String errorCode;

    @JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String errorDescription;

    /* getters and setters */

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

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
