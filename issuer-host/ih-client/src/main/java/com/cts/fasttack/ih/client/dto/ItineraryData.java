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
 *         &lt;element name="passengerName" type="{}typeX29"/>
 *         &lt;element name="ticketNumber" type="{}typeX15"/>
 *         &lt;element name="restrictedTicketIndicator" type="{}typeRestrTicketInd"/>
 *         &lt;element name="travelAgencyCode" type="{}typeX8" minOccurs="0"/>
 *         &lt;element name="travelAgencyName" type="{}typeX25" minOccurs="0"/>
 *         &lt;element ref="{}VTripLegs"/>
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
    "passengerName",
    "ticketNumber",
    "restrictedTicketIndicator",
    "travelAgencyCode",
    "travelAgencyName",
    "vTripLegs"
})
@XmlRootElement(name = "ItineraryData")
public class ItineraryData {

    @XmlElement(required = true)
    protected String passengerName;
    @XmlElement(required = true)
    protected String ticketNumber;
    @XmlElement(required = true)
    protected String restrictedTicketIndicator;
    protected String travelAgencyCode;
    protected String travelAgencyName;
    @XmlElement(name = "VTripLegs", required = true)
    protected VTripLegs vTripLegs;

    /**
     * Gets the value of the passengerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Sets the value of the passengerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerName(String value) {
        this.passengerName = value;
    }

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Gets the value of the restrictedTicketIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictedTicketIndicator() {
        return restrictedTicketIndicator;
    }

    /**
     * Sets the value of the restrictedTicketIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictedTicketIndicator(String value) {
        this.restrictedTicketIndicator = value;
    }

    /**
     * Gets the value of the travelAgencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelAgencyCode() {
        return travelAgencyCode;
    }

    /**
     * Sets the value of the travelAgencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelAgencyCode(String value) {
        this.travelAgencyCode = value;
    }

    /**
     * Gets the value of the travelAgencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelAgencyName() {
        return travelAgencyName;
    }

    /**
     * Sets the value of the travelAgencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelAgencyName(String value) {
        this.travelAgencyName = value;
    }

    /**
     * Gets the value of the vTripLegs property.
     * 
     * @return
     *     possible object is
     *     {@link VTripLegs }
     *     
     */
    public VTripLegs getVTripLegs() {
        return vTripLegs;
    }

    /**
     * Sets the value of the vTripLegs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VTripLegs }
     *     
     */
    public void setVTripLegs(VTripLegs value) {
        this.vTripLegs = value;
    }

}
