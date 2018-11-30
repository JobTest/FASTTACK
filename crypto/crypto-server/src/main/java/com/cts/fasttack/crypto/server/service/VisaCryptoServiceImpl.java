package com.cts.fasttack.crypto.server.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.client.dto.TripleDESEncryptionResultDto;
import com.cts.fasttack.crypto.server.conf.CryptoEngineConfiguration;
import com.cts.fasttack.crypto.server.data.EncKeyId;
import com.cts.fasttack.crypto.server.exception.UnexpectedKidException;
import com.cts.fasttack.crypto.server.util.JweHelper;

import cts.mobo.hsm.objects.KeyHandle;
import cts.mobo.hsm.util.HexUtil;

/**
 * @author Dmitry Koval
 */
@Service
public class VisaCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements VisaCryptoService {

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.VTS_IAPI_ISS_PRIV, KeyType.VTS_IAPI_VISA_CERT, KeyType.VTS_WSD};

    @Autowired
    private CryptoEngineConfiguration cryptoEngineConfiguration;

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String decrypt(String encryptData) {
        KeyHandle visaCertificateHandle = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_IAPI_VISA_CERT, KEY_REFCODE));

        KeyHandle issuerPrivateKeyHandle = null;
        String kid = JweHelper.extractKid(encryptData);
        try {
            issuerPrivateKeyHandle = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_IAPI_ISS_PRIV, kid));
        } catch (CryptographyException ex) {
        	log.warn("Could not find Issuer Private Key with REFCODE = " + kid);
        }
        if (issuerPrivateKeyHandle == null) {
            try {
                issuerPrivateKeyHandle = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_IAPI_ISS_PRIV, KEY_REFCODE));
            } catch (CryptographyException ex) {
            	log.debug("Default Issuer Private Key with REFCODE = " + KEY_REFCODE + " not registered");
            }
        }
        if (issuerPrivateKeyHandle == null) {
        	throw new UnexpectedKidException(kid);
        }

        return cryptoWrapper().verifyAndDecryptIapiEncryptedData(visaCertificateHandle, issuerPrivateKeyHandle, encryptData);
    }

    @Override
    public String decryptWith3desAlgorithm(String encryptedData, String encryptionKeyIndex) throws ServiceException {
        KeyHandle visaKey = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_WSD, encryptionKeyIndex));
        return new String(cryptoWrapper().decrypt3DesCbcZeroIvWithVdspFormatting(visaKey, HexUtil.hexToBytes(encryptedData)), StandardCharsets.UTF_8);
    }

    @Override
    public TripleDESEncryptionResultDto encryptWith3desAlgorithm(String data) throws ServiceException {
        TripleDESEncryptionResultDto encryptionResult = new TripleDESEncryptionResultDto();

        KeyHandle visaKey = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_WSD, cryptoEngineConfiguration.getEncryptionKeyIndexForVtsWsd()));
        encryptionResult.setEncryptedData(HexUtil.bytesToHex(cryptoWrapper().encrypt3DesCbcZeroIvWithVdspFormatting(visaKey, data.getBytes())));
        encryptionResult.setEncryptionKeyIndex(cryptoEngineConfiguration.getEncryptionKeyIndexForVtsWsd());

        return encryptionResult;
    }

}
