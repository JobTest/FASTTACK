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
 *         &lt;element ref="{}PostauthorizationData"/>
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
    "postauthorizationData"
})
@XmlRootElement(name = "Postauthorization")
public class Postauthorization {

    @XmlElement(name = "PostauthorizationData", required = true)
    protected PostauthorizationData postauthorizationData;

    /**
     * Gets the value of the postauthorizationData property.
     * 
     * @return
     *     possible object is
     *     {@link PostauthorizationData }
     *     
     */
    public PostauthorizationData getPostauthorizationData() {
        return postauthorizationData;
    }

    /**
     * Sets the value of the postauthorizationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostauthorizationData }
     *     
     */
    public void setPostauthorizationData(PostauthorizationData value) {
        this.postauthorizationData = value;
    }

}
