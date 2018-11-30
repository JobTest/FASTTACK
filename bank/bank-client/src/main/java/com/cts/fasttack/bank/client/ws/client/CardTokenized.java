
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
 *         &lt;element ref="{http://sab/}conversationId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRequestorId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRefId"/&gt;
 *         &lt;element ref="{http://sab/}status"/&gt;
 *         &lt;element ref="{http://sab/}panInternalId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID"/&gt;
 *         &lt;element ref="{http://sab/}pan"/&gt;
 *         &lt;element ref="{http://sab/}expiryMonth"/&gt;
 *         &lt;element ref="{http://sab/}expiryYear"/&gt;
 *         &lt;element ref="{http://sab/}token"/&gt;
 *         &lt;element ref="{http://sab/}tokenExpiryMonth"/&gt;
 *         &lt;element ref="{http://sab/}tokenExpiryYear"/&gt;
 *         &lt;element ref="{http://sab/}tokenActivationDate"/&gt;
 *         &lt;element ref="{http://sab/}ips"/&gt;
 *         &lt;element ref="{http://sab/}panSource"/&gt;
 *         &lt;element ref="{http://sab/}paymentAppInstId"/&gt;
 *         &lt;element ref="{http://sab/}deviceType"/&gt;
 *         &lt;element ref="{http://sab/}storageTechnology"/&gt;
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
    "conversationId",
    "tokenRequestorId",
    "tokenRefId",
    "status",
    "panInternalId",
    "panInternalGUID",
    "pan",
    "expiryMonth",
    "expiryYear",
    "token",
    "tokenExpiryMonth",
    "tokenExpiryYear",
    "tokenActivationDate",
    "ips",
    "panSource",
    "paymentAppInstId",
    "deviceType",
    "storageTechnology",
    "deviceName"
})
@XmlRootElement(name = "cardTokenized", namespace = "http://sab/")
public class CardTokenized {

    @XmlElement(required = true, namespace = "http://sab/")
    protected String requestId;

    @XmlElement(required = true, namespace = "http://sab/")
    protected String conversationId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRequestorId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRefId;

    @XmlElement(namespace = "http://sab/")
    protected String status;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalId;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalGUID;

    @XmlElement(required = true, namespace = "http://sab/")
    protected String pan;

    @XmlElement(required = true, namespace = "http://sab/")
    protected String expiryMonth;

    @XmlElement(required = true, namespace = "http://sab/")
    protected String expiryYear;

    @XmlElement(namespace = "http://sab/")
    protected String token;

    @XmlElement(namespace = "http://sab/")
    protected String tokenExpiryMonth;

    @XmlElement(namespace = "http://sab/")
    protected String tokenExpiryYear;

    @XmlElement(namespace = "http://sab/")
    protected String tokenActivationDate;

    @XmlElement(required = true, namespace = "http://sab/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ips;

    @XmlElement(required = true, namespace = "http://sab/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String panSource;

    @XmlElement(namespace = "http://sab/")
    protected String paymentAppInstId;

    @XmlElement(namespace = "http://sab/")
    protected String deviceType;

    @XmlElement(namespace = "http://sab/")
    protected String storageTechnology;

    @XmlElement(namespace = "http://sab/")
    protected String deviceName;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
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

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getTokenActivationDate() {
        return tokenActivationDate;
    }

    public void setTokenActivationDate(String tokenActivationDate) {
        this.tokenActivationDate = tokenActivationDate;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getPaymentAppInstId() {
        return paymentAppInstId;
    }

    public void setPaymentAppInstId(String paymentAppInstId) {
        this.paymentAppInstId = paymentAppInstId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
