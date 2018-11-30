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
 *         &lt;element name="legNr" type="{}typeLegNr"/>
 *         &lt;element name="arrivalTime" type="{}typeX4" minOccurs="0"/>
 *         &lt;element name="conjunctTicket" type="{}typeX15" minOccurs="0"/>
 *         &lt;element name="couponNumber" type="{}typeX1" minOccurs="0"/>
 *         &lt;element name="departureTime" type="{}typeX4" minOccurs="0"/>
 *         &lt;element name="endorsementsRestr" type="{}typeX20" minOccurs="0"/>
 *         &lt;element name="exchangeTicket" type="{}typeX15" minOccurs="0"/>
 *         &lt;element name="fareAmnt" type="{}typeX12" minOccurs="0"/>
 *         &lt;element name="fareBasis" type="{}typeX15" minOccurs="0"/>
 *         &lt;element name="feesAmnt" type="{}typeX12" minOccurs="0"/>
 *         &lt;element name="stopOverCode" type="{}typeX1" minOccurs="0"/>
 *         &lt;element name="taxAmnt" type="{}typeX12" minOccurs="0"/>
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
    "legNr",
    "arrivalTime",
    "conjunctTicket",
    "couponNumber",
    "departureTime",
    "endorsementsRestr",
    "exchangeTicket",
    "fareAmnt",
    "fareBasis",
    "feesAmnt",
    "stopOverCode",
    "taxAmnt",
    "tripNumber"
})
@XmlRootElement(name = "MCTripLeg")
public class MCTripLeg {

    @XmlElement(required = true)
    protected String carrierCode;
    @XmlElement(required = true)
    protected String departureAirport;
    @XmlElement(required = true)
    protected String departureDate;
    @XmlElement(required = true)
    protected String destinationAirport;
    @XmlElement(required = true)
    protected String legNr;
    protected String arrivalTime;
    protected String conjunctTicket;
    protected String couponNumber;
    protected String departureTime;
    protected String endorsementsRestr;
    protected String exchangeTicket;
    protected String fareAmnt;
    protected String fareBasis;
    protected String feesAmnt;
    protected String stopOverCode;
    protected String taxAmnt;
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
     * Gets the value of the arrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalTime(String value) {
        this.arrivalTime = value;
    }

    /**
     * Gets the value of the conjunctTicket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConjunctTicket() {
        return conjunctTicket;
    }

    /**
     * Sets the value of the conjunctTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConjunctTicket(String value) {
        this.conjunctTicket = value;
    }

    /**
     * Gets the value of the couponNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCouponNumber() {
        return couponNumber;
    }

    /**
     * Sets the value of the couponNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCouponNumber(String value) {
        this.couponNumber = value;
    }

    /**
     * Gets the value of the departureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureTime(String value) {
        this.departureTime = value;
    }

    /**
     * Gets the value of the endorsementsRestr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndorsementsRestr() {
        return endorsementsRestr;
    }

    /**
     * Sets the value of the endorsementsRestr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndorsementsRestr(String value) {
        this.endorsementsRestr = value;
    }

    /**
     * Gets the value of the exchangeTicket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExchangeTicket() {
        return exchangeTicket;
    }

    /**
     * Sets the value of the exchangeTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExchangeTicket(String value) {
        this.exchangeTicket = value;
    }

    /**
     * Gets the value of the fareAmnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareAmnt() {
        return fareAmnt;
    }

    /**
     * Sets the value of the fareAmnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareAmnt(String value) {
        this.fareAmnt = value;
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
     * Gets the value of the feesAmnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeesAmnt() {
        return feesAmnt;
    }

    /**
     * Sets the value of the feesAmnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeesAmnt(String value) {
        this.feesAmnt = value;
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
     * Gets the value of the taxAmnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxAmnt() {
        return taxAmnt;
    }

    /**
     * Sets the value of the taxAmnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxAmnt(String value) {
        this.taxAmnt = value;
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
