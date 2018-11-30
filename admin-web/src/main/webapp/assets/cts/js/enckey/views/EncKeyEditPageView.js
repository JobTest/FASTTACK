(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.InputAwareViewWithValidation',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "enckey/enckey_edit_template",
            'select2',
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'common.util.acls',
            'common.util.date',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function(InputAwareViewWithValidation, Common, SecurityModels, encKeyEditTemplate) {
        var EncKeyEditView = InputAwareViewWithValidation.extend({
            el: "#encKey-edit-container",
            template: encKeyEditTemplate,
            initBeforeRender: function(opts) {
                this.model = new SecurityModels.EncKey({ id: Common.Url.parse().id });
                this.model.fetch({async: false});

                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                this.addEvent('click .btnSave', '_saveEncKey');
            },
            initAfterRender: function() {
                this.delegateEvents();
                var el = this.$el;
                Common.ajax.async("enum/enckeyCapacity.json",
                    function (data) {
                        Common.applySelect2(el.find("#capacity"), data);
                    }
                );
                Common.ajax.async("enum/enckeyStatus.json",
                    function (data) {
                        Common.applySelect2(el.find("#statusCode"), data);
                    }
                );

                Common.ajax.async("enum/enckeyWrappingKey.json",
                    function (data) {
                        data.unshift({key: "", caption: Common.bundles.getMessage("select2.notChosen")});
                        Common.applySelect2(el.find("#wrappingKey"), data);
                    }
                );

                Common.applyDatePicker(this.$el.find(".datepicker"));

                this.superInitAfterRender(InputAwareViewWithValidation);

            },
            _saveEncKey: function() {
                var response = this.model.save(null, {async: false});
                if (this.handleAjaxResponse(response)) {
                    Common.navigateToUrl("enckey/view.htm?id=" + this.model.get("id"));
                }
            }
        });
        new EncKeyEditView();
    }
);