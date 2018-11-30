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
 *         &lt;element name="customerRef" type="{}typeX20"/>
 *         &lt;element name="passengerName" type="{}typeX29"/>
 *         &lt;element name="ticketNumber" type="{}typeX15"/>
 *         &lt;element name="restrictedTicketIndicator" type="{}typeRestrTicketInd"/>
 *         &lt;element name="ticketIssueDate" type="{}typeX8" minOccurs="0"/>
 *         &lt;element name="totalFare" type="{}typeX12" minOccurs="0"/>
 *         &lt;element name="totalFees" type="{}typeX12" minOccurs="0"/>
 *         &lt;element name="totalTax" type="{}typeX12" minOccurs="0"/>
 *         &lt;element name="travelAgencyCode" type="{}typeX8" minOccurs="0"/>
 *         &lt;element name="travelAgencyName" type="{}typeX25" minOccurs="0"/>
 *         &lt;element ref="{}MCTripLegs"/>
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
    "customerRef",
    "passengerName",
    "ticketNumber",
    "restrictedTicketIndicator",
    "ticketIssueDate",
    "totalFare",
    "totalFees",
    "totalTax",
    "travelAgencyCode",
    "travelAgencyName",
    "mcTripLegs"
})
@XmlRootElement(name = "MasterCard")
public class MasterCard {

    @XmlElement(required = true)
    protected String carrierCode;
    @XmlElement(required = true)
    protected String customerRef;
    @XmlElement(required = true)
    protected String passengerName;
    @XmlElement(required = true)
    protected String ticketNumber;
    @XmlElement(required = true)
    protected String restrictedTicketIndicator;
    protected String ticketIssueDate;
    protected String totalFare;
    protected String totalFees;
    protected String totalTax;
    protected String travelAgencyCode;
    protected String travelAgencyName;
    @XmlElement(name = "MCTripLegs", required = true)
    protected MCTripLegs mcTripLegs;

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
     * Gets the value of the customerRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerRef() {
        return customerRef;
    }

    /**
     * Sets the value of the customerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerRef(String value) {
        this.customerRef = value;
    }

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
     * Gets the value of the ticketIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketIssueDate() {
        return ticketIssueDate;
    }

    /**
     * Sets the value of the ticketIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketIssueDate(String value) {
        this.ticketIssueDate = value;
    }

    /**
     * Gets the value of the totalFare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalFare() {
        return totalFare;
    }

    /**
     * Sets the value of the totalFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalFare(String value) {
        this.totalFare = value;
    }

    /**
     * Gets the value of the totalFees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalFees() {
        return totalFees;
    }

    /**
     * Sets the value of the totalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalFees(String value) {
        this.totalFees = value;
    }

    /**
     * Gets the value of the totalTax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalTax() {
        return totalTax;
    }

    /**
     * Sets the value of the totalTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalTax(String value) {
        this.totalTax = value;
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
     * Gets the value of the mcTripLegs property.
     * 
     * @return
     *     possible object is
     *     {@link MCTripLegs }
     *     
     */
    public MCTripLegs getMCTripLegs() {
        return mcTripLegs;
    }

    /**
     * Sets the value of the mcTripLegs property.
     * 
     * @param value
     *     allowed object is
     *     {@link MCTripLegs }
     *     
     */
    public void setMCTripLegs(MCTripLegs value) {
        this.mcTripLegs = value;
    }

}
