package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author Dmitry Koval
 */
public class JmsTermsAndConditions {

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
