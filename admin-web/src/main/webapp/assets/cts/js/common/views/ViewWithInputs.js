(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.views.ViewWithInputs',
            [
                'common.views.SimpleViewWithModel',
                'common.util.input.InputChangeHandlerApi',
                'common.util.input.DefaultInputChangeHandler',
                'common.util.input.Select2ObjectModeInputChangeHandler',
                'common.util.input.BooleanInputChangeHandler'
            ],
            factory
        );
    } else {
        factory();
    }
})(
    function(SimpleViewWithModel, InputChangeHandlerApi, DefaultInputChangeHandler, Select2ObjectModeInputChangeHandler, BooleanInputChangeHandler) {

        return SimpleViewWithModel.extend({
            initBeforeRender: function(opts) {
                this.superInitBeforeRender(SimpleViewWithModel, opts);
                /** need to exclude bootstrap.datePicker, it fires change multiple times, for change use separate event */
                this.addEvent('change :input:not(.ignoreChangeEvent):not(.date-picker)', 'inputChange');
                /** bootstrap.datePicker has specific event */
                this.addEvent('changeDate :input:not(.ignoreChangeEvent).date-picker', 'inputChange');
            },
            initAfterRender: function() {
                this.initializeDefaultInputHandlers();
                if (!this.model) {
                    throw new Error("Model should be specified for view: " + this.cid);
                }
                this.listenTo(this.model, "change", this.modelChange);
            },
            initializeDefaultInputHandlers: function() {
                this.getInputHandlers().push(new DefaultInputChangeHandler());
                this.getInputHandlers().push(new Select2ObjectModeInputChangeHandler());
                this.getInputHandlers().push(new BooleanInputChangeHandler());
            },
            addInputHandler: function (acceptCallback, setInputValueToModelCallback, setModelPropertyToInputCallback, index) {
                var handler = new InputChangeHandlerApi(acceptCallback, setInputValueToModelCallback, setModelPropertyToInputCallback);
                if (index) {
                    this.getInputHandlers().splice(index, 0, handler);
                } else {
                    this.getInputHandlers().push(handler);
                }
            },
            getInputHandlers: function() {
                if (!this.inputHandlers) {
                    this.inputHandlers = [];
                }
                return this.inputHandlers;
            },
            /** input to model */
            inputChange: function (event, options) {
                if (this.model && !options || (options && !options.skipModelUpdate) ) {
                    var $input = jQuery(event.target);
                    if ($input.is("[name]")) {
                        for (var i = 0; i < this.inputHandlers.length; i++) {
                            var handler = this.inputHandlers[i];
                            if (handler.setInputValueToModel(this.model, $input, event)) {
                                break;
                            }
                        }
                    }
                }
            },
            /** model to input */
            modelChange: function(model, options) {
                if (options.updateInput) {
                    var changedFields = this.model.changedAttributes();
                    this._setModelAttributesToInputs(changedFields);
                }
            },
            _setModelAttributesToInputs: function(fields) {
                if (fields) {
                    var localView = this;
                    _.each(fields, function(value, key, obj) {
                        // trying to find input, which name starts
                        var $input = localView.$el.find("[name=" + key + "], [name=" + key + "\\[\\]]");
                        if ($input) {
                            localView._setInputValue($input, value, {skipModelUpdate: true});
                        }
                    });
                }
            },
            // Clear input values, and related properties in model
            clearInputs: function () {
                var localView = this;
                // go through each input (with possibility to ignore fields, which can't be modified on UI)
                this.$el.find(":input:not(.ignoreChangeEvent)").each(function(index, input) {
                    var $input = jQuery(input);
                    localView._setInputValue($input, "");
                });
            },
            _setInputValue: function($input, value, options) {
                for (var i = 0; i < this.inputHandlers.length; i++) {
                    var handler = this.inputHandlers[i];
                    if (handler.setModelPropertyToInput(value, $input, options)) {
                        break;
                    }
                }
            },
            setModel: function(model, opts) {
                this.model = model;
                if (opts && opts.updateInput) {
                    this._setModelAttributesToInputs(this.model.toJSON());
                }
            }
        });
    }
);
