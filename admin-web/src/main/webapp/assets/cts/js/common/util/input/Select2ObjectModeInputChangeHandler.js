(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.input.Select2ObjectModeInputChangeHandler', [
            'common.util.input.InputChangeHandlerApi'
        ], factory);
    } else {
        factory();
    }
})(
    function(InputChangeHandlerApi) {

        /**
         * Sets value as object (from options),
         * To enable, select2 input should have attribute data-select-mode="object".
         * */
        function Select2ObjectModeInputChangeHandler() {
            return new InputChangeHandlerApi(
                function($input, event) {
                    return $input.is("select") && $input.is(".select2") && $input.is("[data-select-mode=object]");
                },
                function(model, $input, event) {
                    var inputName = $input.attr("name");
                    var isArray = $input.attr("data-multiple") || inputName.contains("[") && inputName.contains("]");
                    var propertyName = inputName.replace("[", "").replace("]", "");
                    if (isArray) {
                        var array = model.get(propertyName);
                        if (!array) {
                            array = [];
                            model.set(propertyName, array);
                        }
                        if (event.removed) {
                            var removedKey = event.removed.id;
                            var removedIndex = -1;
                            _.each(array, function(value, index) {
                                if (removedKey == value.key) {
                                    removedIndex = index;
                                }
                            });
                            if (removedIndex != -1) {
                                array.splice(removedIndex, 1);
                            }
                        }
                        if (event.added) {
                            var addedObject = JSON.parse(jQuery(event.added.element[0]).attr("data-original-object"));
                            array.push(addedObject);
                        }
                    }
                    else {
                        if (event.added) {
                            var addedObject = JSON.parse(jQuery(event.added.element[0]).attr("data-original-object"));
                            model.set(propertyName, addedObject);
                        }
                    }
                },
                function(value, $input, options) {
                    var inputName = $input.attr("name");
                    var isArray = inputName.contains("[") && inputName.contains("]");
                    if (isArray) {
                        var keyList = [];
                        if (value) {
                            _.each(value, function(value, index) {
                                keyList.push(value.key);
                            });
                        }
                        $input.select2("val", keyList);
                        $input.trigger("change", options ? {skipModelUpdate: options.skipModelUpdate} : null);
                    }
                    else {
                        $input.select2("val", value ? value.key: null);
                        $input.trigger("change", options ? {skipModelUpdate: options.skipModelUpdate} : null);
                    }
                }
            );
        }

        return Select2ObjectModeInputChangeHandler;
    }
);
