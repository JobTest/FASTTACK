package com.cts.fasttack.visa.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "pingRequest", namespace = "http://vnts.visa.com/tpcas/v1")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PingRequestDto {

    private String requestID;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
}
