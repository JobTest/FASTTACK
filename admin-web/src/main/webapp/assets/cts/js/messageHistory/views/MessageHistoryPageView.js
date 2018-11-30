(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "messageHistory/messageHistory_view_template",
            'common.util.ajax',
            'common.util.url',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, InputAwareViewWithValidation, Common, SecurityModels, messageHistoryViewTemplate) {
        var MessageHistoryPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: messageHistoryViewTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.MessageHistory({ id: Common.Url.parse().id });
                this.model.fetch({async: false});
                this.superInitBeforeRender(SimpleViewWithModel, opts);
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            }
        });

        new MessageHistoryPageView();
    }
);