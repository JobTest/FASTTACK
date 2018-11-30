package com.cts.fasttack.admin.web.data.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.admin.web.rest.FEPropertyRestClient;
import com.cts.fasttack.admin.web.validation.common.UniqueIdentifier;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;

public class FEPropDto {

    @NotEmpty(message = "{feProp.validation.empty.propName}")
    @Size(max = 30)
    @UniqueIdentifier(groups = EntityCreateOperation.class, service = FEPropertyRestClient.class, message = "{feProp.validation.exist.propName}")
    private String propName;

    @NotEmpty(message = "{feProp.validation.empty.propValue}")
    @Size(max = 255)
    private String propValue;

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}
