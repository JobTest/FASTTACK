package com.cts.fasttack.bank.client.config;

import com.cts.fasttack.bank.client.rest.factory.BankHttpsClientRequestFactoryUnilateral;
import com.cts.fasttack.bank.client.rest.factory.BankHttpsClientRequestFactoryBilateral;
import com.cts.fasttack.bank.client.ws.interceptor.LoggingWebServiceInterceptor;
import com.cts.fasttack.bank.client.ws.saaj.BankSaajSoapMessageFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AUTH;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.ws.security.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import com.cts.fasttack.common.core.util.WsSecurityPasswordType;

import java.nio.charset.StandardCharsets;

@Configuration
public class WebServicesConfiguration {

    private Logger logger = LogManager.getLogger(WebServicesConfiguration.class);

    public static final String authenticateNamespace = "http://sab/";

    @Value("${spring.client.ws.username}")
    private String username;

    @Value("${spring.client.ws.password}")
    private String password;

    @Value("${spring.client.ws.address}")
    private String address;

    @Value("${spring.client.ws.connectionTimeoutInMills}")
    private int connectionTimeout;

    @Value("${spring.client.ws.readTimeoutInMills}")
    private int readTimeout;

    @Value("${spring.client.ws.security.passwordType:}")
    private String wsSecurityPasswordType;

    @Autowired(required = false)
    @Qualifier("bankHttpsClientRequestFactoryUnilateral")
    private BankHttpsClientRequestFactoryUnilateral httpsClientRequestFactoryUnilateral;

    @Autowired(required = false)
    @Qualifier("bankHttpsClientRequestFactoryBilateral")
    private BankHttpsClientRequestFactoryBilateral httpsClientRequestFactoryBilateral;

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.cts.fasttack.bank.client.ws.client");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(address);
        webServiceTemplate.setMessageFactory(messageFactory());

        ClientInterceptor[] interceptors = isSecurityHeaderFromAlfaBank()
                ? new ClientInterceptor[]{ new LoggingWebServiceInterceptor("com.cts.fasttack", address), securityInterceptor() }
                : new ClientInterceptor[]{ new LoggingWebServiceInterceptor("com.cts.fasttack", address) };
        webServiceTemplate.setInterceptors(interceptors);
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

    @Bean
    public Jaxb2Marshaller jaxb2MarshallerContragent(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.cts.fasttack.bank.client.ws.contragent");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplateContragent(){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2MarshallerContragent());
        webServiceTemplate.setUnmarshaller(jaxb2MarshallerContragent());
        webServiceTemplate.setDefaultUri(address);
        webServiceTemplate.setMessageFactory(messageFactory());

        ClientInterceptor[] interceptors = new ClientInterceptor[]{new LoggingWebServiceInterceptor("com.cts.fasttack", address)};
        webServiceTemplate.setInterceptors(interceptors);
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

    @Bean
    public WebServiceMessageFactory messageFactory(){
        return new BankSaajSoapMessageFactory();
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender(){
        SSLConnectionSocketFactory sslConnectionSocketFactory = createSSLConnectionSocketFactory();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslConnectionSocketFactory)
                .build();
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .addInterceptorLast((HttpRequestInterceptor) (request, context) -> request.addHeader(AUTH.WWW_AUTH_RESP, "Basic " + Base64.encodeBase64String((username + ":" + password).getBytes(StandardCharsets.UTF_8))))
                .setConnectionManager(new PoolingHttpClientConnectionManager(socketFactoryRegistry))
                .setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(connectionTimeout).setSocketTimeout(readTimeout).build())
                .build();

        return new HttpComponentsMessageSender(httpClient);
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();

        wss4jSecurityInterceptor.setSecurementActions("UsernameToken");
        wss4jSecurityInterceptor.setSecurementPasswordType(WSConstants.PW_TEXT);
        wss4jSecurityInterceptor.setSecurementUsername(username);
        wss4jSecurityInterceptor.setSecurementPassword(password);
        wss4jSecurityInterceptor.setSecurementUsernameTokenNonce(true);
        wss4jSecurityInterceptor.setSecurementUsernameTokenCreated(true);

        return wss4jSecurityInterceptor;
    }

    private SSLConnectionSocketFactory createSSLConnectionSocketFactory() {
        if (isBilateralTlsEnabled()) {
            logger.info("create Bilateral SSLConnectionSocketFactory");
            return new SSLConnectionSocketFactory(httpsClientRequestFactoryBilateral.getSocketFactory(),
                    null, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        }
        else if (isUnilateralTlsEnabled()) {
            logger.info("create Unilateral SSLConnectionSocketFactory");
            return new SSLConnectionSocketFactory(httpsClientRequestFactoryUnilateral.getSocketFactory(),
                    null, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        }
        logger.info("create SSLConnectionSocketFactory");
        return SSLConnectionSocketFactory.getSocketFactory();
    }

    private boolean isBilateralTlsEnabled() {
        return httpsClientRequestFactoryBilateral!=null && httpsClientRequestFactoryBilateral.isTlsEnabled();
    }

    private boolean isUnilateralTlsEnabled() {
        return httpsClientRequestFactoryUnilateral!=null && httpsClientRequestFactoryUnilateral.isTlsEnabled();
    }

    private boolean isSecurityHeaderFromAlfaBank() {
        return wsSecurityPasswordType.equals(WsSecurityPasswordType.PASSWORD_TEXT);
    }
}
