package com.cts.fasttack.ih_sv.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.common.core.util.XmlUtil;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.SmartvistaCryptoRestClient;
import com.cts.fasttack.ih_sv.client.converter.Avs1ToCardStatusVerificationResponseDtoConverter;
import com.cts.fasttack.ih_sv.client.converter.CardStatusVerificationJmsMessageToCardInfoConverter;
import com.cts.fasttack.ih_sv.client.converter.EncryptedCardInfoToAvs1Converter;
import com.cts.fasttack.ih_sv.client.dto.CardInfo;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Request;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Response;
import com.cts.fasttack.ih_sv.client.ws.service.Avs1Service;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * @author d.ishchenko
 */
@Component
public class CardStatusVerificationProcessor
		extends AbstractCamelProcessor<CardStatusVerificationJmsMessage, JmsCardStatusVerificationResponseDto> {

	@Value("${spring.avs1.initializationVectorHex}")
	private String initializationVectorHex;

	@Value("${spring.avs1.encryptionKeyIndex}")
	private String encryptionKeyIndex;

	@Autowired
	private CardStatusVerificationJmsMessageToCardInfoConverter cardStatusVerificationJmsMessageToCardInfoConverter;

	@Autowired
	private SmartvistaCryptoRestClient smartvistaCryptoRestClient;

	@Autowired
	private EncryptedCardInfoToAvs1Converter encryptedCardInfoToAvs1Converter;

	@Autowired
	private Avs1Service avs1Service;

	@Autowired
	private Avs1ToCardStatusVerificationResponseDtoConverter avs1ToCardStatusVerificationResponseDtoConverter;

	@Override
	public void process(Exchange exchange) throws Exception {
		execute(exchange, CardStatusVerificationJmsMessage.class, request -> {
			CardInfo cardInfo = cardStatusVerificationJmsMessageToCardInfoConverter.convert(request);

			String cardInfoXml = XmlUtil.toXmlJAXB(cardInfo, CardInfo.class);

			CryptoResponseDto cryptoResponse = smartvistaCryptoRestClient.encrypt(cardInfoXml, initializationVectorHex, encryptionKeyIndex);
			
			if (cryptoResponse.getErrorCode() != null) {
				throw new ServiceException(cryptoResponse.getErrorCode());
			}

			String encryptedData = cryptoResponse.getText();

			Avs1Request avs1Request = encryptedCardInfoToAvs1Converter.convert(encryptedData, encryptionKeyIndex);
			avs1Request.setRequestId(request.getCardStatusVerificationDto().getRequestId());

			Avs1Response avs1Response = avs1Service.avs1(avs1Request, StringUtil.displayPanOrToken(cardInfo.getPan()));

			JmsCardStatusVerificationResponseDto jmsResponse = avs1ToCardStatusVerificationResponseDtoConverter
					.convert(avs1Response);

			return jmsResponse;
		});
	}

}
