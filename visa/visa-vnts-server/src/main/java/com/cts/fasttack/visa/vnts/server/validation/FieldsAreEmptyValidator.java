package com.cts.fasttack.visa.vnts.server.validation;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cts.fasttack.visa.vnts.server.dto.SendPasscodeRequestDto;
import org.apache.commons.lang3.StringUtils;

/**
 * @author a.lipavets
 */
public class FieldsAreEmptyValidator implements ConstraintValidator<ValidateIfFieldsAreEmpty, SendPasscodeRequestDto> {
    @Override
    public void initialize(ValidateIfFieldsAreEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(SendPasscodeRequestDto request, ConstraintValidatorContext context) {
        List<String> fields = Arrays.asList(request.getToken(), request.getTokenReferenceID(), request.getWalletProviderMsgTracing().getTokenRequestorID(), request.getPanReferenceID());
        for (String s : fields){
            if(StringUtils.isNotBlank(s)){
                return true;
            }
        }
        return false;
    }
}
