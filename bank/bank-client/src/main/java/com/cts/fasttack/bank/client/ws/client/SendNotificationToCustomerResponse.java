
package com.cts.fasttack.bank.client.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{http://sab/}code"/&gt;
 *         &lt;element ref="{http://sab/}errorMessage"/&gt;
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
    "code",
    "errorMessage"
})
@XmlRootElement(name = "sendNotificationToCustomerResponse", namespace = "http://sab/")
public class SendNotificationToCustomerResponse {

    @XmlElementRef(name = "requestId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> requestId;

    @XmlElementRef(name = "code", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> code;

    @XmlElementRef(name = "errorMessage", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> errorMessage;

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
     * Sets the value of the requestId property.
     * 
     * @param requestId
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(JAXBElement<String> requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param code
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCode(JAXBElement<String> code) {
        this.code = code;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(JAXBElement<String> value) {
        this.errorMessage = value;
    }

}
