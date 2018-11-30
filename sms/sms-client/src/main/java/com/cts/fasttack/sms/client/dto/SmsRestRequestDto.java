package com.cts.fasttack.sms.client.dto;

import java.util.Map;

/**
 * @author Dmitry Koval
 */
public class SmsRestRequestDto {

    private String type;

    private String phone;

    /** Parameters for SMS Message Template */
    private Map<String, Object> templateParameters;

    public SmsRestRequestDto() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, Object> getTemplateParameters() {
        return templateParameters;
    }

    public void setTemplateParameters(Map<String, Object> templateParameters) {
        this.templateParameters = templateParameters;
    }
}
