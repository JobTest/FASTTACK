package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclUser")
public class AclUser extends AbstractAcl {

    public static Priv USER_CREATE = new Priv("USER_CREATE", "Создание записей в справочнике пользователей");
    public static Priv USER_VIEW = new Priv("USER_VIEW", "Просмотр записей в справочнике пользователей");
    public static Priv USER_EDIT = new Priv("USER_EDIT", "Редактирование записей в справочнике пользователей");
    public static Priv USER_DELETE = new Priv("USER_DELETE", "Удаление записей в справочнике пользователей");
    public static Priv USER_CHANGE_PASSWORD = new Priv("USER_CHANGE_PASSWORD","Изменение пароля пользователя");

    @Override
    public boolean isCanCreate(){
        return isHasPrivilege(USER_CREATE);
    }

    @Override
    public boolean isCanView(){
        return isHasPrivilege(USER_VIEW);
    }

    @Override
    public boolean isCanEdit(){
        return isHasPrivilege(USER_EDIT);
    }

    @Override
    public boolean isCanDelete(){
        return isHasPrivilege(USER_DELETE);
    }

    public boolean isCanChangePassword(){
        return isHasPrivilege(USER_CHANGE_PASSWORD);
    }
}
