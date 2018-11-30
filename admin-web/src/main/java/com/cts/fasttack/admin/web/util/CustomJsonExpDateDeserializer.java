package com.cts.fasttack.admin.web.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author Dmitry Koval
 */
public class CustomJsonExpDateDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (StringUtils.isNotBlank(p.getText()) && p.getText().contains("/")) {
            return p.getText().replace("/", "");
        } else {
            return p.getText();
        }
    }
}
