(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'messageHistory/filter_view_template',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (FilteredTableView, filter_view_template, CommonMessages) {

        var MessageHistoryFilterTableView = FilteredTableView.extend({
            collectionUrl: "messageHistory/filter.json",
            filterName: "MessageHistoryListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    name: "id",
                    label: CommonMessages.bundles.getMessage("messageHistory.id"),
                    cellTemplate: "<a href='{{=baseUrl}}messageHistory/view.htm?id={{=model.id}}'>{{=model.id}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "connectorClient",
                    label: CommonMessages.bundles.getMessage("messageHistory.connectorClient"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "msgType",
                    label: CommonMessages.bundles.getMessage("messageHistory.msgType"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "msgDateOut",
                    label: CommonMessages.bundles.getMessage("messageHistory.msgDateOut"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "msgDateIn",
                    label: CommonMessages.bundles.getMessage("messageHistory.msgDateIn"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "decision",
                    label: CommonMessages.bundles.getMessage("messageHistory.decision"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "errorCode",
                    label: CommonMessages.bundles.getMessage("messageHistory.errorCode"),
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

        new MessageHistoryFilterTableView();
    }
);
