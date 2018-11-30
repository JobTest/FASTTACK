
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkTransferResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkTransferResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkTransferItem" type="{http://sab/}checkTransferItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkTransferResponse", propOrder = {
    "checkTransferItem"
})
public class CheckTransferResponse {

    protected List<CheckTransferItem> checkTransferItem;

    /**
     * Gets the value of the checkTransferItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkTransferItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckTransferItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckTransferItem }
     * 
     * 
     */
    public List<CheckTransferItem> getCheckTransferItem() {
        if (checkTransferItem == null) {
            checkTransferItem = new ArrayList<CheckTransferItem>();
        }
        return this.checkTransferItem;
    }

}
