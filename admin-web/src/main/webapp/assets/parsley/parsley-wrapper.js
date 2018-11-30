/**
 * Used to configure Parsley before registration in AMD
 * */
(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('parsley.wrapper', ['parsley', 'common.util.messages'], factory);
    } else {
        factory();
    }
})(function(Parsley, CommonMessages) {

    // PARSLEY CUSTOM VALIDATORS

    /** Check that that input field value not equals with field by param 'inputId' */
    window.Parsley.addValidator('notequalto', {
        validateString: function(val, inputId) {
            return val !== $(inputId).val();
        }
    });

    window.Parsley.addValidator('panformat', {
        validateString: function(val, inputId) {
            return !val || /^([\d]{16}|[\d]{19})$/.test(val) || /A[\d]{2}[A-F\d]{16}/.test(val);
        }
    });

    window.Parsley.addValidator('cardproductrange', {
        validateString: function(val, inputId) {
            return !val || /\d{6,19}/.test(val);
        }
    }).addMessage('en', 'cardproductrange', Common.bundles.getMessage('cardproduct.validation.range.size'));

    return Parsley;
});