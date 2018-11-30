package com.cts.fasttack.logging.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;

/**
 * Dto for {@link com.cts.fasttack.logging.domain.AlertLog}
 *
 * @author d.koval
 */
public class AlertLogDto extends IdentifierDto<Long> {

    private String event;

    private String data;

    private Date date;

    private String originator;

    private String actUser;

    private String actData;

    private Date actDate;

    public AlertLogDto() {
        setId(-1L);
        setDate(new Date());
    }

    public AlertLogDto event(String event) {
        this.event = event;
        return this;
    }

    public AlertLogDto data(String data) {
        this.data = data;
        return this;
    }

    public AlertLogDto originator(String originator) {
        this.originator = originator;
        return this;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getActUser() {
        return actUser;
    }

    public void setActUser(String actUser) {
        this.actUser = actUser;
    }

    public String getActData() {
        return actData;
    }

    public void setActData(String actData) {
        this.actData = actData;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }
}
