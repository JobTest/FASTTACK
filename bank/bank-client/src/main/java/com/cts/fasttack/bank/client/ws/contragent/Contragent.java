
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for contragent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contragent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMNextIndentifyDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="middleNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docSr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docIssueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="docIssPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="placeOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="residence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxAdmCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionRcuCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountryJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrPostcodeJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCityJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionJurRcuCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrictJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreetJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNoJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlatJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNoJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCountryBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrPostcodeBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCityBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrRegionBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrDistrictBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrStreetBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrHouseNoBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFlatBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrBuildNoBus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf1Home" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf2Cellur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf3Work" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf4Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf5Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf6Regaddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf7Staffdw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf8Contper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contPersType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k060" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k070" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="cardProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identification" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isVIP" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isAClub" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="finBlock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="K050" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortNameUkr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contInf9URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountOfficer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k110" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressJur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="riskCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="toboId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="staRegAgency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addSubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="industry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="k013" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateRegDocSrNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTypesTaxReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isCardContragent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contragent", propOrder = {
    "fmNextIndentifyDate",
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
    "placeOfBirth",
    "residence",
    "taxAdmCode",
    "addrCountry",
    "addrPostcode",
    "addrCity",
    "addrRegionRcuCode",
    "addrRegion",
    "addrDistrict",
    "addrStreet",
    "addrHouseNo",
    "addrFlat",
    "addrBuildNo",
    "addrCountryJur",
    "addrPostcodeJur",
    "addrCityJur",
    "addrRegionJurRcuCode",
    "addrRegionJur",
    "addrDistrictJur",
    "addrStreetJur",
    "addrHouseNoJur",
    "addrFlatJur",
    "addrBuildNoJur",
    "addrCountryBus",
    "addrPostcodeBus",
    "addrCityBus",
    "addrRegionBus",
    "addrDistrictBus",
    "addrStreetBus",
    "addrHouseNoBus",
    "addrFlatBus",
    "addrBuildNoBus",
    "contInf1Home",
    "contInf2Cellur",
    "contInf3Work",
    "contInf4Fax",
    "contInf5Email",
    "contInf6Regaddr",
    "contInf7Staffdw",
    "contInf8Contper",
    "contPersName",
    "contPersType",
    "k060",
    "k070",
    "nrTaxId",
    "taxRegDate",
    "cardProduct",
    "identification",
    "status",
    "statusText",
    "modifiedBy",
    "isVIP",
    "isAClub",
    "finBlock",
    "k050",
    "nameUkr",
    "shortNameUkr",
    "contInf9URL",
    "accountOfficer",
    "sector",
    "target",
    "k110",
    "creditRating",
    "address",
    "addressJur",
    "riskCategory",
    "nameEng",
    "bankRegDate",
    "toboId",
    "staRegAgency",
    "addSubType",
    "industry",
    "k013",
    "taxCategory",
    "stateRegDocSrNo",
    "workTypesCode",
    "workTypesText",
    "workTypesTaxReg",
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
    "nationality",
    "gender",
    "isCardContragent"
})
@XmlRootElement(name = "contragent", namespace = "http://sab/")
public class Contragent {

    @XmlElementRef(name = "FMNextIndentifyDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fmNextIndentifyDate;
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
    @XmlElementRef(name = "dateOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOfBirth;
    @XmlElementRef(name = "placeOfBirth", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> placeOfBirth;
    @XmlElementRef(name = "residence", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> residence;
    @XmlElementRef(name = "taxAdmCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAdmCode;
    @XmlElementRef(name = "addrCountry", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCountry;
    @XmlElementRef(name = "addrPostcode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostcode;
    @XmlElementRef(name = "addrCity", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCity;
    @XmlElementRef(name = "addrRegionRcuCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionRcuCode;
    @XmlElementRef(name = "addrRegion", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegion;
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
    @XmlElementRef(name = "addrRegionJurRcuCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionJurRcuCode;
    @XmlElementRef(name = "addrRegionJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionJur;
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
    @XmlElementRef(name = "addrCountryBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCountryBus;
    @XmlElementRef(name = "addrPostcodeBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrPostcodeBus;
    @XmlElementRef(name = "addrCityBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrCityBus;
    @XmlElementRef(name = "addrRegionBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrRegionBus;
    @XmlElementRef(name = "addrDistrictBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrDistrictBus;
    @XmlElementRef(name = "addrStreetBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrStreetBus;
    @XmlElementRef(name = "addrHouseNoBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrHouseNoBus;
    @XmlElementRef(name = "addrFlatBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrFlatBus;
    @XmlElementRef(name = "addrBuildNoBus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addrBuildNoBus;
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
    @XmlElementRef(name = "contInf6Regaddr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf6Regaddr;
    @XmlElementRef(name = "contInf7Staffdw", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf7Staffdw;
    @XmlElementRef(name = "contInf8Contper", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf8Contper;
    @XmlElementRef(name = "contPersName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersName;
    @XmlElementRef(name = "contPersType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contPersType;
    @XmlElementRef(name = "k060", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k060;
    @XmlElementRef(name = "k070", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k070;
    @XmlElementRef(name = "nrTaxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nrTaxId;
    @XmlElementRef(name = "taxRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxRegDate;
    @XmlElementRef(name = "cardProduct", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardProduct;
    @XmlElementRef(name = "identification", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> identification;
    @XmlElementRef(name = "status", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "statusText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statusText;
    @XmlElementRef(name = "modifiedBy", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> modifiedBy;
    @XmlElementRef(name = "isVIP", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> isVIP;
    @XmlElementRef(name = "isAClub", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> isAClub;
    @XmlElementRef(name = "finBlock", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finBlock;
    @XmlElementRef(name = "K050", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k050;
    @XmlElementRef(name = "nameUkr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameUkr;
    @XmlElementRef(name = "shortNameUkr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shortNameUkr;
    @XmlElementRef(name = "contInf9URL", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contInf9URL;
    @XmlElementRef(name = "accountOfficer", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountOfficer;
    @XmlElementRef(name = "sector", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sector;
    @XmlElementRef(name = "target", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> target;
    @XmlElementRef(name = "k110", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k110;
    @XmlElementRef(name = "creditRating", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditRating;
    @XmlElementRef(name = "address", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address;
    @XmlElementRef(name = "addressJur", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressJur;
    @XmlElementRef(name = "riskCategory", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> riskCategory;
    @XmlElementRef(name = "nameEng", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameEng;
    @XmlElementRef(name = "bankRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> bankRegDate;
    @XmlElementRef(name = "toboId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> toboId;
    @XmlElementRef(name = "staRegAgency", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> staRegAgency;
    @XmlElementRef(name = "addSubType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addSubType;
    @XmlElementRef(name = "industry", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> industry;
    @XmlElementRef(name = "k013", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> k013;
    @XmlElementRef(name = "taxCategory", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCategory;
    @XmlElementRef(name = "stateRegDocSrNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stateRegDocSrNo;
    @XmlElementRef(name = "workTypesCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesCode;
    @XmlElementRef(name = "workTypesText", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesText;
    @XmlElementRef(name = "workTypesTaxReg", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workTypesTaxReg;
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
    @XmlElementRef(name = "nationality", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nationality;
    @XmlElementRef(name = "gender", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gender;
    @XmlElementRef(name = "isCardContragent", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isCardContragent;

    /**
     * Gets the value of the fmNextIndentifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFMNextIndentifyDate() {
        return fmNextIndentifyDate;
    }

    /**
     * Sets the value of the fmNextIndentifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFMNextIndentifyDate(JAXBElement<String> value) {
        this.fmNextIndentifyDate = value;
    }

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
     * Gets the value of the addrRegionRcuCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionRcuCode() {
        return addrRegionRcuCode;
    }

    /**
     * Sets the value of the addrRegionRcuCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionRcuCode(JAXBElement<String> value) {
        this.addrRegionRcuCode = value;
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
     * Gets the value of the addrRegionJurRcuCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionJurRcuCode() {
        return addrRegionJurRcuCode;
    }

    /**
     * Sets the value of the addrRegionJurRcuCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionJurRcuCode(JAXBElement<String> value) {
        this.addrRegionJurRcuCode = value;
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
     * Gets the value of the addrCountryBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCountryBus() {
        return addrCountryBus;
    }

    /**
     * Sets the value of the addrCountryBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCountryBus(JAXBElement<String> value) {
        this.addrCountryBus = value;
    }

    /**
     * Gets the value of the addrPostcodeBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrPostcodeBus() {
        return addrPostcodeBus;
    }

    /**
     * Sets the value of the addrPostcodeBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrPostcodeBus(JAXBElement<String> value) {
        this.addrPostcodeBus = value;
    }

    /**
     * Gets the value of the addrCityBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrCityBus() {
        return addrCityBus;
    }

    /**
     * Sets the value of the addrCityBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrCityBus(JAXBElement<String> value) {
        this.addrCityBus = value;
    }

    /**
     * Gets the value of the addrRegionBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrRegionBus() {
        return addrRegionBus;
    }

    /**
     * Sets the value of the addrRegionBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrRegionBus(JAXBElement<String> value) {
        this.addrRegionBus = value;
    }

    /**
     * Gets the value of the addrDistrictBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrDistrictBus() {
        return addrDistrictBus;
    }

    /**
     * Sets the value of the addrDistrictBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrDistrictBus(JAXBElement<String> value) {
        this.addrDistrictBus = value;
    }

    /**
     * Gets the value of the addrStreetBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrStreetBus() {
        return addrStreetBus;
    }

    /**
     * Sets the value of the addrStreetBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrStreetBus(JAXBElement<String> value) {
        this.addrStreetBus = value;
    }

    /**
     * Gets the value of the addrHouseNoBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrHouseNoBus() {
        return addrHouseNoBus;
    }

    /**
     * Sets the value of the addrHouseNoBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrHouseNoBus(JAXBElement<String> value) {
        this.addrHouseNoBus = value;
    }

    /**
     * Gets the value of the addrFlatBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrFlatBus() {
        return addrFlatBus;
    }

    /**
     * Sets the value of the addrFlatBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrFlatBus(JAXBElement<String> value) {
        this.addrFlatBus = value;
    }

    /**
     * Gets the value of the addrBuildNoBus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrBuildNoBus() {
        return addrBuildNoBus;
    }

    /**
     * Sets the value of the addrBuildNoBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrBuildNoBus(JAXBElement<String> value) {
        this.addrBuildNoBus = value;
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
     * Gets the value of the contInf6Regaddr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf6Regaddr() {
        return contInf6Regaddr;
    }

    /**
     * Sets the value of the contInf6Regaddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf6Regaddr(JAXBElement<String> value) {
        this.contInf6Regaddr = value;
    }

    /**
     * Gets the value of the contInf7Staffdw property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf7Staffdw() {
        return contInf7Staffdw;
    }

    /**
     * Sets the value of the contInf7Staffdw property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf7Staffdw(JAXBElement<String> value) {
        this.contInf7Staffdw = value;
    }

    /**
     * Gets the value of the contInf8Contper property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf8Contper() {
        return contInf8Contper;
    }

    /**
     * Sets the value of the contInf8Contper property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf8Contper(JAXBElement<String> value) {
        this.contInf8Contper = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatusText(JAXBElement<String> value) {
        this.statusText = value;
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
     * Gets the value of the isVIP property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIsVIP() {
        return isVIP;
    }

    /**
     * Sets the value of the isVIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIsVIP(JAXBElement<Integer> value) {
        this.isVIP = value;
    }

    /**
     * Gets the value of the isAClub property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIsAClub() {
        return isAClub;
    }

    /**
     * Sets the value of the isAClub property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIsAClub(JAXBElement<Integer> value) {
        this.isAClub = value;
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
     * Gets the value of the nameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameUkr() {
        return nameUkr;
    }

    /**
     * Sets the value of the nameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameUkr(JAXBElement<String> value) {
        this.nameUkr = value;
    }

    /**
     * Gets the value of the shortNameUkr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShortNameUkr() {
        return shortNameUkr;
    }

    /**
     * Sets the value of the shortNameUkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShortNameUkr(JAXBElement<String> value) {
        this.shortNameUkr = value;
    }

    /**
     * Gets the value of the contInf9URL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContInf9URL() {
        return contInf9URL;
    }

    /**
     * Sets the value of the contInf9URL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContInf9URL(JAXBElement<String> value) {
        this.contInf9URL = value;
    }

    /**
     * Gets the value of the accountOfficer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountOfficer() {
        return accountOfficer;
    }

    /**
     * Sets the value of the accountOfficer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountOfficer(JAXBElement<String> value) {
        this.accountOfficer = value;
    }

    /**
     * Gets the value of the sector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSector() {
        return sector;
    }

    /**
     * Sets the value of the sector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSector(JAXBElement<String> value) {
        this.sector = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTarget(JAXBElement<String> value) {
        this.target = value;
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
     * Gets the value of the creditRating property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditRating() {
        return creditRating;
    }

    /**
     * Sets the value of the creditRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditRating(JAXBElement<String> value) {
        this.creditRating = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress(JAXBElement<String> value) {
        this.address = value;
    }

    /**
     * Gets the value of the addressJur property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressJur() {
        return addressJur;
    }

    /**
     * Sets the value of the addressJur property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressJur(JAXBElement<String> value) {
        this.addressJur = value;
    }

    /**
     * Gets the value of the riskCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRiskCategory() {
        return riskCategory;
    }

    /**
     * Sets the value of the riskCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRiskCategory(JAXBElement<String> value) {
        this.riskCategory = value;
    }

    /**
     * Gets the value of the nameEng property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameEng() {
        return nameEng;
    }

    /**
     * Sets the value of the nameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameEng(JAXBElement<String> value) {
        this.nameEng = value;
    }

    /**
     * Gets the value of the bankRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBankRegDate() {
        return bankRegDate;
    }

    /**
     * Sets the value of the bankRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBankRegDate(JAXBElement<XMLGregorianCalendar> value) {
        this.bankRegDate = value;
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
     * Gets the value of the staRegAgency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStaRegAgency() {
        return staRegAgency;
    }

    /**
     * Sets the value of the staRegAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStaRegAgency(JAXBElement<String> value) {
        this.staRegAgency = value;
    }

    /**
     * Gets the value of the addSubType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddSubType() {
        return addSubType;
    }

    /**
     * Sets the value of the addSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddSubType(JAXBElement<String> value) {
        this.addSubType = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndustry(JAXBElement<String> value) {
        this.industry = value;
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

}
