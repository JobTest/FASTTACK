package com.cts.fasttack.admin.web.config.context.parameter;

import java.util.Locale;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import com.cts.fasttack.admin.web.data.dict.RandomGenerateSequenceType;

@Component
@Validated
@ConfigurationProperties("spring.admin.web")
public class AdminWebParameters {

    @NotNull
    private Locale defaultLocale;

    @NotNull
    private Integer storageTtlMinutes;

    @NotEmpty
    private String buildTimestamp;

    @NotEmpty
    private String buildTimestampFormat;

    @NotNull
    private Integer randomSequenceLength;

    @NotNull
    private RandomGenerateSequenceType randomSequenceType;

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Integer getStorageTtlMinutes() {
        return storageTtlMinutes;
    }

    public void setStorageTtlMinutes(Integer storageTtlMinutes) {
        this.storageTtlMinutes = storageTtlMinutes;
    }

    public String getBuildTimestamp() {
        return buildTimestamp;
    }

    public void setBuildTimestamp(String buildTimestamp) {
        this.buildTimestamp = buildTimestamp;
    }

    public String getBuildTimestampFormat() {
        return buildTimestampFormat;
    }

    public void setBuildTimestampFormat(String buildTimestampFormat) {
        this.buildTimestampFormat = buildTimestampFormat;
    }

    public Integer getRandomSequenceLength() {
        return randomSequenceLength;
    }

    public void setRandomSequenceLength(Integer randomSequenceLength) {
        this.randomSequenceLength = randomSequenceLength;
    }

    public RandomGenerateSequenceType getRandomSequenceType() {
        return randomSequenceType;
    }

    public void setRandomSequenceType(RandomGenerateSequenceType randomSequenceType) {
        this.randomSequenceType = randomSequenceType;
    }
}
