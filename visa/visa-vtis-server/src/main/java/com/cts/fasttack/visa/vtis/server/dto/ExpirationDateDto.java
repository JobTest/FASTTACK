package com.cts.fasttack.visa.vtis.server.dto;

/**
 * @author Dmitry Koval
 */
public class ExpirationDateDto {
    private String month;

    private String year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
