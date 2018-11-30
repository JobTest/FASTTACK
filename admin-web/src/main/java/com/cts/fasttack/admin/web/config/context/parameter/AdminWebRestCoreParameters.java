package com.cts.fasttack.admin.web.config.context.parameter;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("spring.rest.core")
public class AdminWebRestCoreParameters {

    @NotEmpty
    private String address;

    @NotNull
    private Integer connectionTimeoutInMills;

    @NotNull
    private Integer readTimeoutInMills;

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
}
