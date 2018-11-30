(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'cardProduct/filter_view_template',
            'common.util.messages',
            'common.util.ajax'
        ], factory);
    } else {
        factory();
    }
})(
    function (FilteredTableView, filter_view_template, CommonMessages, Common) {
        var TemplateCell = Backgrid.Cell.extend({
            render: function () {
                this.$el.empty();
                var context = {
                    baseUrl: AppCommon.baseUrl,
                    model: this.model.toJSON()
                };
                this.$el.append(this.template(context));
                this.delegateEvents();
                return this;
            }
        });

        var CardProductFilterTableView = FilteredTableView.extend({
            CollectionConstructor: Common.backbone.collection.QueryResultPageableCollection.extend({
                url: AppCommon.baseUrl + "cardProduct/filter.json",
                state: {sortKey: "productConfigId"}
            }),
            filterName: "CardProductListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    label: CommonMessages.bundles.getMessage("cardProduct.productConfigId"),
                    name: "productConfigId",
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}cardProduct/view.htm?productConfigId={{=model.productConfigId}}'>{{=model.productConfigId}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    label: CommonMessages.bundles.getMessage("cardProduct.beginRange"),
                    name: "beginRange",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    label: CommonMessages.bundles.getMessage("cardProduct.endRange"),
                    name: "endRange",
                    cell: "string",
                    sortable: true,
                    editable: false
                }
            ],
            initAfterRender:function(){
                this.superInitAfterRender(FilteredTableView);
                this.handle.trigger("backgrid:filter", this.filterView.model);
            }
        });

        new CardProductFilterTableView();
    }
);