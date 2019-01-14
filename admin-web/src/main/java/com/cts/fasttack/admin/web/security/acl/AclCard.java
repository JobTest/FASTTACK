package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclCard")
public class AclCard extends AbstractAcl {

    public static Priv CARD_VIEW = new Priv("CARD_VIEW", "Просмотр информации о карте");
    public static Priv CARD_UPDATE = new Priv("CARD_UPDATE", "Перевыпуск карты");

    @Override
    public boolean isCanView() {
        return isHasPrivilege(CARD_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return false;
    }

    @Override
    public boolean isCanCreate() {
        return false;
    }

    public boolean isCanUpdate(){
        return isHasPrivilege(CARD_UPDATE);
    }

    @Override
    public boolean isCanDelete() {
        return false;
    }
}
