package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;

import com.cts.fasttack.logging.domain.MessageHistory;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

/**
 * Convert {@link MessageHistory} into {@link MessageHistoryDto}
 *
 * @author Dmitry Koval
 */
@Component
public class MessageHistoryToDtoConverter extends IdentifierToDtoConverter<Long, MessageHistory, MessageHistoryDto> {
    @Override
    protected MessageHistoryDto generateTarget() {
        return new MessageHistoryDto();
    }

    @Override
    public void convert(MessageHistory source, MessageHistoryDto target) {
        target.setId(source.getId());
        target.setParentId(source.getParentId());
        target.setTokenId(source.getTokenId());
        target.setConnectorClient(source.getConnectorClient());
        target.setMsgType(source.getMsgType());
        target.setMsgDateIn(source.getMsgDateIn());
        target.setMsgDateOut(source.getMsgDateOut());
        target.setMsgRawIn(source.getMsgRawIn());
        target.setMsgRawOut(source.getMsgRawOut());
        target.setDecision(source.getDecision());
        target.setErrorCode(source.getErrorCode());
        target.setCvcResp(source.getCvcResp());
        target.setMaskedPan(source.getMaskedPan());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGuid(source.getPanInternalGuid());
        target.setPanSource(source.getPanSource());
    }


}
