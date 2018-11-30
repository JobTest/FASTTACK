package com.cts.fasttack.admin.web.data.domain;

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
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.common.core.data.Identifiable;


/**
 * @author - a.kuzminov
 * Журнал действия операторов административного интерфейса.
 */
@Entity
@Table(name = "ACSLOG")
public class AccessLog implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "ACSLOG_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ACSLOG_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSLOG_ID_SEQ")
    private Long id = -1L;

    /** Login сотрудника */
    @Column(name = "USRNAME", updatable = false)
    private String username;

    /** Дата и время запроса */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACSDATE", updatable = false)
    private Date accessDate;

    /**
     * Тип сущности (карта, банк, и т.д.)
     */
    @Column(name = "ITEMTYPE", updatable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    /**
     * Тип доступа (чтение/запись/изменение/удаление)
     */
    @Column(name = "TYPE", updatable = false)
    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    /** Идентификатор карты */
    @Column(name = "ITEMID", updatable = false)
    private String itemId;

    /** Дополнительные параметры запроса */
    @Column(name = "F1", updatable = false)
    private String field1;

    /** Дополнительные параметры запроса */
    @Column(name = "F2", updatable = false)
    private String field2;

    /** Дополнительные параметры запроса */
    @Column(name = "F3", updatable = false)
    private String field3;

    /** Дополнительные параметры запроса */
    @Column(name = "F4", updatable = false)
    private String field4;

    /** Дополнительные параметры запроса */
    @Column(name = "F5", updatable = false)
    private String field5;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id < 1;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }
}
