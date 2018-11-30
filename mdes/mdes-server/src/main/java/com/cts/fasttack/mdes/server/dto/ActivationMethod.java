package com.cts.fasttack.mdes.server.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dict.ActivationMethodType;
import com.cts.fasttack.common.core.validation.ValidEnum;

/**
 * @author a.lipavets
 */
public class ActivationMethod {

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = ActivationMethodType.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String type;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String value;

    /** getters and setters*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
