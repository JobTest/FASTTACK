package com.cts.fasttack.logging.interceptor.data;

import java.util.HashMap;
import java.util.Map;

import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

public class AuthorizeTestService {

    @MessageHistoryOperation(connectorClient = "MDES", msgType = "AUTHENTICATE", tokenId = "#testObject.tokenRequestorId", rawIn = "#testObject.deviceInfo",
            panInternalId = "#testObject.panInternalId", panInternalGuid = "#testObject.panInternalGuid", decision = "#result.get(\"decision\")[0]", errorCode = "#result.get(\"errorCode\")[0]",
            cvcResp = "#result.get(\"cvcResp\")[0]", panSource = "#testObject.panSource", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#testObject.pan)")
    public Object authenticate(AuthorizeTestObject testObject) {
        Map<String, String[]> response = new HashMap<>(1);
        response.put("activationMethods", new String[]{
                "TEXT_TO_CARDHOLDER_NUMBER",
                "CARDHOLDER_TO_USE_MOBILE_APP",
                "CARDHOLDER_TO_CALL_AUTOMATED_NUMBER"
        });
        response.put("errorCode", new String[]{"01"});
        response.put("decision", new String[]{"DECLINE"});
        response.put("cvcResp", new String[]{"R"});
        return response;
    }

    @MessageHistoryOperation(connectorClient = "BANK", tokenId = "#testObject.tokenRequestorId", rawIn = "#testObject.deviceInfo")
    public Object verify(AuthorizeTestObject testObject) {
        return "OK";
    }

    @MessageHistoryOperation(connectorClient = "BANK", tokenId = "#testObject.tokenRequestorId", rawIn = "#testObject.deviceInfo")
    public Object register(AuthorizeTestObject testObject) {
        Map<String, String> response = new HashMap<>(2);
        response.put("deviceId", "000111");
        response.put("activationId", "21891295");
        return response;
    }

    @MessageHistoryOperation(tokenId = "#testObject.tokenRequestorId", rawIn = "#testObject")
    public void voidTest(AuthorizeTestObject testObject) {

    }

    @MessageHistoryOperation(tokenId = "#testObject.tokenRequestorId", rawIn = "#testObject")
    public Object proceedExceptionTest(AuthorizeTestObject testObject) {
        throw new IllegalStateException();
    }

    @MessageHistoryOperation(connectorClient = "BANK", msgType = "FAIL", tokenId = "#otherObject.tokenRequestorId", rawIn = "#testObject.deviceInfo")
    public Object fail(AuthorizeTestObject testObject) {
        return testObject.getTokenRequestorId();
    }
}
