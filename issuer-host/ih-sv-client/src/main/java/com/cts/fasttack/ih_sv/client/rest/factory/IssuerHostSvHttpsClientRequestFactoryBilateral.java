package com.cts.fasttack.ih_sv.client.rest.factory;

import com.cts.fasttack.common.core.rest.client.factory.PasswordCallbackHandler;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyStore;

/**
 * @author d.ishchenko
 */
@Component("issuerHostSvHttpsClientRequestFactoryBilateral")
@ConfigurationProperties("spring.client")
@ConditionalOnProperty(prefix = "spring.client", value = "mutualTls")
public class IssuerHostSvHttpsClientRequestFactoryBilateral extends SimpleClientHttpRequestFactory implements InitializingBean {

    private String jksKeyStorePassword;

    private Resource jksKeyStore;

    private Resource jksTrustStore;

    private String keyPassword;

    private Boolean tlsEnabled;

    private Boolean mutualTls;

    private SSLSocketFactory socketFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (mutualTls!=null) {
            Assert.notNull(jksKeyStorePassword, "Password for KeyStore must be set");
            Assert.notNull(jksKeyStore, "KeyStore must be set");
            Assert.notNull(jksTrustStore, "TrustStore file must be set");
            Assert.notNull(keyPassword, "Password for private key must be set");
            Assert.notNull(tlsEnabled, "fasttack-bank-client-application.properties 'spring.client.tlsEnabled' must be set");
        } else {
            tlsEnabled = false;
        }

        if (tlsEnabled) {
            KeyStore.Builder jksKeyStoreBuilder = createJksKeyStoreBuilder(jksKeyStore, jksKeyStorePassword);

            socketFactory = SSLContexts.custom().loadTrustMaterial(jksTrustStore.getFile())
                    .loadKeyMaterial(jksKeyStoreBuilder.getKeyStore(), keyPassword.toCharArray())
                    .build().getSocketFactory();
        }
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
            httpsConnection.setSSLSocketFactory(socketFactory);
        }
        super.prepareConnection(connection, httpMethod);
    }

    private KeyStore.Builder createJksKeyStoreBuilder(Resource keyStore, String password) throws IOException {
        return KeyStore.Builder.newInstance("JKS", null, keyStore.getFile(),
                new KeyStore.CallbackHandlerProtection(new PasswordCallbackHandler(password)));
    }

    public void setJksKeyStorePassword(String jksKeyStorePassword) {
        this.jksKeyStorePassword = jksKeyStorePassword;
    }

    public void setJksKeyStore(Resource jksKeyStore) {
        this.jksKeyStore = jksKeyStore;
    }

    public void setJksTrustStore(Resource jksTrustStore) {
        this.jksTrustStore = jksTrustStore;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public void setTlsEnabled(Boolean tlsEnabled) {
        this.tlsEnabled = tlsEnabled;
    }

    public Boolean isTlsEnabled() {
        return tlsEnabled;
    }

    public void setMutualTls(Boolean mutualTls) {
        this.mutualTls = mutualTls;
    }

    public SSLSocketFactory getSocketFactory() {
        return socketFactory;
    }
}
