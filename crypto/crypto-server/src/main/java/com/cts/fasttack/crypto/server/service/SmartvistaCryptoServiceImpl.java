package com.cts.fasttack.crypto.server.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;

/**
 * @author d.ishchenko
 */
@Service("smartvistaCryptoService")
public class SmartvistaCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements SmartvistaCryptoService {

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.SV_AVS1};

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String encrypt(String clearText, String hexIv, String keyIndex) throws ServiceException {
        if(StringUtils.isNotBlank(clearText)){
            return cryptoWrapper().encrypt3DesCbcWithPkcs5Padding(clearText, hexIv, getKeyByEncKeyId(new EncKeyId(KeyType.SV_AVS1, keyIndex)));
        }
        return clearText;
    }
}
