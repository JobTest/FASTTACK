
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardDeliveryStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDeliveryStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCardDeliveryStatusItem" type="{http://sab/}getCardDeliveryStatusItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDeliveryStatusResponse", propOrder = {
    "getCardDeliveryStatusItem"
})
public class GetCardDeliveryStatusResponse {

    protected List<GetCardDeliveryStatusItem> getCardDeliveryStatusItem;

    /**
     * Gets the value of the getCardDeliveryStatusItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCardDeliveryStatusItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCardDeliveryStatusItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCardDeliveryStatusItem }
     * 
     * 
     */
    public List<GetCardDeliveryStatusItem> getGetCardDeliveryStatusItem() {
        if (getCardDeliveryStatusItem == null) {
            getCardDeliveryStatusItem = new ArrayList<GetCardDeliveryStatusItem>();
        }
        return this.getCardDeliveryStatusItem;
    }

}
