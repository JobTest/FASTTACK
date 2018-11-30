package com.cts.fasttack.core.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import com.cts.fasttack.common.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.CardholderVerificationMethodDtoToDomainConverter;
import com.cts.fasttack.core.converter.CardholderVerificationMethodToDtoConverter;
import com.cts.fasttack.core.dao.CardholderVerificationMethodDao;
import com.cts.fasttack.core.data.CardholderVerificationMethod;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;

/**
 * @author a.lipavets
 */
@Service("cardholderVerificationMethodService")
public class CardholderVerificationMethodServiceImpl extends GenericServiceImpl<Long, CardholderVerificationMethodDto, CardholderVerificationMethod, CardholderVerificationMethodDao> implements CardholderVerificationMethodService {

    @Autowired
    public CardholderVerificationMethodServiceImpl(CardholderVerificationMethodDao dao, CardholderVerificationMethodToDtoConverter domainToDtoConverter, CardholderVerificationMethodDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CardholderVerificationMethodDto> getByCorrelationId(String correlationId) {
        return Optional.ofNullable(domainToDtoConverter.convert(dao.getByCorrelationId(correlationId)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CardholderVerificationMethodDto> getByTokenRefIdAndRequestorId(String tokenRefId, String tokenRequestorId) {
        return Optional.ofNullable(domainToDtoConverter.convert(dao.getByTokenRefIdAndRequestorId(tokenRefId, tokenRequestorId)));
    }

    @Override
    @Transactional
    public void saveOrUpdate(DCProgressDto dcProgressDto, String accountNumber) {
        Optional<CardholderVerificationMethodDto> cvm = getByCorrelationId(dcProgressDto.getCorrelationId());
        CardholderVerificationMethodDto dto;
        if (cvm.isPresent()) {
            dto = cvm.get();
            setCardholderVerificationMethodDto(dcProgressDto, dto, accountNumber);
        } else {
            dto = new CardholderVerificationMethodDto();
            setCardholderVerificationMethodDto(dcProgressDto, dto, accountNumber);
        }
        save(dto);
    }

    @Override
    @Transactional
    public void saveOrUpdate(DCProgressDto dcProgressDto, String accountNumber, String tokenizationPath, String wpReasonCodes, String wpDeviceScore, String wpPhonenumberScore, String wpAccountScore, String colorTokenizationStandardVersion, String deviceType, String deviceName) {
        Optional<CardholderVerificationMethodDto> cvm = getByCorrelationId(dcProgressDto.getCorrelationId());
        CardholderVerificationMethodDto dto;
        if (cvm.isPresent()) {
            dto = cvm.get();
            setCardholderVerificationMethodDto(dcProgressDto, dto, accountNumber, tokenizationPath, wpReasonCodes, wpDeviceScore, wpPhonenumberScore, wpAccountScore, colorTokenizationStandardVersion, deviceType, deviceName);
        } else {
            dto = new CardholderVerificationMethodDto();
            setCardholderVerificationMethodDto(dcProgressDto, dto, accountNumber, tokenizationPath, wpReasonCodes, wpDeviceScore, wpPhonenumberScore, wpAccountScore, colorTokenizationStandardVersion, deviceType, deviceName);
        }
        save(dto);
    }

    @Override
    @Transactional
    public void saveOrUpdate(CardholderVerificationMethodDto cvmDto) {
        save(cvmDto);
    }

    private void setCardholderVerificationMethodDto(DCProgressDto source, CardholderVerificationMethodDto target, String accountNumber) {
        target.setCellPhone(source.getCustomerPhone());
        target.setTransactionDate(source.getEventDate());
        target.setTokenRefId(source.getTokenUniqueReference());
        if (target.getTokenRefId() == null) {
        	target.setTokenRefId("NotYetAssigned-" + source.getCorrelationId());
        }
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setCorrelationId(source.getCorrelationId());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setRequestId(source.getRequestId());
        target.setMaskedPan(StringUtil.displayPanOrToken(accountNumber));
    }

    private void setCardholderVerificationMethodDto(DCProgressDto source, CardholderVerificationMethodDto target, String accountNumber, String tokenizationPath, String wpReasonCodes, String wpDeviceScore, String wpPhonenumberScore, String wpAccountScore, String colorTokenizationStandardVersion, String deviceType, String deviceName) {
        target.setCellPhone(source.getCustomerPhone());
        target.setTransactionDate(source.getEventDate());
        target.setTokenRefId(source.getTokenUniqueReference());
        if (target.getTokenRefId() == null) {
            target.setTokenRefId("NotYetAssigned-" + source.getCorrelationId());
        }
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setCorrelationId(source.getCorrelationId());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setRequestId(source.getRequestId());
        target.setMaskedPan(StringUtil.displayPanOrToken(accountNumber));
        target.setWpReasonCodes(wpReasonCodes);
        target.setWpDeviceScore(wpDeviceScore);
        target.setWpPhonenumberScore(wpPhonenumberScore);
        target.setWpAccountScore(wpAccountScore);
        target.setTokenizationPath(tokenizationPath);
        target.setColorTokenizationStandardVersion(colorTokenizationStandardVersion);
        target.setDeviceType(deviceType);
        target.setDeviceName(deviceName);
    }

    @Override
    @Transactional
    public CardholderVerificationMethodDto saveOrUpdateByConfirmProvisionResponse(JmsConfirmProvisioningResponseDto cpResponse, JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto, String pan) {
        Optional<CardholderVerificationMethodDto> cardholderVerificationMethod = getByTokenRefIdAndRequestorId(jmsCardholderVerificationMethodsDto.getTokenReferenceID(), jmsCardholderVerificationMethodsDto.getTokenRequestorID());
        CardholderVerificationMethodDto dto;
        if (cardholderVerificationMethod.isPresent()) {
            dto = cardholderVerificationMethod.get();
            createCardholderVerificationMethodDto(cpResponse, jmsCardholderVerificationMethodsDto, dto, pan);
        } else {
            dto = new CardholderVerificationMethodDto();
            createCardholderVerificationMethodDto(cpResponse, jmsCardholderVerificationMethodsDto, dto, pan);
        }
        return save(dto);
    }

    private void createCardholderVerificationMethodDto(JmsConfirmProvisioningResponseDto cpResponse, JmsCardholderVerificationMethodsDto jmsCardholderVerificationMethodsDto, CardholderVerificationMethodDto target, String pan){
        target.setCellPhone(cpResponse.getCustomerPhone());
        target.setTransactionDate(new Date());
        target.setTokenRefId(jmsCardholderVerificationMethodsDto.getTokenReferenceID());
        target.setTokenRequestorId(jmsCardholderVerificationMethodsDto.getTokenRequestorID());
        target.setPanInternalId(cpResponse.getPanInternalId());
        target.setPanInternalGUID(cpResponse.getPanInternalGUID());
        target.setCorrelationId(jmsCardholderVerificationMethodsDto.getWpConversationId());
        target.setRequestId(UUID.randomUUID().toString());
        target.setCvmIdentifierOtp(jmsCardholderVerificationMethodsDto.getCvmIdentifierOtp());
        target.setMaskedPan(StringUtil.displayPanOrToken(pan));
    }
}
