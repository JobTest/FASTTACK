
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardDeliveryStatusLogResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDeliveryStatusLogResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCardDeliveryStatusLogItem" type="{http://sab/}getCardDeliveryStatusLogItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDeliveryStatusLogResponse", propOrder = {
    "getCardDeliveryStatusLogItem"
})
public class GetCardDeliveryStatusLogResponse {

    protected List<GetCardDeliveryStatusLogItem> getCardDeliveryStatusLogItem;

    /**
     * Gets the value of the getCardDeliveryStatusLogItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCardDeliveryStatusLogItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCardDeliveryStatusLogItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCardDeliveryStatusLogItem }
     * 
     * 
     */
    public List<GetCardDeliveryStatusLogItem> getGetCardDeliveryStatusLogItem() {
        if (getCardDeliveryStatusLogItem == null) {
            getCardDeliveryStatusLogItem = new ArrayList<GetCardDeliveryStatusLogItem>();
        }
        return this.getCardDeliveryStatusLogItem;
    }

}
