(function (factory) {

    if (typeof define === 'function' && define.amd) {
        define(['backgrid'], factory);
    }
    else {
        factory();
    }

})
(function () {

    return Backgrid.Cell.extend({
        render: function () {
            if(!this.template) {
                throw new Error("Empty field: 'template' in " + this.constructor.name);
            }
            this.$el.html(this.template({
                baseUrl: AppCommon.baseUrl,
                model: this.model.toJSON()
            }));
            this.delegateEvents();
            return this;
        }
    });

});