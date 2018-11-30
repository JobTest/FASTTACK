package com.cts.fasttack.admin.web.security.service;

import javax.servlet.ServletRequest;

/**
 * Хранение залогиненых пользователей с признаком актуальности их данных и прав.
 *
 * @author Anton Leliuk
 */
public interface UserAuthoritiesHolder {

    /**
     * Удаляются данные о залогиненом пользователе, когда сессия становится невалидной. Это происходит даже когда пользователь просто разлогинивается с системы.<br/><br/>
     * Для этого вешаем {@link UserDetailsHttpSessionListener} и выполняем <code>removeAuthorities()</code> внутри реализации метода <code>sessionDestroyed()</code>
     *
     * @param jSessionId id невалидной сессии
     */
    void removeAuthorities(String jSessionId);

    /**
     * Добавляет или обновляет данные о залогиненом пользователе включая IP-адрес. Выполняется:
     * <ul><li>когда пользователь залогинивается в систему {@link AuthenticationSuccessHandler} <code>onSuccessfulAuthentication()</code>,</li>
     * <li>когда данные или права залогиненного пользователя становятся неактуальными {@link ReAuthenticationFilterSecurityInterceptor} <code>reauthenticateIfRequired()</code>.</li></ul>
     *
     * @param request {@link ServletRequest}
     */
    void refreshAuthorities(ServletRequest request);

    /**
     * Обозначает, что данные или права пользователя стали неактуальными. Выполняется при редактировании данных или прав пользователя
     *
     * @param userId id пользователя, чьи данные или права были изменены
     */
    void discardAuthoritiesByUser(String userId);

    /**
     * Обозначает, что права всех пользователей с данной ролью стали неактуальными. Вызывается при редактировании карточки роли
     */
    void discardAuthoritiesByRole(String roleId);

    /**
     * @return <code>true</code> если данные или права залогиненного пользователя являются актуальными
     */
    boolean isCurrentUserAuthoritiesUpToDate();
}
