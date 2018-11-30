package com.cts.fasttack.admin.web.validation.common;

import java.io.Serializable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cts.fasttack.admin.web.util.ApplicationContextHolder;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.service.ExistCheckService;
import com.cts.fasttack.common.core.util.ObjectUtil;

public class UniqueIdentifierValidator implements ConstraintValidator<UniqueIdentifier, Serializable> {

    private ExistCheckService<Serializable> existCheckService;

    @Override
    public void initialize(UniqueIdentifier annotation) {
        if (existCheckService == null) {
            existCheckService = ObjectUtil.uncheckedCast(ApplicationContextHolder.getBean(annotation.service()));
        }
    }

    @Override
    public boolean isValid(Serializable value, ConstraintValidatorContext context) {
        try {
            return !existCheckService.isExists(value);
        } catch (ServiceException e) {
            throw new BusinessLogicException(e.getHttpStatus(), e.getMessage());
        }
    }
}
