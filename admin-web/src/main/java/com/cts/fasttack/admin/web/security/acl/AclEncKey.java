package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclEncKey")
public class AclEncKey extends AbstractAcl {

    public static Priv ENC_KEY_CREATE = new Priv("ENC_KEY_CREATE", "Создание записи ключа");
    public static Priv ENC_KEY_VIEW = new Priv("ENC_KEY_VIEW", "Просмотр записи ключа");
    public static Priv ENC_KEY_EDIT = new Priv("ENC_KEY_EDIT", "Редактирование записи ключа");
    public static Priv ENC_KEY_DELETE = new Priv("ENC_KEY_DELETE", "Удаление записи ключа");


    public boolean isCanCreate(){
        return isHasPrivilege(ENC_KEY_CREATE);
    }

    public boolean isCanView(){
        return isHasPrivilege(ENC_KEY_VIEW);
    }

    public boolean isCanEdit(){
        return isHasPrivilege(ENC_KEY_EDIT);
    }

    public boolean isCanDelete(){
        return isHasPrivilege(ENC_KEY_DELETE);
    }

}
