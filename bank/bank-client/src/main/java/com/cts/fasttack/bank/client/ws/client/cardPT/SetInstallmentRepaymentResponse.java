
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setInstallmentRepaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setInstallmentRepaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setInstallmentRepaymentItem" type="{http://sab/}setInstallmentRepaymentItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setInstallmentRepaymentResponse", propOrder = {
    "setInstallmentRepaymentItem"
})
public class SetInstallmentRepaymentResponse {

    protected List<SetInstallmentRepaymentItem> setInstallmentRepaymentItem;

    /**
     * Gets the value of the setInstallmentRepaymentItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the setInstallmentRepaymentItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSetInstallmentRepaymentItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SetInstallmentRepaymentItem }
     * 
     * 
     */
    public List<SetInstallmentRepaymentItem> getSetInstallmentRepaymentItem() {
        if (setInstallmentRepaymentItem == null) {
            setInstallmentRepaymentItem = new ArrayList<SetInstallmentRepaymentItem>();
        }
        return this.setInstallmentRepaymentItem;
    }

}
