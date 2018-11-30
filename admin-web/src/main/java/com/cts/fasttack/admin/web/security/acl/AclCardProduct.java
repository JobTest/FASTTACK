package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;

@Component("aclCardProduct")
public class AclCardProduct extends AbstractAcl {

    public static Priv CARD_PROPRODUCT_CREATE = new Priv("CARD_PROPRODUCT_CREATE", "Создание карточного продукта");
    public static Priv CARD_PROPRODUCT_VIEW = new Priv("CARD_PROPRODUCT_VIEW", "Просмотр карточного продукта");
    public static Priv CARD_PROPRODUCT_EDIT = new Priv("CARD_PROPRODUCT_EDIT", "Редактирование карточного продукта");
    public static Priv CARD_PROPRODUCT_DELETE = new Priv("CARD_PROPRODUCT_DELETE", "Удаление карточного продукта");

    @Override
    public boolean isCanCreate() {
        return isHasPrivilege(CARD_PROPRODUCT_CREATE);
    }

    @Override
    public boolean isCanView() {
        return isHasPrivilege(CARD_PROPRODUCT_VIEW);
    }

    @Override
    public boolean isCanEdit() {
        return isHasPrivilege(CARD_PROPRODUCT_EDIT);
    }

    @Override
    public boolean isCanDelete() {
        return isHasPrivilege(CARD_PROPRODUCT_DELETE);
    }
}
