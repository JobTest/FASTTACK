/**
 * @author Anton Leliuk
 */
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'binSetup/filter_view_template',
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

        var BinSetupFilterTableView = FilteredTableView.extend({
            CollectionConstructor: Common.backbone.collection.QueryResultPageableCollection.extend({
                url: AppCommon.baseUrl + "bin/filter.json",
                state: {sortKey: "bin"}
            }),
            filterName: "BinListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    name: "bin",
                    label: CommonMessages.bundles.getMessage("bin.bin"),
                    cellTemplate: "<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=model.bin}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "sendAsv",
                    label: CommonMessages.bundles.getMessage("bin.sendAsv"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=Common.bundles.getMessage('common.text.' + model.sendAsv)}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    name: "sendCardTokenized",
                    label: CommonMessages.bundles.getMessage("bin.sendCardTokenized"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=Common.bundles.getMessage('common.text.' + model.sendCardTokenized)}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    name: "sendGetCustomerId",
                    label: CommonMessages.bundles.getMessage("bin.sendGetCustomerId"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=Common.bundles.getMessage('common.text.' + model.sendGetCustomerId)}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    name: "cvcAttempt",
                    label: CommonMessages.bundles.getMessage("bin.cvcAttempt"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=model.cvcAttempt}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    name: "prepaid",
                    label: CommonMessages.bundles.getMessage("bin.prepaid"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=Common.bundles.getMessage('common.text.' + model.prepaid)}}</a>")}),
                    sortable: true,
                    editable: false
                },
                {
                    name: "maxTokensPerCard",
                    label: CommonMessages.bundles.getMessage("bin.maxTokensPerCard"),
                    cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}bin/view.htm?bin={{=model.bin}}'>{{=model.maxTokensPerCard}}</a>")}),
                    sortable: true,
                    editable: false
                }
            ],
            initAfterRender:function(){
                this.superInitAfterRender(FilteredTableView);
                this.handle.trigger("backgrid:filter", this.filterView.model);
            }
        });

        new BinSetupFilterTableView();
    }
);