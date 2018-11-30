
package com.cts.fasttack.bank.client.ws.contragent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFinMonitorRiskByContragentIdResponce complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFinMonitorRiskByContragentIdResponce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getFinMonitorRiskByContragentIdItem" type="{http://sab/}getFinMonitorRiskByContragentIdItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFinMonitorRiskByContragentIdResponce", propOrder = {
    "getFinMonitorRiskByContragentIdItem"
})
public class GetFinMonitorRiskByContragentIdResponce {

    @XmlElement(nillable = true)
    protected List<GetFinMonitorRiskByContragentIdItem> getFinMonitorRiskByContragentIdItem;

    /**
     * Gets the value of the getFinMonitorRiskByContragentIdItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getFinMonitorRiskByContragentIdItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFinMonitorRiskByContragentIdItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetFinMonitorRiskByContragentIdItem }
     * 
     * 
     */
    public List<GetFinMonitorRiskByContragentIdItem> getGetFinMonitorRiskByContragentIdItem() {
        if (getFinMonitorRiskByContragentIdItem == null) {
            getFinMonitorRiskByContragentIdItem = new ArrayList<GetFinMonitorRiskByContragentIdItem>();
        }
        return this.getFinMonitorRiskByContragentIdItem;
    }

}
