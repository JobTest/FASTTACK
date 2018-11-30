package com.cts.fasttack.jms.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;

/**
 * @author Dmitry Koval
 */
public class JmsExpirationDateDto {

    @Size(max = 2, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String month;

    @Size(max = 4, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
