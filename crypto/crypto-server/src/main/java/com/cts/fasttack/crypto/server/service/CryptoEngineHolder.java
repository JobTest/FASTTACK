package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.crypto.server.util.CryptoEngineWrapper;
import cts.mobo.hsm.CryptoEngine;

/**
 * Отвечает за единоразовую инициализацию Hsm, HsmSession и создание CryptoEngine.
 */
public interface CryptoEngineHolder {

    CryptoEngine getEngine();

    CryptoEngineWrapper getWrapper();

}
