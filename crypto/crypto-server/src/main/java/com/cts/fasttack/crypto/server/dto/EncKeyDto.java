package com.cts.fasttack.crypto.server.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.crypto.client.dict.EncKeyCapacityType;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyValueHolder;

/**
 * DTO для {@link com.cts.fasttack.crypto.server.data.EncKey}, содержит все поля.
 */
public class EncKeyDto extends IdentifierDto<Long> implements EncKeyValueHolder {

    private KeyType keyType;

    private String refCode;

    private EncKeyCapacityType capacity;

    private EncKeyStatus statusCode;

    private String keyValue;

    private String checkValue;

    private String publicExponent;

    private Date effDate;

    private Date expDate;

    private String wrappingKey;

    private boolean isNew = false;

    public EncKeyDto() {
    }

    public EncKeyDto(KeyType keyType, String refCode, String keyValue) {
        this.keyType = keyType;
        this.refCode = refCode;
        this.keyValue = keyValue;
    }

    public EncKeyStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(EncKeyStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getWrappingKey() {
        return wrappingKey;
    }

    public void setWrappingKey(String wrappingKey) {
        this.wrappingKey = wrappingKey;
    }

    public EncKeyCapacityType getCapacity() {
        return capacity;
    }

    public void setCapacity(EncKeyCapacityType capacity) {
        this.capacity = capacity;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    @Override
    public String getPublicExponent() {
        return publicExponent;
    }

    public void setPublicExponent(String publicExponent) {
        this.publicExponent = publicExponent;
    }
}
