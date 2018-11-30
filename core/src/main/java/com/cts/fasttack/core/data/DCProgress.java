package com.cts.fasttack.core.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.core.dict.DCProgressStatus;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.dict.ProvisioningDecision;

/**
 * Contains dto for the process of digitizing the card
 *
 * @author Dmitry Koval
 */
@Entity
@Table(name = "DCPROGRESS")
public class DCProgress implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "DCPROGRESS_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "DCPROGRESS_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DCPROGRESS_ID_SEQ")
    private Long id = -1L;

    @Column(name = "DC_ID")
    private String dcId;

    @Column(name = "IPS")
    private InternationalPaymentSystem ips;

    @Column(name = "REQUEST_ID")
    private String requestId;

    @Column(name = "CORRELATION_ID")
    private String correlationId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    @Column(name = "PAN_DISPLAY")
    private String panDisplay;

    @Column(name = "TOKENREF")
    private String tokenUniqueReference;

    @Column(name = "PANREF")
    private String panUniqueReference;

    @Column(name = "PAN_INTERNAL_ID")
    private String panInternalId;

    @Column(name = "PAN_INTERNAL_GUID")
    private String panInternalGUID;

    @Column(name = "PROVISIONING_ERR")
    private StandardErrorCodes provisioningError;

    @Column(name = "PROVISIONING_DECISION")
    private ProvisioningDecision provisioningDecision;

    @Column(name = "PROVISIONING_STATUS")
    private DCProgressStatus provisioningStatus;

    @Column(name = "ASV_ERR")
    private String asvErr;

    @Column(name = "ASV_STATUS")
    private DCProgressStatus asvStatus;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENT_DATE")
    private Date eventDate;

    @Column(name = "FINISHED")
    private boolean finished;

    @Column(name = "LOCK")
    private boolean lock;

    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;

    @Column(name = "PRODUCT_CONFIG_ID")
    private String productConfigID;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id < 0;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "DCProgress{" +
                "id=" + id +
                ", dcId='" + dcId + '\'' +
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
                '}';
    }
}
