package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsRiskInformationDto;
import com.cts.fasttack.visa.client.dto.RiskInformationDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class RiskInformationToJmsDtoConverter extends AbstractConverter<RiskInformationDto, JmsRiskInformationDto> {
    @Override
    protected JmsRiskInformationDto generateTarget() {
        return new JmsRiskInformationDto();
    }

    @Override
    protected void lightConvert(RiskInformationDto source, JmsRiskInformationDto target) {
        target.setDateAndTimeTokenActivated(source.getDateAndTimeTokenActivated());
        target.setFinalProvisioningDecision(source.getFinalProvisioningDecision());
        target.setIssuerSpecialConditionCodes(source.getIssuerSpecialConditionCodes());
        target.setPanSource(source.getPanSource());
        target.setRiskAssessmentScore(source.getRiskAssessmentScore());
        target.setTokenProvisioningScore(source.getTokenProvisioningScore());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
    }
}
