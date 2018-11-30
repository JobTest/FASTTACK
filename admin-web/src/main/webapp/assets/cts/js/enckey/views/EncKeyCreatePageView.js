(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            'select2',
            'backbone',
            'common.util.ajax',
            'common.util.acls',
            'common.util.date',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function (InputAwareViewWithValidation, Common, SecurityModels) {
        var EncKeyPageView = InputAwareViewWithValidation.extend({
            el: "#encKeyCreateContainer",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.EncKey();
                Common.applyDatePicker(this.$el.find(".datepicker"));

                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_saveEncKey');
            },
            initAfterRender: function () {
                var el = this.$el;
                var model = this.model;
                Common.ajax.async("enum/enckeyCapacity.json",
                    function (data) {
                        Common.applySelect2(el.find("#capacity"), data);
                        model.set({capacity: data[0].key});
                    }
                );
                Common.ajax.async("enum/enckeyStatus.json",
                    function (data) {
                        Common.applySelect2(el.find("#statusCode"), data);
                        model.set({statusCode: data[0].key});
                    }
                );
                Common.ajax.async("enum/keyTypes.json",
                    function (data) {
                        Common.applySelect2(el.find("#keyType"), data);
                        model.set({keyType: data[0].key});
                    }
                );

                Common.ajax.async("enum/enckeyWrappingKey.json",
                    function (data) {
                        data.unshift({key: "", caption: Common.bundles.getMessage("select2.notChosen")});
                        Common.applySelect2(el.find("#wrappingKey"), data);
                        model.set({wrappingKey: data[0].key});
                    }
                );

                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            _saveEncKey: function () {
                if (this.validateInputs()) {
                    var response = this.model.save(null, {async: false});
                    if (this.handleAjaxResponse(response)) {
                        Common.navigateToUrl("enckey/view.htm?id=" + response.responseJSON.dto.id);
                    }
                }
            }
        });
        new EncKeyPageView();
    }
);
