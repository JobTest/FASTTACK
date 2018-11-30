
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getActualBalanceByCardItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getActualBalanceByCardItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getActualBalanceByCardItem", propOrder = {
    "actualBalance"
})
public class GetActualBalanceByCardItem {

    @XmlElementRef(name = "actualBalance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> actualBalance;

    /**
     * Gets the value of the actualBalance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getActualBalance() {
        return actualBalance;
    }

    /**
     * Sets the value of the actualBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setActualBalance(JAXBElement<BigDecimal> value) {
        this.actualBalance = value;
    }

}
