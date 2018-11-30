(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'backbone',
            'common.util.core',
            'common.util.ajax',
            'common.util.messages',
            'common.views.SimpleWizardView',
            AppCommon.tplBaseUrl + "login/login_view_template",
            'underscore',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (Backbone, CommonCore, CommonAjax, CommonMessage, SimpleWizardView, loginViewTemplate) {

        return SimpleWizardView.extend({
            template: loginViewTemplate,
            className: "row",
            initBeforeRender: function (opts) {
                this.model = new Backbone.Model();
                this.handle = opts.handle;
                this.superInitBeforeRender(SimpleWizardView, opts);
            },
            initAfterRender: function () {
                this.$form = this.$el.find("form");
                this.addEvent("click .btnRestorePassword", function () {
                    this.handle.trigger("goToRestorePassword");
                });
                this.superInitAfterRender(SimpleWizardView);
            },
            changeStep: function (opts) {
                var changeStep = true;
                switch (this.currentStep) {
                    case this.steps[0] :
                        if (opts.isNext) {
                            changeStep = this._signIn();
                        }
                        break;
                    case this.steps[1] :
                        if (opts.isNext) {
                            changeStep = this._signIn();
                        } else {
                            this.handle.trigger("goToLogin");
                        }
                        break;
                    default :
                        break;
                }
                return changeStep;
            },
            _signIn: function () {
                var $self = this;
                var changeStep = false;

                this.model.set(CommonCore.serializeToJSON(this.$form));

                CommonAjax.ajax.sync({
                    url: "login/process-login.htm",
                    method: "POST",
                    data: this.model.toJSON(),
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    beforeSend: function (xhr) {
                        xhr.withCredentials = true;
                    },
                    success: function (data) {
                        if (data.success === true) {
                            window.location.href = AppCommon.baseUrl + "login/success";
                        }
                    },
                    error: function (data) {
                        var response = jQuery.parseJSON(data.responseText);
                        if (response.success === false && response.exception) {
                            var message = CommonMessage.bundles.getMessage(response.exception);
                            if (response.requiredOtp) {
                                $self.$info.html(message);
                                changeStep = true;
                            } else if (response.needChangePassword) {
                                $self.handle.trigger("goToChangePassword");
                            } else {
                                $self.$error.html(message);
                            }
                        } else {
                            console.warn("Unable to login, response data: " + data);
                        }
                    }
                });
                return changeStep;
            }
        });
    }
);