package com.cts.fasttack.admin.web.data.dto;

import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.dto.IdentifierDto;

/**
 * @author Dmitry Koval
 */
public class TokenReasonDto extends IdentifierDto<Long> {

    private TokenEventStatus tokenStatusUpdateReason;

    private String reason;

    private String mdesReason;

    public TokenEventStatus getTokenStatusUpdateReason() {
        return tokenStatusUpdateReason;
    }

    public void setTokenStatusUpdateReason(TokenEventStatus tokenStatusUpdateReason) {
        this.tokenStatusUpdateReason = tokenStatusUpdateReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMdesReason() {
        return mdesReason;
    }

    public void setMdesReason(String mdesReason) {
        this.mdesReason = mdesReason;
    }
}
