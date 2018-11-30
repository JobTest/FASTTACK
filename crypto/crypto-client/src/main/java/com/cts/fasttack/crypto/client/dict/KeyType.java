package com.cts.fasttack.crypto.client.dict;

public enum KeyType implements Dict{

//    PEK(KeyAlg.AES),
//    KEK_CMS(KeyAlg.AES),
    DBK(KeyAlg.AES),
//    CMS_LPUBKEY(KeyAlg.RSA_PUBLIC),
//    CMS_LSECKEY(KeyAlg.RSA_PRIVATE),
    CEK(KeyAlg.DES3),

//    /** Keys for signature checking*/
//    BANK_SDK_SIG_PUB(KeyAlg.RSA_PUBLIC),
//    BANK_SDK_ENC_PRIV(KeyAlg.RSA_PRIVATE),


//    /**
//     * MDES keys
//     */
//    KEK_MDES(KeyAlg.AES),
//    CCM_MDES(KeyAlg.AES),
    MDES_PUB(KeyAlg.RSA_PUBLIC),
//    TAV_SEC(KeyAlg.RSA_PRIVATE),
//    MDES_CUSTOMER_SEC(KeyAlg.RSA_PRIVATE),

      MDES_CUSTOMER_PRIV(KeyAlg.RSA_PRIVATE),

    /** Issuer Master Key (для VISA) */
    VTS_IAPI_ISS_PRIV(KeyAlg.RSA_PRIVATE),
    VTS_IAPI_VISA_CERT(KeyAlg.RSA_CERTIFICATE),
//    VTS_ABK_PUB(KeyAlg.RSA_PUBLIC),
    VTS_WSD(KeyAlg.DES3),

    /* Key for JMS*/
    JMS(KeyAlg.AES),

    /* Keys for Alfabank*/
    //OPC_PUB(KeyAlg.RSA_PUBLIC),
    TAV_PRIV(KeyAlg.RSA_PRIVATE),

    /* Key for AVS1 service on Smartvista*/
    SV_AVS1(KeyAlg.DES3);

    private final KeyAlg keyAlg;

    KeyType(KeyAlg keyAlg){
        this.keyAlg = keyAlg;
    }

    public KeyAlg keyAlg() {
        return keyAlg;
    }

    public String getKey(){
        return name();
    }

    public String getCaption() {
        return name();
    }

    public static KeyType getInstance(String source) {
        for (KeyType item : KeyType.values()) {
            if (item.name().equals(source)) {
                return item;
            }
        }
        return null;
    }
}
