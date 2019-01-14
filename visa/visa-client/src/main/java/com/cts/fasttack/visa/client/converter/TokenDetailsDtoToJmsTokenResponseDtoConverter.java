package com.cts.fasttack.visa.client.converter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.visa.client.dto.TokenDetailsDto;

/**
 * {@link TokenDetailsDto} to {@link JmsTokenResponseDto} converter.
 *
 * @author v.semerkov
 * @author d.ishchenko
 */
@Component
public class TokenDetailsDtoToJmsTokenResponseDtoConverter extends AbstractConverter<TokenDetailsDto, JmsTokenResponseDto> {

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final Pattern EXPIRATION_DATE_PATTERN = Pattern.compile("^(?<" + YEAR + ">\\d{4})-(?<" + MONTH + ">\\d{2})$");

    @Autowired
    private DeviceInformationDtoToJmsDeviceResponseDtoConverter deviceInformationDtoToJmsDeviceResponseDtoConverter;

    @Override
    protected JmsTokenResponseDto generateTarget() {
        return new JmsTokenResponseDto();
    }

    @Override
    protected void lightConvert(TokenDetailsDto source, JmsTokenResponseDto target) {
        target.setAccountPanSuffix(source.getLastFourOfPAN());
        target.setTokenUniqueReference(source.getTokenReferenceID());

        if (StringUtils.isNotBlank(source.getToken()) && source.getToken().length() >= 4) {
            target.setTokenSuffix(source.getToken().substring(source.getToken().length() - 4));
        }

        target.setTokenExpirationDate(convertTokenExpirationDate(source.getTokenExpiration()));
        target.setCurrentStatusCode(source.getTokenState());
        target.setCurrentStatusDescription(convertTokenStateToTokenStatusDescription(source.getTokenState()));
        target.setCurrentStatusDateTime(source.getLastTokenStatusUpdatedTime());
        target.setPaymentAppInstanceId(source.getWalletAccountID());
        target.setStorageTechnology(guessMdesStyleStorageTechnology(source.getTokenType()));

        Optional.ofNullable(source.getRiskInformation())
                .ifPresent(riskInformation -> {
                    target.setTokenActivatedDateTime(riskInformation.getDateAndTimeTokenActivated());
                });

        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setTokenRequestorName(source.getTokenRequestorName());
        target.setTokenType(source.getTokenType());
        target.setDevice(deviceInformationDtoToJmsDeviceResponseDtoConverter.convert(source.getDeviceInformation()));
    }

    /**
     * Converts token expiration date string from format "YYYY-MM" to format "mmyy".
     *
     * @param source input string at "YYYY-MM" format
     * @return result string at "MMYY" format or {@code null} if input string is incorrect or empty
     */
    private String convertTokenExpirationDate(String source) {
        Matcher expirationDateMatcher = EXPIRATION_DATE_PATTERN.matcher(source);
        if (expirationDateMatcher.matches()) {
            String year = expirationDateMatcher.group(YEAR);
            String month = expirationDateMatcher.group(MONTH);
            return month + year.substring(2);
        }
        return null;
    }

    /**
     * Converts token state to token status description.
     *
     * @param tokenState token state from source
     * @return token status description
     */
    private String convertTokenStateToTokenStatusDescription(String tokenState) {
        switch (tokenState) {
            case "A":
                return "Active";
            case "S":
                return "Suspended";
            case "D":
                return "Deactivated";
            case "I":
                return "Inactive";
            default:
                return null;
        }
    }

    private String guessMdesStyleStorageTechnology(String tokenType) {
        if ("S".equals(tokenType)) {
            return "S";
        } else {
            return "H";
        }
    }
}
