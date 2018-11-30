package com.cts.fasttack.core.dto;


import com.cts.fasttack.common.core.dto.IdentifierDto;
import org.apache.commons.lang3.StringUtils;

public class TokenRequestorDto extends IdentifierDto<String> {

    private String tokenRequestorId;

    private String tokenRequestorTitle;

    @Override
    public boolean isNew() {
        return StringUtils.isBlank(getTokenRequestorId());
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
