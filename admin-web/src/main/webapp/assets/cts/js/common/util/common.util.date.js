(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.date', [
                'common.util.core',
                'bootstrapDatepicker',
                'common.util.ajax'], factory);
    } else {
        factory();
    }
})(
    function (Common) {
        Common.applyDatePicker = function ($date, startDate, format, minViewMode) {
            var opts = {
                autoclose: true,
                todayHighlight: true,
                startDate: startDate,
                format: format || 'dd.mm.yyyy', //Common.context.dateFormat.toLowerCase(),
                clearBtn: true,
                autocomplete: true,
                minViewMode: minViewMode ? minViewMode : "days"
            };
            $date.each(function(index, value) {
                $(this).datepicker(opts);
                if (startDate) {
                    $(this).datepicker("setDate", startDate);
                }
                // we have know when datepicker events was already worked by 'datepicker' class on input
                $(this).children("input").addClass("datepicker");
            });
        };
        return Common;
    }
);