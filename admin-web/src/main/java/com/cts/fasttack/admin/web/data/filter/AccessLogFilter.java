package com.cts.fasttack.admin.web.data.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.common.core.list.ListFilter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AccessLogFilter extends ListFilter<AccessLog> {

    private AccessType accessType;

    private String username;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date accessDateFrom;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date accessDateTill;

    private ItemType itemType;

    private String itemId;

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAccessDateFrom() {
        return accessDateFrom;
    }

    public void setAccessDateFrom(Date accessDateFrom) {
        this.accessDateFrom = accessDateFrom;
    }

    public Date getAccessDateTill() {
        return accessDateTill;
    }

    public void setAccessDateTill(Date accessDateTill) {
        this.accessDateTill = accessDateTill;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
