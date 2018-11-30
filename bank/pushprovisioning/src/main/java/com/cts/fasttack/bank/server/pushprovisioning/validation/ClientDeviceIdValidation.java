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
public class ClientDeviceIdValidation implements ConstraintValidator<ClientDeviceId, CreateOpaquePaymentCardRequestDto> {

    @Override
    public void initialize(ClientDeviceId constraintAnnotation) {}

    @Override
    public boolean isValid(CreateOpaquePaymentCardRequestDto value, ConstraintValidatorContext context) {
        boolean result = !Intent.PUSH_PROV_MOBILE.name().equals(value.getIntent()) || StringUtils.isNotBlank(value.getClientDeviceID());
        if(!result){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(StandardErrorCodes.Names.MISSING_REQUIRED_FIELD).addPropertyNode("clientDeviceID").addConstraintViolation();
        }
        return result;
    }
}
