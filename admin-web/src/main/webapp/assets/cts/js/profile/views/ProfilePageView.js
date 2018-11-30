(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.views.modalPanel.SimpleModalPanelView',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "user/user_view_template",
            AppCommon.tplBaseUrl + "profile/profile_change_password_template",
            'common.util.messages',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, SimpleModalPanelView, Common, SecurityModels, userViewTemplate, profileChangePasswordTemplate) {

        var ChangePasswordInputsView = InputAwareViewWithValidation.extend({
            template: profileChangePasswordTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                this.model = new Backbone.Model();
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            changePassword: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false, url: AppCommon.baseUrl + "profile/changePassword.json"});
                    return this.handleAjaxResponse(response);
                }
                return false;
            }
        });

        var ProfilePageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: userViewTemplate,
            getRenderContext: function () {
                return {
                    backUrl: null,
                    editUrl: AppCommon.baseUrl + "profile/edit.htm",
                    dto: this.model.toJSON(),
                    isCanDelete: false,
                    isCanChangePassword: true
                }
            },
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Profile();
                this.model.fetch({async: false});

                this.changePasswordInputsView = new ChangePasswordInputsView();

                this.changePasswordModalPanelView = new SimpleModalPanelView({
                    title: Common.bundles.getMessage("profile.modal.panel.password.title"),
                    buttons: [
                        {buttonId: "cancel", buttonCaption: Common.bundles.getMessage("common.cancel"), buttonClass: "btn-default closeModalPanel"},
                        {buttonId: "changePassword", buttonCaption: Common.bundles.getMessage("common.apply"), buttonClass: "btn-primary"}
                    ],
                    bodyView: this.changePasswordInputsView
                });

                this.listenTo(this.changePasswordInputsView, "changePassword", function () {
                    var noError = this.changePasswordInputsView.changePassword();
                    if (noError) {
                        this.changePasswordModalPanelView.hide();
                    }
                });

                this.addEvent("click .btnShowChangePasswordModalPanel", function () {
                    Common.ajax.validation.clearRemarks();
                    this.changePasswordInputsView.clearInputs();
                    this.changePasswordModalPanelView.show();
                });

                this.superInitBeforeRender(SimpleViewWithModel, opts);
            },
            initAfterRender: function () {
                this.$el.append(this.changePasswordModalPanelView.el);
                this.superInitAfterRender(SimpleViewWithModel);
            }
        });

        new ProfilePageView();
    }
);
