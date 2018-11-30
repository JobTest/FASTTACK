package com.cts.fasttack.core.dto;

/**
 * Cardholder information used for authorizing the account
 *
 * @author a.lipavets
 */
public class CardholderDataDto {

    /**
     * The IP of the device initiating the request
     */
    private String sourceIp;

    /**
     * Latitude and longitude where the device the consumer is attempting to authorize is located.
     */
    private String deviceLocation;

    /**
     * Consumer Identifier provided by the token requestor.
     */
    private String consumerIdentifier;

    /* getters and setters */
    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getConsumerIdentifier() {
        return consumerIdentifier;
    }

    public void setConsumerIdentifier(String consumerIdentifier) {
        this.consumerIdentifier = consumerIdentifier;
    }
}
