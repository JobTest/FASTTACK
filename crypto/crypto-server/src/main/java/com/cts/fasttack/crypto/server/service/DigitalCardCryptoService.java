package com.cts.fasttack.crypto.server.service;

/**
 * @author Anton Leliuk
 */
public interface DigitalCardCryptoService {

    /**
     * Шифрует номер карты (PAN) <p>
     * Зашифрованный пан имеет следующий формат: ADLXXXXXXXXXXXXXXXX - всего 19 символов. Пояснения: <p>
     * A... - признак того, что номер карты зашифрован. <p>
     * .D.. - последняя цифра "чистого" номера карты. <p>
     * ..L. - последняя цифра "длины" ноера карты. Для "стандартного" PAN'а из 16 цифр L = 6, для 13-ти L=3. <p>
     * ...XXX - зашифрованное значение PAN'а, 16 HEX-символов. <p>
     * @param pan номер карты (PAN)
     * @return зашифрованный номер карты
     */
    String encryptPan(String pan);
}
