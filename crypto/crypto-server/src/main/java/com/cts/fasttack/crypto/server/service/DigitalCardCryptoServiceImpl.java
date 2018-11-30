package com.cts.fasttack.crypto.server.service;

import org.springframework.stereotype.Service;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;

import cts.mobo.hsm.objects.KeyHandle;

/**
 * @author Anton Leliuk
 */
@Service("digitalCardCryptoService")
public class DigitalCardCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements DigitalCardCryptoService {

    /**
     * Клеится к началу зашифрованного пана
     */
    private static final String PAN_ENCRYPTED_PREFIX = "A";

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.CEK};

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String encryptPan(String pan) {
        return PAN_ENCRYPTED_PREFIX + pan.substring(pan.length() - 1) + Integer.toString(pan.length() - 10) + cryptoWrapper().encryptPan(pan, getCEKforBIN(pan));
    }

    private KeyHandle getCEKforBIN(String pan){
        String bin = pan.startsWith(PAN_ENCRYPTED_PREFIX) ? extractPanLastNumberFromEncrypted(pan) : pan.substring(pan.length() - 1);
        EncKeyId encKeyId = new EncKeyId(KeyType.CEK,bin);
        return getKeyByEncKeyId(encKeyId);
    }

    private String extractPanLastNumberFromEncrypted(String encryptedPan){
        return encryptedPan.substring(1, 2);
    }
}
