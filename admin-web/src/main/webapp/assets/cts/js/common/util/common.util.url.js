/**
 Url parser.
 Can handle nested properties, arrays, indexed arrays, objects inside arrays, arrays inside arrays.
 Examples:
 1) param 'root.object.name=Bob' creates next structure:
 {
     root: {
         object: {
             name: 'Bob'
         }
     }
 }

 2) param 'root[]=1&root[]=2' creates next structure:
 {
     root: [1, 2]
 }

 3) param 'root[0].name=Bob&root[0].age=20&root[1].name=Pol&root[1].age=22' creates next structure:
 {
     root: [
         {name: 'Bob', age: 20},
         {name: 'Pol', age: 22}
     ]
 }

 4) param 'root[].name=Bob&root[].age=20' creates next structure:
 {
     root: [
         {name: 'Bob'},
         {age: 20}
     ]
 }

 5) param 'root[0].[0]=1&root[0].[1]=2&root[1].[0]=3&root[1].[1]=4' creates next structure:
 {
     root: [
         [1, 2],
         [3, 4],
     ]
 }

 */
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.url', ['common.util.core'], factory);
    } else {
        factory();
    }
})(
    function (Common) {

        if (!Common.Url) {
            Common.Url = {};
        }

        function parseUrl(url) {
            url = decodeURI(url ? url : window.location.href);
            var params = getParamsFromUrl(url);
            var rootObject = {};

            for (var i = 0; i < params.length; i++) {
                var currentContainer = rootObject;
                var param = params[i];
                var paramName = param.name;
                var paramValue = getParamValue(param.value);
                var propertyPaths = paramName.split(".");

                var isPreviousArray = false;
                var previousArrayIndex;
                for (var k = 0; k < propertyPaths.length; k++) {
                    var hasNext = k < propertyPaths.length - 1;
                    var arrayPropertyRegexp = /([a-z][0-9a-z]*)?(\[([0-9]*)\])?/gi;
                    var propertyPath = arrayPropertyRegexp.exec(propertyPaths[k]);
                    var property = propertyPath[1];
                    var isHasProperty = property != null;
                    var isArray = propertyPath[2] != null;
                    var arrayIndex = propertyPath[3];
                    if (hasNext || isArray || isPreviousArray) {
                        if (isPreviousArray) {
                            if (previousArrayIndex) {
                                var parentObj = currentContainer[previousArrayIndex];
                                if (parentObj) {
                                    if (!hasNext || !isHasProperty) {
                                        currentContainer = parentObj;
                                    }
                                    else {
                                        if (!parentObj[property]) {
                                            parentObj[property] = isArray ? [] : {};
                                        }
                                        currentContainer = parentObj[property];
                                    }
                                } else {
                                    var parentObj = isHasProperty ? {} : [];
                                    currentContainer[previousArrayIndex] = parentObj;
                                    if (isHasProperty && (hasNext || isArray)) {
                                        parentObj[property] = isArray ? [] : {};
                                        currentContainer = parentObj[property];
                                    }
                                    else {
                                        currentContainer = parentObj;
                                    }
                                }
                            } else {
                                var parentObj = isHasProperty ? {} : [];
                                currentContainer.push(parentObj);
                                if (isHasProperty && (hasNext || isArray)) {
                                    parentObj[property] = isArray ? [] : {};
                                    currentContainer = parentObj[property];
                                }
                                else {
                                    currentContainer = parentObj;
                                }
                            }
                        } else {
                            if (!isHasProperty) {
                                throw new Error("Can't parse parameter: " + paramName +  " , array without property name should be inside array with property name, like: arrays[].[] ");
                            }
                            if (!currentContainer[property]) {
                                currentContainer[property] = isArray ? [] : {};
                            }
                            currentContainer = currentContainer[property];
                        }
                    }
                    if (!hasNext) {
                        if (isArray) {
                            if (arrayIndex) {
                                currentContainer[arrayIndex] = paramValue;
                            } else {
                                currentContainer.push(paramValue);
                            }
                        } else {
                            currentContainer[property] = paramValue;
                        }
                    }
                    isPreviousArray = isArray;
                    previousArrayIndex = isPreviousArray ? arrayIndex : null;
                }
            }
            return rootObject;
        }


        function getParamValue(string) {
            string = decodeURIComponent(string);
            if (!isNaN(string) && (string.indexOf("0") != 0) && !string.contains('.') && string.length <= 16) {
                // string.length <= 16 - for big numbers return not user friendly format (example 1.2345678901234567e+59),
                // leave number which more then 16 symbols as string
                return +string;
            }
            else if (string.toLowerCase() == "true" || string.toLowerCase() == "false" ) {
                return string.toLowerCase() == "true";
            }
            else {
                return string;
            }
        }

        /**
         * get array with objects {name, value}
         */
        function getParamsFromUrl(url) {
            var querySplitRegexp = /(?:\?|&)((?:\.?(?:(?:[a-z][0-9a-z]*)|(?:[a-z][0-9a-z]*(?:\[[0-9]*\]))|(?:\[[0-9]*\])))+)=([^&#]+)/gi;
            var params = [];
            var rawParam = querySplitRegexp.exec(url);
            while (rawParam) {
                params.push({
                    name: rawParam[1],
                    value: rawParam[2]
                });
                rawParam = querySplitRegexp.exec(url);
            }
            return params;
        }

        function urlBuilder(object, rootName) {
            var result = "";

            if (object && object instanceof Array && object.length > 0) {
                object.forEach(function(item, index) {
                    if (index > 0) {
                        result += '&';
                    }
                    Object.keys(item).forEach(function (i, inx) {
                        if (inx > 0) {
                            result += '&';
                        }
                        result += rootName + '[' + index + '].' + i + '=' + item[i];
                    });
                });
            } else if (object && object instanceof Object) {
                result = Object.keys(object).map(function(key) {
                        return encodeURIComponent(rootName + '.' + key) + '=' + encodeURIComponent(object[key])
                    }).join('&');
            }
            return result;
        }


        function getUrlWithoutQueryParams () {
            /**
             * Has 2 capture groups:
             * $1 - url part before query param string, without ?
             * $2 - ? and query parameters
             *
             * Non-capturing groups:
             * - anything except ?, = &
             * - optional path part, starting with slash
             * - mandatory path end part, slash, anything except slash, then '.htm'
             * */
            return window.location.href.replace(/^((?:.[^?=&]+)(?:\/[^\/]+)*(?:\/[^\/]+.htm))(\?.+)*/, "$1");
        }

        Common.Url.parse = parseUrl;
        Common.Url.urlBuilder = urlBuilder;
        Common.Url.getUrlWithoutQueryParams = getUrlWithoutQueryParams;

        return Common;
    }
);
