package com.cts.fasttack.admin.web.service;

/**
 * I18n message service
 *
 * @author n.bizin
 */
public interface I18nMessageService {

    String getMessage(String code);

    String getMessage(String code, Object... args);

    String getMessageSafe(String code);

}
