
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesTaxReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateRegDocSrNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionTypesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sectorClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sectorClassificationText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeSourcesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeSourcesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeLevelsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propertyTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankProductsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPublicPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CtrlIsPublicPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="work_kind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receipts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="issigned" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isclient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "taxCategory",
    "externalSystem",
    "workTypesCode",
    "workTypesText",
    "workTypesTaxReg",
    "stateRegDocSrNo",
    "positionTypesCode",
    "positionTypesText",
    "sectorClassificationCode",
    "sectorClassificationText",
    "incomeSourcesCode",
    "incomeSourcesText",
    "incomeLevelsCode",
    "propertyTypesCode",
    "bankProductsCode",
    "workPlace",
    "isPublicPerson",
    "ctrlIsPublicPerson",
    "activityTypes",
    "workKind",
    "receipts",
    "issigned",
    "isclient"
})
@XmlRootElement(name = "checkFM")
public class CheckFM {

    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "taxCategory", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCategory;
    @XmlElementRef(name = "externalSystem", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalSystem;
    @XmlElementRef(name = "workTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesCode;
    @XmlElementRef(name = "workTypesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesText;
    @XmlElementRef(name = "workTypesTaxReg", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesTaxReg;
    @XmlElementRef(name = "stateRegDocSrNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stateRegDocSrNo;
    @XmlElementRef(name = "positionTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> positionTypesCode;
    @XmlElementRef(name = "positionTypesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> positionTypesText;
    @XmlElementRef(name = "sectorClassificationCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sectorClassificationCode;
    @XmlElementRef(name = "sectorClassificationText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sectorClassificationText;
    @XmlElementRef(name = "incomeSourcesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeSourcesCode;
    @XmlElementRef(name = "incomeSourcesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeSourcesText;
    @XmlElementRef(name = "incomeLevelsCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeLevelsCode;
    @XmlElementRef(name = "propertyTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> propertyTypesCode;
    @XmlElementRef(name = "bankProductsCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankProductsCode;
    @XmlElementRef(name = "workPlace", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workPlace;
    @XmlElementRef(name = "isPublicPerson", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isPublicPerson;
    @XmlElementRef(name = "CtrlIsPublicPerson", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ctrlIsPublicPerson;
    @XmlElementRef(name = "activityTypes", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> activityTypes;
    @XmlElementRef(name = "work_kind", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workKind;
    @XmlElementRef(name = "receipts", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receipts;
    @XmlElementRef(name = "issigned", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> issigned;
    @XmlElementRef(name = "isclient", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isclient;

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
     * Gets the value of the taxCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxCategory() {
        return taxCategory;
    }

    /**
     * Sets the value of the taxCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxCategory(JAXBElement<String> value) {
        this.taxCategory = value;
    }

    /**
     * Gets the value of the externalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalSystem() {
        return externalSystem;
    }

    /**
     * Sets the value of the externalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalSystem(JAXBElement<String> value) {
        this.externalSystem = value;
    }

    /**
     * Gets the value of the workTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesCode() {
        return workTypesCode;
    }

    /**
     * Sets the value of the workTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesCode(JAXBElement<String> value) {
        this.workTypesCode = value;
    }

    /**
     * Gets the value of the workTypesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesText() {
        return workTypesText;
    }

    /**
     * Sets the value of the workTypesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesText(JAXBElement<String> value) {
        this.workTypesText = value;
    }

    /**
     * Gets the value of the workTypesTaxReg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesTaxReg() {
        return workTypesTaxReg;
    }

    /**
     * Sets the value of the workTypesTaxReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesTaxReg(JAXBElement<String> value) {
        this.workTypesTaxReg = value;
    }

    /**
     * Gets the value of the stateRegDocSrNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStateRegDocSrNo() {
        return stateRegDocSrNo;
    }

    /**
     * Sets the value of the stateRegDocSrNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStateRegDocSrNo(JAXBElement<String> value) {
        this.stateRegDocSrNo = value;
    }

    /**
     * Gets the value of the positionTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPositionTypesCode() {
        return positionTypesCode;
    }

    /**
     * Sets the value of the positionTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPositionTypesCode(JAXBElement<String> value) {
        this.positionTypesCode = value;
    }

    /**
     * Gets the value of the positionTypesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPositionTypesText() {
        return positionTypesText;
    }

    /**
     * Sets the value of the positionTypesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPositionTypesText(JAXBElement<String> value) {
        this.positionTypesText = value;
    }

    /**
     * Gets the value of the sectorClassificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectorClassificationCode() {
        return sectorClassificationCode;
    }

    /**
     * Sets the value of the sectorClassificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectorClassificationCode(JAXBElement<String> value) {
        this.sectorClassificationCode = value;
    }

    /**
     * Gets the value of the sectorClassificationText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectorClassificationText() {
        return sectorClassificationText;
    }

    /**
     * Sets the value of the sectorClassificationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectorClassificationText(JAXBElement<String> value) {
        this.sectorClassificationText = value;
    }

    /**
     * Gets the value of the incomeSourcesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeSourcesCode() {
        return incomeSourcesCode;
    }

    /**
     * Sets the value of the incomeSourcesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeSourcesCode(JAXBElement<String> value) {
        this.incomeSourcesCode = value;
    }

    /**
     * Gets the value of the incomeSourcesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeSourcesText() {
        return incomeSourcesText;
    }

    /**
     * Sets the value of the incomeSourcesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeSourcesText(JAXBElement<String> value) {
        this.incomeSourcesText = value;
    }

    /**
     * Gets the value of the incomeLevelsCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeLevelsCode() {
        return incomeLevelsCode;
    }

    /**
     * Sets the value of the incomeLevelsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeLevelsCode(JAXBElement<String> value) {
        this.incomeLevelsCode = value;
    }

    /**
     * Gets the value of the propertyTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPropertyTypesCode() {
        return propertyTypesCode;
    }

    /**
     * Sets the value of the propertyTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPropertyTypesCode(JAXBElement<String> value) {
        this.propertyTypesCode = value;
    }

    /**
     * Gets the value of the bankProductsCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankProductsCode() {
        return bankProductsCode;
    }

    /**
     * Sets the value of the bankProductsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankProductsCode(JAXBElement<String> value) {
        this.bankProductsCode = value;
    }

    /**
     * Gets the value of the workPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkPlace() {
        return workPlace;
    }

    /**
     * Sets the value of the workPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkPlace(JAXBElement<String> value) {
        this.workPlace = value;
    }

    /**
     * Gets the value of the isPublicPerson property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsPublicPerson() {
        return isPublicPerson;
    }

    /**
     * Sets the value of the isPublicPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsPublicPerson(JAXBElement<String> value) {
        this.isPublicPerson = value;
    }

    /**
     * Gets the value of the ctrlIsPublicPerson property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCtrlIsPublicPerson() {
        return ctrlIsPublicPerson;
    }

    /**
     * Sets the value of the ctrlIsPublicPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCtrlIsPublicPerson(JAXBElement<String> value) {
        this.ctrlIsPublicPerson = value;
    }

    /**
     * Gets the value of the activityTypes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActivityTypes() {
        return activityTypes;
    }

    /**
     * Sets the value of the activityTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActivityTypes(JAXBElement<String> value) {
        this.activityTypes = value;
    }

    /**
     * Gets the value of the workKind property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkKind() {
        return workKind;
    }

    /**
     * Sets the value of the workKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkKind(JAXBElement<String> value) {
        this.workKind = value;
    }

    /**
     * Gets the value of the receipts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceipts() {
        return receipts;
    }

    /**
     * Sets the value of the receipts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceipts(JAXBElement<String> value) {
        this.receipts = value;
    }

    /**
     * Gets the value of the issigned property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssigned() {
        return issigned;
    }

    /**
     * Sets the value of the issigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssigned(JAXBElement<String> value) {
        this.issigned = value;
    }

    /**
     * Gets the value of the isclient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsclient() {
        return isclient;
    }

    /**
     * Sets the value of the isclient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsclient(JAXBElement<String> value) {
        this.isclient = value;
    }

}
