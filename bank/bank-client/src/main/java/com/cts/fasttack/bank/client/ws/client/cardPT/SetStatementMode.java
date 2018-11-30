
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
 *         &lt;element name="dealNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="addrCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrPostcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrRegion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrDistrict" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrHouseNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrFlat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrBuildNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dealNo",
    "deliveryType",
    "addrCountry",
    "addrPostcode",
    "addrCity",
    "addrRegion",
    "addrDistrict",
    "addrStreet",
    "addrHouseNo",
    "addrFlat",
    "addrBuildNo",
    "email"
})
@XmlRootElement(name = "setStatementMode")
public class SetStatementMode {

    @XmlElement(required = true, nillable = true)
    protected String dealNo;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer deliveryType;
    @XmlElement(required = true, nillable = true)
    protected String addrCountry;
    @XmlElement(required = true, nillable = true)
    protected String addrPostcode;
    @XmlElement(required = true, nillable = true)
    protected String addrCity;
    @XmlElement(required = true, nillable = true)
    protected String addrRegion;
    @XmlElement(required = true, nillable = true)
    protected String addrDistrict;
    @XmlElement(required = true, nillable = true)
    protected String addrStreet;
    @XmlElement(required = true, nillable = true)
    protected String addrHouseNo;
    @XmlElement(required = true, nillable = true)
    protected String addrFlat;
    @XmlElement(required = true, nillable = true)
    protected String addrBuildNo;
    @XmlElement(required = true, nillable = true)
    protected String email;

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
     * Gets the value of the deliveryType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeliveryType() {
        return deliveryType;
    }

    /**
     * Sets the value of the deliveryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryType(Integer value) {
        this.deliveryType = value;
    }

    /**
     * Gets the value of the addrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCountry() {
        return addrCountry;
    }

    /**
     * Sets the value of the addrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCountry(String value) {
        this.addrCountry = value;
    }

    /**
     * Gets the value of the addrPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrPostcode() {
        return addrPostcode;
    }

    /**
     * Sets the value of the addrPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrPostcode(String value) {
        this.addrPostcode = value;
    }

    /**
     * Gets the value of the addrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCity() {
        return addrCity;
    }

    /**
     * Sets the value of the addrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCity(String value) {
        this.addrCity = value;
    }

    /**
     * Gets the value of the addrRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrRegion() {
        return addrRegion;
    }

    /**
     * Sets the value of the addrRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrRegion(String value) {
        this.addrRegion = value;
    }

    /**
     * Gets the value of the addrDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrDistrict() {
        return addrDistrict;
    }

    /**
     * Sets the value of the addrDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrDistrict(String value) {
        this.addrDistrict = value;
    }

    /**
     * Gets the value of the addrStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrStreet() {
        return addrStreet;
    }

    /**
     * Sets the value of the addrStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrStreet(String value) {
        this.addrStreet = value;
    }

    /**
     * Gets the value of the addrHouseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrHouseNo() {
        return addrHouseNo;
    }

    /**
     * Sets the value of the addrHouseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrHouseNo(String value) {
        this.addrHouseNo = value;
    }

    /**
     * Gets the value of the addrFlat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrFlat() {
        return addrFlat;
    }

    /**
     * Sets the value of the addrFlat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrFlat(String value) {
        this.addrFlat = value;
    }

    /**
     * Gets the value of the addrBuildNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrBuildNo() {
        return addrBuildNo;
    }

    /**
     * Sets the value of the addrBuildNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrBuildNo(String value) {
        this.addrBuildNo = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
