package com.cts.fasttack.common.core.dict;

import org.apache.commons.lang3.StringUtils;

public enum VtsTokenStatus {
    /**
     * Inactive
     */
    I("I"),
    /**
     * Active
     */
    A("A"),
    /**
     * Suspend
     */
    S("S"),
    /**
     * Delete
     */
    D("D"),
    ;

    VtsTokenStatus(String code) {
        this.code = code;
    }

    public static VtsTokenStatus valueOfCode(String code) {
        if (StringUtils.isBlank(code)) return null;
        switch (code) {
            case "I":
                return I;
            case "A":
                return A;
            case "S":
                return S;
            case "D":
                return D;
        }
        return null;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
