package com.cts.fasttack.crypto.client.dict;

import cts.mobo.hsm.util.SymmetricKeyUtil.KEY_TYPE;

/**
 * Алгоритм шифрования, с которым применяется ключ
 */
public enum KeyAlg {

    AES(KEY_TYPE.AES),
    AES_256(KEY_TYPE.AES_256),
    DES3(KEY_TYPE.DES3),
    RSA_PUBLIC(null),
    RSA_PRIVATE(null),
    RSA_CERTIFICATE(null);

    private KEY_TYPE symmetricKeyType;

    KeyAlg(KEY_TYPE symmetricKeyType) {
        this.symmetricKeyType = symmetricKeyType;
    }

    public boolean isPrivate() {
        return this == RSA_PRIVATE;
    }

    public boolean isPublic() {
        return this == RSA_PUBLIC;
    }

    public boolean isSymmetric() {
        return this == AES || this == AES_256 || this == DES3;
    }

    public boolean isCertificate() {
        return this == RSA_CERTIFICATE;
    }

    public KEY_TYPE getSymmetricKeyType() {
        return symmetricKeyType;
    }
}
