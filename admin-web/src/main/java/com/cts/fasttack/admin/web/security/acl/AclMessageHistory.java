package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

/**
 * Access control list for message history.
 *
 * @author v.semerkov
 */
@Component("aclMessageHistory")
public class AclMessageHistory extends AbstractAcl {

    public static Priv MESSAGE_HISTORY_VIEW = new Priv("MESSAGE_HISTORY_VIEW", "Просмотр системных журналов");

    @Override
    public boolean isCanView() {
        return isHasPrivilege(MESSAGE_HISTORY_VIEW);
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
