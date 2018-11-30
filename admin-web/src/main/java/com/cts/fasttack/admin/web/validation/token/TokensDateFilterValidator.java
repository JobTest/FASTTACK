package com.cts.fasttack.admin.web.validation.token;

import com.cts.fasttack.admin.web.data.list.TokenListFilter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokensDateFilterValidator implements ConstraintValidator<ValidateTokensDateFilter, TokenListFilter> {

    @Override
    public void initialize(ValidateTokensDateFilter constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokenListFilter value, ConstraintValidatorContext context) {
        return (value.getDateFrom()!=null && value.getDateTill()!=null) || (value.getDateFrom()==null && value.getDateTill()==null)
            ? true
            : false;
    }
}
