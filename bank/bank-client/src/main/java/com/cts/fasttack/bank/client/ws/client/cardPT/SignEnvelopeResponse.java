
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signEnvelopeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signEnvelopeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signEnvelopeItem" type="{http://sab/}signEnvelopeItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signEnvelopeResponse", propOrder = {
    "signEnvelopeItem"
})
public class SignEnvelopeResponse {

    protected List<SignEnvelopeItem> signEnvelopeItem;

    /**
     * Gets the value of the signEnvelopeItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signEnvelopeItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignEnvelopeItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignEnvelopeItem }
     * 
     * 
     */
    public List<SignEnvelopeItem> getSignEnvelopeItem() {
        if (signEnvelopeItem == null) {
            signEnvelopeItem = new ArrayList<SignEnvelopeItem>();
        }
        return this.signEnvelopeItem;
    }

}
