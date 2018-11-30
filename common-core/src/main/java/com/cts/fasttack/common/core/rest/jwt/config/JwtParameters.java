package com.cts.fasttack.common.core.rest.jwt.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class JwtParameters implements InitializingBean {

    public static final JWSAlgorithm JWS_ALGORITHM = JWSAlgorithm.HS256;

    public static final String JWT_HEADER = "FT-JWT-SIGNATURE";

    private String sharedSecret = "$xudFxQpSqrO/apXPJ5J/jXFiaBBMdC8ZA#3Zkh2";

    private MACSigner signer;

    private MACVerifier verifier;

    @Override
    public void afterPropertiesSet() throws Exception {
        // Create HMAC signer
        signer = new MACSigner(sharedSecret);

        // On the consumer side, parse the JWS and verify its HMAC
        verifier = new MACVerifier(sharedSecret);
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }

    public MACSigner getSigner() {
        return signer;
    }

    public MACVerifier getVerifier() {
        return verifier;
    }
}
