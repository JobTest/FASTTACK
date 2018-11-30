package com.cts.fasttack.common.core.rest.client.factory;

import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

/**
 * KeyManager to select a key with desired alias while delegating processing to specified KeyManager
 * and used {@link KeyStore} based on HSM to get {@link PrivateKey}
 * @author Anton Leliuk
 */
public class AliasedX509ExtendedKeyManager extends X509ExtendedKeyManager {

    private X509KeyManager keyManager;
    private KeyStore keyStore;
    private String clientCertificateAlias;
    private String keyStorePassword;

    public AliasedX509ExtendedKeyManager(X509KeyManager keyManager, KeyStore keyStore, String clientCertificateAlias, String keyStorePassword) {
        this.keyManager = keyManager;
        this.keyStore = keyStore;
        this.clientCertificateAlias = clientCertificateAlias;
        this.keyStorePassword = keyStorePassword;
    }

    @Override
    public String chooseEngineClientAlias(String[] strings, Principal[] principals, SSLEngine sslEngine) {
        return clientCertificateAlias;
    }

    @Override
    public String[] getClientAliases(String s, Principal[] principals) {
        return keyManager.getClientAliases(s, principals);
    }

    @Override
    public String chooseClientAlias(String[] strings, Principal[] principals, Socket socket) {
        return clientCertificateAlias;
    }

    @Override
    public String[] getServerAliases(String s, Principal[] principals) {
        return keyManager.getServerAliases(s, principals);
    }

    @Override
    public String chooseServerAlias(String s, Principal[] principals, Socket socket) {
        return keyManager.chooseServerAlias(s, principals, socket);
    }

    @Override
    public X509Certificate[] getCertificateChain(String s) {
        X509Certificate[] result;

        try {
            Certificate[] cc = keyStore.getCertificateChain(clientCertificateAlias);
            result = new X509Certificate[cc.length];
            int i = 0;

            for (Certificate cert : cc) {
                if (cert instanceof X509Certificate) {
                    result[i] = (X509Certificate) cert;
                    i++;
                }
            }
        } catch (KeyStoreException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    @Override
    public PrivateKey getPrivateKey(String s) {
        PrivateKey result = null;

        try {
            Key key = keyStore.getKey(clientCertificateAlias, keyStorePassword.toCharArray());

            if (key instanceof PrivateKey) {
                result = (PrivateKey) key;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }
}
