(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.acls',[
            'common.util.core'], factory);
    } else {
        factory();
    }
})(
    function (Common) {
        Common.acls = {};
        Common.acls.isHasPrivilege = function(code){
            return AppCommon.isHasPrivilege(code);
        };
        Common.acls.isHasAnyPrivilege = function(privileges){
            for (var i = 0; i < privileges.length; i++) {
                if(Common.acls.isHasPrivilege(privileges[i])){
                    return true;
                }
            }
            return false;
        };
        Common.acls.isHasAllPrivileges = function(privileges){
            for (var i = 0; i < privileges.length; i++) {
                if(!Common.acls.isHasPrivilege(privileges[i])){
                    return false;
                }
            }
            return true;
        };
        return Common;
    }
);
