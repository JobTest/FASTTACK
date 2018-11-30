package com.cts.fasttack.admin.web.validation.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebValidatorParameters;
import com.cts.fasttack.admin.web.data.dto.UserPasswordAwareDto;

/**
 * Password validator
 */
public class UserPasswordConstraintValidator implements ConstraintValidator<UserPasswordConstraint, UserPasswordAwareDto> {

    /**
     * Characters: TAB,LF,VT,FF,CR,Space.
     */
    private static final char[] WHITESPACE_CHARS = new char[]{(byte) 0x09, (byte) 0x0A, (byte) 0x0B, (byte) 0x0C, (byte) 0x0D, (byte) 0x20};

    /**
     * Regular expression used to find duplicate symbols.
     */
    private static final String REPEAT_CHAR_REGEX = "([a-zа-яA-ZА-Я]|[@#$%%^&+=:{}~!?\\[\\]()<>№|\\/])\\1{%d}";

    @Autowired
    private AdminWebValidatorParameters adminWebValidatorParameters;

    @Override
    public void initialize(UserPasswordConstraint userPasswordConstraint) {
    }

    @Override
    public boolean isValid(UserPasswordAwareDto user, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isNotEmpty(user.getNewPassword())) {
            /* password mustn't contains username*/
            if (user.getUsername().equals(user.getNewPassword())) {
                return false;
            }

            /* password mustn't contains whitespaces*/
            for (char c : WHITESPACE_CHARS) {
                if (user.getNewPassword().contains(String.valueOf(c))) {
                    return false;
                }
            }

            /* password must match regexp */
            if (!adminWebValidatorParameters.getPasswordPolicyRegexp().matcher(user.getNewPassword()).matches()) {
                return false;
            }

            /* password mustn't contains repeated symbols */
            if (adminWebValidatorParameters.getPasswordPolicyRepeatLength() > 0) {
                Pattern pattern = Pattern.compile(String.format(REPEAT_CHAR_REGEX, adminWebValidatorParameters.getPasswordPolicyRepeatLength() - 1), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(user.getNewPassword());
                if (matcher.find()) {
                    return false;
                }
            }
        }
        return true;
    }
}
