(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "feProp/feProp_edit_template",
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels, fePropEditTemplate) {
        var FePropEditView = InputAwareViewWithValidation.extend({
            el: "#feProp-edit-container",
            template: fePropEditTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.FeProp({propName: Common.Url.parse().propName});
                this.model.fetch({async: false});
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', "_save");
            },
            _save: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {type: 'PUT', async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("feProp/view.htm?propName=" + this.model.get("propName"));
                    }
                }
            }
        });

        new FePropEditView();
    }
);