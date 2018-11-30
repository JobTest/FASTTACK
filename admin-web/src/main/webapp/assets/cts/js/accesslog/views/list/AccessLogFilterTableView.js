(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
                'underscore',
                'common.backgrid.FilteredTableView',
                AppCommon.tplBaseUrl + "accesslog/filter_view_template",
                'common.backgrid.FilterView',
                'common.views.ViewWithInputs'
            ]
            , factory);

    } else {
        factory();
    }
})(
    function (_, FilteredTableView, filter_view_template, FilterView, ViewWithInputs) {

        var AccessLogFilterTableView = FilteredTableView.extend({

            template: filter_view_template,
            CollectionConstructor: Common.backbone.collection.QueryResultPageableCollection.extend({
                url: AppCommon.baseUrl + "accessLog/filter.json",
                state: { pageSize: 20, sortField: "accessDate", asc: true}
            }),
            filterName: "AccessLogListFilter",
            listColumns: [
                {
                    label: Common.bundles.getMessage("accessLog.user"),
                    name: "username",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    label: Common.bundles.getMessage("accessLog.accessDate"),
                    name: "accessDate",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    label: Common.bundles.getMessage("accessLog.accessType"),
                    name: "accessType",
                    cellTemplate: "{{=Common.bundles.getMessage('AccessType.' + model.accessType)}}",
                    sortable: true,
                    editable: false
                },
                {
                    name: "itemType",
                    label: Common.bundles.getMessage("accessLog.itemType"),
                    cellTemplate: "{{=Common.bundles.getMessage('ItemType.' + model.itemType)}}",
                    sortable: true,
                    editable: false
                },
                {
                    name: "itemId",
                    label: Common.bundles.getMessage("accessLog.itemId"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "field1",
                    label: "F1",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "field2",
                    label: "F2",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "field3",
                    label: "F3",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "field4",
                    label: "F4",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "field5",
                    label: "F5",
                    cell: "string",
                    sortable: true,
                    editable: false
                }
            ],

            FilterViewConstructor: FilterView.extend({
                initAfterRender: function () {
                    this.superInitAfterRender(ViewWithInputs);

                    var el = this.$el;

                    Common.ajax.sync({
                        url: "enum/accessTypes.json",
                        cache: true,
                        success: function (data) {
                            data.unshift({key: "", caption: Common.bundles.getMessage("select2.allChosen")});
                            Common.applySelect2(el.find("#accessType"), data);
                        }
                    });

                    Common.ajax.sync({
                        url: "enum/itemTypes.json",
                        success: function (data) {
                            data.unshift({key: "", caption: Common.bundles.getMessage("select2.allChosen")});
                            Common.applySelect2(el.find("#itemType"), data);
                        }
                    });
                    Common.applyDatePicker(this.$el.find(".inputNarrow"));
                }
            })
        });

        new AccessLogFilterTableView({});
    }
);
