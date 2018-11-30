package com.cts.fasttack.common.core.logging;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.AbstractLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.status.StatusLogger;

/**
 * Look up servlet container logs directory
 * @author Anton Leliuk
 */
@Plugin(name = "sc-logs", category = StrLookup.CATEGORY)
public class ServletContainerLogsDirectoryLookup extends AbstractLookup {

    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final Marker LOOKUP = MarkerManager.getMarker("LOOKUP");
    private static final String TOMCAT_HOME = "catalina.home";
    private static final String JBOSS_EAP_HOME = "jboss.home.dir";

    @Override
    public String lookup(LogEvent logEvent, String key) {
        try {
            String value = System.getProperty(TOMCAT_HOME);
            if(StringUtils.isNotBlank(value)){
                return value + "/logs";
            } else {
                value = System.getProperty(JBOSS_EAP_HOME);
                if(StringUtils.isNotBlank(value)){
                    return value + "/standalone/log";
                }
            }
            return StringUtils.defaultIfBlank(value, key);
        } catch (Exception e) {
            LOGGER.warn(LOOKUP, "Error while looking servlet container logs directory.", e);
            return null;
        }
    }
}
