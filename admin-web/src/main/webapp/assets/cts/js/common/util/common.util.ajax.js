(function (factory) {
    if (typeof define === 'function' && define.amd) {

        define('common.util.ajax', ['common.util.core', 'common.localStorage', 'jquery'], factory);
    } else {
        factory();
    }
})(
    function (Common, CommonLocalStorage, jQuery) {

        Common.ajax = {};

        /**
         * @param opts :
         * url - ajax url (required),
         * contentType - ajax contentType (default is application/json),
         * method - ajax method (default is GET),
         * data - ajax data (required),
         * beforeSend - ajax beforeSend callback,
         * success - ajax success callback,
         * error - ajax error callback
         */
        Common.ajax.sync = function (opts) {
            var props = {
                url: AppCommon.baseUrl + opts.url,
                dataType: "json",
                contentType: opts.contentType || "application/json; charset=utf-8",
                async: false,
                method: opts.method || 'GET',
                data: opts.data,
                error: opts.error || Common.ajax.validation.handleAjaxResponse
            };
            if (opts.beforeSend) {
                props.beforeSend = opts.beforeSend;
            }
            if (opts.success) {
                props.success = opts.success;
            }
            return jQuery.ajax(props).responseJSON;
        };

        /**
         * @param opts :
         * url - ajax url (required),
         * contentType - ajax contentType (default is application/json),
         * method - ajax method (default is GET),
         * data - ajax data (required),
         * beforeSend - ajax beforeSend callback,
         * success - ajax success callback,
         * error - ajax error callback
         */
        Common.ajax.async = function (url, callback, opts) {
            opts = opts || {};
            var props = {
                url: AppCommon.baseUrl + url,
                dataType: "json",
                contentType: opts.contentType || "application/json; charset=utf-8",
                async: true,
                method: opts.method || 'GET',
                data: opts.data,
                error: opts.error || Common.ajax.validation.handleAjaxResponse
            };
            if (opts.beforeSend) {
                props.beforeSend = opts.beforeSend;
            }
            props.success = function(data){
                callback(data);
            };
            jQuery.ajax(props);
        };

        Common.ajax.isValidResponse = function(ajaxResponse) {
            if (ajaxResponse) {
                return ajaxResponse.status === 'SUCCESS' || ajaxResponse.status >= 200 && ajaxResponse.status < 300;
            }
        };

        /**
         * Asynchronous call, use this with jQuery.when(promise1, promise2, ...).then(function(loaded promise1, loaded promise2, loaded ...) { });
         * @param opts.url mandatory param
         * @param opts.method default is 'GET'
         * @param opts.data
         * @param opts.cache if true then result will be loaded once and stored in localStorage.
         * @param opts.ajax custom ajax function, can be used as backbone model fetch function.
         * @param opts.ajaxContext mandatory if using opts.ajax, if using backbone fetch, model should be passed.
         * @param opts.performAjax(opts) function that should invoke asynchronous ajax with given error and success callbacks
         */
        Common.ajax.promise = function(opts) {
            var deferred = jQuery.Deferred();
            opts.async = true;
            opts.success = function () {
                deferred.resolve.apply(deferred, arguments);
            };
            opts.error = function (ajaxResponse) {
                deferred.reject.apply(deferred, arguments);
                Common.ajax.validation.handleAjaxResponse(ajaxResponse)
            };
            if (opts.ajax && opts.ajaxContext) {
                opts.ajax.apply(opts.ajaxContext, [opts]);
            } else if (opts.performAjax) {
                opts.performAjax(opts);
            } else {
                _performAjax(opts);
            }
            return deferred.promise();
        };

        /** Internal ajax logic for synchronous and asynchronous requests. */
        function _performAjax(opts) {
            if (!opts.url) {
                throw new Error("Property is undefined: 'url'");
            }

            if (opts.cache && opts.method) {
                if (opts.cache == true && opts.method != 'GET') {
                    throw new Error("Common ajax support cache functionality only with GET method.")
                }
            }

            if (opts.cache) {
                var ajaxCache = CommonLocalStorage.webStorage.get(localStorage, CommonLocalStorage.webStorage.keys.AJAXCache, {});
                if (ajaxCache[opts.url]) {
                    if (opts.success) {
                        opts.success(ajaxCache[opts.url]);
                        return;
                    } else {
                        return ajaxCache[opts.url];
                    }
                }
            }

            var props = {
                url: AppCommon.baseUrl + opts.url,
                dataType: "json",
                contentType: opts.contentType || "application/json; charset=utf-8",
                async: opts.async,
                method: opts.method || 'GET',
                data: opts.data,
                success: !opts.success ? null : function(data) {
                    if (opts.cache) {
                        ajaxCache[opts.url] = data;
                        CommonLocalStorage.webStorage.set(localStorage, CommonLocalStorage.webStorage.keys.AJAXCache, ajaxCache);
                    }
                    opts.success(data);
                },
                error: opts.error || jQuery.ajaxSetup().error
            };

            var ajaxResponse = jQuery.ajax(props);
            if (!opts.async && !opts.success) {
                if (opts.cache) {
                    ajaxCache[opts.url] = ajaxResponse.responseJSON;
                    CommonLocalStorage.webStorage.set(localStorage, CommonLocalStorage.webStorage.keys.AJAXCache, ajaxCache);
                }
                if (isValidResponse(ajaxResponse)) {
                    ajaxResponse.responseJSON.status = 200;
                    return ajaxResponse.responseJSON;
                }
            }
            return ajaxResponse;
        }

        Common.ajax.validation = {
            /**
             * If response status is 500 then show error message in .errorDescription container.
             * If response status is between 200 and 299 then all messages will be cleared, and true will be returned.
             * If response contains fieldRemarks, then for each remark message will be displayed in general container or in input own container.
             * All remarks will be saved in model's field - validationError.
             * If message contains other type of error, then only general container will be used
             * */
            handleAjaxResponse: function(ajaxResponse) {
                if (ajaxResponse) {

                    if (ajaxResponse.status === 500) {
                        Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.message"));
                        return false;
                    }

                    if (Common.ajax.isValidResponse(ajaxResponse)) {
                        Common.ajax.validation.clearErrorDescription();
                        Common.ajax.validation.clearInputRemark();
                        return true;
                    }

                    var responseJSON = ajaxResponse.responseJSON;
                    if (responseJSON) {
                        var message = responseJSON.message;
                        if (message) {
                            Common.ajax.validation.showErrorDescription(message);
                        }

                        var fieldRemarks = responseJSON.fieldRemarks;
                        if (fieldRemarks) {
                            var remarks = ajaxResponse.responseJSON.fieldRemarks;

                            Common.ajax.validation.clearInputRemark();

                            _.each(remarks, function (item) {
                                Common.ajax.validation.showInputRemark(item.field, item.remark);
                            });
                        }
                    } else {
                        var errorMessage;
                        if (ajaxResponse.message) {
                            errorMessage = Common.bundles.getMessage(ajaxResponse.message);
                        } else {
                            errorMessage = ajaxResponse.status + " " + ajaxResponse.statusText;
                        }
                        Common.ajax.validation.showErrorDescription(errorMessage || ajaxResponse.message);
                    }
                }
                return false;
            },
            showErrorDescription: function(text) {
                var $errorContainer = jQuery(".errorDescription");
                if (!$errorContainer.length) {
                    $errorContainer = jQuery(".globalErrorMessages");
                }
                $errorContainer.text(text);
            },
            clearErrorDescription: function() {
                jQuery(".globalErrorMessages, .errorDescription").text("");
            },
            showInputRemark: function(inputName, text) {
                var $remarks = jQuery("[name=" + inputName + "], [data-remark-field=" + inputName + "].fieldRemark");
                if ($remarks.length > 0) {
                    $remarks.each(function(index, target) {
                        var $target = jQuery(target);
                        if ($target.is(".fieldRemark")) {
                            $target.text(text);
                        } else {
                            var $fieldRemark = $target.siblings(".fieldRemark");
                            if ($fieldRemark.length > 0) {
                                $fieldRemark.text(text);
                            } else {
                                throw new Error("Field remark to input with [name='" + inputName + "'] should be added.");
                            }
                        }
                    });
                } else {
                    this.showErrorDescription(inputName + ": " + text);
                }
            },
            clearInputRemark: function(inputName) {
                if (inputName) {
                    jQuery("[name=" + inputName + "]").each(function(index, input) {
                        jQuery(input).siblings(".fieldRemark").text("");
                    });
                } else {
                    jQuery(".fieldRemark").text("");
                }
            },
            clearRemarks: function() {
                this.clearErrorDescription();
                this.clearInputRemark();
            }
        };

        return Common;
    }
);
