(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define(["jquery", "common.util.messages", "select2"], factory);
    } else {
        factory();
    }
})(
    function($, Common) {

        $.fn.select2.locales['en'] = {
            formatNoMatches: function () {
                return Common.bundles.getMessage("select2.formatNoMatches");
            },
            formatInputTooShort: function (input, min) {
                return Common.bundles.getMessage("select2.formatInputTooShort") + character(min - input.length);
            },
            formatInputTooLong: function (input, max) {
                return Common.bundles.getMessage("select2.formatInputTooLong", [character(input.length - max)]);
            },
            formatSelectionTooBig: function (limit) {
                return Common.bundles.getMessage("select2.formatSelectionTooBig", [limit]) + (limit % 10 == 1 && limit % 100 != 11 ? Common.bundles.getMessage("common.text.suffix.single") : Common.bundles.getMessage("common.text.suffix.multiple"));
            },
            formatLoadMore: function (pageNumber) {
                return Common.bundles.getMessage("select2.formatLoadMore");
            },
            formatSearching: function () {
                return Common.bundles.getMessage("select2.formatSearching");
            }
        };

        $.extend($.fn.select2.defaults, $.fn.select2.locales['en']);

        function character (n) {
            return " " + n + " " + Common.bundles.getMessage("select2.character") + (n%10 < 5 && n%10 > 0 && (n%100 < 5 || n%100 > 20) ? n%10 > 1 ? Common.bundles.getMessage("common.text.suffix.single") : "" : Common.bundles.getMessage("common.text.suffix.multiple"));
        }
    }
);