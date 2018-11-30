package com.cts.fasttack.mdes.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.mdes.client.dto.AbstractTokenLifecycleRequestDto;
import com.cts.fasttack.mdes.client.dto.AuditInfoDto;

/**
 * @author Anton Leliuk
 */
public abstract class AbstractJmsToTokenLifecycleDtoConverter<T extends AbstractTokenLifecycleRequestDto> extends AbstractConverter<TokenLifecycleIpsJmsMessage, T> {

    @Override
    protected void lightConvert(TokenLifecycleIpsJmsMessage request, T target) {
        JmsTokenLifecycleIpsDto source = request.getJmsTokenActivateIpsDto();
        target.setTokenUniqueReference(source.getTokenRefID());
        target.setCommentText(source.getComment());
        target.setReasonCode(source.getMdesReasonCode());
        target.setAccountPan(source.getPan());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        AuditInfoDto auditInfoDto = new AuditInfoDto();
        auditInfoDto.setOrganization(source.getOrganization());
        auditInfoDto.setUserId(source.getUserId());
        auditInfoDto.setUserName(source.getUsername());
        target.setAuditInfo(auditInfoDto);
    }
}
