package com.cts.fasttack.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = "TOKEN_REQUESTOR")
public class TokenRequestor implements Identifiable<String> {

    @Id
    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    @Column(name = "TOKENREQUESTOR_TITLE")
    private String tokenRequestorTitle;

    @Transient
    private boolean isNew = false;

    @Override
    public String getId() {
        return tokenRequestorId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getTokenRequestorTitle() {
        return tokenRequestorTitle;
    }

    public void setTokenRequestorTitle(String tokenRequestorTitle) {
        this.tokenRequestorTitle = tokenRequestorTitle;
    }
}
