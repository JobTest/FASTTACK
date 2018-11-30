package com.cts.fasttack.common.core.util;

import java.io.IOException;
import java.util.Date;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomJsonDateSerializer extends JsonSerializer<Date> {

    private final DateFormatEnum format;

    public CustomJsonDateSerializer(DateFormatEnum format) {
        this.format = format;
    }

    public CustomJsonDateSerializer() {
        this.format = DateFormatEnum.DATE;
    }

    @Override
    public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(DateFormatUtil.dateToString(format, date));
    }

    @Override
    public Class<Date> handledType() {
        return Date.class;
    }

    public static class DateTime extends CustomJsonDateSerializer {
        public DateTime() {
            super(DateFormatEnum.DATETIME);
        }
    }

    public static class DateNoTime extends CustomJsonDateSerializer {
        public DateNoTime() {
            super(DateFormatEnum.DATE);
        }
    }

    public static class RnsDate extends CustomJsonDateSerializer {
        public RnsDate() {
            super(DateFormatEnum.RNS_FORMAT);
        }
    }

    public static class DateTimeNoSeconds extends CustomJsonDateSerializer {
        public DateTimeNoSeconds() {
            super(DateFormatEnum.DATETIME_NO_SECONDS);
        }
    }

    public static class ExpireDate extends CustomJsonDateSerializer {
        public ExpireDate() {
            super(DateFormatEnum.EXPIRE_DATE);
        }
    }

}
