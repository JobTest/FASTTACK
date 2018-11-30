(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.input.InputChangeHandlerApi', factory);
    } else {
        factory();
    }
})(
    function() {

        /**
         * Base for setting and clearing model properties from input values.
         * @param acceptCallback function($input), return true if handler can set input value, if it can, then other handler will be ignored
         * @param setInputValueToModelCallback function(model, $input, event), sets input value to model
         * @param setModelPropertyToInputCallback function(value, $input, options), sets model property's value to input
         * */
        function InputChangeHandler(acceptCallback, setInputValueToModelCallback, setModelPropertyToInputCallback) {
            this.setInputValueToModel = function(model, $input, event) {
                if (!acceptCallback($input)) {
                    return false;
                }
                else {
                    // TODO add nested models support (if input name is something like this 'object.name' then for current model under name 'object' new model should be created with field 'name')
                    setInputValueToModelCallback(model, $input, event);
                    return true;
                }
            };
            this.setModelPropertyToInput = function(value, $input, options) {
                if (!acceptCallback($input)) {
                    return false;
                }
                else {
                    // TODO add nested models support (if input name is something like this 'object.name' then for current model under name 'object' new model should be created with field 'name')
                    setModelPropertyToInputCallback(value, $input, options);
                    return true;
                }
            };
        }

        return InputChangeHandler;
    }
);
