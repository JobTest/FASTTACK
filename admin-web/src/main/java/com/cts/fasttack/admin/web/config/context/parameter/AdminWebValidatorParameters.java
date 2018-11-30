package com.cts.fasttack.admin.web.config.context.parameter;

import java.util.regex.Pattern;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("spring.admin.web.validator")
public class AdminWebValidatorParameters {

    @NotNull
    private Pattern passwordPolicyRegexp;

    @NotNull
    private Integer passwordPolicyRepeatLength;

    public Pattern getPasswordPolicyRegexp() {
        return passwordPolicyRegexp;
    }

    public void setPasswordPolicyRegexp(Pattern passwordPolicyRegexp) {
        this.passwordPolicyRegexp = passwordPolicyRegexp;
    }

    public Integer getPasswordPolicyRepeatLength() {
        return passwordPolicyRepeatLength;
    }

    public void setPasswordPolicyRepeatLength(Integer passwordPolicyRepeatLength) {
        this.passwordPolicyRepeatLength = passwordPolicyRepeatLength;
    }
}
