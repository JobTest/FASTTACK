
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="middleNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docSr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docIssueDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="docIssPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="residence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxAdmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrPostcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrRegion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrDistrict" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrHouseNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrFlat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrBuildNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrCountryJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrPostcodeJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrCityJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrRegionJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrDistrictJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrStreetJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrHouseNoJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrFlatJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrBuildNoJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf1Home" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf2Cellur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf3Work" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf4Fax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf5Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf6Regaddrhf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf7Staffdwp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contInf8Contperph" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contPersType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contPersName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="k060" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="k070" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nrTaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxRegDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="placeOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardProduct" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="identification" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isCardContragent" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "taxId",
    "lastNameUkr",
    "firstNameUkr",
    "middleNameUkr",
    "docSr",
    "docNo",
    "docIssueDate",
    "docIssPlace",
    "dateOfBirth",
    "residence",
    "taxAdmCode",
    "addrCountry",
    "addrPostcode",
    "addrCity",
    "addrRegion",
    "addrDistrict",
    "addrStreet",
    "addrHouseNo",
    "addrFlat",
    "addrBuildNo",
    "addrCountryJur",
    "addrPostcodeJur",
    "addrCityJur",
    "addrRegionJur",
    "addrDistrictJur",
    "addrStreetJur",
    "addrHouseNoJur",
    "addrFlatJur",
    "addrBuildNoJur",
    "contInf1Home",
    "contInf2Cellur",
    "contInf3Work",
    "contInf4Fax",
    "contInf5Email",
    "contInf6Regaddrhf",
    "contInf7Staffdwp",
    "contInf8Contperph",
    "contPersType",
    "contPersName",
    "k060",
    "k070",
    "nrTaxId",
    "taxRegDate",
    "placeOfBirth",
    "cardProduct",
    "identification",
    "modifiedBy",
    "nationality",
    "docTypeId",
    "isCardContragent"
})
@XmlRootElement(name = "registerCardContragent")
public class RegisterCardContragent {

    @XmlElement(required = true, nillable = true)
    protected String contragentId;
    @XmlElement(required = true, nillable = true)
    protected String taxId;
    @XmlElement(required = true, nillable = true)
    protected String lastNameUkr;
    @XmlElement(required = true, nillable = true)
    protected String firstNameUkr;
    @XmlElement(required = true, nillable = true)
    protected String middleNameUkr;
    @XmlElement(required = true, nillable = true)
    protected String docSr;
    @XmlElement(required = true, nillable = true)
    protected String docNo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar docIssueDate;
    @XmlElement(required = true, nillable = true)
    protected String docIssPlace;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(required = true, nillable = true)
    protected String residence;
    @XmlElement(required = true, nillable = true)
    protected String taxAdmCode;
    @XmlElement(required = true, nillable = true)
    protected String addrCountry;
    @XmlElement(required = true, nillable = true)
    protected String addrPostcode;
    @XmlElement(required = true, nillable = true)
    protected String addrCity;
    @XmlElement(required = true, nillable = true)
    protected String addrRegion;
    @XmlElement(required = true, nillable = true)
    protected String addrDistrict;
    @XmlElement(required = true, nillable = true)
    protected String addrStreet;
    @XmlElement(required = true, nillable = true)
    protected String addrHouseNo;
    @XmlElement(required = true, nillable = true)
    protected String addrFlat;
    @XmlElement(required = true, nillable = true)
    protected String addrBuildNo;
    @XmlElement(required = true, nillable = true)
    protected String addrCountryJur;
    @XmlElement(required = true, nillable = true)
    protected String addrPostcodeJur;
    @XmlElement(required = true, nillable = true)
    protected String addrCityJur;
    @XmlElement(required = true, nillable = true)
    protected String addrRegionJur;
    @XmlElement(required = true, nillable = true)
    protected String addrDistrictJur;
    @XmlElement(required = true, nillable = true)
    protected String addrStreetJur;
    @XmlElement(required = true, nillable = true)
    protected String addrHouseNoJur;
    @XmlElement(required = true, nillable = true)
    protected String addrFlatJur;
    @XmlElement(required = true, nillable = true)
    protected String addrBuildNoJur;
    @XmlElement(required = true, nillable = true)
    protected String contInf1Home;
    @XmlElement(required = true, nillable = true)
    protected String contInf2Cellur;
    @XmlElement(required = true, nillable = true)
    protected String contInf3Work;
    @XmlElement(required = true, nillable = true)
    protected String contInf4Fax;
    @XmlElement(required = true, nillable = true)
    protected String contInf5Email;
    @XmlElement(required = true, nillable = true)
    protected String contInf6Regaddrhf;
    @XmlElement(required = true, nillable = true)
    protected String contInf7Staffdwp;
    @XmlElement(required = true, nillable = true)
    protected String contInf8Contperph;
    @XmlElement(required = true, nillable = true)
    protected String contPersType;
    @XmlElement(required = true, nillable = true)
    protected String contPersName;
    @XmlElement(required = true, nillable = true)
    protected String k060;
    @XmlElement(required = true, nillable = true)
    protected String k070;
    @XmlElement(required = true, nillable = true)
    protected String nrTaxId;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar taxRegDate;
    @XmlElement(required = true, nillable = true)
    protected String placeOfBirth;
    @XmlElement(required = true, nillable = true)
    protected String cardProduct;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer identification;
    @XmlElement(required = true, nillable = true)
    protected String modifiedBy;
    @XmlElement(required = true, nillable = true)
    protected String nationality;
    @XmlElement(required = true, nillable = true)
    protected String docTypeId;
    @XmlElement(required = true, nillable = true)
    protected String isCardContragent;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContragentId(String value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the taxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxId(String value) {
        this.taxId = value;
    }

    /**
     * Gets the value of the lastNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNameUkr() {
        return lastNameUkr;
    }

    /**
     * Sets the value of the lastNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNameUkr(String value) {
        this.lastNameUkr = value;
    }

    /**
     * Gets the value of the firstNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstNameUkr() {
        return firstNameUkr;
    }

    /**
     * Sets the value of the firstNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstNameUkr(String value) {
        this.firstNameUkr = value;
    }

    /**
     * Gets the value of the middleNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleNameUkr() {
        return middleNameUkr;
    }

    /**
     * Sets the value of the middleNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleNameUkr(String value) {
        this.middleNameUkr = value;
    }

    /**
     * Gets the value of the docSr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocSr() {
        return docSr;
    }

    /**
     * Sets the value of the docSr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocSr(String value) {
        this.docSr = value;
    }

    /**
     * Gets the value of the docNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
    }

    /**
     * Gets the value of the docIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocIssueDate() {
        return docIssueDate;
    }

    /**
     * Sets the value of the docIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocIssueDate(XMLGregorianCalendar value) {
        this.docIssueDate = value;
    }

    /**
     * Gets the value of the docIssPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssPlace() {
        return docIssPlace;
    }

    /**
     * Sets the value of the docIssPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssPlace(String value) {
        this.docIssPlace = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the residence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Sets the value of the residence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidence(String value) {
        this.residence = value;
    }

    /**
     * Gets the value of the taxAdmCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxAdmCode() {
        return taxAdmCode;
    }

    /**
     * Sets the value of the taxAdmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxAdmCode(String value) {
        this.taxAdmCode = value;
    }

    /**
     * Gets the value of the addrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCountry() {
        return addrCountry;
    }

    /**
     * Sets the value of the addrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCountry(String value) {
        this.addrCountry = value;
    }

    /**
     * Gets the value of the addrPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrPostcode() {
        return addrPostcode;
    }

    /**
     * Sets the value of the addrPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrPostcode(String value) {
        this.addrPostcode = value;
    }

    /**
     * Gets the value of the addrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCity() {
        return addrCity;
    }

    /**
     * Sets the value of the addrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCity(String value) {
        this.addrCity = value;
    }

    /**
     * Gets the value of the addrRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrRegion() {
        return addrRegion;
    }

    /**
     * Sets the value of the addrRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrRegion(String value) {
        this.addrRegion = value;
    }

    /**
     * Gets the value of the addrDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrDistrict() {
        return addrDistrict;
    }

    /**
     * Sets the value of the addrDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrDistrict(String value) {
        this.addrDistrict = value;
    }

    /**
     * Gets the value of the addrStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrStreet() {
        return addrStreet;
    }

    /**
     * Sets the value of the addrStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrStreet(String value) {
        this.addrStreet = value;
    }

    /**
     * Gets the value of the addrHouseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrHouseNo() {
        return addrHouseNo;
    }

    /**
     * Sets the value of the addrHouseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrHouseNo(String value) {
        this.addrHouseNo = value;
    }

    /**
     * Gets the value of the addrFlat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrFlat() {
        return addrFlat;
    }

    /**
     * Sets the value of the addrFlat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrFlat(String value) {
        this.addrFlat = value;
    }

    /**
     * Gets the value of the addrBuildNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrBuildNo() {
        return addrBuildNo;
    }

    /**
     * Sets the value of the addrBuildNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrBuildNo(String value) {
        this.addrBuildNo = value;
    }

    /**
     * Gets the value of the addrCountryJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCountryJur() {
        return addrCountryJur;
    }

    /**
     * Sets the value of the addrCountryJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCountryJur(String value) {
        this.addrCountryJur = value;
    }

    /**
     * Gets the value of the addrPostcodeJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrPostcodeJur() {
        return addrPostcodeJur;
    }

    /**
     * Sets the value of the addrPostcodeJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrPostcodeJur(String value) {
        this.addrPostcodeJur = value;
    }

    /**
     * Gets the value of the addrCityJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCityJur() {
        return addrCityJur;
    }

    /**
     * Sets the value of the addrCityJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCityJur(String value) {
        this.addrCityJur = value;
    }

    /**
     * Gets the value of the addrRegionJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrRegionJur() {
        return addrRegionJur;
    }

    /**
     * Sets the value of the addrRegionJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrRegionJur(String value) {
        this.addrRegionJur = value;
    }

    /**
     * Gets the value of the addrDistrictJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrDistrictJur() {
        return addrDistrictJur;
    }

    /**
     * Sets the value of the addrDistrictJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrDistrictJur(String value) {
        this.addrDistrictJur = value;
    }

    /**
     * Gets the value of the addrStreetJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrStreetJur() {
        return addrStreetJur;
    }

    /**
     * Sets the value of the addrStreetJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrStreetJur(String value) {
        this.addrStreetJur = value;
    }

    /**
     * Gets the value of the addrHouseNoJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrHouseNoJur() {
        return addrHouseNoJur;
    }

    /**
     * Sets the value of the addrHouseNoJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrHouseNoJur(String value) {
        this.addrHouseNoJur = value;
    }

    /**
     * Gets the value of the addrFlatJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrFlatJur() {
        return addrFlatJur;
    }

    /**
     * Sets the value of the addrFlatJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrFlatJur(String value) {
        this.addrFlatJur = value;
    }

    /**
     * Gets the value of the addrBuildNoJur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrBuildNoJur() {
        return addrBuildNoJur;
    }

    /**
     * Sets the value of the addrBuildNoJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrBuildNoJur(String value) {
        this.addrBuildNoJur = value;
    }

    /**
     * Gets the value of the contInf1Home property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf1Home() {
        return contInf1Home;
    }

    /**
     * Sets the value of the contInf1Home property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf1Home(String value) {
        this.contInf1Home = value;
    }

    /**
     * Gets the value of the contInf2Cellur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf2Cellur() {
        return contInf2Cellur;
    }

    /**
     * Sets the value of the contInf2Cellur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf2Cellur(String value) {
        this.contInf2Cellur = value;
    }

    /**
     * Gets the value of the contInf3Work property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf3Work() {
        return contInf3Work;
    }

    /**
     * Sets the value of the contInf3Work property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf3Work(String value) {
        this.contInf3Work = value;
    }

    /**
     * Gets the value of the contInf4Fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf4Fax() {
        return contInf4Fax;
    }

    /**
     * Sets the value of the contInf4Fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf4Fax(String value) {
        this.contInf4Fax = value;
    }

    /**
     * Gets the value of the contInf5Email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf5Email() {
        return contInf5Email;
    }

    /**
     * Sets the value of the contInf5Email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf5Email(String value) {
        this.contInf5Email = value;
    }

    /**
     * Gets the value of the contInf6Regaddrhf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf6Regaddrhf() {
        return contInf6Regaddrhf;
    }

    /**
     * Sets the value of the contInf6Regaddrhf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf6Regaddrhf(String value) {
        this.contInf6Regaddrhf = value;
    }

    /**
     * Gets the value of the contInf7Staffdwp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf7Staffdwp() {
        return contInf7Staffdwp;
    }

    /**
     * Sets the value of the contInf7Staffdwp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf7Staffdwp(String value) {
        this.contInf7Staffdwp = value;
    }

    /**
     * Gets the value of the contInf8Contperph property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContInf8Contperph() {
        return contInf8Contperph;
    }

    /**
     * Sets the value of the contInf8Contperph property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContInf8Contperph(String value) {
        this.contInf8Contperph = value;
    }

    /**
     * Gets the value of the contPersType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContPersType() {
        return contPersType;
    }

    /**
     * Sets the value of the contPersType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContPersType(String value) {
        this.contPersType = value;
    }

    /**
     * Gets the value of the contPersName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContPersName() {
        return contPersName;
    }

    /**
     * Sets the value of the contPersName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContPersName(String value) {
        this.contPersName = value;
    }

    /**
     * Gets the value of the k060 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getK060() {
        return k060;
    }

    /**
     * Sets the value of the k060 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setK060(String value) {
        this.k060 = value;
    }

    /**
     * Gets the value of the k070 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getK070() {
        return k070;
    }

    /**
     * Sets the value of the k070 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setK070(String value) {
        this.k070 = value;
    }

    /**
     * Gets the value of the nrTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrTaxId() {
        return nrTaxId;
    }

    /**
     * Sets the value of the nrTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrTaxId(String value) {
        this.nrTaxId = value;
    }

    /**
     * Gets the value of the taxRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxRegDate() {
        return taxRegDate;
    }

    /**
     * Sets the value of the taxRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxRegDate(XMLGregorianCalendar value) {
        this.taxRegDate = value;
    }

    /**
     * Gets the value of the placeOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the value of the placeOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfBirth(String value) {
        this.placeOfBirth = value;
    }

    /**
     * Gets the value of the cardProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardProduct() {
        return cardProduct;
    }

    /**
     * Sets the value of the cardProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardProduct(String value) {
        this.cardProduct = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdentification(Integer value) {
        this.identification = value;
    }

    /**
     * Gets the value of the modifiedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the value of the modifiedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifiedBy(String value) {
        this.modifiedBy = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the docTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypeId() {
        return docTypeId;
    }

    /**
     * Sets the value of the docTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypeId(String value) {
        this.docTypeId = value;
    }

    /**
     * Gets the value of the isCardContragent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCardContragent() {
        return isCardContragent;
    }

    /**
     * Sets the value of the isCardContragent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCardContragent(String value) {
        this.isCardContragent = value;
    }

}
