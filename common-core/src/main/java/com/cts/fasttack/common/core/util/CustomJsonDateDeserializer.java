package com.cts.fasttack.common.core.util;

import java.io.IOException;
import java.util.Date;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    private final DateFormatEnum format;

    public CustomJsonDateDeserializer(DateFormatEnum format) {
        this.format = format;
    }

    public CustomJsonDateDeserializer() {
        this.format = DateFormatEnum.DATE;
    }

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {
        return DateFormatUtil.stringToDate(format, jsonparser.getText());
    }

    public static class DateTime extends CustomJsonDateDeserializer {
        public DateTime() {
            super(DateFormatEnum.DATETIME);
        }
    }

    public static class DateNoTime extends CustomJsonDateDeserializer {
        public DateNoTime() {
            super(DateFormatEnum.DATE);
        }
    }

    public static class RnsDate extends CustomJsonDateDeserializer {
        public RnsDate() {
            super(DateFormatEnum.RNS_FORMAT);
        }
    }

    public static class DateTimeNoSeconds extends CustomJsonDateDeserializer {
        public DateTimeNoSeconds() {
            super(DateFormatEnum.DATETIME_NO_SECONDS);
        }
    }

    public static class ExpireDate extends CustomJsonDateDeserializer {
        public ExpireDate() {
            super(DateFormatEnum.EXPIRE_DATE);
        }
    }

}
