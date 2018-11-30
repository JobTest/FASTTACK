package com.cts.fasttack.admin.web.converter;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.cts.fasttack.admin.web.data.dto.MessageHistoryViewableDto;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for checking {@link MessageHistoryDtoToMessageHistoryViewableDtoConverter}
 *
 * @author v.semerkov
 */
@RunWith(value = Parameterized.class)
public class MessageHistoryDtoToMessageHistoryViewableDtoConverterTest {

    private static MessageHistoryDtoToMessageHistoryViewableDtoConverter messageHistoryDtoToMessageHistoryViewableDtoConverter = new MessageHistoryDtoToMessageHistoryViewableDtoConverter();

    private String msgRaw;
    private String expectedResult;

    public MessageHistoryDtoToMessageHistoryViewableDtoConverterTest(String msgRaw, String expectedResult) {
        this.msgRaw = msgRaw;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                // 0 - payload is JSON
                {
                        "ID: 65c22339-a68c-408b-bdb8-aad5ff008c2a\n" +
                                "Address: http://localhost:8080/fasttack-bank-server/getTokenByWalletId\n" +
                                "Http-Method: POST\n" +
                                "Content-Type: text/xml\n" +
                                "Payload: {\"requestID\":\"50a1e2ff972b4d01\",\"clientWalletAccountId\":\"1b24f24a24ba98e27d43e345b532a245e4723d7a9c4f624e\",\"clientWalletProvider\":\"22345678910\"}",

                        "<pre>ID: 65c22339-a68c-408b-bdb8-aad5ff008c2a<br/>" +
                                "Address: http://localhost:8080/fasttack-bank-server/getTokenByWalletId<br/>" +
                                "Http-Method: POST<br/>" +
                                "Content-Type: text/xml<br/>" +
                                "Payload: {<br/>  \"requestID\" : \"50a1e2ff972b4d01\",<br/>  \"clientWalletAccountId\" : \"1b24f24a24ba98e27d43e345b532a245e4723d7a9c4f624e\",<br/>  \"clientWalletProvider\" : \"22345678910\"<br/>}</pre>"
                },

                // 1 - payload is XML with line separators
                {
                        "ID: db9e5bae-eacc-4d39-a6ca-0db0b89afac8\n" +
                                "Address: http://localhost:8080/fasttack-bank-server/getTokenByWalletId\n" +
                                "Http-Method: POST\n" +
                                "Content-Type: application/xml\n" +
                                "Payload: <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<GetTokenByWalletIdRequest>\n" +
                                "  <clientWalletAccountId>uGrOxzwW2ghVx1nuoC2Fnwko</clientWalletAccountId>\n" +
                                "  <clientWalletProvider>40010075001</clientWalletProvider>\n" +
                                "  <requestID>50a1e2ff972b4d01</requestID>\n" +
                                "</GetTokenByWalletIdRequest>\n",

                        "<pre>ID: db9e5bae-eacc-4d39-a6ca-0db0b89afac8<br/>" +
                                "Address: http://localhost:8080/fasttack-bank-server/getTokenByWalletId<br/>" +
                                "Http-Method: POST<br/>" +
                                "Content-Type: application/xml<br/>" +
                                "Payload: &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;" +
                                "&lt;GetTokenByWalletIdRequest&gt;<br/>" +
                                "  &lt;clientWalletAccountId&gt;uGrOxzwW2ghVx1nuoC2Fnwko&lt;/clientWalletAccountId&gt;<br/>" +
                                "  &lt;clientWalletProvider&gt;40010075001&lt;/clientWalletProvider&gt;<br/>" +
                                "  &lt;requestID&gt;50a1e2ff972b4d01&lt;/requestID&gt;<br/>" +
                                "&lt;/GetTokenByWalletIdRequest&gt;<br/></pre>"
                },

                // 2 - payload is XML without line separators
                {
                        "ID: 4a2c316d-3fa5-4743-874d-d303a27f26ba\n" +
                                "Response-Code: 200\n" +
                                "Messages: OK\n" +
                                "Payload: <?xml version=\"1.0\" encoding=\"UTF-8\"?><response><errorCode>INVALID_JSON</errorCode><errorDescription>Invalid JSON</errorDescription></response>",

                        "<pre>ID: 4a2c316d-3fa5-4743-874d-d303a27f26ba<br/>" +
                                "Response-Code: 200<br/>" +
                                "Messages: OK<br/>" +
                                "Payload: &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&lt;response&gt;<br/>    &lt;errorCode&gt;INVALID_JSON&lt;/errorCode&gt;<br/>    &lt;errorDescription&gt;Invalid JSON&lt;/errorDescription&gt;<br/>&lt;/response&gt;<br/></pre>"
                },

                // 3 - payload is error message
                {
                        "ID: db9e5bae-eacc-4d39-a6ca-0db0b89afac8\n" +
                                "Response-Code: 400\n" +
                                "Messages: Bad Request\n" +
                                "Payload: Validation failed for argument at index 0 in method: public com.cts.fasttack.bank.server.dto.GetTokenByWalletIdResponseDto com.cts.fasttack.bank.server.controller.BankRestController.getTokenByWalletId(com.cts.fasttack.bank.server.dto.GetTokenByWalletIdRequestDto), with 1 error(s): [Field error in object 'getTokenByWalletIdRequestDto' on field 'requestId': rejected value [null]; codes [NotEmpty.getTokenByWalletIdRequestDto.requestId,NotEmpty.requestId,NotEmpty.java.lang.String,NotEmpty]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [getTokenByWalletIdRequestDto.requestId,requestId]; arguments []; default message [requestId]]; default message [MISSING_REQUIRED_FIELD]] ",

                        "<pre>ID: db9e5bae-eacc-4d39-a6ca-0db0b89afac8<br/>" +
                                "Response-Code: 400<br/>" +
                                "Messages: Bad Request<br/>" +
                                "Payload: Validation failed for argument at index 0 in method: public com.cts.fasttack.bank.server.dto.GetTokenByWalletIdResponseDto com.cts.fasttack.bank.server.controller.BankRestController.getTokenByWalletId(com.cts.fasttack.bank.server.dto.GetTokenByWalletIdRequestDto), with 1 error(s): [Field error in object 'getTokenByWalletIdRequestDto' on field 'requestId': rejected value [null]; codes [NotEmpty.getTokenByWalletIdRequestDto.requestId,NotEmpty.requestId,NotEmpty.java.lang.String,NotEmpty]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [getTokenByWalletIdRequestDto.requestId,requestId]; arguments []; default message [requestId]]; default message [MISSING_REQUIRED_FIELD]] </pre>"
                },

                // 4 - payload is absent
                {
                        "ID: 4a2c316d-3fa5-4743-874d-d303a27f26ba\n" +
                                "Address: http://localhost:8080/fasttack-mdes-server/getCustomerIdentifier\n" +
                                "Http-Method: GET\n" +
                                "Content-Type: null",

                        "<pre>ID: 4a2c316d-3fa5-4743-874d-d303a27f26ba<br/>" +
                                "Address: http://localhost:8080/fasttack-mdes-server/getCustomerIdentifier<br/>" +
                                "Http-Method: GET<br/>" +
                                "Content-Type: null</pre>"
                },

                // 5 - payload is empty
                {
                        "",

                        "<pre></pre>"
                },

                // 6 - payload is null
                {
                        null,

                        "<pre>null</pre>"
                }
        });
    }

    @Test
    public void test() {
        MessageHistoryDto source = new MessageHistoryDto();
        source.setMsgRawIn(msgRaw);
        source.setMsgRawOut(msgRaw);

        MessageHistoryViewableDto result = messageHistoryDtoToMessageHistoryViewableDtoConverter.convert(source);

        assertEquals(result.getMsgRawIn(), expectedResult);
        assertEquals(result.getMsgRawOut(), expectedResult);
    }
}
