package com.cts.fasttack.ih.client.converter.xml;

import com.cts.fasttack.ih.client.config.IssuerHostClientParameters;
import org.apache.xml.security.Init;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.opensaml.security.crypto.KeySupport;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.MarshallingFailureException;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * Xml converter which add XML Digital Signature to the document
 * @author Anton Leliuk
 */
public class XmlDigitalSignatureMarshallingHttpMessageConverter extends MarshallingHttpMessageConverter implements InitializingBean {

    private IssuerHostClientParameters parameters;

    private Marshaller marshaller;

    private PrivateKey privateKey;

    public XmlDigitalSignatureMarshallingHttpMessageConverter(Marshaller marshaller, IssuerHostClientParameters parameters) {
        super(marshaller);
        this.marshaller = marshaller;
        this.parameters = parameters;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Init.init();
        privateKey = KeySupport.decodePrivateKey(parameters.getPrivateKeyPemFile().getFile(), parameters.getKeyPassword().toCharArray());
    }

    @Override
    protected void writeToResult(Object o, HttpHeaders headers, Result result) throws IOException {
        Assert.notNull(this.marshaller, "Property 'marshaller' is required");
        try {
            DOMResult domResult = new DOMResult();
            this.marshaller.marshal(o, domResult);

            Document document = (Document) domResult.getNode();

            XMLSignature signature = new XMLSignature(document, "#", XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1, Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);

            Transforms contentTransforms = new Transforms(document);

            contentTransforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
            contentTransforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
            signature.addDocument("", contentTransforms, Constants.ALGO_ID_DIGEST_SHA1);

            Element signatureElement = signature.getElement();

            document.getDocumentElement().appendChild(signatureElement);

            signature.sign(privateKey);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(domResult.getNode());
            transformer.transform(source, result);

        } catch (MarshallingFailureException | XMLSecurityException | TransformerException ex) {
            throw new HttpMessageNotWritableException("Could not write [" + o + "]", ex);
        }
    }
}
