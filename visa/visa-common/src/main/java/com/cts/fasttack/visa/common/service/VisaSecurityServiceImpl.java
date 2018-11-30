package com.cts.fasttack.visa.common.service;

import com.cts.fasttack.visa.common.config.VisaSecurityParameters;
import com.visa.dmpd.token.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author Anton Leliuk
 */
@Service
@ConditionalOnProperty(prefix = "spring.visa.encryption", value = "enabled", havingValue = "true")
public class VisaSecurityServiceImpl implements VisaSecurityService {

    @Autowired
    private VisaSecurityParameters parameters;

    @Override
    public String createSharedSecretJwe(String text) {
        return JWTUtility.createSharedSecretJwe(text, parameters.getEncryptionApiKey(), parameters.getEncryptionSharedSecret());
    }
}
