
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardDealJurItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDealJurItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dealId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountStatusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountContragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardStatusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardContragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isChipCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPrimary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDealJurItem", propOrder = {
    "dealId",
    "dealNo",
    "accountNumber",
    "currencyCode",
    "accountStatusId",
    "accountStatusText",
    "accountContragentId",
    "companyName",
    "projectId",
    "projectText",
    "cardId",
    "cardHashNumber",
    "cardStatusId",
    "cardStatusText",
    "contragentName",
    "cardContragentId",
    "isChipCard",
    "isPrimary",
    "responseCode",
    "responseText"
})
public class GetCardDealJurItem {

    @XmlElementRef(name = "dealId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealId;
    @XmlElementRef(name = "dealNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dealNo;
    @XmlElementRef(name = "accountNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountNumber;
    @XmlElementRef(name = "currencyCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currencyCode;
    @XmlElementRef(name = "accountStatusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountStatusId;
    @XmlElementRef(name = "accountStatusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountStatusText;
    @XmlElementRef(name = "accountContragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountContragentId;
    @XmlElementRef(name = "companyName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyName;
    @XmlElementRef(name = "projectId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectId;
    @XmlElementRef(name = "projectText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectText;
    @XmlElementRef(name = "cardId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardId;
    @XmlElementRef(name = "cardHashNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardHashNumber;
    @XmlElementRef(name = "cardStatusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardStatusId;
    @XmlElementRef(name = "cardStatusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardStatusText;
    @XmlElementRef(name = "contragentName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentName;
    @XmlElementRef(name = "cardContragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardContragentId;
    @XmlElementRef(name = "isChipCard", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isChipCard;
    @XmlElementRef(name = "isPrimary", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isPrimary;
    @XmlElementRef(name = "responseCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> responseCode;
    @XmlElementRef(name = "responseText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> responseText;

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
     * Gets the value of the accountStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountStatusId() {
        return accountStatusId;
    }

    /**
     * Sets the value of the accountStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountStatusId(JAXBElement<String> value) {
        this.accountStatusId = value;
    }

    /**
     * Gets the value of the accountStatusText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountStatusText() {
        return accountStatusText;
    }

    /**
     * Sets the value of the accountStatusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountStatusText(JAXBElement<String> value) {
        this.accountStatusText = value;
    }

    /**
     * Gets the value of the accountContragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountContragentId() {
        return accountContragentId;
    }

    /**
     * Sets the value of the accountContragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountContragentId(JAXBElement<String> value) {
        this.accountContragentId = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyName(JAXBElement<String> value) {
        this.companyName = value;
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
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardId(JAXBElement<String> value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the cardHashNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardHashNumber() {
        return cardHashNumber;
    }

    /**
     * Sets the value of the cardHashNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardHashNumber(JAXBElement<String> value) {
        this.cardHashNumber = value;
    }

    /**
     * Gets the value of the cardStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardStatusId() {
        return cardStatusId;
    }

    /**
     * Sets the value of the cardStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardStatusId(JAXBElement<String> value) {
        this.cardStatusId = value;
    }

    /**
     * Gets the value of the cardStatusText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardStatusText() {
        return cardStatusText;
    }

    /**
     * Sets the value of the cardStatusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardStatusText(JAXBElement<String> value) {
        this.cardStatusText = value;
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
     * Gets the value of the cardContragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardContragentId() {
        return cardContragentId;
    }

    /**
     * Sets the value of the cardContragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardContragentId(JAXBElement<String> value) {
        this.cardContragentId = value;
    }

    /**
     * Gets the value of the isChipCard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsChipCard() {
        return isChipCard;
    }

    /**
     * Sets the value of the isChipCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsChipCard(JAXBElement<String> value) {
        this.isChipCard = value;
    }

    /**
     * Gets the value of the isPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the value of the isPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsPrimary(JAXBElement<String> value) {
        this.isPrimary = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponseCode(JAXBElement<String> value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponseText() {
        return responseText;
    }

    /**
     * Sets the value of the responseText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponseText(JAXBElement<String> value) {
        this.responseText = value;
    }

}
