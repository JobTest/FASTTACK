package com.cts.fasttack.core.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author a.lipavets
 */
@Embeddable
public class TokenInfoId implements TokenInfoIdable{

	private static final long serialVersionUID = 3172325629659721161L;

	@Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    public TokenInfoId() {
    }

    public TokenInfoId(String tokenRefId, String tokenRequestorId) {
        this.tokenRefId = tokenRefId;
        this.tokenRequestorId = tokenRequestorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TokenInfoId that = (TokenInfoId) o;

        return new EqualsBuilder()
                .append(tokenRefId, that.tokenRefId)
                .append(tokenRequestorId, that.tokenRequestorId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(tokenRefId)
                .append(tokenRequestorId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "TokenInfoId{" +
                "tokenRefId='" + tokenRefId + '\'' +
                ", tokenRequestorId='" + tokenRequestorId + '\'' +
                '}';
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
