package com.cts.fasttack.core.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenParameters {

    @Value("${spring.core.job.token.originator:}")
    private String originator;

    @Value("${spring.core.job.token.operator-id:}")
    private String operatorID;

    @Value("${spring.core.job.token.user-id:}")
    private String userId;

    @Value("${spring.core.job.token.user-name:}")
    private String userName;

    @Value("${spring.core.job.token.comment:}")
    private String comment;

    private List<String> reminderPeriods;

    @Value("${spring.core.token.window-reminder-period.list:}")
    private List<String> windowReminderPeriods;

    @Value("${spring.core.token.deactivate-period:}")
    private String deactivatePeriod;

    @Value("${spring.customer.notify.token.sendOnlyForRequestors:}")
    private List<String> sendOnlyForRequestors;

    public String getOriginator() {
        return originator;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }

    public List<String> getSendOnlyForRequestors() {
        return sendOnlyForRequestors;
    }

    public List<Integer> getReminderPeriods() {
        return reminderPeriods.stream()
                .filter(rp -> isInteger(rp))
                .map(rp -> Integer.valueOf(rp))
                .collect(Collectors.toList());
    }

    public List<WindowReminderPeriod> getWindowReminderPeriods() {
        return windowReminderPeriods.stream()
                .filter(wrp -> isWindowReminderPeriod(wrp))
                .map(wrp -> new WindowReminderPeriod(getWindowReminderPeriod(wrp)))
                .collect(Collectors.toList());
    }

    public int maxReminderPeriod() {
        return getReminderPeriods().stream().mapToInt(i -> i)
                .max().orElse(0);
    }

    public Integer getDeactivatePeriod() {
        return isInteger(deactivatePeriod)
                ? Integer.valueOf(deactivatePeriod)
                : 0;
    }

    private boolean isInteger(Object obj) {
        if(obj instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(obj.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }

    private int[] getWindowReminderPeriod(String windowReminderPeriod) {
        return Arrays.stream(windowReminderPeriod.split(WindowReminderPeriod.SEPARATOR))
                .filter(rp -> isInteger(rp))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int maxWindowReminderPeriod() {
        return getWindowReminderPeriods().stream()
                .map(wrp -> wrp.getEnd())
                .mapToInt(i -> i)
                .max().orElse(0);
    }

    private boolean isWindowReminderPeriod(String windowReminderPeriod) {
        return Arrays.stream(windowReminderPeriod.split(WindowReminderPeriod.SEPARATOR))
                .filter(rp -> isInteger(rp))
                .mapToInt(Integer::parseInt)
                .count()==2
                    ? true
                    : false;
    }
}
