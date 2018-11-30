
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAvailableAddCardItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAvailableAddCardItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prefixId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefixName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeCardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardRiskClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardRiskClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authRangeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authRangeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAvailableAddCardItem", propOrder = {
    "prefixId",
    "prefixName",
    "codeCardId",
    "cardName",
    "cardRiskClassId",
    "cardRiskClassName",
    "authRangeId",
    "authRangeName"
})
public class GetAvailableAddCardItem {

    @XmlElementRef(name = "prefixId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prefixId;
    @XmlElementRef(name = "prefixName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prefixName;
    @XmlElementRef(name = "codeCardId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codeCardId;
    @XmlElementRef(name = "cardName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardName;
    @XmlElementRef(name = "cardRiskClassId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardRiskClassId;
    @XmlElementRef(name = "cardRiskClassName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardRiskClassName;
    @XmlElementRef(name = "authRangeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> authRangeId;
    @XmlElementRef(name = "authRangeName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> authRangeName;

    /**
     * Gets the value of the prefixId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrefixId() {
        return prefixId;
    }

    /**
     * Sets the value of the prefixId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrefixId(JAXBElement<String> value) {
        this.prefixId = value;
    }

    /**
     * Gets the value of the prefixName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrefixName() {
        return prefixName;
    }

    /**
     * Sets the value of the prefixName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrefixName(JAXBElement<String> value) {
        this.prefixName = value;
    }

    /**
     * Gets the value of the codeCardId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodeCardId() {
        return codeCardId;
    }

    /**
     * Sets the value of the codeCardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodeCardId(JAXBElement<String> value) {
        this.codeCardId = value;
    }

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardName(JAXBElement<String> value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the cardRiskClassId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardRiskClassId() {
        return cardRiskClassId;
    }

    /**
     * Sets the value of the cardRiskClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardRiskClassId(JAXBElement<String> value) {
        this.cardRiskClassId = value;
    }

    /**
     * Gets the value of the cardRiskClassName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardRiskClassName() {
        return cardRiskClassName;
    }

    /**
     * Sets the value of the cardRiskClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardRiskClassName(JAXBElement<String> value) {
        this.cardRiskClassName = value;
    }

    /**
     * Gets the value of the authRangeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthRangeId() {
        return authRangeId;
    }

    /**
     * Sets the value of the authRangeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthRangeId(JAXBElement<String> value) {
        this.authRangeId = value;
    }

    /**
     * Gets the value of the authRangeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthRangeName() {
        return authRangeName;
    }

    /**
     * Sets the value of the authRangeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthRangeName(JAXBElement<String> value) {
        this.authRangeName = value;
    }

}
