package com.cts.fasttack.ih.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}XMLPayRequest"/>
 *         &lt;element ref="{}XMLPayResponse"/>
 *         &lt;element ref="{}XMLMPIRequest"/>
 *         &lt;element ref="{}XMLMPIResponse"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "xmlPayRequest",
    "xmlPayResponse",
    "xmlmpiRequest",
    "xmlmpiResponse"
})
@XmlRootElement(name = "Message")
public class Message {

    @XmlElement(name = "XMLPayRequest")
    protected XMLPayRequest xmlPayRequest;
    @XmlElement(name = "XMLPayResponse")
    protected XMLPayResponse xmlPayResponse;
    @XmlElement(name = "XMLMPIRequest")
    protected XMLMPIRequest xmlmpiRequest;
    @XmlElement(name = "XMLMPIResponse")
    protected XMLMPIResponse xmlmpiResponse;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the xmlPayRequest property.
     * 
     * @return
     *     possible object is
     *     {@link XMLPayRequest }
     *     
     */
    public XMLPayRequest getXMLPayRequest() {
        return xmlPayRequest;
    }

    /**
     * Sets the value of the xmlPayRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLPayRequest }
     *     
     */
    public void setXMLPayRequest(XMLPayRequest value) {
        this.xmlPayRequest = value;
    }

    /**
     * Gets the value of the xmlPayResponse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLPayResponse }
     *     
     */
    public XMLPayResponse getXMLPayResponse() {
        return xmlPayResponse;
    }

    /**
     * Sets the value of the xmlPayResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLPayResponse }
     *     
     */
    public void setXMLPayResponse(XMLPayResponse value) {
        this.xmlPayResponse = value;
    }

    /**
     * Gets the value of the xmlmpiRequest property.
     * 
     * @return
     *     possible object is
     *     {@link XMLMPIRequest }
     *     
     */
    public XMLMPIRequest getXMLMPIRequest() {
        return xmlmpiRequest;
    }

    /**
     * Sets the value of the xmlmpiRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLMPIRequest }
     *     
     */
    public void setXMLMPIRequest(XMLMPIRequest value) {
        this.xmlmpiRequest = value;
    }

    /**
     * Gets the value of the xmlmpiResponse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLMPIResponse }
     *     
     */
    public XMLMPIResponse getXMLMPIResponse() {
        return xmlmpiResponse;
    }

    /**
     * Sets the value of the xmlmpiResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLMPIResponse }
     *     
     */
    public void setXMLMPIResponse(XMLMPIResponse value) {
        this.xmlmpiResponse = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
