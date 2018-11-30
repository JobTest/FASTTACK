package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.dict.MdesTokenStatus;
import com.cts.fasttack.common.core.dict.VtsTokenStatus;
import com.cts.fasttack.core.dict.TokenStatus;

import java.util.Optional;

public class TokenStatusConvert {

    public TokenStatus convert(VtsTokenStatus vtsTokenStatus) {
        return Optional.ofNullable(vtsTokenStatus)
                .map(tokenStatus -> TokenStatus.getInstance(tokenStatus.name()))
                .orElse(null);
    }

    public TokenStatus convert(MdesTokenStatus mdesTokenStatus) {
        return Optional.ofNullable(mdesTokenStatus)
                .map(tokenStatus -> TokenStatus.getInstance(tokenStatus.name()))
                .orElse(null);
    }
}
