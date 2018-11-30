(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            'select2',
            'backbone',
            'common.util.ajax',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels) {
        var RolePageView = InputAwareViewWithValidation.extend({
            el: "#roleCreateContainer",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Role();

                this.privilegeList = Common.ajax.sync({
                    url: "privilege/filter.json",
                    method: "POST",
                    data: JSON.stringify({unlimited: true})
                }).objects;

                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_saveRole');
            },
            initAfterRender: function () {
                Common.applySelect2(this.$el.find("#privileges"), this.privilegeList);
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            _saveRole: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {type: 'POST', async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("role/view.htm?id=" + this.model.get("id"));
                    }
                }
            }
        });

        new RolePageView();
    }
);
