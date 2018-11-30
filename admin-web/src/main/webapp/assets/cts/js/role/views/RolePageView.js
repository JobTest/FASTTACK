(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "role/role_view_template",
            'common.util.ajax',
            'common.util.url',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, Common, SecurityModels, roleViewTemplate) {
        var RolePageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: roleViewTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Role({id: Common.Url.parse().id});
                this.model.fetch({async: false});
                this.superInitBeforeRender(SimpleViewWithModel, opts);
                this.addEvent("click .btnDelete", "_deleteRole");
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            },
            _deleteRole: function () {
                if (confirm(Common.bundles.getMessage("common.confirmDelete"))) {
                    this.model.destroy({
                        success: function () {
                            Common.navigateToUrl("role/list.htm");
                        }
                    });
                } else {
                    return false;
                }
            }
        });

        new RolePageView();
    }
);