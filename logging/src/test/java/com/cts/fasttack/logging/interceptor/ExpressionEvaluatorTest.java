package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.Method;

import com.cts.fasttack.common.core.util.StringUtil;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.EvaluationContext;

import com.cts.fasttack.logging.interceptor.data.AuthorizeTestObject;
import com.cts.fasttack.logging.interceptor.data.AuthorizeTestService;
import com.cts.fasttack.logging.interceptor.data.DeviceInfoTestObject;

import static org.junit.Assert.assertEquals;

public class ExpressionEvaluatorTest {
    private DeviceInfoTestObject deviceInfo = new DeviceInfoTestObject("My Phone", "3F4D62", "ANDROID", "4.4", new String[]{"NFC"});

    private AuthorizeTestObject authorize = new AuthorizeTestObject("111000", deviceInfo, "panInternalId", "panInternalGuid", "1000100010001000", "L");

    private AuthorizeTestService service = new AuthorizeTestService();

    @Test
    public void evaluateExpressionTest() throws Throwable {
        Method m = AuthorizeTestService.class.getMethod("authenticate", AuthorizeTestObject.class);
        MessageHistoryOperation a = AnnotationUtils.getAnnotation(m, MessageHistoryOperation.class);
        EvaluationContext context = ExpressionEvaluator.INSTANCE.createEvaluationContext(m, new Object[] {authorize}, service.authenticate(authorize), String.class);
        assertEquals("MDES", a.connectorClient());
        assertEquals("AUTHENTICATE", a.msgType());
        assertEquals("111000", ExpressionEvaluator.INSTANCE.evaluateExpression(a.tokenId(), m, context));
        assertEquals(deviceInfo, ExpressionEvaluator.INSTANCE.evaluateExpression(a.rawIn(), m, context));
        assertEquals("panInternalId", ExpressionEvaluator.INSTANCE.evaluateExpression(a.panInternalId(), m, context));
        assertEquals("panInternalGuid", ExpressionEvaluator.INSTANCE.evaluateExpression(a.panInternalGuid(), m, context));
        assertEquals(StringUtil.displayPanOrToken("1000100010001000"), ExpressionEvaluator.INSTANCE.evaluateExpression(a.maskedPan(), m, context));
        assertEquals("L", ExpressionEvaluator.INSTANCE.evaluateExpression(a.panSource(), m, context));
        assertEquals("01", ExpressionEvaluator.INSTANCE.evaluateExpression(a.errorCode(), m, context));
        assertEquals("DECLINE",ExpressionEvaluator.INSTANCE.evaluateExpression(a.decision(), m, context));
        assertEquals("R", ExpressionEvaluator.INSTANCE.evaluateExpression(a.cvcResp(), m, context));
    }

    @Test(expected = RuntimeException.class)
    public void evaluateExpressionTestFail() throws Throwable {
        Method m = AuthorizeTestService.class.getMethod("fail", AuthorizeTestObject.class);
        MessageHistoryOperation a = AnnotationUtils.getAnnotation(m, MessageHistoryOperation.class);
        EvaluationContext context = ExpressionEvaluator.INSTANCE.createEvaluationContext(m, new Object[] {authorize}, null, String.class);

        ExpressionEvaluator.INSTANCE.evaluateExpression(a.tokenId(), m, context);
    }
}
