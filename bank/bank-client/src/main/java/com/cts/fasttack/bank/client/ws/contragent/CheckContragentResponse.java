
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkContragentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkContragentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkContragentItem" type="{http://sab/}checkContragentItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkContragentResponse", propOrder = {
    "checkContragentItem"
})
public class CheckContragentResponse {

    @XmlElement(nillable = true)
    protected List<CheckContragentItem> checkContragentItem;

    /**
     * Gets the value of the checkContragentItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkContragentItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckContragentItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckContragentItem }
     * 
     * 
     */
    public List<CheckContragentItem> getCheckContragentItem() {
        if (checkContragentItem == null) {
            checkContragentItem = new ArrayList<CheckContragentItem>();
        }
        return this.checkContragentItem;
    }

}
