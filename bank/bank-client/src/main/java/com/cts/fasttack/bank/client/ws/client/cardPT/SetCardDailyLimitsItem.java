
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setCardDailyLimitsItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setCardDailyLimitsItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardRiskClassId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCardDailyLimitsItem", propOrder = {
    "cardRiskClassId"
})
public class SetCardDailyLimitsItem {

    @XmlElementRef(name = "cardRiskClassId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> cardRiskClassId;

    /**
     * Gets the value of the cardRiskClassId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCardRiskClassId() {
        return cardRiskClassId;
    }

    /**
     * Sets the value of the cardRiskClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCardRiskClassId(JAXBElement<Long> value) {
        this.cardRiskClassId = value;
    }

}
