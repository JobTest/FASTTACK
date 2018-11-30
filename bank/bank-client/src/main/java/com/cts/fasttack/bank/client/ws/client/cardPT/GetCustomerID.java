
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
 *         &lt;element name="cardID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hashNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cardID",
    "cardNum",
    "hashNum",
    "cardGUID"
})
@XmlRootElement(name = "getCustomerID", namespace = "http://sab/")
public class GetCustomerID {

    @XmlElement(namespace = "http://sab/")
    protected String cardID;

    @XmlElement(namespace = "http://sab/")
    protected String cardNum;

    @XmlElement(namespace = "http://sab/")
    protected String hashNum;

    @XmlElement(namespace = "http://sab/")
    protected String cardGUID;

    /**
     * Gets the value of the cardID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardID() {
        return cardID;
    }

    /**
     * Sets the value of the cardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardID(String value) {
        this.cardID = value;
    }

    /**
     * Gets the value of the cardNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * Sets the value of the cardNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNum(String value) {
        this.cardNum = value;
    }

    /**
     * Gets the value of the hashNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashNum() {
        return hashNum;
    }

    /**
     * Sets the value of the hashNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashNum(String value) {
        this.hashNum = value;
    }

    /**
     * Gets the value of the cardGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardGUID() {
        return cardGUID;
    }

    /**
     * Sets the value of the cardGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardGUID(String value) {
        this.cardGUID = value;
    }

}
