package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;

import com.cts.fasttack.logging.domain.MessageHistory;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

/**
 * Convert {@link MessageHistoryDto} into {@link MessageHistory}
 *
 * @author Dmitry Koval
 */
@Component
public class MessageHistoryDtoToDomainConverter extends AbstractConverter<MessageHistoryDto, MessageHistory> {
    @Override
    protected MessageHistory generateTarget() {
        return new MessageHistory();
    }

    @Override
    protected void lightConvert(MessageHistoryDto source, MessageHistory target) {
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

    @Override
    public void convertPrimitives(MessageHistoryDto source, MessageHistory target) {
        lightConvert(source, target);
    }
}
