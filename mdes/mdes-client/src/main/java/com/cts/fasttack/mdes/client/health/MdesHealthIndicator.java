package com.cts.fasttack.mdes.client.health;

import com.cts.fasttack.mdes.client.dto.SystemStatusResponseDto;
import com.cts.fasttack.mdes.client.rest.MdesRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class MdesHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    private MdesRestClient mdesRestClient;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        SystemStatusResponseDto response = mdesRestClient.systemStatus();
        builder.withDetail("response", response).up();
    }
}
