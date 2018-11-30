package com.cts.fasttack.common.core.rest.jwt.service;

import com.cts.fasttack.common.core.rest.jwt.config.JwtParameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anton Leliuk
 */
public class JwtServiceTest {

    private JwtService service;

    @Before
    public void before() throws Exception {
        JwtParameters parameters = new JwtParameters();
        parameters.setSharedSecret("$xudFxQpSqrO/apXPJ5J/jXFiaBBMdC8ZA#3Zkh2");
        parameters.afterPropertiesSet();

        service = new JwtServiceImpl(parameters);
    }

    @Test
    public void signAndVerify() throws Exception {
        String signature = service.sign("GUI", 10);
        Assert.assertNotNull(signature);
        Assert.assertTrue(service.verify(signature));
    }

    @Test
    public void invalidSignature() throws Exception {
        Assert.assertFalse(service.verify("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJHVUkiLCJleHAiOjE1MjA2MzcyNzN9.OiE_KfpCREVbasXru6kotdB3SwJ--r2u0i4FOufl5xw+1"));
    }

    @Test
    public void signatureExpired() throws Exception {
        String signature = service.sign("GUI", 1);
        Assert.assertNotNull(signature);
        Thread.sleep(2000);
        Assert.assertFalse(service.verify(signature));
    }


}
