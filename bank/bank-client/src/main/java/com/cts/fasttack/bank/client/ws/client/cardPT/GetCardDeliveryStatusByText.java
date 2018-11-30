
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="searchText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardDeliveryStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plantDeliveryPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "searchText",
    "cardDeliveryStatus",
    "plantDeliveryPoint",
    "shopId"
})
@XmlRootElement(name = "getCardDeliveryStatusByText")
public class GetCardDeliveryStatusByText {

    @XmlElement(required = true, nillable = true)
    protected String searchText;
    @XmlElement(required = true, nillable = true)
    protected String cardDeliveryStatus;
    @XmlElement(required = true, nillable = true)
    protected String plantDeliveryPoint;
    @XmlElement(required = true, nillable = true)
    protected String shopId;

    /**
     * Gets the value of the searchText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Sets the value of the searchText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchText(String value) {
        this.searchText = value;
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

}
