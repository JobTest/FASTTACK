
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkCodeD5CodeD6Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkCodeD5CodeD6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkCodeD5CodeD6Item" type="{http://sab/}checkCodeD5CodeD6Item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkCodeD5CodeD6Response", propOrder = {
    "checkCodeD5CodeD6Item"
})
public class CheckCodeD5CodeD6Response {

    @XmlElement(nillable = true)
    protected List<CheckCodeD5CodeD6Item> checkCodeD5CodeD6Item;

    /**
     * Gets the value of the checkCodeD5CodeD6Item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkCodeD5CodeD6Item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckCodeD5CodeD6Item().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckCodeD5CodeD6Item }
     * 
     * 
     */
    public List<CheckCodeD5CodeD6Item> getCheckCodeD5CodeD6Item() {
        if (checkCodeD5CodeD6Item == null) {
            checkCodeD5CodeD6Item = new ArrayList<CheckCodeD5CodeD6Item>();
        }
        return this.checkCodeD5CodeD6Item;
    }

}
