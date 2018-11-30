package com.cts.fasttack.visa.client.jms.processor;

import com.cts.fasttack.visa.client.dto.TokenDetailsDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryRequestDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryResponseDto;
import com.cts.fasttack.visa.client.service.VisaRestClient;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.visa.client.converter.TokenInquiryJmsToRequestDtoConverter;
import com.cts.fasttack.visa.client.converter.TokenInquiryResponseToJmsTokenInfoResponseConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Processor for getting token info for VISA.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoVtsProcessor extends AbstractCamelProcessor<TokenInquiryJmsMessage, JmsTokenInfoResponseDto> {

    @Autowired
    private VisaRestClient visaRestClient;

    @Autowired
    private TokenInquiryJmsToRequestDtoConverter tokenInquiryJmsToRequestDtoConverter;

    @Autowired
    private TokenInquiryResponseToJmsTokenInfoResponseConverter tokenInquiryResponseToJmsTokenInfoResponseConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        //todo The real version of the product
        execute(exchange, TokenInquiryJmsMessage.class,
                request -> tokenInquiryResponseToJmsTokenInfoResponseConverter.convert(visaRestClient.tokenInquiry(
                        tokenInquiryJmsToRequestDtoConverter.convert(request.getTokenInquiryRequestDto()))));

        //todo A some emulation visaRestClient for test
//        execute(exchange, TokenInquiryJmsMessage.class,
//                request -> {
//                    TokenInquiryRequestDto requestDto = tokenInquiryJmsToRequestDtoConverter.convert(request.getTokenInquiryRequestDto());
//
//                    TokenDetailsDto tokenDetail = new TokenDetailsDto();
//                    tokenDetail.setTokenRequestorName("");
//                    tokenDetail.setWalletAccountID("");
//                    tokenDetail.setWalletAccountEmailAddress("");
//                    tokenDetail.setTokenAssuranceLevel("");
//                    tokenDetail.setEntityOfLastAction("");
//                    tokenDetail.setOperatorID("");
//                    tokenDetail.setOtpVerificationAttempts("");
//                    tokenDetail.setOtpVerificationRetryCounts("");
//                    tokenDetail.setLastFourOfPan("");
//                    tokenDetail.setLastFourOfPreviousPan("");
//                    tokenDetail.setOtpCodeIndicator("");
//                    tokenDetail.setToken(requestDto.getToken());
//                    tokenDetail.setPanReferenceID(requestDto.getPanReferenceID());
//                    tokenDetail.setTokenReferenceID(requestDto.getTokenReferenceID());
//                    tokenDetail.setTokenRequestorID(requestDto.getTokenRequestorID());
//                    tokenDetail.setTokenExpiration("2023-12-31");
//                    tokenDetail.setTokenState("A");
//                    tokenDetail.setDeactivationDate(new Date());
//                    tokenDetail.setLastTokenStatusUpdatedTime(new Date());
//                    tokenDetail.setOtpCodeExpiration(new Date());
//                    tokenDetail.setRiskInformation(null);
//                    tokenDetail.setDeviceInformation(null);
//                    tokenDetail.setTokenType(null);
//                    List<TokenDetailsDto> tokenDetails = new ArrayList<>();
//                    tokenDetails.add(tokenDetail);
//                    TokenInquiryResponseDto responseDto = new TokenInquiryResponseDto();
//                    responseDto.setErrorCode("0");
//                    responseDto.setTokenDetails(tokenDetails);
//
//                    return tokenInquiryResponseToJmsTokenInfoResponseConverter.convert(responseDto); });
    }
}
