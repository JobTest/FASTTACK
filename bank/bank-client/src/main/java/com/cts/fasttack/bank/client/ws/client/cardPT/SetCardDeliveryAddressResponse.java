
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setCardDeliveryAddressResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setCardDeliveryAddressResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setCardDeliveryAddressItem" type="{http://sab/}setCardDeliveryAddressItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCardDeliveryAddressResponse", propOrder = {
    "setCardDeliveryAddressItem"
})
public class SetCardDeliveryAddressResponse {

    protected List<SetCardDeliveryAddressItem> setCardDeliveryAddressItem;

    /**
     * Gets the value of the setCardDeliveryAddressItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the setCardDeliveryAddressItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSetCardDeliveryAddressItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SetCardDeliveryAddressItem }
     * 
     * 
     */
    public List<SetCardDeliveryAddressItem> getSetCardDeliveryAddressItem() {
        if (setCardDeliveryAddressItem == null) {
            setCardDeliveryAddressItem = new ArrayList<SetCardDeliveryAddressItem>();
        }
        return this.setCardDeliveryAddressItem;
    }

}
