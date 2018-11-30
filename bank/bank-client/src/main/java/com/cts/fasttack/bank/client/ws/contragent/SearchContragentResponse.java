
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchContragentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchContragentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contragent" type="{http://sab/}contragent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchContragentResponse", propOrder = {
    "contragent"
})
public class SearchContragentResponse {

    @XmlElement(nillable = true)
    protected List<Contragent> contragent;

    /**
     * Gets the value of the contragent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contragent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContragent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contragent }
     * 
     * 
     */
    public List<Contragent> getContragent() {
        if (contragent == null) {
            contragent = new ArrayList<Contragent>();
        }
        return this.contragent;
    }

}
