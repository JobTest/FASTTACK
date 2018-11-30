
package com.cts.fasttack.bank.client.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://sab/}requestId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRefId"/&gt;
 *         &lt;element ref="{http://sab/}conversationId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://sab/}otp"/&gt;
 *         &lt;element name="customerPhone"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="\+380[0-9]{2}[0-9]{7}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://sab/}tokenRequestorId"/&gt;
 *         &lt;element ref="{http://sab/}lastFourOfPAN"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestId",
    "tokenRefId",
    "conversationId",
    "panInternalId",
    "panInternalGUID",
    "otp",
    "customerPhone",
    "deviceType",
    "tokenRequestorId",
    "lastFourOfPAN"
})
@XmlRootElement(name = "sendOTP", namespace = "http://sab/")
public class SendOTP {

    @XmlElementRef(name = "requestId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> requestId;

    @XmlElementRef(name = "tokenRefId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> tokenRefId;

    @XmlElementRef(name = "conversationId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> conversationId;

    @XmlElement(name = "panInternalId", namespace = "http://sab/")
    protected String panInternalId;

    @XmlElement(name = "panInternalGUID", namespace = "http://sab/")
    protected String panInternalGUID;

    @XmlElementRef(name = "otp", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> otp;

    @XmlElementRef(name = "customerPhone", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> customerPhone;

    @XmlElementRef(name = "deviceType", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> deviceType;

    @XmlElementRef(name = "tokenRequestorId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> tokenRequestorId;

    @XmlElementRef(name = "lastFourOfPAN", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> lastFourOfPAN;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public JAXBElement<String> getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the tokenRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenRefId(JAXBElement<String> value) {
        this.tokenRefId = value;
    }

    /**
     * Gets the value of the tokenRefId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getTokenRefId() {
        return tokenRefId;
    }

    /**
     * Sets the value of the requestId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRequestId(JAXBElement<String> value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the conversationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public JAXBElement<String> getConversationId() {
        return conversationId;
    }

    /**
     * Sets the value of the conversationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversationId(JAXBElement<String> value) {
        this.conversationId = value;
    }

    /**
     * Gets the value of the panInternalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanInternalId() {
        return panInternalId;
    }

    /**
     * Sets the value of the panInternalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanInternalId(String value) {
        this.panInternalId = value;
    }

    /**
     * Gets the value of the panInternalGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    /**
     * Sets the value of the panInternalGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanInternalGUID(String value) {
        this.panInternalGUID = value;
    }

    /**
     * Gets the value of the otp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public JAXBElement<String> getOtp() {
        return otp;
    }

    /**
     * Sets the value of the otp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtp(JAXBElement<String> value) {
        this.otp = value;
    }

    /**
     * Gets the value of the customerPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public JAXBElement<String> getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the value of the customerPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPhone(JAXBElement<String> value) {
        this.customerPhone = value;
    }


    /**
     * Gets the value of the deviceType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getDeviceType() {
        return deviceType;
    }

    /**
     * Sets the value of the deviceType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeviceType(JAXBElement<String> value) {
        this.deviceType = value;
    }






    /**
     * Sets the value of the tokenRequestorId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTokenRequestorId(JAXBElement<String> value) {
        this.tokenRequestorId = value;
    }

    /**
     * Gets the value of the tokenRequestorId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getTokenRequestorId() {
        return tokenRequestorId;
    }

    /**
     * Sets the value of the lastFourOfPAN property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastFourOfPAN(JAXBElement<String> value) {
        this.lastFourOfPAN = value;
    }

    /**
     * Gets the value of the lastFourOfPAN property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getLastFourOfPAN() {
        return lastFourOfPAN;
    }
}
