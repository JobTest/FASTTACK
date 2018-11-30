
package com.cts.fasttack.bank.client.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://sab/}decision"/&gt;
 *         &lt;element ref="{http://sab/}panInternalId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://sab/}code"/&gt;
 *         &lt;element ref="{http://sab/}errorMessage"/&gt;
 *         &lt;element name="customerPhone" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="\+380[0-9]{2}[0-9]{7}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "decision",
    "panInternalId",
    "panInternalGUID",
    "code",
    "errorMessage",
    "customerPhone",
    "productConfigID"
})
@XmlRootElement(name = "confirmProvisioningResponse", namespace = "http://sab/")
public class ConfirmProvisioningResponse {

//    @XmlElement(required = true)
//    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
//    protected String decision;
//    protected String panInternalId;
//    protected String panInternalGUID;
//    @XmlElement(required = true)
//    protected String code;
//    @XmlElement(required = true)
//    protected String errorMessage;
//    protected String customerPhone;
//    protected String productConfigID;


    @XmlElementRef(name = "decision", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  decision;

    @XmlElementRef(name = "panInternalId", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  panInternalId;

    @XmlElementRef(name = "panInternalGUID", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  panInternalGUID;

    @XmlElementRef(name = "code", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  code;


    @XmlElementRef(name = "errorMessage", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  errorMessage;

    @XmlElementRef(name = "customerPhone", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  customerPhone;

    @XmlElementRef(name = "productConfigID", namespace = "http://sab/", type = JAXBElement.class)
    protected JAXBElement<String>  productConfigID;


//    /**
//     * Gets the value of the decision property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getDecision() {
//        return decision;
//    }
//
//    /**
//     * Sets the value of the decision property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setDecision(String value) {
//        this.decision = value;
//    }
//
//    /**
//     * Gets the value of the panInternalId property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getPanInternalId() {
//        return panInternalId;
//    }
//
//    /**
//     * Sets the value of the panInternalId property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setPanInternalId(String value) {
//        this.panInternalId = value;
//    }
//
//    /**
//     * Gets the value of the panInternalGUID property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getPanInternalGUID() {
//        return panInternalGUID;
//    }
//
//    /**
//     * Sets the value of the panInternalGUID property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setPanInternalGUID(String value) {
//        this.panInternalGUID = value;
//    }
//
//    /**
//     * Gets the value of the code property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getCode() {
//        return code;
//    }
//
//    /**
//     * Sets the value of the code property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setCode(String value) {
//        this.code = value;
//    }
//
//    /**
//     * Gets the value of the errorMessage property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getErrorMessage() {
//        return errorMessage;
//    }
//
//    /**
//     * Sets the value of the errorMessage property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setErrorMessage(String value) {
//        this.errorMessage = value;
//    }
//
//    /**
//     * Gets the value of the customerPhone property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getCustomerPhone() {
//        return customerPhone;
//    }
//
//    /**
//     * Sets the value of the customerPhone property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setCustomerPhone(String value) {
//        this.customerPhone = value;
//    }
//
//    public String getProductConfigID() {
//        return productConfigID;
//    }
//
//    public void setProductConfigID(String productConfigID) {
//        this.productConfigID = productConfigID;
//    }


    public JAXBElement<String> getDecision() {
        return decision;
    }

    public void setDecision(JAXBElement<String> decision) {
        this.decision = decision;
    }

    public JAXBElement<String> getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(JAXBElement<String> panInternalId) {
        this.panInternalId = panInternalId;
    }

    public JAXBElement<String> getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(JAXBElement<String> panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }

    public JAXBElement<String> getCode() {
        return code;
    }

    public void setCode(JAXBElement<String> code) {
        this.code = code;
    }

    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(JAXBElement<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public JAXBElement<String> getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(JAXBElement<String> customerPhone) {
        this.customerPhone = customerPhone;
    }

    public JAXBElement<String> getProductConfigID() {
        return productConfigID;
    }

    public void setProductConfigID(JAXBElement<String> productConfigID) {
        this.productConfigID = productConfigID;
    }
}
