package com.cts.fasttack.core.data;

import java.io.Serializable;

/**
 * @author a.lipavets
 */
public interface TokenInfoIdable extends Serializable {

    String getTokenRefId();

    String getTokenRequestorId();
}
