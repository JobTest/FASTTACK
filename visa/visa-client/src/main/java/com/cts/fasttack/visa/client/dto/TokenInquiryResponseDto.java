package com.cts.fasttack.visa.client.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author a.lipavets
 */
@XmlRootElement(name = "tokenInquiryRes", namespace = "http://vnts.visa.com/tpcas/v1")
public class TokenInquiryResponseDto extends VisaClientCommonResponse{

    private List<TokenDetailsDto> tokenDetails;

    public List<TokenDetailsDto> getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(List<TokenDetailsDto> tokenDetails) {
        this.tokenDetails = tokenDetails;
    }
}
