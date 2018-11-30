package com.cts.fasttack.admin.web.data;

import java.util.List;

/**
 * @author Anton Leliuk
 */
public class JsonResponseWrapper<T> {

    public enum Status {
        SUCCESS, ERROR
    }

    /**
     * Данное поле позволит однозначно определить для метода JsonResponseWrapperModel.parse(resp, options) содержится ли в ответе (resp) JsonResponseWrapper
     */
    public static boolean responseWrapper = true;

    private T dto;

    private Status status;

    private String message;

    private List<FieldRemark> fieldRemarks;

    private JsonResponseWrapper(T dto, Status status, String message) {
        this.dto = dto;
        this.status = status;
        this.message = message;
    }

    private JsonResponseWrapper(Status status, String message, List<FieldRemark> fieldRemarks) {
        this.status = status;
        this.message = message;
        this.fieldRemarks = fieldRemarks;
    }

    public static <T>JsonResponseWrapper<T> success(T dto) {
        return new JsonResponseWrapper<>(dto, Status.SUCCESS, null);
    }

    public static <T>JsonResponseWrapper<T> error(String message, List<FieldRemark> fieldRemarks) {
        return new JsonResponseWrapper<>(Status.ERROR, message, fieldRemarks);
    }

    public static <T>JsonResponseWrapper<T> error(String message) {
        return new JsonResponseWrapper<>(null, Status.ERROR, message);
    }

    public static <T>JsonResponseWrapper<T> result(boolean result) {
        return new JsonResponseWrapper<>(null, result ? Status.SUCCESS : Status.ERROR, null);
    }

    /** getters and setters */

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<FieldRemark> getFieldRemarks() {
        return fieldRemarks;
    }

    public void setFieldRemarks(List<FieldRemark> fieldRemarks) {
        this.fieldRemarks = fieldRemarks;
    }
}
