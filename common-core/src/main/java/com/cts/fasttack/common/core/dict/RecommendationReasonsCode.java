package com.cts.fasttack.common.core.dict;

import org.apache.commons.lang3.StringUtils;

public enum RecommendationReasonsCode {
    LONG_ACCOUNT_TENURE("00"),
    GOOD_ACTIVITY_HISTORY("00"),
    ADDITIONAL_DEVICE("00"),
    SOFTWARE_UPDATE("00"),
    ACCOUNT_TOO_NEW_SINCE_LAUNCH("01"),
    ACCOUNT_TOO_NEW("02"),
    ACCOUNT_CARD_TOO_NEW("03"),
    ACCOUNT_RECENTLY_CHANGED("04"),
    SUSPICIOUS_ACTIVITY("05"),
    INACTIVE_ACCOUNT("06"),
    HAS_SUSPENDED_TOKENS("07"),
    DEVICE_RECENTLY_LOST("08"),
    TOO_MANY_RECENT_ATTEMPTS("09"),
    TOO_MANY_RECENT_TOKENS("0A"),
    TOO_MANY_DIFFERENT_CARDHOLDERS("0B"),
    LOW_DEVICE_SCORE("0C"),
    LOW_ACCOUNT_SCORE("0D"),
    OUTSIDE_HOME_TERRITORY("0E"),
    UNABLE_TO_ASSESS("0F"),
    HIGH_RISK("0G"),
    LOW_PHONE_NUMBER_SCORE("0H"),
    ;

    RecommendationReasonsCode(String code) {
        this.code = code;
    }

    public static RecommendationReasonsCode valueOfCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        switch (code) {
            case "00":
                return LONG_ACCOUNT_TENURE;
            case "01":
                return ACCOUNT_TOO_NEW_SINCE_LAUNCH;
            case "02":
                return ACCOUNT_TOO_NEW;
            case "03":
                return ACCOUNT_CARD_TOO_NEW;
            case "04":
                return ACCOUNT_RECENTLY_CHANGED;
            case "05":
                return SUSPICIOUS_ACTIVITY;
            case "06":
                return INACTIVE_ACCOUNT;
            case "07":
                return HAS_SUSPENDED_TOKENS;
            case "08":
                return DEVICE_RECENTLY_LOST;
            case "09":
                return TOO_MANY_RECENT_ATTEMPTS;
            case "0A":
                return TOO_MANY_RECENT_TOKENS;
            case "0B":
                return TOO_MANY_DIFFERENT_CARDHOLDERS;
            case "0C":
                return LOW_DEVICE_SCORE;
            case "0D":
                return LOW_ACCOUNT_SCORE;
            case "0E":
                return OUTSIDE_HOME_TERRITORY;
            case "0F":
                return UNABLE_TO_ASSESS;
            case "0G":
                return HIGH_RISK;
            case "0H":
                return LOW_PHONE_NUMBER_SCORE;
        }
        return null;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
