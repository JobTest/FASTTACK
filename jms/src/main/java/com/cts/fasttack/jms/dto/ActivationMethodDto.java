package com.cts.fasttack.jms.dto;

/**
 * For response Authorize Service
 *
 * @author Dmitry Koval
 */
public class ActivationMethodDto {

    /**
     * Specifies the activation method type
     */
    private String type;

    /**
     * Specifies the activation method value (meaning varies depending on the activation method type)
     */
    private String value;

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
