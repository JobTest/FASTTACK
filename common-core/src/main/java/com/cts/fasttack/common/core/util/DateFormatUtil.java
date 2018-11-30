package com.cts.fasttack.common.core.util;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateFormatUtil {

    private static final String[] MDES_DATE_PATTERNS = {
            "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSZZZZZ",
            "yyyy-MM-dd'T'HH:mm:ss.SZZZZZ",
            "yyyy-MM-dd'T'HH:mm:ssZZZZZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            "yyyy-MM-dd'T'HH:mm:ss.SSXXX",
            "yyyy-MM-dd'T'HH:mm:ss.SXXX",
            "yyyy-MM-dd'T'HH:mm:ssXXX"
    };

    public static Date stringToDate(DateFormatEnum dateFormatEnum, String value) {
        if (StringUtils.isNotBlank(value)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatEnum.getValue());
            try {
                return dateFormat.parse(value);
            } catch (ParseException ignored) {
                ignored.printStackTrace();
            }
        }
        return null;

    }

    public static String dateToString(DateFormatEnum dateFormatEnum, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatEnum.getValue());
        return date != null ? dateFormat.format(date) : null;
    }

    public static Date expiryDate(Date date) {
        return date != null ? Date.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    public static LocalDateTime clearTime(LocalDateTime date) {
        return date.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static Date expiryDate(LocalDateTime date) {
        return Date.from(clearTime(date).with(TemporalAdjusters.lastDayOfMonth()).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date expiryDate(DateFormatEnum dateFormatEnum, String date) {
        return Date.from(LocalDateTime.parse(date, DateTimeFormatter.ofPattern(dateFormatEnum.getValue())).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date parseAndValidateMdesDateFormat(String date, String fieldName, Logger log, String serviceName) throws ServiceException {
        if (StringUtils.isBlank(fieldName)) {
            if (log != null) {
                log.warn("Error in '" + serviceName + "', " + fieldName + " is empty.");
            }
            throw new ServiceException(StandardErrorCodes.MISSING_REQUIRED_FIELD, fieldName);
        }

        try {
            return DateUtils.parseDate(date, MDES_DATE_PATTERNS);
        } catch (ParseException e) {
            if (log != null) {
                log.error("Invalid date format in " + serviceName + ", field name:'" + fieldName + "' field value: '" + date + "'.");
            }
            throw new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, fieldName);
        }
    }

    public static LocalDate convert(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static int toDays (int hours) {
        return hours/24;
    }

    public static int toHours (int days) {
        return days*24;
    }
}
