package com.cts.fasttack.admin.web.security.service;

import com.cts.fasttack.admin.web.security.data.UserAuthoritiesData;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("userAuthoritiesHolder")
public class DefaultUserAuthoritiesHolder implements UserAuthoritiesHolder {

    private static final Logger log = LogManager.getLogger(UserAuthoritiesHolder.class);

    private Map<String, UserAuthoritiesData> holder = new ConcurrentHashMap<>();

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public void removeAuthorities(String jSessionId) {
        UserAuthoritiesData removed = holder.remove(jSessionId);
        if (removed != null) {
            log.info("Remove authorities for user - " + removed.getUserId() + " for sessionId - " + jSessionId);
        }
    }

    @Override
    public void refreshAuthorities(ServletRequest request) {
        UserAuthoritiesDto currentUser = getCurrentUser();
        if (currentUser != null) {
            String sessionId = getCurrentJSessionId();
            log.info("Put authorities for user " + currentUser.getId() + " for sessionId - " + sessionId);
            holder.put(sessionId, new UserAuthoritiesData(currentUser, request.getRemoteAddr()));
        }
    }

    @Override
    public void discardAuthoritiesByUser(String userId) {
        log.info("Discard authorities for user - " + userId);
        for (Map.Entry<String, UserAuthoritiesData> entry : holder.entrySet()) {
            if (entry.getValue().getUserId().equalsIgnoreCase(userId)) {
                holder.put(entry.getKey(), entry.getValue().discard());
            }
        }
    }

    @Override
    public void discardAuthoritiesByRole(String roleId) {
        log.info("Discard authorities for role - " + roleId);
        for (Map.Entry<String, UserAuthoritiesData> entry : holder.entrySet()) {
            if (entry.getValue().getRoles().contains(roleId)) {
                holder.put(entry.getKey(), entry.getValue().discard());
            }
        }
    }

    @Override
    public boolean isCurrentUserAuthoritiesUpToDate() {
        UserAuthoritiesData data = holder.get(getCurrentJSessionId());
        return data != null && data.isUpToDate();
    }

    private String getCurrentJSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }

    private UserAuthoritiesDto getCurrentUser() {
        return currentUserService.getCurrentUser();
    }
}
