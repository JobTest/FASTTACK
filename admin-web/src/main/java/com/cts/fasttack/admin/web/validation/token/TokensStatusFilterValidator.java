package com.cts.fasttack.admin.web.validation.token;

import com.cts.fasttack.admin.web.data.list.TokenListFilter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokensStatusFilterValidator implements ConstraintValidator<ValidateTokensStatusFilter, TokenListFilter> {

    @Override
    public void initialize(ValidateTokensStatusFilter constraintAnnotation) {

    }

    /**
        0) Статус токена:
        1) Номер карты (PAN)
        2) Client ID
        3) ИНН
        4) Документ
        5) Token Reference
        6) Payment Application ID
     */
    @Override
    public boolean isValid(TokenListFilter value, ConstraintValidatorContext context) {
        return value.getStatuses()!=null && !value.getStatuses().isEmpty()
                ? StringUtils.isNotBlank(value.getPan())
                    || StringUtils.isNotBlank(value.getContragentId())
                    || StringUtils.isNotBlank(value.getTaxId())
                    || StringUtils.isNotBlank(value.getDocSr())
                    || StringUtils.isNotBlank(value.getDocNo())
                    || StringUtils.isNotBlank(value.getTokenRefId())
                    || StringUtils.isNotBlank(value.getPaymentAppId())
                : true;
    }
}
