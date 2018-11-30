
package com.cts.fasttack.bank.client.ws.client;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://sab/}requestId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRefId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRequestorId"/&gt;
 *         &lt;element ref="{http://sab/}messageReasonCode"/&gt;
 *         &lt;element ref="{http://sab/}status"/&gt;
 *         &lt;element ref="{http://sab/}tokenExpiryMonth"/&gt;
 *         &lt;element ref="{http://sab/}tokenExpiryYear"/&gt;
 *         &lt;element ref="{http://sab/}ips"/&gt;
 *         &lt;element ref="{http://sab/}panInternalId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID"/&gt;
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
    "requestId",
    "tokenRefId",
    "tokenRequestorId",
    "messageReasonCode",
    "status",
    "tokenExpiryMonth",
    "tokenExpiryYear",
    "ips",
    "panInternalId",
    "panInternalGUID"
})
@XmlRootElement(name = "tokenStatusUpdated", namespace = "http://sab/")
public class TokenStatusUpdated {

    @XmlElement(required = true, namespace = "http://sab/")
    protected String requestId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRequestorId;

    @XmlElement(namespace = "http://sab/")
    protected String messageReasonCode;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRefId;

    @XmlElement(namespace = "http://sab/")
    protected String status;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenExpiryMonth;

    @XmlElement(namespace = "http://sab/")
    protected String tokenExpiryYear;

    @XmlElement(required = true, namespace = "http://sab/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ips;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalGUID;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(String messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getTokenExpiryMonth() {
        return tokenExpiryMonth;
    }

    public void setTokenExpiryMonth(String tokenExpiryMonth) {
        this.tokenExpiryMonth = tokenExpiryMonth;
    }

    public String getTokenExpiryYear() {
        return tokenExpiryYear;
    }

    public void setTokenExpiryYear(String tokenExpiryYear) {
        this.tokenExpiryYear = tokenExpiryYear;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }
}
