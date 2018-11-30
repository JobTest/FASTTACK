
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardsByContragentIdItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardsByContragentIdItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameOnCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardNoXXX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardTypeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardStatusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalCardStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPrimary" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="mBanking" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="mBankingPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardOwnerFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeCardId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="codeCardText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accStatusId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="accStatusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardsByContragentIdItem", propOrder = {
    "cardId",
    "cardHashNumber",
    "nameOnCard",
    "cardNoXXX",
    "cardTypeId",
    "cardTypeText",
    "cardStatusId",
    "cardStatusText",
    "originalCardStatusId",
    "expireDate",
    "isPrimary",
    "mBanking",
    "mBankingPhone",
    "cardOwnerFullName",
    "additionalInfo",
    "codeCardId",
    "codeCardText",
    "accStatusId",
    "accStatusText",
    "projectText"
})
public class GetCardsByContragentIdItem {

    @XmlElementRef(name = "cardId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardId;
    @XmlElementRef(name = "cardHashNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardHashNumber;
    @XmlElementRef(name = "nameOnCard", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameOnCard;
    @XmlElementRef(name = "cardNoXXX", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardNoXXX;
    @XmlElementRef(name = "cardTypeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardTypeId;
    @XmlElementRef(name = "cardTypeText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardTypeText;
    @XmlElementRef(name = "cardStatusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardStatusId;
    @XmlElementRef(name = "cardStatusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardStatusText;
    @XmlElementRef(name = "originalCardStatusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originalCardStatusId;
    @XmlElementRef(name = "expireDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> expireDate;
    @XmlElementRef(name = "isPrimary", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> isPrimary;
    @XmlElementRef(name = "mBanking", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> mBanking;
    @XmlElementRef(name = "mBankingPhone", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mBankingPhone;
    @XmlElementRef(name = "cardOwnerFullName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardOwnerFullName;
    @XmlElementRef(name = "additionalInfo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalInfo;
    @XmlElementRef(name = "codeCardId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> codeCardId;
    @XmlElementRef(name = "codeCardText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codeCardText;
    @XmlElementRef(name = "accStatusId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> accStatusId;
    @XmlElementRef(name = "accStatusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accStatusText;
    @XmlElementRef(name = "projectText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> projectText;

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
     * Gets the value of the nameOnCard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameOnCard() {
        return nameOnCard;
    }

    /**
     * Sets the value of the nameOnCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameOnCard(JAXBElement<String> value) {
        this.nameOnCard = value;
    }

    /**
     * Gets the value of the cardNoXXX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardNoXXX() {
        return cardNoXXX;
    }

    /**
     * Sets the value of the cardNoXXX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardNoXXX(JAXBElement<String> value) {
        this.cardNoXXX = value;
    }

    /**
     * Gets the value of the cardTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardTypeId() {
        return cardTypeId;
    }

    /**
     * Sets the value of the cardTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardTypeId(JAXBElement<String> value) {
        this.cardTypeId = value;
    }

    /**
     * Gets the value of the cardTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardTypeText() {
        return cardTypeText;
    }

    /**
     * Sets the value of the cardTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardTypeText(JAXBElement<String> value) {
        this.cardTypeText = value;
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
     * Gets the value of the originalCardStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginalCardStatusId() {
        return originalCardStatusId;
    }

    /**
     * Sets the value of the originalCardStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginalCardStatusId(JAXBElement<String> value) {
        this.originalCardStatusId = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExpireDate(JAXBElement<String> value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the isPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the value of the isPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIsPrimary(JAXBElement<BigInteger> value) {
        this.isPrimary = value;
    }

    /**
     * Gets the value of the mBanking property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getMBanking() {
        return mBanking;
    }

    /**
     * Sets the value of the mBanking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setMBanking(JAXBElement<BigInteger> value) {
        this.mBanking = value;
    }

    /**
     * Gets the value of the mBankingPhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMBankingPhone() {
        return mBankingPhone;
    }

    /**
     * Sets the value of the mBankingPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMBankingPhone(JAXBElement<String> value) {
        this.mBankingPhone = value;
    }

    /**
     * Gets the value of the cardOwnerFullName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardOwnerFullName() {
        return cardOwnerFullName;
    }

    /**
     * Sets the value of the cardOwnerFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardOwnerFullName(JAXBElement<String> value) {
        this.cardOwnerFullName = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdditionalInfo(JAXBElement<String> value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the codeCardId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCodeCardId() {
        return codeCardId;
    }

    /**
     * Sets the value of the codeCardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCodeCardId(JAXBElement<BigInteger> value) {
        this.codeCardId = value;
    }

    /**
     * Gets the value of the codeCardText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodeCardText() {
        return codeCardText;
    }

    /**
     * Sets the value of the codeCardText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodeCardText(JAXBElement<String> value) {
        this.codeCardText = value;
    }

    /**
     * Gets the value of the accStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getAccStatusId() {
        return accStatusId;
    }

    /**
     * Sets the value of the accStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setAccStatusId(JAXBElement<BigInteger> value) {
        this.accStatusId = value;
    }

    /**
     * Gets the value of the accStatusText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccStatusText() {
        return accStatusText;
    }

    /**
     * Sets the value of the accStatusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccStatusText(JAXBElement<String> value) {
        this.accStatusText = value;
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

}
