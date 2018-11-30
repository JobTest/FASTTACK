package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.BinSetup;
import com.cts.fasttack.core.dto.BinSetupDto;

@Component
public class BinSetupDtoToDomainConverter extends AbstractConverter<BinSetupDto, BinSetup> {

    @Override
    protected BinSetup generateTarget() {
        return new BinSetup();
    }

    @Override
    protected void lightConvert(BinSetupDto source, BinSetup target) {
        target.setBin(source.getBin());
        target.setSendAsv(source.isSendAsv());
        target.setSendCardTokenized(source.isSendCardTokenized());
        target.setSendGetCustomerId(source.isSendGetCustomerId());
        target.setCvcAttempt(source.getCvcAttempt());
        target.setPrepaid(source.isPrepaid());
        target.setMaxTokensPerCard(source.getMaxTokensPerCard());
    }
}
