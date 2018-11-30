
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
 *         &lt;element name="subProductCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subProductName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subProductGroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="actualProduct" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="split" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="premium" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loyaltyCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accidentInsurance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="voyage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="finRiskInsurance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kService" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "getSubproductAttributes")
public class GetSubproductAttributes {

    @XmlElement(required = true, nillable = true)
    protected String subProductCode;
    @XmlElement(required = true, nillable = true)
    protected String subProductName;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer subProductGroup;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer actualProduct;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer split;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer premium;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer loyaltyCode;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer accidentInsurance;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer voyage;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer finRiskInsurance;
    @XmlElement(required = true, nillable = true)
    protected String kService;

    /**
     * Gets the value of the subProductCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubProductCode() {
        return subProductCode;
    }

    /**
     * Sets the value of the subProductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubProductCode(String value) {
        this.subProductCode = value;
    }

    /**
     * Gets the value of the subProductName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubProductName() {
        return subProductName;
    }

    /**
     * Sets the value of the subProductName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubProductName(String value) {
        this.subProductName = value;
    }

    /**
     * Gets the value of the subProductGroup property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubProductGroup() {
        return subProductGroup;
    }

    /**
     * Sets the value of the subProductGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubProductGroup(Integer value) {
        this.subProductGroup = value;
    }

    /**
     * Gets the value of the actualProduct property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getActualProduct() {
        return actualProduct;
    }

    /**
     * Sets the value of the actualProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setActualProduct(Integer value) {
        this.actualProduct = value;
    }

    /**
     * Gets the value of the split property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSplit() {
        return split;
    }

    /**
     * Sets the value of the split property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSplit(Integer value) {
        this.split = value;
    }

    /**
     * Gets the value of the premium property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPremium() {
        return premium;
    }

    /**
     * Sets the value of the premium property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPremium(Integer value) {
        this.premium = value;
    }

    /**
     * Gets the value of the loyaltyCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLoyaltyCode() {
        return loyaltyCode;
    }

    /**
     * Sets the value of the loyaltyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLoyaltyCode(Integer value) {
        this.loyaltyCode = value;
    }

    /**
     * Gets the value of the accidentInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccidentInsurance() {
        return accidentInsurance;
    }

    /**
     * Sets the value of the accidentInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccidentInsurance(Integer value) {
        this.accidentInsurance = value;
    }

    /**
     * Gets the value of the voyage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVoyage() {
        return voyage;
    }

    /**
     * Sets the value of the voyage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVoyage(Integer value) {
        this.voyage = value;
    }

    /**
     * Gets the value of the finRiskInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFinRiskInsurance() {
        return finRiskInsurance;
    }

    /**
     * Sets the value of the finRiskInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFinRiskInsurance(Integer value) {
        this.finRiskInsurance = value;
    }

    /**
     * Gets the value of the kService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKService() {
        return kService;
    }

    /**
     * Sets the value of the kService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKService(String value) {
        this.kService = value;
    }

}
