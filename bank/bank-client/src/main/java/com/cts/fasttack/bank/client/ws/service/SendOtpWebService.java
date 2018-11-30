package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsSendOtpDto;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;

/**
 * @author a.lipavets
 */
public interface SendOtpWebService {

    /**
     * Verification by checking OTP code
     *
     * @param request object that contains otp code
     * @return possible object is
     *     {@link BankJmsResponseDto }
     *
     * @throws ServiceException
     */
    BankJmsResponseDto sendOtp(JmsSendOtpDto request) throws ServiceException;
}
