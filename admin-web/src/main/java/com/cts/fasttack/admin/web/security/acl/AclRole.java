package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclRole")
public class AclRole extends AbstractAcl {

    public static Priv ROLE_CREATE = new Priv("ROLE_CREATE", "Создание записей в справочнике ролей");
    public static Priv ROLE_VIEW = new Priv("ROLE_VIEW", "Просмотр записей в справочнике ролей");
    public static Priv ROLE_EDIT = new Priv("ROLE_EDIT", "Редактирование записей в справочнике ролей");
    public static Priv ROLE_DELETE = new Priv("ROLE_DELETE", "Удаление записей в справочнике ролей");

    @Override
    public boolean isCanCreate() {
        return isHasPrivilege(ROLE_CREATE);
    }

    @Override
    public boolean isCanView() {
        return isHasPrivilege(ROLE_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return isHasPrivilege(ROLE_EDIT);
    }

    @Override
    public boolean isCanDelete() {
        return isHasPrivilege(ROLE_DELETE);
    }
}
