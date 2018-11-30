package com.cts.fasttack.visa.common.config;

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
@ConditionalOnProperty(prefix = "spring.visa.encryption", value = "enabled", havingValue = "true")
@ConfigurationProperties("spring.visa.encryption")
public class VisaSecurityParameters {

    /**
     * Encryption API key
     */
    @NotEmpty
    private String encryptionApiKey;

    /**
     * Encryption shared secret
     */
    @NotEmpty
    private String encryptionSharedSecret;

    public String getEncryptionApiKey() {
        return encryptionApiKey;
    }

    public void setEncryptionApiKey(String encryptionApiKey) {
        this.encryptionApiKey = encryptionApiKey;
    }

    public String getEncryptionSharedSecret() {
        return encryptionSharedSecret;
    }

    public void setEncryptionSharedSecret(String encryptionSharedSecret) {
        this.encryptionSharedSecret = encryptionSharedSecret;
    }
}
