
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registerCardDealResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerCardDealResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registerCardDealItem" type="{http://sab/}registerCardDealItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerCardDealResponse", propOrder = {
    "registerCardDealItem"
})
public class RegisterCardDealResponse {

    @XmlElement(nillable = true)
    protected List<RegisterCardDealItem> registerCardDealItem;

    /**
     * Gets the value of the registerCardDealItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registerCardDealItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegisterCardDealItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegisterCardDealItem }
     * 
     * 
     */
    public List<RegisterCardDealItem> getRegisterCardDealItem() {
        if (registerCardDealItem == null) {
            registerCardDealItem = new ArrayList<RegisterCardDealItem>();
        }
        return this.registerCardDealItem;
    }

}
