
package com.cts.fasttack.bank.client.ws.client;

import com.cts.fasttack.bank.client.config.WebServicesConfiguration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://sab/}isAuthenticated"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isAuthenticated"
})
@XmlRootElement(name = "authenticateResponse", namespace = WebServicesConfiguration.authenticateNamespace)
public class AuthenticateResponse {

    @XmlElementRef(name = "isAuthenticated", namespace = WebServicesConfiguration.authenticateNamespace, type = JAXBElement.class)
    protected JAXBElement<Boolean> isAuthenticated;

    /**
     * Gets the value of the isAuthenticated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public JAXBElement<Boolean> isIsAuthenticated() {
        return isAuthenticated;
    }

    /**
     * Sets the value of the isAuthenticated property.
     * 
     * @param isAuthenticated
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequestId(JAXBElement<Boolean> isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

}
