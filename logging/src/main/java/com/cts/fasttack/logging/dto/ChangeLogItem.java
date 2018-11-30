package com.cts.fasttack.logging.dto;

/**
 * Object change log
 */
public interface ChangeLogItem {

    void setItemType(String itemType);

    void setItemId(String itemId);

    void setFields(String[] fields);

    void setMessage(String message);

    void setOriginator(String originator);
}
