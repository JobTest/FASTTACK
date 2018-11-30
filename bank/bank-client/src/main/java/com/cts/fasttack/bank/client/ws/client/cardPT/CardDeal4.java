
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for cardDeal4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardDeal4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dealId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="expireDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealTypeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarifPlanId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarifPlanText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="isActiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPersonalized" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="isSalary" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="projectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toboId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="closeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="sold" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segmentCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDeliveryModeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDeliveryAdress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNo8030" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://sab/}cardList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardDeal4", propOrder = {
    "dealId",
    "dealNo",
    "accountNo",
    "currencyCode",
    "signDate",
    "startDate",
    "expireDate",
    "contragentId",
    "taxId",
    "contragentName",
    "statusId",
    "statusText",
    "dealTypeId",
    "dealTypeText",
    "tarifPlanId",
    "tarifPlanText",
    "projectId",
    "projectText",
    "creditLimit",
    "isActive",
    "isActiveText",
    "isPersonalized",
    "isSalary",
    "projectType",
    "toboId",
    "closeDate",
    "sold",
    "subProductCode",
    "segmentCode",
    "reportDeliveryModeId",
    "emailAddress",
    "reportDeliveryAdress",
    "accountNo8030",
    "cardList"
})
public class CardDeal4 {

    @XmlElementRef(name = "dealId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealId;
    @XmlElementRef(name = "dealNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealNo;
    @XmlElementRef(name = "accountNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountNo;
    @XmlElementRef(name = "currencyCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currencyCode;
    @XmlElementRef(name = "signDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> signDate;
    @XmlElementRef(name = "startDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDate;
    @XmlElementRef(name = "expireDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expireDate;
    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "taxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxId;
    @XmlElementRef(name = "contragentName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentName;
    @XmlElementRef(name = "statusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statusId;
    @XmlElementRef(name = "statusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statusText;
    @XmlElementRef(name = "dealTypeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealTypeId;
    @XmlElementRef(name = "dealTypeText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealTypeText;
    @XmlElementRef(name = "tarifPlanId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tarifPlanId;
    @XmlElementRef(name = "tarifPlanText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tarifPlanText;
    @XmlElementRef(name = "projectId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectId;
    @XmlElementRef(name = "projectText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectText;
    @XmlElementRef(name = "creditLimit", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> creditLimit;
    @XmlElementRef(name = "isActive", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isActive;
    @XmlElementRef(name = "isActiveText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isActiveText;
    @XmlElementRef(name = "isPersonalized", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isPersonalized;
    @XmlElementRef(name = "isSalary", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isSalary;
    @XmlElementRef(name = "projectType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectType;
    @XmlElementRef(name = "toboId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> toboId;
    @XmlElementRef(name = "closeDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> closeDate;
    @XmlElementRef(name = "sold", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sold;
    @XmlElementRef(name = "subProductCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subProductCode;
    @XmlElementRef(name = "segmentCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> segmentCode;
    @XmlElementRef(name = "reportDeliveryModeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportDeliveryModeId;
    @XmlElementRef(name = "emailAddress", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> emailAddress;
    @XmlElementRef(name = "reportDeliveryAdress", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportDeliveryAdress;
    @XmlElementRef(name = "accountNo8030", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountNo8030;
    @XmlElement(required = true)
    protected CardList cardList;

    /**
     * Gets the value of the dealId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDealId() {
        return dealId;
    }

    /**
     * Sets the value of the dealId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDealId(JAXBElement<String> value) {
        this.dealId = value;
    }

    /**
     * Gets the value of the dealNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDealNo() {
        return dealNo;
    }

    /**
     * Sets the value of the dealNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDealNo(JAXBElement<String> value) {
        this.dealNo = value;
    }

    /**
     * Gets the value of the accountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountNo() {
        return accountNo;
    }

    /**
     * Sets the value of the accountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountNo(JAXBElement<String> value) {
        this.accountNo = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrencyCode(JAXBElement<String> value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSignDate(JAXBElement<XMLGregorianCalendar> value) {
        this.signDate = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpireDate(JAXBElement<XMLGregorianCalendar> value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentId(JAXBElement<String> value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the taxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxId(JAXBElement<String> value) {
        this.taxId = value;
    }

    /**
     * Gets the value of the contragentName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentName() {
        return contragentName;
    }

    /**
     * Sets the value of the contragentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentName(JAXBElement<String> value) {
        this.contragentName = value;
    }

    /**
     * Gets the value of the statusId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatusId() {
        return statusId;
    }

    /**
     * Sets the value of the statusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatusId(JAXBElement<String> value) {
        this.statusId = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatusText(JAXBElement<String> value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the dealTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDealTypeId() {
        return dealTypeId;
    }

    /**
     * Sets the value of the dealTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDealTypeId(JAXBElement<String> value) {
        this.dealTypeId = value;
    }

    /**
     * Gets the value of the dealTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDealTypeText() {
        return dealTypeText;
    }

    /**
     * Sets the value of the dealTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDealTypeText(JAXBElement<String> value) {
        this.dealTypeText = value;
    }

    /**
     * Gets the value of the tarifPlanId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTarifPlanId() {
        return tarifPlanId;
    }

    /**
     * Sets the value of the tarifPlanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTarifPlanId(JAXBElement<String> value) {
        this.tarifPlanId = value;
    }

    /**
     * Gets the value of the tarifPlanText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTarifPlanText() {
        return tarifPlanText;
    }

    /**
     * Sets the value of the tarifPlanText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTarifPlanText(JAXBElement<String> value) {
        this.tarifPlanText = value;
    }

    /**
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProjectId(JAXBElement<String> value) {
        this.projectId = value;
    }

    /**
     * Gets the value of the projectText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProjectText() {
        return projectText;
    }

    /**
     * Sets the value of the projectText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProjectText(JAXBElement<String> value) {
        this.projectText = value;
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
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsActive(JAXBElement<BigInteger> value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the isActiveText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsActiveText() {
        return isActiveText;
    }

    /**
     * Sets the value of the isActiveText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsActiveText(JAXBElement<String> value) {
        this.isActiveText = value;
    }

    /**
     * Gets the value of the isPersonalized property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsPersonalized() {
        return isPersonalized;
    }

    /**
     * Sets the value of the isPersonalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsPersonalized(JAXBElement<BigInteger> value) {
        this.isPersonalized = value;
    }

    /**
     * Gets the value of the isSalary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsSalary() {
        return isSalary;
    }

    /**
     * Sets the value of the isSalary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsSalary(JAXBElement<BigInteger> value) {
        this.isSalary = value;
    }

    /**
     * Gets the value of the projectType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProjectType() {
        return projectType;
    }

    /**
     * Sets the value of the projectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProjectType(JAXBElement<String> value) {
        this.projectType = value;
    }

    /**
     * Gets the value of the toboId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToboId() {
        return toboId;
    }

    /**
     * Sets the value of the toboId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToboId(JAXBElement<String> value) {
        this.toboId = value;
    }

    /**
     * Gets the value of the closeDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getCloseDate() {
        return closeDate;
    }

    /**
     * Sets the value of the closeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setCloseDate(JAXBElement<XMLGregorianCalendar> value) {
        this.closeDate = value;
    }

    /**
     * Gets the value of the sold property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSold() {
        return sold;
    }

    /**
     * Sets the value of the sold property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSold(JAXBElement<String> value) {
        this.sold = value;
    }

    /**
     * Gets the value of the subProductCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubProductCode() {
        return subProductCode;
    }

    /**
     * Sets the value of the subProductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubProductCode(JAXBElement<String> value) {
        this.subProductCode = value;
    }

    /**
     * Gets the value of the segmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSegmentCode() {
        return segmentCode;
    }

    /**
     * Sets the value of the segmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSegmentCode(JAXBElement<String> value) {
        this.segmentCode = value;
    }

    /**
     * Gets the value of the reportDeliveryModeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportDeliveryModeId() {
        return reportDeliveryModeId;
    }

    /**
     * Sets the value of the reportDeliveryModeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportDeliveryModeId(JAXBElement<String> value) {
        this.reportDeliveryModeId = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmailAddress(JAXBElement<String> value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the reportDeliveryAdress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportDeliveryAdress() {
        return reportDeliveryAdress;
    }

    /**
     * Sets the value of the reportDeliveryAdress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportDeliveryAdress(JAXBElement<String> value) {
        this.reportDeliveryAdress = value;
    }

    /**
     * Gets the value of the accountNo8030 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountNo8030() {
        return accountNo8030;
    }

    /**
     * Sets the value of the accountNo8030 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountNo8030(JAXBElement<String> value) {
        this.accountNo8030 = value;
    }

    /**
     * Gets the value of the cardList property.
     * 
     * @return
     *     possible object is
     *     {@link CardList }
     *     
     */
    public CardList getCardList() {
        return cardList;
    }

    /**
     * Sets the value of the cardList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardList }
     *     
     */
    public void setCardList(CardList value) {
        this.cardList = value;
    }

}
