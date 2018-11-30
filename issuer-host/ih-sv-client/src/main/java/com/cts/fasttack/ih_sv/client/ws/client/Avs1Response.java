package com.cts.fasttack.ih_sv.client.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.ih_sv.client.config.WebServicesConfiguration;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "requestId", "code" })
@XmlRootElement(name = "AVS1Response", namespace = WebServicesConfiguration.avs1Namespace)
public class Avs1Response {

	@XmlElementRef(name = "requestId", namespace = WebServicesConfiguration.avs1Namespace, type = JAXBElement.class, required = true)
	protected JAXBElement<String> requestId;

	@XmlElementRef(name = "code", namespace = WebServicesConfiguration.avs1Namespace, type = JAXBElement.class, required = true)
	protected JAXBElement<String> code;

	public JAXBElement<String> getRequestId() {
		return requestId;
	}

	public void setRequestId(JAXBElement<String> requestId) {
		this.requestId = requestId;
	}

	public JAXBElement<String> getCode() {
		return code;
	}

	public void setCode(JAXBElement<String> code) {
		this.code = code;
	}

}
