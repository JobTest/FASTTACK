(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'jquery',
            'common.views.SimpleViewWithModel',
            'common.views.InputAwareViewWithValidation',
            'common.views.modalPanel.SimpleModalPanelView',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "token/token_confirm_view_template",
            AppCommon.tplBaseUrl + "token/token_lifecycle_template",
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
    function ($, SimpleViewWithModel, InputAwareViewWithValidation, SimpleModalPanelView, Common, SecurityModels, tokenConfirmViewTemplate, tokenConfirmLifecycleTemplate, tokenUpdateTemplate, Grid, CommonAjax) {

        var TokensConfirm = new SecurityModels.TokensConfirm({
            tokens: Common.Url.parse().tokens
        });
        // Get list token info by TokenRefId and TokenRequestorId
        TokensConfirm.save(null, {type: 'POST', async: false});

        var TokenConfirmLifecycleInputsView = InputAwareViewWithValidation.extend({
            template: tokenConfirmLifecycleTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                this.model = TokensConfirm;
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                var tokens = this.model.toJSON().tokens;
                this.model = new SecurityModels.TokenConfirmLifecycle({
                    tokens: tokens.map(tokenLifecycleId),
                    tokenEventStatus: ''
                });
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            tokenLifecycle: function (data) {
                if (this.validateInputs()) {
                    this.model.attributes.tokenReason = data;
                    return this.model.save(null, {async: false});
                }
                return false;
            }
        });

        var TokenUpdateInputsView = InputAwareViewWithValidation.extend({
            template: tokenUpdateTemplate,
            tagName: "form",
            initBeforeRender: function (opts) {
                this.model = TokensConfirm;
                this.superInitBeforeRender(InputAwareViewWithValidation, opts);
                var tokens = this.model.toJSON().tokens;
                this.model = new SecurityModels.TokenConfirmUpdate({
                    tokens: tokens.map(tokenUpdateId)
                });
            },
            initAfterRender: function () {
                this.superInitAfterRender(InputAwareViewWithValidation);
            },
            tokenUpdate: function (data) {
                this.model.attributes.tokenReason = data;
                return this.model.save(null, {async: false});
            }
        });


        var TokenConfirmPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: tokenConfirmViewTemplate,
            initBeforeRender: function (opts) {
                this.model = TokensConfirm;
                this.tokenConfirmLifecycleInputsView = new TokenConfirmLifecycleInputsView();
                this.tokenLifecycleModalPanelView = {};


                this.tokenUpdateInputsView = new TokenUpdateInputsView();
                this.tokenUpdateModalPanelView = {};


                this.listenTo(this.tokenConfirmLifecycleInputsView, "btnTokenLifecycle", function (data) {
                    var tokens = this.model.toJSON().tokens;
                    this.model = new SecurityModels.TokenConfirmLifecycle({
                        tokens: tokens.map(tokenLifecycleId),
                        tokenEventStatus: ''
                    });

                    var noError = this.tokenConfirmLifecycleInputsView.tokenLifecycle(data.$el.find("#tokenReason")[0].value);
                    if (noError.responseJSON.code === '00' || noError.responseJSON.code == '0') {
                        window.location.replace(AppCommon.baseUrl + 'token/list.htm');
                    } else {
                        if (!noError.responseJSON.fieldRemarks) {
                            var responseMessage = noError.responseJSON.errorMessage ? Common.bundles.getMessage(noError.responseJSON.errorMessage) : noError.responseJSON.message;
                            Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.ips.message") + responseMessage);
                        }
                    }
                });

                this.listenTo(this.tokenUpdateInputsView, "btnTokenUpdate", function (data) {
                    var tokens = this.model.attributes.tokens;
                    this.model = new SecurityModels.TokenConfirmLifecycle({
                        tokens: tokens.map(tokenLifecycleId),
                        tokenEventStatus: ''
                    });

                    var errors = this.tokenUpdateInputsView.tokenUpdate(data.$el.find("#tokenReason")[0].value);
                    if (errors.responseJSON.codeStatus === '00') {
                        window.location.replace(AppCommon.baseUrl + 'token/list.htm');
                    } else {
                        if(!errors.responseJSON.fieldRemarks){
                            Common.ajax.validation.showErrorDescription(Common.bundles.getMessage("common.error.ips.message") + errors.responseJSON.message);
                        }
                    }
                });

                this.addEvent("click .btnConfirmToken", function () {
                    var event = Common.Url.parse().event;
                    if (event == 'updateToken') {
                        showModalUpdateToken(this.tokenUpdateInputsView);
                    } else {
                        this.tokenLifecycleModalPanelView = showModalLifecycle(this.tokenConfirmLifecycleInputsView, Common.bundles.getMessage("token.modal.panel." + event + ".title"), event.toUpperCase());
                    }
                });


                function showModalLifecycle(tokenConfirmLifecycleInputsView, title, tokenEventStatus){
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
                        bodyView: tokenConfirmLifecycleInputsView
                    });
                    var el = this.tokenLifecycleModalPanelView.$el;
                    Common.ajax.async("tokenReason/items.json?tokenEventStatus=" + tokenEventStatus,
                        function (data) {
                            Common.applySelect2(el.find("#tokenReason"), data);
                        }
                    );
                    this.tokenLifecycleModalPanelView.bodyView.model.attributes.tokenEventStatus = tokenEventStatus;
                    tokenConfirmLifecycleInputsView.clearInputs();
                    this.tokenLifecycleModalPanelView.show();
                    return this.tokenLifecycleModalPanelView;
                }

                function showModalUpdateToken(tokenUpdateInputsView){
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
                        bodyView: tokenUpdateInputsView
                    });
                    var el = this.tokenUpdateModalPanelView.$el;
                    Common.ajax.async("tokenReason/items.json?tokenEventStatus=UPDATE",
                        function (data) {
                            Common.applySelect2(el.find("#tokenReason"), data);
                        }
                    );
                    Common.applyDatePicker(el.find(".datepicker"), null, 'mmyy');
                    this.tokenUpdateModalPanelView.bodyView.model.attributes.tokenEventStatus = "UPDATE";
                    tokenUpdateInputsView.clearInputs();
                    this.tokenUpdateModalPanelView.show();
                }

                this.superInitBeforeRender(SimpleViewWithModel, opts);
            },
            render: function () {
                this.$el.html(this.template({
                    tokens: this.model.attributes.tokens,
                    event: Common.Url.parse().event,
                    backUrl: AppCommon.baseUrl + "token/list.htm"
                }));
                this.initAfterRender();
                this.delegateEvents();
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.$el.append(this.tokenLifecycleModalPanelView.el);
                this.$el.append(this.tokenUpdateModalPanelView.el);
                this.superInitAfterRender(SimpleViewWithModel);
            }
        });

        function tokenLifecycleId(obj) {
            return {
                tokenRefId: obj.tokenId ? obj.tokenId.tokenRefId: obj.tokenRefId,
                tokenRequestorId: obj.tokenId ? obj.tokenId.tokenRequestorId : obj.tokenRequestorId,
                panInternalId: obj.panInternalId,
                panInternalGuid: obj.panInternalGuid,
                ips: obj.ips
            }
        }

        function tokenUpdateId(obj) {
            return {
                tokenRefId: obj.tokenId ? obj.tokenId.tokenRefId : obj.tokenRefId,
                tokenRequestorId: obj.tokenId ? obj.tokenId.tokenRequestorId : obj.tokenRequestorId,
                panInternalId: obj.panInternalId,
                panInternalGuid: obj.panInternalGuid,
                ips: obj.ips
            }
        }


        new TokenConfirmPageView();
    }
);
