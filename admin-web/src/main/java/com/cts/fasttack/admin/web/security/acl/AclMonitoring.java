package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component("aclMonitoring")
public class AclMonitoring extends AbstractAcl {

    public static Priv MONITORING_VIEW = new Priv("MONITORING_VIEW", "Просмотр страницы monitoring");

    @Override
    public boolean isCanView() {
        return isHasPrivilege(MONITORING_VIEW);
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
