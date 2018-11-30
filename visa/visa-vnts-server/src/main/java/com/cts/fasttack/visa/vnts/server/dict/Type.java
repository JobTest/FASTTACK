package com.cts.fasttack.visa.vnts.server.dict;

/**
 * @author a.lipavets
 */
public enum Type {
    cell_phone,
    email,
    bank_app,
    customer_service,
    outbound_call;

    public static Type getInstance(String key){
        for(Type t : values()){
            if(t.name().equals(key)){
                return t;
            }
        }
        return null;
    }
}
