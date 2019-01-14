package com.cts.fasttack.common.core.config;

public final class PropertyClientConnectionManager {

    static {
        DEFAULT_MAX_PER_ROUTE = getInteger(PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS, 3, 10);
        MAX_TOTAL = getInteger(PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS, 100, 200);

    }

    public static int DEFAULT_MAX_PER_ROUTE; //todo:  by default defaultMaxPerRoute=10

    public static int MAX_TOTAL; //todo:  by default maxTotal=200

    private static int getInteger(String value, int increaseValue, int defaultValue) {
        return isInteger(value)
                ? Integer.valueOf(value) * increaseValue
                : defaultValue;
    }

    private static boolean isInteger(Object value) {
        if(value instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(value.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }

}
