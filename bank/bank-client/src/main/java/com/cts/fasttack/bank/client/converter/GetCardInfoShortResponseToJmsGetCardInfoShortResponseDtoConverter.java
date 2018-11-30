package com.cts.fasttack.bank.client.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCardInfoShortItem;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCardInfoShortResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;

/**
 * {@link GetCardInfoShortResponse} to {@link JmsGetCardInfoShortResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class GetCardInfoShortResponseToJmsGetCardInfoShortResponseDtoConverter extends AbstractConverter<GetCardInfoShortResponse, JmsGetCardInfoShortResponseDto> {

    @Override
    protected JmsGetCardInfoShortResponseDto generateTarget() {
        return new JmsGetCardInfoShortResponseDto();
    }

    @Override
    protected void lightConvert(GetCardInfoShortResponse source, JmsGetCardInfoShortResponseDto target) {
        Optional.ofNullable(source.getGetCardInfoShortItem())
                .ifPresent(getGetCardInfoShortItem -> {
                    if (!CollectionUtils.isEmpty(getGetCardInfoShortItem)) {
                        GetCardInfoShortItem getCardInfoShortItem = getGetCardInfoShortItem.get(0);

                        // Card ID
                        Optional.ofNullable(getCardInfoShortItem.getCardID())
                                .ifPresent(cardID -> Optional.ofNullable(cardID.getValue())
                                        .ifPresent(target::setCardID));

                        // Card GUID
                        Optional.ofNullable(getCardInfoShortItem.getCardGUID())
                                .ifPresent(cardGUID -> Optional.ofNullable(cardGUID.getValue())
                                        .ifPresent(target::setCardGUID));

                        // Phone number
                        Optional.ofNullable(getCardInfoShortItem.getPhoneNumber())
                                .ifPresent(phoneNumber -> Optional.ofNullable(phoneNumber.getValue())
                                        .ifPresent(target::setPhoneNumber));
                    }
                });
    }
}
