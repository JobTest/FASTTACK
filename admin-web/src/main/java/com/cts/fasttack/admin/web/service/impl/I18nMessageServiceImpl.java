package com.cts.fasttack.admin.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import com.cts.fasttack.admin.web.service.I18nMessageService;

@Service
public class I18nMessageServiceImpl implements I18nMessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        return messageSource.getMessage(code, new Object[0], LocaleContextHolder.getLocale());
    }

    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    public String getMessageSafe(String code) {
        try {
            return getMessage(code);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }
}
