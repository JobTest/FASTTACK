package com.cts.fasttack.crypto.server.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Cryptography engine configuration
 * @author Anton Leliuk
 */
@Component
@ConfigurationProperties("spring.fasttack.crypto")
public class CryptoEngineConfiguration {

    private int slotId;

    private String password;

    private String encryptionKeyIndexForVtsWsd;

    private Resource appleRootTruststore;

    private String appleRootCertAlias;

    private boolean appleCRLVerificationMandated;

    private boolean certificationMode;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptionKeyIndexForVtsWsd() {
        return encryptionKeyIndexForVtsWsd;
    }

    public void setEncryptionKeyIndexForVtsWsd(String encryptionKeyIndexForVtsWsd) {
        this.encryptionKeyIndexForVtsWsd = encryptionKeyIndexForVtsWsd;
    }

    public Resource getAppleRootTruststore() {
        return appleRootTruststore;
    }

    public void setAppleRootTruststore(Resource appleRootTruststore) {
        this.appleRootTruststore = appleRootTruststore;
    }

    public String getAppleRootCertAlias() {
        return appleRootCertAlias;
    }

    public void setAppleRootCertAlias(String appleRootCertAlias) {
        this.appleRootCertAlias = appleRootCertAlias;
    }

    public boolean isAppleCRLVerificationMandated() {
        return appleCRLVerificationMandated;
    }

    public void setAppleCRLVerificationMandated(boolean appleCRLVerificationMandated) {
        this.appleCRLVerificationMandated = appleCRLVerificationMandated;
    }

    public boolean isCertificationMode() {
        return certificationMode;
    }

    public void setCertificationMode(boolean certificationMode) {
        this.certificationMode = certificationMode;
    }

}
