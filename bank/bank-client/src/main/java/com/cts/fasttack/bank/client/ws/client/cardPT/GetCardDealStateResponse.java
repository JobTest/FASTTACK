
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.bank.client.ws.client.cardPT.CardDealState;


/**
 * <p>Java class for getCardDealStateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDealStateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardDealState" type="{http://sab/}cardDealState" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDealStateResponse", propOrder = {
    "cardDealState"
})
public class GetCardDealStateResponse {

    protected List<CardDealState> cardDealState;

    /**
     * Gets the value of the cardDealState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardDealState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardDealState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardDealState }
     * 
     * 
     */
    public List<CardDealState> getCardDealState() {
        if (cardDealState == null) {
            cardDealState = new ArrayList<CardDealState>();
        }
        return this.cardDealState;
    }

}
