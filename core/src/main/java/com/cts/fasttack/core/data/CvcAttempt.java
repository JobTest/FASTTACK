package com.cts.fasttack.core.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;

/**
 * @author Dmitry Koval
 */
@Entity
@Table(name = "CVC_ATTEMPT")
public class CvcAttempt implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "CVC_ATTEMPT_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CVC_ATTEMPT_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CVC_ATTEMPT_ID_SEQ")
    private Long id = -1L;

    @Column(name = "FAILURES")
    private Integer failures;

    @Column(name = "LASTDATE")
    private Date lastDate;

    @Column(name = "PAN_INTERNAL_ID")
    private String panInternalID;

    @Column(name = "PAN_INTERNAL_GUID")
    private String panInternalGUID;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getFailures() {
        return failures;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getPanInternalID() {
        return panInternalID;
    }

    public void setPanInternalID(String panInternalID) {
        this.panInternalID = panInternalID;
    }

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }
}
