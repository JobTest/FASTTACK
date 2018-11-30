package com.cts.fasttack.crypto.server.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
import com.cts.fasttack.crypto.server.conf.CryptoEngineConfiguration;
import com.cts.fasttack.crypto.server.data.EncKeyId;
import com.cts.fasttack.crypto.server.util.CryptoEngineWrapper;
import com.cts.fasttack.crypto.server.util.certverification.CertificateVerificationException;
import com.cts.fasttack.crypto.server.util.certverification.CertificateVerifier;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.ObjectMapper;

import cts.mobo.hsm.objects.KeyHandle;
import cts.mobo.hsm.util.HexUtil;

/**
 * @author d.ishchenko
 */
@Service("inAppProvisioningCryptoService")
public class InAppProvisioningCryptoServiceImpl extends AbstractHSMCryptoServiceImpl
        implements InAppProvisioningCryptoService {

    private static final String PDF_FPAN = "FPAN";
    private static final String PDF_EFPAN = "eFPAN";

    private static final KeyType[] SUPPORTED_KEY_TYPES = new KeyType[] { KeyType.VTS_WSD, KeyType.TAV_PRIV };
    private static final EncKeyId TAV_PRIV_ENC_KEY_ID = new EncKeyId(KeyType.TAV_PRIV, KEY_REFCODE);

    private static byte[] appleRootCertBytes = null;

    @Autowired
    private CryptoEngineConfiguration cryptoEngineConfiguration;

    @Override
    protected KeyType[] getSupportedKeyTypes() {
        return SUPPORTED_KEY_TYPES;
    }

    @Override
    public CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(String accountNumber,
            String expiryMonth, String expiryYear, String cardholderName, InternationalPaymentSystem ips, String nonce,
            String nonceSignature, List<String> certificates, String visaWsdKeyEncryptionRule, String visaWsdKeyIndex,
            String visaPaymentDataFormat, Integer visaPanPrefixLength) throws ServiceException {

        X509Certificate leafCert;

        try {
            if (appleRootCertBytes == null) {
                loadAppleRootCert();
            }

            Set<byte[]> certChainBytes = new HashSet<byte[]>();

            for (String certificate : certificates) {
                certChainBytes.add(Base64.getDecoder()
                        .decode(certificate.replace("\n", "").replace("\r", "").replace("\t", "").replace(" ", "")));
            }

            leafCert = AppleCrypto.verifyCertChain(certChainBytes, appleRootCertBytes,
                    cryptoEngineConfiguration.isAppleCRLVerificationMandated());
        } catch (Exception ex) {
            String errorDescription = "An error occurred during verification of Apple certificates chain: "
                    + ex.getMessage();

            log.error(errorDescription, ex);

            throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
        }

        String plaintextPassData;

        if (ips.equals(InternationalPaymentSystem.V)) {
            try {
                if (visaPaymentDataFormat == null) {
                    visaPaymentDataFormat = PDF_FPAN;
                }

                if (PDF_FPAN.equals(visaPaymentDataFormat)) {
                    plaintextPassData = VisaSpecific.createFpanPlaintextPassData(accountNumber, cardholderName,
                            expiryMonth, expiryYear, nonce, nonceSignature);
                } else if (PDF_EFPAN.equals(visaPaymentDataFormat)) {
                    KeyHandle visaWsdKey = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_WSD, visaWsdKeyIndex));

                    String encryptedPrimaryAccountNumber = VisaSpecific.createEncryptedPrimaryAccountNumber(
                            accountNumber, expiryMonth, expiryYear, cryptoWrapper(), visaWsdKey,
                            visaWsdKeyEncryptionRule + "." + visaWsdKeyIndex);

                    if (cryptoEngineConfiguration.isCertificationMode()) {
                        log.info("encryptedPrimaryAccountNumber = " + encryptedPrimaryAccountNumber);
                    }

                    plaintextPassData = VisaSpecific.createEfpanPlaintextPassData(encryptedPrimaryAccountNumber,
                            cardholderName, accountNumber.substring(0, visaPanPrefixLength), nonce, nonceSignature);
                } else {
                    throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE,
                            "visaPaymentDataFormat in parameters has invalid/unsupported value '"
                                    + visaPaymentDataFormat + "'");
                }
            } catch (Exception ex) {
                String errorDescription = "An error occurred during preparation of pass data for Visa card: "
                        + ex.getMessage();

                log.error(errorDescription, ex);

                throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
            }
        } else {
            try {
                plaintextPassData = MastercardSpecific.createPlaintextPassData(accountNumber, cardholderName,
                        expiryMonth, expiryYear, nonce, nonceSignature);
            } catch (Exception ex) {
                String errorDescription = "An error occurred during preparation of pass data for Mastercard card: "
                        + ex.getMessage();

                log.error(errorDescription, ex);

                throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
            }
        }

        byte[][] encryptedPassDataResult;

        try {
            encryptedPassDataResult = AppleCrypto.createEncryptedPassData(leafCert, plaintextPassData.getBytes());
        } catch (Exception ex) {
            String errorDescription = "An error occurred during encryption of pass data: " + ex.getMessage();

            log.error(errorDescription, ex);

            throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
        }

        String activationData;
        String authCode = null;

        if (ips.equals(InternationalPaymentSystem.V)) {
            try {
                KeyHandle visaWsdKey = getKeyByEncKeyId(new EncKeyId(KeyType.VTS_WSD, visaWsdKeyIndex));

                while (true) {
                    authCode = Long.toString(Math.abs(UUID.randomUUID().getLeastSignificantBits()), 36);
                    if (authCode.length() >= 6) {
                        authCode = authCode.substring(0, 6).toUpperCase();

                        break;
                    }
                }

                activationData = VisaSpecific.createActivationData(nonce, authCode, cryptoWrapper(), visaWsdKey,
                        visaWsdKeyEncryptionRule + "." + visaWsdKeyIndex);

                if (cryptoEngineConfiguration.isCertificationMode()) {
                    log.info("activationData = " + activationData);
                }
            } catch (Exception ex) {
                String errorDescription = "An error occurred during preparation of activation data for Visa card: "
                        + ex.getMessage();

                log.error(errorDescription, ex);

                throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
            }
        } else {
            try {
                KeyHandle tavKey = getKeyByEncKeyId(TAV_PRIV_ENC_KEY_ID);

                activationData = MastercardSpecific.createActivationData(accountNumber, expiryMonth, expiryYear,
                        cryptoWrapper(), tavKey);
            } catch (Exception ex) {
                String errorDescription = "An error occurred during preparation of activation data for Mastercard card: "
                        + ex.getMessage();

                log.error(errorDescription, ex);

                throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, errorDescription);
            }
        }

        CreateInAppProvisioningDataCryptoResponse result = new CreateInAppProvisioningDataCryptoResponse();

        result.setEncryptedPassData(Base64.getEncoder().encodeToString(encryptedPassDataResult[0]));
        result.setActivationData(Base64.getEncoder().encodeToString(activationData.getBytes()));
        result.setEphemeralPublicKey(Base64.getEncoder().encodeToString(encryptedPassDataResult[1]));
        result.setAuthcode(authCode);

        return result;
    }

    private void loadAppleRootCert()
            throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, ServiceException {
        Resource artResource = cryptoEngineConfiguration.getAppleRootTruststore();

        if (artResource == null) {
            throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE,
                    "appleRootTruststore not defined in crypto-server configuration");
        }

        String arcAlias = cryptoEngineConfiguration.getAppleRootCertAlias();

        if (arcAlias == null) {
            throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE,
                    "appleRootCertAlias not defined in crypto-server configuration");
        }

        KeyStore truststore = KeyStore.getInstance("JKS");

        truststore.load(artResource.getInputStream(), null);

        Certificate cert = truststore.getCertificate(arcAlias);

        if (cert == null) {
            throw new CertificateException("The certificate with alias '" + arcAlias + "' not found in '"
                    + artResource.getFilename() + "' truststore");
        }

        if (cert instanceof X509Certificate) {
            appleRootCertBytes = ((X509Certificate) cert).getEncoded();
        } else {
            throw new CertificateException("The certificate with alias '" + arcAlias + "' read from '"
                    + artResource.getFilename() + "' truststore is not an X.509 certificate");
        }
    }

    private static class AppleCrypto {

        private final static String leafOID = "1.2.840.113635.100.6.39";

        public static X509Certificate verifyCertChain(Set<byte[]> certChainBytes, byte[] trustedRootCertBytes,
                boolean isCRLVerificationMandated) throws CertificateVerificationException {
            try {
                X509Certificate x509LeafCert = null;
                Set<X509Certificate> x509OtherCerts = new HashSet<X509Certificate>();

                CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

                X509Certificate x509TrustedRootCert;

                InputStream is = null;

                try {
                    is = new ByteArrayInputStream(trustedRootCertBytes);

                    x509TrustedRootCert = (X509Certificate) certFactory.generateCertificate(is);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }

                for (byte[] certBytes : certChainBytes) {
                    is = null;

                    try {
                        is = new ByteArrayInputStream(certBytes);

                        X509Certificate x509Cert = (X509Certificate) certFactory.generateCertificate(is);

                        if (x509Cert.equals(x509TrustedRootCert)) {
                            continue;
                        }

                        if (x509Cert.getExtensionValue(leafOID) != null) {
                            x509LeafCert = x509Cert;
                        } else {
                            x509OtherCerts.add(x509Cert);
                        }
                    } finally {
                        if (is != null) {
                            is.close();
                        }
                    }
                }

                if (x509LeafCert == null) {
                    throw new CertificateVerificationException("No leaf certificate with OID '" + leafOID + "' found");
                }

                x509OtherCerts.add(x509TrustedRootCert);

                PKIXCertPathBuilderResult cpbr = CertificateVerifier.verifyCertificate(x509LeafCert, x509OtherCerts,
                        isCRLVerificationMandated);

                if (!cpbr.getTrustAnchor().getTrustedCert().equals(x509TrustedRootCert)) {
                    throw new CertificateVerificationException(
                            "The certificate verification path did not finish at the Apple Root certificate");
                }

                return x509LeafCert;
            } catch (CertificateVerificationException ex) {
                throw ex;
            } catch (Exception ex) {
                throw new CertificateVerificationException(
                        "Exception while verifying a certificate chain: " + ex.getMessage(), ex);
            }
        }

        public static byte[][] createEncryptedPassData(X509Certificate leafCert, byte[] plaintext)
                throws CryptographyException {
            try {
                PublicKey leafCertPK = leafCert.getPublicKey();

                if (!(leafCertPK instanceof ECPublicKey)) {
                    throw new CryptographyException("The public key in the leaf certificate is not an ECC key");
                }

                ECPublicKey staticPublic = (ECPublicKey) leafCertPK;

                BouncyCastleProvider bcp = new BouncyCastleProvider();

                KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECDH", bcp);

                ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");

                kpg.initialize(ecSpec);

                KeyPair ephemeralKeyPair = kpg.generateKeyPair();

                ECPrivateKey ephemeralPrivate = (ECPrivateKey) ephemeralKeyPair.getPrivate();

                ECPublicKey ephemeralPublic = (ECPublicKey) ephemeralKeyPair.getPublic();

                KeyAgreement ka = KeyAgreement.getInstance("ECDH", bcp);

                ka.init(ephemeralPrivate);
                ka.doPhase(staticPublic, true);

                byte[] sharedSecret = ka.generateSecret();

                byte[] ephemeralPublicBytes = getUncompressedSubjectPublicKey(ephemeralPublic);

                byte[] derivedKey = kdf(sharedSecret, ephemeralPublicBytes, bcp);

                SecretKeySpec aesKey = new SecretKeySpec(derivedKey, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(
                        new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
                Cipher aesGcm = Cipher.getInstance("AES/GCM/NoPadding", bcp);

                aesGcm.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);

                return new byte[][] { aesGcm.doFinal(plaintext), ephemeralPublicBytes };
            } catch (CryptographyException ex) {
                throw ex;
            } catch (Exception ex) {
                throw new CryptographyException("Exception while encrypting pass data: " + ex.getMessage(), ex);
            }
        }

        private static byte[] getUncompressedSubjectPublicKey(ECPublicKey ecPublicKey) {
            byte[] uncompressedPubKey = new byte[65];

            uncompressedPubKey[0] = 0x04;

            byte[] affineX = ecPublicKey.getW().getAffineX().toByteArray();
            byte[] affineY = ecPublicKey.getW().getAffineY().toByteArray();

            if (affineX.length == 33)
                System.arraycopy(affineX, 1, uncompressedPubKey, 1, 32);
            else
                System.arraycopy(affineX, 0, uncompressedPubKey, 1, 32);

            if (affineY.length == 33)
                System.arraycopy(affineY, 1, uncompressedPubKey, 33, 32);
            else
                System.arraycopy(affineY, 0, uncompressedPubKey, 33, 32);

            return uncompressedPubKey;
        }

        private static byte[] kdf(byte[] sharedSecret, byte[] ephemeralPublicBytes, BouncyCastleProvider bcp)
                throws IOException, NoSuchAlgorithmException {
            final String algorithmId = "id-aes256-GCM";

            byte[] otherInfo;

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try {
                baos.write(algorithmId.length());
                baos.write(algorithmId.getBytes(StandardCharsets.UTF_8));
                baos.write("Apple".getBytes(StandardCharsets.UTF_8));
                baos.write(ephemeralPublicBytes);

                otherInfo = baos.toByteArray();
            } finally {
                baos.close();
            }

            MessageDigest sha256 = MessageDigest.getInstance("SHA-256", bcp);

            sha256.update(new byte[] { 0x00, 0x00, 0x00, 0x01 });
            sha256.update(sharedSecret);
            sha256.update(otherInfo);

            return sha256.digest();
        }

    }

    private static class VisaSpecific {

        public static String createFpanPlaintextPassData(String accountNumber, String cardholderName,
                String expiryMonth, String expiryYear, String nonce, String nonceSignature) {
            PassData passData = constructFpanPassData(accountNumber, cardholderName, expiryMonth, expiryYear, nonce,
                    nonceSignature);

            return toJson(passData);
        }

        public static String createEncryptedPrimaryAccountNumber(String pan, String expiryMonth, String expiryYear,
                CryptoEngineWrapper cryptoWrapper, KeyHandle visaWsdKey, String keysetIdentifier) {
            SimpleDateFormat datetimeSdf = new SimpleDateFormat("yyyyMMddHHmmss");

            datetimeSdf.setTimeZone(TimeZone.getTimeZone("GMT"));

            String clearInformation = "pan=" + pan + ";expiry=" + expiryMonth + expiryYear + ";datetime="
                    + datetimeSdf.format(new Date());

            String encryptedInformation = HexUtil.bytesToHex(cryptoWrapper.encrypt3DesCbcZeroIvWithVdspFormatting(
                    visaWsdKey, clearInformation.getBytes(StandardCharsets.US_ASCII)));

            return "MBPAD-1-FK-" + keysetIdentifier + "--TDEA-" + encryptedInformation;
        }

        public static String createEfpanPlaintextPassData(String encryptedPrimaryAccountNumber, String cardholderName,
                String panPrefix, String nonce, String nonceSignature) {
            PassData passData = constructEfpanPassData(encryptedPrimaryAccountNumber, cardholderName, panPrefix, nonce,
                    nonceSignature);

            return toJson(passData);
        }

        public static String createActivationData(String nonce, String authCode, CryptoEngineWrapper cryptoWrapper,
                KeyHandle visaWsdKey, String keysetIdentifier) {
            String clearInformation = "nonce=" + nonce + ";authcode=" + authCode;

            String encryptedInformation = HexUtil.bytesToHex(cryptoWrapper.encrypt3DesCbcZeroIvWithVdspFormatting(
                    visaWsdKey, clearInformation.getBytes(StandardCharsets.US_ASCII)));

            return "MBPAC-1-FK-" + keysetIdentifier + "--TDEA-" + encryptedInformation;
        }

        private static PassData constructFpanPassData(String accountNumber, String cardholderName, String expiryMonth,
                String expiryYear, String nonce, String nonceSignature) {
            PassData result = new PassData();

            result.setPrimaryAccountNumber(accountNumber);
            result.setName(cardholderName);
            result.setExpiration(expiryMonth + "/" + expiryYear);
            result.setNonce(nonce);
            result.setNonceSignature(nonceSignature);

            return result;
        }

        private static PassData constructEfpanPassData(String encryptedPrimaryAccountNumber, String cardholderName,
                String panPrefix, String nonce, String nonceSignature) {
            PassData result = new PassData();

            result.setEncryptedPrimaryAccountNumber(new String(
                    Base64.getEncoder().encode(encryptedPrimaryAccountNumber.getBytes(StandardCharsets.UTF_8)),
                    StandardCharsets.UTF_8));
            result.setName(cardholderName);
            result.setNetworkName("Visa");
            result.setNonce(nonce);
            result.setNonceSignature(nonceSignature);
            result.setPrimaryAccountNumberPrefix(panPrefix);

            return result;
        }

        private static class PassData {
            private String primaryAccountNumber;
            private String encryptedPrimaryAccountNumber;
            private String name;
            private String expiration;
            private String primaryAccountNumberPrefix;
            private String networkName;
            private String nonce;
            private String nonceSignature;

            @SuppressWarnings("unused")
            public String getPrimaryAccountNumber() {
                return primaryAccountNumber;
            }

            public void setPrimaryAccountNumber(String primaryAccountNumber) {
                this.primaryAccountNumber = primaryAccountNumber;
            }

            @SuppressWarnings("unused")
            public String getEncryptedPrimaryAccountNumber() {
                return encryptedPrimaryAccountNumber;
            }

            public void setEncryptedPrimaryAccountNumber(String encryptedPrimaryAccountNumber) {
                this.encryptedPrimaryAccountNumber = encryptedPrimaryAccountNumber;
            }

            @SuppressWarnings("unused")
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @SuppressWarnings("unused")
            public String getExpiration() {
                return expiration;
            }

            public void setExpiration(String expiration) {
                this.expiration = expiration;
            }

            @SuppressWarnings("unused")
            public String getPrimaryAccountNumberPrefix() {
                return primaryAccountNumberPrefix;
            }

            public void setPrimaryAccountNumberPrefix(String primaryAccountNumberPrefix) {
                this.primaryAccountNumberPrefix = primaryAccountNumberPrefix;
            }

            @SuppressWarnings("unused")
            public String getNetworkName() {
                return networkName;
            }

            public void setNetworkName(String networkName) {
                this.networkName = networkName;
            }

            @SuppressWarnings("unused")
            public String getNonce() {
                return nonce;
            }

            public void setNonce(String nonce) {
                this.nonce = nonce;
            }

            @SuppressWarnings("unused")
            public String getNonceSignature() {
                return nonceSignature;
            }

            public void setNonceSignature(String nonceSignature) {
                this.nonceSignature = nonceSignature;
            }
        }

        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        private static String toJson(Object object) {
            return execute(() -> OBJECT_MAPPER.writeValueAsString(object));
        }

        private static <T> T execute(ConversionCallback<T> callback) {
            try {
                return callback.call();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        private interface ConversionCallback<R> {
            R call() throws IOException;
        }

        private static class SolidusCharacterEscapes extends CharacterEscapes {

            private static final long serialVersionUID = -6772177720325892590L;

            private final int[] asciiEscapes;

            public SolidusCharacterEscapes() {
                int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();

                esc['/'] = CharacterEscapes.ESCAPE_CUSTOM;
                asciiEscapes = esc;
            }

            @Override
            public int[] getEscapeCodesForAscii() {

                return asciiEscapes;
            }

            @Override
            public SerializableString getEscapeSequence(int ch) {

                return new SerializedString("\\" + (char) ch);
            }
        }

        static {
            OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            OBJECT_MAPPER.getFactory().setCharacterEscapes(new SolidusCharacterEscapes());
        }

    }

    private static class MastercardSpecific {

        public static String createPlaintextPassData(String pan, String cardholderName, String expiryMonth,
                String expiryYear, String nonce, String nonceSignature) {
            PassData passData = constructPassData(pan, cardholderName, expiryMonth, expiryYear, nonce, nonceSignature);

            return toJson(passData);
        }

        public static String createActivationData(String pan, String expiryMonth, String expiryYear,
                CryptoEngineWrapper cryptoWrapper, KeyHandle tavKey) {

            String tavBase64Encoded = cryptoWrapper.generateTokenizationAuthenticationValue(tavKey, pan,
                    expiryMonth + expiryYear, null);

            return new String(Base64.getDecoder().decode(tavBase64Encoded.getBytes(StandardCharsets.UTF_8)),
                    StandardCharsets.UTF_8);
        }

        private static PassData constructPassData(String pan, String cardholderName, String expiryMonth,
                String expiryYear, String nonce, String nonceSignature) {
            PassData result = new PassData();

            result.setPrimaryAccountNumber(pan);
            result.setName(cardholderName);
            result.setExpiration(expiryMonth + "/" + expiryYear);
            result.setNonce(nonce);
            result.setNonceSignature(nonceSignature);

            return result;
        }

        private static class PassData {
            private String primaryAccountNumber;
            private String name;
            private String expiration;
            private String nonce;
            private String nonceSignature;

            @SuppressWarnings("unused")
            public String getPrimaryAccountNumber() {
                return primaryAccountNumber;
            }

            public void setPrimaryAccountNumber(String primaryAccountNumber) {
                this.primaryAccountNumber = primaryAccountNumber;
            }

            @SuppressWarnings("unused")
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @SuppressWarnings("unused")
            public String getExpiration() {
                return expiration;
            }

            public void setExpiration(String expiration) {
                this.expiration = expiration;
            }

            @SuppressWarnings("unused")
            public String getNonce() {
                return nonce;
            }

            public void setNonce(String nonce) {
                this.nonce = nonce;
            }

            @SuppressWarnings("unused")
            public String getNonceSignature() {
                return nonceSignature;
            }

            public void setNonceSignature(String nonceSignature) {
                this.nonceSignature = nonceSignature;
            }
        }

        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        private static String toJson(Object object) {
            return execute(() -> OBJECT_MAPPER.writeValueAsString(object));
        }

        private static <T> T execute(ConversionCallback<T> callback) {
            try {
                return callback.call();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        private interface ConversionCallback<R> {
            R call() throws IOException;
        }

        private static class SolidusCharacterEscapes extends CharacterEscapes {

            private static final long serialVersionUID = -6772177720325892590L;

            private final int[] asciiEscapes;

            public SolidusCharacterEscapes() {
                int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();

                esc['/'] = CharacterEscapes.ESCAPE_CUSTOM;
                asciiEscapes = esc;
            }

            @Override
            public int[] getEscapeCodesForAscii() {

                return asciiEscapes;
            }

            @Override
            public SerializableString getEscapeSequence(int ch) {

                return new SerializedString("\\" + (char) ch);
            }
        }

        static {
            OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            OBJECT_MAPPER.getFactory().setCharacterEscapes(new SolidusCharacterEscapes());
        }

    }
}
