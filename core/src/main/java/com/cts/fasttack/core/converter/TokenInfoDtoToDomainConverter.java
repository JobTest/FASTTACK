package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.TokenInfo;
import com.cts.fasttack.core.dto.TokenInfoDto;
import org.springframework.stereotype.Component;

/**
 * Convert {@link TokenInfoDto} into {@link TokenInfo}
 *
 * @author a.lipavets
 */
@Component
public class TokenInfoDtoToDomainConverter extends AbstractConverter<TokenInfoDto, TokenInfo> {
    @Override
    protected TokenInfo generateTarget() {
        return new TokenInfo();
    }

    @Override
    protected void lightConvert(TokenInfoDto source, TokenInfo target) {
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
        target.setNew(source.isNew());
        target.setReminderPeriod(source.getReminderPeriod());
        target.setTokenizationPath(source.getTokenizationPath());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
        target.setWpPhonenumberScore(source.getWpPhonenumberScore());
        target.setColorTokenizationStandardVersion(source.getClrTokenizationStandardVer());
    }
}
