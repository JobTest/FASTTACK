package com.cts.fasttack.bank.client.ws.saaj;

import org.springframework.util.ObjectUtils;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageException;
import org.springframework.ws.transport.TransportConstants;
import org.springframework.ws.transport.TransportOutputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * SAAJ-specific implementation of the {@link SoapMessage} interface. Created via the {@link BankSaajSoapMessageFactory},
 * wraps a {@link SOAPMessage}.
 * @author Anton Leliuk
 */
public class BankSaajSoapMessage extends SaajSoapMessage {

    public BankSaajSoapMessage(SOAPMessage soapMessage, boolean langAttributeOnSoap11FaultString, MessageFactory messageFactory) {
        super(soapMessage, langAttributeOnSoap11FaultString, messageFactory);
    }

    /**
     * Override default method writeTo to remove header Accept
     */
    @Override
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            SOAPMessage message = getSaajMessage();
            message.getMimeHeaders().removeHeader(TransportConstants.HEADER_ACCEPT);
            message.saveChanges();
            if (outputStream instanceof TransportOutputStream) {
                TransportOutputStream transportOutputStream = (TransportOutputStream) outputStream;
                // some SAAJ implementations (Axis 1) do not have a Content-Type header by default
                MimeHeaders headers = message.getMimeHeaders();
                if (ObjectUtils.isEmpty(headers.getHeader(TransportConstants.HEADER_CONTENT_TYPE))) {
                    SOAPEnvelope envelope1 = message.getSOAPPart().getEnvelope();
                    if (envelope1.getElementQName().getNamespaceURI().equals(SoapVersion.SOAP_11.getEnvelopeNamespaceUri())) {
                        headers.addHeader(TransportConstants.HEADER_CONTENT_TYPE, SoapVersion.SOAP_11.getContentType());
                    } else {
                        headers.addHeader(TransportConstants.HEADER_CONTENT_TYPE, SoapVersion.SOAP_12.getContentType());
                    }
                    message.saveChanges();
                }
                for (Iterator<?> iterator = headers.getAllHeaders(); iterator.hasNext();) {
                    MimeHeader mimeHeader = (MimeHeader) iterator.next();
                    transportOutputStream.addHeader(mimeHeader.getName(), mimeHeader.getValue());
                }
            }
            message.writeTo(outputStream);

            outputStream.flush();
        } catch (SOAPException ex) {
            throw new SaajSoapMessageException("Could not write message to OutputStream: " + ex.getMessage(), ex);
        }
    }
}
