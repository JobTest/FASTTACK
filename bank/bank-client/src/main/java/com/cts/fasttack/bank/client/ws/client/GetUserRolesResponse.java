
package com.cts.fasttack.bank.client.ws.client;

import com.cts.fasttack.bank.client.config.WebServicesConfiguration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{http://sab/}userRoles"/&gt;
 *         &lt;element ref="{http://sab/}traidPointType"/&gt;
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
    "userRoles",
    "traidPointType"
})
@XmlRootElement(name = "getUserRolesResponse", namespace = WebServicesConfiguration.authenticateNamespace)
public class GetUserRolesResponse {

    @XmlElementRefs({
            @XmlElementRef(name = "userRoles", namespace = WebServicesConfiguration.authenticateNamespace, type = JAXBElement.class)
    })
    protected List<JAXBElement<String>> userRoles = new ArrayList<>();

    @XmlElementRef(name = "traidPointType", namespace = WebServicesConfiguration.authenticateNamespace, type = JAXBElement.class)
    protected JAXBElement<String> traidPointType;

    /**
     * Gets the value of the userRoles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<JAXBElement<String>> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the value of the userRoles property.
     * 
     * @param userRoles
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRoles(List<JAXBElement<String>> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * Gets the value of the traidPointType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public JAXBElement<String> getTraidPointType() {
        return traidPointType;
    }

    /**
     * Sets the value of the traidPointType property.
     *
     * @param traidPointType
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTraidPointType(JAXBElement<String> traidPointType) {
        this.traidPointType = traidPointType;
    }
}
