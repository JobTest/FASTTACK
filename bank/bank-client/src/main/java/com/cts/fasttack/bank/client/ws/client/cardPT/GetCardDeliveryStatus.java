
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="cardHash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardDeliveryStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plantDeliveryPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="embCardName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardProject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateCreateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateCreateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datePersonFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datePersonTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateFileGenFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateFileGenTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateExpFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateExpTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateLastChangeFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateLastChangeTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="renewLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chipExist" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="urgent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryRegionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryDistrictCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateOnPrintFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateOnPrintTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "cardHash",
    "cardDeliveryStatus",
    "plantDeliveryPoint",
    "shopId",
    "embCardName",
    "cardPrefix",
    "cardSuffix",
    "cardProject",
    "dateCreateFrom",
    "dateCreateTo",
    "datePersonFrom",
    "datePersonTo",
    "dateFileGenFrom",
    "dateFileGenTo",
    "dateExpFrom",
    "dateExpTo",
    "dateLastChangeFrom",
    "dateLastChangeTo",
    "manufacturer",
    "renewLabel",
    "chipExist",
    "urgent",
    "deliveryRegionCode",
    "deliveryDistrictCode",
    "barcode",
    "dateOnPrintFrom",
    "dateOnPrintTo"
})
@XmlRootElement(name = "getCardDeliveryStatus")
public class GetCardDeliveryStatus {

    @XmlElement(required = true, nillable = true)
    protected String cardHash;
    @XmlElement(required = true, nillable = true)
    protected String cardDeliveryStatus;
    @XmlElement(required = true, nillable = true)
    protected String plantDeliveryPoint;
    @XmlElement(required = true, nillable = true)
    protected String shopId;
    @XmlElement(required = true, nillable = true)
    protected String embCardName;
    @XmlElement(required = true, nillable = true)
    protected String cardPrefix;
    @XmlElement(required = true, nillable = true)
    protected String cardSuffix;
    @XmlElement(required = true, nillable = true)
    protected String cardProject;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateCreateFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateCreateTo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datePersonFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datePersonTo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFileGenFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFileGenTo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateExpFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateExpTo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastChangeFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastChangeTo;
    @XmlElement(required = true, nillable = true)
    protected String manufacturer;
    @XmlElement(required = true, nillable = true)
    protected String renewLabel;
    @XmlElement(required = true, nillable = true)
    protected String chipExist;
    @XmlElement(required = true, nillable = true)
    protected String urgent;
    @XmlElement(required = true, nillable = true)
    protected String deliveryRegionCode;
    @XmlElement(required = true, nillable = true)
    protected String deliveryDistrictCode;
    @XmlElement(required = true, nillable = true)
    protected String barcode;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOnPrintFrom;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOnPrintTo;

    /**
     * Gets the value of the cardHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHash() {
        return cardHash;
    }

    /**
     * Sets the value of the cardHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHash(String value) {
        this.cardHash = value;
    }

    /**
     * Gets the value of the cardDeliveryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardDeliveryStatus() {
        return cardDeliveryStatus;
    }

    /**
     * Sets the value of the cardDeliveryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardDeliveryStatus(String value) {
        this.cardDeliveryStatus = value;
    }

    /**
     * Gets the value of the plantDeliveryPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlantDeliveryPoint() {
        return plantDeliveryPoint;
    }

    /**
     * Sets the value of the plantDeliveryPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlantDeliveryPoint(String value) {
        this.plantDeliveryPoint = value;
    }

    /**
     * Gets the value of the shopId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * Sets the value of the shopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopId(String value) {
        this.shopId = value;
    }

    /**
     * Gets the value of the embCardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbCardName() {
        return embCardName;
    }

    /**
     * Sets the value of the embCardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbCardName(String value) {
        this.embCardName = value;
    }

    /**
     * Gets the value of the cardPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardPrefix() {
        return cardPrefix;
    }

    /**
     * Sets the value of the cardPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardPrefix(String value) {
        this.cardPrefix = value;
    }

    /**
     * Gets the value of the cardSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSuffix() {
        return cardSuffix;
    }

    /**
     * Sets the value of the cardSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSuffix(String value) {
        this.cardSuffix = value;
    }

    /**
     * Gets the value of the cardProject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardProject() {
        return cardProject;
    }

    /**
     * Sets the value of the cardProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardProject(String value) {
        this.cardProject = value;
    }

    /**
     * Gets the value of the dateCreateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreateFrom() {
        return dateCreateFrom;
    }

    /**
     * Sets the value of the dateCreateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreateFrom(XMLGregorianCalendar value) {
        this.dateCreateFrom = value;
    }

    /**
     * Gets the value of the dateCreateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreateTo() {
        return dateCreateTo;
    }

    /**
     * Sets the value of the dateCreateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreateTo(XMLGregorianCalendar value) {
        this.dateCreateTo = value;
    }

    /**
     * Gets the value of the datePersonFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePersonFrom() {
        return datePersonFrom;
    }

    /**
     * Sets the value of the datePersonFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePersonFrom(XMLGregorianCalendar value) {
        this.datePersonFrom = value;
    }

    /**
     * Gets the value of the datePersonTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePersonTo() {
        return datePersonTo;
    }

    /**
     * Sets the value of the datePersonTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePersonTo(XMLGregorianCalendar value) {
        this.datePersonTo = value;
    }

    /**
     * Gets the value of the dateFileGenFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFileGenFrom() {
        return dateFileGenFrom;
    }

    /**
     * Sets the value of the dateFileGenFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFileGenFrom(XMLGregorianCalendar value) {
        this.dateFileGenFrom = value;
    }

    /**
     * Gets the value of the dateFileGenTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFileGenTo() {
        return dateFileGenTo;
    }

    /**
     * Sets the value of the dateFileGenTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFileGenTo(XMLGregorianCalendar value) {
        this.dateFileGenTo = value;
    }

    /**
     * Gets the value of the dateExpFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateExpFrom() {
        return dateExpFrom;
    }

    /**
     * Sets the value of the dateExpFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateExpFrom(XMLGregorianCalendar value) {
        this.dateExpFrom = value;
    }

    /**
     * Gets the value of the dateExpTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateExpTo() {
        return dateExpTo;
    }

    /**
     * Sets the value of the dateExpTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateExpTo(XMLGregorianCalendar value) {
        this.dateExpTo = value;
    }

    /**
     * Gets the value of the dateLastChangeFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastChangeFrom() {
        return dateLastChangeFrom;
    }

    /**
     * Sets the value of the dateLastChangeFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastChangeFrom(XMLGregorianCalendar value) {
        this.dateLastChangeFrom = value;
    }

    /**
     * Gets the value of the dateLastChangeTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastChangeTo() {
        return dateLastChangeTo;
    }

    /**
     * Sets the value of the dateLastChangeTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastChangeTo(XMLGregorianCalendar value) {
        this.dateLastChangeTo = value;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the renewLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewLabel() {
        return renewLabel;
    }

    /**
     * Sets the value of the renewLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewLabel(String value) {
        this.renewLabel = value;
    }

    /**
     * Gets the value of the chipExist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChipExist() {
        return chipExist;
    }

    /**
     * Sets the value of the chipExist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChipExist(String value) {
        this.chipExist = value;
    }

    /**
     * Gets the value of the urgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrgent() {
        return urgent;
    }

    /**
     * Sets the value of the urgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrgent(String value) {
        this.urgent = value;
    }

    /**
     * Gets the value of the deliveryRegionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryRegionCode() {
        return deliveryRegionCode;
    }

    /**
     * Sets the value of the deliveryRegionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryRegionCode(String value) {
        this.deliveryRegionCode = value;
    }

    /**
     * Gets the value of the deliveryDistrictCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryDistrictCode() {
        return deliveryDistrictCode;
    }

    /**
     * Sets the value of the deliveryDistrictCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryDistrictCode(String value) {
        this.deliveryDistrictCode = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the dateOnPrintFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOnPrintFrom() {
        return dateOnPrintFrom;
    }

    /**
     * Sets the value of the dateOnPrintFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOnPrintFrom(XMLGregorianCalendar value) {
        this.dateOnPrintFrom = value;
    }

    /**
     * Gets the value of the dateOnPrintTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOnPrintTo() {
        return dateOnPrintTo;
    }

    /**
     * Sets the value of the dateOnPrintTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOnPrintTo(XMLGregorianCalendar value) {
        this.dateOnPrintTo = value;
    }

}
