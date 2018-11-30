
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processInstallmentItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processInstallmentItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="installmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equalAvlAmountOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processInstallmentItem", propOrder = {
    "installmentId",
    "result",
    "errorCode",
    "errorMessage",
    "transactionSum",
    "equalAmount",
    "equalAvlAmountOut"
})
public class ProcessInstallmentItem {

    @XmlElementRef(name = "installmentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> installmentId;
    @XmlElementRef(name = "result", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> result;
    @XmlElementRef(name = "errorCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> errorCode;
    @XmlElementRef(name = "errorMessage", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    @XmlElementRef(name = "transactionSum", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionSum;
    @XmlElementRef(name = "equalAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> equalAmount;
    @XmlElementRef(name = "equalAvlAmountOut", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> equalAvlAmountOut;

    /**
     * Gets the value of the installmentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstallmentId() {
        return installmentId;
    }

    /**
     * Sets the value of the installmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstallmentId(JAXBElement<String> value) {
        this.installmentId = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setResult(JAXBElement<BigInteger> value) {
        this.result = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<BigInteger> value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorMessage(JAXBElement<String> value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the transactionSum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionSum() {
        return transactionSum;
    }

    /**
     * Sets the value of the transactionSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionSum(JAXBElement<String> value) {
        this.transactionSum = value;
    }

    /**
     * Gets the value of the equalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEqualAmount() {
        return equalAmount;
    }

    /**
     * Sets the value of the equalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEqualAmount(JAXBElement<String> value) {
        this.equalAmount = value;
    }

    /**
     * Gets the value of the equalAvlAmountOut property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEqualAvlAmountOut() {
        return equalAvlAmountOut;
    }

    /**
     * Sets the value of the equalAvlAmountOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEqualAvlAmountOut(JAXBElement<String> value) {
        this.equalAvlAmountOut = value;
    }

}
