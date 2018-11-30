package com.cts.fasttack.ih_sv.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Response;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;

/**
 * @author d.ishchenko
 */
@Component
public class Avs1ToCardStatusVerificationResponseDtoConverter
		extends AbstractConverter<Avs1Response, JmsCardStatusVerificationResponseDto> {

	@Override
	protected JmsCardStatusVerificationResponseDto generateTarget() {
		return new JmsCardStatusVerificationResponseDto();
	}

	@Override
	protected void lightConvert(Avs1Response source, JmsCardStatusVerificationResponseDto target) {
		String code = source.getCode().getValue();

		target.setHostCode(code);
		target.setTranCode(code);

		switch (code) {
			case "000":
				target.setCvResult("M");
				break;
			case "001":
				target.setCvResult("N");
				target.setHostCode(code);
				target.setTranCode("000");
				break;
			case "002":
				target.setCvResult("P");
				target.setHostCode(code);
				target.setTranCode("000");
				break;
			case "005":
				target.setCvResult("N");
				target.setHostCode(code);
				target.setTranCode("000");
				break;
			default:
				target.setCvResult("P");
				target.setErrorCode(code);
				break;
		}
	}

}
