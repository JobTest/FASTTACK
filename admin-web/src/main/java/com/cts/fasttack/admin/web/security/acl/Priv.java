package com.cts.fasttack.admin.web.security.acl;

public class Priv {

    private String code;

    private String name;

    public Priv(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
