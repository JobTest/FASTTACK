package com.cts.fasttack.common.core.dict;

import org.apache.commons.lang3.StringUtils;

/**
 * Source of the PAN
 *
 * @author a.lipavets
 */
public enum PanSourceType {
    /**
     * KEY_ENTERED
     */
    K,
    /**
     * ON_FILE
     */
    O,
    /**
     * MOBILE_BANKING_APP
     */
    M;


	private final static String KEY_ENTERED = "KEY_ENTERED";
	private final static String ON_FILE = "ON_FILE";
	private final static String MOBILE_BANKING_APP = "MOBILE_BANKING_APP";
	
    public static PanSourceType valueOfFirstWord(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        switch (value) {
            case KEY_ENTERED:
                return K;
            case ON_FILE:
                return O;
            case MOBILE_BANKING_APP:
                return M;

        }
        return null;
    }

    public static String valueOfFirstWordAsNullableString(String value) {
    	PanSourceType pst = PanSourceType.valueOfFirstWord(value);
    	
		if (pst == null) {
			return null;
		}
		return pst.name();
    }

    public static PanSourceType getInstance(String key){
        for(PanSourceType t : values()){
            if(t.name().equals(key)){
                return t;
            }
        }
        return null;
    }
    
	public static PanSourceType fromVisaIwsiPanSource(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
		switch (value) {
		case "01":
			return K;
		case "02":
			return O;
		case "03":
			return M;
		}
		return null;
	}
    
	public static String fromVisaIwsiPanSourceAsNullableString(String value) {
		PanSourceType pst = PanSourceType.fromVisaIwsiPanSource(value);
		
		if (pst == null) {
			return null;
		}
		return pst.name();
	}

	public static String firstWordFromVisaIwsiPanSource(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
		switch (value) {
		case "01":
			return KEY_ENTERED;
		case "02":
			return ON_FILE;
		case "03":
			return MOBILE_BANKING_APP;
		}
		return null;
	}
}
