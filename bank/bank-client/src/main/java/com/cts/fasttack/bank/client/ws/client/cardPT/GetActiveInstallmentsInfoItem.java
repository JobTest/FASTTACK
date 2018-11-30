
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getActiveInstallmentsInfoItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getActiveInstallmentsInfoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="installmentID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="operationInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="operationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="periodAmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="periodComiss" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="periodPrc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="remainAmt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="remainCnt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="remainAmtBody" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getActiveInstallmentsInfoItem", propOrder = {
    "installmentID",
    "operationInfo",
    "startAmount",
    "operationDate",
    "periodAmt",
    "periodComiss",
    "periodPrc",
    "remainAmt",
    "remainCnt",
    "remainAmtBody"
})
public class GetActiveInstallmentsInfoItem {

    @XmlElementRef(name = "installmentID", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> installmentID;
    @XmlElementRef(name = "operationInfo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operationInfo;
    @XmlElementRef(name = "startAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> startAmount;
    @XmlElementRef(name = "operationDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> operationDate;
    @XmlElementRef(name = "periodAmt", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> periodAmt;
    @XmlElementRef(name = "periodComiss", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> periodComiss;
    @XmlElementRef(name = "periodPrc", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> periodPrc;
    @XmlElementRef(name = "remainAmt", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> remainAmt;
    @XmlElementRef(name = "remainCnt", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> remainCnt;
    @XmlElementRef(name = "remainAmtBody", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> remainAmtBody;

    /**
     * Gets the value of the installmentID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInstallmentID() {
        return installmentID;
    }

    /**
     * Sets the value of the installmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInstallmentID(JAXBElement<Long> value) {
        this.installmentID = value;
    }

    /**
     * Gets the value of the operationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperationInfo() {
        return operationInfo;
    }

    /**
     * Sets the value of the operationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperationInfo(JAXBElement<String> value) {
        this.operationInfo = value;
    }

    /**
     * Gets the value of the startAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStartAmount() {
        return startAmount;
    }

    /**
     * Sets the value of the startAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStartAmount(JAXBElement<Long> value) {
        this.startAmount = value;
    }

    /**
     * Gets the value of the operationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getOperationDate() {
        return operationDate;
    }

    /**
     * Sets the value of the operationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setOperationDate(JAXBElement<XMLGregorianCalendar> value) {
        this.operationDate = value;
    }

    /**
     * Gets the value of the periodAmt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPeriodAmt() {
        return periodAmt;
    }

    /**
     * Sets the value of the periodAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPeriodAmt(JAXBElement<Long> value) {
        this.periodAmt = value;
    }

    /**
     * Gets the value of the periodComiss property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPeriodComiss() {
        return periodComiss;
    }

    /**
     * Sets the value of the periodComiss property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPeriodComiss(JAXBElement<Long> value) {
        this.periodComiss = value;
    }

    /**
     * Gets the value of the periodPrc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPeriodPrc() {
        return periodPrc;
    }

    /**
     * Sets the value of the periodPrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPeriodPrc(JAXBElement<Long> value) {
        this.periodPrc = value;
    }

    /**
     * Gets the value of the remainAmt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRemainAmt() {
        return remainAmt;
    }

    /**
     * Sets the value of the remainAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRemainAmt(JAXBElement<Long> value) {
        this.remainAmt = value;
    }

    /**
     * Gets the value of the remainCnt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRemainCnt() {
        return remainCnt;
    }

    /**
     * Sets the value of the remainCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRemainCnt(JAXBElement<Long> value) {
        this.remainCnt = value;
    }

    /**
     * Gets the value of the remainAmtBody property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRemainAmtBody() {
        return remainAmtBody;
    }

    /**
     * Sets the value of the remainAmtBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRemainAmtBody(JAXBElement<Long> value) {
        this.remainAmtBody = value;
    }

}
