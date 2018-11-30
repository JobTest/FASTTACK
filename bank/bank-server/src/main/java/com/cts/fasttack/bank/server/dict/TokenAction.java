package com.cts.fasttack.bank.server.dict;

/**
 * @author a.lipavets
 */
public enum TokenAction {
    Activate,
    Deactivate,
    Suspend,
    Resume;

    public static TokenAction getInstance(String key){
        for(TokenAction action : values()){
            if(action.name().equals(key)){
                return action;
            }
        }
        return null;
    }
}
