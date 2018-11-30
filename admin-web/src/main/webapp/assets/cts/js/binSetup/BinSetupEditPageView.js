(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "binSetup/binSetup_edit_template",
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels, binSetupEditTemplate) {
        var BinSetupEditView = InputAwareViewWithValidation.extend({
            el: "#binSetup-edit-container",
            template: binSetupEditTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.BinSetup(
                    {
                        bin: Common.Url.parse().bin
                    }
                );
                this.model.fetch({async: false});
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_save');

            },
            _save: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {type: 'PUT', async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("bin/view.htm?bin=" + this.model.get("bin"));
                    }
                }
            }
        });

        new BinSetupEditView();
    }
);
