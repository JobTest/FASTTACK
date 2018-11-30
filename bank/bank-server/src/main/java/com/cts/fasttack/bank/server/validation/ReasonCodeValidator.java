package com.cts.fasttack.bank.server.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cts.fasttack.bank.server.dict.ActivateReasonCode;
import com.cts.fasttack.bank.server.dict.DeleteReasonCode;
import com.cts.fasttack.bank.server.dict.ResumeReasonCode;
import com.cts.fasttack.bank.server.dict.SuspendReasonCode;
import com.cts.fasttack.bank.server.dict.TokenAction;
import com.cts.fasttack.bank.server.dto.TokenLifecycleRequestDto;

/**
 * @author a.lipavets
 */
public class ReasonCodeValidator implements ConstraintValidator<ValidateReasonCode, TokenLifecycleRequestDto> {
    @Override
    public void initialize(ValidateReasonCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokenLifecycleRequestDto value, ConstraintValidatorContext context) {
        if("V".equals(value.getIps())) {
            return true;
        }
        switch (TokenAction.getInstance(value.getAction())) {
            case Activate:
                return ActivateReasonCode.getInstance(value.getReasonCode()) != null;
            case Resume:
                return ResumeReasonCode.getInstance(value.getReasonCode()) != null;
            case Suspend:
                return SuspendReasonCode.getInstance(value.getReasonCode()) != null;
            case Deactivate:
                return DeleteReasonCode.getInstance(value.getReasonCode()) != null;
        }
        return false;
    }
}
