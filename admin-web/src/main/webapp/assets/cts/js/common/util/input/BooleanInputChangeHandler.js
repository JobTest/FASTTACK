(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.input.BooleanInputChangeHandler', [
            'common.util.input.InputChangeHandlerApi'
        ], factory);
    } else {
        factory();
    }
})(
    function(InputChangeHandlerApi) {

        /**
         * Sets input values to model or clears if value is empty.
         * Can handle input type checkbox
         * */
        function BooleanInputChangeHandler() {
            return new InputChangeHandlerApi(
                function($input) {
                    var inputType = $input.attr("type");
                    return $input.is("input") && inputType == "checkbox" && $input.is(".boolean");
                },
                function(model, $input, event) {
                    var inputName = $input.attr("name");
                    var inputValue = $input.is(":checked");
                    model.set(inputName, inputValue);
                },
                function(value, $input, options) {
                    $input.prop('checked', value);
                }
            );
        }

        return BooleanInputChangeHandler;
    }
);
