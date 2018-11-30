
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insBsnStopAfterEmbResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insBsnStopAfterEmbResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="insBsnStopAfterEmbItem" type="{http://sab/}insBsnStopAfterEmbItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insBsnStopAfterEmbResponse", propOrder = {
    "insBsnStopAfterEmbItem"
})
public class InsBsnStopAfterEmbResponse {

    protected List<InsBsnStopAfterEmbItem> insBsnStopAfterEmbItem;

    /**
     * Gets the value of the insBsnStopAfterEmbItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insBsnStopAfterEmbItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsBsnStopAfterEmbItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsBsnStopAfterEmbItem }
     * 
     * 
     */
    public List<InsBsnStopAfterEmbItem> getInsBsnStopAfterEmbItem() {
        if (insBsnStopAfterEmbItem == null) {
            insBsnStopAfterEmbItem = new ArrayList<InsBsnStopAfterEmbItem>();
        }
        return this.insBsnStopAfterEmbItem;
    }

}
