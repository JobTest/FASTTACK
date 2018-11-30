package com.cts.fasttack.core.dict;

import org.apache.commons.lang3.StringUtils;

/**
 * Valid Token Types
 *
 * @author a.lipavets
 */
public enum TokenType {
    /**
     * E-commerce
     */
    E,
    /**
     * Card on File
     */
    C,
    /**
     * Secure Element
     */
    S,
    /**
     * HCE
     */
    H;

    public static TokenType valueOfFirstWord(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        switch (value) {
            case "ECOMMERCE":
                return E;
            case "CARD_ON_FILE":
                return C;
            case "SECURE_ELEMENT":
                return S;
            case "HCE":
                return H;
        }
        return null;
    }

    public static TokenType getInstance(String key){
        for(TokenType t : values()){
            if(t.name().equals(key)){
                return t;
            }
        }
        return null;
    }
}
