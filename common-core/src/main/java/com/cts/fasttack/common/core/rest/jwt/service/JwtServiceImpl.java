package com.cts.fasttack.common.core.rest.jwt.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.rest.jwt.config.JwtParameters;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Anton Leliuk
 */
@Service("jwtService")
public class JwtServiceImpl implements JwtService {

    private Logger log = LogManager.getLogger(JwtService.class);

    private final JwtParameters parameters;

    @Autowired
    public JwtServiceImpl(JwtParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String sign(String originator, long ttl) throws ServiceException {
        try {
            // Prepare JWT with claims set
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(originator)
                    .expirationTime(Date.from(LocalDateTime.now().plusSeconds(ttl).atZone(ZoneId.systemDefault()).toInstant()))
                    .build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JwtParameters.JWS_ALGORITHM), claimsSet);
            // Apply the HMAC protection
            signedJWT.sign(parameters.getSigner());
            return signedJWT.serialize();
        } catch (Exception e) {
            log.error("Error while sign", e);
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }

    }

    @Override
    public boolean verify(String signature) throws ServiceException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(signature);
            return signedJWT.verify(parameters.getVerifier()) &&
                    new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime());
        } catch (Exception e) {
            log.error("Error while verify signature", e);
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }
    }
}
