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
 *         &lt;element name="carrierCode" type="{}typeX2"/>
 *         &lt;element name="departureAirport" type="{}typeX5"/>
 *         &lt;element name="departureDate" type="{}typeDateYYYYMMDD"/>
 *         &lt;element name="destinationAirport" type="{}typeX5"/>
 *         &lt;element name="serviceClass" type="{}typeX2"/>
 *         &lt;element name="legNr" type="{}typeLegNr"/>
 *         &lt;element name="fareBasis" type="{}typeX15" minOccurs="0"/>
 *         &lt;element name="stopOverCode" type="{}typeX1" minOccurs="0"/>
 *         &lt;element name="tripNumber" type="{}typeX5" minOccurs="0"/>
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
    "carrierCode",
    "departureAirport",
    "departureDate",
    "destinationAirport",
    "serviceClass",
    "legNr",
    "fareBasis",
    "stopOverCode",
    "tripNumber"
})
@XmlRootElement(name = "VTripLeg")
public class VTripLeg {

    @XmlElement(required = true)
    protected String carrierCode;
    @XmlElement(required = true)
    protected String departureAirport;
    @XmlElement(required = true)
    protected String departureDate;
    @XmlElement(required = true)
    protected String destinationAirport;
    @XmlElement(required = true)
    protected String serviceClass;
    @XmlElement(required = true)
    protected String legNr;
    protected String fareBasis;
    protected String stopOverCode;
    protected String tripNumber;

    /**
     * Gets the value of the carrierCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * Sets the value of the carrierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierCode(String value) {
        this.carrierCode = value;
    }

    /**
     * Gets the value of the departureAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Sets the value of the departureAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureAirport(String value) {
        this.departureAirport = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureDate(String value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the destinationAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * Sets the value of the destinationAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationAirport(String value) {
        this.destinationAirport = value;
    }

    /**
     * Gets the value of the serviceClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceClass() {
        return serviceClass;
    }

    /**
     * Sets the value of the serviceClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceClass(String value) {
        this.serviceClass = value;
    }

    /**
     * Gets the value of the legNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegNr() {
        return legNr;
    }

    /**
     * Sets the value of the legNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegNr(String value) {
        this.legNr = value;
    }

    /**
     * Gets the value of the fareBasis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareBasis() {
        return fareBasis;
    }

    /**
     * Sets the value of the fareBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareBasis(String value) {
        this.fareBasis = value;
    }

    /**
     * Gets the value of the stopOverCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopOverCode() {
        return stopOverCode;
    }

    /**
     * Sets the value of the stopOverCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopOverCode(String value) {
        this.stopOverCode = value;
    }

    /**
     * Gets the value of the tripNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripNumber() {
        return tripNumber;
    }

    /**
     * Sets the value of the tripNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripNumber(String value) {
        this.tripNumber = value;
    }

}
