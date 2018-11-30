package com.cts.fasttack.crypto.server.util;

import java.nio.charset.StandardCharsets;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.StringUtil;
import cts.mobo.hsm.CryptoEngine;
import cts.mobo.hsm.objects.KeyHandle;
import cts.mobo.hsm.util.HexUtil;
import cts.mobo.hsm.util.RsaKeyUtil;
import cts.mobo.hsm.util.SymmetricKeyUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Оберка над методами HSM, бросающая корректные исключения
 */
public class CryptoEngineWrapper {

	/**
	 * Число, которому должна быть кратна строка, чтобы ее можно было
	 * зашифровать AES алгоритмом
	 */
	private final static int AES_LENGTH = 16;

	/**
	 * Число, которому должна быть кратна строка, чтобы ее можно было
	 * зашифровать DES алгоритмом
	 */
	private final static int DES_LENGTH = 8;

	private final Logger log = LogManager.getLogger(getClass());

	private CryptoEngine engine;

	public CryptoEngineWrapper(CryptoEngine engine) {
		this.engine = engine;
	}

	public String encryptAes(String decrypted, KeyHandle keyHandle) throws ServiceException {
		try {
			byte[] decryptedBytes = convertToMultipleBytes(decrypted.getBytes(StandardCharsets.UTF_8), AES_LENGTH);
			byte[] encryptedBytes = engine.symmetricKeyAlg().encrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES, decryptedBytes);
			return HexUtil.bytesToHex(encryptedBytes);
		} catch (Exception e) {
			log.error("Error in AES encryption", e);
			throw new CryptographyException(e);
		}
	}

    public String decryptAes(String encrypted, KeyHandle keyHandle){
        return new String(decryptAesGetBytes(encrypted, keyHandle), StandardCharsets.UTF_8);
    }

	public String encryptAes256(String decrypted, KeyHandle keyHandle) throws ServiceException {
		try {
			byte[] decryptedBytes = convertToMultipleBytes(decrypted.getBytes(StandardCharsets.UTF_8), AES_LENGTH);
			byte[] encryptedBytes = engine.symmetricKeyAlg().encrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES_256, decryptedBytes);
			return HexUtil.bytesToHex(encryptedBytes);
		} catch (Exception e) {
			log.error("Error in AES 256 encryption", e);
			throw new CryptographyException(e);
		}
	}

    public String decryptAes256(String encrypted, KeyHandle keyHandle){
        return new String(decryptAes256GetBytes(encrypted, keyHandle), StandardCharsets.UTF_8);
    }

	public String encryptAes256Cbc(String decrypted, String hexIv, KeyHandle keyHandle) throws ServiceException {
		try {
			byte[] decryptedBytes = convertToMultipleBytes(decrypted.getBytes(StandardCharsets.UTF_8), AES_LENGTH);
			byte[] iv = HexUtil.hexToBytes(hexIv);
			byte[] encryptedBytes = engine.symmetricKeyAlg().encryptCbc(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES_256, iv, decryptedBytes);
			return HexUtil.bytesToHex(encryptedBytes);
		} catch (Exception e) {
			log.error("Error in AES 256 CBC encryption", e);
			throw new CryptographyException(e);
		}
	}

    public String decryptAes256Cbc(String encrypted, KeyHandle keyHandle, String hexIv){
        return new String(decryptAes256CbcGetBytes(encrypted, keyHandle, hexIv), StandardCharsets.UTF_8);
    }

	public String encrypt3Des(String decrypted, KeyHandle keyHandle) throws ServiceException {
		try {
			byte[] decryptedBytes = convertToMultipleBytes(decrypted.getBytes(StandardCharsets.UTF_8), DES_LENGTH);
			byte[] encryptedBytes = engine.symmetricKeyAlg().encrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.DES3, decryptedBytes);
			return HexUtil.bytesToHex(encryptedBytes);
		} catch (Exception e) {
			log.error("Error in 3DES encryption", e);
			throw new CryptographyException(e);
		}
	}

    public String decrypt3Des(String encrypted, KeyHandle keyHandle){
        return new String(decrypt3DesGetBytes(encrypted, keyHandle), StandardCharsets.UTF_8);
    }

    public String encrypt3DesCbcWithPkcs5Padding(String clearText, String hexIv, KeyHandle keyHandle) throws ServiceException {
        try {
            byte[] clearTextBytes = clearText.getBytes(StandardCharsets.UTF_8);
            byte[] paddedBytes = padPkcs5(clearTextBytes);
            byte[] iv = HexUtil.hexToBytes(hexIv);
            byte[] encryptedBytes = engine.symmetricKeyAlg().encryptCbc(keyHandle, SymmetricKeyUtil.KEY_TYPE.DES3, iv, paddedBytes);
            return HexUtil.bytesToHex(encryptedBytes);
        } catch (Exception e) {
            log.error("Error in 3DES CBC with PKCS#5 padding encryption", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Расшифровывает AES|DES ключ, зашифрованный под LMK
     */
    public KeyHandle unwrapSymmetricUnderLMK(SymmetricKeyUtil.KEY_TYPE type, String wrappedKey) {
        try {
            return engine.symmetricKeyAlg().unwrapKey_LMK(type, HexUtil.hexToBytes(wrappedKey));
        } catch (Exception e) {
            log.error("Error unwrapping key", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Зашифровывает RSA под LMK
     */
    public KeyHandle unwrapRsaUnderLMK(String wrappedKey) {
        try {
            return engine.rsaKeyAlg().unwrapKey_LMK(HexUtil.hexToBytes(wrappedKey));
        } catch (Exception e) {
            log.error("Error unwrapping key", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Создает публичный ключ RSA
     */
    public KeyHandle createRsaPublicKey(String privateKeyUnderLMK, String publicExponent) {
        try {
            return engine.rsaKeyAlg().createPublicKey(HexUtil.hexToBytes(privateKeyUnderLMK),
                    HexUtil.hexToBytes(publicExponent));
        } catch (Exception e) {
            log.error("Error creating RSA public key", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Creates certificate in HSM
     *
     * @param pemEncodedCertificate PEM-encoded certificate. Can start with <code>-----BEGIN CERTIFICATE-----</code> and end with <code>-----END CERTIFICATE-----</code>
     *
     * @return Key handle of certificate
     */
    public KeyHandle createRsaCertificate(String pemEncodedCertificate) {
        try {
            log.debug("Pem-encoded RSA certificate:\n" + pemEncodedCertificate);

            byte[] asn1bytes = rsaCertificateAsn1Bytes(pemEncodedCertificate);

            log.debug("Creating RSA certificate from ASN1 bytes (HEX):\n" + HexUtil.bytesToHex(asn1bytes));

            return engine.rsaKeyAlg().createX509Certificate(asn1bytes);
        } catch (Exception e) {
            log.error("Can't create RSA certificate", e);
            throw new CryptographyException(e);
        }
    }

    public KeyHandle createSymmetricKey(SymmetricKeyUtil.KEY_TYPE type){
        try {
            return engine.symmetricKeyAlg().generateKey(type);
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    public byte[] generateRandomData(int length){
        try {
            return engine.mpaAlg().generateRandomData(length);
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    /**
     * Удаляет DES|AES ключ, выполняя проверку на null
     */
    public void deleteSymmetricKey(KeyHandle keyHandle) {
        try {
            if (keyHandle != null) {
                engine.symmetricKeyAlg().deleteKey(keyHandle);
            }
        } catch (Exception e) {
            log.error("Error deleting key", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Удаляет RSA ключ, выполняя проверку на null
     */
    public void deleteRSAKey(KeyHandle keyHandle) {
        try {
            if (keyHandle != null) {
                engine.rsaKeyAlg().deleteKey(keyHandle);
            }
        } catch (Exception e) {
            log.error("Error deleting key", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Расшифровует AES ключ
     * @param keyHandle
     * @param encryptedKey
     * @return
     */
    public KeyHandle decryptAesWithRsa(KeyHandle keyHandle, String encryptedKey){
        try {
            return engine.rsaKeyAlg().decrypt(keyHandle,
                    HexUtil.hexToBytes(encryptedKey),
                    SymmetricKeyUtil.KEY_TYPE.AES,
                    RsaKeyUtil.RSA_MECHANISM_TYPE.RSA_PKCS);
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    public byte[] encryptRsaWithAes(KeyHandle publicKey, KeyHandle aesKey){
        try {
            return engine.rsaKeyAlg().encrypt(publicKey, aesKey, RsaKeyUtil.RSA_MECHANISM_TYPE.RSA_PKCS);
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    /**
     *
     * @param keyHandle
     * @param encryptedKey
     * @param oaepAlgorithm
     * @return
     */
    public KeyHandle decryptOaep(KeyHandle keyHandle, String encryptedKey, String oaepAlgorithm){
        try {
            return engine.rsaKeyAlg().decryptOaep(keyHandle,
                    HexUtil.hexToBytes(encryptedKey),
                    SymmetricKeyUtil.KEY_TYPE.AES,
                    RsaKeyUtil.OAEP_HASHING_ALG.valueOf(oaepAlgorithm));
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    public byte[] encryptOaep(KeyHandle publicKey, KeyHandle aesKey, String oaepAlgorithm){
        try {
            return engine.rsaKeyAlg().encryptOaep(publicKey, aesKey, RsaKeyUtil.OAEP_HASHING_ALG.valueOf(oaepAlgorithm));
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    /**
     *
     * @param keyHandle
     * @param iv
     * @param encryptedData
     * @return
     */
    public byte[] decryptAesCbcWithPkcs7Padding(KeyHandle keyHandle, String iv, String encryptedData){
        try {
            return engine.mastercardAlg().
                    decryptAesCbcWithPkcs7Padding(keyHandle,
                            HexUtil.hexToBytes(iv),
                            HexUtil.hexToBytes(encryptedData));
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    public byte[] encryptAesCbcWithPkcs7Padding(KeyHandle keyHandle, byte[] iv, byte[] encryptedData){
        try {
            return engine.mastercardAlg()
                    .encryptAesCbcWithPkcs7Padding(
                            keyHandle,
                            iv,
                            encryptedData);
        } catch (Exception e) {
            throw new CryptographyException(e);
        }
    }

    public String generateTokenizationAuthenticationValue(KeyHandle keyHandle, String pan, String expDateMMYY, String tokenUniqueReference){
        try {
            return this.engine.mastercardAlg().buildSignedTav(keyHandle, pan, expDateMMYY, tokenUniqueReference);
        } catch (Exception e){
            log.error("Can't build signed TAV", e);
            throw new CryptographyException(e);
        }

    }

    public byte[] encrypt3DesCbcZeroIvWithVdspFormatting(KeyHandle keyHandle, byte[] clearData) {
        try {
            return this.engine.visaAlg().encrypt3DesCbcZeroIvWithVdspFormatting(keyHandle, clearData);
        } catch (Exception e){
            log.error("Can't encrypt with 3des algirithm.");
            throw new CryptographyException(e);
        }
    }

    public byte[] decrypt3DesCbcZeroIvWithVdspFormatting(KeyHandle keyHandle, byte[] encryptedData) {
        try {
            return this.engine.visaAlg().decrypt3DesCbcZeroIvWithVdspFormatting(keyHandle, encryptedData);
        } catch (Exception e){
            log.error("Can't decrypt with 3des algirithm.");
            throw new CryptographyException(e);
        }
    }

    public String verifyAndDecryptIapiEncryptedData(KeyHandle cert, KeyHandle privKey, String encryptedData) {
        try {
            return this.engine.visaAlg().verifyAndDecryptIapiEncryptedData(cert, privKey, encryptedData);
        } catch (Exception e){
            throw new CryptographyException(e);
        }
    }

    /**
     * Зашифровывает PAN
     */
    public String encryptPan(String pan, KeyHandle CEK) {
        try {
            return engine.panAlg().encryptPan(pan, CEK);
        } catch (Exception e) {
            log.error("Error encrypting PAN", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Extracts clear ASN-1 data from RSA X509 Pem-encoded certificate
     * @param pemEncodedCertificate Incoming certificate.
     * Can look like<br><code><br>-----BEGIN CERTIFICATE-----<br>AAA...==<br>-----END CERTIFICATE-----</code>
     * @return Certificate data for ASN1-decoding
     */
    private byte[] rsaCertificateAsn1Bytes(String pemEncodedCertificate) {
        assert pemEncodedCertificate != null;

        String clearedPem = pemEncodedCertificate.replace("-----BEGIN CERTIFICATE-----", "")
                .replace("-----END CERTIFICATE-----", "");

        return new Base64().decode(clearedPem);
    }

    private byte[] decryptAesGetBytes(String encrypted, KeyHandle keyHandle){
        byte[] encryptedBytes = HexUtil.hexToBytes(encrypted);
        try {
            return engine.symmetricKeyAlg().decrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES,
                    encryptedBytes);
        } catch (Exception e) {
            log.error("Error in AES decryption", e);
            throw new CryptographyException(e);
        }
    }

    private byte[] decryptAes256GetBytes(String encrypted, KeyHandle keyHandle){
        byte[] encryptedBytes = HexUtil.hexToBytes(encrypted);
        try {
            return engine.symmetricKeyAlg().decrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES_256,
                    encryptedBytes);
        } catch (Exception e) {
            log.error("Error in AES 256 decryption", e);
            throw new CryptographyException(e);
        }
    }

    private byte[] decryptAes256CbcGetBytes(String encrypted, KeyHandle keyHandle, String hexIv){
        byte[] encryptedBytes = HexUtil.hexToBytes(encrypted);
        byte[] iv = HexUtil.hexToBytes(hexIv);
        try {
            return engine.symmetricKeyAlg().decryptCbc(keyHandle, SymmetricKeyUtil.KEY_TYPE.AES_256,
                    iv, encryptedBytes);
        } catch (Exception e) {
            log.error("Error in AES 256 CBC decryption", e);
            throw new CryptographyException(e);
        }
    }

    private byte[] decrypt3DesGetBytes(String encrypted, KeyHandle keyHandle){
        byte[] encryptedBytes = HexUtil.hexToBytes(encrypted);
        try {
            return engine.symmetricKeyAlg().decrypt(keyHandle, SymmetricKeyUtil.KEY_TYPE.DES3,
                    encryptedBytes);
        } catch (Exception e) {
            log.error("Error in 3DES decryption", e);
            throw new CryptographyException(e);
        }
    }

    /**
     * Дополняет пробелы в начале строки, чтобы ее можно было зашифровать AES/3DES алгоритмом
     * @param value строка в виде байт, которую необходимо зашифровать
     * @param multiple требуемая кратность длины строки
     * @return строка, длина которой кратна multiple, с добавленными пробелами
     */
    private byte[] convertToMultipleBytes(byte[] value, int multiple) {
        return StringUtil.appendSymbolSequenceToBytes(value, getMultipleLength(value.length, multiple), ' ', true);
    }

    /**
     * Возвращает длину, кратную multiple, округленную в большую сторону
     * @param length длина строки, которую нужно округлить
     * @param multiple требуемая кратность
     */
    private int getMultipleLength(int length, int multiple) {
        return roundToHigher(length, multiple);
    }

    /**
     * Возвращает значение, кратное multiple, округленное в большую сторону.
     * @param value значение, которое нужно округлить
     */
    private int roundToHigher(int value, int multiple) {
        return (value - (value % multiple)) + (value % multiple == 0 ? 0 : multiple);
    }

    private byte[] padPkcs5(byte[] input) {
        int inputLength = input.length;
        int padLength = 8 - inputLength % 8;
        int resultLength = inputLength + padLength;
        byte[] result = new byte[resultLength];

        System.arraycopy(input, 0, result, 0, inputLength);

        for (int i = inputLength; i < resultLength; ++i) {
                result[i] = (byte) padLength;
        }

        return result;
    }

}
