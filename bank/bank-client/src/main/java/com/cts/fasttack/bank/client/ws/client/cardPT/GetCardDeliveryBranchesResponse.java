
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardDeliveryBranchesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDeliveryBranchesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCardDeliveryBranchesItem" type="{http://sab/}getCardDeliveryBranchesItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDeliveryBranchesResponse", propOrder = {
    "getCardDeliveryBranchesItem"
})
public class GetCardDeliveryBranchesResponse {

    protected List<GetCardDeliveryBranchesItem> getCardDeliveryBranchesItem;

    /**
     * Gets the value of the getCardDeliveryBranchesItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCardDeliveryBranchesItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCardDeliveryBranchesItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCardDeliveryBranchesItem }
     * 
     * 
     */
    public List<GetCardDeliveryBranchesItem> getGetCardDeliveryBranchesItem() {
        if (getCardDeliveryBranchesItem == null) {
            getCardDeliveryBranchesItem = new ArrayList<GetCardDeliveryBranchesItem>();
        }
        return this.getCardDeliveryBranchesItem;
    }

}
