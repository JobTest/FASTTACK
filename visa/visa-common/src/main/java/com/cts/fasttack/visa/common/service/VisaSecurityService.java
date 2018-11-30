package com.cts.fasttack.visa.common.service;

/**
 * @author Anton Leliuk
 */
public interface VisaSecurityService {

    String createSharedSecretJwe(String text);
}
