package com.cts.fasttack.visa.vnts.server.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;

/**
 * Cardholder Info object
 *
 * @author a.lipavets
 */
public class CardholderInfoDto {

    /**
     * This field is used to describe which version of the Encrypted Data Blob structure is populated in this request.
     */
    @Size(min = 1, max = 32, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String version;

    /**
     * Index of symmetric double-length 3DES key used to encrypt the data
     */
    @Size(min = 1, max = 8, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String encryptionKeyIndex;

    /**
     * Data are encrypted using double-length 3DES symmetric key.
     */
    @Size(min = 1, max = 512, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[0-9a-fA-F]+|^$", message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String encryptedData;

    /* getters and setters*/

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncryptionKeyIndex() {
        return encryptionKeyIndex;
    }

    public void setEncryptionKeyIndex(String encryptionKeyIndex) {
        this.encryptionKeyIndex = encryptionKeyIndex;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
