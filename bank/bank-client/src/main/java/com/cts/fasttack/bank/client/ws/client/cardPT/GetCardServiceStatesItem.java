
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardServiceStatesItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardServiceStatesItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alfaCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finRiskInsurance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accidentInsurance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voyage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardServiceStatesItem", propOrder = {
    "alfaCheck",
    "finRiskInsurance",
    "accidentInsurance",
    "voyage",
    "kService"
})
public class GetCardServiceStatesItem {

    @XmlElementRef(name = "alfaCheck", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> alfaCheck;
    @XmlElementRef(name = "finRiskInsurance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finRiskInsurance;
    @XmlElementRef(name = "accidentInsurance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accidentInsurance;
    @XmlElementRef(name = "voyage", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> voyage;
    @XmlElementRef(name = "kService", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> kService;

    /**
     * Gets the value of the alfaCheck property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlfaCheck() {
        return alfaCheck;
    }

    /**
     * Sets the value of the alfaCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlfaCheck(JAXBElement<String> value) {
        this.alfaCheck = value;
    }

    /**
     * Gets the value of the finRiskInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinRiskInsurance() {
        return finRiskInsurance;
    }

    /**
     * Sets the value of the finRiskInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinRiskInsurance(JAXBElement<String> value) {
        this.finRiskInsurance = value;
    }

    /**
     * Gets the value of the accidentInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccidentInsurance() {
        return accidentInsurance;
    }

    /**
     * Sets the value of the accidentInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccidentInsurance(JAXBElement<String> value) {
        this.accidentInsurance = value;
    }

    /**
     * Gets the value of the voyage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVoyage() {
        return voyage;
    }

    /**
     * Sets the value of the voyage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVoyage(JAXBElement<String> value) {
        this.voyage = value;
    }

    /**
     * Gets the value of the kService property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKService() {
        return kService;
    }

    /**
     * Sets the value of the kService property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKService(JAXBElement<String> value) {
        this.kService = value;
    }

}
