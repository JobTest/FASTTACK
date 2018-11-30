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
 *         &lt;element ref="{}PARes" minOccurs="0"/>
 *         &lt;element ref="{}XID" minOccurs="0"/>
 *         &lt;element ref="{}Recurrent" minOccurs="0"/>
 *         &lt;element ref="{}AirlineAddendumData" minOccurs="0"/>
 *         &lt;element ref="{}Ref3" minOccurs="0"/>
 *         &lt;element ref="{}Walletid" minOccurs="0"/>
 *         &lt;element ref="{}Wallet" minOccurs="0"/>
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
    "paRes",
    "xid",
    "recurrent",
    "airlineAddendumData",
    "ref3",
    "walletid",
    "wallet"
})
@XmlRootElement(name = "PayData")
public class PayData {

    @XmlElement(name = "Invoice", required = true)
    protected Invoice invoice;
    @XmlElement(name = "Card", required = true)
    protected Card card;
    @XmlElement(name = "PARes")
    protected PARes paRes;
    @XmlElement(name = "XID")
    protected String xid;
    @XmlElement(name = "Recurrent")
    protected Boolean recurrent;
    @XmlElement(name = "AirlineAddendumData")
    protected AirlineAddendumData airlineAddendumData;
    @XmlElement(name = "Ref3")
    protected String ref3;
    @XmlElement(name = "Walletid")
    protected String walletid;
    @XmlElement(name = "Wallet")
    protected Wallet wallet;

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
     * Gets the value of the paRes property.
     * 
     * @return
     *     possible object is
     *     {@link PARes }
     *     
     */
    public PARes getPARes() {
        return paRes;
    }

    /**
     * Sets the value of the paRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARes }
     *     
     */
    public void setPARes(PARes value) {
        this.paRes = value;
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
     * Gets the value of the recurrent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecurrent() {
        return recurrent;
    }

    /**
     * Sets the value of the recurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecurrent(Boolean value) {
        this.recurrent = value;
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

    /**
     * Gets the value of the walletid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletid() {
        return walletid;
    }

    /**
     * Sets the value of the walletid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletid(String value) {
        this.walletid = value;
    }

    /**
     * Gets the value of the wallet property.
     * 
     * @return
     *     possible object is
     *     {@link Wallet }
     *     
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * Sets the value of the wallet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wallet }
     *     
     */
    public void setWallet(Wallet value) {
        this.wallet = value;
    }

}
