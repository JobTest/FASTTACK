
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.cts.fasttack.bank.client.ws.client.cardPT.CardDeal5;


/**
 * <p>Java class for getCardDealByCardNumberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDealByCardNumberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardDeal" type="{http://sab/}cardDeal5" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDealByCardNumberResponse", propOrder = {
    "cardDeal"
})
public class GetCardDealByCardNumberResponse {

    protected List<CardDeal5> cardDeal;

    /**
     * Gets the value of the cardDeal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardDeal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardDeal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardDeal5 }
     * 
     * 
     */
    public List<CardDeal5> getCardDeal() {
        if (cardDeal == null) {
            cardDeal = new ArrayList<CardDeal5>();
        }
        return this.cardDeal;
    }

}
