package com.cts.fasttack.mdes.server.dto;

import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dict.RecomendedDecision;
import com.cts.fasttack.common.core.validation.ValidEnum;

/**
 * {@link WalletProviderDecisioningInfo} for {@link AuthorizeServiceRequestDto}.
 * Contains information about the decision recommended by the Wallet Provider
 *
 * @author Dmitry Koval
 */
public class WalletProviderDecisioningInfo {

    /**
     * The decision recommended by the Wallet Provider
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = RecomendedDecision.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String recommendedDecision;

    /**
     * The standards version used by the Wallet Provider to determine the recommended decision
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String recommendationStandardVersion;

    /**
     * Score given to the device by the Wallet Provider
     */
    private Integer deviceScore;

    /**
     * Score given to the account by the Wallet Provider
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String accountScore;

    /**
     * Score given to the phone number by the Wallet Provider
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String phoneNumberScore;

    /**
     * Reasons provided to the Wallet Provider on how the recommended decision was reached
     */
    private String[] recommendationReasons;


    public String getRecommendedDecision() {
        return recommendedDecision;
    }

    public void setRecommendedDecision(String recommendedDecision) {
        this.recommendedDecision = recommendedDecision;
    }

    public String getRecommendationStandardVersion() {
        return recommendationStandardVersion;
    }

    public void setRecommendationStandardVersion(String recommendationStandardVersion) {
        this.recommendationStandardVersion = recommendationStandardVersion;
    }

    public Integer getDeviceScore() {
        return deviceScore;
    }

    public void setDeviceScore(Integer deviceScore) {
        this.deviceScore = deviceScore;
    }

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public String getPhoneNumberScore() {
        return phoneNumberScore;
    }

    public void setPhoneNumberScore(String phoneNumberScore) {
        this.phoneNumberScore = phoneNumberScore;
    }

    public String[] getRecommendationReasons() {
        return recommendationReasons;
    }

    public void setRecommendationReasons(String[] recommendationReasons) {
        this.recommendationReasons = recommendationReasons;
    }
}
