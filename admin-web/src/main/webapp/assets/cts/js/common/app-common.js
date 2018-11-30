window.AppCommon.assetBaseUrl = AppCommon.baseUrl + "assets/";

window.AppCommon.tplBaseUrl = "tpl!" + AppCommon.baseUrl + "template/";

window.AppCommon.templateSettings = {
    /* Void expression, when need to create local variable {{var a = 1;}} */
    evaluate: /\{\{(.+?)\}\}/g,
    /* Place result into template  {{=obj.name}} */
    interpolate: /\{\{=(.+?)\}\}/g,
    /* Place escaped result into template  {{-obj.name}} */
    escape: /\{\{-(.+?)\}\}/g
};

(function () {
    var baseUrl = AppCommon.assetBaseUrl;
    var paths = {
        tpl: baseUrl + 'dist/js/tpl.min-0.0.2',
        text: baseUrl + 'requirejs/text-2.0.14',
        require: baseUrl + 'require/require.min.js',
        underscore: baseUrl + 'underscore/underscore-min-1.8.3',
        'underscore.wrapper': baseUrl + 'underscore/underscore-wrapper',
        backbone: baseUrl + 'backbone/backbone-min-1.2.3',
        'backbone.wrapper': baseUrl + 'backbone/backbone-wrapper',
        'backbone.paginator': baseUrl + 'backbone/backbone.paginator.min',

        backgrid: baseUrl + 'backgrid/js/backgrid.min-0.3.5',
        'backgrid.paginator': baseUrl + 'backgrid/js/backgrid-paginator',
        'backgrid.filter': baseUrl + 'backgrid/js/backgrid-filter',
        'backgrid.select-all' : baseUrl + 'backgrid/js/backgrid-select-all.min',
        'backbone.deep-model': baseUrl + 'backbone/deep-model.min',

        jquery: baseUrl + 'dist/js/jquery-3.2.1.min',
        'jquery.wrapper': baseUrl + 'cts/js/jquery/jquery-wrapper',
        bootstrap: baseUrl + 'bootstrap/js/bootstrap.min-3.3.5',

        bootstrapDatepicker: baseUrl + 'bootstrap/js/bootstrap-datepicker.min-1.4.0',
        select2: baseUrl + 'select2/select2-3.5.4.min',
        'select2.wrapper': baseUrl + 'select2/select2-wrapper',
        parsley: baseUrl + 'parsley/parsley.min-2.2.0-rc4',
        'parsley.wrapper': baseUrl + 'parsley/parsley-wrapper',
        'moment': baseUrl + 'dist/js/moment.min-2.15.1',

        /** Common utils */
        'common.localStorage': baseUrl + 'cts/js/common/util/common.localStorage',
        'common.util.messages': baseUrl + 'cts/js/common/util/common.util.messages',
        'common.util.acls': baseUrl + 'cts/js/common/util/common.util.acls',
        'common.util.core': baseUrl + 'cts/js/common/util/common.util.core',
        'common.util.ajax': baseUrl + 'cts/js/common/util/common.util.ajax',
        'common.util.url': baseUrl + 'cts/js/common/util/common.util.url',
        'common.util.filter': baseUrl + 'cts/js/common/util/common.util.filter',
        'common.util.date': baseUrl + 'cts/js/common/util/common.util.date',
        'common.util.backbone': baseUrl + 'cts/js/common/util/common.util.backbone',
        'common.util.input.InputChangeHandlerApi': baseUrl + 'cts/js/common/util/input/InputChangeHandlerApi',
        'common.util.input.DefaultInputChangeHandler': baseUrl + 'cts/js/common/util/input/DefaultInputChangeHandler',
        'common.util.input.BooleanInputChangeHandler': baseUrl + 'cts/js/common/util/input/BooleanInputChangeHandler',
        'common.util.input.Select2ObjectModeInputChangeHandler': baseUrl + 'cts/js/common/util/input/Select2ObjectModeInputChangeHandler',

        'common.backgrid.PaginatorWithInputFields': baseUrl + 'cts/js/common/backgrid/PaginatorWithInputFields',
        'common.backgrid.GridView': baseUrl + 'cts/js/common/backgrid/GridView',
        'common.backgrid.TemplateCell': baseUrl + 'cts/js/common/backgrid/TemplateCell',
        'common.backgrid.FilterView': baseUrl + 'cts/js/common/backgrid/FilterView',
        'common.backgrid.FilteredTableView': baseUrl + 'cts/js/common/backgrid/FilteredTableView',

        /** Backbone Views */
        'common.views.SimpleView': baseUrl + 'cts/js/common/views/SimpleView',
        'common.views.SimpleViewWithModel': baseUrl + 'cts/js/common/views/SimpleViewWithModel',
        'common.views.ViewWithInputs': baseUrl + 'cts/js/common/views/ViewWithInputs',
        'common.views.InputAwareViewWithValidation': baseUrl + 'cts/js/common/views/InputAwareViewWithValidation',
        'common.views.modalPanel.SimpleModalPanelView': baseUrl + 'cts/js/common/views/modalPanel/SimpleModalPanelView',

        /** other */
        sbAdmin: baseUrl + 'dist/js/sb-admin-2',
        metisMenu: baseUrl + 'dist/js/metisMenu.min'
    };
    var map = {
        '*': {
            /** Everyone will receive domain instead of '*.wrapper' */
            backbone: 'backbone.wrapper',
            underscore: 'underscore.wrapper',
            select2: 'select2.wrapper',
            parsley: 'parsley.wrapper',
            jquery: 'jquery.wrapper'
        },
        /** But wrapper will receive real domain */
        'backbone.wrapper': {
            backbone: 'backbone'
        },
        'underscore.wrapper': {
            underscore: 'underscore'
        },
        'select2.wrapper': {
            select2: 'select2'
        },
        'parsley.wrapper': {
            parsley: 'parsley'
        },
        'jquery.wrapper': {
            jquery: 'jquery'
        }
    };
    var shims = {
        bootstrap: ['jquery'],
        bootstrapDatepicker: ['jquery', 'bootstrap'],
        /** Backgrid is not requireJs friendly, so requireJs will wrap it to provide common functionality */
        backgrid: {
            deps: ['jquery', 'underscore', 'backbone'],
            exports: 'Backgrid'
        },
        select2: ['jquery', 'common.util.messages'],
        parsley: ['jquery'],
        'backgrid.paginator': ['backgrid'],
        'backgrid.filter': ['backgrid'],
        metisMenu: ['jquery'],
        sbAdmin: ['jquery', 'metisMenu'],
        'backbone.deep-model': ['backbone']
    };

    /** Default page dependencies, which exist on each page. */
    var requires = ['bootstrap', 'sbAdmin', 'metisMenu'];

    /**
     * Invoke method that can modify existing dependencies
     * */
    if (window.extendRequireJsDependency) {
        window.extendRequireJsDependency(paths, shims, requires);
    }

    require.config({
        /** Prevent scripts loaded with require.js from caching */
        urlArgs: function (id, url) {
            if (url.indexOf("cdnjs") > 0) {
                return "";
            }
            return ((url.indexOf("?") === -1) ? "?" : "&") + "v=" + AppCommon.context.version;
        },
        paths: paths,
        map: map,
        wrapShim: true,
        shim: shims,
        // tpl should change underscore templateSettings
        tpl: {
            templateSettings: AppCommon.templateSettings,
            extension: '.htm'
        }
    });

    require(requires, function () {
    });
})();