package com.cts.fasttack.jms.dto;

/**
 * @author a.lipavets
 */
public class JmsSearchContragent2Dto {

    private String contragentId;

    private String taxId;

    private String docSr;

    private String docNo;

    private String sName;

    private String name;

    private String contragentCategory;

    public String getContragentId() {
        return contragentId;
    }

    public void setContragentId(String contragentId) {
        this.contragentId = contragentId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getDocSr() {
        return docSr;
    }

    public void setDocSr(String docSr) {
        this.docSr = docSr;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContragentCategory() {
        return contragentCategory;
    }

    public void setContragentCategory(String contragentCategory) {
        this.contragentCategory = contragentCategory;
    }
}
