package com.cts.fasttack.bank.server.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.bank.server.dto.TokenUpdateRequestDto;

/**
 * @author a.lipavets
 */
public class TokenUpdateValidator implements ConstraintValidator<ValidateTokenUpdate, TokenUpdateRequestDto> {
    @Override
    public void initialize(ValidateTokenUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokenUpdateRequestDto value, ConstraintValidatorContext context) {
        return existTokenRefAndRequestorId(value) || existPanInternalIdOrGuid(value);
    }

    private boolean existPanInternalIdOrGuid(TokenUpdateRequestDto value){
        return StringUtils.isNotBlank(value.getPanInternalId()) || StringUtils.isNotBlank(value.getPanInternalGUID());
    }

    private boolean existTokenRefAndRequestorId(TokenUpdateRequestDto value){
        return StringUtils.isNotBlank(value.getTokenRefId()) && StringUtils.isNotBlank(value.getTokenRequestorId());
    }
}
