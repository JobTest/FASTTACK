
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStatusMonitoringTransactionsItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStatusMonitoringTransactionsItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cardMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusMonitoringCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="statusMonitoringClient" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatusMonitoringTransactionsItem", propOrder = {
    "cardId",
    "cardMask",
    "cardProject",
    "categoryCard",
    "cardName",
    "statusMonitoringCard",
    "statusMonitoringClient"
})
public class GetStatusMonitoringTransactionsItem {

    @XmlElementRef(name = "cardId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> cardId;
    @XmlElementRef(name = "cardMask", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardMask;
    @XmlElementRef(name = "cardProject", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardProject;
    @XmlElementRef(name = "categoryCard", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> categoryCard;
    @XmlElementRef(name = "cardName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardName;
    @XmlElementRef(name = "statusMonitoringCard", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> statusMonitoringCard;
    @XmlElementRef(name = "statusMonitoringClient", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> statusMonitoringClient;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCardId(JAXBElement<Long> value) {
        this.cardId = value;
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
     * Gets the value of the categoryCard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCategoryCard() {
        return categoryCard;
    }

    /**
     * Sets the value of the categoryCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCategoryCard(JAXBElement<Long> value) {
        this.categoryCard = value;
    }

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardName(JAXBElement<String> value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the statusMonitoringCard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStatusMonitoringCard() {
        return statusMonitoringCard;
    }

    /**
     * Sets the value of the statusMonitoringCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStatusMonitoringCard(JAXBElement<Long> value) {
        this.statusMonitoringCard = value;
    }

    /**
     * Gets the value of the statusMonitoringClient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStatusMonitoringClient() {
        return statusMonitoringClient;
    }

    /**
     * Sets the value of the statusMonitoringClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStatusMonitoringClient(JAXBElement<Long> value) {
        this.statusMonitoringClient = value;
    }

}
