package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.dto.MessageHistoryDto;
import com.cts.fasttack.logging.interceptor.data.AuthorizeTestObject;
import com.cts.fasttack.logging.interceptor.data.AuthorizeTestService;
import com.cts.fasttack.logging.interceptor.data.DeviceInfoTestObject;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.logging.service.MessageHistoryService;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MessageHistoryInterceptorTest {

    @InjectMocks
    private MessageHistoryInterceptor messageHistoryInterceptor = new MessageHistoryInterceptor();

    @Mock
    private MessageHistoryService messageHistoryService;

    @Mock
    private MethodInvocation invocation;

    @Mock
    private CallingContext callingContext;

    private AuthorizeTestService authorizeTestService = new AuthorizeTestService();

    private AuthorizeTestObject phone1 = new AuthorizeTestObject("111000", new DeviceInfoTestObject("My Phone 1", "1F1D11", "ANDROID", "4.1", new String[]{"NFC"}), "panInternalId", "panInternalGuid","1000100010001000", "L");
    private AuthorizeTestObject phone2 = new AuthorizeTestObject("101010", new DeviceInfoTestObject("My Phone 2", "2F2D22", "ANDROID", "5.1", new String[]{"ABC"}));
    private AuthorizeTestObject phone3 = new AuthorizeTestObject("000111", new DeviceInfoTestObject("My Phone 3", "3F3D33", "IOS", "10", new String[]{"ABC", "NFC"}));

    @Test
    public void invokeTest() throws Throwable {
        Method method1 = AuthorizeTestService.class.getMethod("authenticate", AuthorizeTestObject.class);
        Method method2 = AuthorizeTestService.class.getMethod("verify", AuthorizeTestObject.class);
        Method method3 = AuthorizeTestService.class.getMethod("register", AuthorizeTestObject.class);

        Mockito.doAnswer(i -> {
            MessageHistoryDto dto = (MessageHistoryDto) i.getArguments()[0];
            assertEquals(1L, dto.getId().longValue());
            assertNull(dto.getParentId());
            assertEquals("111000", dto.getTokenId());
            assertEquals("MDES", dto.getConnectorClient());
            assertEquals("AUTHENTICATE", dto.getMsgType());

            assertEquals("panInternalId", dto.getPanInternalId());
            assertEquals("panInternalGuid", dto.getPanInternalGuid());
            assertEquals(StringUtil.displayPanOrToken("1000100010001000"), dto.getMaskedPan());
            assertEquals("L", dto.getPanSource());
            assertEquals("01", dto.getErrorCode());
            assertEquals("DECLINE",dto.getDecision());
            assertEquals("R", dto.getCvcResp());

            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateIn()));
            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateOut()));

            String device = dto.getMsgRawIn().substring(dto.getMsgRawIn().indexOf('{'), dto.getMsgRawIn().lastIndexOf('}') + 1);
            assertEquals("{\"deviceName\":\"My Phone 1\",\"serialNumber\":\"1F1D11\",\"osName\":\"ANDROID\",\"osVersion\":\"4.1\",\"paymentTypes\":[\"NFC\"]}", device);

            String activationMethods = dto.getMsgRawOut().substring(dto.getMsgRawOut().indexOf('{'), dto.getMsgRawOut().lastIndexOf('}') + 1);
            assertEquals("{\"errorCode\":[\"01\"],\"decision\":[\"DECLINE\"],\"activationMethods\":[\"TEXT_TO_CARDHOLDER_NUMBER\",\"CARDHOLDER_TO_USE_MOBILE_APP\",\"CARDHOLDER_TO_CALL_AUTOMATED_NUMBER\"],\"cvcResp\":[\"R\"]}", activationMethods);
            return dto;
        }).when(messageHistoryService).update(Mockito.any(MessageHistoryDto.class));
        invokeMethod(1L, method1, phone1);

        assertNull(MessageHistoryInterceptor.PARENT_ID.get());

        MessageHistoryInterceptor.PARENT_ID.set(1L);

        Mockito.doAnswer(i -> {
            MessageHistoryDto dto = (MessageHistoryDto) i.getArguments()[0];
            assertEquals(2L, dto.getId().longValue());
            assertEquals(1L, dto.getParentId().longValue());
            assertEquals("101010", dto.getTokenId());
            assertEquals("BANK", dto.getConnectorClient());
            assertEquals("VERIFY", dto.getMsgType());
            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateIn()));
            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateOut()));

            String device = dto.getMsgRawIn().substring(dto.getMsgRawIn().indexOf('{'), dto.getMsgRawIn().lastIndexOf('}') + 1);
            assertEquals("{\"deviceName\":\"My Phone 2\",\"serialNumber\":\"2F2D22\",\"osName\":\"ANDROID\",\"osVersion\":\"5.1\",\"paymentTypes\":[\"ABC\"]}", device);
            return dto;
        }).when(messageHistoryService).update(Mockito.any(MessageHistoryDto.class));
        invokeMethod(2L, method2, phone2);

        assertNull(MessageHistoryInterceptor.PARENT_ID.get());

        MessageHistoryInterceptor.PARENT_ID.set(1L);

        Mockito.doAnswer(i -> {
            MessageHistoryDto dto = (MessageHistoryDto) i.getArguments()[0];
            assertEquals(3L, dto.getId().longValue());
            assertEquals(1L, dto.getParentId().longValue());
            assertEquals("000111", dto.getTokenId());
            assertEquals("BANK", dto.getConnectorClient());
            assertEquals("REGISTER", dto.getMsgType());
            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateIn()));
            assertTrue(DateUtils.isSameDay(new Date(), dto.getMsgDateOut()));

            String device = dto.getMsgRawIn().substring(dto.getMsgRawIn().indexOf('{'), dto.getMsgRawIn().lastIndexOf('}') + 1);
            assertEquals("{\"deviceName\":\"My Phone 3\",\"serialNumber\":\"3F3D33\",\"osName\":\"IOS\",\"osVersion\":\"10\",\"paymentTypes\":[\"ABC\",\"NFC\"]}", device);

            String deviceId = dto.getMsgRawOut().substring(dto.getMsgRawOut().indexOf('{'), dto.getMsgRawOut().lastIndexOf('}') + 1);
            assertEquals("{\"deviceId\":\"000111\",\"activationId\":\"21891295\"}", deviceId);
            return dto;
        }).when(messageHistoryService).update(Mockito.any(MessageHistoryDto.class));
        invokeMethod(3L, method3, phone3);
    }

    @Test
    public void invokeVoidTest() throws Throwable {
        Mockito.when(messageHistoryService.update(Mockito.any(MessageHistoryDto.class))).thenReturn(null);
        Object o = invokeMethod(1L, AuthorizeTestService.class.getMethod("voidTest", AuthorizeTestObject.class), phone1);
        assertNull(o);
    }

    @Test
    public void proceedExceptionTest() throws Throwable {
        try {
            invokeMethod(1L, AuthorizeTestService.class.getMethod("proceedExceptionTest", AuthorizeTestObject.class), phone1);
        } catch (InvocationTargetException expected) {
            assertNull(MessageHistoryInterceptor.PARENT_ID.get());
        }
    }

    private Object invokeMethod(Long messageId, Method method, Object ... args) throws Throwable {
        Mockito.when(invocation.getMethod()).thenReturn(method);
        Mockito.when(invocation.getThis()).thenReturn(authorizeTestService);
        Mockito.when(invocation.getArguments()).thenReturn(args);
        Mockito.when(callingContext.getOriginator()).thenReturn("BANK");

        Mockito.doAnswer(i -> method.invoke(authorizeTestService, args)).when(invocation).proceed();

        Mockito.doAnswer(i -> {
            MessageHistoryDto dto = (MessageHistoryDto) i.getArguments()[0];
            dto.setId(messageId);
            return dto;

        }).when(messageHistoryService).save(Mockito.any(MessageHistoryDto.class));

        return messageHistoryInterceptor.invoke(invocation);
    }

}
