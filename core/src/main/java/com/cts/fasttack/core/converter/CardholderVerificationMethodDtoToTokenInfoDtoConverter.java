package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.converter.RecommendationReasonsConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.util.TokenizationPathUtil;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import org.springframework.stereotype.Component;

@Component
public class CardholderVerificationMethodDtoToTokenInfoDtoConverter extends AbstractConverter<CardholderVerificationMethodDto, TokenInfoDto> {

    @Override
    protected TokenInfoDto generateTarget() {
        return new TokenInfoDto();
    }

    @Override
    protected void lightConvert(CardholderVerificationMethodDto source, TokenInfoDto target) {
        target.setId(new TokenInfoId(source.getTokenRefId(), source.getTokenRequestorId()));
        target.setIps(InternationalPaymentSystem.M);
        if (source.getWpReasonCodes() != null) target.setTokenizationPath(TokenizationPathUtil.identifyCodes(new RecommendationReasonsConverter().convert(source.getWpReasonCodes())).getValues());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpPhonenumberScore(source.getWpPhonenumberScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
        target.setClrTokenizationStandardVer(source.getColorTokenizationStandardVersion());
        target.setCustomerPhone(source.getCellPhone());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGuid(source.getPanInternalGUID());
        target.setMaskedPan(source.getMaskedPan());
        target.setTokenizationPath(source.getTokenizationPath());
        target.setPanRefId(source.getTokenRefId());
    }

}
