package com.cts.fasttack.admin.web.data.domain;

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
@Table(name = "TOKEN_COMMENT")
public class TokenComment implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "TOKEN_COMMENT_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "TOKEN_COMMENT_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOKEN_COMMENT_ID_SEQ")
    private Long id = -1L;

    @Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    @Column(name = "EVENT_REF")
    private String eventRef;

    @Column(name = "COMDATA")
    private Date comData;

    @Column(name = "COMCONTENT")
    private String comment;

    @Column(name = "USRNAME")
    private String usrname;

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
    }

    public Date getComData() {
        return comData;
    }

    public void setComData(Date comData) {
        this.comData = comData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

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

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }
}
