package com.cts.fasttack.admin.web.data.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Koval
 */
public class ModuleHealthResponseDto {

    private List<ModuleResponseDto> objects = new ArrayList<>();

    public List<ModuleResponseDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ModuleResponseDto> objects) {
        this.objects = objects;
    }
}
