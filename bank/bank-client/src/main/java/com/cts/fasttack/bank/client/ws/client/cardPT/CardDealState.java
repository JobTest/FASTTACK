
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for cardDealState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardDealState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="availableAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="availableCredit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nextPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nextPaymentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="totalDebt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="installmentDebt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="lastBalanceUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{http://sab/}accountList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardDealState", propOrder = {
    "balance",
    "availableAmount",
    "availableCredit",
    "creditLimit",
    "nextPaymentAmount",
    "nextPaymentDate",
    "totalDebt",
    "installmentDebt",
    "lastBalanceUpdate",
    "accountList"
})
public class CardDealState {

    @XmlElementRef(name = "balance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> balance;
    @XmlElementRef(name = "availableAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> availableAmount;
    @XmlElementRef(name = "availableCredit", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> availableCredit;
    @XmlElementRef(name = "creditLimit", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> creditLimit;
    @XmlElementRef(name = "nextPaymentAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> nextPaymentAmount;
    @XmlElementRef(name = "nextPaymentDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> nextPaymentDate;
    @XmlElementRef(name = "totalDebt", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> totalDebt;
    @XmlElementRef(name = "installmentDebt", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> installmentDebt;
    @XmlElementRef(name = "lastBalanceUpdate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastBalanceUpdate;
    @XmlElement(required = true)
    protected AccountList accountList;

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setBalance(JAXBElement<Long> value) {
        this.balance = value;
    }

    /**
     * Gets the value of the availableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAvailableAmount() {
        return availableAmount;
    }

    /**
     * Sets the value of the availableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAvailableAmount(JAXBElement<Long> value) {
        this.availableAmount = value;
    }

    /**
     * Gets the value of the availableCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAvailableCredit() {
        return availableCredit;
    }

    /**
     * Sets the value of the availableCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAvailableCredit(JAXBElement<Long> value) {
        this.availableCredit = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCreditLimit(JAXBElement<Long> value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the nextPaymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    /**
     * Sets the value of the nextPaymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setNextPaymentAmount(JAXBElement<Long> value) {
        this.nextPaymentAmount = value;
    }

    /**
     * Gets the value of the nextPaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getNextPaymentDate() {
        return nextPaymentDate;
    }

    /**
     * Sets the value of the nextPaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setNextPaymentDate(JAXBElement<XMLGregorianCalendar> value) {
        this.nextPaymentDate = value;
    }

    /**
     * Gets the value of the totalDebt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getTotalDebt() {
        return totalDebt;
    }

    /**
     * Sets the value of the totalDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setTotalDebt(JAXBElement<Long> value) {
        this.totalDebt = value;
    }

    /**
     * Gets the value of the installmentDebt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInstallmentDebt() {
        return installmentDebt;
    }

    /**
     * Sets the value of the installmentDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInstallmentDebt(JAXBElement<Long> value) {
        this.installmentDebt = value;
    }

    /**
     * Gets the value of the lastBalanceUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastBalanceUpdate() {
        return lastBalanceUpdate;
    }

    /**
     * Sets the value of the lastBalanceUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastBalanceUpdate(JAXBElement<XMLGregorianCalendar> value) {
        this.lastBalanceUpdate = value;
    }

    /**
     * Gets the value of the accountList property.
     * 
     * @return
     *     possible object is
     *     {@link AccountList }
     *     
     */
    public AccountList getAccountList() {
        return accountList;
    }

    /**
     * Sets the value of the accountList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountList }
     *     
     */
    public void setAccountList(AccountList value) {
        this.accountList = value;
    }

}
