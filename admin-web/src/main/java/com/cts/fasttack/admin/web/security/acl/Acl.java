package com.cts.fasttack.admin.web.security.acl;

public interface Acl {

    boolean isHasPrivilege(Priv priv);

    boolean isCanView();

    boolean isCanEdit();

    boolean isCanCreate();

    boolean isCanDelete();
}
