package com.cts.fasttack.admin.web.jms.processor;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.security.data.ReAuthenticationMessage;
import com.cts.fasttack.admin.web.security.service.UserAuthoritiesHolder;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

@Component
public class ReAuthProcessor extends AbstractCamelProcessor<ReAuthenticationMessage, Void> {

    @Autowired
    private UserAuthoritiesHolder userAuthoritiesHolder;

    @Override
    public void process(Exchange exchange) throws Exception {
        super.execute(exchange, ReAuthenticationMessage.class, request -> {
            if (StringUtils.isNotBlank(request.getUserId())) {
                userAuthoritiesHolder.discardAuthoritiesByUser(request.getUserId());
            }
            if (StringUtils.isNotBlank(request.getRoleId())) {
                userAuthoritiesHolder.discardAuthoritiesByRole(request.getRoleId());
            }
            return null;
        });
    }
}
