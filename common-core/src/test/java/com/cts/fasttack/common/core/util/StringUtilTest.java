package com.cts.fasttack.common.core.util;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Anton Leliuk
 */
public class StringUtilTest {

    @Test
    public void appendSymbolSequenceToBytesTest() {
        // Test 1 (source length 41)
        byte[] b1 = "{\"UserId\":\"testId\",\"Password\":\"test1234\"}".getBytes(StandardCharsets.UTF_8);
        byte[] res1 = StringUtil.appendSymbolSequenceToBytes(b1, 48, ' ', true);

        assertEquals(48, res1.length);
        assertEquals("       {\"UserId\":\"testId\",\"Password\":\"test1234\"}", new String(res1));

        // Test 2 (source length 38, bytes length 49)
        byte[] b2 = "{\"UserId\":\"логин\",\"Password\":\"пароль\"}".getBytes(StandardCharsets.UTF_8);
        byte[] res2 = StringUtil.appendSymbolSequenceToBytes(b2, 58, ' ', true);

        assertEquals(58, res2.length);
        assertEquals("         {\"UserId\":\"логин\",\"Password\":\"пароль\"}", new String(res2, StandardCharsets.UTF_8));

        // Test 3 (source length 9)
        byte[] b3 = "Test text".getBytes(StandardCharsets.UTF_8);
        byte[] res3 = StringUtil.appendSymbolSequenceToBytes(b3, 16, ' ', true);

        assertEquals(16, res3.length);
        assertEquals("       Test text", new String(res3));

        // Test 4 (source length 9)
        byte[] b4 = "Test text".getBytes(StandardCharsets.UTF_8);
        byte[] res4 = StringUtil.appendSymbolSequenceToBytes(b4, 5, ' ', true);

        assertEquals(9, res4.length);
        assertEquals("Test text", new String(res4));
    }

    @Test
    public void sensitiveFieldsHidingTest() {
        String text = "{\"UserId\":\"test111\",\"Password\":\"12345678\"}";
        assertEquals("{\"UserId\":\"test111\",\"Password\":\"******\"}", StringUtil.sensitiveFieldsHiding(text));

        text = "{\"UserId\":\"test111\",\"Password\":\"12345678\",\"ActivationCode\":\"12345678\",\"mobilePin\":\"12345678\",\"MobilPin\":\"12345678\",\"cardNumber\":\"12345678\"}"; //fixme old
//        assertEquals("{\"UserId\":\"test111\",\"Password\":\"******\",\"ActivationCode\":\"******\",\"mobilePin\":\"******\",\"MobilPin\":\"******\",\"cardNumber\":\"******\"}", StringUtil.sensitiveFieldsHiding(text)); //todo old
        text = "{\"UserId\":\"test111\",\"Password\":\"12345678\",\"ActivationCode\":\"12345678\",\"mobilePin\":\"12345678\",\"MobilPin\":\"12345678\",\"cardNumber\":\"4999999999990011\"}";
        assertEquals("{\"UserId\":\"test111\",\"Password\":\"******\",\"ActivationCode\":\"******\",\"mobilePin\":\"******\",\"MobilPin\":\"******\",\"cardNumber\":\"499999******0011\"}", StringUtil.sensitiveFieldsHiding(text));

        text = "{\"UserId\":\"test\",\"CVV2\":\"685\"}";
        assertEquals("{\"UserId\":\"test\",\"CVV2\":\"******\"}", StringUtil.sensitiveFieldsHiding(text));

        text = "{\"UserId\":\"test\",\"PAN\":\"125342572285956945\"}";
//        assertEquals("{\"UserId\":\"test\",\"PAN\":\"******\"}", StringUtil.sensitiveFieldsHiding(text)); //todo old
        assertEquals("{\"UserId\":\"test\",\"PAN\":\"125342******6945\"}", StringUtil.sensitiveFieldsHiding(text));

        text = "{\"TokenActivateRequest\":{\"CommentText\":\"xxx\",\"ReasonCode\":\"C\",\"AccountPan\":\"1234567890123456\",\"PaymentAppInstanceId\":\"E029361010194\",\"AuditInfo\":{\"UserId\":\"admin@cts.com\",\"UserName\":\"Admin\",\"Organization\":\"BANK ALFA\"}}}";
        assertEquals("{\"TokenActivateRequest\":{\"CommentText\":\"xxx\",\"ReasonCode\":\"C\",\"AccountPan\":\"123456******3456\",\"PaymentAppInstanceId\":\"E029361010194\",\"AuditInfo\":{\"UserId\":\"admin@cts.com\",\"UserName\":\"Admin\",\"Organization\":\"BANK ALFA\"}}}", StringUtil.sensitiveFieldsHiding(text));
    }

    @Test
    public void sensitiveFieldsFromXmlHidingTest() {
        String text = "<ns2:ResetMPAInputData xmlns:ns2=\"http://hce.everest.com/2015/04\" xmlns:ns3=\"http://schemas.datacontract.org/2004/07/MPTSAESService\" xmlns:ns4=\"http://schemas.microsoft.com/2003/10/Serialization/\"><ns2:CMSMPA_ID>0000000000000000000000000000000000000000000000000000000000002430</ns2:CMSMPA_ID><ns2:WSPPASSPHRASE>Passw0rd</ns2:WSPPASSPHRASE><ns2:WSPUSERIDENTIFIER>usr010</ns2:WSPUSERIDENTIFIER></ns2:ResetMPAInputData>";
        assertEquals("<ns2:ResetMPAInputData xmlns:ns2=\"http://hce.everest.com/2015/04\" xmlns:ns3=\"http://schemas.datacontract.org/2004/07/MPTSAESService\" xmlns:ns4=\"http://schemas.microsoft.com/2003/10/Serialization/\"><ns2:CMSMPA_ID>0000000000000000000000000000000000000000000000000000000000002430</ns2:CMSMPA_ID><ns2:WSPPASSPHRASE>******</ns2:WSPPASSPHRASE><ns2:WSPUSERIDENTIFIER>usr010</ns2:WSPUSERIDENTIFIER></ns2:ResetMPAInputData>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<PassPhrase>secret</PassPhrase>";
        assertEquals("<PassPhrase>******</PassPhrase>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<CVV2>123</CVV2>";
        assertEquals("<CVV2>******</CVV2>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<OTP>987654</OTP>";
        assertEquals("<OTP>******</OTP>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<WSPPASSPHRASE>secret_password</WSPPASSPHRASE>";
        assertEquals("<WSPPASSPHRASE>******</WSPPASSPHRASE>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<ns:WSPPASSPHRASE>fgfdgg</ns:WSPPASSPHRASE>";
        assertEquals("<ns:WSPPASSPHRASE>******</ns:WSPPASSPHRASE>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<PassPhrase>secret</PassPhrase><ns:WSPPASSPHRASE>fgfdgg</ns:WSPPASSPHRASE>";
        assertEquals("<PassPhrase>******</PassPhrase><ns:WSPPASSPHRASE>******</ns:WSPPASSPHRASE>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<ns3:ProvisionCardInputData xmlns:ns3=\"http://hce.everest.com/2015/04\" xmlns:ns2=\"http://schemas.datacontract.org/2004/07/MPTSAESService\" xmlns:ns4=\"http://schemas.microsoft.com/2003/10/Serialization/\"><ns3:CMSMPA_ID>0000000000000000000000000000000000000000000000000000000000008239</ns3:CMSMPA_ID><ns3:CardholderName>IA TSITSKISHVILI</ns3:CardholderName><ns3:EffectiveDate>1111</ns3:EffectiveDate><ns3:ExpiryDate>1702</ns3:ExpiryDate><ns3:PAN>4140510260908026</ns3:PAN><ns3:PSN>00</ns3:PSN><ns3:WSPPASSPHRASE>1234</ns3:WSPPASSPHRASE><ns3:WSPUSERIDENTIFIER>BOG</ns3:WSPUSERIDENTIFIER></ns3:ProvisionCardInputData>";
//        assertEquals("<ns3:ProvisionCardInputData xmlns:ns3=\"http://hce.everest.com/2015/04\" xmlns:ns2=\"http://schemas.datacontract.org/2004/07/MPTSAESService\" xmlns:ns4=\"http://schemas.microsoft.com/2003/10/Serialization/\"><ns3:CMSMPA_ID>0000000000000000000000000000000000000000000000000000000000008239</ns3:CMSMPA_ID><ns3:CardholderName>IA TSITSKISHVILI</ns3:CardholderName><ns3:EffectiveDate>1111</ns3:EffectiveDate><ns3:ExpiryDate>1702</ns3:ExpiryDate><ns3:PAN>******</ns3:PAN><ns3:PSN>00</ns3:PSN><ns3:WSPPASSPHRASE>******</ns3:WSPPASSPHRASE><ns3:WSPUSERIDENTIFIER>BOG</ns3:WSPUSERIDENTIFIER></ns3:ProvisionCardInputData>", StringUtil.sensitiveFieldsFromXmlHiding(text)); //todo old
        assertEquals("<ns3:ProvisionCardInputData xmlns:ns3=\"http://hce.everest.com/2015/04\" xmlns:ns2=\"http://schemas.datacontract.org/2004/07/MPTSAESService\" xmlns:ns4=\"http://schemas.microsoft.com/2003/10/Serialization/\"><ns3:CMSMPA_ID>0000000000000000000000000000000000000000000000000000000000008239</ns3:CMSMPA_ID><ns3:CardholderName>IA TSITSKISHVILI</ns3:CardholderName><ns3:EffectiveDate>1111</ns3:EffectiveDate><ns3:ExpiryDate>1702</ns3:ExpiryDate><ns3:PAN>414051******8026</ns3:PAN><ns3:PSN>00</ns3:PSN><ns3:WSPPASSPHRASE>******</ns3:WSPPASSPHRASE><ns3:WSPUSERIDENTIFIER>BOG</ns3:WSPUSERIDENTIFIER></ns3:ProvisionCardInputData>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<CardNum>4999999999990011</CardNum><ExpYear>2019</ExpYear><ExpMonth>05</ExpMonth><CVNum>111</CVNum>";
//        assertEquals("<CardNum>******</CardNum><ExpYear>2019</ExpYear><ExpMonth>05</ExpMonth><CVNum>******</CVNum>", StringUtil.sensitiveFieldsFromXmlHiding(text)); //todo old
        assertEquals("<CardNum>499999******0011</CardNum><ExpYear>2019</ExpYear><ExpMonth>05</ExpMonth><CVNum>******</CVNum>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<sab:confirmProvisioningResponse><sab:panInternalId>43434</sab:panInternalId><sab:pan>258</sab:pan><PAN>258</PAN></sab:confirmProvisioningResponse>";
        assertEquals("<sab:confirmProvisioningResponse><sab:panInternalId>43434</sab:panInternalId><sab:pan>******</sab:pan><PAN>******</PAN></sab:confirmProvisioningResponse>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<sab:confirmProvisioningResponse><sab:panInternalId/><sab:pan>258</sab:pan><PAN>258</PAN></sab:confirmProvisioningResponse>";
        assertEquals("<sab:confirmProvisioningResponse><sab:panInternalId/><sab:pan>******</sab:pan><PAN>******</PAN></sab:confirmProvisioningResponse>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<sab:confirmProvisioningResponse><sab:panInternalId some=\"value\"/><sab:pan>258</sab:pan><PAN>258</PAN></sab:confirmProvisioningResponse>";
        assertEquals("<sab:confirmProvisioningResponse><sab:panInternalId some=\"value\"/><sab:pan>******</sab:pan><PAN>******</PAN></sab:confirmProvisioningResponse>", StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><ECommerceConnect xmlns:ns2=\"http://www.w3.org/2001/04/xmlenc#\" xmlns:ns3=\"http://www.w3.org/2000/09/xmldsig#\"><Message id=\"1\" version=\"1.0\"><XMLPayRequest><RequestData><MerchantID>1754987</MerchantID><TerminalID>E7882997</TerminalID><Transactions><Transaction Id=\"2\"><Authorization><PayData><Invoice><OrderID>3468</OrderID><Date>20180511160036</Date><TotalAmount>0</TotalAmount><Currency>980</Currency><Description>Account verification</Description></Invoice><Card><CardNum>5559490000000007</CardNum><ExpYear>2020</ExpYear><ExpMonth>01</ExpMonth><CVNum>123</CVNum></Card></PayData></Authorization></Transaction></Transactions></RequestData></XMLPayRequest></Message><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "<ds:SignedInfo>\n" +
                "<ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "<ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "<ds:Reference URI=\"\">\n" +
                "<ds:Transforms>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "</ds:Transforms>\n" +
                "<ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
                "<ds:DigestValue>UZoWzu6lPNkegqbAL3QCU/yJEsM=</ds:DigestValue>\n" +
                "</ds:Reference>\n" +
                "</ds:SignedInfo>\n" +
                "<ds:SignatureValue>\n" +
                "eUw3h3m83BADC9ehNL5FBXR0X1X5l/HKc2lO8vp/izsphY4b4QVQApxjXxYAjvA7RjnmshP2Awku&#13;\n" +
                "6jCEc12nhHJBUX0C84RnMoWokm1C8JSpYocQgycNBUpiQzRlVF26OCU7w5N5cwPG8spsBVyL5qoX&#13;\n" +
                "sJIMBcQ6pjWylzoI+cA=\n" +
                "</ds:SignatureValue>\n" +
                "</ds:Signature></ECommerceConnect>";
//        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><ECommerceConnect xmlns:ns2=\"http://www.w3.org/2001/04/xmlenc#\" xmlns:ns3=\"http://www.w3.org/2000/09/xmldsig#\"><Message id=\"1\" version=\"1.0\"><XMLPayRequest><RequestData><MerchantID>******</MerchantID><TerminalID>******</TerminalID><Transactions><Transaction Id=\"2\"><Authorization><PayData><Invoice><OrderID>3468</OrderID><Date>20180511160036</Date><TotalAmount>0</TotalAmount><Currency>980</Currency><Description>Account verification</Description></Invoice><Card><CardNum>******</CardNum><ExpYear>2020</ExpYear><ExpMonth>01</ExpMonth><CVNum>******</CVNum></Card></PayData></Authorization></Transaction></Transactions></RequestData></XMLPayRequest></Message><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" + //todo old
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><ECommerceConnect xmlns:ns2=\"http://www.w3.org/2001/04/xmlenc#\" xmlns:ns3=\"http://www.w3.org/2000/09/xmldsig#\"><Message id=\"1\" version=\"1.0\"><XMLPayRequest><RequestData><MerchantID>******</MerchantID><TerminalID>******</TerminalID><Transactions><Transaction Id=\"2\"><Authorization><PayData><Invoice><OrderID>3468</OrderID><Date>20180511160036</Date><TotalAmount>0</TotalAmount><Currency>980</Currency><Description>Account verification</Description></Invoice><Card><CardNum>555949******0007</CardNum><ExpYear>2020</ExpYear><ExpMonth>01</ExpMonth><CVNum>******</CVNum></Card></PayData></Authorization></Transaction></Transactions></RequestData></XMLPayRequest></Message><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "<ds:SignedInfo>\n" +
                "<ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "<ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "<ds:Reference URI=\"\">\n" +
                "<ds:Transforms>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "</ds:Transforms>\n" +
                "<ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
                "<ds:DigestValue>UZoWzu6lPNkegqbAL3QCU/yJEsM=</ds:DigestValue>\n" +
                "</ds:Reference>\n" +
                "</ds:SignedInfo>\n" +
                "<ds:SignatureValue>\n" +
                "eUw3h3m83BADC9ehNL5FBXR0X1X5l/HKc2lO8vp/izsphY4b4QVQApxjXxYAjvA7RjnmshP2Awku&#13;\n" +
                "6jCEc12nhHJBUX0C84RnMoWokm1C8JSpYocQgycNBUpiQzRlVF26OCU7w5N5cwPG8spsBVyL5qoX&#13;\n" +
                "sJIMBcQ6pjWylzoI+cA=\n" +
                "</ds:SignatureValue>\n" +
                "</ds:Signature></ECommerceConnect>",
                StringUtil.sensitiveFieldsFromXmlHiding(text));

        text = "<ns3:authenticate xmlns:ns3=\"http://sab/\" xmlns:ns4=\"http://ws.wso2.org/dataservice\"><ns3:user>test1@cts.com</ns3:user><ns3:password>!QAZse4</ns3:password></ns3:authenticate>";
        assertEquals("<ns3:authenticate xmlns:ns3=\"http://sab/\" xmlns:ns4=\"http://ws.wso2.org/dataservice\"><ns3:user>test1@cts.com</ns3:user><ns3:password>******</ns3:password></ns3:authenticate>", StringUtil.sensitiveFieldsFromXmlHiding(text));
    }

    @Test
    public void toUppercaseWordsWithUnderscoresTest() {
        assertNull(StringUtil.toUppercaseWordsWithUnderscores(null));
        assertNull(StringUtil.toUppercaseWordsWithUnderscores(""));
        assertEquals("A_SIMPLE_STRING", StringUtil.toUppercaseWordsWithUnderscores("aSimpleString"));
        assertEquals("A_SIMPLE_PATH", StringUtil.toUppercaseWordsWithUnderscores("/aSimplePath"));
    }

    @Test
    public void maskPhoneNumber(){
        assertEquals("12X-XXX-XX32", StringUtil.maskPhoneNumber("1234567832"));
    }

    @Test
    public void maskPhoneNumberWithPrefix(){
        assertEquals("+3812X-XXX-XX32", StringUtil.maskPhoneNumber("+381234567832"));
    }

    @Test
    public void maskPhoneNumberNull(){
        assertEquals(null, StringUtil.maskPhoneNumber(null));
    }

    @Test
    public void maskPhoneNumberEmptyNumber(){
        assertEquals("", StringUtil.maskPhoneNumber(""));
    }

    @Test
    public void maskPhoneNumberNotNumber(){
        assertEquals("asd", StringUtil.maskPhoneNumber("asd"));
    }

    @Test
    public void maskPhoneNumberNotCorrectLength(){
        assertEquals("123", StringUtil.maskPhoneNumber("123"));
    }

    @Test
    public void generateSymbolWithLuhnAlgorithm() {
        /*
         *   Test 1 (Sequence length: 14)
         *   4  5  6  1     2  6  1  2     1  2  3  4     5  4  6  4
         *   8     12       4     2        2     6        10    12
         *   8     3        4     2        2     6        1     3
         *   8 +5 +3 +1  +  4 +6 +2 +2  +  2 +2 +6 +4  +  1 +4 +3 +4=57 Сумма не кратна 10,
         *   делаем последним значение последовательности число, сделающее кратным результат(7)
         *   8 +5 +3 +1  +  4 +6 +2 +2  +  2 +2 +6 +4  +  1 +4 +3 +7=60
         */
        String sequence1 = "4561261212345464";
        assertEquals(7, StringUtil.generateSymbolWithLuhnAlgorithm(sequence1));

        //Test 2 (Sequence length: 15)
        String sequence2 = "234512462346234";
        assertEquals(4, StringUtil.generateSymbolWithLuhnAlgorithm(sequence2));

        //Test 3 (Sequence length: 16)
        String sequence3 = "8888888888888888";
        assertEquals(8, StringUtil.generateSymbolWithLuhnAlgorithm(sequence3));
    }

    @Test
    public void displayPanOrToken(){
        assertEquals("123456_4567", StringUtil.displayPanOrToken("1234567891234567"));
        assertEquals("", StringUtil.displayPanOrToken(""));
        assertEquals(null, StringUtil.displayPanOrToken(null));
        assertEquals("123", StringUtil.displayPanOrToken("123"));
        assertEquals("aaaaaaaaaaaaaaaa", StringUtil.displayPanOrToken("aaaaaaaaaaaaaaaa"));
    }

}
