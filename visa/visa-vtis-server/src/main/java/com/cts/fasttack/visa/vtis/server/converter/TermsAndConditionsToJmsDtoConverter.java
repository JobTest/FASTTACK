package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.TermsAndConditions;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTermsAndConditions;

/**
 * @author Dmitry Koval
 */
@Component
public class TermsAndConditionsToJmsDtoConverter extends AbstractConverter<TermsAndConditions, JmsTermsAndConditions> {
    @Override
    protected JmsTermsAndConditions generateTarget() {
        return new JmsTermsAndConditions();
    }

    @Override
    protected void lightConvert(TermsAndConditions source, JmsTermsAndConditions target) {
        target.setId(source.getId());
        target.setDate(source.getDate());
    }
}
