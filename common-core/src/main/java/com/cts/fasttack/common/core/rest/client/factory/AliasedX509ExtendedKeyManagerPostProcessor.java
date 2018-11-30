package com.cts.fasttack.common.core.rest.client.factory;

import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509KeyManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Factory hook that allows for custom modification of new created {@link KeyManager}
 * @author Anton Leliuk
 */
@Component
@ConfigurationProperties("spring.client.rest")
public class AliasedX509ExtendedKeyManagerPostProcessor implements KeyManagerPostProcessor {

    /**
     * Client certificate alias
     */
    private String clientCertificateAlias;

    /**
     * PKCS#11 password. Typically is it a password for access to HSM
     */
    private String pkcsPassword;

    @Override
    public KeyManager[] postProcessAfterInitialization(KeyManager[] keyManagers, KeyStore pkcs11KeyStore) {
        if(StringUtils.isNotBlank(clientCertificateAlias)){
            for(int idx = 0; idx < keyManagers.length; idx++){
                if (keyManagers[idx] instanceof X509KeyManager
                        && !(keyManagers[idx] instanceof AliasedX509ExtendedKeyManager)) {
                    keyManagers[idx] = new AliasedX509ExtendedKeyManager((X509KeyManager)keyManagers[idx], pkcs11KeyStore, clientCertificateAlias, pkcsPassword);
                }
            }
        }
        return keyManagers;
    }

    public void setClientCertificateAlias(String clientCertificateAlias) {
        this.clientCertificateAlias = clientCertificateAlias;
    }

    public void setPkcsPassword(String pkcsPassword) {
        this.pkcsPassword = pkcsPassword;
    }
}
