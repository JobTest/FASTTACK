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
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.views.modalPanel.SimpleModalPanelView',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "token/token_view_template",
            AppCommon.tplBaseUrl + "token/token_lifecycle_template",
            AppCommon.tplBaseUrl + "token/token_comment_template",
            AppCommon.tplBaseUrl + "token/token_update_template",
            'common.backgrid.GridView',
            'common.util.ajax',
            'common.util.url',
            'common.util.messages',
            'common.util.acls',
            'common.util.date',
            'parsley',
            'backbone',
            'backbone.deep-model',
            'backgrid.paginator',
            'select2'
        ], factory);
    } else {
        factory();
    }
})(
    function ($, SimpleViewWithModel, InputAwareViewWithValidation, SimpleModalPanelView, Common, SecurityModels, tokenViewTemplate, tokenLifecycleTemplate, tokenCommentTemplate, tokenUpdateTemplate, Grid, CommonAjax) {

        var tokenId = Common.Url.parse();

        var TokenLifecycleInputsView = InputAwareViewWithValidation.extend({
            template: tokenLifecycleTemplate,
            tagName: "form",
            getRenderContext: function () {
                return {
                    tokenizationPath: "",
                    pan: ""
                }
            },
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.TokenLifecycle({
                    tokenRefId: Common.Url.parse().tokenRefId,
                    tokenRequestorId: Common.Url.parse().tokenRequestorId,
                    tokenEventStatus: ''
                });
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            tokenLifecycle: function (data, ips) {
                if (this.validateInputs()) {
                    this.model.attributes.tokenReason = data;
                    this.model.attributes.ips = ips;
                    return this.model.save(null, {async: false});
                }
                return false;
            }
        });

        var TokenCommentInputsView = InputAwareViewWithValidation.extend({
            template: tokenCommentTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.TokenComment({
                    tokenRefId: Common.Url.parse().tokenRefId,
                    tokenRequestorId: Common.Url.parse().tokenRequestorId
                });
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            tokenComment: function () {
                return this.model.save(null, {async: false});
            }
        });

        var TokenUpdateInputsView = InputAwareViewWithValidation.extend({
            template: tokenUpdateTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                var tokenId = Common.Url.parse();
                this.model = new SecurityModels.TokenUpdate({
                    tokenRefId: tokenId.tokenRefId,
                    tokenRequestorId: tokenId.tokenRequestorId
                });
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            tokenUpdate: function (data) {
                this.model.attributes.tokenReason = data;
                return this.model.save(null, {async: false});
            }

        });

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

        var TokenPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: tokenViewTemplate,
            getRenderContext: function () {
                return {
                    backUrl: AppCommon.baseUrl + "token/list.htm",
                    dto: this.model.toJSON(),
                    tokenStatus: this.model.attributes.tokenStatus
                }
            },
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Token({
                    tokenRefId: Common.Url.parse().tokenRefId,
                    tokenRequestorId: Common.Url.parse().tokenRequestorId
                });
                this.model.fetch({async: false});

                this.tokenLifecycleInputsView = new TokenLifecycleInputsView();
                this.tokenLifecycleModalPanelView = {};

                this.tokenCommentInputsView = new TokenCommentInputsView();
                this.tokenCommentModalPanelView = {};

                this.tokenUpdateInputsView = new TokenUpdateInputsView();
                this.tokenUpdateModalPanelView = {};

                this.superInitBeforeRender(SimpleViewWithModel, opts);

                var TokenHistoryPageableCollection = Common.backbone.collection.QueryResultPageableCollection.extend({
                    url: AppCommon.baseUrl + "token/history/"+ this.model.attributes.tokenRefId +"/" + this.model.attributes.tokenRequestorId + "/filter.json"
                });

                var TokenCommentPageableCollection = Common.backbone.collection.QueryResultPageableCollection.extend({
                   url: AppCommon.baseUrl + "token/comment/" + this.model.attributes.tokenRefId +"/" + this.model.attributes.tokenRequestorId + "/filter.json"
                });

                this.dcCollection = new TokenHistoryPageableCollection();
                this.dcGrid = new Grid({
                    className: "backgrid table-bordered",
                    columns: [
                        {
                            name: "tokenEventDate",
                            label: Common.bundles.getMessage("token.tokenEventDate"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "tokenEventSource",
                            label: Common.bundles.getMessage("token.tokenEventSource"),
                            cell: TemplateCell.extend({template: _.template("{{=Common.bundles.getMessage('TokenEventSource.' + model.tokenEventSource)}}")}),
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "tokenEventType",
                            label: Common.bundles.getMessage("token.tokenEventType"),
                            cell: TemplateCell.extend({template: _.template("{{=Common.bundles.getMessage('TokenEventType.' + model.tokenEventType)}}")}),
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "tokenStatus",
                            label: Common.bundles.getMessage("token.status"),
                            cell: TemplateCell.extend({template: _.template("{{=Common.bundles.getMessage('TokenStatus.' + model.tokenStatus)}}")}),
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "tokenExpdate",
                            label: Common.bundles.getMessage("token.tokenExpdate"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "comment",
                            label: Common.bundles.getMessage("token.comment"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        }
                    ],
                    collection: this.dcCollection,
                    alignContent: "left"
                });
                this.dcPaginator = new Backgrid.Extension.Paginator({
                    windowSize: 20,
                    slideScale: 0.25,
                    goBackFirstOnSort: false,
                    collection: this.dcCollection
                });

                this.commentCollection = new TokenCommentPageableCollection();
                this.commentGrid = new Grid({
                    className: "backgrid table-bordered",
                    columns: [
                        {
                            name: "eventRef",
                            label: Common.bundles.getMessage("token.comment.eventRef"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "comData",
                            label: Common.bundles.getMessage("token.comment.comData"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "comment",
                            label: Common.bundles.getMessage("token.comment"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        },
                        {
                            name: "usrname",
                            label: Common.bundles.getMessage("token.comment.usrname"),
                            cell: "string",
                            sortable: true,
                            editable: false
                        }
                    ],
                    collection: this.commentCollection,
                    alignContent: "left"
                });

                this.commentPaginator = new Backgrid.Extension.Paginator({
                    windowSize: 20,
                    slideScale: 0.25,
                    goBackFirstOnSort: false,
                    collection: this.commentCollection
                });

                this.listenTo(this.tokenLifecycleInputsView, "btnTokenLifecycle", function (data) {
                    var noError = this.tokenLifecycleInputsView.tokenLifecycle(data.$el.find("#tokenReason")[0].value, this.model.attributes.ips);
                    if (noError.responseJSON.codeStatus === '00') {
                        this.tokenLifecycleModalPanelView.hide();
                        location.reload();
                    } else {
                        if (!noError.responseJSON.fieldRemarks) {
                            if (noError.responseJSON.errorCode === 'VSE40002') {
                                Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.warning.ips.message") + noError.responseJSON.message);
                            } else {
                                Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.ips.message") + noError.responseJSON.message);
                            }
                        }
                    }
                });

                this.listenTo(this.tokenCommentInputsView, "btnTokenComment", function (data) {
                    var errors = this.tokenCommentInputsView.tokenComment();
                    if (errors.status == '200') {
                        location.reload();
                    }
                });

                this.listenTo(this.tokenUpdateInputsView, "btnTokenUpdate", function (data) {
                    var errors = this.tokenUpdateInputsView.tokenUpdate(data.$el.find("#tokenReason")[0].value);
                    if (errors.responseJSON.codeStatus === '00') {
                        this.tokenUpdateModalPanelView.hide();
                        location.reload();
                    } else {
                        if(!errors.responseJSON.fieldRemarks) {
                            Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.ips.message") + errors.responseJSON.message);
                        }
                    }
                });


                this.addEvent("click .btnActiveToken", function () {
                    this.tokenLifecycleModalPanelView = showModal(this.tokenLifecycleInputsView, Common.bundles.getMessage("token.modal.panel.activate.title"), "ACTIVATE");
                });
                this.addEvent("click .btnSuspendToken", function () {
                    this.tokenLifecycleModalPanelView = showModal(this.tokenLifecycleInputsView, Common.bundles.getMessage("token.modal.panel.suspend.title"), "SUSPEND");
                });
                this.addEvent("click .btnResumeToken", function () {
                    this.tokenLifecycleModalPanelView = showModal(this.tokenLifecycleInputsView, Common.bundles.getMessage("token.modal.panel.resume.title"), "RESUME");
                });
                this.addEvent("click .btnDeleteToken", function () {
                    this.tokenLifecycleModalPanelView = showModal(this.tokenLifecycleInputsView, Common.bundles.getMessage("token.modal.panel.delete.title"), "DELETE");
                });

                function showModal(tokenLifecycleInputsView, title, tokenEventStatus){
                    Common.ajax.validation.clearRemarks();
                    this.tokenLifecycleModalPanelView = new SimpleModalPanelView({
                        title: title,
                        buttons: [
                            {
                                buttonId: "cancel",
                                buttonCaption: Common.bundles.getMessage("common.cancel"),
                                buttonClass: "btn-default closeModalPanel"
                            },
                            {
                                buttonId: "btnTokenLifecycle",
                                buttonCaption: Common.bundles.getMessage("common.apply"),
                                buttonClass: "btn-primary btnTokenLifecycle"
                            }
                        ],
                        bodyView: tokenLifecycleInputsView
                    });
                    var el = this.tokenLifecycleModalPanelView.$el;
                    Common.ajax.async("tokenReason/items.json?tokenEventStatus=" + tokenEventStatus,
                        function (data) {
                            Common.applySelect2(el.find("#tokenReason"), data);
                        }
                    );
                    Common.ajax.async("token/item.json?tokenRefId=" + tokenId.tokenRefId + "&tokenRequestorId=" + tokenId.tokenRequestorId,
                        function (data) {
                            el.find("#pan").val(data.pan);
                            if (data.ips=="V") {
                                el.find("#pan").attr("readonly", "readonly");
                            }

                            el.find("#tokenizationPath").val(data.tokenizationPath);

                            if (data.tokenizationPath=='GREEN') {
                                el.find("#tokenizationPathColor").css("border", "1px solid green");
                                el.find("#tokenizationPathColor").css("background-color", "green");
                            } else if (data.tokenizationPath=='RED') {
                                el.find("#tokenizationPathColor").css("border", "1px solid red");
                                el.find("#tokenizationPathColor").css("background-color", "red");
                            } else if (data.tokenizationPath=='YELLOW') {
                                el.find("#tokenizationPathColor").css("border", "1px solid yellow");
                                el.find("#tokenizationPathColor").css("background-color", "yellow");
                            } else if (data.tokenizationPath=='ORANGE') {
                                el.find("#tokenizationPathColor").css("border", "1px solid orange");
                                el.find("#tokenizationPathColor").css("background-color", "orange");
                            } else {
                            }
                        }
                    );
                    this.tokenLifecycleModalPanelView.bodyView.model.attributes.tokenEventStatus = tokenEventStatus;
                    tokenLifecycleInputsView.clearInputs();
                    this.tokenLifecycleModalPanelView.show();
                    return this.tokenLifecycleModalPanelView;
                }

                this.addEvent("click .addComment", function () {
                    Common.ajax.validation.clearRemarks();
                    this.tokenCommentModalPanelView = new SimpleModalPanelView({
                        title: Common.bundles.getMessage("token.addComment"),
                        buttons: [
                            {
                                buttonId: "cancel",
                                buttonCaption: Common.bundles.getMessage("common.cancel"),
                                buttonClass: "btn-default closeModalPanel"
                            },
                            {
                                buttonId: "btnTokenComment",
                                buttonCaption: Common.bundles.getMessage("common.apply"),
                                buttonClass: "btn-primary btnTokenComment"
                            }
                        ],
                        bodyView: this.tokenCommentInputsView
                    });
                    this.tokenCommentInputsView.clearInputs();
                    this.tokenCommentModalPanelView.show();
                });

                this.addEvent("click .updateToken", function () {
                    Common.ajax.validation.clearRemarks();
                    this.tokenUpdateModalPanelView = new SimpleModalPanelView({
                        title: Common.bundles.getMessage("token.modal.panel.update.title"),
                        buttons: [
                            {
                                buttonId: "cancel",
                                buttonCaption: Common.bundles.getMessage("common.cancel"),
                                buttonClass: "btn-default closeModalPanel"
                            },
                            {
                                buttonId: "btnTokenUpdate",
                                buttonCaption: Common.bundles.getMessage("common.apply"),
                                buttonClass: "btn-primary btnTokenUpdate"
                            }
                        ],
                        bodyView: this.tokenUpdateInputsView
                    });
                    var el = this.tokenUpdateModalPanelView.$el;
                    Common.ajax.async("tokenReason/items.json?tokenEventStatus=UPDATE",
                        function (data) {
                            Common.applySelect2(el.find("#tokenReason"), data);
                        }
                    );
                    Common.applyDatePicker(el.find(".datepicker"), null, 'mm/yy', 'months');

                    this.tokenUpdateModalPanelView.bodyView.model.attributes.tokenEventStatus = "UPDATE";
                    this.tokenUpdateModalPanelView.bodyView.model.attributes.ips = this.model.attributes.ips;
                    this.tokenUpdateInputsView.clearInputs();
                    this.tokenUpdateModalPanelView.show();
                });

            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                this.$el.append("<H3>" + Common.bundles.getMessage("token.history") + "<H3/>");
                this.$el.append(this.dcGrid.render().sort("tokenEventDate", "descending").el);
                this.$el.append(this.dcPaginator.render().el);

                //this.$el.append("<H3>" + Common.bundles.getMessage("token.comments") + "<H3/>");
                //this.$el.append(this.commentGrid.render().sort("comData", "descending").el);
                //this.$el.append(this.commentPaginator.render().el);

                this.dcCollection.fetch({reset: true});
                //this.commentCollection.fetch({reset: true});

                return this;
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.$el.append(this.tokenLifecycleModalPanelView.el);
                this.$el.append(this.tokenCommentModalPanelView.el);
                this.$el.append(this.tokenUpdateModalPanelView.el);
                this.superInitAfterRender(SimpleViewWithModel);
            }
        });

        new TokenPageView();
    }
);
