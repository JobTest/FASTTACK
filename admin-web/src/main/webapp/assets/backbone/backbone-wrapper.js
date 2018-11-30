(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define(['backbone', 'common.util.ajax'], factory);
    } else {
        factory();
    }
})(
    function(Backbone, Common) {

        Backbone.extend = function(parent, additionalProperties) {
            return Backbone.View.extend.call(parent, additionalProperties);
        };

        /**
         * Override existing sync, add possibility to stringify 'data' param when url ends with '.json'
         * */
        Backbone.sync = function(method, model, options) {
            var type = methodMap[method];

            // Default options, unless specified.
            _.defaults(options || (options = {}), {
                emulateHTTP: Backbone.emulateHTTP,
                emulateJSONemulateJSON: Backbone.emulateJSON
            });

            // Default JSON-request options.
            var params = {type: type, dataType: 'json'};

            // Ensure that we have a URL.
            if (!options.url) {
                params.url = _.result(model, 'url') || urlError();
            }

            // Ensure that we have the appropriate request data.
            if (options.data == null && model && (method === 'create' || method === 'update' || method === 'patch')) {
                params.contentType = 'application/json';
                params.data = JSON.stringify(options.attrs || model.toJSON(options));
            } else {
                /** All methods, which end with json should be post with data stringified. */
                var url = options.url || params.url;
                var data = options.data || params.data;
                if (url.endsWith(".json") && data) {
                    options.method = "POST";
                    options.contentType = 'application/json';
                    options.data = JSON.stringify(data);
                }
            }

            // For older servers, emulate JSON by encoding the request into an HTML-form.
            if (options.emulateJSON) {
                params.contentType = 'application/x-www-form-urlencoded';
                params.data = params.data ? {model: params.data} : {};
            }

            // For older servers, emulate HTTP by mimicking the HTTP method with `_method`
            // And an `X-HTTP-Method-Override` header.
            if (options.emulateHTTP && (type === 'PUT' || type === 'DELETE' || type === 'PATCH')) {
                params.type = 'POST';
                if (options.emulateJSON) params.data._method = type;
                var beforeSend = options.beforeSend;
                options.beforeSend = function(xhr) {
                    xhr.setRequestHeader('X-HTTP-Method-Override', type);
                    if (beforeSend) return beforeSend.apply(this, arguments);
                };
            }

            // Don't process data on a non-GET request.
            if (params.type !== 'GET' && !options.emulateJSON) {
                params.processData = false;
            }

            // Pass along `textStatus` and `errorThrown` from jQuery.
            var error = options.error;
            options.error = function(xhr, textStatus, errorThrown) {
                options.textStatus = textStatus;
                options.errorThrown = errorThrown;

                if (error){
                    error.call(options.context, xhr, textStatus, errorThrown);
                }

                Common.ajax.validation.handleAjaxResponse(xhr);
            };

            // Make the request, allowing the user to override any Ajax options.
            var xhr = options.xhr = Backbone.ajax(_.extend(params, options));
            model.trigger('request', model, xhr, options);
            return xhr;
        };

        // Map from CRUD to HTTP for our default `Backbone.sync` implementation.
        var methodMap = {
            'create': 'POST',
            'update': 'PUT',
            'patch':  'PATCH',
            'delete': 'DELETE',
            'read':   'GET'
        };

        // Set the default implementation of `Backbone.ajax` to proxy through to `$`.
        // Override this if you'd like to use a different library.
        Backbone.ajax = function() {
            return Backbone.$.ajax.apply(Backbone.$, arguments);
        };

        // Throw an error when a URL is needed, and none is supplied.
        var urlError = function() {
            throw new Error('A "url" property or function must be specified');
        };

        return Backbone;
    }
);
