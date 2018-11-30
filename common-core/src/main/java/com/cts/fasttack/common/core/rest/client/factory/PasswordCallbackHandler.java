package com.cts.fasttack.common.core.rest.client.factory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * @author Anton Leliuk
 */
public class PasswordCallbackHandler implements CallbackHandler {

    private String password;

    public PasswordCallbackHandler(String password) {
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            if (cb instanceof PasswordCallback) {
                PasswordCallback pcb = (PasswordCallback) cb;
                pcb.setPassword(password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[0]);
            }
        }
    }
}
