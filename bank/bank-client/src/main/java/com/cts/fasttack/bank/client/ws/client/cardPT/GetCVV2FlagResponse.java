
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCVV2FlagResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCVV2FlagResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCVV2FlagItem" type="{http://sab/}getCVV2FlagItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCVV2FlagResponse", propOrder = {
    "getCVV2FlagItem"
})
public class GetCVV2FlagResponse {

    protected List<GetCVV2FlagItem> getCVV2FlagItem;

    /**
     * Gets the value of the getCVV2FlagItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCVV2FlagItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCVV2FlagItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCVV2FlagItem }
     * 
     * 
     */
    public List<GetCVV2FlagItem> getGetCVV2FlagItem() {
        if (getCVV2FlagItem == null) {
            getCVV2FlagItem = new ArrayList<GetCVV2FlagItem>();
        }
        return this.getCVV2FlagItem;
    }

}
