package com.cts.fasttack.bank.server.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author d.ishchenko
 *
 */
public enum DeviceType {

    PHONE, TABLET, TABLET_OR_EREADER, WATCH, WATCH_OR_WRISTBAND, CARD, STICKER, PC, DEVICE_PERIPHERAL, TAG, JEWELRY, FASHION_ACCESSORY, GARMENT, DOMESTIC_APPLIANCE, VEHICLE, MEDIA_OR_GAMING_DEVICE, UNDEFINED;

    private final static Map<String, DeviceType> tokenInfoCodeMap = new HashMap<String, DeviceType>();

    public static DeviceType fromTokenInfoDeviceType(String code) {
        DeviceType result = tokenInfoCodeMap.get(code);

        if (result != null) {
            return result;
        } else {
            return UNDEFINED;
        }
    }

    static {
        tokenInfoCodeMap.put("03", WATCH);
        tokenInfoCodeMap.put("09", PHONE);
        tokenInfoCodeMap.put("13", TABLET_OR_EREADER);
        tokenInfoCodeMap.put("14", PHONE);
        tokenInfoCodeMap.put("15", TABLET_OR_EREADER);
        tokenInfoCodeMap.put("16", PHONE);
        tokenInfoCodeMap.put("17", TABLET_OR_EREADER);
        tokenInfoCodeMap.put("18", WATCH);
        tokenInfoCodeMap.put("19", WATCH);
        tokenInfoCodeMap.put("21", PHONE);
        tokenInfoCodeMap.put("22", TABLET);
        tokenInfoCodeMap.put("23", WATCH);
        tokenInfoCodeMap.put("24", STICKER);
        tokenInfoCodeMap.put("25", PC);
        tokenInfoCodeMap.put("26", DEVICE_PERIPHERAL);
        tokenInfoCodeMap.put("27", TAG);
        tokenInfoCodeMap.put("28", JEWELRY);
        tokenInfoCodeMap.put("29", FASHION_ACCESSORY);
        tokenInfoCodeMap.put("30", GARMENT);
        tokenInfoCodeMap.put("31", DOMESTIC_APPLIANCE);
        tokenInfoCodeMap.put("32", VEHICLE);
        tokenInfoCodeMap.put("33", MEDIA_OR_GAMING_DEVICE);
        tokenInfoCodeMap.put("99", UNDEFINED);
    }

}
