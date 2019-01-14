package com.cts.fasttack.ih_sv.client.config;

import com.cts.fasttack.common.core.config.PropertyClientConnectionManager;
import com.cts.fasttack.ih_sv.client.rest.factory.IssuerHostSvHttpsClientRequestFactoryUnilateral;
import com.cts.fasttack.ih_sv.client.rest.factory.IssuerHostSvHttpsClientRequestFactoryBilateral;
import com.cts.fasttack.ih_sv.client.ws.interceptor.LoggingWebServiceInterceptor;
import com.cts.fasttack.ih_sv.client.ws.saaj.IssuerHostSvSaajSoapMessageFactory;
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

/**
 * @author d.ishchenko
 */
@Configuration
public class WebServicesConfiguration {

    public static final String avs1Namespace = "http://www.bpc.ru/apigate/command/avs1/";

	private Logger logger = LogManager.getLogger(WebServicesConfiguration.class);

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

	private int defaultMaxPerRoute = PropertyClientConnectionManager.DEFAULT_MAX_PER_ROUTE;

	private int maxTotal = PropertyClientConnectionManager.MAX_TOTAL;

	@Autowired(required = false)
	@Qualifier("issuerHostSvHttpsClientRequestFactoryUnilateral")
	private IssuerHostSvHttpsClientRequestFactoryUnilateral httpsClientRequestFactoryUnilateral;

	@Autowired(required = false)
	@Qualifier("issuerHostSvHttpsClientRequestFactoryBilateral")
	private IssuerHostSvHttpsClientRequestFactoryBilateral httpsClientRequestFactoryBilateral;

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.cts.fasttack.ih_sv.client.ws.client");
		return marshaller;
	}

	@Bean
	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri(address);
		webServiceTemplate.setMessageFactory(messageFactory());

		ClientInterceptor[] interceptors = new ClientInterceptor[] {
				new LoggingWebServiceInterceptor("com.cts.fasttack", address),
				securityInterceptor() };
		webServiceTemplate.setInterceptors(interceptors);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender());
		return webServiceTemplate;
	}

	@Bean
	public WebServiceMessageFactory messageFactory() {
		return new IssuerHostSvSaajSoapMessageFactory();
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender() {
		SSLConnectionSocketFactory sslConnectionSocketFactory = createSSLConnectionSocketFactory();
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", sslConnectionSocketFactory).build();

		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
		poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
//        poolingHttpClientConnectionManager.setMaxPerRoute(new HttpRoute(new HttpHost("locahost", 8088)), 50);

		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
				.setConnectionManager(poolingHttpClientConnectionManager) //todo: new
				.setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(connectionTimeout)
						.setSocketTimeout(readTimeout).build())
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

}
