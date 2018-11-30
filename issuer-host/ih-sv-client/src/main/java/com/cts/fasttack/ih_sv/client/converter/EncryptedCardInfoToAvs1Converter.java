package com.cts.fasttack.ih_sv.client.converter;

import java.util.UUID;

import org.springframework.stereotype.Component;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Request;
import com.cts.fasttack.ih_sv.client.ws.client.ObjectFactory;

/**
 * @author d.ishchenko
 */
@Component
public class EncryptedCardInfoToAvs1Converter {

	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

	public Avs1Request convert(String encryptedData, String encryptionKeyIndex) {
		Avs1Request target = OBJECT_FACTORY.createAvs1Request();

		target.setRequestId(UUID.randomUUID().toString());
		target.setEncryptionKeyIndex(encryptionKeyIndex);
		target.setEncryptedData(encryptedData);
		
		return target;
	}

}
