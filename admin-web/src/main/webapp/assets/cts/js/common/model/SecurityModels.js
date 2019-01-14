(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('security.model', ['backbone.deep-model'], factory);
    } else {
        factory();
    }
})(
    function () {
        var SecurityModels = {};

        SecurityModels.User = Backbone.Model.extend({
            url: AppCommon.baseUrl + "user/item.json",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.Profile = Backbone.Model.extend({
            url: AppCommon.baseUrl + "profile/item.json"
        });

        SecurityModels.ChangeUserPassword = Backbone.Model.extend({
            url: AppCommon.baseUrl + "user/changePassword.json"
        });

        SecurityModels.Role = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "role/item.json",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.EncKey = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "enckey/item.json",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.FeProp = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "feProp/item.json",
            idAttribute: "propName",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?propName=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.CardProduct = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "cardProduct/item.json",
            idAttribute: "id",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.BinSetup = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "bin/item.json",
            idAttribute: "bin",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?bin=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.Token = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/item.json",
            sync: function(method, model, options) {
                if (model.attributes.tokenRefId != undefined && model.attributes.tokenRequestorId != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?tokenRefId=" + model.attributes.tokenRefId + "&tokenRequestorId=" + model.attributes.tokenRequestorId;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.TokenLifecycle = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/lifecycle.json"
        });

        SecurityModels.TokensConfirm = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/confirmList.json"
        });

        SecurityModels.TokenConfirmLifecycle = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/confirmLifecycle.json"
        });

        SecurityModels.TokenComment = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/comment"
        });

        SecurityModels.TokenConfirmComment = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/comment/confirmList"
        });

        SecurityModels.TokenUpdate = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/update.json"
        });

        SecurityModels.TokenConfirmUpdate = Backbone.Model.extend({
            url: AppCommon.baseUrl + "token/confirmUpdate.json"
        });


        SecurityModels.Card = Backbone.Model.extend({
            url: AppCommon.baseUrl + "card/item.json",
            sync: function(method, model, options) {
                if (model.attributes.tokenRefId != undefined && model.attributes.tokenRequestorId != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?tokenRefId=" + model.attributes.tokenRefId + "&tokenRequestorId=" + model.attributes.tokenRequestorId;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });


        SecurityModels.MessageHistory = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "messageHistory/item.json",
            sync: function(method, model, options) {
                if (model.id != undefined && 'read' === method.toLowerCase()) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.SystemConfig = Backbone.DeepModel.extend({
            url: AppCommon.baseUrl + "syscfg/item.json",
            sync: function(method, model, options) {
                if (model.id != undefined && ['read', 'delete'].indexOf(method.toLowerCase()) != -1) {
                    options.url = this.url + "?id=" + model.id;
                }
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.AlertLogStatistic = Backbone.DeepModel.extend({
            imageClass : "fa fa-key fa-5x",
            divClass : "panel panel-yellow",
            url: AppCommon.baseUrl + "alertLogStatistic.json",
            sync: function(method, model, options) {
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.ChangeLogStatistic = Backbone.DeepModel.extend({
            imageClass : "fa fa-pencil-square-o fa-5x",
            divClass : "panel panel-red",
            url: AppCommon.baseUrl + "changeLogStatistic.json",
            sync: function(method, model, options) {
                return Backbone.sync.apply(this, arguments);
            }
        });

        SecurityModels.Health = Backbone.Model.extend({
            url: AppCommon.baseUrl + "systemStatus"
        });

        return SecurityModels;
    }
);
