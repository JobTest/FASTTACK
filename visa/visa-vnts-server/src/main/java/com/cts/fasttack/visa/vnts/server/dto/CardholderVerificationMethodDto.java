package com.cts.fasttack.visa.vnts.server.dto;


import com.cts.fasttack.visa.vnts.server.dict.OtpMethodPlatform;
import com.cts.fasttack.visa.vnts.server.dict.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Max occurrence up to 10
 * If Action Code is 00 then at least one occurrence of Cardholder Verifcation Method should be populated

 * @author a.lipavets
 */
@JsonInclude(Include.NON_NULL)
public class CardholderVerificationMethodDto {

    /**
     * cell_phone
     * email
     * bank_app*
     * customer_service
     * outbound_call
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private Type type;

    /**
     * Masked values for consumer contact information
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String value;

    /**
     * This ID should be provided by the issuer.
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String identifier;

	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private String sourceAddress;

    /**
     * This feld is used when the Type feld contains the value bank_app.
     */
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private OtpMethodPlatform otpMethodPlatform;

    /* getters and setters */

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public OtpMethodPlatform getOtpMethodPlatform() {
        return otpMethodPlatform;
    }

    public void setOtpMethodPlatform(OtpMethodPlatform otpMethodPlatform) {
        this.otpMethodPlatform = otpMethodPlatform;
    }
}
