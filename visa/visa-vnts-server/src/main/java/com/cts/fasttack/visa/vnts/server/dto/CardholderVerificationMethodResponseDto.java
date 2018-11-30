package com.cts.fasttack.visa.vnts.server.dto;

import com.cts.fasttack.visa.common.dto.CommonVisaResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author a.lipavets
 */
@JacksonXmlRootElement(localName = "getCardHolderVerificationMethodsRes", namespace = "http://vnts.visa.com/tpcas/v1")
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "getCardHolderVerificationMethodsRes", namespace = "http://vnts.visa.com/tpcas/v1")
public class CardholderVerificationMethodResponseDto extends CommonVisaResponseDto {

    @JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(namespace = "http://vnts.visa.com/tpcas/v1")
    private List<CardholderVerificationMethodDto> cardholderVerificationMethod;

    @JsonIgnore
    @XmlTransient
    private String maskedPan;

    @JsonIgnore
    @XmlTransient
    private String panInternalId;

    @JsonIgnore
    @XmlTransient
    private String panInternalGuid;

    public List<CardholderVerificationMethodDto> getCardholderVerificationMethod() {
        return cardholderVerificationMethod;
    }

    public void setCardholderVerificationMethod(List<CardholderVerificationMethodDto> cardholderVerificationMethod) {
        this.cardholderVerificationMethod = cardholderVerificationMethod;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }
}
