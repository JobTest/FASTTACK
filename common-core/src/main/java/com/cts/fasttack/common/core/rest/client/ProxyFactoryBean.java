package com.cts.fasttack.common.core.rest.client;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FactoryBean implementing for Proxy
 * @author a.lipavets
 */
@Component("clientRestProxy")
@ConfigurationProperties("spring.client.rest.proxy")
public class ProxyFactoryBean implements FactoryBean<Proxy> {

    private String host;
    private String port;

    @Override
    public Proxy getObject() throws Exception {

        if(StringUtils.isEmpty(host) || StringUtils.isEmpty(port)){
            return null;
        }

        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, Integer.parseInt(port)));
    }

    @Override
    public Class<?> getObjectType() {
        return Proxy.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
