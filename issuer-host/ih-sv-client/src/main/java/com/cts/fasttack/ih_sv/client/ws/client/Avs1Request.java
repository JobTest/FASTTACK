package com.cts.fasttack.ih_sv.client.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.ih_sv.client.config.WebServicesConfiguration;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "requestId", "encryptionKeyIndex", "encryptedData" })
@XmlRootElement(name = "AVS1Request", namespace = WebServicesConfiguration.avs1Namespace)
public class Avs1Request {

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String requestId;

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String encryptionKeyIndex;

	@XmlElement(namespace = WebServicesConfiguration.avs1Namespace, required = true, nillable = true)
	private String encryptedData;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
