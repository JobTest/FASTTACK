
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
 *         &lt;element name="cardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="barCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trackStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trackStatusAdd1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trackStatusAdd2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileGenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="persFileDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="requestnum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchfilename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="netreceiveddate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="courier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dealid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commentinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="solution" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cardHashNumber",
    "barCode",
    "trackStatus",
    "trackStatusAdd1",
    "trackStatusAdd2",
    "manufacturer",
    "userLogin",
    "fileGenName",
    "persFileDate",
    "requestnum",
    "batchfilename",
    "netreceiveddate",
    "courier",
    "dealid",
    "commentinfo",
    "solution"
})
@XmlRootElement(name = "setCardDeliveryStatus")
public class SetCardDeliveryStatus {

    @XmlElement(required = true, nillable = true)
    protected String cardHashNumber;
    @XmlElement(required = true, nillable = true)
    protected String barCode;
    @XmlElement(required = true, nillable = true)
    protected String trackStatus;
    @XmlElement(required = true, nillable = true)
    protected String trackStatusAdd1;
    @XmlElement(required = true, nillable = true)
    protected String trackStatusAdd2;
    @XmlElement(required = true, nillable = true)
    protected String manufacturer;
    @XmlElement(required = true, nillable = true)
    protected String userLogin;
    @XmlElement(required = true, nillable = true)
    protected String fileGenName;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar persFileDate;
    @XmlElement(required = true, nillable = true)
    protected String requestnum;
    @XmlElement(required = true, nillable = true)
    protected String batchfilename;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar netreceiveddate;
    @XmlElement(required = true, nillable = true)
    protected String courier;
    @XmlElement(required = true, nillable = true)
    protected String dealid;
    @XmlElement(required = true, nillable = true)
    protected String commentinfo;
    @XmlElement(required = true, nillable = true)
    protected String solution;

    /**
     * Gets the value of the cardHashNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHashNumber() {
        return cardHashNumber;
    }

    /**
     * Sets the value of the cardHashNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHashNumber(String value) {
        this.cardHashNumber = value;
    }

    /**
     * Gets the value of the barCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * Sets the value of the barCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarCode(String value) {
        this.barCode = value;
    }

    /**
     * Gets the value of the trackStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackStatus() {
        return trackStatus;
    }

    /**
     * Sets the value of the trackStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackStatus(String value) {
        this.trackStatus = value;
    }

    /**
     * Gets the value of the trackStatusAdd1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackStatusAdd1() {
        return trackStatusAdd1;
    }

    /**
     * Sets the value of the trackStatusAdd1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackStatusAdd1(String value) {
        this.trackStatusAdd1 = value;
    }

    /**
     * Gets the value of the trackStatusAdd2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackStatusAdd2() {
        return trackStatusAdd2;
    }

    /**
     * Sets the value of the trackStatusAdd2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackStatusAdd2(String value) {
        this.trackStatusAdd2 = value;
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
     * Gets the value of the userLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Sets the value of the userLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLogin(String value) {
        this.userLogin = value;
    }

    /**
     * Gets the value of the fileGenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileGenName() {
        return fileGenName;
    }

    /**
     * Sets the value of the fileGenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileGenName(String value) {
        this.fileGenName = value;
    }

    /**
     * Gets the value of the persFileDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPersFileDate() {
        return persFileDate;
    }

    /**
     * Sets the value of the persFileDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPersFileDate(XMLGregorianCalendar value) {
        this.persFileDate = value;
    }

    /**
     * Gets the value of the requestnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestnum() {
        return requestnum;
    }

    /**
     * Sets the value of the requestnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestnum(String value) {
        this.requestnum = value;
    }

    /**
     * Gets the value of the batchfilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchfilename() {
        return batchfilename;
    }

    /**
     * Sets the value of the batchfilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchfilename(String value) {
        this.batchfilename = value;
    }

    /**
     * Gets the value of the netreceiveddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNetreceiveddate() {
        return netreceiveddate;
    }

    /**
     * Sets the value of the netreceiveddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNetreceiveddate(XMLGregorianCalendar value) {
        this.netreceiveddate = value;
    }

    /**
     * Gets the value of the courier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourier() {
        return courier;
    }

    /**
     * Sets the value of the courier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourier(String value) {
        this.courier = value;
    }

    /**
     * Gets the value of the dealid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealid() {
        return dealid;
    }

    /**
     * Sets the value of the dealid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealid(String value) {
        this.dealid = value;
    }

    /**
     * Gets the value of the commentinfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentinfo() {
        return commentinfo;
    }

    /**
     * Sets the value of the commentinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentinfo(String value) {
        this.commentinfo = value;
    }

    /**
     * Gets the value of the solution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSolution() {
        return solution;
    }

    /**
     * Sets the value of the solution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSolution(String value) {
        this.solution = value;
    }

}
