
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchContragentByAccountNoItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchContragentByAccountNoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sysFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="getContragentByIdResponse" type="{http://sab/}getContragentByIdResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchContragentByAccountNoItem", propOrder = {
    "sysFrom",
    "contragentId",
    "getContragentByIdResponse"
})
public class SearchContragentByAccountNoItem {

    @XmlElementRef(name = "sysFrom", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sysFrom;
    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "getContragentByIdResponse", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetContragentByIdResponse> getContragentByIdResponse;

    /**
     * Gets the value of the sysFrom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSysFrom() {
        return sysFrom;
    }

    /**
     * Sets the value of the sysFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSysFrom(JAXBElement<String> value) {
        this.sysFrom = value;
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
     * Gets the value of the getContragentByIdResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetContragentByIdResponse }{@code >}
     *     
     */
    public JAXBElement<GetContragentByIdResponse> getGetContragentByIdResponse() {
        return getContragentByIdResponse;
    }

    /**
     * Sets the value of the getContragentByIdResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetContragentByIdResponse }{@code >}
     *     
     */
    public void setGetContragentByIdResponse(JAXBElement<GetContragentByIdResponse> value) {
        this.getContragentByIdResponse = value;
    }

}
