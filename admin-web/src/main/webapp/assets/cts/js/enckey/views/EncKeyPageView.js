(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "enckey/enckey_view_template",
            'common.util.ajax',
            'common.util.url',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, Common, SecurityModels, encKeyViewTemplate) {
        var EncKeyPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: encKeyViewTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.EncKey({ id: Common.Url.parse().id });
                this.model.fetch({async: false});

                this.superInitBeforeRender(SimpleViewWithModel, opts);
                this.addEvent("click .btnDelete", "_deleteEncKey");
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            },
            _deleteEncKey: function () {
                if (confirm(Common.bundles.getMessage("common.confirmDelete"))) {
                    this.model.destroy({
                        success: function () {
                            Common.navigateToUrl("enckey/list.htm");
                        }
                    });
                } else {
                    return false;
                }
            }
        });

        new EncKeyPageView();
    }
);