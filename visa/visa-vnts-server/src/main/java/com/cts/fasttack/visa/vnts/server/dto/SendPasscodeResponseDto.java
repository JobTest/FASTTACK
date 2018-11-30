package com.cts.fasttack.visa.vnts.server.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.cts.fasttack.visa.common.dto.CommonVisaResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * SendPasscodeRes Response
 *
 * @author a.lipavets
 */
@JacksonXmlRootElement(localName = "sendPasscodeRes", namespace = "http://vnts.visa.com/tpcas/v1")
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "sendPasscodeRes", namespace = "http://vnts.visa.com/tpcas/v1")
public class SendPasscodeResponseDto extends CommonVisaResponseDto {

	@JsonIgnore
    @XmlTransient
    private String panInternalId;

    @JsonIgnore
    @XmlTransient
    private String panInternalGuid;

    @JsonIgnore
    @XmlTransient
    private String maskedPan;

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

	public String getMaskedPan() {
		return maskedPan;
	}

	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}
}
