(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.views.modalPanel.SimpleModalPanelView',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "user/user_view_template",
            AppCommon.tplBaseUrl + "user/user_change_password_template",
            'common.util.ajax',
            'common.util.url',
            'common.util.messages',
            'common.util.acls',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, SimpleModalPanelView, Common, SecurityModels, userViewTemplate, userChangePasswordTemplate) {
        var ChangePasswordInputsView = InputAwareViewWithValidation.extend({
            template: userChangePasswordTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.ChangeUserPassword({id: Common.Url.parse().id});
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            changePassword: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false});
                    return this.handleAjaxResponse(response);
                }
                return false;
            }
        });

        var UserPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: userViewTemplate,
            getRenderContext: function () {
                return {
                    backUrl: AppCommon.baseUrl + "user/list.htm",
                    editUrl: AppCommon.baseUrl + "user/edit.htm?id=" + this.model.get("username"),
                    dto: this.model.toJSON(),
                    isCanDelete: AppCommon.isHasPrivilege('USER_DELETE'),
                    isCanChangePassword: AppCommon.isHasPrivilege('USER_CHANGE_PASSWORD')
                }
            },
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.User({id: Common.Url.parse().id});
                this.model.fetch({async: false});

                this.changePasswordInputsView = new ChangePasswordInputsView();
                this.changePasswordView = new SimpleModalPanelView({
                    title: Common.bundles.getMessage("users.modal.panel.change.password"),
                    buttons: [
                        {buttonId: "cancel", buttonCaption: Common.bundles.getMessage("common.cancel"), buttonClass: "btn-default closeModalPanel"},
                        {buttonId: "changePassword", buttonCaption: Common.bundles.getMessage("common.apply"), buttonClass: "btn-primary"}
                    ],
                    bodyView: this.changePasswordInputsView
                });
                this.listenTo(this.changePasswordInputsView, "changePassword", function () {
                    var noError = this.changePasswordInputsView.changePassword();
                    if (noError) {
                        this.changePasswordView.hide();
                    }
                });

                this.superInitBeforeRender(SimpleViewWithModel, opts);
                this.addEvent("click .btnShowChangePasswordModalPanel", function () {
                    Common.ajax.validation.clearRemarks();
                    this.changePasswordInputsView.clearInputs();
                    this.changePasswordView.show();
                });
                this.addEvent("click .btnDelete", "_deleteUser");
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                this.$el.append(this.changePasswordView.el);
                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            },
            _deleteUser: function () {
                if (confirm(Common.bundles.getMessage("common.confirmDelete"))) {
                    this.model.destroy({
                        success: function () {
                            Common.navigateToUrl("user/list.htm");
                        }
                    });
                } else {
                    return false;
                }
            }
        });

        new UserPageView();
    }
);
