(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "feProp/feProp_view_template",
            'common.util.ajax',
            'common.util.url',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, Common, SecurityModels, fePropViewTemplate) {
        var FePropPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: fePropViewTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.FeProp({propName: Common.Url.parse().propName});
                this.model.fetch({async: false});
                this.superInitBeforeRender(SimpleViewWithModel, opts);
                this.addEvent("click .btnDelete", "_delete");
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            },
            _delete: function () {
                if (confirm(Common.bundles.getMessage("common.confirmDelete"))) {
                    this.model.destroy({
                        success: function () {
                            Common.navigateToUrl("feProp/list.htm");
                        }
                    });
                } else {
                    return false;
                }
            }
        });

        new FePropPageView();
    }
);