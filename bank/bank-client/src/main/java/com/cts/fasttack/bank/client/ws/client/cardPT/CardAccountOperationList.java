
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cardAccountOperationList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardAccountOperationList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardAccountOperationItem" type="{http://sab/}cardAccountOperationItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardAccountOperationList", propOrder = {
    "cardAccountOperationItem"
})
public class CardAccountOperationList {

    protected List<CardAccountOperationItem> cardAccountOperationItem;

    /**
     * Gets the value of the cardAccountOperationItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardAccountOperationItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardAccountOperationItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardAccountOperationItem }
     * 
     * 
     */
    public List<CardAccountOperationItem> getCardAccountOperationItem() {
        if (cardAccountOperationItem == null) {
            cardAccountOperationItem = new ArrayList<CardAccountOperationItem>();
        }
        return this.cardAccountOperationItem;
    }

}
