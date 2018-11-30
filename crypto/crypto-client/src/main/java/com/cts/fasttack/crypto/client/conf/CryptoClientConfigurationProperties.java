package com.cts.fasttack.crypto.client.conf;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Anton Leliuk
 */
@Validated
@Component
@ConfigurationProperties("spring.crypto.server")
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class CryptoClientConfigurationProperties {

    @NotEmpty
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
