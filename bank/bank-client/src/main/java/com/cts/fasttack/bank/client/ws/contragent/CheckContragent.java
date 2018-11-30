
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="middleNameUkr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docSr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docIssueDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="docIssPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="recordNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="residence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxAdmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finBlock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrPostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUCodeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddrKOATUUClassJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountryJur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addrPostcodeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddrCityTypeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCityJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionNameJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrictJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreetJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNoJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlatJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNoJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf1Home" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf2Cellur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf3Work" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf4Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf5EMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf6RegAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf7StaffDw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf8ContPer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k013" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k050" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k060" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k070" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k110" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrStateRegisterCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="placeOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isCardContragent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstNameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastNameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toboId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relManager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatcaQuest" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fatcaStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="externalSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "docEndDate",
    "recordNo",
    "dateOfBirth",
    "residence",
    "taxAdmCode",
    "gender",
    "finBlock",
    "addrKOATUUCode",
    "addrKOATUUClass",
    "addrCountry",
    "addrPostCode",
    "addrCityType",
    "addrCity",
    "addrRegion",
    "addrRegionName",
    "addrDistrict",
    "addrStreet",
    "addrHouseNo",
    "addrFlat",
    "addrBuildNo",
    "addrKOATUUCodeJur",
    "addrKOATUUClassJur",
    "addrCountryJur",
    "addrPostcodeJur",
    "addrCityTypeJur",
    "addrCityJur",
    "addrRegionJur",
    "addrRegionNameJur",
    "addrDistrictJur",
    "addrStreetJur",
    "addrHouseNoJur",
    "addrFlatJur",
    "addrBuildNoJur",
    "contInf1Home",
    "contInf2Cellur",
    "contInf3Work",
    "contInf4Fax",
    "contInf5EMail",
    "contInf6RegAddr",
    "contInf7StaffDw",
    "contInf8ContPer",
    "contPersType",
    "contPersName",
    "k013",
    "k050",
    "k060",
    "k070",
    "k110",
    "nrTaxId",
    "nrStateRegisterCountry",
    "taxRegDate",
    "placeOfBirth",
    "modifiedBy",
    "nationality",
    "docTypeId",
    "isCardContragent",
    "firstNameEng",
    "lastNameEng",
    "taxCategory",
    "additionalInfo1",
    "additionalInfo2",
    "toboId",
    "relManager",
    "fatcaQuest",
    "fatcaStatus",
    "externalSystem",
    "applicationType"
})
@XmlRootElement(name = "checkContragent")
public class CheckContragent {

    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElement(required = true)
    protected String taxId;
    @XmlElement(required = true)
    protected String lastNameUkr;
    @XmlElement(required = true)
    protected String firstNameUkr;
    @XmlElement(required = true)
    protected String middleNameUkr;
    @XmlElementRef(name = "docSr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> docSr;
    @XmlElement(required = true)
    protected String docNo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar docIssueDate;
    @XmlElement(required = true)
    protected String docIssPlace;
    @XmlElementRef(name = "docEndDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> docEndDate;
    @XmlElementRef(name = "recordNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recordNo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(required = true)
    protected String residence;
    @XmlElement(required = true)
    protected String taxAdmCode;
    @XmlElementRef(name = "gender", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gender;
    @XmlElementRef(name = "finBlock", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finBlock;
    @XmlElementRef(name = "addrKOATUUCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUCode;
    @XmlElementRef(name = "addrKOATUUClass", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUClass;
    @XmlElement(required = true)
    protected String addrCountry;
    @XmlElementRef(name = "addrPostCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostCode;
    @XmlElementRef(name = "addrCityType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityType;
    @XmlElementRef(name = "addrCity", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCity;
    @XmlElementRef(name = "addrRegion", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegion;
    @XmlElementRef(name = "addrRegionName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionName;
    @XmlElementRef(name = "addrDistrict", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrDistrict;
    @XmlElementRef(name = "addrStreet", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrStreet;
    @XmlElementRef(name = "addrHouseNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrHouseNo;
    @XmlElementRef(name = "addrFlat", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrFlat;
    @XmlElementRef(name = "addrBuildNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrBuildNo;
    @XmlElementRef(name = "addrKOATUUCodeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUCodeJur;
    @XmlElementRef(name = "AddrKOATUUClassJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUClassJur;
    @XmlElement(required = true)
    protected String addrCountryJur;
    @XmlElementRef(name = "addrPostcodeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostcodeJur;
    @XmlElementRef(name = "AddrCityTypeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityTypeJur;
    @XmlElementRef(name = "addrCityJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityJur;
    @XmlElementRef(name = "addrRegionJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionJur;
    @XmlElementRef(name = "addrRegionNameJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionNameJur;
    @XmlElementRef(name = "addrDistrictJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrDistrictJur;
    @XmlElementRef(name = "addrStreetJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrStreetJur;
    @XmlElementRef(name = "addrHouseNoJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrHouseNoJur;
    @XmlElementRef(name = "addrFlatJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrFlatJur;
    @XmlElementRef(name = "addrBuildNoJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrBuildNoJur;
    @XmlElementRef(name = "contInf1Home", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf1Home;
    @XmlElementRef(name = "contInf2Cellur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf2Cellur;
    @XmlElementRef(name = "contInf3Work", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf3Work;
    @XmlElementRef(name = "contInf4Fax", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf4Fax;
    @XmlElementRef(name = "contInf5EMail", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf5EMail;
    @XmlElementRef(name = "contInf6RegAddr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf6RegAddr;
    @XmlElementRef(name = "contInf7StaffDw", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf7StaffDw;
    @XmlElementRef(name = "contInf8ContPer", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf8ContPer;
    @XmlElementRef(name = "contPersType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersType;
    @XmlElementRef(name = "contPersName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersName;
    @XmlElementRef(name = "k013", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k013;
    @XmlElementRef(name = "k050", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k050;
    @XmlElementRef(name = "k060", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k060;
    @XmlElementRef(name = "k070", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k070;
    @XmlElementRef(name = "k110", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k110;
    @XmlElementRef(name = "nrTaxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nrTaxId;
    @XmlElementRef(name = "nrStateRegisterCountry", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nrStateRegisterCountry;
    @XmlElementRef(name = "taxRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxRegDate;
    @XmlElementRef(name = "placeOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> placeOfBirth;
    @XmlElementRef(name = "modifiedBy", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> modifiedBy;
    @XmlElementRef(name = "nationality", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nationality;
    @XmlElement(required = true)
    protected String docTypeId;
    @XmlElementRef(name = "isCardContragent", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardContragent;
    @XmlElementRef(name = "firstNameEng", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstNameEng;
    @XmlElementRef(name = "lastNameEng", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastNameEng;
    @XmlElementRef(name = "taxCategory", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCategory;
    @XmlElementRef(name = "additionalInfo1", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalInfo1;
    @XmlElementRef(name = "additionalInfo2", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalInfo2;
    @XmlElementRef(name = "toboId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> toboId;
    @XmlElementRef(name = "relManager", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relManager;
    @XmlElementRef(name = "fatcaQuest", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> fatcaQuest;
    @XmlElementRef(name = "fatcaStatus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> fatcaStatus;
    @XmlElement(required = true)
    protected String externalSystem;
    @XmlElementRef(name = "applicationType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationType;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentId(JAXBElement<String> value) {
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocSr() {
        return docSr;
    }

    /**
     * Sets the value of the docSr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocSr(JAXBElement<String> value) {
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
     * Gets the value of the docEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDocEndDate() {
        return docEndDate;
    }

    /**
     * Sets the value of the docEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDocEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.docEndDate = value;
    }

    /**
     * Gets the value of the recordNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecordNo() {
        return recordNo;
    }

    /**
     * Sets the value of the recordNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecordNo(JAXBElement<String> value) {
        this.recordNo = value;
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
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGender(JAXBElement<String> value) {
        this.gender = value;
    }

    /**
     * Gets the value of the finBlock property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinBlock() {
        return finBlock;
    }

    /**
     * Sets the value of the finBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinBlock(JAXBElement<String> value) {
        this.finBlock = value;
    }

    /**
     * Gets the value of the addrKOATUUCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrKOATUUCode() {
        return addrKOATUUCode;
    }

    /**
     * Sets the value of the addrKOATUUCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrKOATUUCode(JAXBElement<String> value) {
        this.addrKOATUUCode = value;
    }

    /**
     * Gets the value of the addrKOATUUClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrKOATUUClass() {
        return addrKOATUUClass;
    }

    /**
     * Sets the value of the addrKOATUUClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrKOATUUClass(JAXBElement<String> value) {
        this.addrKOATUUClass = value;
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
     * Gets the value of the addrPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrPostCode() {
        return addrPostCode;
    }

    /**
     * Sets the value of the addrPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrPostCode(JAXBElement<String> value) {
        this.addrPostCode = value;
    }

    /**
     * Gets the value of the addrCityType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCityType() {
        return addrCityType;
    }

    /**
     * Sets the value of the addrCityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCityType(JAXBElement<String> value) {
        this.addrCityType = value;
    }

    /**
     * Gets the value of the addrCity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCity() {
        return addrCity;
    }

    /**
     * Sets the value of the addrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCity(JAXBElement<String> value) {
        this.addrCity = value;
    }

    /**
     * Gets the value of the addrRegion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegion() {
        return addrRegion;
    }

    /**
     * Sets the value of the addrRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegion(JAXBElement<String> value) {
        this.addrRegion = value;
    }

    /**
     * Gets the value of the addrRegionName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionName() {
        return addrRegionName;
    }

    /**
     * Sets the value of the addrRegionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionName(JAXBElement<String> value) {
        this.addrRegionName = value;
    }

    /**
     * Gets the value of the addrDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrDistrict() {
        return addrDistrict;
    }

    /**
     * Sets the value of the addrDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrDistrict(JAXBElement<String> value) {
        this.addrDistrict = value;
    }

    /**
     * Gets the value of the addrStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrStreet() {
        return addrStreet;
    }

    /**
     * Sets the value of the addrStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrStreet(JAXBElement<String> value) {
        this.addrStreet = value;
    }

    /**
     * Gets the value of the addrHouseNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrHouseNo() {
        return addrHouseNo;
    }

    /**
     * Sets the value of the addrHouseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrHouseNo(JAXBElement<String> value) {
        this.addrHouseNo = value;
    }

    /**
     * Gets the value of the addrFlat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrFlat() {
        return addrFlat;
    }

    /**
     * Sets the value of the addrFlat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrFlat(JAXBElement<String> value) {
        this.addrFlat = value;
    }

    /**
     * Gets the value of the addrBuildNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrBuildNo() {
        return addrBuildNo;
    }

    /**
     * Sets the value of the addrBuildNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrBuildNo(JAXBElement<String> value) {
        this.addrBuildNo = value;
    }

    /**
     * Gets the value of the addrKOATUUCodeJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrKOATUUCodeJur() {
        return addrKOATUUCodeJur;
    }

    /**
     * Sets the value of the addrKOATUUCodeJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrKOATUUCodeJur(JAXBElement<String> value) {
        this.addrKOATUUCodeJur = value;
    }

    /**
     * Gets the value of the addrKOATUUClassJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrKOATUUClassJur() {
        return addrKOATUUClassJur;
    }

    /**
     * Sets the value of the addrKOATUUClassJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrKOATUUClassJur(JAXBElement<String> value) {
        this.addrKOATUUClassJur = value;
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrPostcodeJur() {
        return addrPostcodeJur;
    }

    /**
     * Sets the value of the addrPostcodeJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrPostcodeJur(JAXBElement<String> value) {
        this.addrPostcodeJur = value;
    }

    /**
     * Gets the value of the addrCityTypeJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCityTypeJur() {
        return addrCityTypeJur;
    }

    /**
     * Sets the value of the addrCityTypeJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCityTypeJur(JAXBElement<String> value) {
        this.addrCityTypeJur = value;
    }

    /**
     * Gets the value of the addrCityJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCityJur() {
        return addrCityJur;
    }

    /**
     * Sets the value of the addrCityJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCityJur(JAXBElement<String> value) {
        this.addrCityJur = value;
    }

    /**
     * Gets the value of the addrRegionJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionJur() {
        return addrRegionJur;
    }

    /**
     * Sets the value of the addrRegionJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionJur(JAXBElement<String> value) {
        this.addrRegionJur = value;
    }

    /**
     * Gets the value of the addrRegionNameJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionNameJur() {
        return addrRegionNameJur;
    }

    /**
     * Sets the value of the addrRegionNameJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionNameJur(JAXBElement<String> value) {
        this.addrRegionNameJur = value;
    }

    /**
     * Gets the value of the addrDistrictJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrDistrictJur() {
        return addrDistrictJur;
    }

    /**
     * Sets the value of the addrDistrictJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrDistrictJur(JAXBElement<String> value) {
        this.addrDistrictJur = value;
    }

    /**
     * Gets the value of the addrStreetJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrStreetJur() {
        return addrStreetJur;
    }

    /**
     * Sets the value of the addrStreetJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrStreetJur(JAXBElement<String> value) {
        this.addrStreetJur = value;
    }

    /**
     * Gets the value of the addrHouseNoJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrHouseNoJur() {
        return addrHouseNoJur;
    }

    /**
     * Sets the value of the addrHouseNoJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrHouseNoJur(JAXBElement<String> value) {
        this.addrHouseNoJur = value;
    }

    /**
     * Gets the value of the addrFlatJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrFlatJur() {
        return addrFlatJur;
    }

    /**
     * Sets the value of the addrFlatJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrFlatJur(JAXBElement<String> value) {
        this.addrFlatJur = value;
    }

    /**
     * Gets the value of the addrBuildNoJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrBuildNoJur() {
        return addrBuildNoJur;
    }

    /**
     * Sets the value of the addrBuildNoJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrBuildNoJur(JAXBElement<String> value) {
        this.addrBuildNoJur = value;
    }

    /**
     * Gets the value of the contInf1Home property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf1Home() {
        return contInf1Home;
    }

    /**
     * Sets the value of the contInf1Home property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf1Home(JAXBElement<String> value) {
        this.contInf1Home = value;
    }

    /**
     * Gets the value of the contInf2Cellur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf2Cellur() {
        return contInf2Cellur;
    }

    /**
     * Sets the value of the contInf2Cellur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf2Cellur(JAXBElement<String> value) {
        this.contInf2Cellur = value;
    }

    /**
     * Gets the value of the contInf3Work property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf3Work() {
        return contInf3Work;
    }

    /**
     * Sets the value of the contInf3Work property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf3Work(JAXBElement<String> value) {
        this.contInf3Work = value;
    }

    /**
     * Gets the value of the contInf4Fax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf4Fax() {
        return contInf4Fax;
    }

    /**
     * Sets the value of the contInf4Fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf4Fax(JAXBElement<String> value) {
        this.contInf4Fax = value;
    }

    /**
     * Gets the value of the contInf5EMail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf5EMail() {
        return contInf5EMail;
    }

    /**
     * Sets the value of the contInf5EMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf5EMail(JAXBElement<String> value) {
        this.contInf5EMail = value;
    }

    /**
     * Gets the value of the contInf6RegAddr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf6RegAddr() {
        return contInf6RegAddr;
    }

    /**
     * Sets the value of the contInf6RegAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf6RegAddr(JAXBElement<String> value) {
        this.contInf6RegAddr = value;
    }

    /**
     * Gets the value of the contInf7StaffDw property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf7StaffDw() {
        return contInf7StaffDw;
    }

    /**
     * Sets the value of the contInf7StaffDw property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf7StaffDw(JAXBElement<String> value) {
        this.contInf7StaffDw = value;
    }

    /**
     * Gets the value of the contInf8ContPer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf8ContPer() {
        return contInf8ContPer;
    }

    /**
     * Sets the value of the contInf8ContPer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf8ContPer(JAXBElement<String> value) {
        this.contInf8ContPer = value;
    }

    /**
     * Gets the value of the contPersType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContPersType() {
        return contPersType;
    }

    /**
     * Sets the value of the contPersType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContPersType(JAXBElement<String> value) {
        this.contPersType = value;
    }

    /**
     * Gets the value of the contPersName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContPersName() {
        return contPersName;
    }

    /**
     * Sets the value of the contPersName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContPersName(JAXBElement<String> value) {
        this.contPersName = value;
    }

    /**
     * Gets the value of the k013 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getK013() {
        return k013;
    }

    /**
     * Sets the value of the k013 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setK013(JAXBElement<String> value) {
        this.k013 = value;
    }

    /**
     * Gets the value of the k050 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getK050() {
        return k050;
    }

    /**
     * Sets the value of the k050 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setK050(JAXBElement<String> value) {
        this.k050 = value;
    }

    /**
     * Gets the value of the k060 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getK060() {
        return k060;
    }

    /**
     * Sets the value of the k060 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setK060(JAXBElement<String> value) {
        this.k060 = value;
    }

    /**
     * Gets the value of the k070 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getK070() {
        return k070;
    }

    /**
     * Sets the value of the k070 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setK070(JAXBElement<String> value) {
        this.k070 = value;
    }

    /**
     * Gets the value of the k110 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getK110() {
        return k110;
    }

    /**
     * Sets the value of the k110 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setK110(JAXBElement<String> value) {
        this.k110 = value;
    }

    /**
     * Gets the value of the nrTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNrTaxId() {
        return nrTaxId;
    }

    /**
     * Sets the value of the nrTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNrTaxId(JAXBElement<String> value) {
        this.nrTaxId = value;
    }

    /**
     * Gets the value of the nrStateRegisterCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNrStateRegisterCountry() {
        return nrStateRegisterCountry;
    }

    /**
     * Sets the value of the nrStateRegisterCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNrStateRegisterCountry(JAXBElement<String> value) {
        this.nrStateRegisterCountry = value;
    }

    /**
     * Gets the value of the taxRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxRegDate() {
        return taxRegDate;
    }

    /**
     * Sets the value of the taxRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxRegDate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxRegDate = value;
    }

    /**
     * Gets the value of the placeOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the value of the placeOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlaceOfBirth(JAXBElement<String> value) {
        this.placeOfBirth = value;
    }

    /**
     * Gets the value of the modifiedBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the value of the modifiedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setModifiedBy(JAXBElement<String> value) {
        this.modifiedBy = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNationality(JAXBElement<String> value) {
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsCardContragent() {
        return isCardContragent;
    }

    /**
     * Sets the value of the isCardContragent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsCardContragent(JAXBElement<String> value) {
        this.isCardContragent = value;
    }

    /**
     * Gets the value of the firstNameEng property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstNameEng() {
        return firstNameEng;
    }

    /**
     * Sets the value of the firstNameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstNameEng(JAXBElement<String> value) {
        this.firstNameEng = value;
    }

    /**
     * Gets the value of the lastNameEng property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastNameEng() {
        return lastNameEng;
    }

    /**
     * Sets the value of the lastNameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastNameEng(JAXBElement<String> value) {
        this.lastNameEng = value;
    }

    /**
     * Gets the value of the taxCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxCategory() {
        return taxCategory;
    }

    /**
     * Sets the value of the taxCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxCategory(JAXBElement<String> value) {
        this.taxCategory = value;
    }

    /**
     * Gets the value of the additionalInfo1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdditionalInfo1() {
        return additionalInfo1;
    }

    /**
     * Sets the value of the additionalInfo1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdditionalInfo1(JAXBElement<String> value) {
        this.additionalInfo1 = value;
    }

    /**
     * Gets the value of the additionalInfo2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdditionalInfo2() {
        return additionalInfo2;
    }

    /**
     * Sets the value of the additionalInfo2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdditionalInfo2(JAXBElement<String> value) {
        this.additionalInfo2 = value;
    }

    /**
     * Gets the value of the toboId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToboId() {
        return toboId;
    }

    /**
     * Sets the value of the toboId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToboId(JAXBElement<String> value) {
        this.toboId = value;
    }

    /**
     * Gets the value of the relManager property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelManager() {
        return relManager;
    }

    /**
     * Sets the value of the relManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelManager(JAXBElement<String> value) {
        this.relManager = value;
    }

    /**
     * Gets the value of the fatcaQuest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getFatcaQuest() {
        return fatcaQuest;
    }

    /**
     * Sets the value of the fatcaQuest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setFatcaQuest(JAXBElement<Integer> value) {
        this.fatcaQuest = value;
    }

    /**
     * Gets the value of the fatcaStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getFatcaStatus() {
        return fatcaStatus;
    }

    /**
     * Sets the value of the fatcaStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setFatcaStatus(JAXBElement<Integer> value) {
        this.fatcaStatus = value;
    }

    /**
     * Gets the value of the externalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalSystem() {
        return externalSystem;
    }

    /**
     * Sets the value of the externalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalSystem(String value) {
        this.externalSystem = value;
    }

    /**
     * Gets the value of the applicationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicationType() {
        return applicationType;
    }

    /**
     * Sets the value of the applicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicationType(JAXBElement<String> value) {
        this.applicationType = value;
    }

}
