(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define(['underscore'], factory);
    } else {
        factory();
    }
})(
    function(_) {
        _.templateSettings = AppCommon.templateSettings;
        return _;
    }
);
