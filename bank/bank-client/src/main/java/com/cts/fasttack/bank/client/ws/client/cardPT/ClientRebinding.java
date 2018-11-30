
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
 *         &lt;element name="dealNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "dealNo",
    "contragentId"
})
@XmlRootElement(name = "clientRebinding")
public class ClientRebinding {

    @XmlElement(required = true, nillable = true)
    protected String dealNo;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer contragentId;

    /**
     * Gets the value of the dealNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealNo() {
        return dealNo;
    }

    /**
     * Sets the value of the dealNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealNo(String value) {
        this.dealNo = value;
    }

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

}
