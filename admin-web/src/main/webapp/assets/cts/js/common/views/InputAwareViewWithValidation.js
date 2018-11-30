(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.ViewWithInputs',
            'common.util.ajax',
            'backbone',
            'parsley'
        ], factory);
    } else {
        factory();
    }
})(
    function(ViewWithInputs, CommonAjax) {
        /**
         * For validation, template should contains container with class 'errorDescription' for general validation messages,
         * or container with class 'fieldRemark' near each input, as sibling.
         * Field remark could have attribute 'data-remark-field' - name of field from server.
         * See Common.ajax.validation.handleAjaxResponse
         */
        return ViewWithInputs.extend({
            attributes: {
                'data-parsley-validate': true
            },

            handleAjaxResponse: Common.ajax.validation.handleAjaxResponse,

            validateInputs: function() {
                CommonAjax.ajax.validation.clearRemarks();

                var p = this.$el.parsley();
                p.reset();
                return p.validate();
            }
        });
    }
);
