(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'user/filter_view_template',
            'common.util.messages'
        ], factory);
    } else {
        factory();
    }
})(
    function (FilteredTableView, filter_view_template, CommonMessages) {

        var UserFilterTableView = FilteredTableView.extend({
            collectionUrl: "user/filter.json",
            filterName: "UserListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    name: "username",
                    label: CommonMessages.bundles.getMessage("common.username"),
                    cellTemplate: "<a href='{{=baseUrl}}user/view.htm?id={{=model.id}}'>{{=model.id}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "name",
                    label: CommonMessages.bundles.getMessage("common.name"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "phone",
                    label: CommonMessages.bundles.getMessage("common.phone"),
                    cell: "string",
                    sortable: true,
                    editable: false
                },
                {
                    name: "statusCaption",
                    label: CommonMessages.bundles.getMessage("common.status"),
                    cellTemplate: "{{=Common.bundles.getMessage('UserStatus.' + model.status)}}",
                    sortable: false,
                    editable: false
                }
            ],
            initAfterRender: function () {
                this.superInitAfterRender(FilteredTableView);
                this.handle.trigger("backgrid:filter", this.filterView.model);
            }
        });

        new UserFilterTableView();
    }
);
