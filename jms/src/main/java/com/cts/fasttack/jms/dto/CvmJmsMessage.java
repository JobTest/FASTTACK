package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class CvmJmsMessage extends HeadersJmsMessage {

    private JmsCvmDto cvmDto;

    public JmsCvmDto getCvmDto() {
        return cvmDto;
    }

    public CvmJmsMessage cvmDto(JmsCvmDto cvmDto) {
        this.cvmDto = cvmDto;
        return this;
    }
}
