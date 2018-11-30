
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.bank.client.ws.client.cardPT.CardContragent;


/**
 * <p>Java class for registerCardContragentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerCardContragentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardContragent" type="{http://sab/}cardContragent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerCardContragentResponse", propOrder = {
    "cardContragent"
})
public class RegisterCardContragentResponse {

    protected List<CardContragent> cardContragent;

    /**
     * Gets the value of the cardContragent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardContragent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardContragent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardContragent }
     * 
     * 
     */
    public List<CardContragent> getCardContragent() {
        if (cardContragent == null) {
            cardContragent = new ArrayList<CardContragent>();
        }
        return this.cardContragent;
    }

}
