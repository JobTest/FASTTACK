(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['feProp.views.list.FePropListView'], factory);
    } else {
        factory();
    }
})(
    function (FePropListView) {
        var FePropListPageView = Backbone.View.extend({
            el: "#main-container",
            initialize: function () {
                this.fePropListView = new FePropListView();
                this.render();
            },
            render: function () {
                this.$el.find("#tableContainer").html(
                    this.fePropListView.el
                );
            }
        });

        new FePropListPageView();
    }
);