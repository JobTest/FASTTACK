package com.cts.fasttack.bank.server.pushprovisioning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author d.ishchenko
 */
@Component
@ConfigurationProperties("spring.inapp.provisioning")
public class CreateInAppProvisioningDataParameters {

    private String visaWsdKeyEncryptionRule;
    private String visaWsdKeyIndex;
    private String visaPaymentDataFormat;
    private Integer visaPanPrefixLength;

    public String getVisaWsdKeyEncryptionRule() {
        return visaWsdKeyEncryptionRule;
    }

    public void setVisaWsdKeyEncryptionRule(String visaWsdKeyEncryptionRule) {
        this.visaWsdKeyEncryptionRule = visaWsdKeyEncryptionRule;
    }

    public String getVisaWsdKeyIndex() {
        return visaWsdKeyIndex;
    }

    public void setVisaWsdKeyIndex(String visaWsdKeyIndex) {
        this.visaWsdKeyIndex = visaWsdKeyIndex;
    }

    public String getVisaPaymentDataFormat() {
        return visaPaymentDataFormat;
    }

    public void setVisaPaymentDataFormat(String visaPaymentDataFormat) {
        this.visaPaymentDataFormat = visaPaymentDataFormat;
    }

    public Integer getVisaPanPrefixLength() {
        return visaPanPrefixLength;
    }

    public void setVisaPanPrefixLength(Integer visaPanPrefixLength) {
        this.visaPanPrefixLength = visaPanPrefixLength;
    }

}
