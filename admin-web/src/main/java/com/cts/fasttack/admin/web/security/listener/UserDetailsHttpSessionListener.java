package com.cts.fasttack.admin.web.security.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cts.fasttack.admin.web.util.AlfaBankAuthenticationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.cts.fasttack.admin.web.security.service.UserAuthoritiesHolder;

/**
 * Listener which remove user authorities when session is destroyed
 *
 * @author Anton Leliuk
 */
public class UserDetailsHttpSessionListener implements HttpSessionListener {

    @Autowired
    private AlfaBankAuthenticationHelper alfaBankAuthenticationHelper;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        if (alfaBankAuthenticationHelper.isReclaimUsersFromAlfaBank()) alfaBankAuthenticationHelper.deleteCurrentUser();

        ((UserAuthoritiesHolder) WebApplicationContextUtils.getWebApplicationContext(event.getSession().getServletContext()).getBean("userAuthoritiesHolder")).removeAuthorities(event.getSession().getId());
    }
}
