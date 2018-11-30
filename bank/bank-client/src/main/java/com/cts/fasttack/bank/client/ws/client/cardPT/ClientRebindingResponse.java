
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clientRebindingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clientRebindingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientRebindingItem" type="{http://sab/}clientRebindingItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientRebindingResponse", propOrder = {
    "clientRebindingItem"
})
public class ClientRebindingResponse {

    protected List<ClientRebindingItem> clientRebindingItem;

    /**
     * Gets the value of the clientRebindingItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clientRebindingItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClientRebindingItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClientRebindingItem }
     * 
     * 
     */
    public List<ClientRebindingItem> getClientRebindingItem() {
        if (clientRebindingItem == null) {
            clientRebindingItem = new ArrayList<ClientRebindingItem>();
        }
        return this.clientRebindingItem;
    }

}
