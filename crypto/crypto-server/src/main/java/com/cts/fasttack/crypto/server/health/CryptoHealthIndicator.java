package com.cts.fasttack.crypto.server.health;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.crypto.server.service.DigitalCardCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Anton Leliuk
 */
@Component
public class CryptoHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    private DigitalCardCryptoService digitalCardCryptoService;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        /*
         * PAN = yyyyMMddHHmmss: 14 символов + 0 + Luhn;
         */
        String almostPan = DateFormatUtil.dateToString(DateFormatEnum.DATETIME_WITHOUT_SEPARATION, new Date()) + "0";
        String encryptPan = digitalCardCryptoService.encryptPan(almostPan + StringUtil.generateSymbolWithLuhnAlgorithm(almostPan));
        builder.withDetail("encryptPan", encryptPan).up();
    }
}
