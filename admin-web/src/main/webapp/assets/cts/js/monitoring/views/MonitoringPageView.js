(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.views.SimpleViewWithModel',
            'common.backgrid.GridView',
            'common.util.backbone',
            'security.model',
            AppCommon.tplBaseUrl + "monitoring/monitoring_template",
            'select2',
            'backbone',
            'common.util.ajax',
            'common.util.url',
            'common.util.acls',
            'common.util.date',
            'underscore'
        ], factory);
    } else {
        factory();
    }
})(
    function (SimpleViewWithModel, Grid, Common, SecurityModels, monitoringTemplate) {
        var MonitoringPageView = SimpleViewWithModel.extend({
            template: monitoringTemplate,
            initBeforeRender: function (opts) {
                this.model.fetch({async: false});
                this.superInitBeforeRender(SimpleViewWithModel, opts);
            },
            render: function () {
                this.superRender(SimpleViewWithModel);
                this.$el.find("#mainPanel").addClass(this.model.divClass);
                return this;
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

        var HealthPageView = SimpleViewWithModel.extend({
            el: "#main-container",
            template: monitoringTemplate,
            initBeforeRender: function (opts) {
                this.model = new SecurityModels.Health();
                this.model.fetch({async: false});
                this.superInitBeforeRender(SimpleViewWithModel, opts);
            },
            render: function () {
                this.$el.html(this.template({
                    modules: this.model.attributes.objects
                }));
                this.initAfterRender();
                this.delegateEvents();
            },
            initAfterRender: function () {
                this.delegateEvents();
                this.superInitAfterRender(SimpleViewWithModel);
            }
        });

        new HealthPageView();
    }
);