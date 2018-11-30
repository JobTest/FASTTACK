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
 *         &lt;element ref="{}MPIEnrolRequest"/>
 *         &lt;element ref="{}MPIAuthRequest"/>
 *       &lt;/choice>
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
    "mpiEnrolRequest",
    "mpiAuthRequest"
})
@XmlRootElement(name = "MPIRequest")
public class MPIRequest {

    @XmlElement(name = "MPIEnrolRequest")
    protected MPIEnrolRequest mpiEnrolRequest;
    @XmlElement(name = "MPIAuthRequest")
    protected MPIAuthRequest mpiAuthRequest;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Gets the value of the mpiEnrolRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MPIEnrolRequest }
     *     
     */
    public MPIEnrolRequest getMPIEnrolRequest() {
        return mpiEnrolRequest;
    }

    /**
     * Sets the value of the mpiEnrolRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MPIEnrolRequest }
     *     
     */
    public void setMPIEnrolRequest(MPIEnrolRequest value) {
        this.mpiEnrolRequest = value;
    }

    /**
     * Gets the value of the mpiAuthRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MPIAuthRequest }
     *     
     */
    public MPIAuthRequest getMPIAuthRequest() {
        return mpiAuthRequest;
    }

    /**
     * Sets the value of the mpiAuthRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MPIAuthRequest }
     *     
     */
    public void setMPIAuthRequest(MPIAuthRequest value) {
        this.mpiAuthRequest = value;
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
