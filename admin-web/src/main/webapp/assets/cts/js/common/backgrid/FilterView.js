(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['backbone',
                'common.views.InputAwareViewWithValidation',
                'common.util.core',
                'common.util.date',
                'common.util.messages',
                'common.util.ajax',
                "jquery"],
            factory);
    }
    else {
        factory();
    }

})
(function (Backbone, InputAwareViewWithValidation, CommonCore, CommonDate, CommonMessages, CommonAjax, jQuery) {

    /**
     * Filter View
     * @param opts.validateEmptyFilter is need to validate filter for empty fields, default true
     */
    return InputAwareViewWithValidation.extend({
        emptyFilterMessage: CommonMessages.bundles.getMessage("cts.validation.message.filterIsEmpty"),

        initBeforeRender: function (opts) {
            this.handle = opts.handle;
            this.template = opts.template;
            this.validateEmptyFilter = true;

            if(opts.validateEmptyFilter !== undefined){
                this.validateEmptyFilter = opts.validateEmptyFilter;
            }

            if (!this.template) {
                throw new Error("Empty field: 'template' in " + this.constructor.name);
            }
            this.model = new Backbone.Model();

            if(this.addEvents){
                this.addEvents();
            }
            this.superInitBeforeRender(InputAwareViewWithValidation, opts);

            this.addEvent("click .btnFilter", "_filter");
        },
        getRenderContext: function () {
            return {
                filter: this.model.toJSON()
            };
        },
        initAfterRender: function () {
            this.superInitAfterRender(InputAwareViewWithValidation);
            CommonDate.applyDatePicker(this.$el.find(".inputNarrow"));
        },

        _filter: function () {

            if (!this.validateEmptyFilter) {
                this.handle.trigger("backgrid:filter", this.model);
                return;
            }

            if (jQuery.isEmptyObject(this.model.toJSON())) {
                CommonAjax.ajax.validation.showErrorDescription(this.emptyFilterMessage);
            } else {
                CommonAjax.ajax.validation.clearErrorDescription();

                var allFieldsEmpty = true;
                jQuery.each(this.model.toJSON(), function(i, value) {
                    if (!CommonCore.isEmpty(value)) {
                        allFieldsEmpty = false;
                    }
                });

                if (allFieldsEmpty) {
                    CommonAjax.ajax.validation.showErrorDescription(this.emptyFilterMessage);
                } else if (this.validateInputs()) {
                    this.handle.trigger("backgrid:filter", this.model);
                }
            }
        }
    });

});
