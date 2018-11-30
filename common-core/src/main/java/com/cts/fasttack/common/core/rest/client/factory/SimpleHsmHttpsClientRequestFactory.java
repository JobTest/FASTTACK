package com.cts.fasttack.common.core.rest.client.factory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.Assert;

/**
 * Mutual TLS encryption of the connection using PKCS#11.
 *
 * @author Anton Leliuk
 */
@ConfigurationProperties("spring.client.rest")
public class SimpleHsmHttpsClientRequestFactory extends SimpleClientHttpRequestFactory implements InitializingBean {

    /**
     * PKCS#11 password. Typically is it a password for access to HSM
     */
    private String pkcsPassword;

    /**
     * Password for {@link KeyStore}
     */
    private String jksPassword;

    /**
     * Resource that contain {@link KeyStore} data
     */
    private Resource jksKeyStore;

    /**
     * Resource that contain PKCS#11 configuration
     */
    private Resource pkcsConfig;

    private SSLSocketFactory socketFactory;

    @Autowired
    private KeyManagerPostProcessor keyManagerPostProcessor;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(pkcsPassword, "Password for PKCS#11 must be set");
        Assert.notNull(jksPassword, "Password for KeyStore must be set");
        Assert.notNull(jksKeyStore, "KeyStore must be set");
        Assert.notNull(pkcsConfig, "PKCS#11 configuration file must be set");
        KeyStore.Builder pkcsKeyStoreBuilder = createPkcsKeyStoreBuilder();
        KeyStore.Builder jksKeyStoreBuilder = createJksKeyStoreBuilder();
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        KeyManager[] keyManagers = createKeyManagers(pkcsKeyStoreBuilder);
        if (keyManagerPostProcessor != null) {
            keyManagers = keyManagerPostProcessor.postProcessAfterInitialization(keyManagers, pkcsKeyStoreBuilder.getKeyStore());
        }
        sslContext.init(keyManagers, createCAFileTrustManagers(jksKeyStoreBuilder), null);
        socketFactory = sslContext.getSocketFactory();
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
            httpsConnection.setSSLSocketFactory(socketFactory);
        }
        super.prepareConnection(connection, httpMethod);
    }

    /**
     * Create PKCS#11 {@link KeyStore.Builder}
     *
     * @return {@link KeyStore.Builder}
     * @throws IOException if config file not found
     */
    private KeyStore.Builder createPkcsKeyStoreBuilder() throws IOException {
        @SuppressWarnings("restriction")
		Provider provider = new sun.security.pkcs11.SunPKCS11(pkcsConfig.getInputStream());
        Security.removeProvider("IAIK");
        Security.addProvider(provider);
        return KeyStore.Builder.newInstance("PKCS11", provider, new KeyStore.CallbackHandlerProtection(new PasswordCallbackHandler(pkcsPassword)));
    }

    /**
     * Create JKS {@link KeyStore.Builder}
     *
     * @return {@link KeyStore.Builder}
     * @throws IOException if key store file not found
     */
    private KeyStore.Builder createJksKeyStoreBuilder() throws IOException {
        return KeyStore.Builder.newInstance("JKS", null, jksKeyStore.getFile(), new KeyStore.CallbackHandlerProtection(new PasswordCallbackHandler(jksPassword)));
    }

    /**
     * Create {@code NewSunX509} {@link KeyManager}
     *
     * @param builder PKCS#11 {@link KeyStore.Builder}
     * @return array of available {@link KeyManager}
     * @throws GeneralSecurityException if no security algorithm found
     */
    private KeyManager[] createKeyManagers(KeyStore.Builder builder) throws GeneralSecurityException {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("NewSunX509");
        kmf.init(new KeyStoreBuilderParameters(builder));
        return kmf.getKeyManagers();
    }

    /**
     * Create new {@link TrustManager} for JKS
     *
     * @param builder JSK {@link KeyStore.Builder}
     * @return array of available {@link TrustManager}
     * @throws GeneralSecurityException if no security algorithm found
     */
    private TrustManager[] createCAFileTrustManagers(KeyStore.Builder builder) throws GeneralSecurityException {
        KeyStore keystore = builder.getKeyStore();
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keystore);
        return trustManagerFactory.getTrustManagers();
    }

    public void setPkcsPassword(String pkcsPassword) {
        this.pkcsPassword = pkcsPassword;
    }

    public void setJksPassword(String jksPassword) {
        this.jksPassword = jksPassword;
    }

    public void setJksKeyStore(Resource jksKeyStore) {
        this.jksKeyStore = jksKeyStore;
    }

    public void setPkcsConfig(Resource pkcsConfig) {
        this.pkcsConfig = pkcsConfig;
    }
}
