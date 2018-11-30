package com.cts.fasttack.ih_sv.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.ih_sv.client.config.WebServicesConfiguration;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "pan", "expiryMonth", "expiryYear", "cvNum" })
@XmlRootElement(name = "cardInfo", namespace = WebServicesConfiguration.avs1Namespace)
public class CardInfo {

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String pan;

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String expiryMonth;

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String expiryYear;

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String cvNum;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvNum() {
		return cvNum;
	}

	public void setCvNum(String cvNum) {
		this.cvNum = cvNum;
	}

}
