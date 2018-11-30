package com.cts.fasttack.bank.server.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.bank.server.dict.TokenAction;
import com.cts.fasttack.bank.server.validation.ValidateLifecycleTokenRequest;
import com.cts.fasttack.bank.server.validation.ValidateReasonCode;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;

/**
 * @author a.lipavets
 */
@ValidateLifecycleTokenRequest(message = StandardErrorCodes.Names.INVALID_JSON)
@ValidateReasonCode(message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
public class TokenLifecycleRequestDto extends TokenInfoRequestDto {

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, max = 254, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String reasonCode;

    @Size(min = 1, max = 500, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String commentText;

    @ValidEnum(enumType = TokenAction.class, message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String action;

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
