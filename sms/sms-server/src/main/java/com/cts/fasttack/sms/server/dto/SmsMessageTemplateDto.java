package com.cts.fasttack.sms.server.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;


/**
 * @author Anton Leliuk
 */
public class SmsMessageTemplateDto extends IdentifierDto<Long> {

    private String type;

    private String template;

    private Date lastModified;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
