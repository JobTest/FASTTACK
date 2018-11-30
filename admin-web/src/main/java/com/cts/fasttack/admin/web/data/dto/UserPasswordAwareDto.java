package com.cts.fasttack.admin.web.data.dto;

/**
 * Описание полей username и newPassword для валидации
 */
public interface UserPasswordAwareDto {

    String getUsername();

    String getNewPassword();
}
