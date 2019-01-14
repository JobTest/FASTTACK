package com.cts.fasttack.common.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public final class PropertyActiveMQConnectionFactory {

    static {
        final String propFileName = "fasttack-jms-application.properties";
        CONCURRENT_CONSUMERS = getValueProperty(propFileName, "jms.queue.concurrentConsumers", "1");
        BROKER_URL = getValueProperty(propFileName, "jms.activemq.broker-url", "vm://localhost?broker.persistent=false&broker.useJmx=false");
    }

    public static String CONCURRENT_CONSUMERS; //todo:  by default concurrentConsumers=1

    public static String BROKER_URL; //todo;  by default vm://localhost?broker.persistent=false&broker.useJmx=false

    static String getValueProperty(String propFileName, String keyProperty, String defaultValue) {
        String valuePropertyFromJboss = getValuePropertyFromJboss(propFileName, keyProperty);
        String valuePropertyFromLocal = getValuePropertyFromLocal(propFileName, keyProperty);
        return valuePropertyFromJboss!=null
                ? valuePropertyFromJboss
                : valuePropertyFromLocal!=null
                    ? valuePropertyFromLocal
                    : defaultValue;
    }

    private static String getValuePropertyFromLocal(String propFileName, String keyProperty) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName)) {
            PropertyResourceBundle prop = new PropertyResourceBundle(is);
            return prop.getString(keyProperty);
        } catch (Exception ex) {
            return null;
        }
    }

    private static String getValuePropertyFromJboss(String propFileName, String keyProperty) {
        String fileName = System.getProperty("jboss.server.config.dir") + "/" + propFileName;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(keyProperty);
        } catch (IOException ex) {
            return null;
        }
    }
}
