package com.cts.fasttack.mdes.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsAuditInfoDto;
import com.cts.fasttack.mdes.client.dto.AuditInfoDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsAuditInfoToAuditInfoDtoConverter extends AbstractConverter<JmsAuditInfoDto, AuditInfoDto> {
    @Override
    protected AuditInfoDto generateTarget() {
        return new AuditInfoDto();
    }

    @Override
    protected void lightConvert(JmsAuditInfoDto source, AuditInfoDto target) {
        target.setUserName(source.getUserName());
        target.setUserId(source.getUserId());
        target.setPhone(source.getPhone());
        target.setOrganization(source.getOrganization());
    }
}
