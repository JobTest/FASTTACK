package com.cts.fasttack.crypto.server.data;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.crypto.client.dict.EncKeyCapacityType;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;

/**
 * Набор ключей безопасности для работы системы.
 * Материал – секция “Appendix E – Key Management” в “<a href="https://drive.google.com/file/d/0Bz8D3IpENVf5N2djMk16Tl9Kb2s/view">MCBP - process description</a>”
 * + документ  <a href="https://drive.google.com/file/d/0Bz8D3IpENVf5MVJDc2JBaUFDZ2c/view">“MCBP - Issuer Cryptographic algorithms”</a>
 */
@Entity
@Table(name = "ENCKEY")
public class EncKey implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "ENCKEY_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ENCKEY_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENCKEY_ID_SEQ")
    private Long id = -1L;

    /**
     * Тип ключа
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "KEYTYPE")
    private KeyType keyType;

    /**
     * Идентификатор объекта, который ссылается на ключ. Например, для карточных ключей:
     * NNNNNNNNNN – card BIN or range
     * Количество позиций NN – от 6 до 10. Пример:
     * 676524 – для БИНа
     * 5425871
     * 55230205
     * 532587003
     * 6789850022 – для диапазонов
     */
    @Column(name = "REFCODE")
    private String refCode;

    /**
     * T – test key / P – production key
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "CAPACITY")
    private EncKeyCapacityType capacity;

    /**
     * Статус ключа:
     * 0: Active
     * 1: Expired
     * 2: Future
     * 3: Disabled
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATCODE")
    private EncKeyStatus statusCode;

    /**
     * Зашифрованное значение ключа
     */
    @Column(name = "KEYVALUE")
    private String keyValue;

    /**
     * Проверочное значение ключа
     */
    @Column(name = "CHECKVALUE")
    private String checkValue;

    /**
     * Экспонента публичного ключа. Для остальных ключей поле пустое (null)
     */
    @Column(name = "PUBLICEXPONENT")
    private String publicExponent;

    /**
     * Начало действия ключа
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "EFFDATE")
    private Date effDate;

    /**
     * Конец действия ключа
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPDATE")
    private Date expDate;

    /**
     * ID LMK – ключа в HSM, которым завраплено содержимое данного ключа.
     */
    @Column(name = "WRAPPINGKEY")
    private String wrappingKey;

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    /** @see EncKey#statusCode */
    public EncKeyStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(EncKeyStatus statusCode) {
        this.statusCode = statusCode;
    }

    /** @see EncKey#keyValue */
    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    /** @see EncKey#checkValue */
    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    /** @see EncKey#effDate */
    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    /** @see EncKey#expDate */
    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    /** @see EncKey#wrappingKey */
    public String getWrappingKey() {
        return wrappingKey;
    }

    public void setWrappingKey(String wrappingKey) {
        this.wrappingKey = wrappingKey;
    }

    /** @see EncKey#capacity */
    public EncKeyCapacityType getCapacity() {
        return capacity;
    }

    public void setCapacity(EncKeyCapacityType capacity) {
        this.capacity = capacity;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPublicExponent() {
        return publicExponent;
    }

    public void setPublicExponent(String publicExponent) {
        this.publicExponent = publicExponent;
    }

}
