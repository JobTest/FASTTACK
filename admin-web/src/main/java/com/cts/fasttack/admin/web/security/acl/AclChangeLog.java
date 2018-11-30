package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component
public class AclChangeLog extends AbstractAcl {

    public static Priv CHANGE_LOG_VIEW = new Priv("CHANGE_LOG_VIEW", "Просмотр Журнала изменений объектов");

    public boolean isCanView(){
        return isHasPrivilege(CHANGE_LOG_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return false;
    }

    @Override
    public boolean isCanCreate() {
        return false;
    }

    @Override
    public boolean isCanDelete() {
        return false;
    }
}
