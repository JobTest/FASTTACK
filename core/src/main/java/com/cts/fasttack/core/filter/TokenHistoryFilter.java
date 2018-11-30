package com.cts.fasttack.core.filter;

import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.dto.TokenHistoryList;

/**
 * @author Dmitry Koval
 */
public class TokenHistoryFilter extends ListFilter<TokenHistoryList> {

    private String tokenRefId;

    private String tokenRequestorId;

    private String reminderPeriod;

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }
}
