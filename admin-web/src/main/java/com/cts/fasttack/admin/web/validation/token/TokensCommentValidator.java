package com.cts.fasttack.admin.web.validation.token;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.admin.web.data.dto.TokensChangeStatusDto;

/**
 * @author Dmitry Koval
 */
public class TokensCommentValidator implements ConstraintValidator<ValidateTokensComment, TokensChangeStatusDto> {
    @Override
    public void initialize(ValidateTokensComment constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokensChangeStatusDto value, ConstraintValidatorContext context) {
        return value.getTokens().get(0).getIps().equals("V") || value.getTokens().get(0).getIps().equals("M") && StringUtils.isNotBlank(value.getComment());
    }
}
