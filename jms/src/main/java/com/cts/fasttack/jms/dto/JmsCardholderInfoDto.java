package com.cts.fasttack.jms.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;

/**
 * @author Dmitry Koval
 */
public class JmsCardholderInfoDto {

    @Size(max = 19, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "\\d+", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String primaryAccountNumber;

    @Size(max = 4, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String cvv2;

    @Size(max = 256, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String name;

    @Valid
    private JmsExpirationDateDto expirationDate;

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JmsExpirationDateDto getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(JmsExpirationDateDto expirationDate) {
        this.expirationDate = expirationDate;
    }
}
