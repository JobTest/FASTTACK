package com.cts.fasttack.visa.common.dict;

/**
 * ActionCode for Visa response
 *
 * @author a.lipavets
 */
public enum ActionCode {
    SUCCESS("00"),
    FAILURE("01");

    ActionCode(String code){
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
