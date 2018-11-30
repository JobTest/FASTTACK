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
        var RolePageableCollection = CommonBackbone.backbone.collection.QueryResultPageableCollection.extend({
            url: AppCommon.baseUrl + "role/filter.json"
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

        /**
         * View for loading and displaying table with roles.
         * */
        return Backbone.View.extend({
            initialize: function () {
                this.roleCollection = new RolePageableCollection();
                this.roleGrid = new Grid({
                    className: "backgrid table-responsive",
                    columns: [
                        {
                            label: CommonMessages.bundles.getMessage("roles.list.id.name"),
                            name: "id",
                            cell: TemplateCell.extend({template: _.template("<a href='{{=baseUrl}}role/view.htm?id={{=model.id}}'>{{=model.id}}</a>")}),
                            sortable: true,
                            editable: false
                        },
                        {
                            label: CommonMessages.bundles.getMessage("roles.list.description.name"),
                            name: "description",
                            cell: "string",
                            sortable: true,
                            editable: false
                        }
                    ],
                    collection: this.roleCollection
                });
                this.rolePaginator = new Backgrid.Extension.Paginator({
                    windowSize: 20,
                    slideScale: 0.25,
                    goBackFirstOnSort: false,
                    collection: this.roleCollection
                });
                this.render();
            },
            render: function () {
                this.$el.empty();
                this.$el.append(this.roleGrid.render().el);
                this.$el.append(this.rolePaginator.render().el);
                this.roleCollection.fetch({reset: true});
                return this;
            }
        });
    }
);
