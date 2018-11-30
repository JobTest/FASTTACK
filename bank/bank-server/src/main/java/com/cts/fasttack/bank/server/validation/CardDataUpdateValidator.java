package com.cts.fasttack.bank.server.validation;

import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardDataUpdateValidator implements ConstraintValidator<ValidateCardDataUpdate, CardDataUpdateRequestDto> {
    @Override
    public void initialize(ValidateCardDataUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(CardDataUpdateRequestDto value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value.getNewPanInternalId()) || StringUtils.isNotBlank(value.getNewPanInternalGUID());
    }
}
