(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            'backbone',
            'common.util.ajax',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels) {
        var FePropPageView = InputAwareViewWithValidation.extend({
            el: "#fePropCreateContainer",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.FeProp();
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_save');
            },
            _save: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {type: 'POST', async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("feProp/view.htm?propName=" + this.model.get("propName"));
                    }
                }
            }
        });

        new FePropPageView();
    }
);
