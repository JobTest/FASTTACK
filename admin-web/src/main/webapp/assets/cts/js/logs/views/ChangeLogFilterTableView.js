(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
                'common.util.backbone',
                'underscore',
                'common.backgrid.FilteredTableView',
                AppCommon.tplBaseUrl + "changelog/filter_view_template",
                'common.backgrid.FilterView',
                'common.views.ViewWithInputs'
            ]
            , factory);

    } else {
        factory();
    }
})(
    function (Common, _, FilteredTableView, filter_view_template, FilterView, ViewWithInputs) {

        var ChangeLogFilterTableView = FilteredTableView.extend({
            collectionUrl: "changeLog/filter.json",
            template: filter_view_template,
            filterName: "ChangeLogListFilter",
            listColumns: [
                {
                    name: "action",
                    label: Common.bundles.getMessage("changeLog.action"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "itemType",
                    label: Common.bundles.getMessage("changeLog.itemType"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "itemId",
                    label: Common.bundles.getMessage("changeLog.itemId"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "severity",
                    label: Common.bundles.getMessage("changeLog.severity"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "time",
                    label: Common.bundles.getMessage("changeLog.time"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "originator",
                    label: Common.bundles.getMessage("changeLog.originator"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "bankId",
                    label: Common.bundles.getMessage("changeLog.bankId"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "message",
                    label: Common.bundles.getMessage("changeLog.message"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "f1",
                    label: "F1",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "f2",
                    label: "F2",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "f3",
                    label: "F3",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "f4",
                    label: "F4",
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "f5",
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
                        url: "enum/itemTypes.json",
                        cache: true,
                        success: function(data){
                            data.unshift({key: "", caption: Common.bundles.getMessage("select2.allChosen")});
                            Common.applySelect2(el.find("#itemType"), data);
                            placeholderOption: 'first'
                        }}
                    );
                    Common.applyDatePicker(this.$el.find(".inputNarrow"));
                }
            })
        });

        new ChangeLogFilterTableView();
    }
);
