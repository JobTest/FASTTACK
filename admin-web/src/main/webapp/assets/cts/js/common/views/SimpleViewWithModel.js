(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.views.SimpleViewWithModel', [
            'common.views.SimpleView'
        ], factory);
    } else {
        factory();
    }
})(
    function(SimpleView) {

        return SimpleView.extend({
            initialize: function(opts) {
                if (this.initBeforeRender) {
                    this.initBeforeRender(opts);
                }
                this.render();
            },
            render: function () {
                if (this.template) {
                    this.$el.html(this.template(this.getRenderContext()));
                }
                if (this.initAfterRender) {
                    this.initAfterRender();
                }
                this.delegateEvents();
                return this;
            },
            getRenderContext: function() {
                return this.model.toJSON();
            },
            superInitBeforeRender: function(Super, opts) {
                this.invokeSuper(Super, "initBeforeRender", [opts])
            },
            superRender: function(Super, opts) {
                this.invokeSuper(Super, "render", [opts])
            },
            superInitAfterRender: function(Super, opts) {
                this.invokeSuper(Super, "initAfterRender", [opts])
            }
        });
    }
);
