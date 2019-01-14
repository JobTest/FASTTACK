package com.cts.fasttack.bank.client.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class BankClientRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.cardTokenized?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS).routeId("cardTokenized")
                .process("cardTokenizedProcessor");

        from("jms:queue:FASTTACK.MDES.confirmProvisioning?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("confirmProvisioningMdes")
                .process("confirmProvisioningProcessor");

        from("jms:queue:FASTTACK.MDES.customerIdentifier?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("getCustomerIDRouteMdes")
                .process("getCustomerIDProcessor");

        from("jms:queue:FASTTACK.CORE.sendOtp?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("sendOtpRoute")
                .process("sendOtpProcessor");

        from("jms:queue:FASTTACK.CORE.customerIdentifier?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("getCustomerIDRouteCore")
                .process("getCustomerIDProcessor");

        from("jms:queue:FASTTACK.CORE.tokenCreateNotification?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS).routeId("tokenCreateNotificationBank")
                .process("tokenCreateNotificationBankProcessor");

        from("jms:queue:FASTTACK.VTS.getCardholderVerificationMethods?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("getCardholderVerificationMethods")
                .process("getCardholderVerificationMethodsProcessor");

        from("jms:queue:FASTTACK.VTS.confirmProvisioning?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("confirmProvisioningVts")
                .process("confirmProvisioningProcessor");

        from("jms:queue:FASTTACK.CORE.getCardInfoShort?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("getCardInfoShort")
                .process("getCardInfoShortProcessor");

        from("jms:queue:FASTTACK.CORE.notifyTokenUpdated?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("notifyTokenUpdatedCore")
                .process("notifyTokenUpdatedBankClientProcessor");

        from("jms:queue:FASTTACK.CORE.searchContragent2?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("searchContragent2")
                .process("searchContragent2Processor");

        from("jms:queue:FASTTACK.BANK.sendNotificationToCustomer?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("sendNotificationToCustomer")
                .process("sendNotificationToCustomerProcessor");

        from("jms:queue:FASTTACK.BANK.authenticate?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("authenticate")
                .process("authenticateProcessor");

        from("jms:queue:FASTTACK.BANK.getUserRoles?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("getUserRoles")
                .process("getUserRolesProcessor");
    }
}
