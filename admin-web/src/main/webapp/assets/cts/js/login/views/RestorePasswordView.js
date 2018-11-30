(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'backbone',
            'common.util.ajax',
            'common.util.messages',
            'common.views.SimpleWizardView',
            AppCommon.tplBaseUrl + "login/restore_password_view_template",
            'underscore',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (Backbone, CommonAjax, CommonMessage, SimpleWizardView, restorePasswordViewTemplate) {

        return SimpleWizardView.extend({
            template: restorePasswordViewTemplate,
            className: "row hidden",
            initBeforeRender: function (opts) {
                this.model = new Backbone.Model();
                this.handle = opts.handle;
                this.addEvent("click .btnGoToLogin", function () {
                    this.handle.trigger("goToLogin");
                });
                this.superInitBeforeRender(SimpleWizardView, opts);
            },
            // this step needs when user first time login
            // user have to change password
            goToRestorePasswordStep: function (username) {
                Common.ajax.validation.clearRemarks();
                this.clearInputs();
                this.$success.empty();
                this.$error.empty();
                this.model.set("username", username);
                this.$el.removeClass("hidden");
                this.$info.html(CommonMessage.bundles.getMessage('login.restore.password.first.time.login'));
                this.goToStep('step-restore');
                this.$el.find(".btnPrev").addClass("hidden");
            },
            changeStep: function (opts) {
                var changeStep = true;
                switch (this.currentStep) {
                    case this.steps[0] :
                        if (opts.isNext) {
                            var respUsername = CommonAjax.ajax.sync({url: "restorePassword/username.json?username=" + this.model.get("username")});
                            if (respUsername.message === 'admin.SMS_SEND_ERROR') {
                                this.$error.html(CommonMessage.bundles.getMessage('admin.SMS_SEND_ERROR'));
                                changeStep = false;
                            } else {
                                changeStep = respUsername.message === 'user.not.found' ? this.handleAjaxResponse(respUsername) : respUsername.status !== Common.json.status.error;
                                if (changeStep) {
                                    this.$success.html(CommonMessage.bundles.getMessage('login.restore.password.sms'));
                                }
                            }
                        } else {
                            this.handle.trigger("goToLogin");
                        }
                        break;
                    case this.steps[1] :
                        if (opts.isNext) {
                            var respSms = CommonAjax.ajax.sync({
                                url: "restorePassword/sms.json",
                                data: {
                                    username: this.model.get("username"),
                                    smsCode: this.model.get("smsCode")
                                }
                            });
                            changeStep = this.handleAjaxResponse(respSms);
                            if (changeStep) {
                                this.$success.html(CommonMessage.bundles.getMessage('login.restore.password.new.password'));
                            } else {
                                this.$error.html(CommonMessage.bundles.getMessage('login.restore.password.sms.fail'));
                            }
                        }
                        break;
                    case this.steps[2] :
                        if (opts.isNext) {
                            var respRestore = CommonAjax.ajax.sync({
                                url: "restorePassword/restore.json",
                                method: "POST",
                                data: JSON.stringify({
                                    username: this.model.get("username"),
                                    password: this.model.get("password")
                                })
                            });
                            changeStep = this.handleAjaxResponse(respRestore);
                            if (changeStep) {
                                this.$success.html(CommonMessage.bundles.getMessage('login.restore.password.new.password.success'));
                                this.handle.trigger("signIn", this.model.toJSON());
                            } else {
                                this.$success.html(CommonMessage.bundles.getMessage('login.restore.password.new.password'));
                            }
                        }
                        break;
                    case this.steps[3] :
                        if (opts.isNext) {
                            this.handle.trigger("goToLogin");
                        }
                        break;
                    default :
                        break;
                }
                return changeStep;
            },

            open: function () {
                Common.ajax.validation.clearRemarks();
                this.clearInputs();
                this.$success.empty();
                this.$error.empty();
                this.$el.removeClass("hidden");
                this.goToStep('step-email');
            }
        });
    }
);