package com.cts.fasttack.sms.server.util;

import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.GeneralDataCoding;
import org.jsmpp.bean.MessageClass;

/**
 * @author Anton Leliuk
 */
public class GeneralDataCodingWithText extends GeneralDataCoding {

    private byte[] text;

    public GeneralDataCodingWithText(Alphabet alphabet, MessageClass messageClass, byte[] text) throws IllegalArgumentException {
        super(alphabet, messageClass, false);
        this.text = text;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

}
