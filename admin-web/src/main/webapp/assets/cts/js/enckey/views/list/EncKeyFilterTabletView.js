(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'enckey/filter_view_template',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (FilteredTableView, filter_view_template, CommonMessages) {

        var EncKeyFilterTableView = FilteredTableView.extend({
            collectionUrl: "enckey/filter.json",
            filterName: "EncKeyListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    name: "keyType",
                    label: CommonMessages.bundles.getMessage("enckey.keyType"),
                    cellTemplate: "<a href='{{=baseUrl}}enckey/view.htm?id={{=model.id}}'>{{=model.keyType}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "refCode",
                    label: CommonMessages.bundles.getMessage("enckey.refCode"),
                    cellTemplate: "<a href='{{=baseUrl}}enckey/view.htm?id={{=model.id}}'>{{=model.refCode}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "capacity",
                    label: CommonMessages.bundles.getMessage("enckey.capacity"),
                    cellTemplate: "<a href='{{=baseUrl}}enckey/view.htm?id={{=model.id}}'>{{=model.capacity}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "statusCode",
                    label: CommonMessages.bundles.getMessage("enckey.statusCode"),
                    cellTemplate: "<a href='{{=baseUrl}}enckey/view.htm?id={{=model.id}}'>{{=model.statusCode}}</a>",
                    sortable: true,
                    editable: false
                }
            ],
            initAfterRender:function(){
                this.superInitAfterRender(FilteredTableView);
                this.handle.trigger("backgrid:filter", this.filterView.model);
            }
        });

        new EncKeyFilterTableView();
    }
);