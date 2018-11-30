package com.cts.fasttack.mdes.client.interceptor;

import com.cts.fasttack.mdes.client.config.MdesRestParameters;
import com.cts.fasttack.mdes.client.request.MdesHttpRequestWrapper;
import com.mastercard.api.core.model.HttpMethod;
import com.mastercard.api.core.security.Authentication;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import oauth.signpost.OAuth;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Anton Leliuk
 */
public class MdesAuthInterceptor implements ClientHttpRequestInterceptor, /*RequestInterceptor,*/ InitializingBean {

    private final Logger log = LogManager.getLogger(MdesAuthInterceptor.class);

    @Autowired
    private MdesRestParameters parameters;

    private Authentication authentication;

    @Override
    public void afterPropertiesSet() throws Exception {
        authentication = new OAuthAuthentication(parameters.getConsumerKey(), parameters.getPrivateKeyResource().getInputStream(), parameters.getKeyAlias(), parameters.getKeyPassword());
    }

//    @Override
//    public void apply(RequestTemplate template) {
//        try {
//            HttpMethod mdesMethod = getMdesMethod(template.method());
//            HttpRequestBase message = new HttpRequestBase() {
//                @Override
//                public String getMethod() {
//                    return template.method();
//                }
//            };
//            template.headers().forEach((s, strings) -> {
//                if(!CollectionUtils.isEmpty(strings)){
//                    message.addHeader(s, strings.iterator().next());
//                }
//            });
//            template.query("Format", "JSON");
//            template.header("User-Agent", "sdk-api-core:dev/1.0.6");
//            authentication.sign(new URI(parameters.getAddress() + template.url()), mdesMethod, ContentType.APPLICATION_JSON, new String(template.body(), StandardCharsets.UTF_8), message);
//            template.header(OAuth.HTTP_AUTHORIZATION_HEADER,  message.getFirstHeader(OAuth.HTTP_AUTHORIZATION_HEADER).getValue());
//        } catch (Exception e) {
//            log.warn("Exception while generating hash of body", e);
//        }
//    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        MdesHttpRequestWrapper wrapper = new MdesHttpRequestWrapper(request);
        wrapper.getHeaders().add("User-Agent", "sdk-api-core:1.4.19/1.0.6");
        try {
            HttpMethod mdesMethod = getMdesMethod(wrapper.getMethod().name());
            HttpRequestBase message = new HttpRequestBase() {
                @Override
                public String getMethod() {
                    return mdesMethod.getHttpMethodAsString();
                }
            };
            wrapper.getHeaders().forEach((s, strings) -> {
                if(!CollectionUtils.isEmpty(strings)){
                    message.addHeader(s, strings.iterator().next());
                }
            });

            authentication.sign(wrapper.getURI(), mdesMethod, ContentType.APPLICATION_JSON, new String(body, StandardCharsets.UTF_8), message);
            wrapper.getHeaders().add(OAuth.HTTP_AUTHORIZATION_HEADER, message.getFirstHeader(OAuth.HTTP_AUTHORIZATION_HEADER).getValue());
        } catch (Exception e) {
            log.warn("Exception while generating hash of body", e);
        }
        return execution.execute(wrapper, body);
    }

    private com.mastercard.api.core.model.HttpMethod getMdesMethod(String httpMethod){
        switch (httpMethod){
            case "POST":
                return com.mastercard.api.core.model.HttpMethod.POST;
            case "DELETE":
                return com.mastercard.api.core.model.HttpMethod.DELETE;
            case "PUT":
                return com.mastercard.api.core.model.HttpMethod.PUT;
            default:
                return com.mastercard.api.core.model.HttpMethod.GET;
        }
    }

}
