package com.cts.fasttack.admin.web.security.data;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for reAuthenticate users
 * @author Anton Leliuk
 */
public class ReAuthenticationMessage extends HeadersJmsMessage {

    private String userId;

    private String roleId;

    public static ReAuthenticationMessage forUser(String userId) {
        ReAuthenticationMessage message = new ReAuthenticationMessage();
        message.setUserId(userId);
        return message;
    }

    public static ReAuthenticationMessage forRole(String roleId) {
        ReAuthenticationMessage message = new ReAuthenticationMessage();
        message.setRoleId(roleId);
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
