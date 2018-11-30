package com.cts.fasttack.ih_sv.client.ws.saaj;

import org.springframework.ws.soap.SoapMessageCreationException;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * @author d.ishchenko
 */
public class IssuerHostSvSaajSoapMessageFactory extends SaajSoapMessageFactory {

	private boolean localLangAttributeOnSoap11FaultString = true;

	@Override
	public SaajSoapMessage createWebServiceMessage() {
		try {
			SOAPMessage saajMessage = getMessageFactory().createMessage();
			postProcess(saajMessage);
			return new IssuerHostSvSaajSoapMessage(saajMessage, localLangAttributeOnSoap11FaultString,
					getMessageFactory());
		} catch (SOAPException ex) {
			throw new SoapMessageCreationException("Could not create empty message: " + ex.getMessage(), ex);
		}
	}

	@Override
	public void setLangAttributeOnSoap11FaultString(boolean langAttributeOnSoap11FaultString) {
		super.setLangAttributeOnSoap11FaultString(langAttributeOnSoap11FaultString);
		this.localLangAttributeOnSoap11FaultString = langAttributeOnSoap11FaultString;
	}

	@Override
	protected void postProcess(SOAPMessage soapMessage) throws SOAPException {
		super.postProcess(soapMessage);
	}

}
