package com.cts.fasttack.ih.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}MPIResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mpiResponse"
})
@XmlRootElement(name = "XMLMPIResponse")
public class XMLMPIResponse {

    @XmlElement(name = "MPIResponse", required = true)
    protected MPIResponse mpiResponse;

    /**
     * Gets the value of the mpiResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MPIResponse }
     *     
     */
    public MPIResponse getMPIResponse() {
        return mpiResponse;
    }

    /**
     * Sets the value of the mpiResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MPIResponse }
     *     
     */
    public void setMPIResponse(MPIResponse value) {
        this.mpiResponse = value;
    }

}
