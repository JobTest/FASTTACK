package com.cts.fasttack.bank.server.pushprovisioning.validation;

import com.cts.fasttack.bank.server.pushprovisioning.dict.Intent;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Anton Leliuk
 */
public class ClientAppIdValidation implements ConstraintValidator<ClientAppId, CreateOpaquePaymentCardRequestDto> {

    @Override
    public void initialize(ClientAppId constraintAnnotation) {}

    @Override
    public boolean isValid(CreateOpaquePaymentCardRequestDto value, ConstraintValidatorContext context) {

        boolean result = !Intent.PUSH_PROV_MOBILE.name().equals(value.getIntent()) || StringUtils.isNotBlank(value.getClientAppID());
        if(!result){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(StandardErrorCodes.Names.MISSING_REQUIRED_FIELD).addPropertyNode("clientAppID").addConstraintViolation();
        }
        return result;
    }
}
