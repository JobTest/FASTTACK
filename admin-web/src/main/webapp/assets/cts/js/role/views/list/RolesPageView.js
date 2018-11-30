(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['role.views.list.RoleListView'], factory);
    } else {
        factory();
    }
})(
    function (RoleListView) {
        var RolePageView = Backbone.View.extend({
            el: "#main-container",
            initialize: function () {
                this.roleListView = new RoleListView();
                this.render();
            },
            render: function () {
                this.$el.find("#tableContainer").html(
                    this.roleListView.el
                );
            }
        });

        new RolePageView();
    }
);
