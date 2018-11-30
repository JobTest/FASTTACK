package com.cts.fasttack.common.core.dict;

public enum TokenizationPath {
    GREEN("GREEN"),
    RED("RED"),
    YELLOW("YELLOW"),
    ORANGE("ORANGE"),
    ;

    TokenizationPath(String values) {
        this.values = values;
    }

    private String values;

    public String getValues() {
        return values;
    }
}
