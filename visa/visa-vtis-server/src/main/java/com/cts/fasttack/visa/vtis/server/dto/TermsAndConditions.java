package com.cts.fasttack.visa.vtis.server.dto;

import java.util.Date;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;


/**
 * @author Dmitry Koval
 */
public class TermsAndConditions {

    @Size(max = 64, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String id;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
