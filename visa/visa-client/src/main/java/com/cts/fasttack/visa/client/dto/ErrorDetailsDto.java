package com.cts.fasttack.visa.client.dto;

/**
 * @author Anton Leliuk
 */
public class ErrorDetailsDto {

    private String location;
    private String message;

    @Override
    public String toString() {
        return "ErrorDetailsDto{" +
                "location='" + location + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
