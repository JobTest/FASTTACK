package com.cts.fasttack.common.core.dict;

public enum DateFormatEnum {
    DATETIME("dd.MM.yyyy HH:mm:ss"),
    DATETIME_NO_SECONDS("dd.MM.yyyy HH:mm"),
    DATETIME_WITHOUT_SEPARATION("yyyyMMddHHmmss"),
    EXPIRE_DATE("MM/yy"),
    EXPIRATION_DATE("MMyy"),
    DATE("dd.MM.yyyy"),
    SLASH_DATE("dd/MM/yyyy"),
    RNS_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ"),
    MDES_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),
    BOG_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ssZ"),
    FEEDBACK_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ss.Z"),
    MINI_STATEMENT_DATE_FORMAT("yyyy-MM-dd HH:mm:ss"),
    BOG_DATE("MMyy"),
    PROVUS_DATE("yyMM"),
    TAV_DATE("MMyy"),
    TRANSACTION_HISTORY_FORMAT("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    VTS_DATETIMEOFEVENT_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    private String value;

    DateFormatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
