package com.cts.fasttack.admin.web.data.dto;

import com.cts.fasttack.crypto.client.dict.Dict;
import com.cts.fasttack.common.core.dto.IdentifierDto;

public class PrivilegeDto extends IdentifierDto<String> implements Dict {

	private static final long serialVersionUID = 9143372202126909422L;

	private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public String getCaption() {
        return getId();
    }
}
