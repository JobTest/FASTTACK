
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="card4Last" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "docNo",
    "card4Last"
})
@XmlRootElement(name = "identifyCard")
public class IdentifyCard {

    @XmlElement(required = true, nillable = true)
    protected String contragentId;
    @XmlElement(required = true, nillable = true)
    protected String docNo;
    @XmlElement(required = true, nillable = true)
    protected String card4Last;

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
     * Gets the value of the docNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
    }

    /**
     * Gets the value of the card4Last property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCard4Last() {
        return card4Last;
    }

    /**
     * Sets the value of the card4Last property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCard4Last(String value) {
        this.card4Last = value;
    }

}
