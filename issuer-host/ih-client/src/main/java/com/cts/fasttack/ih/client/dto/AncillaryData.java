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
 *         &lt;element name="origTicketNumber" type="{}typeX15" minOccurs="0"/>
 *         &lt;element name="creditReasonIndicator" type="{}typeX1" minOccurs="0"/>
 *         &lt;element name="serviceCategories" type="{}typeX32" minOccurs="0"/>
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
    "origTicketNumber",
    "creditReasonIndicator",
    "serviceCategories"
})
@XmlRootElement(name = "AncillaryData")
public class AncillaryData {

    @XmlElement(required = true)
    protected String passengerName;
    @XmlElement(required = true)
    protected String ticketNumber;
    protected String origTicketNumber;
    protected String creditReasonIndicator;
    protected String serviceCategories;

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
     * Gets the value of the origTicketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigTicketNumber() {
        return origTicketNumber;
    }

    /**
     * Sets the value of the origTicketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigTicketNumber(String value) {
        this.origTicketNumber = value;
    }

    /**
     * Gets the value of the creditReasonIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditReasonIndicator() {
        return creditReasonIndicator;
    }

    /**
     * Sets the value of the creditReasonIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReasonIndicator(String value) {
        this.creditReasonIndicator = value;
    }

    /**
     * Gets the value of the serviceCategories property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCategories() {
        return serviceCategories;
    }

    /**
     * Sets the value of the serviceCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCategories(String value) {
        this.serviceCategories = value;
    }

}
