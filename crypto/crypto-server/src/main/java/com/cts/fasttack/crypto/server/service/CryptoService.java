package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.crypto.server.data.EncKeyId;
import cts.mobo.hsm.objects.KeyHandle;

/**
 * @author Anton Leliuk
 */
public interface CryptoService {

    KeyHandle getKeyByEncKeyId(EncKeyId id);
}
