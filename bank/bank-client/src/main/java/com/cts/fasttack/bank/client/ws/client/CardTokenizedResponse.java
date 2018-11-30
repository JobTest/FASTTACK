
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
 *         &lt;element ref="{http://sab/}panInternalId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID"/&gt;
 *         &lt;element ref="{http://sab/}code"/&gt;
 *         &lt;element ref="{http://sab/}errorMessage"/&gt;
 *         &lt;element ref="{http://sab/}customerPhone"/&gt;
 *         &lt;element ref="{http://sab/}customerId"/&gt;
 *         &lt;element ref="{http://sab/}conversationId"/&gt;
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
    "panInternalId",
    "panInternalGUID",
    "code",
    "errorMessage",
    "customerPhone",
    "customerId",
    "conversationId"
})
@XmlRootElement(name = "cardTokenizedResponse", namespace = "http://sab/")
public class CardTokenizedResponse {

    @XmlElementRef(name = "requestId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> requestId;

    @XmlElementRef(name = "panInternalId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> panInternalId;

    @XmlElementRef(name = "panInternalGUID", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> panInternalGUID;

    @XmlElementRef(name = "code", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> code;

    @XmlElementRef(name = "errorMessage", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> errorMessage;

    @XmlElementRef(name = "customerPhone", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> customerPhone;

    @XmlElementRef(name = "customerId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> customerId;

    @XmlElementRef(name = "conversationId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String> conversationId;

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
     * Gets the value of the panInternalId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getPanInternalId() {
        return panInternalId;
    }

    /**
     * Sets the value of the panInternalId property.
     *
     * @param panInternalId
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPanInternalId(JAXBElement<String> panInternalId) {
        this.panInternalId = panInternalId;
    }

    /**
     * Gets the value of the panInternalGUID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getPanInternalGUID() {
        return panInternalGUID;
    }

    /**
     * Sets the value of the panInternalGUID property.
     *
     * @param panInternalGUID
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPanInternalGUID(JAXBElement<String> panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
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
     * @param errorMessage
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorMessage(JAXBElement<String> errorMessage) {
        this.errorMessage = errorMessage;
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
     * @param customerPhone
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerPhone(JAXBElement<String> customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Gets the value of the customerId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     *
     * @param customerId
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerId(JAXBElement<String> customerId) {
        this.customerId = customerId;
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
     * @param conversationId
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConversationId(JAXBElement<String> conversationId) {
        this.conversationId = conversationId;
    }
}
