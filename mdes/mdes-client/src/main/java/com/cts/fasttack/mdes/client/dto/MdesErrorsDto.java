package com.cts.fasttack.mdes.client.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "Errors")
@XmlAccessorType(XmlAccessType.FIELD)
public class MdesErrorsDto {

    @JsonProperty("Error")
    @XmlElement(name = "Error")
    private List<MdesErrorDto> errors;

    public List<MdesErrorDto> getErrors() {
        return errors;
    }

    public MdesErrorDto getFirstError() {
        return errors != null && errors.size() != 0 ? errors.get(0) : null;
    }

    public void setErrors(List<MdesErrorDto> errors) {
        this.errors = errors;
    }
}
