package com.cts.fasttack.core.converter;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author a.lipavets
 */
public class TimestampTest {

    private StringToTimestampConverter converter = new StringToTimestampConverter();

    @Test
    public void deviationConverterTest(){
        String secondsTypeValue = "30s";
        String minutesTypeValue = "-30m";
        String millisecondsTypeValue = "100ms";
        String hoursTypeValue = "-100h";

        assertEquals(30, converter.convert(secondsTypeValue).getDuration());
        assertEquals(TimeUnit.SECONDS, converter.convert(secondsTypeValue).getTimeUnit());
        assertEquals(-30, converter.convert(minutesTypeValue).getDuration());
        assertEquals(TimeUnit.MINUTES, converter.convert(minutesTypeValue).getTimeUnit());
        assertEquals(0, converter.convert("").getDuration());
        assertEquals(TimeUnit.SECONDS, converter.convert("").getTimeUnit());

        assertEquals(100, converter.convert(millisecondsTypeValue).getDuration());
        assertEquals(TimeUnit.MILLISECONDS, converter.convert(millisecondsTypeValue).getTimeUnit());
        assertEquals(-100, converter.convert(hoursTypeValue).getDuration());
        assertEquals(TimeUnit.HOURS, converter.convert(hoursTypeValue).getTimeUnit());
    }
}
