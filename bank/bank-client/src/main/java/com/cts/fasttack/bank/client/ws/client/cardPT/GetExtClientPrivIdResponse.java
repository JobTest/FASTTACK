
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getExtClientPrivIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getExtClientPrivIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getExtClientPrivIdItem" type="{http://sab/}getExtClientPrivIdItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getExtClientPrivIdResponse", propOrder = {
    "getExtClientPrivIdItem"
})
public class GetExtClientPrivIdResponse {

    protected List<GetExtClientPrivIdItem> getExtClientPrivIdItem;

    /**
     * Gets the value of the getExtClientPrivIdItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getExtClientPrivIdItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetExtClientPrivIdItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetExtClientPrivIdItem }
     * 
     * 
     */
    public List<GetExtClientPrivIdItem> getGetExtClientPrivIdItem() {
        if (getExtClientPrivIdItem == null) {
            getExtClientPrivIdItem = new ArrayList<GetExtClientPrivIdItem>();
        }
        return this.getExtClientPrivIdItem;
    }

}
