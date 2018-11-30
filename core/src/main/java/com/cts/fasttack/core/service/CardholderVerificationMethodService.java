package com.cts.fasttack.core.service;

import java.util.Optional;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.CardholderVerificationMethod;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;

/**
 * @author a.lipavets
 */
public interface CardholderVerificationMethodService extends GenericService<Long, CardholderVerificationMethodDto, CardholderVerificationMethod> {

    /**
     * Return CardholderVerificationMethod by correlationId
     */
    Optional<CardholderVerificationMethodDto> getByCorrelationId(String correlationId);

    /**
     * Return CardholderVerificationMethod by tokenRefId, tokenRequestorId
     */
    Optional<CardholderVerificationMethodDto> getByTokenRefIdAndRequestorId(String tokenRefId, String tokenRequestorId);

    /**
     *  Save or update by CorrelationID
     * @param dcProgressDto
     */
    void saveOrUpdate(DCProgressDto dcProgressDto, String accountNumber);

    void saveOrUpdate(DCProgressDto dcProgressDto, String accountNumber, String tokenizationPath, String wpReasonCodes, String wpDeviceScore, String wpPhonenumberScore, String wpAccountScore, String colorTokenizationStandardVersion, String deviceType, String deviceName);

    void saveOrUpdate(CardholderVerificationMethodDto cvmDto);

    /**
     * Save or update CardholderVerificationMethod
     */
    CardholderVerificationMethodDto saveOrUpdateByConfirmProvisionResponse(JmsConfirmProvisioningResponseDto cpResponse, JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto, String pan);
}
