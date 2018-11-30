package com.cts.fasttack.logging.domain.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ChangeLogFilter extends ListFilter<ChangeLog> {

    private String action;

    private String itemType;

    private String itemId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateTill;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTill() {
        return dateTill;
    }

    public void setDateTill(Date dateTill) {
        this.dateTill = dateTill;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
