
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkFMResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkFMResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkFMItem" type="{http://sab/}checkFMItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkFMResponse", propOrder = {
    "checkFMItem"
})
public class CheckFMResponse {

    @XmlElement(nillable = true)
    protected List<CheckFMItem> checkFMItem;

    /**
     * Gets the value of the checkFMItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkFMItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckFMItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckFMItem }
     * 
     * 
     */
    public List<CheckFMItem> getCheckFMItem() {
        if (checkFMItem == null) {
            checkFMItem = new ArrayList<CheckFMItem>();
        }
        return this.checkFMItem;
    }

}
