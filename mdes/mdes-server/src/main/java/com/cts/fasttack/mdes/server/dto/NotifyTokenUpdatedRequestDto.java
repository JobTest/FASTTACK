package com.cts.fasttack.mdes.server.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.cts.fasttack.mdes.server.dict.ReasonCode;
import com.cts.fasttack.mdes.server.validation.ValidateNotifyTokenUpdateRequest;

/**
 * NotifyTokenUpdatedRequestDto is coming every times when token's status Is changing on MDES side
 *
 * @author a.lipavets
 */
@ValidateNotifyTokenUpdateRequest(message = StandardErrorCodes.Names.INVALID_JSON)
@XmlRootElement(name = "request")
public class NotifyTokenUpdatedRequestDto extends CommonMdesRequestDto {

    /**
     * Contains the Tokens which were updated
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Valid
    private List<TokenDto> tokens;

    /**
     * The reason code for why the notification is being sent
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = ReasonCode.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String reasonCode;

    /* getters and setters */

    public List<TokenDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenDto> tokens) {
        this.tokens = tokens;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
}
