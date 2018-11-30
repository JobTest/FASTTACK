package com.cts.fasttack.bank.server.pushprovisioning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
@ConfigurationProperties("spring.opaque.card")
public class CreateOpaqueCardParameters {

    private String publicKeyFingerprint;
    private String tavKeyFingerprint;
    private String oaepHashingAlgorithm;

    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
    }

    public void setPublicKeyFingerprint(String publicKeyFingerprint) {
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    public String getTavKeyFingerprint() {
        return tavKeyFingerprint;
    }

    public void setTavKeyFingerprint(String tavKeyFingerprint) {
        this.tavKeyFingerprint = tavKeyFingerprint;
    }

    public String getOaepHashingAlgorithm() {
        return oaepHashingAlgorithm;
    }

    public void setOaepHashingAlgorithm(String oaepHashingAlgorithm) {
        this.oaepHashingAlgorithm = oaepHashingAlgorithm;
    }
}
