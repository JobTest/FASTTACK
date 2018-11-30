
package com.cts.fasttack.bank.client.ws.client;

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
 *         &lt;element ref="{http://sab/}requestId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRefId"/&gt;
 *         &lt;element ref="{http://sab/}tokenRequestorId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalId"/&gt;
 *         &lt;element ref="{http://sab/}panInternalGUID"/&gt;
 *         &lt;element ref="{http://sab/}notificationType"/&gt;
 *         &lt;element ref="{http://sab/}lastFourOfPAN"/&gt;
 *         &lt;element ref="{http://sab/}reminderPeriod"/&gt;
 *         &lt;element ref="{http://sab/}customerPhone"/&gt;
 *         &lt;element ref="{http://sab/}deviceType"/&gt;
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
    "panInternalId",
    "panInternalGUID",
    "notificationType",
    "lastFourOfPAN",
    "reminderPeriod",
    "customerPhone",
    "deviceType"
})
@XmlRootElement(name = "sendNotificationToCustomer", namespace = "http://sab/")
public class SendNotificationToCustomer {

    @XmlElement(required = true, namespace = "http://sab/")
    protected String requestId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRequestorId;

    @XmlElement(namespace = "http://sab/")
    protected String tokenRefId;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalId;

    @XmlElement(namespace = "http://sab/")
    protected String panInternalGUID;

    @XmlElement(namespace = "http://sab/")
    protected String notificationType;

    @XmlElement(namespace = "http://sab/")
    protected String lastFourOfPAN;

    @XmlElement(namespace = "http://sab/")
    protected String reminderPeriod;

    @XmlElement(namespace = "http://sab/")
    protected String customerPhone;

    @XmlElement(namespace = "http://sab/")
    protected String deviceType;

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

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getLastFourOfPAN() {
        return lastFourOfPAN;
    }

    public void setLastFourOfPAN(String lastFourOfPAN) {
        this.lastFourOfPAN = lastFourOfPAN;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
