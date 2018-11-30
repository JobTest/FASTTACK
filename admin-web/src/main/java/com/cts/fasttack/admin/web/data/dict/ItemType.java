package com.cts.fasttack.admin.web.data.dict;


import com.cts.fasttack.crypto.client.dict.Dict;

public enum ItemType implements Dict {

    CHANGE_LOG,
    ACCESS_LOG,
    ENC_KEY,
    ROLE,
    USER,
    FEPROP,
    TOKEN_INFO,
    TOKEN_HISTORY,
    TOKEN_COMMENT,
    MESSAGE_HISTORY,
    BIN_SETUP,
    CARD_PROPRODUCT;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCaption() {
        return name();
    }


}
