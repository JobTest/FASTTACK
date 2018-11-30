package com.cts.fasttack.mdes.server.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.mdes.server.dict.ReasonCode;
import com.cts.fasttack.mdes.server.dto.NotifyTokenUpdatedRequestDto;

/**
 * Validator for {@link NotifyTokenUpdatedRequestDto}
 *
 * @author Dmitry Koval
 */
public class NotifyTokenUpdateRequestValidator implements ConstraintValidator<ValidateNotifyTokenUpdateRequest, NotifyTokenUpdatedRequestDto> {

    @Override
    public void initialize(ValidateNotifyTokenUpdateRequest constraintAnnotation) {
    }

    @Override
    public boolean isValid(NotifyTokenUpdatedRequestDto value, ConstraintValidatorContext context) {
        ReasonCode reasonCode = ReasonCode.getInstance(value.getReasonCode());
        if (reasonCode != null && !reasonCode.isRedigitizationComplete() && !reasonCode.isDeleteFromConsumerApp()) {
            if (!value.getTokens().stream().noneMatch(item -> StringUtils.isBlank(item.getStatus()))) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(StandardErrorCodes.Names.INVALID_FIELD_VALUE).addPropertyNode("reasonCode").addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
