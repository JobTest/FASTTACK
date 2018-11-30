package com.cts.fasttack.admin.web.config.context.support;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

/**
 * Custom implementation of {@link ReloadableResourceBundleMessageSource} to get all message properties
 *
 * @author n.bizin
 */
public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {

    @Override
    protected Properties loadProperties(Resource resource, String fileName) throws IOException {
        return super.loadProperties(resource, fileName);
    }

    /**
     * Gets all messages for presented Locale
     *
     * @param locale user request's locale
     * @return all messages
     */
    public Properties getMessages(Locale locale) {
        return getMergedProperties(locale).getProperties();
    }
}
