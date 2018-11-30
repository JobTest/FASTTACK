package com.cts.fasttack.admin.web.data.dto;

import java.util.Map;

/**
 * @author Dmitry Koval
 */
public class ModuleResponseDto {

    private String name;

    private String status;

    private String appGroupName;

    private Map<?,?> response;

    public ModuleResponseDto(String name, String status, String appGroupName, Map<?,?> response) {
        this.name = name;
        this.status = status;
        this.appGroupName = appGroupName;
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<?,?> getResponse() {
        return response;
    }

    public void setResponse(Map<?,?> response) {
        this.response = response;
    }

    public String getAppGroupName() {
        return appGroupName;
    }

    public void setAppGroupName(String appGroupName) {
        this.appGroupName = appGroupName;
    }
}
