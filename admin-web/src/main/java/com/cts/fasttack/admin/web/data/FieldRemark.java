package com.cts.fasttack.admin.web.data;

/**
 * Field remark violation
 */
public class FieldRemark {

    private String field;

    private String remark;

    public FieldRemark(String field, String remark) {
        this.field = field;
        this.remark = remark;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
