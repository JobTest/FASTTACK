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
        var UserPageView = InputAwareViewWithValidation.extend({
            el: "#userCreateContainer",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.User();
                this.roleList = Common.ajax.sync({
                    url: "role/filter.json",
                    method: "POST",
                    data: JSON.stringify({unlimited: true})
                }).objects;

                this.userStatusList = Common.ajax.sync({url: "enum/userStatusList.json", cache: true});
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_saveUser');
            },
            initAfterRender: function () {
                Common.applySelect2(this.$el.find("#roles"), this.roleList);
                Common.applySelect2(this.$el.find("#status"), this.userStatusList);
                this.superInitAfterRender(InputAwareViewWithValidation);
                this.model.set({status: this.userStatusList[0].key});
            },
            _saveUser: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("user/view.htm?id=" + this.model.get("username"));
                    }
                }
            }
        });
        new UserPageView();
    }
);