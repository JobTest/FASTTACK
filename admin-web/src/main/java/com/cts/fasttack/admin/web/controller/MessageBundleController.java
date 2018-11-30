package com.cts.fasttack.admin.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;
import com.cts.fasttack.admin.web.config.context.support.ExposedResourceMessageBundleSource;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;

/**
 * Resolve message bundles for use in js
 */
@Controller
public class MessageBundleController {

    private final ConcurrentHashMap<Locale, Map<String, String>> messageBundles = new ConcurrentHashMap<>();

    @Autowired
    private ExposedResourceMessageBundleSource messageSource;

    @GetMapping("/messageBundles.json")
    @ResponseBody
    public JsonResponseWrapper<Map<String, String>> getStrings(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);
        Map<String, String> localeMessages = messageBundles.get(locale);
        if (localeMessages == null) {
            localeMessages = getMessages(locale);
            messageBundles.put(locale, localeMessages);
        }
        return JsonResponseWrapper.success(localeMessages);
    }

    private Map<String, String> getMessages(Locale locale) {
        Properties properties = messageSource.getMessages(locale);
        Map<String, String> messagesMap = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                messagesMap.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return messagesMap;
    }

}
