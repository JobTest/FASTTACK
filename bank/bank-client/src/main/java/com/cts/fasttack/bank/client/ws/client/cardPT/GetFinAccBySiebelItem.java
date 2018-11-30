
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFinAccBySiebelItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFinAccBySiebelItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isCardAgreementId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="finAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currDgtlCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPrincipal" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="isCardAccountId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFinAccBySiebelItem", propOrder = {
    "isCardAgreementId",
    "finAccountNumber",
    "accountType",
    "accountState",
    "currDgtlCode",
    "isPrincipal",
    "isCardAccountId"
})
public class GetFinAccBySiebelItem {

    @XmlElementRef(name = "isCardAgreementId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isCardAgreementId;
    @XmlElementRef(name = "finAccountNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finAccountNumber;
    @XmlElementRef(name = "accountType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountType;
    @XmlElementRef(name = "accountState", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountState;
    @XmlElementRef(name = "currDgtlCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currDgtlCode;
    @XmlElementRef(name = "isPrincipal", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isPrincipal;
    @XmlElementRef(name = "isCardAccountId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isCardAccountId;

    /**
     * Gets the value of the isCardAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsCardAgreementId() {
        return isCardAgreementId;
    }

    /**
     * Sets the value of the isCardAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsCardAgreementId(JAXBElement<BigInteger> value) {
        this.isCardAgreementId = value;
    }

    /**
     * Gets the value of the finAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinAccountNumber() {
        return finAccountNumber;
    }

    /**
     * Sets the value of the finAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinAccountNumber(JAXBElement<String> value) {
        this.finAccountNumber = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountType(JAXBElement<String> value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the accountState property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountState() {
        return accountState;
    }

    /**
     * Sets the value of the accountState property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountState(JAXBElement<String> value) {
        this.accountState = value;
    }

    /**
     * Gets the value of the currDgtlCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrDgtlCode() {
        return currDgtlCode;
    }

    /**
     * Sets the value of the currDgtlCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrDgtlCode(JAXBElement<String> value) {
        this.currDgtlCode = value;
    }

    /**
     * Gets the value of the isPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsPrincipal() {
        return isPrincipal;
    }

    /**
     * Sets the value of the isPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsPrincipal(JAXBElement<BigInteger> value) {
        this.isPrincipal = value;
    }

    /**
     * Gets the value of the isCardAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsCardAccountId() {
        return isCardAccountId;
    }

    /**
     * Sets the value of the isCardAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsCardAccountId(JAXBElement<BigInteger> value) {
        this.isCardAccountId = value;
    }

}
