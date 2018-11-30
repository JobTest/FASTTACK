package com.cts.fasttack.logging.domain;

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
import com.cts.fasttack.logging.domain.dict.LogSeverity;
import com.cts.fasttack.logging.dto.ChangeLogItem;

/**
 * Journal requests / responses to changes in objects
 *
 * @author Dmitry Koval
 */
@Entity
@Table(name = "CHANGELOG")
public class ChangeLog implements Identifiable<Long>, ChangeLogItem {

    @Id
    @GenericGenerator(
            name = "CHANGELOG_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CHANGELOG_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHANGELOG_ID_SEQ")
    private Long id = -1L;

    private String action;

    @Column(name = "ITEMTYPE")
    private String itemType;

    @Column(name = "ITEMID")
    private String itemId;

    @Enumerated(EnumType.STRING)
    private LogSeverity severity;

    private String message;

    /**
     * Datetime to request
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt", nullable = false, updatable = false)
    private Date time;

    private String originator;

    private String f1;

    private String f2;

    private String f3;

    private String f4;

    private String f5;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id < 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public void setFields(String[] fields) {
        this.f1 = fields.length > 0 ? fields[0] : null;
        this.f2 = fields.length > 1 ? fields[1] : null;
        this.f3 = fields.length > 2 ? fields[2] : null;
        this.f4 = fields.length > 3 ? fields[3] : null;
        this.f5 = fields.length > 4 ? fields[4] : null;
    }

    public String[] getFields() {
        String[] result = new String[5];
        result[0] = f1;
        result[1] = f2;
        result[2] = f3;
        result[3] = f4;
        result[4] = f5;
        return result;
    }

    public LogSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(LogSeverity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOriginator() {
        return originator;
    }

    @Override
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }
}
