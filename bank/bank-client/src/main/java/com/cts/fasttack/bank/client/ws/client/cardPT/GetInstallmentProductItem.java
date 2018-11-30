
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInstallmentProductItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInstallmentProductItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subproductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="interestRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="payment" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="amountRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInstallmentProductItem", propOrder = {
    "subproductCode",
    "interestRate",
    "term",
    "payment",
    "amountRange"
})
public class GetInstallmentProductItem {

    @XmlElementRef(name = "subproductCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subproductCode;
    @XmlElementRef(name = "interestRate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestRate;
    @XmlElementRef(name = "term", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> term;
    @XmlElementRef(name = "payment", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> payment;
    @XmlElementRef(name = "amountRange", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> amountRange;

    /**
     * Gets the value of the subproductCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubproductCode() {
        return subproductCode;
    }

    /**
     * Sets the value of the subproductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubproductCode(JAXBElement<String> value) {
        this.subproductCode = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInterestRate(JAXBElement<BigDecimal> value) {
        this.interestRate = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setTerm(JAXBElement<BigInteger> value) {
        this.term = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setPayment(JAXBElement<BigInteger> value) {
        this.payment = value;
    }

    /**
     * Gets the value of the amountRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAmountRange() {
        return amountRange;
    }

    /**
     * Sets the value of the amountRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAmountRange(JAXBElement<String> value) {
        this.amountRange = value;
    }

}
