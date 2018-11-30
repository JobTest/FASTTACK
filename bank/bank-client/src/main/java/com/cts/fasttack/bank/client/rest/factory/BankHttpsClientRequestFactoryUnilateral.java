package com.cts.fasttack.bank.client.rest.factory;

import org.apache.http.ssl.SSLContexts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Component("bankHttpsClientRequestFactoryUnilateral")
@ConfigurationProperties("spring.client")
public class BankHttpsClientRequestFactoryUnilateral extends SimpleClientHttpRequestFactory {

    private Logger logger = LogManager.getLogger(BankHttpsClientRequestFactoryUnilateral.class);

    private Resource jksTrustStore;

    private Boolean tlsEnabled;

    private SSLSocketFactory socketFactory;

    @PostConstruct
    public void init() {
        tlsEnabled = tlsEnabled!=null ? tlsEnabled : tlsEnabled==Boolean.FALSE;

        if (tlsEnabled) {
            Assert.notNull(jksTrustStore, "TrustStore file must be set");

            try {
                socketFactory = SSLContexts.custom().loadTrustMaterial(jksTrustStore.getFile())
                        .build().getSocketFactory();
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException | CertificateException ex) {
                logger.error(ex.getLocalizedMessage());
            }
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

    public void setJksTrustStore(Resource jksTrustStore) {
        this.jksTrustStore = jksTrustStore;
    }

    public void setTlsEnabled(Boolean tlsEnabled) {
        this.tlsEnabled = tlsEnabled;
    }

    public Boolean isTlsEnabled() {
        return tlsEnabled;
    }

    public SSLSocketFactory getSocketFactory() {
        return socketFactory;
    }
}
