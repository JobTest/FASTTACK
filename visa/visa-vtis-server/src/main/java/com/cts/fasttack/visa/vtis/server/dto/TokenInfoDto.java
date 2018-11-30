package com.cts.fasttack.visa.vtis.server.dto;


import com.cts.fasttack.common.core.dict.VisaTokenStatus;
import com.cts.fasttack.common.core.dict.VisaTokenType;

/**
 * @author Dmitry Koval
 */
public class TokenInfoDto {

    private String token;

    private VisaTokenType tokenType;

    private VisaTokenStatus tokenStatus;

    private ExpirationDateDto tokenExpirationDate;

    private String tokenAssuranceLevel;

    private String numberOfActiveTokensForPAN;

    private String numberOfInactiveTokensForPAN;

    private String numberOfSuspendedTokensForPAN;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public VisaTokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(VisaTokenType tokenType) {
        this.tokenType = tokenType;
    }

    public VisaTokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(VisaTokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public ExpirationDateDto getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(ExpirationDateDto tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public String getTokenAssuranceLevel() {
        return tokenAssuranceLevel;
    }

    public void setTokenAssuranceLevel(String tokenAssuranceLevel) {
        this.tokenAssuranceLevel = tokenAssuranceLevel;
    }

    public String getNumberOfActiveTokensForPAN() {
        return numberOfActiveTokensForPAN;
    }

    public void setNumberOfActiveTokensForPAN(String numberOfActiveTokensForPAN) {
        this.numberOfActiveTokensForPAN = numberOfActiveTokensForPAN;
    }

    public String getNumberOfInactiveTokensForPAN() {
        return numberOfInactiveTokensForPAN;
    }

    public void setNumberOfInactiveTokensForPAN(String numberOfInactiveTokensForPAN) {
        this.numberOfInactiveTokensForPAN = numberOfInactiveTokensForPAN;
    }

    public String getNumberOfSuspendedTokensForPAN() {
        return numberOfSuspendedTokensForPAN;
    }

    public void setNumberOfSuspendedTokensForPAN(String numberOfSuspendedTokensForPAN) {
        this.numberOfSuspendedTokensForPAN = numberOfSuspendedTokensForPAN;
    }
}
