package com.cts.fasttack.admin.web.validation.cardReplacement;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.ValidationFailureException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardReplacementExistsValidator implements ConstraintValidator<ValidateCardReplacementExists, String> {

    private Logger logger = LogManager.getLogger(CardReplacementExistsValidator.class);

    @Autowired
    private IntegrationBus integrationBus;

    @Override
    public void initialize(ValidateCardReplacementExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isNotBlank(value)) {
                new com.cts.fasttack.common.core.validation.LuhnValidator().validate(value);

                JmsGetCardInfoShortResponseDto getCardInfoShort = getCardInfoShort(value);
                if (getCardInfoShort != null && StringUtils.isNotBlank(getCardInfoShort.getCardID())) return true;
            }
        } catch (ValidationFailureException | ServiceException ex) {
            logger.error("Number '{}' is NOT valid!", value);
            return false;
        }
        return true;
    }

    private JmsGetCardInfoShortResponseDto getCardInfoShort(String pan) throws ServiceException {
        JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
        jmsGetCardInfoShortMessageDto.setPan(pan);
        HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                .originator("CORE");

        return integrationBus.inOut(() -> "CORE", "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);
    }
}
