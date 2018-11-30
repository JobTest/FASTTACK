
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="middleNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docSr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docIssueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="docIssPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="recordNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="residence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrStateRegisterCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxAdmCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountryJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrPostcodeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="contInf5Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf6Regaddrhf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf7Staffdwp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf8Contperph" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k060" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k070" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="placeOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identification" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="modifiedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isCardContragent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstNameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastNameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesTaxReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateRegDocSrNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionTypesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sectorClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sectorClassificationText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeSourcesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeSourcesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeLevelsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propertyTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankProductsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountsInOtherBanks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPublicPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controller" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="addrKOATUUCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUClass" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="addrCityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUCodeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrKOATUUClassJur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="addrCityTypeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finnClass" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="applicationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatcaQuest" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fatcaStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="workKind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receipts" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fmqParamDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="fmqParamComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "nrStateRegisterCountry",
    "taxAdmCode",
    "addrCountry",
    "addrPostcode",
    "addrCity",
    "addrRegion",
    "addrRegionName",
    "addrDistrict",
    "addrStreet",
    "addrHouseNo",
    "addrFlat",
    "addrBuildNo",
    "addrCountryJur",
    "addrPostcodeJur",
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
    "isCardContragent",
    "firstNameEng",
    "lastNameEng",
    "taxCategory",
    "workTypesCode",
    "workTypesText",
    "workTypesTaxReg",
    "stateRegDocSrNo",
    "positionTypesCode",
    "positionTypesText",
    "sectorClassificationCode",
    "sectorClassificationText",
    "incomeSourcesCode",
    "incomeSourcesText",
    "incomeLevelsCode",
    "propertyTypesCode",
    "bankProductsCode",
    "workPlace",
    "accountsInOtherBanks",
    "isPublicPerson",
    "controller",
    "activityTypes",
    "additionalInfo1",
    "additionalInfo2",
    "signDate",
    "addrKOATUUCode",
    "addrKOATUUClass",
    "addrCityType",
    "addrKOATUUCodeJur",
    "addrKOATUUClassJur",
    "addrCityTypeJur",
    "gender",
    "externalSystem",
    "finnClass",
    "applicationType",
    "fatcaQuest",
    "fatcaStatus",
    "workKind",
    "receipts",
    "fmqParamDate",
    "fmqParamComment"
})
@XmlRootElement(name = "registerContragent")
public class RegisterContragent {

    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "taxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxId;
    @XmlElementRef(name = "lastNameUkr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastNameUkr;
    @XmlElementRef(name = "firstNameUkr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstNameUkr;
    @XmlElementRef(name = "middleNameUkr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> middleNameUkr;
    @XmlElementRef(name = "docSr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> docSr;
    @XmlElementRef(name = "docNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> docNo;
    @XmlElementRef(name = "docIssueDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> docIssueDate;
    @XmlElementRef(name = "docIssPlace", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> docIssPlace;
    @XmlElementRef(name = "docEndDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> docEndDate;
    @XmlElementRef(name = "recordNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recordNo;
    @XmlElementRef(name = "dateOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOfBirth;
    @XmlElementRef(name = "residence", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> residence;
    @XmlElementRef(name = "nrStateRegisterCountry", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nrStateRegisterCountry;
    @XmlElementRef(name = "taxAdmCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAdmCode;
    @XmlElementRef(name = "addrCountry", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCountry;
    @XmlElementRef(name = "addrPostcode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostcode;
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
    @XmlElementRef(name = "addrCountryJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCountryJur;
    @XmlElementRef(name = "addrPostcodeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostcodeJur;
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
    @XmlElementRef(name = "contInf5Email", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf5Email;
    @XmlElementRef(name = "contInf6Regaddrhf", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf6Regaddrhf;
    @XmlElementRef(name = "contInf7Staffdwp", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf7Staffdwp;
    @XmlElementRef(name = "contInf8Contperph", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf8Contperph;
    @XmlElementRef(name = "contPersType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersType;
    @XmlElementRef(name = "contPersName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersName;
    @XmlElementRef(name = "k060", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k060;
    @XmlElementRef(name = "k070", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k070;
    @XmlElementRef(name = "nrTaxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nrTaxId;
    @XmlElementRef(name = "taxRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxRegDate;
    @XmlElementRef(name = "placeOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> placeOfBirth;
    @XmlElementRef(name = "cardProduct", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardProduct;
    @XmlElementRef(name = "identification", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> identification;
    @XmlElementRef(name = "modifiedBy", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> modifiedBy;
    @XmlElementRef(name = "nationality", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nationality;
    @XmlElementRef(name = "docTypeId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> docTypeId;
    @XmlElementRef(name = "isCardContragent", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardContragent;
    @XmlElementRef(name = "firstNameEng", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstNameEng;
    @XmlElementRef(name = "lastNameEng", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastNameEng;
    @XmlElementRef(name = "taxCategory", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCategory;
    @XmlElementRef(name = "workTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesCode;
    @XmlElementRef(name = "workTypesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesText;
    @XmlElementRef(name = "workTypesTaxReg", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesTaxReg;
    @XmlElementRef(name = "stateRegDocSrNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stateRegDocSrNo;
    @XmlElementRef(name = "positionTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> positionTypesCode;
    @XmlElementRef(name = "positionTypesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> positionTypesText;
    @XmlElementRef(name = "sectorClassificationCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sectorClassificationCode;
    @XmlElementRef(name = "sectorClassificationText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sectorClassificationText;
    @XmlElementRef(name = "incomeSourcesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeSourcesCode;
    @XmlElementRef(name = "incomeSourcesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeSourcesText;
    @XmlElementRef(name = "incomeLevelsCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incomeLevelsCode;
    @XmlElementRef(name = "propertyTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> propertyTypesCode;
    @XmlElementRef(name = "bankProductsCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankProductsCode;
    @XmlElementRef(name = "workPlace", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workPlace;
    @XmlElementRef(name = "accountsInOtherBanks", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountsInOtherBanks;
    @XmlElementRef(name = "isPublicPerson", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isPublicPerson;
    @XmlElementRef(name = "controller", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> controller;
    @XmlElementRef(name = "activityTypes", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> activityTypes;
    @XmlElementRef(name = "additionalInfo1", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalInfo1;
    @XmlElementRef(name = "additionalInfo2", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalInfo2;
    @XmlElementRef(name = "signDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> signDate;
    @XmlElementRef(name = "addrKOATUUCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUCode;
    @XmlElementRef(name = "addrKOATUUClass", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> addrKOATUUClass;
    @XmlElementRef(name = "addrCityType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityType;
    @XmlElementRef(name = "addrKOATUUCodeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrKOATUUCodeJur;
    @XmlElementRef(name = "addrKOATUUClassJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> addrKOATUUClassJur;
    @XmlElementRef(name = "addrCityTypeJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityTypeJur;
    @XmlElementRef(name = "gender", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gender;
    @XmlElementRef(name = "externalSystem", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalSystem;
    @XmlElementRef(name = "finnClass", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> finnClass;
    @XmlElementRef(name = "applicationType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationType;
    @XmlElementRef(name = "fatcaQuest", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> fatcaQuest;
    @XmlElementRef(name = "fatcaStatus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> fatcaStatus;
    @XmlElementRef(name = "workKind", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workKind;
    @XmlElementRef(name = "receipts", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> receipts;
    @XmlElementRef(name = "fmqParamDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> fmqParamDate;
    @XmlElementRef(name = "fmqParamComment", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fmqParamComment;

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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxId(JAXBElement<String> value) {
        this.taxId = value;
    }

    /**
     * Gets the value of the lastNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastNameUkr() {
        return lastNameUkr;
    }

    /**
     * Sets the value of the lastNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastNameUkr(JAXBElement<String> value) {
        this.lastNameUkr = value;
    }

    /**
     * Gets the value of the firstNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstNameUkr() {
        return firstNameUkr;
    }

    /**
     * Sets the value of the firstNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstNameUkr(JAXBElement<String> value) {
        this.firstNameUkr = value;
    }

    /**
     * Gets the value of the middleNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMiddleNameUkr() {
        return middleNameUkr;
    }

    /**
     * Sets the value of the middleNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMiddleNameUkr(JAXBElement<String> value) {
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocNo(JAXBElement<String> value) {
        this.docNo = value;
    }

    /**
     * Gets the value of the docIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDocIssueDate() {
        return docIssueDate;
    }

    /**
     * Sets the value of the docIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDocIssueDate(JAXBElement<XMLGregorianCalendar> value) {
        this.docIssueDate = value;
    }

    /**
     * Gets the value of the docIssPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocIssPlace() {
        return docIssPlace;
    }

    /**
     * Sets the value of the docIssPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocIssPlace(JAXBElement<String> value) {
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
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<XMLGregorianCalendar> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the residence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResidence() {
        return residence;
    }

    /**
     * Sets the value of the residence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResidence(JAXBElement<String> value) {
        this.residence = value;
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
     * Gets the value of the taxAdmCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxAdmCode() {
        return taxAdmCode;
    }

    /**
     * Sets the value of the taxAdmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxAdmCode(JAXBElement<String> value) {
        this.taxAdmCode = value;
    }

    /**
     * Gets the value of the addrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCountry() {
        return addrCountry;
    }

    /**
     * Sets the value of the addrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCountry(JAXBElement<String> value) {
        this.addrCountry = value;
    }

    /**
     * Gets the value of the addrPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrPostcode() {
        return addrPostcode;
    }

    /**
     * Sets the value of the addrPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrPostcode(JAXBElement<String> value) {
        this.addrPostcode = value;
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
     * Gets the value of the addrCountryJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCountryJur() {
        return addrCountryJur;
    }

    /**
     * Sets the value of the addrCountryJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCountryJur(JAXBElement<String> value) {
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
     * Gets the value of the contInf5Email property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf5Email() {
        return contInf5Email;
    }

    /**
     * Sets the value of the contInf5Email property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf5Email(JAXBElement<String> value) {
        this.contInf5Email = value;
    }

    /**
     * Gets the value of the contInf6Regaddrhf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf6Regaddrhf() {
        return contInf6Regaddrhf;
    }

    /**
     * Sets the value of the contInf6Regaddrhf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf6Regaddrhf(JAXBElement<String> value) {
        this.contInf6Regaddrhf = value;
    }

    /**
     * Gets the value of the contInf7Staffdwp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf7Staffdwp() {
        return contInf7Staffdwp;
    }

    /**
     * Sets the value of the contInf7Staffdwp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf7Staffdwp(JAXBElement<String> value) {
        this.contInf7Staffdwp = value;
    }

    /**
     * Gets the value of the contInf8Contperph property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf8Contperph() {
        return contInf8Contperph;
    }

    /**
     * Sets the value of the contInf8Contperph property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf8Contperph(JAXBElement<String> value) {
        this.contInf8Contperph = value;
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
     * Gets the value of the cardProduct property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardProduct() {
        return cardProduct;
    }

    /**
     * Sets the value of the cardProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardProduct(JAXBElement<String> value) {
        this.cardProduct = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIdentification(JAXBElement<Integer> value) {
        this.identification = value;
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocTypeId() {
        return docTypeId;
    }

    /**
     * Sets the value of the docTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocTypeId(JAXBElement<String> value) {
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
     * Gets the value of the workTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesCode() {
        return workTypesCode;
    }

    /**
     * Sets the value of the workTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesCode(JAXBElement<String> value) {
        this.workTypesCode = value;
    }

    /**
     * Gets the value of the workTypesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesText() {
        return workTypesText;
    }

    /**
     * Sets the value of the workTypesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesText(JAXBElement<String> value) {
        this.workTypesText = value;
    }

    /**
     * Gets the value of the workTypesTaxReg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkTypesTaxReg() {
        return workTypesTaxReg;
    }

    /**
     * Sets the value of the workTypesTaxReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkTypesTaxReg(JAXBElement<String> value) {
        this.workTypesTaxReg = value;
    }

    /**
     * Gets the value of the stateRegDocSrNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStateRegDocSrNo() {
        return stateRegDocSrNo;
    }

    /**
     * Sets the value of the stateRegDocSrNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStateRegDocSrNo(JAXBElement<String> value) {
        this.stateRegDocSrNo = value;
    }

    /**
     * Gets the value of the positionTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPositionTypesCode() {
        return positionTypesCode;
    }

    /**
     * Sets the value of the positionTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPositionTypesCode(JAXBElement<String> value) {
        this.positionTypesCode = value;
    }

    /**
     * Gets the value of the positionTypesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPositionTypesText() {
        return positionTypesText;
    }

    /**
     * Sets the value of the positionTypesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPositionTypesText(JAXBElement<String> value) {
        this.positionTypesText = value;
    }

    /**
     * Gets the value of the sectorClassificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectorClassificationCode() {
        return sectorClassificationCode;
    }

    /**
     * Sets the value of the sectorClassificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectorClassificationCode(JAXBElement<String> value) {
        this.sectorClassificationCode = value;
    }

    /**
     * Gets the value of the sectorClassificationText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectorClassificationText() {
        return sectorClassificationText;
    }

    /**
     * Sets the value of the sectorClassificationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectorClassificationText(JAXBElement<String> value) {
        this.sectorClassificationText = value;
    }

    /**
     * Gets the value of the incomeSourcesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeSourcesCode() {
        return incomeSourcesCode;
    }

    /**
     * Sets the value of the incomeSourcesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeSourcesCode(JAXBElement<String> value) {
        this.incomeSourcesCode = value;
    }

    /**
     * Gets the value of the incomeSourcesText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeSourcesText() {
        return incomeSourcesText;
    }

    /**
     * Sets the value of the incomeSourcesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeSourcesText(JAXBElement<String> value) {
        this.incomeSourcesText = value;
    }

    /**
     * Gets the value of the incomeLevelsCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncomeLevelsCode() {
        return incomeLevelsCode;
    }

    /**
     * Sets the value of the incomeLevelsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncomeLevelsCode(JAXBElement<String> value) {
        this.incomeLevelsCode = value;
    }

    /**
     * Gets the value of the propertyTypesCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPropertyTypesCode() {
        return propertyTypesCode;
    }

    /**
     * Sets the value of the propertyTypesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPropertyTypesCode(JAXBElement<String> value) {
        this.propertyTypesCode = value;
    }

    /**
     * Gets the value of the bankProductsCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankProductsCode() {
        return bankProductsCode;
    }

    /**
     * Sets the value of the bankProductsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankProductsCode(JAXBElement<String> value) {
        this.bankProductsCode = value;
    }

    /**
     * Gets the value of the workPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkPlace() {
        return workPlace;
    }

    /**
     * Sets the value of the workPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkPlace(JAXBElement<String> value) {
        this.workPlace = value;
    }

    /**
     * Gets the value of the accountsInOtherBanks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountsInOtherBanks() {
        return accountsInOtherBanks;
    }

    /**
     * Sets the value of the accountsInOtherBanks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountsInOtherBanks(JAXBElement<String> value) {
        this.accountsInOtherBanks = value;
    }

    /**
     * Gets the value of the isPublicPerson property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsPublicPerson() {
        return isPublicPerson;
    }

    /**
     * Sets the value of the isPublicPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsPublicPerson(JAXBElement<String> value) {
        this.isPublicPerson = value;
    }

    /**
     * Gets the value of the controller property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getController() {
        return controller;
    }

    /**
     * Sets the value of the controller property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setController(JAXBElement<String> value) {
        this.controller = value;
    }

    /**
     * Gets the value of the activityTypes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActivityTypes() {
        return activityTypes;
    }

    /**
     * Sets the value of the activityTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActivityTypes(JAXBElement<String> value) {
        this.activityTypes = value;
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
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSignDate(JAXBElement<XMLGregorianCalendar> value) {
        this.signDate = value;
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
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAddrKOATUUClass() {
        return addrKOATUUClass;
    }

    /**
     * Sets the value of the addrKOATUUClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAddrKOATUUClass(JAXBElement<Integer> value) {
        this.addrKOATUUClass = value;
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
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAddrKOATUUClassJur() {
        return addrKOATUUClassJur;
    }

    /**
     * Sets the value of the addrKOATUUClassJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAddrKOATUUClassJur(JAXBElement<Integer> value) {
        this.addrKOATUUClassJur = value;
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
     * Gets the value of the externalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalSystem() {
        return externalSystem;
    }

    /**
     * Sets the value of the externalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalSystem(JAXBElement<String> value) {
        this.externalSystem = value;
    }

    /**
     * Gets the value of the finnClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getFinnClass() {
        return finnClass;
    }

    /**
     * Sets the value of the finnClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setFinnClass(JAXBElement<Integer> value) {
        this.finnClass = value;
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
     * Gets the value of the workKind property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkKind() {
        return workKind;
    }

    /**
     * Sets the value of the workKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkKind(JAXBElement<String> value) {
        this.workKind = value;
    }

    /**
     * Gets the value of the receipts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getReceipts() {
        return receipts;
    }

    /**
     * Sets the value of the receipts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setReceipts(JAXBElement<Integer> value) {
        this.receipts = value;
    }

    /**
     * Gets the value of the fmqParamDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFmqParamDate() {
        return fmqParamDate;
    }

    /**
     * Sets the value of the fmqParamDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFmqParamDate(JAXBElement<XMLGregorianCalendar> value) {
        this.fmqParamDate = value;
    }

    /**
     * Gets the value of the fmqParamComment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFmqParamComment() {
        return fmqParamComment;
    }

    /**
     * Sets the value of the fmqParamComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFmqParamComment(JAXBElement<String> value) {
        this.fmqParamComment = value;
    }

}
