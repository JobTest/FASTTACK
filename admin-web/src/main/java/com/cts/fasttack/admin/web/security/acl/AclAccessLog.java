package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclAccessLog")
public class AclAccessLog extends AbstractAcl {

    public static Priv ACCESS_LOG_VIEW = new Priv("ACCESS_LOG_VIEW", "Просмотр записей в логе доступа");

    public boolean isCanView(){
        return isHasPrivilege(ACCESS_LOG_VIEW);
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
