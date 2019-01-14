package com.cts.fasttack.bank.server.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author d.ishchenko
 *
 */
public enum StorageTechnology {

    DEVICE_MEMORY, DEVICE_MEMORY_PROTECTED_TPM, TEE, SE, SERVER, VEE, UNKNOWN;

    private final static Map<String, StorageTechnology> tokenInfoCodeMap = new HashMap<String, StorageTechnology>();

    public static StorageTechnology fromTokenInfoStorageTechnology(String code) {
        StorageTechnology result = tokenInfoCodeMap.get(code);

        if (result != null) {
            return result;
        } else {
            return UNKNOWN;
        }
    }

    static {
        tokenInfoCodeMap.put("D", DEVICE_MEMORY);
        tokenInfoCodeMap.put("P", DEVICE_MEMORY_PROTECTED_TPM);
        tokenInfoCodeMap.put("H", SERVER);
        tokenInfoCodeMap.put("E", TEE);
        tokenInfoCodeMap.put("S", SE);
        tokenInfoCodeMap.put("V", VEE);
    }

}
