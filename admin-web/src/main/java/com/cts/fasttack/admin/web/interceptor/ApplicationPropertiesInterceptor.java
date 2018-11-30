package com.cts.fasttack.admin.web.interceptor;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebParameters;

public class ApplicationPropertiesInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    @Autowired
    private Environment environment;

    @Autowired
    private AdminWebParameters adminWebParameters;

    private Map<String, String> webProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, String> webProperties = new TreeMap<>();

        for (PropertySource<?> s : ((AbstractEnvironment) environment).getPropertySources()) {
            if (s instanceof ResourcePropertySource) {
                for (Map.Entry<String, Object> entry : ((ResourcePropertySource) s).getSource().entrySet()) {
                    if (Objects.equals(entry.getValue(), adminWebParameters.getBuildTimestamp())) {
                        webProperties.put(entry.getKey(), new SimpleDateFormat(adminWebParameters.getBuildTimestampFormat()).format(new Date()));
                    }
                }
            }
        }

        this.webProperties = Collections.unmodifiableMap(webProperties);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("properties", webProperties);
        }
    }

}
