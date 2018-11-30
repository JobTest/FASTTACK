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
 *         &lt;choice>
 *           &lt;element ref="{}AncillaryData"/>
 *           &lt;element ref="{}ItineraryData"/>
 *         &lt;/choice>
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
    "ancillaryData",
    "itineraryData"
})
@XmlRootElement(name = "VISA")
public class VISA {

    @XmlElement(name = "AncillaryData")
    protected AncillaryData ancillaryData;
    @XmlElement(name = "ItineraryData")
    protected ItineraryData itineraryData;

    /**
     * Gets the value of the ancillaryData property.
     * 
     * @return
     *     possible object is
     *     {@link AncillaryData }
     *     
     */
    public AncillaryData getAncillaryData() {
        return ancillaryData;
    }

    /**
     * Sets the value of the ancillaryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AncillaryData }
     *     
     */
    public void setAncillaryData(AncillaryData value) {
        this.ancillaryData = value;
    }

    /**
     * Gets the value of the itineraryData property.
     * 
     * @return
     *     possible object is
     *     {@link ItineraryData }
     *     
     */
    public ItineraryData getItineraryData() {
        return itineraryData;
    }

    /**
     * Sets the value of the itineraryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItineraryData }
     *     
     */
    public void setItineraryData(ItineraryData value) {
        this.itineraryData = value;
    }

}
