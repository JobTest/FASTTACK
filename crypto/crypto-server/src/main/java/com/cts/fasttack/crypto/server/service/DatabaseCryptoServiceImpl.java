package com.cts.fasttack.crypto.server.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.server.data.EncKeyId;
import com.cts.fasttack.crypto.client.dict.KeyType;

/**
 * @author Dmitry Koval
 */
@Service("databaseCryptoService")
public class DatabaseCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements DatabaseCryptoService {

    private static final EncKeyId DBK = new EncKeyId(KeyType.DBK, KEY_REFCODE);

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.DBK};

    @Override
    public String encrypt(String decrypted) throws ServiceException {
        if(StringUtils.isNotBlank(decrypted)){
            return cryptoWrapper().encryptAes(decrypted, getKeyByEncKeyId(DBK));
        }
        return decrypted;
    }

    @Override
    public String decrypt(String encrypted) throws ServiceException {
        return cryptoWrapper().decryptAes(encrypted, getKeyByEncKeyId(DBK));
    }

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }
}
