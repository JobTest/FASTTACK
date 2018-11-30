package com.cts.fasttack.core.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.core.data.DCProgress;
import com.cts.fasttack.core.dict.DCProgressStatus;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.dict.ProvisioningDecision;

/**
 * DTO for {@link DCProgress}
 *
 * @author Dmitry Koval
 */
public class DCProgressDto extends IdentifierDto<Long> {

    private String dcId;

    private InternationalPaymentSystem ips;

    private String requestId;

    private String correlationId;

    private String tokenRequestorId;

    private String panDisplay;

    private String tokenUniqueReference;

    private String panUniqueReference;

    private String panInternalId;

    private String panInternalGUID;

    private StandardErrorCodes provisioningError;

    private ProvisioningDecision provisioningDecision;

    private DCProgressStatus provisioningStatus;

    private String asvErr;

    private DCProgressStatus asvStatus;

    private Long taskId;

    private Date eventDate;

    private boolean finished;

    private boolean lock;

    private String customerPhone;

    private String productConfigID;

    public DCProgressDto() {
        setId(-1L);
    }

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId;
    }

    public InternationalPaymentSystem getIps() {
        return ips;
    }

    public void setIps(InternationalPaymentSystem ips) {
        this.ips = ips;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getPanDisplay() {
        return panDisplay;
    }

    public void setPanDisplay(String panDisplay) {
        this.panDisplay = panDisplay;
    }

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getPanUniqueReference() {
        return panUniqueReference;
    }

    public void setPanUniqueReference(String panUniqueReference) {
        this.panUniqueReference = panUniqueReference;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public StandardErrorCodes getProvisioningError() {
        return provisioningError;
    }

    public void setProvisioningError(StandardErrorCodes provisioningError) {
        this.provisioningError = provisioningError;
    }

    public ProvisioningDecision getProvisioningDecision() {
        return provisioningDecision;
    }

    public void setProvisioningDecision(ProvisioningDecision provisioningDecision) {
        this.provisioningDecision = provisioningDecision;
    }

    public DCProgressStatus getProvisioningStatus() {
        return provisioningStatus;
    }

    public void setProvisioningStatus(DCProgressStatus provisioningStatus) {
        this.provisioningStatus = provisioningStatus;
    }

    public String getAsvErr() {
        return asvErr;
    }

    public void setAsvErr(String asvErr) {
        this.asvErr = asvErr;
    }

    public DCProgressStatus getAsvStatus() {
        return asvStatus;
    }

    public void setAsvStatus(DCProgressStatus asvStatus) {
        this.asvStatus = asvStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean getLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getProductConfigID() {
        return productConfigID;
    }

    public void setProductConfigID(String productConfigID) {
        this.productConfigID = productConfigID;
    }

    @Override
    public String toString() {
        return "DCProgressDto{" +
                "id='" + getId() + '\'' +
                "dcId='" + dcId + '\'' +
                ", ips=" + ips +
                ", requestId='" + requestId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", tokenRequestorId='" + tokenRequestorId + '\'' +
                ", panDisplay='" + panDisplay + '\'' +
                ", tokenUniqueReference='" + tokenUniqueReference + '\'' +
                ", panUniqueReference='" + panUniqueReference + '\'' +
                ", panInternalId='" + panInternalId + '\'' +
                ", panInternalGUID='" + panInternalGUID + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", productConfigID='" + productConfigID + '\'' +
                ", provisioningError=" + provisioningError +
                ", provisioningDecision=" + provisioningDecision +
                ", provisioningStatus=" + provisioningStatus +
                ", asvErr='" + asvErr + '\'' +
                ", asvStatus=" + asvStatus +
                ", taskId=" + taskId +
                ", eventDate=" + eventDate +
                ", finished=" + finished +
                ", lock=" + lock +
                "} ";
    }
}
