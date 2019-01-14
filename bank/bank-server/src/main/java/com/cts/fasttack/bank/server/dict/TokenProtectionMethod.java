package com.cts.fasttack.bank.server.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author d.ishchenko
 *
 */
public enum TokenProtectionMethod {

    SOFTWARE, TRUSTED_EXECUTION_ENVIRONMENT, SECURE_ELEMENT, CLOUD, UNKNOWN;

    private final static Map<String, TokenProtectionMethod> tokenInfoCodeMap = new HashMap<String, TokenProtectionMethod>();

    public static TokenProtectionMethod fromTokenInfoStorageTechnology(String code) {
        TokenProtectionMethod result = tokenInfoCodeMap.get(code);

        if (result != null) {
            return result;
        } else {
            return UNKNOWN;
        }
    }

    static {
        tokenInfoCodeMap.put("D", SOFTWARE);
        tokenInfoCodeMap.put("H", CLOUD);
        tokenInfoCodeMap.put("E", TRUSTED_EXECUTION_ENVIRONMENT);
        tokenInfoCodeMap.put("S", SECURE_ELEMENT);
    }

}
