(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.input.DefaultInputChangeHandler', [
            'common.util.input.InputChangeHandlerApi'
        ], factory);
    } else {
        factory();
    }
})(
    function(InputChangeHandlerApi) {

        // TODO add checkbox, simple select (not select 2, not sure if it works now) support
        /**
         * Sets input values to model or clears if value is empty.
         * Can handle simple text inputs, textarea, select2, bootstrap.dataPicker.
         * For Select2 sets keys as values
         * */
        function DefaultInputChangeHandler() {
            return new InputChangeHandlerApi(
                function($input) {
                    var inputType = $input.attr("type");
                    return $input.is("input") && (
                        !$input.is("[type]") ||
                            inputType == "email" ||
                            inputType == "tel" ||
                            inputType == "number" ||
                            inputType == "text" ||
                            inputType == "password" ||
                            inputType == "radio" ||
                            inputType == "hidden" ||
                            inputType == "checkbox"
                        ) ||
                        $input.is("textarea") ||
                        $input.is("select") && $input.is(".select2") && ($input.is(":not([data-select-mode])") || $input.is(":not([data-select-mode=object])"));
                },
                function(model, $input, event) {
                    var inputName = $input.attr("name");
                    var inputValue = null;
                    if ($input[0].type === 'checkbox') {
                        inputValue = $input.is(":checked");
                    } else {
                        inputValue = $input.val();
                    }
                    var propertyName = inputName.replace("[", "").replace("]", "");
                    if (inputValue == "" || inputValue == null || inputValue == undefined) {
                        model.set(propertyName, null);
                    } else {
                        model.set(propertyName, inputValue);
                    }
                },
                function(value, $input, options) {
                    if ($input.is(":input:not(.date-picker):not(select.select2)")) {
                        $input.val(value);
                        $input.trigger("change", options ? {skipModelUpdate: options.skipModelUpdate} : null);
                    }
                    else if ($input.is("select.select2")) {
                        if (value == "") {
                            value = null;
                        }
                        $input.select2("val", value);
                        $input.trigger("change", options ? {skipModelUpdate: options.skipModelUpdate} : null);
                    }
                    else if ($input.is(":input.date-picker")) {
                        $input.val(value);
                        $input.trigger("changeDate", options ? {skipModelUpdate: options.skipModelUpdate} : null);
                    }
                }
            );
        }

        return DefaultInputChangeHandler;
    }
);
