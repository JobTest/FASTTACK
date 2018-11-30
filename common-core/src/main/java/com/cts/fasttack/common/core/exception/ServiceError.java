package com.cts.fasttack.common.core.exception;

import org.springframework.http.HttpStatus;

/**
 * Ошибка, произошедшая в рамках обработки запроса к веб сервису от MDES или MPA
 */
public interface ServiceError {

    /**
     * Код ошибки по стандартам MDES
     */
    ErrorCode getErrorCode();

    /**
     * Дополнительные поля ошибки по стандартам MDES
     */
    Object[] getParams();

    /**
     * Описание ошибки по стандартам MDES
     */
    String getErrorDescription();

    /**
     * Пояснение, о причине ошибки
     */
    String getMessage();

    /**
     * Статус Response
     */
    HttpStatus getHttpStatus();

}
