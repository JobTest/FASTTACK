package com.cts.fasttack.visa.client.factory;

import com.cts.fasttack.visa.client.config.VisaConnectionParameters;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Anton Leliuk
 */
public class VisaClientHttpsRequestFactory extends SimpleClientHttpRequestFactory implements InitializingBean {

    @Autowired
    private VisaConnectionParameters connectionParameters;

    private SSLSocketFactory socketFactory;

    private static final TrustManager[] TRUST_ALL_MANAGERS = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }
    };

    @Override
    public void afterPropertiesSet() throws Exception {

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(connectionParameters.getCertificateResource().getInputStream(), connectionParameters.getCertificatePassword().toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, connectionParameters.getCertificatePassword().toCharArray());


        sslContext.init(kmf.getKeyManagers(), TRUST_ALL_MANAGERS, new SecureRandom());
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
}
