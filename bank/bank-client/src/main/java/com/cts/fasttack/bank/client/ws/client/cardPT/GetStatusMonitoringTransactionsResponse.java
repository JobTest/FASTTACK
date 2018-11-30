
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStatusMonitoringTransactionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStatusMonitoringTransactionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getStatusMonitoringTransactionsItem" type="{http://sab/}getStatusMonitoringTransactionsItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatusMonitoringTransactionsResponse", propOrder = {
    "getStatusMonitoringTransactionsItem"
})
public class GetStatusMonitoringTransactionsResponse {

    protected List<GetStatusMonitoringTransactionsItem> getStatusMonitoringTransactionsItem;

    /**
     * Gets the value of the getStatusMonitoringTransactionsItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getStatusMonitoringTransactionsItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetStatusMonitoringTransactionsItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStatusMonitoringTransactionsItem }
     * 
     * 
     */
    public List<GetStatusMonitoringTransactionsItem> getGetStatusMonitoringTransactionsItem() {
        if (getStatusMonitoringTransactionsItem == null) {
            getStatusMonitoringTransactionsItem = new ArrayList<GetStatusMonitoringTransactionsItem>();
        }
        return this.getStatusMonitoringTransactionsItem;
    }

}
