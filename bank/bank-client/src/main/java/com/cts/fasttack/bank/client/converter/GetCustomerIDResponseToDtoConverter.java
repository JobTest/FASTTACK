package com.cts.fasttack.bank.client.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCustomerIDItem;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCustomerIDResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import org.springframework.util.CollectionUtils;

/**
 * {@link GetCustomerIDResponse} to {@link JmsGetCustomerIDResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class GetCustomerIDResponseToDtoConverter extends AbstractConverter<GetCustomerIDResponse, JmsGetCustomerIDResponseDto> {

    @Override
    protected JmsGetCustomerIDResponseDto generateTarget() {
        return new JmsGetCustomerIDResponseDto();
    }

    @Override
    protected void lightConvert(GetCustomerIDResponse source, JmsGetCustomerIDResponseDto target) {
        Optional.ofNullable(source.getGetCustomerIDItem())
                .ifPresent(getGetCustomerIDItems -> {
                    if (!CollectionUtils.isEmpty(getGetCustomerIDItems)) {
                        GetCustomerIDItem getCustomerIDItem = source.getGetCustomerIDItem().get(0);

                        // Customer ID
                        Optional.ofNullable(getCustomerIDItem.getCustomerID())
                                .ifPresent(customerID -> Optional.ofNullable(customerID.getValue())
                                        .ifPresent(value -> target.setCustomerID(value.toString())));

                        // Code
                        Optional.ofNullable(getCustomerIDItem.getCode())
                                .ifPresent(code -> Optional.ofNullable(code.getValue())
                                        .ifPresent(value -> target.setCode(value.toString())));

                        // Error message
                        Optional.ofNullable(getCustomerIDItem.getErrorMessage())
                                .ifPresent(errorMessage -> target.setErrorMessage(errorMessage.getValue()));
                    }
                });
    }
}
