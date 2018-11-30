(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.messages', [
                'common.util.core',
                'common.util.ajax',
                'common.localStorage'], factory);
    } else {
        factory();
    }
})(
    function (Common) {
        var storage_key = "Bundles";
        var message_bundle_path = "messageBundles.json";
        var messageStorage = Common.webStorage.get(localStorage, storage_key);
        if (!messageStorage || (messageStorage.version != Common.context.version)) {
            var response = Common.ajax.sync({url : message_bundle_path});
            messageStorage = {
                map: response.dto,
                version: Common.context.version
            };
            Common.webStorage.set(localStorage, storage_key, messageStorage);
        }

        Common.bundles = {};
        Common.bundles.getMessage = function(key, args) {
            var message = messageStorage.map[key];
            if (message && args) {
                if (args.constructor === [].constructor) {
                    for (var i = 0; i < args.length; i++) {
                        message = message.replace("{" + i + "}", args[i]);
                    }
                } else if (args.constructor === {}.constructor) {
                    for (var key in args) {
                        message = message.replace("{" + key + "}", args[key]);
                    }
                }
            }
            return message;
        };
        return Common;
    }
);