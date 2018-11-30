
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="i_fullname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iFullname"
})
@XmlRootElement(name = "getProjectInfoByAgrtplname")
public class GetProjectInfoByAgrtplname {

    @XmlElement(name = "i_fullname", required = true, nillable = true)
    protected String iFullname;

    /**
     * Gets the value of the iFullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFullname() {
        return iFullname;
    }

    /**
     * Sets the value of the iFullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFullname(String value) {
        this.iFullname = value;
    }

}
