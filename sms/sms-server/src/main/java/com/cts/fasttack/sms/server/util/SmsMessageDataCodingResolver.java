package com.cts.fasttack.sms.server.util;

import java.nio.charset.Charset;

import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.MessageClass;

import net.freeutils.charset.gsm.SCGSMCharset;

/**
 * @author Anton Leliuk
 */
public class SmsMessageDataCodingResolver {

    private static final Charset GSM7_CHARSET = new SCGSMCharset();
    private static final Charset UCS2_CHARSET = Charset.forName("UTF-16BE");

    public static GeneralDataCodingWithText resolve(String text){
        byte[] bytes = text.getBytes(GSM7_CHARSET);
        String comparing = new String(bytes, GSM7_CHARSET);

        if(text.equals(comparing)){
            return new GeneralDataCodingWithText(Alphabet.ALPHA_DEFAULT, MessageClass.CLASS1, text.getBytes(GSM7_CHARSET));
        }

        return new GeneralDataCodingWithText(Alphabet.ALPHA_UCS2, MessageClass.CLASS1, text.getBytes(UCS2_CHARSET));
    }
}
