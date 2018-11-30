package com.cts.fasttack.core.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;

/**
 * @author Dmitry Koval
 */
public class CvcAttemptDto extends IdentifierDto<Long> {

    private Integer failures;

    private Date lastDate;

    private String panInternalID;

    private String panInternalGUID;

    private boolean isNew = false;

    public CvcAttemptDto() {
    }

    public CvcAttemptDto(String panInternalID, String panInternalGUID, Date lastDate, Integer failures) {
        this.panInternalID = panInternalID;
        this.panInternalGUID = panInternalGUID;
        this.lastDate = lastDate;
        this.failures = failures;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getFailures() {
        return failures;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getPanInternalID() {
        return panInternalID;
    }

    public void setPanInternalID(String panInternalID) {
        this.panInternalID = panInternalID;
    }

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }
}
