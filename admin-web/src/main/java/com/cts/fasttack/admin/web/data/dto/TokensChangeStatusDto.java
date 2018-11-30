package com.cts.fasttack.admin.web.data.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.admin.web.validation.token.ValidateTokensComment;
import com.cts.fasttack.common.core.dict.TokenEventStatus;

/**
 * @author Dmitry Koval
 */
@ValidateTokensComment(message = "{token.comment.empty}")
public class TokensChangeStatusDto {

    @Size(min = 1, message = "{token.list.empty}")
    private List<TokenChangeStatusDto> tokens;

    private String comment;

    @NotEmpty
    private String tokenReason;

    @NotNull
    private TokenEventStatus tokenEventStatus;

    public List<TokenChangeStatusDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenChangeStatusDto> tokens) {
        this.tokens = tokens;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public TokenEventStatus getTokenEventStatus() {
        return tokenEventStatus;
    }

    public void setTokenEventStatus(TokenEventStatus tokenEventStatus) {
        this.tokenEventStatus = tokenEventStatus;
    }
}
