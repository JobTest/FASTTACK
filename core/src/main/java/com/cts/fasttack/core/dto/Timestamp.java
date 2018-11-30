package com.cts.fasttack.core.dto;

import java.util.concurrent.TimeUnit;

/**
 * Class for deviation, contains duration and time type
 * @author a.lipavets
 */
public class Timestamp {

    private long duration;

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    /**getters and setters*/

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
