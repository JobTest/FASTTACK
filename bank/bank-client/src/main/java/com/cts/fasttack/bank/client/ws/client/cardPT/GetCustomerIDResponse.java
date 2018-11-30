
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for getCustomerIDResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCustomerIDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCustomerIDItem" type="{http://sab/}getCustomerIDItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerIDResponse", propOrder = {
    "getCustomerIDItem"
})
@XmlRootElement(name = "getCustomerIDResponse", namespace = "http://sab/")
public class GetCustomerIDResponse {

    @XmlElement(name = "getCustomerIDItem", namespace = "http://sab/")
    protected List<GetCustomerIDItem> getCustomerIDItem;

    /**
     * Gets the value of the getCustomerIDItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCustomerIDItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCustomerIDItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCustomerIDItem }
     * 
     * 
     */
    public List<GetCustomerIDItem> getGetCustomerIDItem() {
        if (getCustomerIDItem == null) {
            getCustomerIDItem = new ArrayList<GetCustomerIDItem>();
        }
        return this.getCustomerIDItem;
    }

}
