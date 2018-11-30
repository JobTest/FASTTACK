package com.cts.fasttack.crypto.server.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;

/**
 * @author Anton Leliuk
 */
@Service("jmsCryptoService")
public class JmsCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements JmsCryptoService {

    private static final EncKeyId JMS_CMS = new EncKeyId(KeyType.JMS, KEY_REFCODE);

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.JMS};

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String encrypt(String decrypted) throws ServiceException {
        if(StringUtils.isNotBlank(decrypted)){
            return cryptoWrapper().encryptAes(decrypted, getKeyByEncKeyId(JMS_CMS));
        }
        return decrypted;
    }

    @Override
    public String decrypt(String encrypted) throws ServiceException {
        return cryptoWrapper().decryptAes(encrypted, getKeyByEncKeyId(JMS_CMS));
    }
}
