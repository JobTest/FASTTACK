package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.TokenInfoDto;
import org.springframework.stereotype.Component;

/**
 * Convert {@link TokenInfo} into {@link TokenInfoDto}
 *
 * @author a.lipavets
 */
@Component
public class TokenInfoToDtoConverter extends IdentifierToDtoConverter<TokenInfoId, TokenInfo, TokenInfoDto> {
    @Override
    protected TokenInfoDto generateTarget() {
        return new TokenInfoDto();
    }

    @Override
    public void convert(TokenInfo source, TokenInfoDto target) {
        target.setId(source.getId());
        target.setActiveTokenCount(source.getActiveTokenCount());
        target.setBin(source.getBin());
        target.setReminderPeriod(source.getReminderPeriod());
        target.setTokenizationPath(source.getTokenizationPath());
        target.setClientWalletAccountId(source.getClientWalletAccountId());
        target.setCustomerId(source.getCustomerId());
        target.setCustomerPhone(source.getCustomerPhone());
        target.setDigitizeDate(source.getDigitizeDate());
        target.setIps(source.getIps());
        target.setLifecycleTraceId(source.getLifecycleTraceId());
        target.setMaskedPan(source.getMaskedPan());
        target.setMaskedToken(source.getMaskedToken());
        target.setPanInternalGuid(source.getPanInternalGuid());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanRefId(source.getPanRefId());
        target.setPanSource(source.getPanSource());
        target.setTokenExpdate(source.getTokenExpdate());
        target.setTokenStatus(source.getTokenStatus());
        target.setTokenStatusUpdate(source.getTokenStatusUpdate());
        target.setTokenType(source.getTokenType());
        target.setReminderPeriod(source.getReminderPeriod());
        target.setTokenizationPath(source.getTokenizationPath());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
        target.setWpPhonenumberScore(source.getWpPhonenumberScore());
        target.setClrTokenizationStandardVer(source.getColorTokenizationStandardVersion());
    }
}
