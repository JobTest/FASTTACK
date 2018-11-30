package com.cts.fasttack.core.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Dmitry Koval
 */
@Embeddable
public class TokenHistoryInfoId implements Serializable{

	private static final long serialVersionUID = 5070909091020513725L;

	@Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    public TokenHistoryInfoId() {
    }

    public TokenHistoryInfoId(Long id, String tokenRefId, String tokenRequestorId) {
        this.id = id;
        this.tokenRefId = tokenRefId;
        this.tokenRequestorId = tokenRequestorId;
    }

    public Long getId() {
        return id;
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
