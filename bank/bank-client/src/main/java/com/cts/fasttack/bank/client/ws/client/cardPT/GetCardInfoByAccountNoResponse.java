
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardInfoByAccountNoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardInfoByAccountNoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCardInfoByAccountNoItem" type="{http://sab/}getCardInfoByAccountNoItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardInfoByAccountNoResponse", propOrder = {
    "getCardInfoByAccountNoItem"
})
public class GetCardInfoByAccountNoResponse {

    protected List<GetCardInfoByAccountNoItem> getCardInfoByAccountNoItem;

    /**
     * Gets the value of the getCardInfoByAccountNoItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCardInfoByAccountNoItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCardInfoByAccountNoItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCardInfoByAccountNoItem }
     * 
     * 
     */
    public List<GetCardInfoByAccountNoItem> getGetCardInfoByAccountNoItem() {
        if (getCardInfoByAccountNoItem == null) {
            getCardInfoByAccountNoItem = new ArrayList<GetCardInfoByAccountNoItem>();
        }
        return this.getCardInfoByAccountNoItem;
    }

}
