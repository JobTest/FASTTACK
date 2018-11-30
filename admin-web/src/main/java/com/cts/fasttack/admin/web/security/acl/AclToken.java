package com.cts.fasttack.admin.web.security.acl;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.TokenEventStatus;

/**
 * @author Anton Leliuk
 */
@Component("aclToken")
public class AclToken extends AbstractAcl {

    private static final Priv TOKEN_VIEW = new Priv("TOKEN_VIEW", "Просмотр информации о токене");
    private static final Priv TOKEN_ACTIVATE = new Priv("TOKEN_ACTIVATE", "Активация токена");
    private static final Priv TOKEN_SUSPEND = new Priv("TOKEN_SUSPEND", "Приостановка токена");
    private static final Priv TOKEN_RESUME = new Priv("TOKEN_RESUME", "Восстановление токена");
    private static final Priv TOKEN_DELETE = new Priv("TOKEN_DELETE", "Удаление токена");
    private static final Priv TOKEN_ADD_COMMENT = new Priv("TOKEN_ADD_COMMENT", "Добавление комментариев");
    private static final Priv TOKEN_UPDATE = new Priv("TOKEN_UPDATE", "Редактирование токена");

    @Override
    public boolean isCanView() {
        return isHasPrivilege(TOKEN_VIEW);
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
        return isHasPrivilege(TOKEN_DELETE);
    }

    public boolean isCanActivate() {
        return isHasPrivilege(TOKEN_ACTIVATE);
    }

    public boolean isCanSuspend() {
        return isHasPrivilege(TOKEN_SUSPEND);
    }

    public boolean isCanResume() {
        return isHasPrivilege(TOKEN_RESUME);
    }

    public boolean isCanAddComment() {
        return isHasPrivilege(TOKEN_ADD_COMMENT);
    }

    public boolean isCanUpdate(){
        return isHasPrivilege(TOKEN_UPDATE);
    }

    public boolean isCanModify(TokenEventStatus value) {
        switch (value.name()) {
            case "ACTIVATE":
                return isCanActivate();
            case "DELETE":
                return isCanDelete();
            case "SUSPEND":
                return isCanSuspend();
            case "RESUME":
                return isCanResume();
        }
        return false;
    }
}
