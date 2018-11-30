package com.cts.fasttack.common.core.util;

import com.cts.fasttack.common.core.exception.InvalidJsonXmlException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Anton Leliuk
 */
public class XmlUtil {

    private static final Logger log = LogManager.getLogger(XmlUtil.class);

    private static final XmlMapper XML_MAPPER = new XmlMapper();

    static {
        XML_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        XML_MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        XML_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        XML_MAPPER.addMixIn(JAXBElement.class, JaxbElementMixIn.class);
    }

    public static String toXml(Object object){
        try {
            return XML_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new InvalidJsonXmlException(e);
        }
    }

    public static String toXmlJAXB(Object object, Class<?> clazz){
        try {
        	StringWriter stringWriter = new StringWriter();

            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.marshal(object, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new InvalidJsonXmlException(e);
        }
    }

}
