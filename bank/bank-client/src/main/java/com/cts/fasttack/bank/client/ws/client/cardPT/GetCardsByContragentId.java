
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNoXXX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isPrimary" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expireDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="projectType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "cardNoXXX",
    "cardStatusId",
    "isPrimary",
    "expireDate",
    "projectType",
    "accStatusId"
})
@XmlRootElement(name = "getCardsByContragentId")
public class GetCardsByContragentId {

    @XmlElement(required = true, nillable = true)
    protected String contragentId;
    @XmlElement(required = true, nillable = true)
    protected String cardId;
    @XmlElement(required = true, nillable = true)
    protected String cardNoXXX;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cardStatusId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer isPrimary;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expireDate;
    @XmlElement(required = true, nillable = true)
    protected String projectType;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer accStatusId;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContragentId(String value) {
        this.contragentId = value;
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
     * Gets the value of the cardNoXXX property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNoXXX() {
        return cardNoXXX;
    }

    /**
     * Sets the value of the cardNoXXX property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNoXXX(String value) {
        this.cardNoXXX = value;
    }

    /**
     * Gets the value of the cardStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCardStatusId() {
        return cardStatusId;
    }

    /**
     * Sets the value of the cardStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCardStatusId(Integer value) {
        this.cardStatusId = value;
    }

    /**
     * Gets the value of the isPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the value of the isPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIsPrimary(Integer value) {
        this.isPrimary = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the projectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * Sets the value of the projectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectType(String value) {
        this.projectType = value;
    }

    /**
     * Gets the value of the accStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccStatusId() {
        return accStatusId;
    }

    /**
     * Sets the value of the accStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccStatusId(Integer value) {
        this.accStatusId = value;
    }

}
