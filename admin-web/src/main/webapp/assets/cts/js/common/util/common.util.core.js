(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.core', factory);
    } else {
        factory();
    }
})(
    function () {
        var Common = {};
        Common.context = AppCommon.context;

        //------------------------------- HTTP STATUSES -------------------------------------//
        Common.json = {};
        Common.json.status = {};
        Common.json.status.success = 'SUCCESS';
        Common.json.status.error = 'ERROR';

        //---------------------------------------- navigation ---------------------------------------//
        Common.back = function () {
            window.history.back();
        };
        Common.navigateToAHref = function (jqueryAObject) {
            window.location.href = jqueryAObject.attr("href");
        };

        /**
         * Adds base url with domen to given param,
         * */
        Common.navigateToUrl = function (url) {
            var parser = document.createElement('a');
            parser.href = window.location.href;
            var goToUrl = parser.protocol + "//" + parser.host + AppCommon.baseUrl + url.replace(/^\//g, '');
            window.location.replace(goToUrl);
        };
        //---------------------------------------- some initializations -------------------------------------------//
        Common.isAutomaticallyGeneratedElement = function (element) {
            return element.attr("id") == undefined || element.attr("id").indexOf("autogen") > -1;

        };
        //---------------------------------------- select2 ---------------//
        // In java items have to implements Dict.
        Common.applySelect2 = function (container, items) {
            // if select already has options, remove them and init new options
            if (container.children("option")) {
                container.children("option").remove();
            }

            var allowClear = container.attr("data-allow-clear") == "true";
            var useObject = container.attr("data-select-mode") == "object";
            var unscapeAttr = container.attr("data-unescape") == "true";
            var dataValueAttr = unscapeAttr ? unescape(container.attr("data-value")) : container.attr("data-value");
            var multiple = container.attr("data-multiple");
            var dataValue = null;
            var objectDataValueKeys = [];
            if (dataValueAttr && dataValueAttr.indexOf("[") != -1) {
                dataValue = JSON.parse(dataValueAttr);
                $.each(dataValue, function (indedx, value) {
                    if (value instanceof Object && value.key) {
                        objectDataValueKeys[indedx] = value.key;
                    }
                });
            } else {
                dataValue = dataValueAttr;
            }
            if (multiple) {
                container.attr("multiple", multiple);
                $.each(items, function (indedx, value) {
                    var option = $("<option></option>");
                    option.attr("value", value.key).text(value.caption);
                    if (dataValue && ((objectDataValueKeys.indexOf(value.key) != -1) || value.key == dataValue)) {
                        option.attr("selected", "selected");
                    }
                    if (useObject) {
                        option.attr("data-original-object", JSON.stringify(value));
                    }
                    container.append(option);
                });
            } else {
                //TODO refactor this part with non multiple select. Added as hotfix
                var dataValueObject = useObject && dataValue != null ? JSON.parse(dataValue) : null;
                $.each(items, function (indedx, value) {
                    var option = $("<option></option>");
                    option.attr("value", value.key).text(value.caption);
                    if (dataValueObject != null) {
                        if (dataValueObject.key == value.key) {
                            option.attr("selected", "selected");
                        }
                    } else {
                        if (dataValue && ((objectDataValueKeys.indexOf(value.key) != -1) || value.key == dataValue)) {
                            option.attr("selected", "selected");
                        }
                    }
                    if (useObject) {
                        option.attr("data-original-object", JSON.stringify(value));
                    }
                    container.append(option);
                });
            }
            container.select2({
                allowClear: allowClear
            });
        };
        //---------------------------------------- date picker ---------------//
        Common.applyDatePicker = function (container) {
            //TODO create separate common.util.date module for date manipulations
        };

        //---------------------------------------- functions for type --------------------------------------------//
        Common.typeUtils = {};

        Common.typeUtils.isString = function (obj) {
            return "[object String]" == Object.prototype.toString.call(obj);
        };

        Common.typeUtils.isNumber = function (obj) {
            return "[object Number]" == Object.prototype.toString.call(obj);
        };

        Common.typeUtils.isDate = function (obj) {
            return "[object Date]" == Object.prototype.toString.call(obj);
        };

        Common.typeUtils.isExists = function (obj) {
            return !("[object Undefined]" == Object.prototype.toString.call(obj) ||
                "[object Null]" == Object.prototype.toString.call(obj));
        };

        Common.isEmpty = function (str) {
            return typeof str == 'string' && !str.trim() || typeof str == 'undefined' || str === null;
        };

        //---------------------------- Async Task ----------------------------------------------------//

        Common.Task = function (opts) {
            setTimeout(function () {
                opts.callback.apply(opts.context || this, opts.arguments);
            }, 0);
        };

        //------------------------------- Extend function ----------------------------------------//
        window.Extend = function extend(Child, Parent) {
            var F = function () {
            };
            F.prototype = Parent.prototype;
            Child.prototype = new F();
            Child.prototype.constructor = Child;
            Child.superclass = Parent.prototype;
            return Child;
        };

        // For Chrome, it doesn't have method contains for strings
        if (!String.prototype.contains) {
            String.prototype.contains = function (text) {
                return this.indexOf(text) > -1;
            };
        }
        // Makes first letter upperCase, other letters lowerCase
        if (!String.prototype.capitalize) {
            String.prototype.capitalize = function () {
                return this.charAt(0).toUpperCase() + this.toLowerCase().slice(1);
            };
        }

        // Serialize jQuery(name, value) object to json
        Common.serializeToJSON = function ($obj) {
            var o = {};
            var a = $obj.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

        window.Common = Common;
        return Common;
    }
);