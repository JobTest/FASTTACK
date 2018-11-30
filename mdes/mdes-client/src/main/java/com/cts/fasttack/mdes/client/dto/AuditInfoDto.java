package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dmitry Koval
 */
@JsonRootName("AuditInfo")
public class AuditInfoDto {

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("Organization")
    private String organization;

    @JsonProperty("Phone")
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
