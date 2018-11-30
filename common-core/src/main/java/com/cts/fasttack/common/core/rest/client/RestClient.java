package com.cts.fasttack.common.core.rest.client;

import java.net.URI;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ExceptionHandler;

public interface RestClient {

    /**
     * Обращается к рест сервису пытаясь получить объект по ключу
     * <p><p>
     * Пример: <p>
     * 1) Путь - "https://www.example.com:8080/rest" <p>
     * 2) key - "ident" <p>
     * Строка в результате: https://www.example.com:8080/rest/ident
     * @param path request path
     * @param key ключ объекта
     * @param responseType class of response
     * @return результат выполнения запроса
     */
    <RESPONSE> RESPONSE get(String path, String key, Class<RESPONSE> responseType) throws ServiceException;

    <RESPONSE> RESPONSE get(URI uri, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException;

    <RESPONSE> RESPONSE get(String path, String key, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException;

    <RESPONSE> RESPONSE get(String path, Class<RESPONSE> responseType, Map<String, Object> uriVariables, ExceptionHandler exceptionHandler) throws ServiceException;

    /**
     * Send POST request
     * @param path request path
     * @param request the Object to be POSTed
     * @param responseType the type of the return value
     * @return response
     */
    <REQUEST, RESPONSE> RESPONSE post(String path, REQUEST request, Class<RESPONSE> responseType) throws ServiceException;

    /**
     * @param uri to send to specific addresses
     */
    <REQUEST, RESPONSE> RESPONSE post(URI uri, REQUEST request, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException;

    <REQUEST, RESPONSE> RESPONSE post(String path, REQUEST request, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException;

    <REQUEST, RESPONSE> RESPONSE post(String path, REQUEST request, Class<RESPONSE> responseType, Map<String, Object> uriVariables, ExceptionHandler exceptionHandler) throws ServiceException;

    <REQUEST, RESPONSE> ResponseEntity<RESPONSE> post(final String path, final REQUEST request, final ParameterizedTypeReference<RESPONSE> type) throws ServiceException;

    <REQUEST, RESPONSE> RESPONSE put(URI uri, REQUEST request, Class<RESPONSE> responseType, ExceptionHandler exceptionHandler) throws ServiceException;

    <REQUEST> void put(String path, REQUEST request, ExceptionHandler exceptionHandler, Object... urlVariables) throws ServiceException;

    <REQUEST, RESPONSE> RESPONSE put(final String path, final REQUEST request, final Class<RESPONSE> responseType, final ExceptionHandler exceptionHandler, final Object... urlVariables) throws ServiceException;

    <REQUEST> void delete(String path, REQUEST request, ExceptionHandler exceptionHandler, Object... urlVariables) throws ServiceException;


}
