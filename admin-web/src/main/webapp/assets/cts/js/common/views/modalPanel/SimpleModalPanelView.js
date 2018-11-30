(function(factory) {
    if (typeof define === "function" && define.amd) {
        define([
            "common.views.SimpleView",
            AppCommon.tplBaseUrl + "modalPanel/simple_modal_panel_view_template"
        ], factory);
    } else {
        factory();
    }
})(
    /**
     * Simple modal panel view which contains title, body and buttons.
     * initialize opts:
     *      title: modal panel title,
     *      bodyView (required): for example ViewWithInputs,
     *      buttons: { id: 'triggered bodyView action', caption: 'button caption', class: 'button class' }.
     */
    function(SimpleView, simpleModalPanelViewTemplate) {

        return SimpleView.extend({
            className: "modal fade",
            attributes: {
                "tabindex": "-1",
                "role": "dialog",
                "aria-hidden": "true"
            },
            template: simpleModalPanelViewTemplate,
            initialize: function(opts) {
                this.initBeforeRender(opts);
                this.render();
            },
            initBeforeRender: function(opts) {
                this.title = opts.title;
                this.buttons = opts.buttons;
                this.bodyView = opts.bodyView;

                this.addEvent("click button[data-btn-id]", "_clickBtn");
                this.addEvent("click .closeModalPanel", "hide");

                this.listenTo(this.bodyView, "hide", this.hide);
            },
            render: function () {
                this.$el.html(this.template({
                    title: this.title,
                    buttons: this.buttons
                }));
                this.initAfterRender();
                this.delegateEvents();
                return this;
            },
            initAfterRender: function() {
                this.$bodyViewContainer = this.$el.find(".bodyViewContainer");
                this.$bodyViewContainer.html(this.bodyView.el);
            },
            show: function() {
                this.$el.modal("show");
                this.bodyView.trigger("showModalPanel", this);
            },
            hide: function() {
                this.$el.modal("hide");
                this.bodyView.trigger("hideModalPanel", this);
            },
            _clickBtn: function(e) {
                var btnId = jQuery(e.currentTarget).attr("data-btn-id");
                this.bodyView.trigger(btnId, this);
            },
            superInitBeforeRender: function(Super, opts) {
                this.invokeSuper(Super, "initBeforeRender", [opts])
            },
            superInitAfterRender: function(Super) {
                this.invokeSuper(Super, "initAfterRender")
            }
        });
    }
);
