package com.cts.fasttack.crypto.server.service;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;

import cts.mobo.hsm.objects.KeyHandle;

/**
 * @author a.lipavets
 */
@Service("mdesCryptoService")
public class MdesCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements MdesCryptoService {


    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.MDES_CUSTOMER_PRIV, KeyType.MDES_PUB};

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String decryptWithMdesCustomerPriv(String encryptedData, String encryptedKey, String publicKeyFingerprint, String oaepAlgorithm, String iv) {

        KeyHandle mdes = getKeyByEncKeyId(new EncKeyId(
                KeyType.MDES_CUSTOMER_PRIV, publicKeyFingerprint));

        KeyHandle aesKeyHandle;
        if (StringUtils.isBlank(oaepAlgorithm)) {
            aesKeyHandle = cryptoWrapper().decryptAesWithRsa(mdes, encryptedKey);
        } else {
            aesKeyHandle = cryptoWrapper().decryptOaep(mdes, encryptedKey, oaepAlgorithm);
        }

        try {
            return new String(cryptoWrapper().decryptAesCbcWithPkcs7Padding(aesKeyHandle, iv, encryptedData), StandardCharsets.UTF_8);
        } finally {
            cryptoWrapper().deleteSymmetricKey(aesKeyHandle);
        }
    }


}
