
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardTemplateText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="brunchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setActivate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportDeliveryModeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dealNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outletCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="posAgent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="corpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardIssueMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cardNumber",
    "cardTemplateText",
    "codeWord",
    "firstNameLatin",
    "lastNameLatin",
    "brunchId",
    "setActivate",
    "reportDeliveryModeId",
    "emailAddress",
    "dealNo",
    "outletCode",
    "posAgent",
    "corpName",
    "cardIssueMode"
})
@XmlRootElement(name = "registerCardDeal")
public class RegisterCardDeal {

    @XmlElement(required = true, nillable = true)
    protected String contragentId;
    @XmlElement(required = true, nillable = true)
    protected String cardNumber;
    @XmlElement(required = true, nillable = true)
    protected String cardTemplateText;
    @XmlElement(required = true, nillable = true)
    protected String codeWord;
    @XmlElement(required = true, nillable = true)
    protected String firstNameLatin;
    @XmlElement(required = true, nillable = true)
    protected String lastNameLatin;
    @XmlElement(required = true, nillable = true)
    protected String brunchId;
    @XmlElement(required = true, nillable = true)
    protected String setActivate;
    @XmlElement(required = true, nillable = true)
    protected String reportDeliveryModeId;
    @XmlElement(required = true, nillable = true)
    protected String emailAddress;
    @XmlElement(required = true, nillable = true)
    protected String dealNo;
    @XmlElement(required = true, nillable = true)
    protected String outletCode;
    @XmlElement(required = true, nillable = true)
    protected String posAgent;
    @XmlElement(required = true, nillable = true)
    protected String corpName;
    @XmlElement(required = true, nillable = true)
    protected String cardIssueMode;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContragentId(String value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardTemplateText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardTemplateText() {
        return cardTemplateText;
    }

    /**
     * Sets the value of the cardTemplateText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardTemplateText(String value) {
        this.cardTemplateText = value;
    }

    /**
     * Gets the value of the codeWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeWord() {
        return codeWord;
    }

    /**
     * Sets the value of the codeWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeWord(String value) {
        this.codeWord = value;
    }

    /**
     * Gets the value of the firstNameLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    /**
     * Sets the value of the firstNameLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstNameLatin(String value) {
        this.firstNameLatin = value;
    }

    /**
     * Gets the value of the lastNameLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNameLatin() {
        return lastNameLatin;
    }

    /**
     * Sets the value of the lastNameLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNameLatin(String value) {
        this.lastNameLatin = value;
    }

    /**
     * Gets the value of the brunchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrunchId() {
        return brunchId;
    }

    /**
     * Sets the value of the brunchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrunchId(String value) {
        this.brunchId = value;
    }

    /**
     * Gets the value of the setActivate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetActivate() {
        return setActivate;
    }

    /**
     * Sets the value of the setActivate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetActivate(String value) {
        this.setActivate = value;
    }

    /**
     * Gets the value of the reportDeliveryModeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDeliveryModeId() {
        return reportDeliveryModeId;
    }

    /**
     * Sets the value of the reportDeliveryModeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDeliveryModeId(String value) {
        this.reportDeliveryModeId = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the dealNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealNo() {
        return dealNo;
    }

    /**
     * Sets the value of the dealNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealNo(String value) {
        this.dealNo = value;
    }

    /**
     * Gets the value of the outletCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutletCode() {
        return outletCode;
    }

    /**
     * Sets the value of the outletCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutletCode(String value) {
        this.outletCode = value;
    }

    /**
     * Gets the value of the posAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosAgent() {
        return posAgent;
    }

    /**
     * Sets the value of the posAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosAgent(String value) {
        this.posAgent = value;
    }

    /**
     * Gets the value of the corpName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * Sets the value of the corpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorpName(String value) {
        this.corpName = value;
    }

    /**
     * Gets the value of the cardIssueMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardIssueMode() {
        return cardIssueMode;
    }

    /**
     * Sets the value of the cardIssueMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardIssueMode(String value) {
        this.cardIssueMode = value;
    }

}
