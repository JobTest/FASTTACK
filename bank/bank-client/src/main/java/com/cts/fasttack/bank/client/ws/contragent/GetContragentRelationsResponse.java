
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getContragentRelationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getContragentRelationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getContragentRelationsItem" type="{http://sab/}getContragentRelationsItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContragentRelationsResponse", propOrder = {
    "getContragentRelationsItem"
})
public class GetContragentRelationsResponse {

    @XmlElement(nillable = true)
    protected List<GetContragentRelationsItem> getContragentRelationsItem;

    /**
     * Gets the value of the getContragentRelationsItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getContragentRelationsItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetContragentRelationsItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetContragentRelationsItem }
     * 
     * 
     */
    public List<GetContragentRelationsItem> getGetContragentRelationsItem() {
        if (getContragentRelationsItem == null) {
            getContragentRelationsItem = new ArrayList<GetContragentRelationsItem>();
        }
        return this.getContragentRelationsItem;
    }

}
