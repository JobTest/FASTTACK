package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component("aclBinSetup")
public class AclBinSetup extends AbstractAcl {

    private static final Priv BIN_VIEW = new Priv("BIN_VIEW", "Просмотр информации о Bin");
    private static final Priv BIN_CREATE = new Priv("BIN_CREATE", "Создание Bin");
    private static final Priv BIN_EDIT = new Priv("BIN_EDIT", "Редактирование Bin");
    private static final Priv BIN_DELETE = new Priv("BIN_DELETE", "Удаление Bin");

    @Override
    public boolean isCanView() {
        return isHasPrivilege(BIN_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return isHasPrivilege(BIN_EDIT);
    }

    @Override
    public boolean isCanCreate() {
        return isHasPrivilege(BIN_CREATE);
    }

    @Override
    public boolean isCanDelete() {
        return isHasPrivilege(BIN_DELETE);
    }
}
