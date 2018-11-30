
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getContragentRelationsItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getContragentRelationsItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relativeContragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relativeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relativeTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relativeFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationModifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContragentRelationsItem", propOrder = {
    "contragentId",
    "sector",
    "fullName",
    "relationCode",
    "relationName",
    "relativeContragentId",
    "relativeSector",
    "relativeTaxId",
    "relativeFullName",
    "relationModifiedDate"
})
public class GetContragentRelationsItem {

    @XmlElementRef(name = "\u0441ontragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "sector", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sector;
    @XmlElementRef(name = "fullName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fullName;
    @XmlElementRef(name = "relationCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relationCode;
    @XmlElementRef(name = "relationName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relationName;
    @XmlElementRef(name = "relativeContragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relativeContragentId;
    @XmlElementRef(name = "relativeSector", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relativeSector;
    @XmlElementRef(name = "relativeTaxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relativeTaxId;
    @XmlElementRef(name = "relativeFullName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relativeFullName;
    @XmlElementRef(name = "relationModifiedDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relationModifiedDate;

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
     * Gets the value of the sector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSector() {
        return sector;
    }

    /**
     * Sets the value of the sector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSector(JAXBElement<String> value) {
        this.sector = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFullName(JAXBElement<String> value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the relationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelationCode() {
        return relationCode;
    }

    /**
     * Sets the value of the relationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelationCode(JAXBElement<String> value) {
        this.relationCode = value;
    }

    /**
     * Gets the value of the relationName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelationName() {
        return relationName;
    }

    /**
     * Sets the value of the relationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelationName(JAXBElement<String> value) {
        this.relationName = value;
    }

    /**
     * Gets the value of the relativeContragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelativeContragentId() {
        return relativeContragentId;
    }

    /**
     * Sets the value of the relativeContragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelativeContragentId(JAXBElement<String> value) {
        this.relativeContragentId = value;
    }

    /**
     * Gets the value of the relativeSector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelativeSector() {
        return relativeSector;
    }

    /**
     * Sets the value of the relativeSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelativeSector(JAXBElement<String> value) {
        this.relativeSector = value;
    }

    /**
     * Gets the value of the relativeTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelativeTaxId() {
        return relativeTaxId;
    }

    /**
     * Sets the value of the relativeTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelativeTaxId(JAXBElement<String> value) {
        this.relativeTaxId = value;
    }

    /**
     * Gets the value of the relativeFullName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelativeFullName() {
        return relativeFullName;
    }

    /**
     * Sets the value of the relativeFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelativeFullName(JAXBElement<String> value) {
        this.relativeFullName = value;
    }

    /**
     * Gets the value of the relationModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelationModifiedDate() {
        return relationModifiedDate;
    }

    /**
     * Sets the value of the relationModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelationModifiedDate(JAXBElement<String> value) {
        this.relationModifiedDate = value;
    }

}
