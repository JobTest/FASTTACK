package com.cts.fasttack.crypto.server.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;
import com.cts.fasttack.crypto.server.dto.CryptoCardInfo;
import com.cts.fasttack.crypto.server.dto.CryptoCardInfoData;
import com.cts.fasttack.crypto.server.dto.IssuerInitiatedDigitizationDto;

import cts.mobo.hsm.objects.KeyHandle;
import cts.mobo.hsm.util.HexUtil;
import cts.mobo.hsm.util.SymmetricKeyUtil;

/**
 * @author Anton Leliuk
 */
@Service("pushProvisioningCryptoService")
public class PushProvisioningCryptoServiceImpl extends AbstractHSMCryptoServiceImpl implements PushProvisioningCryptoService {

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[]{KeyType.TAV_PRIV};
    private static final EncKeyId TAV_PRIV_ENC_KEY_ID = new EncKeyId(KeyType.TAV_PRIV, KEY_REFCODE);

    @Autowired
    private MdesCryptoService mdesCryptoService;

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public String encryptOpaqueBody(String publicKeyFingerprint, String tavKeyFingerprint, String oaepHashingAlgorithm, String accountNumber, String expiryMonth, String expiryYear, String cardholderName) throws ServiceException {
        CryptoCardInfoData cardInfoData = createCardInfoData(accountNumber, expiryMonth, expiryYear, cardholderName);

        String cidJson = JsonUtil.toJson(cardInfoData);

        CryptoCardInfo cardInfo = createCardInfo(publicKeyFingerprint, oaepHashingAlgorithm, cidJson);

        IssuerInitiatedDigitizationDto iidd = new IssuerInitiatedDigitizationDto();
        iidd.setCardInfo(cardInfo);
        if(StringUtils.isNotBlank(tavKeyFingerprint)){
            KeyHandle tavKey = getKeyByEncKeyId(TAV_PRIV_ENC_KEY_ID);
            iidd.setTokenizationAuthenticationValue(cryptoWrapper().generateTokenizationAuthenticationValue(tavKey, accountNumber, expiryMonth + expiryYear, null));
        } else {
            iidd.setTokenizationAuthenticationValue(null);
        }

        String iiddJson = JsonUtil.toJson(iidd);

        return new String(Base64.getEncoder().encode(iiddJson.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    private CryptoCardInfo createCardInfo(String publicKeyFingerprint, String oaepHashingAlgorithm, String cidJson) {

        CryptoCardInfo cardInfo = new CryptoCardInfo();
        cardInfo.setPublicKeyFingerprint(publicKeyFingerprint);
        cardInfo.setOaepHashingAlgorithm(oaepHashingAlgorithm);

        KeyHandle publicKey = mdesCryptoService.getKeyByEncKeyId(new EncKeyId(KeyType.MDES_PUB, publicKeyFingerprint));

        KeyHandle aesKey = null;
        try {
            aesKey = cryptoWrapper().createSymmetricKey(SymmetricKeyUtil.KEY_TYPE.AES);

            byte[] ivBytes = cryptoWrapper().generateRandomData(16);

            String encryptedData = HexUtil.bytesToHex(cryptoWrapper().encryptAesCbcWithPkcs7Padding(aesKey,
                    ivBytes, cidJson.getBytes(StandardCharsets.UTF_8)));

            String iv = HexUtil.bytesToHex(ivBytes);

            byte[] encryptedKeyBytes;

            if (StringUtils.isBlank(oaepHashingAlgorithm)) {
                encryptedKeyBytes = cryptoWrapper().encryptRsaWithAes(publicKey, aesKey);
            } else {
                encryptedKeyBytes = cryptoWrapper().encryptOaep(publicKey, aesKey, oaepHashingAlgorithm);
            }

            String encryptedKey = HexUtil.bytesToHex(encryptedKeyBytes);

            cardInfo.setEncryptedKey(encryptedKey);
            cardInfo.setIv(iv);
            cardInfo.setEncryptedData(encryptedData);

            return cardInfo;
        } catch (Exception e) {
            throw new CryptographyException(e);
        } finally {
            if (aesKey != null) {
                cryptoWrapper().deleteSymmetricKey(aesKey);
            }
        }
    }

    private CryptoCardInfoData createCardInfoData(String accountNumber, String expiryMonth, String expiryYear, String cardholderName) {
        CryptoCardInfoData data = new CryptoCardInfoData();
        data.setExpiryMonth(expiryMonth);
        data.setExpiryYear(expiryYear);
        data.setCardholderName(cardholderName);
        data.setAccountNumber(accountNumber);
        data.setSource("CARD_ADDED_VIA_APPLICATION");
        return data;
    }
}
