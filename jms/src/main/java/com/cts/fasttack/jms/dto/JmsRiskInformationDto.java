package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author a.lipavets
 */
public class JmsRiskInformationDto {

    private String wpReasonCodes;

    private String panSource;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String riskAssessmentScore;

    private String tokenProvisioningScore;

    private String finalProvisioningDecision;

    private Date dateAndTimeTokenActivated;

    private String issuerSpecialConditionCodes;

    public String getWpReasonCodes() {
        return wpReasonCodes;
    }

    public void setWpReasonCodes(String wpReasonCodes) {
        this.wpReasonCodes = wpReasonCodes;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getWpDeviceScore() {
        return wpDeviceScore;
    }

    public void setWpDeviceScore(String wpDeviceScore) {
        this.wpDeviceScore = wpDeviceScore;
    }

    public String getWpAccountScore() {
        return wpAccountScore;
    }

    public void setWpAccountScore(String wpAccountScore) {
        this.wpAccountScore = wpAccountScore;
    }

    public String getRiskAssessmentScore() {
        return riskAssessmentScore;
    }

    public void setRiskAssessmentScore(String riskAssessmentScore) {
        this.riskAssessmentScore = riskAssessmentScore;
    }

    public String getTokenProvisioningScore() {
        return tokenProvisioningScore;
    }

    public void setTokenProvisioningScore(String tokenProvisioningScore) {
        this.tokenProvisioningScore = tokenProvisioningScore;
    }

    public String getFinalProvisioningDecision() {
        return finalProvisioningDecision;
    }

    public void setFinalProvisioningDecision(String finalProvisioningDecision) {
        this.finalProvisioningDecision = finalProvisioningDecision;
    }

    public Date getDateAndTimeTokenActivated() {
        return dateAndTimeTokenActivated;
    }

    public void setDateAndTimeTokenActivated(Date dateAndTimeTokenActivated) {
        this.dateAndTimeTokenActivated = dateAndTimeTokenActivated;
    }

    public String getIssuerSpecialConditionCodes() {
        return issuerSpecialConditionCodes;
    }

    public void setIssuerSpecialConditionCodes(String issuerSpecialConditionCodes) {
        this.issuerSpecialConditionCodes = issuerSpecialConditionCodes;
    }
}
