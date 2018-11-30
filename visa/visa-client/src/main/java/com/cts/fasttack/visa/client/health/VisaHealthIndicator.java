package com.cts.fasttack.visa.client.health;

import com.cts.fasttack.visa.client.dto.PingRequestDto;
import com.cts.fasttack.visa.client.dto.PingResponseDto;
import com.cts.fasttack.visa.client.service.VisaRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Application health indicator to check if Visa is alive
 * @author Anton Leliuk
 */
@Component
public class VisaHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    private VisaRestClient visaRestClient;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        PingRequestDto request = new PingRequestDto();
        request.setRequestID(UUID.randomUUID().toString().replaceAll("-", ""));
        PingResponseDto response = visaRestClient.ping(request);
        builder.withDetail("responseCode", response.getResponseCode()).up();
    }

}
