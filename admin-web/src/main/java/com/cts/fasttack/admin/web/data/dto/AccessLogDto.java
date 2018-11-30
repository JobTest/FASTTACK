package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;

import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AccessLogDto extends IdentifierDto<Long> {

    private String username;

    @JsonSerialize(using = CustomJsonDateSerializer.DateTimeNoSeconds.class)
    private Date accessDate;

    private AccessType accessType;

    private ItemType itemType;

    private String itemId;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

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

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
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

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

}
