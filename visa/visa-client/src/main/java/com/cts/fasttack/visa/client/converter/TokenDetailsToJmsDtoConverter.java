package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenDetailsDto;
import com.cts.fasttack.visa.client.dto.TokenDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenDetailsToJmsDtoConverter extends AbstractConverter<TokenDetailsDto,JmsTokenDetailsDto> {

    @Autowired
    private DeviceInfoToJmsDtoConverter deviceInfoToJmsDtoConverter;

    @Autowired
    private RiskInformationToJmsDtoConverter riskInformationToJmsDtoConverter;

    @Override
    protected JmsTokenDetailsDto generateTarget() {
        return new JmsTokenDetailsDto();
    }

    @Override
    protected void lightConvert(TokenDetailsDto source, JmsTokenDetailsDto target) {
        target.setDeactivationDate(source.getDeactivationDate());
        target.setDeviceInformation(deviceInfoToJmsDtoConverter.convert(source.getDeviceInformation()));
        target.setEntityOfLastAction(source.getEntityOfLastAction());
        target.setLastFourOfPan(source.getLastFourOfPan());
        target.setLastFourOfPreviousPan(source.getLastFourOfPreviousPan());
        target.setLastTokenStatusUpdatedTime(source.getLastTokenStatusUpdatedTime());
        target.setOperatorID(source.getOperatorID());
        target.setOtpCodeExpiration(source.getOtpCodeExpiration());
        target.setOtpCodeIndicator(source.getOtpCodeIndicator());
        target.setOtpVerificationAttempts(source.getOtpVerificationAttempts());
        target.setOtpVerificationRetryCounts(source.getOtpVerificationRetryCounts());
        target.setPanReferenceID(source.getPanReferenceID());
        target.setRiskInformation(riskInformationToJmsDtoConverter.convert(source.getRiskInformation()));
        target.setToken(source.getToken());
        target.setTokenAssuranceLevel(source.getTokenAssuranceLevel());
        target.setTokenExpiration(source.getTokenExpiration());
        target.setTokenReferenceID(source.getTokenReferenceID());
        target.setTokenRequestorID(source.getTokenRequestorID());
        target.setTokenRequestorName(source.getTokenRequestorName());
        target.setTokenState(source.getTokenState());
        target.setTokenType(source.getTokenType());
        target.setWalletAccountEmailAddress(source.getWalletAccountEmailAddress());
        target.setWalletAccountID(source.getWalletAccountID());
    }
}
