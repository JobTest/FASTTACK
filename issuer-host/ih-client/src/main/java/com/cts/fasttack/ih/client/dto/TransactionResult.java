package com.cts.fasttack.ih.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{}TranCode"/>
 *         &lt;element ref="{}ApprovalCode" minOccurs="0"/>
 *         &lt;element ref="{}Rrn" minOccurs="0"/>
 *         &lt;element ref="{}Comment" minOccurs="0"/>
 *         &lt;element ref="{}CVResult" minOccurs="0"/>
 *         &lt;element ref="{}HostCode" minOccurs="0"/>
 *         &lt;element ref="{}CardNum" minOccurs="0"/>
 *         &lt;element ref="{}CardNumMasked" minOccurs="0"/>
 *         &lt;element ref="{}ExtData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Recurrent" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tranCode",
    "approvalCode",
    "rrn",
    "comment",
    "cvResult",
    "hostCode",
    "cardNum",
    "cardNumMasked",
    "extData",
    "recurrent"
})
@XmlRootElement(name = "TransactionResult")
public class TransactionResult {

    @XmlElement(name = "TranCode", required = true)
    protected String tranCode;
    @XmlElement(name = "ApprovalCode")
    protected String approvalCode;
    @XmlElement(name = "Rrn")
    protected String rrn;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "CVResult")
    protected String cvResult;
    @XmlElement(name = "HostCode")
    protected String hostCode;
    @XmlElement(name = "CardNum")
    protected Long cardNum;
    @XmlElement(name = "CardNumMasked")
    protected String cardNumMasked;
    @XmlElement(name = "ExtData")
    protected List<ExtData> extData;
    @XmlElement(name = "Recurrent")
    protected Boolean recurrent;
    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

    /**
     * Gets the value of the tranCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranCode() {
        return tranCode;
    }

    /**
     * Sets the value of the tranCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranCode(String value) {
        this.tranCode = value;
    }

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the rrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRrn() {
        return rrn;
    }

    /**
     * Sets the value of the rrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRrn(String value) {
        this.rrn = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the cvResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVResult() {
        return cvResult;
    }

    /**
     * Sets the value of the cvResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVResult(String value) {
        this.cvResult = value;
    }

    /**
     * Gets the value of the hostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostCode() {
        return hostCode;
    }

    /**
     * Sets the value of the hostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostCode(String value) {
        this.hostCode = value;
    }

    /**
     * Gets the value of the cardNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCardNum() {
        return cardNum;
    }

    /**
     * Sets the value of the cardNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCardNum(Long value) {
        this.cardNum = value;
    }

    /**
     * Gets the value of the cardNumMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumMasked() {
        return cardNumMasked;
    }

    /**
     * Sets the value of the cardNumMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumMasked(String value) {
        this.cardNumMasked = value;
    }

    /**
     * Gets the value of the extData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtData }
     * 
     * 
     */
    public List<ExtData> getExtData() {
        if (extData == null) {
            extData = new ArrayList<ExtData>();
        }
        return this.extData;
    }

    /**
     * Gets the value of the recurrent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecurrent() {
        return recurrent;
    }

    /**
     * Sets the value of the recurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecurrent(Boolean value) {
        this.recurrent = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
