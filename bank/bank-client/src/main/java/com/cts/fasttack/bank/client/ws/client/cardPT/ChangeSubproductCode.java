
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
 *         &lt;element name="subproductCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "subproductCode",
    "templateId"
})
@XmlRootElement(name = "changeSubproductCode")
public class ChangeSubproductCode {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer contragentId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cardId;
    @XmlElement(required = true, nillable = true)
    protected String subproductCode;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer templateId;

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
     * Gets the value of the subproductCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubproductCode() {
        return subproductCode;
    }

    /**
     * Sets the value of the subproductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubproductCode(String value) {
        this.subproductCode = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTemplateId(Integer value) {
        this.templateId = value;
    }

}
