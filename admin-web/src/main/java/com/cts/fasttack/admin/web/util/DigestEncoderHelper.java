package com.cts.fasttack.admin.web.util;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * Helper for encode digest
 *
 * @author n.bizin
 */
public class DigestEncoderHelper {

    public static final ShaPasswordEncoder SHA_PASSWORD_ENCODER = new ShaPasswordEncoder(512);

    public static String encode(String digest, String salt) {
        if (digest != null) {
            return SHA_PASSWORD_ENCODER.encodePassword(digest, salt);
        }
        return null;
    }
}
