package com.cts.fasttack.core.dict;

import org.apache.commons.lang3.StringUtils;

/**
 * Token status
 *
 * @author a.lipavets
 */
public enum TokenStatus {
    /**
     * Inactive
     */
    I(3703),
    /**
     * Active
     */
    A(3713),
    /**
     * Suspend
     */
    S(3702),
    /**
     * Delete
     */
    D(3701),
    /**
     * Resume
     */
    R(3703),

    /**
     * Update Pan
     */
    U_P(3721),

    /**
     * Update Expiry Date
     */
    U_EX(3720);

    public static final TokenStatus[] STATUSES_WITHOUT_DELETED =  new TokenStatus[]{I, A, S, R};

    private int vtsReasonCode;

    TokenStatus(int vtsReasonCode) {
        this.vtsReasonCode = vtsReasonCode;
    }

    public int getVtsReasonCode() {
        return vtsReasonCode;
    }

    public static TokenStatus valueOfFirstWord(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        switch (value) {
            case "INACTIVE":
                return I;
            case "ACTIVE":
            case "ACTIVATE":
                return A;
            case "SUSPENDED":
            case "SUSPEND":
                return S;
            case "DEACTIVATED":
            case "DELETE":
                return D;
            case "RESUME":
                return R;
            case "UPDATE_PAN":
                return U_P;
            case "UPDATE_EXP":
                return U_EX;
        }
        return null;
    }

    public static TokenStatus getInstance(String key){
        for(TokenStatus s : values()){
            if(s.name().equals(key)){
                return s;
            }
        }
        return null;
    }

    public boolean isResume(){
        return this == R;
    }

    public boolean isDelete() {
        return this == D;
    }
}
