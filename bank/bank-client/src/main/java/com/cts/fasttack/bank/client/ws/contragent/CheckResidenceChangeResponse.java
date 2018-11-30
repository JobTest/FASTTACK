
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkResidenceChangeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkResidenceChangeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkResidenceChangeItem" type="{http://sab/}checkResidenceChangeItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkResidenceChangeResponse", propOrder = {
    "checkResidenceChangeItem"
})
public class CheckResidenceChangeResponse {

    @XmlElement(nillable = true)
    protected List<CheckResidenceChangeItem> checkResidenceChangeItem;

    /**
     * Gets the value of the checkResidenceChangeItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkResidenceChangeItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckResidenceChangeItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckResidenceChangeItem }
     * 
     * 
     */
    public List<CheckResidenceChangeItem> getCheckResidenceChangeItem() {
        if (checkResidenceChangeItem == null) {
            checkResidenceChangeItem = new ArrayList<CheckResidenceChangeItem>();
        }
        return this.checkResidenceChangeItem;
    }

}
