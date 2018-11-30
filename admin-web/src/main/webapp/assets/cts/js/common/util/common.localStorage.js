(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.localStorage', [ 'moment', 'common.util.core'], factory);
    } else {
        factory();
    }
})(
    function (moment, Common) {
        Common.webStorage = {
            keys: {
                AJAXCache: "AJAXCache"
            }
        };

        /**
         * Check that cache is expired.
         * @param key localStorage key
         * @param cache localStorage json value
         * @returns {boolean}
         */
        var _isExpire = function (key, cache) {
            return cache.version != AppCommon.context.cacheVersion ||
                !cache.timestamp ||
                cache.userLogin != AppCommon.context.currentUserEmail ||
                AppCommon.context.cacheTimeToLive <= moment.duration(moment().diff(moment(cache.timestamp))).asMinutes();
        };

        /**
         * Provide localStorage key with {@code CommonConfig.localStoragePrefix} as prefix
         * @param key localStorage key
         * @returns {string}
         */
        var _provideKey = function (key) {
            return AppCommon.context.localStoragePrefix + "_" + key;
        };

        /**
         * Get value from localStorage.
         * Clear and set new value by defaultValue if storage is expire.
         * @param key localStorageKey
         * @param defaultValue default value
         * @returns {*}
         */
        Common.webStorage.get = function (storage, key, defaultValue) {
            var item = storage.getItem(_provideKey(key));
            var cache = item ? JSON.parse(item) : null;
            if (!cache || _isExpire(key, cache)) {
                if (defaultValue || !cache) {
                    if ("[object Function]" == Object.prototype.toString.call(defaultValue)) {
                        cache = this.set(storage, key, defaultValue());
                    } else {
                        cache = this.set(storage, key, defaultValue);
                    }
                }
            }
            return cache.map;
        };
        Common.webStorage.set = function (storage, key, value) {
            var cache = {
                version: AppCommon.context.cacheVersion,
                timestamp: new Date().getTime(),
                userLogin: AppCommon.context.currentUserEmail,
                map: value || {}
            };
            storage.setItem(_provideKey(key), JSON.stringify(cache));
            return cache;
        };

        /**
         * Add new value in cache.map
         * @param key localStorageKey
         * @param mapKey localStorage cache.map key
         * @param mapValue localStorage cache.map value
         */
        Common.webStorage.add = function (storage, key, mapKey, mapValue) {
            if (mapValue) {
                var cache = this.get(key, {});
                cache[mapKey] = mapValue;
                this.set(storage, key, cache);
            }
        };
        Common.webStorage.remove = function(storage, key){
            var storageKey = _provideKey(key);
            storage.removeItem(storageKey);
        };
        Common.webStorage.removeAll = function(storage) {
            var keys = [];
            for (var i = 0; i < storage.length; i++) {
                var key = storage.key(i);
                if (key.startsWith(AppCommon.context.localStoragePrefix)) {
                    keys.push(key);
                }
            }
            for (var j = 0; j < keys.length; j++) {
                storage.removeItem(keys[j]);
            }
        };

        return Common;
    }
);
