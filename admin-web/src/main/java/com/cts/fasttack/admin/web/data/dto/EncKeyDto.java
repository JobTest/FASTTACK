package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.crypto.client.dict.EncKeyCapacityType;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.client.validation.operation.EncKeySaveOperation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Dmitry Koval
 */
//@EncKeyDateCheck(groups = EncKeySaveOperation.class, message = "{enckey.validation.date}", fields = "effDate,expDate")
public class EncKeyDto extends IdentifierDto<Long> {

    @NotNull(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private KeyType keyType;

    @NotEmpty(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private String refCode;

    @NotNull(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private EncKeyCapacityType capacity;

    @NotNull(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private EncKeyStatus statusCode;

    @NotEmpty(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private String keyValue;

    private String checkValue;

    @Size(max = 6, message = "{enckey.validation.common.publicExponent.maxSize}", groups = EncKeySaveOperation.class)
    private String publicExponent;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private Date effDate;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = "{enckey.validation.common.empty}", groups = EncKeySaveOperation.class)
    private Date expDate;

    private String wrappingKey;

    private boolean isNew = false;


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

    public EncKeyCapacityType getCapacity() {
        return capacity;
    }

    public void setCapacity(EncKeyCapacityType capacity) {
        this.capacity = capacity;
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

    public String getPublicExponent() {
        return publicExponent;
    }

    public void setPublicExponent(String publicExponent) {
        this.publicExponent = publicExponent;
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

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
