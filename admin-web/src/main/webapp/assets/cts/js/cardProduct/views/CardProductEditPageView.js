(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "cardProduct/cardProduct_edit_template",
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels, cardProductEditTemplate) {
        var CardProductEditView = InputAwareViewWithValidation.extend({
            el: "#cardProduct-edit-container",
            template: cardProductEditTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.CardProduct({id: Common.Url.parse().id});
                this.model.fetch({async: false});
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', "_save");
            },
            _save: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {type: 'PUT', async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("cardProduct/view.htm?id=" + this.model.get("id"));
                    }
                }
            }
        });

        new CardProductEditView();
    }
);