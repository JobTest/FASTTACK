(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "user/user_edit_template",
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
    function (InputAwareViewWithValidation, Common, SecurityModels, userEditTemplate) {

        var ProfileEditView = InputAwareViewWithValidation.extend({
            el: "#main-container",
            template: userEditTemplate,
            getRenderContext: function () {
                return {
                    backUrl: AppCommon.baseUrl + "profile/view.htm",
                    dto: this.model.toJSON()
                }
            },
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Profile();
                this.model.fetch({async: false});

                this.roleList = Common.ajax.sync({
                    url: "role/filter.json",
                    method: "POST",
                    data: JSON.stringify({unlimited: true})
                }).objects;
                this.userStatusList = Common.ajax.sync({url: "enum/userStatusList.json", cache: true});

                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', "_saveProfile");
            },
            initAfterRender: function () {
                this.delegateEvents();
                Common.applySelect2(this.$el.find("#roles"), this.roleList);
                Common.applySelect2(this.$el.find("#status"), this.userStatusList);
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            _saveProfile: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("profile/view.htm");
                    }
                }
            }
        });
        new ProfileEditView();
    }
);