package com.cts.fasttack.crypto.server.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.crypto.server.conf.CryptoEngineConfiguration;
import com.cts.fasttack.crypto.server.util.CryptoEngineWrapper;

import cts.mobo.hsm.CryptoEngine;
import cts.mobo.hsm.Hsm;
import cts.mobo.hsm.HsmSession;

/**
 * Отвечает за единоразовую инициализацию Hsm, HsmSession и создание CryptoEngine.
 */
@Component
public class CryptoEngineHolderImpl implements CryptoEngineHolder {

    private final Logger log = LogManager.getLogger(getClass());

    private CryptoEngineConfiguration configuration;

    private CryptoEngine cryptoEngine;

    private CryptoEngineWrapper wrapper;

    @PostConstruct
    public void init() {
        log.info("Initializing HSM on slot " + configuration.getSlotId() + "...");
        Hsm.hsm_initialize();
        HsmSession hsmSession = new HsmSession(configuration.getSlotId(), configuration.getPassword(), true);
        cryptoEngine = new CryptoEngine(hsmSession);
        wrapper = new CryptoEngineWrapper(cryptoEngine);
        log.info("HSM has been initialized");
    }

    @Override
    public CryptoEngine getEngine() {
        if (cryptoEngine == null) {
            throw new IllegalStateException("CryptoEngine getEngine - cryptoEngine isn't initialized");
        }
        return cryptoEngine;
    }

    @Override
    public CryptoEngineWrapper getWrapper() {
        if (cryptoEngine == null) {
            throw new IllegalStateException("CryptoEngineWrapper getWrapper - cryptoEngine isn't initialized");
        }
        return wrapper;
    }

	@PreDestroy
	public void finalizeHSM() {

		log.info("Finalizing HSM...");
		if (cryptoEngine != null) {
			HsmSession session = cryptoEngine.getHsmSession();
			// удаляем ссылку на engine до закрытия сессии, чтобы никто не
			// обратился к закрытой сессии
			cryptoEngine = null;
			wrapper = null;
			if (session != null) {
				session.closeSession();
			}
			Hsm.hsm_finalize();
			log.info("HSM has been finalized");
		}
	}

	@Autowired
    public void setConfiguration(CryptoEngineConfiguration configuration) {
        this.configuration = configuration;
    }
}
