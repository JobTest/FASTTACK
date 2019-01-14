/**
 * @author Anton Leliuk
 */
function getTokenRequestorId(tokenRequestorId, tokenRequestorTitle) {
    if (tokenRequestorTitle!=null) {
        return tokenRequestorTitle;
    } else {
        return tokenRequestorId;
    }
}

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'jquery',
            'common.backgrid.FilteredTableView',
            AppCommon.tplBaseUrl + 'token/filter_view_template',
            'common.util.messages',
            'common.util.ajax',
            'common.backgrid.FilterView',
            'common.views.ViewWithInputs',
            'backgrid.select-all'
        ], factory);
    } else {
        factory();
    }
})(
    function ($, FilteredTableView, filter_view_template, CommonMessages, Common, FilterView, ViewWithInputs) {

        var TokenFilterTableView = FilteredTableView.extend({
            CollectionConstructor: Common.backbone.collection.QueryResultPageableCollection.extend({
                url: AppCommon.baseUrl + "token/filter.json",
                state: {sortKey: "tokenEventDate"}
            }),
            filterName: "TokenListFilter",
            validateEmptyFilter: false,
            template: filter_view_template,
            listColumns: [
                {
                    name: "",
                    cell: "select-row",
                    headerCell: "select-all"
                },
                {
                    name: "",
                    label: "#",
                    cell: Backgrid.Cell.extend({
                        render: function () {
                            this.$el.html("<tr><td class='sortable renderable'><a href='" + AppCommon.baseUrl + "token/view.htm?tokenRefId=" + this.model.attributes.tokenId.tokenRefId + "&tokenRequestorId=" + this.model.attributes.tokenId.tokenRequestorId + "'>" + (this.model.collection.indexOf(this.model) + 1) + "</a></td></tr>");
                            return this;
                        }
                    }),
                    sortable: false
                },
                {
                    name: "customerId",
                    label:  "",
                    cellTemplate: "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.customerId}}</a></td></tr>" +
                    "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.customerPhone}}</a></td></tr>",
                    headerCell: Backgrid.HeaderCell.extend({
                        render: function () {
                            this.$el.html("<a>" + CommonMessages.bundles.getMessage("token.customerId.customerPhone") + "<b class='sort-caret'></b></a>");
                            this.delegateEvents();
                            return this;
                        }
                    }),
                    sortable: true,
                    editable: false
                },
                {
                    name: "maskedPan",
                    label: "",
                    cellTemplate: "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.maskedPan}}</a></td></tr>" +
                    "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.panInternalId}}</a></td></tr>" +
                    "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.maskedToken}}</a></td></tr>",
                    headerCell: Backgrid.HeaderCell.extend({
                        render: function () {
                            this.$el.html("<a>" + CommonMessages.bundles.getMessage("token.maskedPan.panInternalId.bin") + "<b class='sort-caret'></b></a>");
                            this.delegateEvents();
                            return this;
                        }
                    }),
                    sortable: true,
                    editable: false
                },
                {
                    name: "deviceName",
                    label: CommonMessages.bundles.getMessage("token.deviceName"),
                    cellTemplate: "<a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.deviceName}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "id.tokenRequestorId",
                    label: CommonMessages.bundles.getMessage("token.tokenRequestorId"),
                    cellTemplate: "<a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=getTokenRequestorId(model.tokenId.tokenRequestorId, model.tokenRequestorTitle)}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "panSource",
                    label: CommonMessages.bundles.getMessage("messageHistory.panSource"),
                    cellTemplate: "<a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=Common.bundles.getMessage('PanSource.' + model.panSource)}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "digitizeDate",
                    label: CommonMessages.bundles.getMessage("token.digitizeDate"),
                    cellTemplate: "<a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.digitizeDate}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "tokenExpdate",
                    label: CommonMessages.bundles.getMessage("token.expdate"),
                    cellTemplate: "<a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.tokenExpdate}}</a>",
                    sortable: true,
                    editable: false
                },
                {
                    name: "tokenStatus",
                    label: "",
                    cellTemplate: "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=Common.bundles.getMessage('TokenStatus.' + model.tokenStatus)}}</a></td></tr>" +
                    "<tr><td class='sortable renderable'><a href='{{=baseUrl}}token/view.htm?tokenRefId={{=model.tokenId.tokenRefId}}&tokenRequestorId={{=model.tokenId.tokenRequestorId}}'>{{=model.tokenStatusUpdate}}</a></td></tr>",
                    headerCell: Backgrid.HeaderCell.extend({
                        render: function () {
                            this.$el.html("<a>" + CommonMessages.bundles.getMessage("token.tokenStatus.tokenEventDate") + "<b class='sort-caret'></b></a>");
                            this.delegateEvents();
                            return this;
                        }
                    }),
                    sortable: true,
                    editable: false
                }
            ],

            FilterViewConstructor: FilterView.extend({
                addEvents: function () {
                    this.addEvent("click .btnActiveToken", function (opt) {
                        confirmEvent("activate", this.model);
                    });
                    this.addEvent("click .btnSuspendToken", function (opt) {
                        confirmEvent("suspend", this.model);
                    });

                    this.addEvent("click .btnResumeToken", function (opt) {
                        confirmEvent("resume", this.model);
                    });
                    this.addEvent("click .btnDeleteToken", function (opt) {
                        confirmEvent("delete", this.model);
                    });

                    this.addEvent("click .updateToken", function () {
                        confirmEvent("updateToken", this.model);
                    });

                    function confirmEvent(event, model) {
                        var selectedTokens = tokenFilterTableView.listView.listGrid.getSelectedModels();
                        if (selectedTokens.length > 0) {
                            if (selectedTokens.length > 1) {
                                var panInternalId = selectedTokens[0].attributes.panInternalId;
                                var panInternalGuid = selectedTokens[0].attributes.panInternalGuid;

                                if (selectedTokens.find(function (elem) {
                                        return elem.attributes.panInternalId != panInternalId
                                            || elem.attributes.panInternalGuid != panInternalGuid;
                                    })) {
                                    Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.same.pan.message"));
                                } else {
                                    window.location.replace(AppCommon.baseUrl + 'token/confirm_view.htm?' + Common.Url.urlBuilder(selectedTokens.map(function(item){return item.attributes.tokenId}), "tokens") + "&event=" + event);
                                }
                            } else {
                                window.location.replace(AppCommon.baseUrl + 'token/confirm_view.htm?' + Common.Url.urlBuilder(selectedTokens.map(function(item){return item.attributes.tokenId}), "tokens") + "&event=" + event);
                            }
                        } else {
                            Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.confirm.message"));
                        }
                    }
                },
                initAfterRender: function () {
                    this.superInitAfterRender(ViewWithInputs);
                    var el = this.$el;
                    Common.ajax.sync({
                        url: "enum/tokenStatusList.json",
                        cache: true,
                        success: function(data){
                            Common.applySelect2(el.find("#statuses"), data);
                        }
                    });

                }
            })
        });

        var tokenFilterTableView = new TokenFilterTableView();
    }
);