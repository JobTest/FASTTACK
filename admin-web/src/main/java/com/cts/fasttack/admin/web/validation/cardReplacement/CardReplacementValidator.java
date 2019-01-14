package com.cts.fasttack.admin.web.validation.cardReplacement;

import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import org.apache.commons.lang3.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardReplacementValidator implements ConstraintValidator<ValidateCardReplacement, CardReplacementFilter> {

    @Override
    public void initialize(ValidateCardReplacement constraintAnnotation) {

    }

    @Override
    public boolean isValid(CardReplacementFilter value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value.getOldPan())) return false;
        if (StringUtils.isNotBlank(value.getNewPan()) && StringUtils.isNotBlank(value.getNewExpDate())) return StringUtils.isNotBlank(value.getOldPan()) && StringUtils.isNotBlank(value.getOldExpDate()) && !value.getNewPan().equals(value.getOldPan());
        if (StringUtils.isNotBlank(value.getNewPan())) return StringUtils.isNotBlank(value.getOldPan()) && !value.getNewPan().equals(value.getOldPan());
        if (StringUtils.isNotBlank(value.getNewExpDate())) return StringUtils.isNotBlank(value.getOldExpDate());
        return true;
    }
}
