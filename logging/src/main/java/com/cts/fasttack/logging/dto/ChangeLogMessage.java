package com.cts.fasttack.logging.dto;


import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.service.ChangeLogFiller;

/**
 * Container of log data
 */
public class ChangeLogMessage implements ChangeLogFiller {

    private String itemType;

    private String itemId;

    private String message;

    private String bankId;

    private String[] fields = new String[5];

    private String originator;

    public ChangeLogMessage(String itemType, String itemId) {
        this(itemType, itemId, null);
    }

    public ChangeLogMessage(String itemType, String itemId, String message) {
        this.itemType = itemType;
        this.itemId = itemId;
        this.message = message;
    }

    public ChangeLogMessage fields(String... fields) {
        this.fields = fields;
        return this;
    }

    public ChangeLogMessage originator(String originator) {
        this.originator = originator;
        return this;
    }

    public ChangeLogMessage message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public void fill(ChangeLogItem item) {
        item.setItemType(this.itemType);
        item.setItemId(this.itemId);
        item.setMessage(this.message);
        item.setFields(substringFields(this.fields));
        item.setOriginator(this.originator);
    }

    /**
     * Если значение поля field больше 255 тогда берем первые 200 символов потом "..." и последние 50 символов
     */
    private String[] substringFields(String[] fields) {
        String[] newFields = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            newFields[i] = StringUtil.substringLimitInBytes(fields[i], 200, 50);
        }
        return newFields;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }
}
