package com.cts.fasttack.common.core.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Message source service
 *
 * @author Dmitry Koval
 */
@Component
public class MessageSourceService {

    @Autowired
    private MessageSource messageSource;


    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, key, Locale.getDefault());
    }
}
