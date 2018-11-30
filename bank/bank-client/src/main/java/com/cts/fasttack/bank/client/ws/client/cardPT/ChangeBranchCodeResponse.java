
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeBranchCodeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changeBranchCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeBranchCodeItem" type="{http://sab/}changeBranchCodeItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeBranchCodeResponse", propOrder = {
    "changeBranchCodeItem"
})
public class ChangeBranchCodeResponse {

    protected List<ChangeBranchCodeItem> changeBranchCodeItem;

    /**
     * Gets the value of the changeBranchCodeItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeBranchCodeItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeBranchCodeItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeBranchCodeItem }
     * 
     * 
     */
    public List<ChangeBranchCodeItem> getChangeBranchCodeItem() {
        if (changeBranchCodeItem == null) {
            changeBranchCodeItem = new ArrayList<ChangeBranchCodeItem>();
        }
        return this.changeBranchCodeItem;
    }

}
