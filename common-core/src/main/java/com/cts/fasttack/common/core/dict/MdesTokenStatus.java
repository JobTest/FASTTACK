package com.cts.fasttack.common.core.dict;

import org.apache.commons.lang3.StringUtils;

public enum MdesTokenStatus {
    /**
     * Inactive
     */
    I("U"),
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

    MdesTokenStatus(String code) {
        this.code = code;
    }

    public static MdesTokenStatus valueOfCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        switch (code) {
            case "U":
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
