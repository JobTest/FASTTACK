package com.cts.fasttack.jms.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.dict.VisaTokenStatus;
import com.cts.fasttack.common.core.dict.VisaTokenType;
import com.cts.fasttack.common.core.validation.Minimal;
import com.cts.fasttack.common.core.validation.ValidEnum;

/**
 * @author Dmitry Koval
 */
public class JmsTokenInfoDto {

    @Size(max = 19, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "\\d+", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String token;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @ValidEnum(enumType = VisaTokenType.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String tokenType;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @ValidEnum(enumType = VisaTokenStatus.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String tokenStatus;

    @Valid
    private JmsExpirationDateDto tokenExpirationDate;

    @Size(max = 2, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String tokenAssuranceLevel;

    @Size(max = 4, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|$^", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String numberOfActiveTokensForPAN;

    @Size(max = 4, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|$^", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String numberOfInactiveTokensForPAN;

    @Size(max = 4, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|$^", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String numberOfSuspendedTokensForPAN;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public JmsExpirationDateDto getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(JmsExpirationDateDto tokenExpirationDate) {
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
