package com.cts.fasttack.bank.server.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.bank.server.dto.TokenInfoRequestDto;
import com.cts.fasttack.bank.server.dto.TokenLifecycleRequestDto;

/**
 * Validator for {@link TokenLifecycleRequestDto} and {@link TokenInfoRequestDto}.
 *
 * @author a.lipavets
 */
public class LifecycleTokenRequestValidator implements ConstraintValidator<ValidateLifecycleTokenRequest, TokenInfoRequestDto> {
    @Override
    public void initialize(ValidateLifecycleTokenRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokenInfoRequestDto request, ConstraintValidatorContext context) {
        int validCount = 0;
        if(StringUtils.isNotBlank(request.getTokenRefId()) && StringUtils.isNotBlank(request.getTokenRequestorId())) {
            validCount++;
        }

        if(StringUtils.isNotBlank(request.getPanInternalId()) || StringUtils.isNotBlank(request.getPanInternalGUID())) {
            validCount++;
        }

        if(StringUtils.isNotBlank(request.getPan()) && StringUtils.isNotBlank(request.getPaymentAppInstanceId())){
            validCount++;
        }

        return validCount == 1;
    }
}
