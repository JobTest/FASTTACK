package com.cts.fasttack.bank.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class BankClientRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.cardTokenized").routeId("cardTokenized")
                .process("cardTokenizedProcessor");

        from("jms:queue:FASTTACK.MDES.confirmProvisioning")
                .routeId("confirmProvisioningMdes")
                .process("confirmProvisioningProcessor");

        from("jms:queue:FASTTACK.MDES.customerIdentifier")
                .routeId("getCustomerIDRouteMdes")
                .process("getCustomerIDProcessor");

        from("jms:queue:FASTTACK.CORE.sendOtp")
                .routeId("sendOtpRoute")
                .process("sendOtpProcessor");

        from("jms:queue:FASTTACK.CORE.customerIdentifier")
                .routeId("getCustomerIDRouteCore")
                .process("getCustomerIDProcessor");

        from("jms:queue:FASTTACK.CORE.tokenCreateNotification").routeId("tokenCreateNotificationBank")
                .process("tokenCreateNotificationBankProcessor");

        from("jms:queue:FASTTACK.VTS.getCardholderVerificationMethods")
                .routeId("getCardholderVerificationMethods")
                .process("getCardholderVerificationMethodsProcessor");

        from("jms:queue:FASTTACK.VTS.confirmProvisioning")
                .routeId("confirmProvisioningVts")
                .process("confirmProvisioningProcessor");

        from("jms:queue:FASTTACK.CORE.getCardInfoShort")
                .routeId("getCardInfoShort")
                .process("getCardInfoShortProcessor");

        from("jms:queue:FASTTACK.CORE.notifyTokenUpdated")
                .routeId("notifyTokenUpdatedCore")
                .process("notifyTokenUpdatedBankClientProcessor");

        from("jms:queue:FASTTACK.CORE.searchContragent2")
                .routeId("searchContragent2")
                .process("searchContragent2Processor");

        from("jms:queue:FASTTACK.BANK.sendNotificationToCustomer")
                .routeId("sendNotificationToCustomer")
                .process("sendNotificationToCustomerProcessor");

        from("jms:queue:FASTTACK.BANK.authenticate")
                .routeId("authenticate")
                .process("authenticateProcessor");

        from("jms:queue:FASTTACK.BANK.getUserRoles")
                .routeId("getUserRoles")
                .process("getUserRolesProcessor");
    }
}
