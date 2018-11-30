(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'common.backgrid.GridView',
            'common.util.backbone',
            'common.util.messages',
            'backbone',
            'backgrid.paginator'
        ], factory);
    } else {
        factory();
    }
})(
    function (Grid, CommonBackbone, CommonMessages, Backbone) {
        var FePropPageableCollection = CommonBackbone.backbone.collection.QueryResultPageableCollection.extend({
            url: AppCommon.baseUrl + "feProp/filter.json"
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

        return Backbone.View.extend({
            initialize: function () {
                this.fePropCollection = new FePropPageableCollection();

                this.fePropGrid = new Grid({
                    className: "backgrid table-responsive",
                    columns: [
                        {
                            label: CommonMessages.bundles.getMessage("feProp.propName"),
                            name: "propName",
                            cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}feProp/view.htm?propName={{=model.propName}}'>{{=model.propName}}</a>")}),
                            sortable: true,
                            editable: false
                        },
                        {
                            label: CommonMessages.bundles.getMessage("feProp.propValue"),
                            name: "propValue",
                            cell: "string",
                            sortable: true,
                            editable: false
                        }
                    ],
                    collection: this.fePropCollection
                });

                this.fePropPaginator = new Backgrid.Extension.Paginator({
                    windowSize: 20,
                    slideScale: 0.25,
                    goBackFirstOnSort: false,
                    collection: this.fePropCollection
                });
                this.render();
            },
            render: function () {
                this.$el.empty();
                this.$el.append(this.fePropGrid.render().el);
                this.$el.append(this.fePropPaginator.render().el);
                this.fePropCollection.fetch({reset: true});
                return this;
            }
        });
    }
);
