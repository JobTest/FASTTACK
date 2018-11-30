package com.cts.fasttack.core.dict;

import org.apache.commons.lang.StringUtils;

/**
 * @author a.lipavets
 */
public enum Source {
    CARD_ON_FILE,
    CARD_ADDED_MANUALLY,
    CARD_ADDED_VIA_APPLICATION;

    public boolean isCardAddedManually(){
        return this == CARD_ADDED_MANUALLY;
    }

    public boolean isCardAddedViaApplication(){
        return this == CARD_ADDED_VIA_APPLICATION;
    }

    public boolean isCardOnFile(){
        return this == CARD_ON_FILE;
    }

    public static String getSource(String source) {
        if(StringUtils.isNotBlank(source)) {
            switch (source) {
                case "CARD_ON_FILE":
                    return "O";
                case "CARD_ADDED_MANUALLY":
                    return "K";
                case "CARD_ADDED_VIA_APPLICATION":
                    return "M";
                default:
                    return null;
            }
        }
        return null;
    }
}
