package com.cts.fasttack.visa.client.config;

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
public class VisaConnectionParameters {

    @NotEmpty
    private String address;

    @NotNull
    private Integer connectionTimeoutInMills;

    @NotNull
    private Integer readTimeoutInMills;

    @NotNull
    private Resource certificateResource;

    @NotEmpty
    private String certificatePassword;

    @NotEmpty
    private String basicAuthUsername;

    @NotEmpty
    private String basicAuthPassword;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getConnectionTimeoutInMills() {
        return connectionTimeoutInMills;
    }

    public void setConnectionTimeoutInMills(Integer connectionTimeoutInMills) {
        this.connectionTimeoutInMills = connectionTimeoutInMills;
    }

    public Integer getReadTimeoutInMills() {
        return readTimeoutInMills;
    }

    public void setReadTimeoutInMills(Integer readTimeoutInMills) {
        this.readTimeoutInMills = readTimeoutInMills;
    }

    public Resource getCertificateResource() {
        return certificateResource;
    }

    public void setCertificateResource(Resource certificateResource) {
        this.certificateResource = certificateResource;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }

    public String getBasicAuthUsername() {
        return basicAuthUsername;
    }

    public void setBasicAuthUsername(String basicAuthUsername) {
        this.basicAuthUsername = basicAuthUsername;
    }

    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    public void setBasicAuthPassword(String basicAuthPassword) {
        this.basicAuthPassword = basicAuthPassword;
    }
}