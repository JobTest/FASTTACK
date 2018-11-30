package com.cts.fasttack.visa.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pingResponse", namespace = "http://vnts.visa.com/tpcas/v1")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PingResponseDto {

	private String responseCode;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

}
