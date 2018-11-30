package com.cts.fasttack.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.cts.fasttack.admin.web.data.FieldRemark;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.security.AjaxDetectionHelper;
import com.cts.fasttack.common.core.exception.BusinessLogicException;

/**
 * Global exception controller
 * @author Anton Leliuk
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponseWrapper<?> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        List<FieldRemark> fieldErrorsList = new ArrayList<>();
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                fieldErrorsList.add(new FieldRemark(fieldError.getField(), fieldError.getDefaultMessage()));
            }
        }

        List<String> globalErrorsList = null;
        if (bindingResult.hasGlobalErrors()) {
            List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
            globalErrorsList = new ArrayList<>(globalErrors.size());
            for (ObjectError objectError : globalErrors) {
                if (objectError.getArguments().length > 1 && objectError.getArguments()[1] instanceof String){
                    //будем предполагать что вторым аргументом идут кода полей, если это не так, то нужно допиливать, пока это так
                    String fields = (String) objectError.getArguments()[1];
                    String[] codes = StringUtils.split(fields, ',');
                    for (String code : codes) {
                        fieldErrorsList.add(new FieldRemark(code, objectError.getDefaultMessage()));
                    }
                } else {
                    globalErrorsList.add(objectError.getDefaultMessage());
                }
            }
        }

        return JsonResponseWrapper.error(StringUtils.join(globalErrorsList, System.lineSeparator()), fieldErrorsList);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JsonResponseWrapper<?> businessLogicException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (AjaxDetectionHelper.isAjax(request)) {
            return JsonResponseWrapper.error(e.getMessage());
        } else if (e instanceof BusinessLogicException) {
            response.sendError(((BusinessLogicException) e).getStatus().value(), e.getMessage());
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return null;
    }

}
