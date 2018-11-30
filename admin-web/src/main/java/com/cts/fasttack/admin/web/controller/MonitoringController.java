package com.cts.fasttack.admin.web.controller;

import com.cts.fasttack.admin.web.data.dto.ModuleHealthResponseDto;
import com.cts.fasttack.admin.web.data.dto.ModuleResponseDto;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.netflix.appinfo.InstanceInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@PreAuthorize("isAuthenticated()")
public class MonitoringController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private Logger log = LogManager.getLogger(MonitoringController.class);

    @GetMapping("monitoring.htm")
    @PreAuthorize("@aclMonitoring.canView")
    public String monitoring() {
        return "monitoring";
    }

    @PreAuthorize("@aclMonitoring.isCanView()")
    @GetMapping("/systemStatus")
    @ResponseBody
    public ModuleHealthResponseDto health() throws IOException {
        ModuleHealthResponseDto responseDto = new ModuleHealthResponseDto();
        RestTemplate restTemplate = new RestTemplate();
        discoveryClient.getServices().parallelStream().forEach(s -> {
            InstanceInfo instance = ((EurekaDiscoveryClient.EurekaServiceInstance) discoveryClient.getInstances(s).get(0)).getInstanceInfo();
            Map<?,?> healthResponse;
            try {
                String url = instance.getHealthCheckUrl().replace(instance.getHostName(), "localhost");
                log.warn("HealthCheckUrl: " + instance.getHealthCheckUrl()+ "; SecureHealthCheckUrl: " + instance.getSecureHealthCheckUrl());
                healthResponse = restTemplate.getForObject(instance.getSecureHealthCheckUrl() != null ? url.replace(instance.getAppName().toLowerCase(), instance.getSecureHealthCheckUrl()) : url, Map.class);
            } catch (RestClientResponseException e) {
                healthResponse = JsonUtil.fromJson(e.getResponseBodyAsString(), HashMap.class);
            }
            responseDto.getObjects().add(new ModuleResponseDto(instance.getAppName(),
                    healthResponse.get("status").toString(), instance.getAppGroupName(), healthResponse));
        });
        return responseDto;
    }
}
