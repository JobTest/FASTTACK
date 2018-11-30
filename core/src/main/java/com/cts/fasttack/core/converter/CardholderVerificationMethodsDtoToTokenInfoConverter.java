package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.converter.RecommendationReasonsConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.common.core.util.TokenizationPathUtil;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsDtoToTokenInfoConverter extends AbstractConverter<JmsCardholderVerificationMethodsDto, TokenInfoDto> {
    @Override
    protected TokenInfoDto generateTarget() {
        return new TokenInfoDto();
    }

    @Override
    protected void lightConvert(JmsCardholderVerificationMethodsDto source, TokenInfoDto target) {
        target.setIps(InternationalPaymentSystem.V);
        target.setTokenStatus(TokenStatus.I);
        target.setTokenStatusUpdate(new Date());
        target.setId(new TokenInfoId(source.getTokenReferenceID(), source.getTokenRequestorID()));
        target.setPanRefId(source.getPanReferenceID());
        target.setLifecycleTraceId(source.getLifeCycleTraceID());
        target.setMaskedToken(StringUtil.displayPanOrToken(source.getToken()));
        target.setPanSource(PanSourceType.fromVisaIwsiPanSource(source.getPanSource()));
        if (source.getWpReasonCodes() != null) target.setTokenizationPath(TokenizationPathUtil.identifyCodes(new RecommendationReasonsConverter().convert(source.getWpReasonCodes())).getValues());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpPhonenumberScore(source.getWpPhonenumberScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
        target.setClrTokenizationStandardVer(source.getColorTokenizationStandardVersion());
    }
}
