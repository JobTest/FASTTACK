(function(factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.views.SimpleView', ['backbone'], factory);
    } else {
        factory();
    }
})(
    function(Backbone) {
        return Backbone.View.extend({
            addEvent: function(key, functionName) {
                // Such way of initializing events because of inheritance, each View has it's own events object
                this._getEvents()[key] = functionName;
            },
            deleteEvent: function(key) {
                delete this._getEvents()[key];
            },
            _getEvents: function() {
                if (!this.events) {
                    this.events = {};
                }
                return this.events;
            },
            invokeSuper: function(Super, method, args) {
                if (Super && Super.prototype[method]) {
                    Super.prototype[method].apply(this, args);
                }
            },
            superInitialize: function(Super, opts) {
                this.invokeSuper(Super, "initialize", [opts])
            },
            createHandle: function() {
                this.handle = _.extend({}, Backbone.Events);
                this.listenTo(this.handle, "all", this._doHandle);
            },
            _doHandle: function(event, opts) {
                // override this to listen all handling
            }
        });
    }
);
