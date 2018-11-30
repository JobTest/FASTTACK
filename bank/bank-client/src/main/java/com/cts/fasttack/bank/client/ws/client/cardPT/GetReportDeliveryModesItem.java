
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getReportDeliveryModesItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReportDeliveryModesItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportDeliveryModeId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="reportDeliveryModeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReportDeliveryModesItem", propOrder = {
    "reportDeliveryModeId",
    "reportDeliveryModeText"
})
public class GetReportDeliveryModesItem {

    @XmlElementRef(name = "reportDeliveryModeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> reportDeliveryModeId;
    @XmlElementRef(name = "reportDeliveryModeText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportDeliveryModeText;

    /**
     * Gets the value of the reportDeliveryModeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getReportDeliveryModeId() {
        return reportDeliveryModeId;
    }

    /**
     * Sets the value of the reportDeliveryModeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setReportDeliveryModeId(JAXBElement<BigInteger> value) {
        this.reportDeliveryModeId = value;
    }

    /**
     * Gets the value of the reportDeliveryModeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportDeliveryModeText() {
        return reportDeliveryModeText;
    }

    /**
     * Sets the value of the reportDeliveryModeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportDeliveryModeText(JAXBElement<String> value) {
        this.reportDeliveryModeText = value;
    }

}
