
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getFinCorpAccBySiebelItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFinCorpAccBySiebelItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isCardConditRateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isCardAgreementId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="agreementNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prBranch" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="statusB2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="statementMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="agreementDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="isCardProjectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isCardConditAccId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="t24Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collectionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountBranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overdraftBeginDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="overdraftEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="statementAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFinCorpAccBySiebelItem", propOrder = {
    "isCardConditRateId",
    "isCardAgreementId",
    "agreementNumber",
    "otherIdNumber",
    "accountNumber",
    "prBranch",
    "statusB2",
    "dealDate",
    "statementMode",
    "dateOfBirth",
    "agreementDate",
    "isCardProjectId",
    "taxIdNumber",
    "isCardConditAccId",
    "dlNumber",
    "accountModel",
    "t24Id",
    "collectionStatus",
    "accountBranchName",
    "overdraftBeginDate",
    "overdraftEndDate",
    "statementAddress",
    "accountType"
})
public class GetFinCorpAccBySiebelItem {

    @XmlElementRef(name = "isCardConditRateId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardConditRateId;
    @XmlElementRef(name = "isCardAgreementId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isCardAgreementId;
    @XmlElementRef(name = "agreementNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> agreementNumber;
    @XmlElementRef(name = "otherIdNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> otherIdNumber;
    @XmlElementRef(name = "accountNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountNumber;
    @XmlElementRef(name = "prBranch", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> prBranch;
    @XmlElementRef(name = "statusB2", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statusB2;
    @XmlElementRef(name = "dealDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dealDate;
    @XmlElementRef(name = "statementMode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statementMode;
    @XmlElementRef(name = "dateOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOfBirth;
    @XmlElementRef(name = "agreementDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> agreementDate;
    @XmlElementRef(name = "isCardProjectId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardProjectId;
    @XmlElementRef(name = "taxIdNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxIdNumber;
    @XmlElementRef(name = "isCardConditAccId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardConditAccId;
    @XmlElementRef(name = "dlNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dlNumber;
    @XmlElementRef(name = "accountModel", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountModel;
    @XmlElementRef(name = "t24Id", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> t24Id;
    @XmlElementRef(name = "collectionStatus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> collectionStatus;
    @XmlElementRef(name = "accountBranchName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountBranchName;
    @XmlElementRef(name = "overdraftBeginDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> overdraftBeginDate;
    @XmlElementRef(name = "overdraftEndDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> overdraftEndDate;
    @XmlElementRef(name = "statementAddress", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statementAddress;
    @XmlElementRef(name = "accountType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountType;

    /**
     * Gets the value of the isCardConditRateId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsCardConditRateId() {
        return isCardConditRateId;
    }

    /**
     * Sets the value of the isCardConditRateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsCardConditRateId(JAXBElement<String> value) {
        this.isCardConditRateId = value;
    }

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
     * Gets the value of the agreementNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * Sets the value of the agreementNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgreementNumber(JAXBElement<String> value) {
        this.agreementNumber = value;
    }

    /**
     * Gets the value of the otherIdNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOtherIdNumber() {
        return otherIdNumber;
    }

    /**
     * Sets the value of the otherIdNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOtherIdNumber(JAXBElement<String> value) {
        this.otherIdNumber = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountNumber(JAXBElement<String> value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the prBranch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getPrBranch() {
        return prBranch;
    }

    /**
     * Sets the value of the prBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setPrBranch(JAXBElement<BigInteger> value) {
        this.prBranch = value;
    }

    /**
     * Gets the value of the statusB2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatusB2() {
        return statusB2;
    }

    /**
     * Sets the value of the statusB2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatusB2(JAXBElement<String> value) {
        this.statusB2 = value;
    }

    /**
     * Gets the value of the dealDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDealDate() {
        return dealDate;
    }

    /**
     * Sets the value of the dealDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDealDate(JAXBElement<XMLGregorianCalendar> value) {
        this.dealDate = value;
    }

    /**
     * Gets the value of the statementMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatementMode() {
        return statementMode;
    }

    /**
     * Sets the value of the statementMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatementMode(JAXBElement<String> value) {
        this.statementMode = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<XMLGregorianCalendar> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the agreementDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getAgreementDate() {
        return agreementDate;
    }

    /**
     * Sets the value of the agreementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setAgreementDate(JAXBElement<XMLGregorianCalendar> value) {
        this.agreementDate = value;
    }

    /**
     * Gets the value of the isCardProjectId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsCardProjectId() {
        return isCardProjectId;
    }

    /**
     * Sets the value of the isCardProjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsCardProjectId(JAXBElement<String> value) {
        this.isCardProjectId = value;
    }

    /**
     * Gets the value of the taxIdNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxIdNumber() {
        return taxIdNumber;
    }

    /**
     * Sets the value of the taxIdNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxIdNumber(JAXBElement<String> value) {
        this.taxIdNumber = value;
    }

    /**
     * Gets the value of the isCardConditAccId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsCardConditAccId() {
        return isCardConditAccId;
    }

    /**
     * Sets the value of the isCardConditAccId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsCardConditAccId(JAXBElement<String> value) {
        this.isCardConditAccId = value;
    }

    /**
     * Gets the value of the dlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDlNumber() {
        return dlNumber;
    }

    /**
     * Sets the value of the dlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDlNumber(JAXBElement<String> value) {
        this.dlNumber = value;
    }

    /**
     * Gets the value of the accountModel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountModel() {
        return accountModel;
    }

    /**
     * Sets the value of the accountModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountModel(JAXBElement<String> value) {
        this.accountModel = value;
    }

    /**
     * Gets the value of the t24Id property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getT24Id() {
        return t24Id;
    }

    /**
     * Sets the value of the t24Id property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setT24Id(JAXBElement<String> value) {
        this.t24Id = value;
    }

    /**
     * Gets the value of the collectionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCollectionStatus() {
        return collectionStatus;
    }

    /**
     * Sets the value of the collectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCollectionStatus(JAXBElement<String> value) {
        this.collectionStatus = value;
    }

    /**
     * Gets the value of the accountBranchName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountBranchName() {
        return accountBranchName;
    }

    /**
     * Sets the value of the accountBranchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountBranchName(JAXBElement<String> value) {
        this.accountBranchName = value;
    }

    /**
     * Gets the value of the overdraftBeginDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getOverdraftBeginDate() {
        return overdraftBeginDate;
    }

    /**
     * Sets the value of the overdraftBeginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setOverdraftBeginDate(JAXBElement<XMLGregorianCalendar> value) {
        this.overdraftBeginDate = value;
    }

    /**
     * Gets the value of the overdraftEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getOverdraftEndDate() {
        return overdraftEndDate;
    }

    /**
     * Sets the value of the overdraftEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setOverdraftEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.overdraftEndDate = value;
    }

    /**
     * Gets the value of the statementAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatementAddress() {
        return statementAddress;
    }

    /**
     * Sets the value of the statementAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatementAddress(JAXBElement<String> value) {
        this.statementAddress = value;
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

}
