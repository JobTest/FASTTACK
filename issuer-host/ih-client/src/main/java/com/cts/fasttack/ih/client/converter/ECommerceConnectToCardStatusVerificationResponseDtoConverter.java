package com.cts.fasttack.ih.client.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;
import com.cts.fasttack.ih.client.dto.TransactionResult;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;

/**
 * {@link ECommerceConnect} to {@link JmsCardStatusVerificationResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class ECommerceConnectToCardStatusVerificationResponseDtoConverter extends AbstractConverter<ECommerceConnect, JmsCardStatusVerificationResponseDto> {

    @Override
    protected JmsCardStatusVerificationResponseDto generateTarget() {
        return new JmsCardStatusVerificationResponseDto();
    }

    @Override
    protected void lightConvert(ECommerceConnect source, JmsCardStatusVerificationResponseDto target) {
        // Message converting
        Optional.ofNullable(source.getMessage())
                .ifPresent(message -> Optional.ofNullable(message.getXMLPayResponse())
                        .ifPresent(xmlPayResponse -> Optional.ofNullable(xmlPayResponse.getResponseData())
                                .ifPresent(responseData -> {
                                    TransactionResult transactionResult = responseData.getTransactionResults().getTransactionResult().get(0);

                                    target.setMerchantId(responseData.getMerchantID());
                                    target.setTerminalId(responseData.getTerminalID());
                                    target.setRrn(transactionResult.getRrn());
                                    target.setCvResult(transactionResult.getCVResult());
                                    target.setComment(transactionResult.getComment());
                                    target.setHostCode(transactionResult.getHostCode());
                                    target.setTranCode(transactionResult.getTranCode());
                                    target.setApprovalCode(transactionResult.getApprovalCode());
                                })));

        // Error converting
        Optional.ofNullable(source.getError())
                .ifPresent(error -> {
                    target.setErrorCode(error.getErrorCode());
                    target.setErrorMessage(error.getErrorMessage());
                    target.setDetails(error.getDetails());
                });

    }
}
