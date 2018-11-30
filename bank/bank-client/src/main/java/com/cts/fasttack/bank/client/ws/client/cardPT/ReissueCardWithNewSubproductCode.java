
package com.cts.fasttack.bank.client.ws.client.cardPT;

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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newSubproductCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeOfTerm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagCommission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cardName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="templateID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="branchCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "contragentId",
    "cardId",
    "newSubproductCode",
    "typeOfTerm",
    "messageId",
    "flagCommission",
    "cardName",
    "templateID",
    "branchCode"
})
@XmlRootElement(name = "reissueCardWithNewSubproductCode")
public class ReissueCardWithNewSubproductCode {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer contragentId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cardId;
    @XmlElement(required = true, nillable = true)
    protected String newSubproductCode;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer typeOfTerm;
    @XmlElement(required = true, nillable = true)
    protected String messageId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer flagCommission;
    @XmlElement(required = true, nillable = true)
    protected String cardName;
    @XmlElement(required = true, nillable = true)
    protected String templateID;
    @XmlElement(required = true, nillable = true)
    protected String branchCode;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContragentId(Integer value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCardId(Integer value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the newSubproductCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSubproductCode() {
        return newSubproductCode;
    }

    /**
     * Sets the value of the newSubproductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSubproductCode(String value) {
        this.newSubproductCode = value;
    }

    /**
     * Gets the value of the typeOfTerm property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeOfTerm() {
        return typeOfTerm;
    }

    /**
     * Sets the value of the typeOfTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeOfTerm(Integer value) {
        this.typeOfTerm = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the flagCommission property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFlagCommission() {
        return flagCommission;
    }

    /**
     * Sets the value of the flagCommission property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFlagCommission(Integer value) {
        this.flagCommission = value;
    }

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardName(String value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the templateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateID() {
        return templateID;
    }

    /**
     * Sets the value of the templateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateID(String value) {
        this.templateID = value;
    }

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

}
