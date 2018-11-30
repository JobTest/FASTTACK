package com.cts.fasttack.jms.dto;

/**
 * Card status verification response DTO from issuer host client.
 *
 * @author v.semerkov
 */
public class JmsCardStatusVerificationResponseDto extends JmsResponseDto {

    /**
     * Merchant unique ID
     */
    private String merchantId;

    /**
     * Terminal unique ID
     */
    private String terminalId;

    /**
     * Retrieval Reference Number
     */
    private String rrn;

    /**
     * CVV2 code checking result
     */
    private String cvResult;

    /**
     * Comment
     */
    private String comment;

    /**
     * Response code from the host (the one with which ECG interacts)
     */
    private String hostCode;


    private String tranCode;

    /**
     * Authorization code
     */
    private String approvalCode;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getCvResult() {
        return cvResult;
    }

    public void setCvResult(String cvResult) {
        this.cvResult = cvResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHostCode() {
        return hostCode;
    }

    public void setHostCode(String hostCode) {
        this.hostCode = hostCode;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
