(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleView',
            'login.views.LoginView',
            'login.views.RestorePasswordView'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleView, LoginView, RestorePasswordView) {

        var LoginPageView = SimpleView.extend({
            el: ".loginPageView",
            initialize: function () {
                this.createHandle();
                this.loginView = new LoginView({
                    handle: this.handle,
                    steps: ['step-login', 'step-sms']
                });
                this.restorePasswordView = new RestorePasswordView({
                    handle: this.handle,
                    steps: ['step-email', 'step-sms', 'step-restore', 'step-complete']
                });
                this.render();
            },
            render: function () {
                this.$el.append(this.loginView.el);
                this.$el.append(this.restorePasswordView.el);
                this.delegateEvents();
                return this;
            },
            _doHandle: function (event, opts) {
                if ('goToLogin' === event) {
                    this.loginView.$el.removeClass("hidden");
                    this.restorePasswordView.$el.addClass("hidden");

                    Common.ajax.validation.clearRemarks();
                    this.loginView.clearInputs();
                }
                if ('goToRestorePassword' === event) {
                    this.loginView.$el.addClass("hidden");
                    this.restorePasswordView.open();
                }
                if ('goToSms' === event) {
                    this.restorePasswordView.$el.addClass("hidden");
                    this.loginView.$el.removeClass("hidden");
                    this.loginView._changeStep({isNext: true});
                }
                if ('goToChangePassword' === event) {
                    this.loginView.$el.addClass("hidden");
                    this.restorePasswordView.goToRestorePasswordStep(this.loginView.model.get("j_username"));
                }
                if ('signIn' === event) {
                    this.restorePasswordView.$el.addClass("hidden");
                    this.loginView.$el.removeClass("hidden");
                    this.loginView.model.set("j_username", opts.username, {updateInput: true});
                    this.loginView.model.set("j_password", opts.password, {updateInput: true});
                    this.loginView._changeStep({isNext: true});
                }
            }
        });
        new LoginPageView();
    }
);