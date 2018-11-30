package com.cts.fasttack.ih.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;choice>
 *         &lt;element ref="{}Authorization"/>
 *         &lt;element ref="{}Refund"/>
 *         &lt;element ref="{}Preauthorization"/>
 *         &lt;element ref="{}Postauthorization"/>
 *         &lt;element ref="{}TransactionStateReq"/>
 *         &lt;element ref="{}CardToCardTransfer"/>
 *         &lt;element ref="{}Settlement"/>
 *       &lt;/choice>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authorization",
    "refund",
    "preauthorization",
    "postauthorization",
    "transactionStateReq",
    "cardToCardTransfer",
    "settlement"
})
@XmlRootElement(name = "Transaction")
public class Transaction {

    @XmlElement(name = "Authorization")
    protected Authorization authorization;
    @XmlElement(name = "Refund")
    protected Refund refund;
    @XmlElement(name = "Preauthorization")
    protected Preauthorization preauthorization;
    @XmlElement(name = "Postauthorization")
    protected Postauthorization postauthorization;
    @XmlElement(name = "TransactionStateReq")
    protected TransactionStateReq transactionStateReq;
    @XmlElement(name = "CardToCardTransfer")
    protected CardToCardTransfer cardToCardTransfer;
    @XmlElement(name = "Settlement")
    protected Settlement settlement;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Gets the value of the authorization property.
     * 
     * @return
     *     possible object is
     *     {@link Authorization }
     *     
     */
    public Authorization getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authorization }
     *     
     */
    public void setAuthorization(Authorization value) {
        this.authorization = value;
    }

    /**
     * Gets the value of the refund property.
     * 
     * @return
     *     possible object is
     *     {@link Refund }
     *     
     */
    public Refund getRefund() {
        return refund;
    }

    /**
     * Sets the value of the refund property.
     * 
     * @param value
     *     allowed object is
     *     {@link Refund }
     *     
     */
    public void setRefund(Refund value) {
        this.refund = value;
    }

    /**
     * Gets the value of the preauthorization property.
     * 
     * @return
     *     possible object is
     *     {@link Preauthorization }
     *     
     */
    public Preauthorization getPreauthorization() {
        return preauthorization;
    }

    /**
     * Sets the value of the preauthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Preauthorization }
     *     
     */
    public void setPreauthorization(Preauthorization value) {
        this.preauthorization = value;
    }

    /**
     * Gets the value of the postauthorization property.
     * 
     * @return
     *     possible object is
     *     {@link Postauthorization }
     *     
     */
    public Postauthorization getPostauthorization() {
        return postauthorization;
    }

    /**
     * Sets the value of the postauthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Postauthorization }
     *     
     */
    public void setPostauthorization(Postauthorization value) {
        this.postauthorization = value;
    }

    /**
     * Gets the value of the transactionStateReq property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStateReq }
     *     
     */
    public TransactionStateReq getTransactionStateReq() {
        return transactionStateReq;
    }

    /**
     * Sets the value of the transactionStateReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStateReq }
     *     
     */
    public void setTransactionStateReq(TransactionStateReq value) {
        this.transactionStateReq = value;
    }

    /**
     * Gets the value of the cardToCardTransfer property.
     * 
     * @return
     *     possible object is
     *     {@link CardToCardTransfer }
     *     
     */
    public CardToCardTransfer getCardToCardTransfer() {
        return cardToCardTransfer;
    }

    /**
     * Sets the value of the cardToCardTransfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardToCardTransfer }
     *     
     */
    public void setCardToCardTransfer(CardToCardTransfer value) {
        this.cardToCardTransfer = value;
    }

    /**
     * Gets the value of the settlement property.
     * 
     * @return
     *     possible object is
     *     {@link Settlement }
     *     
     */
    public Settlement getSettlement() {
        return settlement;
    }

    /**
     * Sets the value of the settlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Settlement }
     *     
     */
    public void setSettlement(Settlement value) {
        this.settlement = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
