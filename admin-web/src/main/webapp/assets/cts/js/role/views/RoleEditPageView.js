(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "role/role_edit_template",
            'select2',
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels, roleEditTemplate) {
        var RoleEditView = InputAwareViewWithValidation.extend({
            el: "#role-edit-container",
            template: roleEditTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Role({id: Common.Url.parse().id});
                this.model.fetch({async: false});

                this.privilegeList = Common.ajax.sync({
                    url: "privilege/filter.json",
                    method: "POST",
                    data: JSON.stringify({unlimited: true})
                }).objects;

                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', "_saveRole");
            },
            initAfterRender: function () {
                this.delegateEvents();
                Common.applySelect2(this.$el.find("#privileges"), this.privilegeList);
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            _saveRole: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("role/view.htm?id=" + this.model.get("id"));
                    }
                }
            }
        });

        new RoleEditView();
    }
);