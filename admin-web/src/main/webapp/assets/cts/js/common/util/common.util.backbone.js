(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.backbone',
            [
                'common.util.core',
                'backbone',
                'underscore',
                'backbone.paginator',
                'backbone.deep-model',
                'backgrid.filter',
                'common.util.filter',
                'common.localStorage',
                'common.util.ajax'
            ], factory);
    } else {
        factory();
    }
})(
    function (Common, Backbone, _) {
        Common.backbone = {};
        Common.backbone.model = {};
        Common.backbone.collection = {};
        Common.backgrid = {};

        /**
         * Model which can extract dto from JsonResponseWrapper response.
         * Error will be thrown if no template for operation and no 'url' parameter in options.
         */
        Common.backbone.model.JsonResponseWrapperModel = Backbone.DeepModel.extend({
            sync: function(method, model, options) {
                options = options || {};
                var template = this._getUrlTemplateMap()[method.toLowerCase()];
                if (template) {
                    options.url = template({model: model});
                } else {
                    if (!options.url) {
                        throw new Error("No url template for method: " + method);
                    }
                }
                return Backbone.sync.apply(this, arguments);
            },
            parse: function(resp, options) {
                if (!resp) {
                    throw new Error("Empty response from server.");
                } else if (options.collection) {
                    return resp;
                } else if (resp.responseWrapper) {
                    if (resp.dto) {
                        return resp.dto;
                    } else {
                        var message = resp.message ? "Error: " + resp.message : "Unknown error.";
                        throw new Error(message);
                    }
                } else {
                    return resp;
                }
            }
        });

        /**
         * Collection, which knows how to extract pageable result from QueryResult.
         * */
        Common.backbone.collection.QueryResultPageableCollection = Backbone.PageableCollection.extend({
            model: Common.backbone.model.JsonResponseWrapperModel,
            filterName: "",
            // You can remap the query parameters from `state` keys from
            // the default to those your server supports
            queryParams: {
                currentPage: "page",
                pageSize: "limit",
                totalPages: "maxPage",
                totalRecords: "totalCount",
                sortKey: "sortField",
                order: "asc",
                directions: {
                    "1": "false",
                    "-1": "true"
                }
            },
            // Initial pagination state
            state: {
                pageSize: 20,
                order: 1
            },
            initialize: function(opts) {
                if(opts){
                    if (opts.state) {
                        var state = opts.state;
                        this.state.page = state.page || this.state.page;
                        this.state.pageSize = state.pageSize || this.state.pageSize;
                        this.state.sortKey = state.sortKey || this.state.sortKey;
                        this.state.order = state.order || this.state.order;
                    }
                    this.filterName = opts.filterName;
                }

            },
            parseState: function (resp, queryParams, state, options) {
                return {
                    currentPage: resp.page,
                    pageSize: resp.limit,
                    totalPages: resp.maxPage,
                    totalRecords: resp.totalCount,
                    sortKey: resp.sortField,
                    order: resp.asc ? -1 : 1
                };
            },

            setSorting: function(sortKey, order, options){
                if(typeof this.filter !== "function"){
                    this.filter.sortField = sortKey;
                    this.filter.asc = order === -1;
                }
                return Backbone.PageableCollection.prototype.setSorting.call(this, sortKey, order, options);
            },
            parseRecords: function (resp) {
                return resp.objects;
            },
            /**
             * override default method fetch to add filter to the each request
             */
            fetch: function(options){
                options = options || {};
                if (typeof this.filter !== "function") {
                    options.data = this.filter;
                }
                if (this.filterName) {
                    Common.webStorage.set(sessionStorage, this.filterName, options.data);
                }

                options.error = function(model, ajaxResponse) {
                    Common.ajax.validation.handleAjaxResponse(ajaxResponse);
                };

                return Backbone.PageableCollection.prototype.fetch.call(this, options);
            },
            setFilter: function (filter) {
                this.filter = filter;
                this.state.sortKey = filter.sortField || this.state.sortKey;
                this.state.order = (filter.asc ? -1 : 1) || this.state.order;
            }
        });

        /**
         * Backgrid server-side filter which store its state in sessionStorage
         */
        var persistentServerSideFilter = Backgrid.Extension.ServerSideFilter.extend({
            initialize: function(options){
                persistentServerSideFilter.__super__.initialize.apply(this, arguments);

                var savedFilter = Common.filter.getSavedFilter(options.collection.filterName);
                if(savedFilter){
                    options.collection.setFilter(savedFilter);
                    var savedValue = savedFilter[options.name];
                    this.searchBox().val(savedValue);
                    this.value = savedValue;
                } else {
                    /**
                     * initialize with empty filter, to be able to save sortField and order in storage
                     */
                    options.collection.setFilter({});
                }
            }
        });

        Common.backgrid.persistentServerSideFilter = persistentServerSideFilter;

        return Common;
    }
);
