
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for annulateSalaryCardResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annulateSalaryCardResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annulateSalaryCardItem" type="{http://sab/}annulateSalaryCardItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annulateSalaryCardResponse", propOrder = {
    "annulateSalaryCardItem"
})
public class AnnulateSalaryCardResponse {

    protected List<AnnulateSalaryCardItem> annulateSalaryCardItem;

    /**
     * Gets the value of the annulateSalaryCardItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annulateSalaryCardItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnulateSalaryCardItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnnulateSalaryCardItem }
     * 
     * 
     */
    public List<AnnulateSalaryCardItem> getAnnulateSalaryCardItem() {
        if (annulateSalaryCardItem == null) {
            annulateSalaryCardItem = new ArrayList<AnnulateSalaryCardItem>();
        }
        return this.annulateSalaryCardItem;
    }

}
