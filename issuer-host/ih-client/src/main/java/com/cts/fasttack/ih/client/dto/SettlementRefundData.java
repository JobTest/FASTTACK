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
 *         &lt;element ref="{}Invoice"/>
 *         &lt;element ref="{}Card"/>
 *         &lt;element ref="{}XID" minOccurs="0"/>
 *         &lt;element ref="{}ApprovalCode" minOccurs="0"/>
 *         &lt;element ref="{}Rrn" minOccurs="0"/>
 *         &lt;element ref="{}ECI" minOccurs="0"/>
 *         &lt;element ref="{}PosConditionCode" minOccurs="0"/>
 *         &lt;element ref="{}AirlineAddendumData" minOccurs="0"/>
 *         &lt;element ref="{}Ref3"/>
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
    "invoice",
    "card",
    "xid",
    "approvalCode",
    "rrn",
    "eci",
    "posConditionCode",
    "airlineAddendumData",
    "ref3"
})
@XmlRootElement(name = "SettlementRefundData")
public class SettlementRefundData {

    @XmlElement(name = "Invoice", required = true)
    protected Invoice invoice;
    @XmlElement(name = "Card", required = true)
    protected Card card;
    @XmlElement(name = "XID")
    protected String xid;
    @XmlElement(name = "ApprovalCode")
    protected String approvalCode;
    @XmlElement(name = "Rrn")
    protected String rrn;
    @XmlElement(name = "ECI")
    protected String eci;
    @XmlElement(name = "PosConditionCode")
    protected String posConditionCode;
    @XmlElement(name = "AirlineAddendumData")
    protected AirlineAddendumData airlineAddendumData;
    @XmlElement(name = "Ref3", required = true)
    protected String ref3;

    /**
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link Invoice }
     *     
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoice }
     *     
     */
    public void setInvoice(Invoice value) {
        this.invoice = value;
    }

    /**
     * Gets the value of the card property.
     * 
     * @return
     *     possible object is
     *     {@link Card }
     *     
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the value of the card property.
     * 
     * @param value
     *     allowed object is
     *     {@link Card }
     *     
     */
    public void setCard(Card value) {
        this.card = value;
    }

    /**
     * Gets the value of the xid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXID() {
        return xid;
    }

    /**
     * Sets the value of the xid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXID(String value) {
        this.xid = value;
    }

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the rrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRrn() {
        return rrn;
    }

    /**
     * Sets the value of the rrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRrn(String value) {
        this.rrn = value;
    }

    /**
     * Gets the value of the eci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECI() {
        return eci;
    }

    /**
     * Sets the value of the eci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECI(String value) {
        this.eci = value;
    }

    /**
     * Gets the value of the posConditionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosConditionCode() {
        return posConditionCode;
    }

    /**
     * Sets the value of the posConditionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosConditionCode(String value) {
        this.posConditionCode = value;
    }

    /**
     * Gets the value of the airlineAddendumData property.
     * 
     * @return
     *     possible object is
     *     {@link AirlineAddendumData }
     *     
     */
    public AirlineAddendumData getAirlineAddendumData() {
        return airlineAddendumData;
    }

    /**
     * Sets the value of the airlineAddendumData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirlineAddendumData }
     *     
     */
    public void setAirlineAddendumData(AirlineAddendumData value) {
        this.airlineAddendumData = value;
    }

    /**
     * Gets the value of the ref3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef3() {
        return ref3;
    }

    /**
     * Sets the value of the ref3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef3(String value) {
        this.ref3 = value;
    }

}
