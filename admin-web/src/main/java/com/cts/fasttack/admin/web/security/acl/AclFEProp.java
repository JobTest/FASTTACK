package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclFEProp")
public class AclFEProp extends AbstractAcl {

    public static Priv FE_PROP_CREATE = new Priv("FE_PROP_CREATE", "Создание записей в справочнике параметров банка");
    public static Priv FE_PROP_VIEW = new Priv("FE_PROP_VIEW", "Просмотр записей в справочнике параметров банка");
    public static Priv FE_PROP_EDIT = new Priv("FE_PROP_EDIT", "Редактирование записей в справочнике параметров банка");
    public static Priv FE_PROP_DELETE = new Priv("FE_PROP_DELETE", "Удаление записей в справочнике параметров банка");

    @Override
    public boolean isCanCreate() {
        return isHasPrivilege(FE_PROP_CREATE);
    }

    @Override
    public boolean isCanView() {
        return isHasPrivilege(FE_PROP_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return isHasPrivilege(FE_PROP_EDIT);
    }

    @Override
    public boolean isCanDelete() {
        return isHasPrivilege(FE_PROP_DELETE);
    }
}
