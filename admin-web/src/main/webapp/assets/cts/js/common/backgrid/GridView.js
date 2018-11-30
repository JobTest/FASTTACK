(function (factory) {

    if (typeof define === 'function' && define.amd) {
        define(['underscore', 'backbone', 'backgrid', 'common.util.messages'], factory);
    }
    else {
        factory();
    }

})
(function (_, Backbone, Backgrid, Common) {

    var _emptyRow = Backgrid.EmptyRow.extend({
        render: function () {
            this.$el.empty();

            this.el.className = "empty emptyRow";
            for(var i = 0; i < this.columns.length; i++){
                var cell = this.el.insertCell(i);
                if(i == 0){
                    cell.innerHTML = _.result(this, "emptyText");
                }
            }
            return this;
        }
    });

    var _body = Backgrid.Body.extend({
        _unshiftEmptyRowMayBe: function () {
            if (this.rows.length === 0 && this.emptyText != null) {
                this.rows.unshift(new _emptyRow({
                    emptyText: this.emptyText,
                    columns: this.columns
                }));
            }
        }
    });
    return Backgrid.Grid.extend({
        initialize: function(options){
            options.body = _body;
            options.emptyText = Common.bundles.getMessage("common.list.empty");
            Backgrid.Grid.prototype.initialize.call(this, options);
        },

        render: function () {
            this.$el.empty();

            this.listenTo(this.collection, "sync", function () {
//                if (this.collection.size() != 0) {
                    if (this.header) {
                        this.$el.append(this.header.render().$el);
                    }

                    if (this.footer) {
                        this.$el.append(this.footer.render().$el);
                    }

                    this.$el.append(this.body.render().$el);

                    this.delegateEvents();

                    // fix for save direction on UI after back from view page to list
                    if (arguments && arguments[1] && arguments[1].sortField && arguments[1].asc) {
                        var column = this.columns.findWhere({ name: arguments[1].sortField});
                        if (column) {
                            column.set("direction", arguments[1].asc ? "ascending" : "descending");
                        }
                    }

                    this.trigger("backgrid:rendered", this);
//                }
            });
            // {@link https://github.com/wyuenho/backgrid/issues/453}
            this.listenTo( this.collection, "backgrid:sort", function (sort) {
                sort.collection.chain()
                    .filter( function ( model ) {
                        return model.cid !== sort.cid;
                    })
                    .each( function ( model ) {
                        model.set( "direction", null );
                    });

            } );
            return this;
        }
    });
});

