
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getCardDeliveryStatusItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDeliveryStatusItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="embCardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileGenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardDeliveryStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateCreate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datePerson" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFileGen" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dateExp" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="lastChangeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="renewLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chipExist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryRegionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryDistrictCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryCityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryStreetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryHouse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryCorp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryFlat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackStatusAdd1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plantDeliveryPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plantDeliveryPointName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="courier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOnPrint" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="messageIdPrimaryProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardsCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="cityDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaryProcessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDeliveryStatusItem", propOrder = {
    "cardHash",
    "contragentId",
    "embCardName",
    "cardMask",
    "fileGenName",
    "cardProject",
    "cardDeliveryStatus",
    "dateCreate",
    "datePerson",
    "dateFileGen",
    "dateExp",
    "lastChangeDate",
    "manufacturer",
    "renewLabel",
    "chipExist",
    "urgent",
    "deliveryRegionCode",
    "deliveryDistrictCode",
    "deliveryCityCode",
    "deliveryStreetType",
    "deliveryStreet",
    "deliveryHouse",
    "deliveryCorp",
    "deliveryFlat",
    "trackStatusAdd1",
    "plantDeliveryPoint",
    "plantDeliveryPointName",
    "deliveryType",
    "deliveryChannel",
    "shopId",
    "barcode",
    "courier",
    "dateOnPrint",
    "messageIdPrimaryProcess",
    "cardsCount",
    "cityDistrict",
    "primaryProcessCode"
})
public class GetCardDeliveryStatusItem {

    @XmlElementRef(name = "cardHash", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardHash;
    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "embCardName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> embCardName;
    @XmlElementRef(name = "cardMask", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardMask;
    @XmlElementRef(name = "fileGenName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileGenName;
    @XmlElementRef(name = "cardProject", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardProject;
    @XmlElementRef(name = "cardDeliveryStatus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardDeliveryStatus;
    @XmlElementRef(name = "dateCreate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateCreate;
    @XmlElementRef(name = "datePerson", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> datePerson;
    @XmlElementRef(name = "dateFileGen", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateFileGen;
    @XmlElementRef(name = "dateExp", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateExp;
    @XmlElementRef(name = "lastChangeDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastChangeDate;
    @XmlElementRef(name = "manufacturer", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> manufacturer;
    @XmlElementRef(name = "renewLabel", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> renewLabel;
    @XmlElementRef(name = "chipExist", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chipExist;
    @XmlElementRef(name = "urgent", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> urgent;
    @XmlElementRef(name = "deliveryRegionCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryRegionCode;
    @XmlElementRef(name = "deliveryDistrictCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryDistrictCode;
    @XmlElementRef(name = "deliveryCityCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryCityCode;
    @XmlElementRef(name = "deliveryStreetType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryStreetType;
    @XmlElementRef(name = "deliveryStreet", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryStreet;
    @XmlElementRef(name = "deliveryHouse", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryHouse;
    @XmlElementRef(name = "deliveryCorp", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryCorp;
    @XmlElementRef(name = "deliveryFlat", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryFlat;
    @XmlElementRef(name = "trackStatusAdd1", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trackStatusAdd1;
    @XmlElementRef(name = "plantDeliveryPoint", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> plantDeliveryPoint;
    @XmlElementRef(name = "plantDeliveryPointName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> plantDeliveryPointName;
    @XmlElementRef(name = "deliveryType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryType;
    @XmlElementRef(name = "deliveryChannel", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryChannel;
    @XmlElementRef(name = "shopId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shopId;
    @XmlElementRef(name = "barcode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "courier", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> courier;
    @XmlElementRef(name = "dateOnPrint", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOnPrint;
    @XmlElementRef(name = "messageIdPrimaryProcess", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageIdPrimaryProcess;
    @XmlElementRef(name = "cardsCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> cardsCount;
    @XmlElementRef(name = "cityDistrict", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cityDistrict;
    @XmlElementRef(name = "primaryProcessCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> primaryProcessCode;

    /**
     * Gets the value of the cardHash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardHash() {
        return cardHash;
    }

    /**
     * Sets the value of the cardHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardHash(JAXBElement<String> value) {
        this.cardHash = value;
    }

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
     * Gets the value of the embCardName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmbCardName() {
        return embCardName;
    }

    /**
     * Sets the value of the embCardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmbCardName(JAXBElement<String> value) {
        this.embCardName = value;
    }

    /**
     * Gets the value of the cardMask property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardMask() {
        return cardMask;
    }

    /**
     * Sets the value of the cardMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardMask(JAXBElement<String> value) {
        this.cardMask = value;
    }

    /**
     * Gets the value of the fileGenName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileGenName() {
        return fileGenName;
    }

    /**
     * Sets the value of the fileGenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileGenName(JAXBElement<String> value) {
        this.fileGenName = value;
    }

    /**
     * Gets the value of the cardProject property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardProject() {
        return cardProject;
    }

    /**
     * Sets the value of the cardProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardProject(JAXBElement<String> value) {
        this.cardProject = value;
    }

    /**
     * Gets the value of the cardDeliveryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardDeliveryStatus() {
        return cardDeliveryStatus;
    }

    /**
     * Sets the value of the cardDeliveryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardDeliveryStatus(JAXBElement<String> value) {
        this.cardDeliveryStatus = value;
    }

    /**
     * Gets the value of the dateCreate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateCreate() {
        return dateCreate;
    }

    /**
     * Sets the value of the dateCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateCreate(JAXBElement<XMLGregorianCalendar> value) {
        this.dateCreate = value;
    }

    /**
     * Gets the value of the datePerson property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDatePerson() {
        return datePerson;
    }

    /**
     * Sets the value of the datePerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDatePerson(JAXBElement<XMLGregorianCalendar> value) {
        this.datePerson = value;
    }

    /**
     * Gets the value of the dateFileGen property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateFileGen() {
        return dateFileGen;
    }

    /**
     * Sets the value of the dateFileGen property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateFileGen(JAXBElement<XMLGregorianCalendar> value) {
        this.dateFileGen = value;
    }

    /**
     * Gets the value of the dateExp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateExp() {
        return dateExp;
    }

    /**
     * Sets the value of the dateExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateExp(JAXBElement<XMLGregorianCalendar> value) {
        this.dateExp = value;
    }

    /**
     * Gets the value of the lastChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastChangeDate() {
        return lastChangeDate;
    }

    /**
     * Sets the value of the lastChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastChangeDate(JAXBElement<XMLGregorianCalendar> value) {
        this.lastChangeDate = value;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setManufacturer(JAXBElement<String> value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the renewLabel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRenewLabel() {
        return renewLabel;
    }

    /**
     * Sets the value of the renewLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRenewLabel(JAXBElement<String> value) {
        this.renewLabel = value;
    }

    /**
     * Gets the value of the chipExist property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChipExist() {
        return chipExist;
    }

    /**
     * Sets the value of the chipExist property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChipExist(JAXBElement<String> value) {
        this.chipExist = value;
    }

    /**
     * Gets the value of the urgent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUrgent() {
        return urgent;
    }

    /**
     * Sets the value of the urgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUrgent(JAXBElement<String> value) {
        this.urgent = value;
    }

    /**
     * Gets the value of the deliveryRegionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryRegionCode() {
        return deliveryRegionCode;
    }

    /**
     * Sets the value of the deliveryRegionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryRegionCode(JAXBElement<String> value) {
        this.deliveryRegionCode = value;
    }

    /**
     * Gets the value of the deliveryDistrictCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryDistrictCode() {
        return deliveryDistrictCode;
    }

    /**
     * Sets the value of the deliveryDistrictCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryDistrictCode(JAXBElement<String> value) {
        this.deliveryDistrictCode = value;
    }

    /**
     * Gets the value of the deliveryCityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryCityCode() {
        return deliveryCityCode;
    }

    /**
     * Sets the value of the deliveryCityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryCityCode(JAXBElement<String> value) {
        this.deliveryCityCode = value;
    }

    /**
     * Gets the value of the deliveryStreetType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryStreetType() {
        return deliveryStreetType;
    }

    /**
     * Sets the value of the deliveryStreetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryStreetType(JAXBElement<String> value) {
        this.deliveryStreetType = value;
    }

    /**
     * Gets the value of the deliveryStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryStreet() {
        return deliveryStreet;
    }

    /**
     * Sets the value of the deliveryStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryStreet(JAXBElement<String> value) {
        this.deliveryStreet = value;
    }

    /**
     * Gets the value of the deliveryHouse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryHouse() {
        return deliveryHouse;
    }

    /**
     * Sets the value of the deliveryHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryHouse(JAXBElement<String> value) {
        this.deliveryHouse = value;
    }

    /**
     * Gets the value of the deliveryCorp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryCorp() {
        return deliveryCorp;
    }

    /**
     * Sets the value of the deliveryCorp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryCorp(JAXBElement<String> value) {
        this.deliveryCorp = value;
    }

    /**
     * Gets the value of the deliveryFlat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryFlat() {
        return deliveryFlat;
    }

    /**
     * Sets the value of the deliveryFlat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryFlat(JAXBElement<String> value) {
        this.deliveryFlat = value;
    }

    /**
     * Gets the value of the trackStatusAdd1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackStatusAdd1() {
        return trackStatusAdd1;
    }

    /**
     * Sets the value of the trackStatusAdd1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackStatusAdd1(JAXBElement<String> value) {
        this.trackStatusAdd1 = value;
    }

    /**
     * Gets the value of the plantDeliveryPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlantDeliveryPoint() {
        return plantDeliveryPoint;
    }

    /**
     * Sets the value of the plantDeliveryPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlantDeliveryPoint(JAXBElement<String> value) {
        this.plantDeliveryPoint = value;
    }

    /**
     * Gets the value of the plantDeliveryPointName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlantDeliveryPointName() {
        return plantDeliveryPointName;
    }

    /**
     * Sets the value of the plantDeliveryPointName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlantDeliveryPointName(JAXBElement<String> value) {
        this.plantDeliveryPointName = value;
    }

    /**
     * Gets the value of the deliveryType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryType() {
        return deliveryType;
    }

    /**
     * Sets the value of the deliveryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryType(JAXBElement<String> value) {
        this.deliveryType = value;
    }

    /**
     * Gets the value of the deliveryChannel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryChannel() {
        return deliveryChannel;
    }

    /**
     * Sets the value of the deliveryChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryChannel(JAXBElement<String> value) {
        this.deliveryChannel = value;
    }

    /**
     * Gets the value of the shopId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopId() {
        return shopId;
    }

    /**
     * Sets the value of the shopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopId(JAXBElement<String> value) {
        this.shopId = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBarcode(JAXBElement<String> value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the courier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCourier() {
        return courier;
    }

    /**
     * Sets the value of the courier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCourier(JAXBElement<String> value) {
        this.courier = value;
    }

    /**
     * Gets the value of the dateOnPrint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateOnPrint() {
        return dateOnPrint;
    }

    /**
     * Sets the value of the dateOnPrint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateOnPrint(JAXBElement<XMLGregorianCalendar> value) {
        this.dateOnPrint = value;
    }

    /**
     * Gets the value of the messageIdPrimaryProcess property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageIdPrimaryProcess() {
        return messageIdPrimaryProcess;
    }

    /**
     * Sets the value of the messageIdPrimaryProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageIdPrimaryProcess(JAXBElement<String> value) {
        this.messageIdPrimaryProcess = value;
    }

    /**
     * Gets the value of the cardsCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCardsCount() {
        return cardsCount;
    }

    /**
     * Sets the value of the cardsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCardsCount(JAXBElement<BigInteger> value) {
        this.cardsCount = value;
    }

    /**
     * Gets the value of the cityDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCityDistrict() {
        return cityDistrict;
    }

    /**
     * Sets the value of the cityDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCityDistrict(JAXBElement<String> value) {
        this.cityDistrict = value;
    }

    /**
     * Gets the value of the primaryProcessCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimaryProcessCode() {
        return primaryProcessCode;
    }

    /**
     * Sets the value of the primaryProcessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimaryProcessCode(JAXBElement<String> value) {
        this.primaryProcessCode = value;
    }

}
