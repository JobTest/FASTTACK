package com.cts.fasttack.core.converter;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.fasttack.core.dto.Timestamp;
import org.springframework.core.convert.converter.Converter;


/**
 * Convert String to Deviation
 *
 * @author a.lipavets
 */

public class StringToTimestampConverter implements Converter<String, Timestamp> {

    private static final String HOURS_TYPE = "h";
    private static final String MITUTES_TYPE = "m";
    private static final String SECONDS_TYPE = "s";
    private static final String MILISECONDS_TYPE = "ms";
    private static final Pattern DURATION_PATTERN = Pattern.compile("^([-+]?[0-9]+)([a-z]+)$");

    @Override
    public Timestamp convert(String source) {
        Matcher matcher = DURATION_PATTERN.matcher(source);

        Timestamp deviation = new Timestamp();
        if(!source.isEmpty() && matcher.matches()) {
            String timeValue = matcher.group(1);
            String timeType = matcher.group(2);

            switch (timeType){
                case HOURS_TYPE:
                    deviation.setTimeUnit(TimeUnit.HOURS);
                    deviation.setDuration(deviation.getTimeUnit().toHours(Long.parseLong(timeValue)));
                    break;
                case MITUTES_TYPE:
                    deviation.setTimeUnit(TimeUnit.MINUTES);
                    deviation.setDuration(deviation.getTimeUnit().toMinutes(Long.parseLong(timeValue)));
                    break;
                case SECONDS_TYPE:
                    deviation.setTimeUnit(TimeUnit.SECONDS);
                    deviation.setDuration(deviation.getTimeUnit().toSeconds(Long.parseLong(timeValue)));
                    break;
                case MILISECONDS_TYPE:
                    deviation.setTimeUnit(TimeUnit.MILLISECONDS);
                    deviation.setDuration(deviation.getTimeUnit().toMillis(Long.parseLong(timeValue)));
                    break;
            }
        }

        return deviation;
    }
}
