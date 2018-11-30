package com.cts.fasttack.ih.client.config;

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
@ConfigurationProperties("spring.client.rest")
@Component
public class IssuerHostClientParameters {

    @NotEmpty
    private String address;

    @NotNull
    private Resource privateKeyPemFile;

    @NotEmpty
    private String keyPassword;

    private int connectionTimeoutInMills;

    private int readTimeoutInMills;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Resource getPrivateKeyPemFile() {
        return privateKeyPemFile;
    }

    public void setPrivateKeyPemFile(Resource privateKeyPemFile) {
        this.privateKeyPemFile = privateKeyPemFile;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
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
}
