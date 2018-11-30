
package com.cts.fasttack.bank.client.ws.client;

import com.cts.fasttack.bank.client.config.WebServicesConfiguration;

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
 *         &lt;element ref="{http://sab/}user"/&gt;
 *         &lt;element ref="{http://sab/}password"/&gt;
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
    "user",
    "password"
})
@XmlRootElement(name = "authenticate", namespace = WebServicesConfiguration.authenticateNamespace)
public class Authenticate {

    @XmlElement(required = true, namespace = WebServicesConfiguration.authenticateNamespace)
    protected String user;

    @XmlElement(required = true, namespace = WebServicesConfiguration.authenticateNamespace)
    protected String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
