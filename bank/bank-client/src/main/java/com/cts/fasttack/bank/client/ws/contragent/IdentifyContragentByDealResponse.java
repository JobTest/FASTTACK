
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identifyContragentByDealResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identifyContragentByDealResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifyContragentByDealItem" type="{http://sab/}identifyContragentByDealItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identifyContragentByDealResponse", propOrder = {
    "identifyContragentByDealItem"
})
public class IdentifyContragentByDealResponse {

    @XmlElement(nillable = true)
    protected List<IdentifyContragentByDealItem> identifyContragentByDealItem;

    /**
     * Gets the value of the identifyContragentByDealItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifyContragentByDealItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifyContragentByDealItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifyContragentByDealItem }
     * 
     * 
     */
    public List<IdentifyContragentByDealItem> getIdentifyContragentByDealItem() {
        if (identifyContragentByDealItem == null) {
            identifyContragentByDealItem = new ArrayList<IdentifyContragentByDealItem>();
        }
        return this.identifyContragentByDealItem;
    }

}
