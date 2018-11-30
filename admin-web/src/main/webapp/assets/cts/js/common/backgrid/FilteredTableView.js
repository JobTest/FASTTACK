(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
                'jquery',
                'common.util.backbone',
                'backbone',
                'common.util.ajax',
                'common.backgrid.PaginatorWithInputFields',
                'common.backgrid.GridView',
                'common.backgrid.TemplateCell',
                'common.views.InputAwareViewWithValidation',
                'common.backgrid.FilterView',
                'common.util.url',
                'backbone.deep-model',
                'common.util.messages',
                'common.localStorage',
                'common.util.filter',
                'select2'
            ]
            , factory);
    }
    else {
        factory();
    }
})
(function ($, Common, Backbone, CommonAjax, Paginator, Grid, TemplateCell, InputAwareViewWithValidation, FilterView) {

    var ListView = InputAwareViewWithValidation.extend({
        initialize: function (opts) {
            this.handle = opts.handle;
            this.url = opts.url;
            this.listCollection = opts.listCollection;
            this.listGrid = new Grid({
                className: "backgrid table-responsive",
                columns: opts.listColumns.map(function (col) {
                    var cell;
                    if(col.cell){
                        cell = col.cell;
                    } else if (col.cellTemplate && Object.prototype.toString.call(col.cellTemplate) == "[object Function]") {
                        cell = TemplateCell.extend({template: col.cellTemplate});
                    } else if (col.cellTemplate && Object.prototype.toString.call(col.cellTemplate) == "[object String]") {
                        cell = TemplateCell.extend({template: _.template(col.cellTemplate)})
                    } else {
                        throw new Error("Specify cell or cellTemplate for column " + col.name);
                    }
                    return {
                        label: col.label,
                        name: col.name,
                        cell: cell,
                        headerCell: col.headerCell,
                        sortable: col.sortable,
                        editable: col.editable
                    };
                }),
                collection: this.listCollection
            });
            this.listPaginator = new Paginator({
                windowSize: 20,
                slideScale: 0.25,
                goBackFirstOnSort: false,
                collection: this.listCollection
            });

            this.listenTo(this.handle, "backgrid:filter", function (filter) {
                Common.ajax.validation.clearRemarks();
                this.listCollection.setFilter(filter.toJSON());
                this.listCollection.fetch({data: filter.toJSON()});
            });

            this.render();

        },

        render: function () {
            this.$el.empty();
            this.$el.append(this.listGrid.render().el);
            this.$el.append(this.listPaginator.render().el);
            return this;
        }
    });


    return InputAwareViewWithValidation.extend({

        FilterViewConstructor: FilterView,
        el: "#main-container",

        initialize: function () {
            this.createHandle();

            if (!this.template) {
                throw new Error("Filter template is undefined.");
            }
            this.filterView = new this.FilterViewConstructor({
                template: this.template,
                handle: this.handle,
                validateEmptyFilter:this.validateEmptyFilter
            });
            this.initBeforeRender();

            var collection;
            if (this.CollectionConstructor) {
                collection = new this.CollectionConstructor();
            } else {
                if (this.collectionUrl) {
                    collection = new (Common.backbone.collection.QueryResultPageableCollection.extend({
                        url: AppCommon.baseUrl + this.collectionUrl
                    }))();
                } else {
                    throw new Error("Collection URL or collection constructor is undefined.");
                }
            }

            if (!this.listColumns) {
                throw new Error("List columns is undefined.");
            }

            collection.filterName = this.filterName;
            this.listView = new ListView({
                listColumns: this.listColumns,
                listCollection: collection,
                handle: this.handle,
                filterName: this.filterName
            });
            this.render();
            this.initAfterRender();
        },
        render: function () {
            this.$el.find("#filterContainer").html(
                this.filterView.el
            );
            this.$el.find("#tableContainer").html(
                this.listView.el
            );
        },
        initAfterRender: function(){
            var savedFilter = Common.filter.getSavedFilter(this.filterName);
            if(savedFilter){
                if(!$.isEmptyObject(savedFilter)){
                    this.filterView.model.set(savedFilter, {updateInput: true});
                    this.listView.listCollection.setFilter(savedFilter);
                    this.listView.listCollection.fetch({data: savedFilter});
                }
            }
        }
    });

});