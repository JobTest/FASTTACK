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
 *       &lt;sequence>
 *         &lt;element ref="{}Code"/>
 *         &lt;element ref="{}ErrorMessage" minOccurs="0"/>
 *         &lt;element ref="{}ErrorDetail" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{}MPIEnrolResponse"/>
 *           &lt;element ref="{}MPIAuthResponse"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "errorMessage",
    "errorDetail",
    "mpiEnrolResponse",
    "mpiAuthResponse"
})
@XmlRootElement(name = "MPIResponse")
public class MPIResponse {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "ErrorDetail")
    protected String errorDetail;
    @XmlElement(name = "MPIEnrolResponse")
    protected MPIEnrolResponse mpiEnrolResponse;
    @XmlElement(name = "MPIAuthResponse")
    protected MPIAuthResponse mpiAuthResponse;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
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
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDetail() {
        return errorDetail;
    }

    /**
     * Sets the value of the errorDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDetail(String value) {
        this.errorDetail = value;
    }

    /**
     * Gets the value of the mpiEnrolResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MPIEnrolResponse }
     *     
     */
    public MPIEnrolResponse getMPIEnrolResponse() {
        return mpiEnrolResponse;
    }

    /**
     * Sets the value of the mpiEnrolResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MPIEnrolResponse }
     *     
     */
    public void setMPIEnrolResponse(MPIEnrolResponse value) {
        this.mpiEnrolResponse = value;
    }

    /**
     * Gets the value of the mpiAuthResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MPIAuthResponse }
     *     
     */
    public MPIAuthResponse getMPIAuthResponse() {
        return mpiAuthResponse;
    }

    /**
     * Sets the value of the mpiAuthResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MPIAuthResponse }
     *     
     */
    public void setMPIAuthResponse(MPIAuthResponse value) {
        this.mpiAuthResponse = value;
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

}
