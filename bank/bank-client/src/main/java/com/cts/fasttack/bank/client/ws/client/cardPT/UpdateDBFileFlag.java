
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="dbFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startLoad" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endLoad" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "dbFileName",
    "startLoad",
    "endLoad"
})
@XmlRootElement(name = "updateDBFileFlag")
public class UpdateDBFileFlag {

    @XmlElement(required = true, nillable = true)
    protected String dbFileName;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startLoad;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endLoad;

    /**
     * Gets the value of the dbFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbFileName() {
        return dbFileName;
    }

    /**
     * Sets the value of the dbFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbFileName(String value) {
        this.dbFileName = value;
    }

    /**
     * Gets the value of the startLoad property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartLoad() {
        return startLoad;
    }

    /**
     * Sets the value of the startLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartLoad(XMLGregorianCalendar value) {
        this.startLoad = value;
    }

    /**
     * Gets the value of the endLoad property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndLoad() {
        return endLoad;
    }

    /**
     * Sets the value of the endLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndLoad(XMLGregorianCalendar value) {
        this.endLoad = value;
    }

}
