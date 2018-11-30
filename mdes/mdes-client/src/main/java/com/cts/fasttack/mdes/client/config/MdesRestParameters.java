package com.cts.fasttack.mdes.client.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author Anton Leliuk
 */
@Validated
@Component
@ConfigurationProperties("spring.client.rest")
public class MdesRestParameters {

    @NotEmpty
    private String address;

    private int connectionTimeoutInMills;

    private int readTimeoutInMills;

    @NotNull
    private Resource privateKeyResource;

    @NotEmpty
    private String consumerKey;

    @NotEmpty
    private String keyAlias;

    @NotEmpty
    private String keyPassword;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getConnectionTimeoutInMills() {
        return connectionTimeoutInMills;
    }

    public void setConnectionTimeoutInMills(int connectionTimeoutInMills) {
        this.connectionTimeoutInMills = connectionTimeoutInMills;
    }

    public int getReadTimeoutInMills() {
        return readTimeoutInMills;
    }

    public void setReadTimeoutInMills(int readTimeoutInMills) {
        this.readTimeoutInMills = readTimeoutInMills;
    }

    public Resource getPrivateKeyResource() {
        return privateKeyResource;
    }

    public void setPrivateKeyResource(Resource privateKeyResource) {
        this.privateKeyResource = privateKeyResource;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }
}
