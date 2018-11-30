package com.cts.fasttack.visa.client.support;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.Collator;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anton Leliuk
 */
public class VisaHttpRequestWrapper extends HttpRequestWrapper {

    private static final Comparator<String> ALPHABETICALLY_COMPARATOR = (o1, o2) -> Collator.getInstance().compare(o1, o2);

    private URI uri;

    private Map<String, String> queryParams = new TreeMap<>(ALPHABETICALLY_COMPARATOR);
    /**
     * Creates a new {@code HttpRequest} wrapping the given request object.
     *
     * @param request the request object to be wrapped
     */
    public VisaHttpRequestWrapper(HttpRequest request, String apiKey) {
        super(request);
        this.uri = reBuildUri(super.getURI(), apiKey);
    }

    @Override
    public URI getURI() {
        return uri;
    }

    /**
     * Build new {@link URI} with {@code apiKey} and sorting query parameters in alphabetic order
     * @param originalUri original URI
     * @param apiKey key
     * @return new {@link URI}
     */
    private URI reBuildUri(URI originalUri, String apiKey){
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromUri(originalUri);
        UriComponents uriComponents = componentsBuilder.build();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme(uriComponents.getScheme())
                .host(uriComponents.getHost())
                .port(uriComponents.getPort())
                .fragment(uriComponents.getFragment())
                .path(uriComponents.getPath())
                .userInfo(uriComponents.getUserInfo());
        queryParams.put("apiKey", apiKey);

        for (Map.Entry<String, String> entry : uriComponents.getQueryParams().toSingleValueMap().entrySet()) {
            queryParams.put(entry.getKey(), entry.getValue());
        }

        queryParams.forEach(uriComponentsBuilder::queryParam);

        return uriComponentsBuilder.build().toUri();
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }
}
