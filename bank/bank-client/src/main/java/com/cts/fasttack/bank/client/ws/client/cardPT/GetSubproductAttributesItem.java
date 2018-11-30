
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSubproductAttributesItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSubproductAttributesItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subProductGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actualProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="split" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loyaltyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accidentInsurance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voyage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finRiskInsurance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSubproductAttributesItem", propOrder = {
    "subProductCode",
    "subProductName",
    "subProductGroup",
    "actualProduct",
    "split",
    "premium",
    "loyaltyCode",
    "accidentInsurance",
    "voyage",
    "finRiskInsurance",
    "kService"
})
public class GetSubproductAttributesItem {

    @XmlElementRef(name = "subProductCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subProductCode;
    @XmlElementRef(name = "subProductName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subProductName;
    @XmlElementRef(name = "subProductGroup", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subProductGroup;
    @XmlElementRef(name = "actualProduct", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> actualProduct;
    @XmlElementRef(name = "split", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> split;
    @XmlElementRef(name = "premium", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> premium;
    @XmlElementRef(name = "loyaltyCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loyaltyCode;
    @XmlElementRef(name = "accidentInsurance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accidentInsurance;
    @XmlElementRef(name = "voyage", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> voyage;
    @XmlElementRef(name = "finRiskInsurance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finRiskInsurance;
    @XmlElementRef(name = "kService", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> kService;

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
     * Gets the value of the subProductName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubProductName() {
        return subProductName;
    }

    /**
     * Sets the value of the subProductName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubProductName(JAXBElement<String> value) {
        this.subProductName = value;
    }

    /**
     * Gets the value of the subProductGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubProductGroup() {
        return subProductGroup;
    }

    /**
     * Sets the value of the subProductGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubProductGroup(JAXBElement<String> value) {
        this.subProductGroup = value;
    }

    /**
     * Gets the value of the actualProduct property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActualProduct() {
        return actualProduct;
    }

    /**
     * Sets the value of the actualProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActualProduct(JAXBElement<String> value) {
        this.actualProduct = value;
    }

    /**
     * Gets the value of the split property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSplit() {
        return split;
    }

    /**
     * Sets the value of the split property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSplit(JAXBElement<String> value) {
        this.split = value;
    }

    /**
     * Gets the value of the premium property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPremium() {
        return premium;
    }

    /**
     * Sets the value of the premium property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPremium(JAXBElement<String> value) {
        this.premium = value;
    }

    /**
     * Gets the value of the loyaltyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoyaltyCode() {
        return loyaltyCode;
    }

    /**
     * Sets the value of the loyaltyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoyaltyCode(JAXBElement<String> value) {
        this.loyaltyCode = value;
    }

    /**
     * Gets the value of the accidentInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccidentInsurance() {
        return accidentInsurance;
    }

    /**
     * Sets the value of the accidentInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccidentInsurance(JAXBElement<String> value) {
        this.accidentInsurance = value;
    }

    /**
     * Gets the value of the voyage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVoyage() {
        return voyage;
    }

    /**
     * Sets the value of the voyage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVoyage(JAXBElement<String> value) {
        this.voyage = value;
    }

    /**
     * Gets the value of the finRiskInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinRiskInsurance() {
        return finRiskInsurance;
    }

    /**
     * Sets the value of the finRiskInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinRiskInsurance(JAXBElement<String> value) {
        this.finRiskInsurance = value;
    }

    /**
     * Gets the value of the kService property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKService() {
        return kService;
    }

    /**
     * Sets the value of the kService property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKService(JAXBElement<String> value) {
        this.kService = value;
    }

}
