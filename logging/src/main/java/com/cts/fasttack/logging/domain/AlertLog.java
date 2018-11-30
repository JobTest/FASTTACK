package com.cts.fasttack.logging.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;

/**
 * Security warnings journal
 *
 * @author Dmitry Koval
 */
@Entity
@Table(name = "ALERTLOG")
public class AlertLog implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "ALERTLOG_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ALERTLOG_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALERTLOG_ID_SEQ")
    private Long id = -1L;

    /**
     * Name event, type
     */
    @Column(name = "event", nullable = false)
    private String event;

    /**
     * Primary data
     */
    @Column(name = "data", nullable = false)
    private String data;

    /**
     * Datetime request
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt", nullable = false, updatable = false)
    private Date date;

    /**
     * System ID - initiator
     */
    @Column(name = "originator", nullable = false)
    private String originator;

    /**
     * User login
     */
    @Column(name = "actuser", nullable = true)
    private String actUser;

    /**
     * Comment of user
     */
    @Column(name = "actdata", nullable = true)
    private String actData;

    /**
     * Date of reaction to the event
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "actdate", nullable = true)
    private Date actDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id < -1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getActUser() {
        return actUser;
    }

    public void setActUser(String actUser) {
        this.actUser = actUser;
    }

    public String getActData() {
        return actData;
    }

    public void setActData(String actData) {
        this.actData = actData;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }
}
