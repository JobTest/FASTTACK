package com.cts.fasttack.mdes.client.request;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author Anton Leliuk
 */
public class MdesHttpRequestWrapper extends HttpRequestWrapper {

    private URI uri;

    /**
     * Create a new {@code HttpRequest} wrapping the given request object.
     *
     * @param request the request object to be wrapped
     */
    public MdesHttpRequestWrapper(HttpRequest request) {
        super(request);
        this.uri = reBuildUri(super.getURI());
    }

    /**
     * Build new {@link java.net.URI} with {@code apiKey} and sorting query parameters in alphabetic order
     * @param originalUri original URI
     * @return new {@link java.net.URI}
     */
    private URI reBuildUri(URI originalUri){
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromUri(originalUri);
        UriComponents uriComponents = componentsBuilder.build();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme(uriComponents.getScheme())
                .host(uriComponents.getHost())
                .port(uriComponents.getPort())
                .fragment(uriComponents.getFragment())
                .path(uriComponents.getPath())
                .userInfo(uriComponents.getUserInfo());

        uriComponentsBuilder.queryParam("Format", "JSON");

        return uriComponentsBuilder.build().toUri();
    }

    @Override
    public URI getURI() {
        return uri;
    }
}
