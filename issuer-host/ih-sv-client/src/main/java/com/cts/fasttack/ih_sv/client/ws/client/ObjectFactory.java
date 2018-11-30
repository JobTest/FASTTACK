package com.cts.fasttack.ih_sv.client.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.cts.fasttack.ih_sv.client.config.WebServicesConfiguration;

@XmlRegistry
public class ObjectFactory {

	private final static QName _RequestId_QNAME = new QName(WebServicesConfiguration.avs1Namespace, "requestId");
	private final static QName _Code_QNAME = new QName(WebServicesConfiguration.avs1Namespace, "code");

	public Avs1Request createAvs1Request() {
		return new Avs1Request();
	}

	public Avs1Response createAvs1Response() {
		return new Avs1Response();
	}

	@XmlElementDecl(namespace = WebServicesConfiguration.avs1Namespace, name = "requestId", scope = Avs1Response.class)
	public JAXBElement<String> createRequestId(String value) {
		return new JAXBElement<String>(_RequestId_QNAME, String.class, Avs1Response.class, value);
	}

	@XmlElementDecl(namespace = WebServicesConfiguration.avs1Namespace, name = "code", scope = Avs1Response.class)
	public JAXBElement<String> createCode(String value) {
		return new JAXBElement<String>(_Code_QNAME, String.class, Avs1Response.class, value);
	}

}
