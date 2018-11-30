/**
 * Used to configure jquery before registration in AMD, requires real jQuery to set configuration
 * */

(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('jquery.wrapper', ['jquery'], factory);
    } else {
        factory();
    }
})(function(jQuery) {
    jQuery.ajaxSetup({
        /**
         * Disables caching globally
         */
        cache: false,
        /**
         * Extends jQuery adding csrf protection. Setting token in ajax request header
         */
        headers:{
            'X-CSRF-TOKEN': jQuery("meta[name='_csrf']").attr("content")
        }
    });

    return jQuery;
});