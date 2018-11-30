package com.cts.fasttack.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.dict.TokenEventStatus;

/**
 * @author Dmitry Koval
 */
@Entity
@Table(name = "TOKEN_REASON")
public class TokenReason implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "TOKEN_REASON_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "TOKEN_REASON_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOKEN_REASON_ID_SEQ")
    private Long id = -1L;

    @Column(name = "TOKEN_STATUS_UPDATE_REASON")
    @Enumerated(EnumType.STRING)
    private TokenEventStatus tokenStatusUpdateReason;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "MDES_REASON")
    private String mdesReason;

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

    public TokenEventStatus getTokenStatusUpdateReason() {
        return tokenStatusUpdateReason;
    }

    public void setTokenStatusUpdateReason(TokenEventStatus tokenStatusUpdateReason) {
        this.tokenStatusUpdateReason = tokenStatusUpdateReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMdesReason() {
        return mdesReason;
    }

    public void setMdesReason(String mdesReason) {
        this.mdesReason = mdesReason;
    }
}
