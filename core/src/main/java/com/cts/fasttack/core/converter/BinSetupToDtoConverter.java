package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.BinSetup;
import com.cts.fasttack.core.dto.BinSetupDto;

@Component
public class BinSetupToDtoConverter extends AbstractConverter<BinSetup, BinSetupDto> {

    @Override
    protected BinSetupDto generateTarget() {
        return new BinSetupDto();
    }

    @Override
    protected void lightConvert(BinSetup source, BinSetupDto target) {
        target.setBin(source.getBin());
        target.setSendAsv(source.isSendAsv());
        target.setSendCardTokenized(source.isSendCardTokenized());
        target.setSendGetCustomerId(source.isSendGetCustomerId());
        target.setCvcAttempt(source.getCvcAttempt());
        target.setPrepaid(source.isPrepaid());
        target.setMaxTokensPerCard(source.getMaxTokensPerCard());
    }
}
