package com.cts.fasttack.common.core.rest.client;

import java.net.URI;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ExceptionHandler;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;

/**
 * Базовый сервис для операций с {@link org.springframework.web.client.RestTemplate}.
 */
public abstract class RestClientImpl implements RestClient {

    protected final static Logger log = LogManager.getLogger(RestClientImpl.class);

    private RestTemplate restTemplate;

    /**
     * REST address
     */
    private String address;

    public RestClientImpl(RestTemplate restTemplate, String address) {
        this.restTemplate = restTemplate;
        this.address = address;
    }

    @Override
    public <RESPONSE> RESPONSE get(final String path, final String key, final Class<RESPONSE> responseType) throws ServiceException {
        return executeWithResponse(() -> restTemplate.getForObject(getBaseUrl(path, key), responseType), ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public <RESPONSE> RESPONSE get(URI uri, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.getForObject(uri, responseType), exceptionHandler);
    }

    @Override
    public <RESPONSE> RESPONSE get(String path, String key, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.getForObject(getBaseUrl(path, key), responseType), exceptionHandler);
    }

    @Override
    public <RESPONSE> RESPONSE get(final String path, final Class<RESPONSE> responseType, final Map<String, Object> uriVariables, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.getForObject(getBaseUrl(path), responseType, uriVariables), exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE post(final String path, final REQUEST request, final Class<RESPONSE> responseType) throws ServiceException {
        return this.post(path, request, responseType, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE post(URI uri, REQUEST request, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.postForObject(uri, request, responseType), exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE post(final String path, final REQUEST request, final Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.postForObject(getBaseUrl(path), request, responseType), exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE post(final String path, final REQUEST request, final Class<RESPONSE> responseType, final Map<String, Object> uriVariables, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> restTemplate.postForObject(getBaseUrl(path), request, responseType, uriVariables), exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE put(final URI uri, final REQUEST request, final Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException {
        return executeWithResponse(() -> {
            HttpEntity<REQUEST> httpEntity = new HttpEntity<>(request);
            ResponseEntity<RESPONSE> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, responseType);
            return response.getBody();
        }, exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> ResponseEntity<RESPONSE> post(final String path, final REQUEST request, final ParameterizedTypeReference<RESPONSE> type) throws ServiceException {
        return executeWithResponse(() -> {
            HttpEntity<REQUEST> httpEntity = new HttpEntity<>(request);
            return restTemplate.exchange(getBaseUrl(path), HttpMethod.POST, httpEntity, type);
        }, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public <REQUEST> void put(final String path, final REQUEST request, final ExceptionHandler exceptionHandler, final Object... urlVariables) throws ServiceException {
        execute(v -> restTemplate.put(getBaseUrl(path), request, urlVariables), exceptionHandler);
    }

    @Override
    public <REQUEST, RESPONSE> RESPONSE put(final String path, final REQUEST request, final Class<RESPONSE> responseType, final ExceptionHandler exceptionHandler, final Object... urlVariables) throws ServiceException {
        return executeWithResponse(() -> {
            HttpEntity<REQUEST> httpEntity = new HttpEntity<>(request);
            ResponseEntity<RESPONSE> response = restTemplate.exchange(getBaseUrl(path), HttpMethod.PUT, httpEntity, responseType, urlVariables);
            return response.getBody();
        }, exceptionHandler);
    }

    @Override
    public <REQUEST> void delete(String path, REQUEST request, ExceptionHandler exceptionHandler, Object... urlVariables) throws ServiceException {
        execute(v -> restTemplate.delete(getBaseUrl(path), request, urlVariables), exceptionHandler);
    }

    /**
     * Создает {@link org.springframework.web.util.UriComponentsBuilder} для создания URI
     * на основании настроек REST сервиса и на основании переданных переменных пути.
     * <p><p>
     * Пример использования переменных пути и переменных запроса: <p>
     * 1) Путь REST сервиса - "https://www.example.com:8080/rest" <p>
     * 2) uriParams - {"files","1.0"} <p>
     * Строка в результате: https://www.example.com:8080/rest/files/version
     *
     * @param uriParams переменные пути
     * @return URI
     */
    private UriComponentsBuilder buildBaseUrl(String path, String...uriParams){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(address).path(path);
        if(ArrayUtils.isNotEmpty(uriParams)){
            builder.pathSegment(uriParams);
        }
        return builder;
    }

    /**
     * Get base URL
     * @param path request path
     * @param uriParams request uri parameters
     * @return full request path
     */
    private String getBaseUrl(String path, String...uriParams){
        return buildBaseUrl(path, uriParams).build().toUriString();
    }

    private void execute(Consumer<Void> callback, ExceptionHandler exceptionHandler) throws ServiceException {
        try {
            callback.accept(null);
        } catch (Exception e) {
            exceptionHandler.handle(e);
        }
    }

    private <RESPONSE> RESPONSE executeWithResponse(Supplier<RESPONSE> callback, ExceptionHandler exceptionHandler) throws ServiceException {
        try {
            return callback.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }

}
