package com.cts.fasttack.sms.server.config;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.SMSCDeliveryReceipt;
import org.jsmpp.bean.TypeOfNumber;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Anton Leliuk
 */
@Validated
@ConfigurationProperties("spring.sms")
@Component
public class SmsConnectionConfiguration {

    @NotEmpty
    private String host;

    @NotNull
    private Integer port;

    @NotEmpty
    private String systemId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String systemType;

    @NotNull
    private Integer enquireLink;

    @NotNull
    private Long transactionTimer;

    @NotNull
    private TypeOfNumber sourceTypeOfNumber;

    @NotNull
    private NumberingPlanIndicator sourceNumberingPlanIndicator;

    @NotNull
    private TypeOfNumber destinationTypeOfNumber;

    @NotNull
    private NumberingPlanIndicator destinationNumberingPlanIndicator;

    @NotNull
    private SMSCDeliveryReceipt deliveryReceipt;

    @NotEmpty
    private String from;

    @NotNull
    private Long reconnectDelay;

    @NotNull
    private Long reconnectInterval;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public Integer getEnquireLink() {
        return enquireLink;
    }

    public void setEnquireLink(Integer enquireLink) {
        this.enquireLink = enquireLink;
    }

    public Long getTransactionTimer() {
        return transactionTimer;
    }

    public void setTransactionTimer(Long transactionTimer) {
        this.transactionTimer = transactionTimer;
    }

    public TypeOfNumber getSourceTypeOfNumber() {
        return sourceTypeOfNumber;
    }

    public void setSourceTypeOfNumber(TypeOfNumber sourceTypeOfNumber) {
        this.sourceTypeOfNumber = sourceTypeOfNumber;
    }

    public NumberingPlanIndicator getSourceNumberingPlanIndicator() {
        return sourceNumberingPlanIndicator;
    }

    public void setSourceNumberingPlanIndicator(NumberingPlanIndicator sourceNumberingPlanIndicator) {
        this.sourceNumberingPlanIndicator = sourceNumberingPlanIndicator;
    }

    public TypeOfNumber getDestinationTypeOfNumber() {
        return destinationTypeOfNumber;
    }

    public void setDestinationTypeOfNumber(TypeOfNumber destinationTypeOfNumber) {
        this.destinationTypeOfNumber = destinationTypeOfNumber;
    }

    public NumberingPlanIndicator getDestinationNumberingPlanIndicator() {
        return destinationNumberingPlanIndicator;
    }

    public void setDestinationNumberingPlanIndicator(NumberingPlanIndicator destinationNumberingPlanIndicator) {
        this.destinationNumberingPlanIndicator = destinationNumberingPlanIndicator;
    }

    public SMSCDeliveryReceipt getDeliveryReceipt() {
        return deliveryReceipt;
    }

    public void setDeliveryReceipt(SMSCDeliveryReceipt deliveryReceipt) {
        this.deliveryReceipt = deliveryReceipt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getReconnectDelay() {
        return reconnectDelay;
    }

    public void setReconnectDelay(Long reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
    }

    public Long getReconnectInterval() {
        return reconnectInterval;
    }

    public void setReconnectInterval(Long reconnectInterval) {
        this.reconnectInterval = reconnectInterval;
    }
}
