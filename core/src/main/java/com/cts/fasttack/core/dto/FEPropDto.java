package com.cts.fasttack.core.dto;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.core.data.FEProp;

/**
 * DTO for {@link FEProp}.
 *
 * @author v.semerkov
 */
public class FEPropDto extends IdentifierDto<String> {

    @NotEmpty
    @Size(max = 30)
    private String propName;

    @NotEmpty
    @Size(max = 255)
    private String propValue;

    @Override
    public boolean isNew() {
        return StringUtils.isBlank(getPropName());
    }

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
