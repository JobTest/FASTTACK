package com.cts.fasttack.core.jms.processor;

import java.util.List;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.core.converter.TokenInfoDtoToJmsCardAndTokenResponseDtoConverter;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.dto.GetTokenByWalletIdJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardAndTokenResponseDto;
import com.cts.fasttack.jms.dto.JmsGetTokenByWalletIdMessageDto;
import com.cts.fasttack.jms.dto.JmsGetTokenByWalletIdResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * Processor for getting token info by wallet info.
 *
 * @author v.semerkov
 */
@Component
public class GetTokenByWalletIdProcessor extends AbstractCamelProcessor<GetTokenByWalletIdJmsMessage, JmsGetTokenByWalletIdResponseDto> {

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenInfoDtoToJmsCardAndTokenResponseDtoConverter tokenInfoDtoToJmsCardAndTokenResponseDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, GetTokenByWalletIdJmsMessage.class, request -> {
            JmsGetTokenByWalletIdMessageDto tokenByWalletIdMessageDto = request.getTokenByWalletIdMessageDto();
            List<TokenInfoDto> tokenInfoDtoList = tokenInfoService.listTokensByWalletId(tokenByWalletIdMessageDto.getClientWalletAccountId(), tokenByWalletIdMessageDto.getClientWalletProvider());
            List<JmsCardAndTokenResponseDto> jmsCardAndTokenResponseDtoList = tokenInfoDtoToJmsCardAndTokenResponseDtoConverter.convert(tokenInfoDtoList);

            JmsGetTokenByWalletIdResponseDto response = new JmsGetTokenByWalletIdResponseDto();
            response.setCardAndTokenList(jmsCardAndTokenResponseDtoList);

            return response;
        });
    }
}
