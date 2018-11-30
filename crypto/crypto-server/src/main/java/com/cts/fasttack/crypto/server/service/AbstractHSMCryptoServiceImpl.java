package com.cts.fasttack.crypto.server.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKeyId;
import com.cts.fasttack.crypto.server.data.EncKeyValueHolder;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;
import com.cts.fasttack.crypto.server.util.CryptoEngineWrapper;

import cts.mobo.hsm.objects.KeyHandle;

/**
 * Абстрактный класс для крипто-сервисов, реализующий функции реистрации ключей и связь с CryptoEngine.
 */
public abstract class AbstractHSMCryptoServiceImpl implements KeySupportService, CryptoService {

	public static final String KEY_REFCODE = "FASTTACK";
	
    protected final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private CryptoEngineHolder cryptoEngineHolder;

    @Autowired
    protected EncKeyService encKeyService;

    protected Map<EncKeyId, KeyHandle> keysMap = new ConcurrentHashMap<>();

    protected abstract KeyType[] getSupportedKeyTypes();

    @PostConstruct
    public void init() {
        for (KeyType keyType : getSupportedKeyTypes()) {
            registerKeys(keyType);
        }
        encKeyService.registerKeySupportService(this);
    }

    protected void registerKeys(KeyType type) {
        EncKeyValueHolder[] keys = getEncKeyService().listActiveKeysByType(type);
        for (EncKeyValueHolder key : keys) {
            registerKey(new EncKeyId(key.getKeyType(), key.getRefCode()), key);
        }
    }

    protected void registerKey(EncKeyId keyId, EncKeyValueHolder key) {
        EncKeyDto keyDto = (EncKeyDto) key;
        try {
            if (EncKeyService.isActive(keyDto)) {
                KeyHandle keyHandle;
                if (keyId.getAlg().isSymmetric()) {
                    keyHandle = cryptoWrapper().unwrapSymmetricUnderLMK(keyId.getAlg().getSymmetricKeyType(), key.getKeyValue());
                } else if (keyId.getAlg().isPrivate()) {
                    keyHandle = cryptoWrapper().unwrapRsaUnderLMK(key.getKeyValue());
                } else if (keyId.getAlg().isPublic()) {
                    keyHandle = cryptoWrapper().createRsaPublicKey(key.getKeyValue(), key.getPublicExponent());
                } else if (keyId.getAlg().isCertificate()) {
                    keyHandle = cryptoWrapper().createRsaCertificate(key.getKeyValue());
                } else {
                    throw new RuntimeException("Couldn't define how to register key " + key.getKeyType() + " of keyAlg " + keyId.getAlg());
                }
                keysMap.put(keyId, keyHandle);
                log.info("Registered key " + keyId + " in crypto engine");
            }
        } catch(Exception e) {
            log.error("Couldn't register key " + keyId + " in crypto engine", e);
        }
    }

    protected void removeKey(EncKeyId keyId, KeyHandle keyHandle) {
        try {
            if (keyId.getAlg().isSymmetric()) {
                cryptoWrapper().deleteSymmetricKey(keyHandle);
            } else if (keyId.getAlg().isPrivate() || keyId.getAlg().isPublic()) {
                cryptoWrapper().deleteRSAKey(keyHandle);
            } else {
                throw new RuntimeException("Couldn't define how to delete key " + keyId.getKeyType() + " of keyAlg " + keyId.getAlg());
            }
            keysMap.remove(keyId);
            log.info("Removed key " + keyId + " from crypto engine");
        } catch(Exception e) {
            log.error("Couldn't remove key " + keyId + " from crypto engine", e);
        }
    }

    protected EncKeyService getEncKeyService(){
        return encKeyService;
    }

    public void setCryptoEngineHolder(CryptoEngineHolder cryptoEngineHolderImpl) {
        this.cryptoEngineHolder = cryptoEngineHolderImpl;
    }

    public Map.Entry<EncKeyId, KeyHandle> getKeyEntry(EncKeyId encKeyId){
        for (Map.Entry<EncKeyId, KeyHandle> entry : keysMap.entrySet()) {
            if(encKeyId.equals(entry.getKey())){
                return entry;
            }
        }
        return null;
    }

    @Override
    public void notifyChangeKey(EncKeyValueHolder encKeyHolder, boolean delete){
        EncKeyId encKeyId = new EncKeyId(encKeyHolder.getKeyType(), encKeyHolder.getRefCode());
        Map.Entry<EncKeyId, KeyHandle> entry =  getKeyEntry(encKeyId);
        if (entry != null){
            if (delete){
                log.info("Remove key " + entry.getKey() + " from crypto engine");
                removeKey(entry.getKey(), entry.getValue());
            } else {
                log.info("Trying to re-register key... " + entry.getKey() + " in crypto engine");
                registerKey(entry.getKey(), encKeyHolder);
            }
        } else if(!delete && supportsKeyType(encKeyId.getKeyType())) {
            log.info("Trying to register key... " + encKeyId + " in crypto engine");
            registerKey(encKeyId, encKeyHolder);
        }
    }

    protected boolean supportsKeyType(KeyType keyType) {
        for (KeyType kt : getSupportedKeyTypes()) {
            if (keyType.equals(kt)) {
                return true;
            }
        }
        return false;
    }

    protected  Map<EncKeyId, KeyHandle> getKeysMap(){
        return keysMap;
    }

    public KeyHandle getKeyByEncKeyId(EncKeyId id){
        KeyHandle keyHandle = getKeysMap().get(id);
        if(keyHandle == null){
            log.warn("Couldn't find KeyHandle by id "+id.toString());
            throw new CryptographyException("Couldn't find KeyHandle by id "+id.toString());
        }
        return keyHandle;
    }

    protected CryptoEngineWrapper cryptoWrapper(){
        return cryptoEngineHolder.getWrapper();
    }

}
