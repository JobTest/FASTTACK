
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProjectInfoByAgrtplnameItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProjectInfoByAgrtplnameItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="o_Agrtplid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Blocked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Projectid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Projectname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Orgname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Ccycharid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Prefixid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Codecardid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Condid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="o_Perccondid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProjectInfoByAgrtplnameItem", propOrder = {
    "oAgrtplid",
    "oBlocked",
    "oProjectid",
    "oProjectname",
    "oOrgname",
    "oCcycharid",
    "oPrefixid",
    "oCodecardid",
    "oCondid",
    "oPerccondid"
})
public class GetProjectInfoByAgrtplnameItem {

    @XmlElementRef(name = "o_Agrtplid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oAgrtplid;
    @XmlElementRef(name = "o_Blocked", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oBlocked;
    @XmlElementRef(name = "o_Projectid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oProjectid;
    @XmlElementRef(name = "o_Projectname", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oProjectname;
    @XmlElementRef(name = "o_Orgname", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oOrgname;
    @XmlElementRef(name = "o_Ccycharid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oCcycharid;
    @XmlElementRef(name = "o_Prefixid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oPrefixid;
    @XmlElementRef(name = "o_Codecardid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oCodecardid;
    @XmlElementRef(name = "o_Condid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oCondid;
    @XmlElementRef(name = "o_Perccondid", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oPerccondid;

    /**
     * Gets the value of the oAgrtplid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOAgrtplid() {
        return oAgrtplid;
    }

    /**
     * Sets the value of the oAgrtplid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOAgrtplid(JAXBElement<String> value) {
        this.oAgrtplid = value;
    }

    /**
     * Gets the value of the oBlocked property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOBlocked() {
        return oBlocked;
    }

    /**
     * Sets the value of the oBlocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOBlocked(JAXBElement<String> value) {
        this.oBlocked = value;
    }

    /**
     * Gets the value of the oProjectid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOProjectid() {
        return oProjectid;
    }

    /**
     * Sets the value of the oProjectid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOProjectid(JAXBElement<String> value) {
        this.oProjectid = value;
    }

    /**
     * Gets the value of the oProjectname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOProjectname() {
        return oProjectname;
    }

    /**
     * Sets the value of the oProjectname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOProjectname(JAXBElement<String> value) {
        this.oProjectname = value;
    }

    /**
     * Gets the value of the oOrgname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOOrgname() {
        return oOrgname;
    }

    /**
     * Sets the value of the oOrgname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOOrgname(JAXBElement<String> value) {
        this.oOrgname = value;
    }

    /**
     * Gets the value of the oCcycharid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOCcycharid() {
        return oCcycharid;
    }

    /**
     * Sets the value of the oCcycharid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOCcycharid(JAXBElement<String> value) {
        this.oCcycharid = value;
    }

    /**
     * Gets the value of the oPrefixid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOPrefixid() {
        return oPrefixid;
    }

    /**
     * Sets the value of the oPrefixid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOPrefixid(JAXBElement<String> value) {
        this.oPrefixid = value;
    }

    /**
     * Gets the value of the oCodecardid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOCodecardid() {
        return oCodecardid;
    }

    /**
     * Sets the value of the oCodecardid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOCodecardid(JAXBElement<String> value) {
        this.oCodecardid = value;
    }

    /**
     * Gets the value of the oCondid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOCondid() {
        return oCondid;
    }

    /**
     * Sets the value of the oCondid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOCondid(JAXBElement<String> value) {
        this.oCondid = value;
    }

    /**
     * Gets the value of the oPerccondid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOPerccondid() {
        return oPerccondid;
    }

    /**
     * Sets the value of the oPerccondid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOPerccondid(JAXBElement<String> value) {
        this.oPerccondid = value;
    }

}
