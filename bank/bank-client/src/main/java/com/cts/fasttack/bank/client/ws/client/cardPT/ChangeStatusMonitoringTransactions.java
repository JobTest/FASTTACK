
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="statusContragent" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cardIdList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="system" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="process" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "contragentId",
    "statusContragent",
    "cardIdList",
    "system",
    "process",
    "user"
})
@XmlRootElement(name = "changeStatusMonitoringTransactions")
public class ChangeStatusMonitoringTransactions {

    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long contragentId;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long statusContragent;
    @XmlElement(required = true, nillable = true)
    protected String cardIdList;
    @XmlElement(required = true, nillable = true)
    protected String system;
    @XmlElement(required = true, nillable = true)
    protected String process;
    @XmlElement(required = true, nillable = true)
    protected String user;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContragentId(Long value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the statusContragent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStatusContragent() {
        return statusContragent;
    }

    /**
     * Sets the value of the statusContragent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStatusContragent(Long value) {
        this.statusContragent = value;
    }

    /**
     * Gets the value of the cardIdList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardIdList() {
        return cardIdList;
    }

    /**
     * Sets the value of the cardIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardIdList(String value) {
        this.cardIdList = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcess(String value) {
        this.process = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

}
