
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getCustomerProfileByTaxIdItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCustomerProfileByTaxIdItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="familyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dependantsCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spouseLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spouseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spouseBirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="marriageDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="nameChanged" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameChangedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="formerLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formerFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formerMidName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentApp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentHouse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contragentRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="contragentPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permanentResidentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="residingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="appTotalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="habitationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permanentResidentTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRegistrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgPostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgaHouse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgPhoneNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgEmployeeCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startWorkDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="totalEmplYears" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="education" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgScopeActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scopeActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subordinatesCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantMidName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantPassportSr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantPassportNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantBirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="guarantPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantMobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantHouse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantApp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantRegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="confirmedProfits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basicProfits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extLoanCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extLoanCreditor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extLoanStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="carCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasCarLoan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasMortgageLoan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasOtherLoan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalLoansAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalLoansMonthPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalLoansRemainBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerProfileByTaxIdItem", propOrder = {
    "familyStatus",
    "childCount",
    "dependantsCount",
    "spouseLastName",
    "spouseName",
    "spouseBirthDate",
    "marriageDate",
    "nameChanged",
    "nameChangedDate",
    "formerLastName",
    "formerFirstName",
    "formerMidName",
    "contragentPostcode",
    "contragentRegion",
    "contragentDistrict",
    "contragentSettlement",
    "contragentApp",
    "contragentStreet",
    "contragentHouse",
    "contragentRegDate",
    "contragentPhone",
    "permanentResidentType",
    "residingDate",
    "appTotalArea",
    "purchaseWay",
    "habitationType",
    "permanentResidentTerm",
    "orgType",
    "orgName",
    "orgRegistrCode",
    "orgPostCode",
    "orgRegion",
    "orgDistrict",
    "orgSettlement",
    "orgStreet",
    "orgaHouse",
    "orgPhoneNum",
    "orgEmployeeCount",
    "startWorkDate",
    "totalEmplYears",
    "education",
    "orgScopeActivity",
    "scopeActivity",
    "position",
    "subordinatesCount",
    "workType",
    "guarantLastName",
    "guarantName",
    "guarantMidName",
    "guarantTaxId",
    "guarantPassportSr",
    "guarantPassportNo",
    "guarantBirthDate",
    "guarantPhone",
    "guarantMobilePhone",
    "guarantPostcode",
    "guarantRegion",
    "guarantDistrict",
    "guarantSettlement",
    "guarantStreet",
    "guarantHouse",
    "guarantApp",
    "guarantRegDate",
    "confirmedProfits",
    "basicProfits",
    "extLoanCount",
    "extLoanCreditor",
    "extLoanStartDate",
    "carCount",
    "carModel",
    "carNumber",
    "carYear",
    "hasCarLoan",
    "hasMortgageLoan",
    "hasOtherLoan",
    "totalLoansAmount",
    "totalLoansMonthPayment",
    "totalLoansRemainBalance"
})
public class GetCustomerProfileByTaxIdItem {

    @XmlElementRef(name = "familyStatus", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> familyStatus;
    @XmlElementRef(name = "childCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> childCount;
    @XmlElementRef(name = "dependantsCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dependantsCount;
    @XmlElementRef(name = "spouseLastName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> spouseLastName;
    @XmlElementRef(name = "spouseName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> spouseName;
    @XmlElementRef(name = "spouseBirthDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> spouseBirthDate;
    @XmlElementRef(name = "marriageDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> marriageDate;
    @XmlElementRef(name = "nameChanged", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameChanged;
    @XmlElementRef(name = "nameChangedDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> nameChangedDate;
    @XmlElementRef(name = "formerLastName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> formerLastName;
    @XmlElementRef(name = "formerFirstName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> formerFirstName;
    @XmlElementRef(name = "formerMidName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> formerMidName;
    @XmlElementRef(name = "contragentPostcode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentPostcode;
    @XmlElementRef(name = "contragentRegion", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentRegion;
    @XmlElementRef(name = "contragentDistrict", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentDistrict;
    @XmlElementRef(name = "contragentSettlement", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentSettlement;
    @XmlElementRef(name = "contragentApp", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentApp;
    @XmlElementRef(name = "contragentStreet", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentStreet;
    @XmlElementRef(name = "contragentHouse", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentHouse;
    @XmlElementRef(name = "contragentRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> contragentRegDate;
    @XmlElementRef(name = "contragentPhone", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentPhone;
    @XmlElementRef(name = "permanentResidentType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> permanentResidentType;
    @XmlElementRef(name = "residingDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> residingDate;
    @XmlElementRef(name = "appTotalArea", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> appTotalArea;
    @XmlElementRef(name = "purchaseWay", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseWay;
    @XmlElementRef(name = "habitationType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> habitationType;
    @XmlElementRef(name = "permanentResidentTerm", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> permanentResidentTerm;
    @XmlElementRef(name = "orgType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgType;
    @XmlElementRef(name = "orgName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgName;
    @XmlElementRef(name = "orgRegistrCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgRegistrCode;
    @XmlElementRef(name = "orgPostCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgPostCode;
    @XmlElementRef(name = "orgRegion", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgRegion;
    @XmlElementRef(name = "orgDistrict", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgDistrict;
    @XmlElementRef(name = "orgSettlement", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgSettlement;
    @XmlElementRef(name = "orgStreet", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgStreet;
    @XmlElementRef(name = "orgaHouse", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgaHouse;
    @XmlElementRef(name = "orgPhoneNum", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgPhoneNum;
    @XmlElementRef(name = "orgEmployeeCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgEmployeeCount;
    @XmlElementRef(name = "startWorkDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startWorkDate;
    @XmlElementRef(name = "totalEmplYears", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalEmplYears;
    @XmlElementRef(name = "education", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> education;
    @XmlElementRef(name = "orgScopeActivity", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgScopeActivity;
    @XmlElementRef(name = "scopeActivity", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> scopeActivity;
    @XmlElementRef(name = "position", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> position;
    @XmlElementRef(name = "subordinatesCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subordinatesCount;
    @XmlElementRef(name = "workType", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workType;
    @XmlElementRef(name = "guarantLastName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantLastName;
    @XmlElementRef(name = "guarantName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantName;
    @XmlElementRef(name = "guarantMidName", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantMidName;
    @XmlElementRef(name = "guarantTaxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantTaxId;
    @XmlElementRef(name = "guarantPassportSr", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantPassportSr;
    @XmlElementRef(name = "guarantPassportNo", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantPassportNo;
    @XmlElementRef(name = "guarantBirthDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> guarantBirthDate;
    @XmlElementRef(name = "guarantPhone", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantPhone;
    @XmlElementRef(name = "guarantMobilePhone", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantMobilePhone;
    @XmlElementRef(name = "guarantPostcode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantPostcode;
    @XmlElementRef(name = "guarantRegion", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantRegion;
    @XmlElementRef(name = "guarantDistrict", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantDistrict;
    @XmlElementRef(name = "guarantSettlement", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantSettlement;
    @XmlElementRef(name = "guarantStreet", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantStreet;
    @XmlElementRef(name = "guarantHouse", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantHouse;
    @XmlElementRef(name = "guarantApp", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guarantApp;
    @XmlElementRef(name = "guarantRegDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> guarantRegDate;
    @XmlElementRef(name = "confirmedProfits", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> confirmedProfits;
    @XmlElementRef(name = "basicProfits", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> basicProfits;
    @XmlElementRef(name = "extLoanCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extLoanCount;
    @XmlElementRef(name = "extLoanCreditor", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extLoanCreditor;
    @XmlElementRef(name = "extLoanStartDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> extLoanStartDate;
    @XmlElementRef(name = "carCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> carCount;
    @XmlElementRef(name = "carModel", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> carModel;
    @XmlElementRef(name = "carNumber", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> carNumber;
    @XmlElementRef(name = "carYear", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> carYear;
    @XmlElementRef(name = "hasCarLoan", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hasCarLoan;
    @XmlElementRef(name = "hasMortgageLoan", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hasMortgageLoan;
    @XmlElementRef(name = "hasOtherLoan", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hasOtherLoan;
    @XmlElementRef(name = "totalLoansAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalLoansAmount;
    @XmlElementRef(name = "totalLoansMonthPayment", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalLoansMonthPayment;
    @XmlElementRef(name = "totalLoansRemainBalance", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalLoansRemainBalance;

    /**
     * Gets the value of the familyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFamilyStatus() {
        return familyStatus;
    }

    /**
     * Sets the value of the familyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFamilyStatus(JAXBElement<String> value) {
        this.familyStatus = value;
    }

    /**
     * Gets the value of the childCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChildCount() {
        return childCount;
    }

    /**
     * Sets the value of the childCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChildCount(JAXBElement<String> value) {
        this.childCount = value;
    }

    /**
     * Gets the value of the dependantsCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDependantsCount() {
        return dependantsCount;
    }

    /**
     * Sets the value of the dependantsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDependantsCount(JAXBElement<String> value) {
        this.dependantsCount = value;
    }

    /**
     * Gets the value of the spouseLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpouseLastName() {
        return spouseLastName;
    }

    /**
     * Sets the value of the spouseLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpouseLastName(JAXBElement<String> value) {
        this.spouseLastName = value;
    }

    /**
     * Gets the value of the spouseName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpouseName() {
        return spouseName;
    }

    /**
     * Sets the value of the spouseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpouseName(JAXBElement<String> value) {
        this.spouseName = value;
    }

    /**
     * Gets the value of the spouseBirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSpouseBirthDate() {
        return spouseBirthDate;
    }

    /**
     * Sets the value of the spouseBirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSpouseBirthDate(JAXBElement<XMLGregorianCalendar> value) {
        this.spouseBirthDate = value;
    }

    /**
     * Gets the value of the marriageDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getMarriageDate() {
        return marriageDate;
    }

    /**
     * Sets the value of the marriageDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setMarriageDate(JAXBElement<XMLGregorianCalendar> value) {
        this.marriageDate = value;
    }

    /**
     * Gets the value of the nameChanged property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameChanged() {
        return nameChanged;
    }

    /**
     * Sets the value of the nameChanged property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameChanged(JAXBElement<String> value) {
        this.nameChanged = value;
    }

    /**
     * Gets the value of the nameChangedDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getNameChangedDate() {
        return nameChangedDate;
    }

    /**
     * Sets the value of the nameChangedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setNameChangedDate(JAXBElement<XMLGregorianCalendar> value) {
        this.nameChangedDate = value;
    }

    /**
     * Gets the value of the formerLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFormerLastName() {
        return formerLastName;
    }

    /**
     * Sets the value of the formerLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFormerLastName(JAXBElement<String> value) {
        this.formerLastName = value;
    }

    /**
     * Gets the value of the formerFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFormerFirstName() {
        return formerFirstName;
    }

    /**
     * Sets the value of the formerFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFormerFirstName(JAXBElement<String> value) {
        this.formerFirstName = value;
    }

    /**
     * Gets the value of the formerMidName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFormerMidName() {
        return formerMidName;
    }

    /**
     * Sets the value of the formerMidName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFormerMidName(JAXBElement<String> value) {
        this.formerMidName = value;
    }

    /**
     * Gets the value of the contragentPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentPostcode() {
        return contragentPostcode;
    }

    /**
     * Sets the value of the contragentPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentPostcode(JAXBElement<String> value) {
        this.contragentPostcode = value;
    }

    /**
     * Gets the value of the contragentRegion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentRegion() {
        return contragentRegion;
    }

    /**
     * Sets the value of the contragentRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentRegion(JAXBElement<String> value) {
        this.contragentRegion = value;
    }

    /**
     * Gets the value of the contragentDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentDistrict() {
        return contragentDistrict;
    }

    /**
     * Sets the value of the contragentDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentDistrict(JAXBElement<String> value) {
        this.contragentDistrict = value;
    }

    /**
     * Gets the value of the contragentSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentSettlement() {
        return contragentSettlement;
    }

    /**
     * Sets the value of the contragentSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentSettlement(JAXBElement<String> value) {
        this.contragentSettlement = value;
    }

    /**
     * Gets the value of the contragentApp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentApp() {
        return contragentApp;
    }

    /**
     * Sets the value of the contragentApp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentApp(JAXBElement<String> value) {
        this.contragentApp = value;
    }

    /**
     * Gets the value of the contragentStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentStreet() {
        return contragentStreet;
    }

    /**
     * Sets the value of the contragentStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentStreet(JAXBElement<String> value) {
        this.contragentStreet = value;
    }

    /**
     * Gets the value of the contragentHouse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentHouse() {
        return contragentHouse;
    }

    /**
     * Sets the value of the contragentHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentHouse(JAXBElement<String> value) {
        this.contragentHouse = value;
    }

    /**
     * Gets the value of the contragentRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getContragentRegDate() {
        return contragentRegDate;
    }

    /**
     * Sets the value of the contragentRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setContragentRegDate(JAXBElement<XMLGregorianCalendar> value) {
        this.contragentRegDate = value;
    }

    /**
     * Gets the value of the contragentPhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentPhone() {
        return contragentPhone;
    }

    /**
     * Sets the value of the contragentPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentPhone(JAXBElement<String> value) {
        this.contragentPhone = value;
    }

    /**
     * Gets the value of the permanentResidentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPermanentResidentType() {
        return permanentResidentType;
    }

    /**
     * Sets the value of the permanentResidentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPermanentResidentType(JAXBElement<String> value) {
        this.permanentResidentType = value;
    }

    /**
     * Gets the value of the residingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getResidingDate() {
        return residingDate;
    }

    /**
     * Sets the value of the residingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setResidingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.residingDate = value;
    }

    /**
     * Gets the value of the appTotalArea property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppTotalArea() {
        return appTotalArea;
    }

    /**
     * Sets the value of the appTotalArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppTotalArea(JAXBElement<String> value) {
        this.appTotalArea = value;
    }

    /**
     * Gets the value of the purchaseWay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseWay() {
        return purchaseWay;
    }

    /**
     * Sets the value of the purchaseWay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseWay(JAXBElement<String> value) {
        this.purchaseWay = value;
    }

    /**
     * Gets the value of the habitationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHabitationType() {
        return habitationType;
    }

    /**
     * Sets the value of the habitationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHabitationType(JAXBElement<String> value) {
        this.habitationType = value;
    }

    /**
     * Gets the value of the permanentResidentTerm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPermanentResidentTerm() {
        return permanentResidentTerm;
    }

    /**
     * Sets the value of the permanentResidentTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPermanentResidentTerm(JAXBElement<String> value) {
        this.permanentResidentTerm = value;
    }

    /**
     * Gets the value of the orgType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgType() {
        return orgType;
    }

    /**
     * Sets the value of the orgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgType(JAXBElement<String> value) {
        this.orgType = value;
    }

    /**
     * Gets the value of the orgName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgName(JAXBElement<String> value) {
        this.orgName = value;
    }

    /**
     * Gets the value of the orgRegistrCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgRegistrCode() {
        return orgRegistrCode;
    }

    /**
     * Sets the value of the orgRegistrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgRegistrCode(JAXBElement<String> value) {
        this.orgRegistrCode = value;
    }

    /**
     * Gets the value of the orgPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgPostCode() {
        return orgPostCode;
    }

    /**
     * Sets the value of the orgPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgPostCode(JAXBElement<String> value) {
        this.orgPostCode = value;
    }

    /**
     * Gets the value of the orgRegion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgRegion() {
        return orgRegion;
    }

    /**
     * Sets the value of the orgRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgRegion(JAXBElement<String> value) {
        this.orgRegion = value;
    }

    /**
     * Gets the value of the orgDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgDistrict() {
        return orgDistrict;
    }

    /**
     * Sets the value of the orgDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgDistrict(JAXBElement<String> value) {
        this.orgDistrict = value;
    }

    /**
     * Gets the value of the orgSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgSettlement() {
        return orgSettlement;
    }

    /**
     * Sets the value of the orgSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgSettlement(JAXBElement<String> value) {
        this.orgSettlement = value;
    }

    /**
     * Gets the value of the orgStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgStreet() {
        return orgStreet;
    }

    /**
     * Sets the value of the orgStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgStreet(JAXBElement<String> value) {
        this.orgStreet = value;
    }

    /**
     * Gets the value of the orgaHouse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgaHouse() {
        return orgaHouse;
    }

    /**
     * Sets the value of the orgaHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgaHouse(JAXBElement<String> value) {
        this.orgaHouse = value;
    }

    /**
     * Gets the value of the orgPhoneNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgPhoneNum() {
        return orgPhoneNum;
    }

    /**
     * Sets the value of the orgPhoneNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgPhoneNum(JAXBElement<String> value) {
        this.orgPhoneNum = value;
    }

    /**
     * Gets the value of the orgEmployeeCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgEmployeeCount() {
        return orgEmployeeCount;
    }

    /**
     * Sets the value of the orgEmployeeCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgEmployeeCount(JAXBElement<String> value) {
        this.orgEmployeeCount = value;
    }

    /**
     * Gets the value of the startWorkDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getStartWorkDate() {
        return startWorkDate;
    }

    /**
     * Sets the value of the startWorkDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setStartWorkDate(JAXBElement<XMLGregorianCalendar> value) {
        this.startWorkDate = value;
    }

    /**
     * Gets the value of the totalEmplYears property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalEmplYears() {
        return totalEmplYears;
    }

    /**
     * Sets the value of the totalEmplYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalEmplYears(JAXBElement<String> value) {
        this.totalEmplYears = value;
    }

    /**
     * Gets the value of the education property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEducation() {
        return education;
    }

    /**
     * Sets the value of the education property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEducation(JAXBElement<String> value) {
        this.education = value;
    }

    /**
     * Gets the value of the orgScopeActivity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgScopeActivity() {
        return orgScopeActivity;
    }

    /**
     * Sets the value of the orgScopeActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgScopeActivity(JAXBElement<String> value) {
        this.orgScopeActivity = value;
    }

    /**
     * Gets the value of the scopeActivity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getScopeActivity() {
        return scopeActivity;
    }

    /**
     * Sets the value of the scopeActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setScopeActivity(JAXBElement<String> value) {
        this.scopeActivity = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPosition(JAXBElement<String> value) {
        this.position = value;
    }

    /**
     * Gets the value of the subordinatesCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubordinatesCount() {
        return subordinatesCount;
    }

    /**
     * Sets the value of the subordinatesCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubordinatesCount(JAXBElement<String> value) {
        this.subordinatesCount = value;
    }

    /**
     * Gets the value of the workType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkType() {
        return workType;
    }

    /**
     * Sets the value of the workType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkType(JAXBElement<String> value) {
        this.workType = value;
    }

    /**
     * Gets the value of the guarantLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantLastName() {
        return guarantLastName;
    }

    /**
     * Sets the value of the guarantLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantLastName(JAXBElement<String> value) {
        this.guarantLastName = value;
    }

    /**
     * Gets the value of the guarantName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantName() {
        return guarantName;
    }

    /**
     * Sets the value of the guarantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantName(JAXBElement<String> value) {
        this.guarantName = value;
    }

    /**
     * Gets the value of the guarantMidName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantMidName() {
        return guarantMidName;
    }

    /**
     * Sets the value of the guarantMidName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantMidName(JAXBElement<String> value) {
        this.guarantMidName = value;
    }

    /**
     * Gets the value of the guarantTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantTaxId() {
        return guarantTaxId;
    }

    /**
     * Sets the value of the guarantTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantTaxId(JAXBElement<String> value) {
        this.guarantTaxId = value;
    }

    /**
     * Gets the value of the guarantPassportSr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantPassportSr() {
        return guarantPassportSr;
    }

    /**
     * Sets the value of the guarantPassportSr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantPassportSr(JAXBElement<String> value) {
        this.guarantPassportSr = value;
    }

    /**
     * Gets the value of the guarantPassportNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantPassportNo() {
        return guarantPassportNo;
    }

    /**
     * Sets the value of the guarantPassportNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantPassportNo(JAXBElement<String> value) {
        this.guarantPassportNo = value;
    }

    /**
     * Gets the value of the guarantBirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getGuarantBirthDate() {
        return guarantBirthDate;
    }

    /**
     * Sets the value of the guarantBirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setGuarantBirthDate(JAXBElement<XMLGregorianCalendar> value) {
        this.guarantBirthDate = value;
    }

    /**
     * Gets the value of the guarantPhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantPhone() {
        return guarantPhone;
    }

    /**
     * Sets the value of the guarantPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantPhone(JAXBElement<String> value) {
        this.guarantPhone = value;
    }

    /**
     * Gets the value of the guarantMobilePhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantMobilePhone() {
        return guarantMobilePhone;
    }

    /**
     * Sets the value of the guarantMobilePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantMobilePhone(JAXBElement<String> value) {
        this.guarantMobilePhone = value;
    }

    /**
     * Gets the value of the guarantPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantPostcode() {
        return guarantPostcode;
    }

    /**
     * Sets the value of the guarantPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantPostcode(JAXBElement<String> value) {
        this.guarantPostcode = value;
    }

    /**
     * Gets the value of the guarantRegion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantRegion() {
        return guarantRegion;
    }

    /**
     * Sets the value of the guarantRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantRegion(JAXBElement<String> value) {
        this.guarantRegion = value;
    }

    /**
     * Gets the value of the guarantDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantDistrict() {
        return guarantDistrict;
    }

    /**
     * Sets the value of the guarantDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantDistrict(JAXBElement<String> value) {
        this.guarantDistrict = value;
    }

    /**
     * Gets the value of the guarantSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantSettlement() {
        return guarantSettlement;
    }

    /**
     * Sets the value of the guarantSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantSettlement(JAXBElement<String> value) {
        this.guarantSettlement = value;
    }

    /**
     * Gets the value of the guarantStreet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantStreet() {
        return guarantStreet;
    }

    /**
     * Sets the value of the guarantStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantStreet(JAXBElement<String> value) {
        this.guarantStreet = value;
    }

    /**
     * Gets the value of the guarantHouse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantHouse() {
        return guarantHouse;
    }

    /**
     * Sets the value of the guarantHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantHouse(JAXBElement<String> value) {
        this.guarantHouse = value;
    }

    /**
     * Gets the value of the guarantApp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuarantApp() {
        return guarantApp;
    }

    /**
     * Sets the value of the guarantApp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuarantApp(JAXBElement<String> value) {
        this.guarantApp = value;
    }

    /**
     * Gets the value of the guarantRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getGuarantRegDate() {
        return guarantRegDate;
    }

    /**
     * Sets the value of the guarantRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setGuarantRegDate(JAXBElement<XMLGregorianCalendar> value) {
        this.guarantRegDate = value;
    }

    /**
     * Gets the value of the confirmedProfits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfirmedProfits() {
        return confirmedProfits;
    }

    /**
     * Sets the value of the confirmedProfits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfirmedProfits(JAXBElement<String> value) {
        this.confirmedProfits = value;
    }

    /**
     * Gets the value of the basicProfits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBasicProfits() {
        return basicProfits;
    }

    /**
     * Sets the value of the basicProfits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBasicProfits(JAXBElement<String> value) {
        this.basicProfits = value;
    }

    /**
     * Gets the value of the extLoanCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtLoanCount() {
        return extLoanCount;
    }

    /**
     * Sets the value of the extLoanCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtLoanCount(JAXBElement<String> value) {
        this.extLoanCount = value;
    }

    /**
     * Gets the value of the extLoanCreditor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtLoanCreditor() {
        return extLoanCreditor;
    }

    /**
     * Sets the value of the extLoanCreditor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtLoanCreditor(JAXBElement<String> value) {
        this.extLoanCreditor = value;
    }

    /**
     * Gets the value of the extLoanStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExtLoanStartDate() {
        return extLoanStartDate;
    }

    /**
     * Sets the value of the extLoanStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExtLoanStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.extLoanStartDate = value;
    }

    /**
     * Gets the value of the carCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCarCount() {
        return carCount;
    }

    /**
     * Sets the value of the carCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCarCount(JAXBElement<String> value) {
        this.carCount = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCarModel(JAXBElement<String> value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the carNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCarNumber() {
        return carNumber;
    }

    /**
     * Sets the value of the carNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCarNumber(JAXBElement<String> value) {
        this.carNumber = value;
    }

    /**
     * Gets the value of the carYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCarYear() {
        return carYear;
    }

    /**
     * Sets the value of the carYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCarYear(JAXBElement<String> value) {
        this.carYear = value;
    }

    /**
     * Gets the value of the hasCarLoan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHasCarLoan() {
        return hasCarLoan;
    }

    /**
     * Sets the value of the hasCarLoan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasCarLoan(JAXBElement<String> value) {
        this.hasCarLoan = value;
    }

    /**
     * Gets the value of the hasMortgageLoan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHasMortgageLoan() {
        return hasMortgageLoan;
    }

    /**
     * Sets the value of the hasMortgageLoan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasMortgageLoan(JAXBElement<String> value) {
        this.hasMortgageLoan = value;
    }

    /**
     * Gets the value of the hasOtherLoan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHasOtherLoan() {
        return hasOtherLoan;
    }

    /**
     * Sets the value of the hasOtherLoan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasOtherLoan(JAXBElement<String> value) {
        this.hasOtherLoan = value;
    }

    /**
     * Gets the value of the totalLoansAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalLoansAmount() {
        return totalLoansAmount;
    }

    /**
     * Sets the value of the totalLoansAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalLoansAmount(JAXBElement<String> value) {
        this.totalLoansAmount = value;
    }

    /**
     * Gets the value of the totalLoansMonthPayment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalLoansMonthPayment() {
        return totalLoansMonthPayment;
    }

    /**
     * Sets the value of the totalLoansMonthPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalLoansMonthPayment(JAXBElement<String> value) {
        this.totalLoansMonthPayment = value;
    }

    /**
     * Gets the value of the totalLoansRemainBalance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalLoansRemainBalance() {
        return totalLoansRemainBalance;
    }

    /**
     * Sets the value of the totalLoansRemainBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalLoansRemainBalance(JAXBElement<String> value) {
        this.totalLoansRemainBalance = value;
    }

}
