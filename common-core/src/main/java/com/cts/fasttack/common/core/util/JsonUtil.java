package com.cts.fasttack.common.core.util;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cts.fasttack.common.core.exception.InvalidJsonXmlException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Сервис для операций с json
 */
public class JsonUtil {

    private static final Logger log = LogManager.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper MVC_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        MVC_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        MVC_MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        MVC_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MVC_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    /**
     * Интерпритирует объект в json строку
     * @param object объект для интерпритации
     * @return json строка с данными объекта
     */
    public static String toJson(Object object) throws ServiceException {
        return execute(() -> OBJECT_MAPPER.writeValueAsString(object));
    }

    /**
     * Создает объект из json строки
     * @param string json строка с описанием объекта
     * @param clazz класс объекта, который хранится в строке
     * @param <T> тип возвращаемого объекта
     * @return объект, полученный из строки
     */
    public static <T> T fromJson(String string, Class<T> clazz) {
        return execute(() -> OBJECT_MAPPER.readValue(string, clazz));
    }

    /**
     * Create object from string
     * @param json object string
     * @param type result type
     * @return object deserialized from string
     */
    public static <T> T fromJson(String json, JavaType type){
        return execute(() -> OBJECT_MAPPER.readValue(json, type));
    }

    /**
     * Create object from byte array
     */
    public static <T> T fromJson(byte[] json, Class<T> clazz){
        return execute(() -> OBJECT_MAPPER.readValue(json, clazz));
    }

    private static <T> T execute(ConversionCallback<T> callback){
        try {
            return callback.call();
        } catch (IOException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new InvalidJsonXmlException(e);
        }
    }

    private interface ConversionCallback<R> {

        R call() throws IOException;
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public static ObjectMapper getMVCMapper(){
        return MVC_MAPPER;
    }
}
