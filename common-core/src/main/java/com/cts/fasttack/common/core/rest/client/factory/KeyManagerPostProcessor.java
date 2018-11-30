package com.cts.fasttack.common.core.rest.client.factory;

import java.security.KeyStore;
import javax.net.ssl.KeyManager;

/**
 * @author Anton Leliuk
 */
public interface KeyManagerPostProcessor {

    KeyManager[] postProcessAfterInitialization(KeyManager[] keyManagers, KeyStore pkcs11KeyStore);
}
