
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="cardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cashMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cashMaxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="purchaseMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="purchaseMaxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalMaxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "cardHashNumber",
    "cardId",
    "cashMaxAmount",
    "cashMaxCount",
    "purchaseMaxAmount",
    "purchaseMaxCount",
    "totalMaxAmount",
    "totalMaxCount",
    "endDate"
})
@XmlRootElement(name = "setCardDailyLimits")
public class SetCardDailyLimits {

    @XmlElement(required = true, nillable = true)
    protected String cardHashNumber;
    @XmlElement(required = true, nillable = true)
    protected String cardId;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long cashMaxAmount;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cashMaxCount;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long purchaseMaxAmount;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer purchaseMaxCount;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long totalMaxAmount;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer totalMaxCount;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the cardHashNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHashNumber() {
        return cardHashNumber;
    }

    /**
     * Sets the value of the cardHashNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHashNumber(String value) {
        this.cardHashNumber = value;
    }

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardId(String value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the cashMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashMaxAmount() {
        return cashMaxAmount;
    }

    /**
     * Sets the value of the cashMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashMaxAmount(Long value) {
        this.cashMaxAmount = value;
    }

    /**
     * Gets the value of the cashMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCashMaxCount() {
        return cashMaxCount;
    }

    /**
     * Sets the value of the cashMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCashMaxCount(Integer value) {
        this.cashMaxCount = value;
    }

    /**
     * Gets the value of the purchaseMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPurchaseMaxAmount() {
        return purchaseMaxAmount;
    }

    /**
     * Sets the value of the purchaseMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPurchaseMaxAmount(Long value) {
        this.purchaseMaxAmount = value;
    }

    /**
     * Gets the value of the purchaseMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPurchaseMaxCount() {
        return purchaseMaxCount;
    }

    /**
     * Sets the value of the purchaseMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPurchaseMaxCount(Integer value) {
        this.purchaseMaxCount = value;
    }

    /**
     * Gets the value of the totalMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalMaxAmount() {
        return totalMaxAmount;
    }

    /**
     * Sets the value of the totalMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalMaxAmount(Long value) {
        this.totalMaxAmount = value;
    }

    /**
     * Gets the value of the totalMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalMaxCount() {
        return totalMaxCount;
    }

    /**
     * Sets the value of the totalMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalMaxCount(Integer value) {
        this.totalMaxCount = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
