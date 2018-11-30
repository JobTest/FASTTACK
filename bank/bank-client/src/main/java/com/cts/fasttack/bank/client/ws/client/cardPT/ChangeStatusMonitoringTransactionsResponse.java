
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeStatusMonitoringTransactionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changeStatusMonitoringTransactionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeStatusMonitoringTransactionsItem" type="{http://sab/}changeStatusMonitoringTransactionsItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeStatusMonitoringTransactionsResponse", propOrder = {
    "changeStatusMonitoringTransactionsItem"
})
public class ChangeStatusMonitoringTransactionsResponse {

    protected List<ChangeStatusMonitoringTransactionsItem> changeStatusMonitoringTransactionsItem;

    /**
     * Gets the value of the changeStatusMonitoringTransactionsItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeStatusMonitoringTransactionsItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeStatusMonitoringTransactionsItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeStatusMonitoringTransactionsItem }
     * 
     * 
     */
    public List<ChangeStatusMonitoringTransactionsItem> getChangeStatusMonitoringTransactionsItem() {
        if (changeStatusMonitoringTransactionsItem == null) {
            changeStatusMonitoringTransactionsItem = new ArrayList<ChangeStatusMonitoringTransactionsItem>();
        }
        return this.changeStatusMonitoringTransactionsItem;
    }

}
