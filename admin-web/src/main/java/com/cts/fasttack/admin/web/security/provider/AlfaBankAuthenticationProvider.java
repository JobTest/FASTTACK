package com.cts.fasttack.admin.web.security.provider;

import com.cts.fasttack.admin.web.util.AlfaBankAuthenticationHelper;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthenticateRequestDto;
import com.cts.fasttack.jms.dto.AuthenticateJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthenticateResponseDto;
import com.cts.fasttack.jms.dto.JmsGetUserRolesRequestDto;
import com.cts.fasttack.jms.dto.GetUserRolesJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetUserRolesResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @see www.baeldung.com/spring-security-authentication-provider
 */

@Component
public class AlfaBankAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LogManager.getLogger(AlfaBankAuthenticationProvider.class);

    private static final String SYSTEM_NAME = "CTS";

    @Autowired
    private AlfaBankAuthenticationHelper alfaBankAuthenticationHelper;

    @Autowired
    private IntegrationBus integrationBus;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        boolean isLdapAuthentication = isLdapAuthentication(username, password);
        if (isLdapAuthentication) {
            log.info("Ldap authentication for user {} is successfully", username);

            List<String> roles = getUserRoles(username);
            alfaBankAuthenticationHelper.saveOrUpdate(username, password, roles);
        } else {
            log.warn("Ldap authentication for user {} is failed", username);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public boolean isLdapFromAlfaBank() {
        return alfaBankAuthenticationHelper.isLdapFromAlfaBank();
    }

    public boolean isReclaimUsersFromAlfaBank() {
        return alfaBankAuthenticationHelper.isReclaimUsersFromAlfaBank();
    }

    private boolean isLdapAuthentication(String username, String password) {
        JmsAuthenticateRequestDto jmsAuthenticateRequestDto = new JmsAuthenticateRequestDto();
        jmsAuthenticateRequestDto.setUser(username);
        jmsAuthenticateRequestDto.setPassword(password);

        try {
            HeadersJmsMessage jmsMessage = new AuthenticateJmsMessage()
                    .jmsAuthenticateRequestDto(jmsAuthenticateRequestDto)
                    .originator("USER");

            return integrationBus.inOut(() -> "BANK", "authenticate", jmsMessage, JmsAuthenticateResponseDto.class)
                    .isIsAuthenticated();
        } catch (ServiceException se) {
            log.warn("Can't authentication user because of timeout or no response from server.");
        }
        return false;
    }

    private List<String> getUserRoles(String username) {
        JmsGetUserRolesRequestDto jmsGetUserRolesRequestDto = new JmsGetUserRolesRequestDto();
        jmsGetUserRolesRequestDto.setUser(username);
        jmsGetUserRolesRequestDto.setSystemName(SYSTEM_NAME);

        try {
            HeadersJmsMessage jmsMessage = new GetUserRolesJmsMessage()
                    .jmsGetUserRolesRequestDto(jmsGetUserRolesRequestDto)
                    .originator("USER");

            String jsonUserRoles =  integrationBus.inOut(() -> "BANK", "getUserRoles", jmsMessage, JmsGetUserRolesResponseDto.class)
                    .getUserRoles();
            return alfaBankAuthenticationHelper.getUserRoles(jsonUserRoles);
        } catch (ServiceException se) {
            log.warn("Can't get User Roles because of timeout or no response from server.");
        }
        return null;
    }
}