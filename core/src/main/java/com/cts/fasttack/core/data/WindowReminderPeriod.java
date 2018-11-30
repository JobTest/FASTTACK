package com.cts.fasttack.core.data;

public class WindowReminderPeriod {

    public WindowReminderPeriod() {

    }

    public WindowReminderPeriod(int[] reminderPeriods) {
        start = reminderPeriods[0];
        end = reminderPeriods[1];
    }

    public final static String SEPARATOR = "-";

    private int start;

    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
