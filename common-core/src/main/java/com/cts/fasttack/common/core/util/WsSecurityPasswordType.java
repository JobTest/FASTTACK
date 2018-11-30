package com.cts.fasttack.common.core.util;

public interface WsSecurityPasswordType {

    String PASSWORD_TEXT = "PasswordText";

    String PASSWORD_DIGEST = "PasswordDigest";

    String PASSWORD_DIGEST_EXT = "PasswordDigestExt";

    String[] passwordTypes = { PASSWORD_TEXT, PASSWORD_DIGEST, PASSWORD_DIGEST_EXT };
}
