(function (factory) {

    if (typeof define === 'function' && define.amd) {
        define(['underscore', 'backbone', 'backgrid', 'backgrid.paginator'], factory);
    }
    else {
        factory();
    }

})
(function () {
    var pageHandle = Backgrid.Extension.PageHandle.extend({

        render: function () {
            this.$el.empty();
            var anchor = document.createElement("a");
            anchor.href = '#';
            var hellip = document.createElement("span");
            if (this.title){
                if(this.title === "hellip" ){
                    hellip.innerHTML = this.label;
                    this.el.appendChild(hellip);
                }else {
                    anchor.title = this.title;
                    anchor.innerHTML = this.label;
                    this.el.appendChild(anchor);
                }
            }


            var collection = this.collection;
            var state = collection.state;
            var currentPage = state.currentPage;
            var pageIndex = this.pageIndex;

            if (this.isRewind && currentPage == state.firstPage ||
                this.isBack && !collection.hasPreviousPage() ||
                this.isForward && !collection.hasNextPage() ||
                this.isFastForward && (currentPage == state.lastPage || state.totalPages < 1)) {
                this.$el.addClass("disabled");
            }
            else if (!(this.isRewind ||
                this.isBack ||
                this.isForward ||
                this.isFastForward) &&
                state.currentPage == pageIndex) {
                this.$el.addClass("active");
            }

            this.delegateEvents();
            return this;
        }

    });
    /**
     * Extend Backgrid paginator. Pagination logic inserting hellip. When there are a sufficient number of pages, the full pager displays "..."
     * For quick navigation, use input field to allow an end user to enter page which  they wish to jump to manually.
     * This paging control uses a text input box to accept new paging numbers.
     * */
    return Backgrid.Extension.Paginator.extend({

        pageHandle : pageHandle,

        events: {
            "change .paginator-input": "inputChangePage",
            "change .paginator-inputPageSize": "inputPageSize"
        },

        maxPages: 10,
        /**
         *  Creates a list of page handle objects for rendering.
         *  @return {Array.<Object>} an array of page handle objects hashes
         * */
        makeHandles: function () {
            var handles = [];
            var collection = this.collection;

            var state = collection.state;

            // convert all indices to 0-based here
            var firstPage = state.firstPage - 1;
            var lastPage = +state.lastPage;
            var currentPage = collection.state.currentPage;
            var hellip = {
                label: "...",
                title: "hellip"
            };

            if (lastPage < this.maxPages){
                for (var i = firstPage; i < lastPage; i++) {
                    handles.push(new this.pageHandle({
                        collection: collection,
                        pageIndex: i
                    }));
                }
            }
            else if (currentPage - 2 <= 2) {
                for (var i = firstPage; i < currentPage + 1; i++) {
                    handles.push(new this.pageHandle({
                        collection: collection,
                        pageIndex: i
                    }));
                }
                handles.push(new this.pageHandle({
                    collection: collection,
                    title: hellip.title,
                    label: hellip.label
                }));


                handles.push(new this.pageHandle({
                    collection: collection,
                    pageIndex: lastPage - 1
                }));
            }

            else if (currentPage + 4 >= lastPage) {
                handles.push(new this.pageHandle({
                    collection: collection,
                    pageIndex: firstPage
                }));

                handles.push(new this.pageHandle({
                    collection: collection,
                    title: hellip.title,
                    label: hellip.label
                }));
                for (var i = currentPage - 2; i < lastPage; i++) {
                    handles.push(new this.pageHandle({
                        collection: collection,
                        pageIndex: i
                    }));
                }
            }

            else if (currentPage - 2 > 2 && currentPage + 4 < lastPage) {
                handles.push(new this.pageHandle({
                    collection: collection,
                    pageIndex: firstPage
                }));

                handles.push(new this.pageHandle({
                    collection: collection,
                    title: hellip.title,
                    label: hellip.label
                }));
                for (var i = currentPage - 2; i < currentPage + 2; i++) {
                    handles.push(new this.pageHandle({
                        collection: collection,
                        pageIndex: i
                    }));
                }
                handles.push(new this.pageHandle({
                    collection: collection,
                    title: hellip.title,
                    label: hellip.label
                }));


                handles.push(new this.pageHandle({
                    collection: collection,
                    pageIndex: lastPage - 1
                }));
            }

            var controls = this.controls;
            _.each(["back", "rewind", "forward", "fastForward"], function (key) {
                var value = controls[key];
                if (value) {
                    var handleCtorOpts = {
                        collection: collection,
                        title: value.title,
                        label: value.label
                    };
                    handleCtorOpts["is" + key.slice(0, 1).toUpperCase() + key.slice(1)] = true;
                    var handle = new this.pageHandle(handleCtorOpts);
                    if ((key == "rewind" || key == "back") && currentPage != firstPage + 1) {
                        handles.unshift(handle);
                    }
                    if ((key == "forward" || key == "fastForward") && currentPage != lastPage){
                        handles.push(handle)
                    };
                }
            }, this);

            return handles;
        },

        render: function () {
            this.$el.empty();

            if (this.collection.size() != 0 && this.collection.state.lastPage > 1) {
                if (this.handles) {
                    for (var i = 0, l = this.handles.length; i < l; i++) {
                        this.handles[i].remove();
                    }
                }

                var handles = this.handles = this.makeHandles();
                var ul = document.createElement("ul");

                for (var i = 0; i < handles.length; i++) {
                    ul.appendChild(handles[i].render().el);
                }
                this.el.appendChild(ul);

                if(this.collection.state.lastPage > this.maxPages) {
                    var input = document.createElement("input");
                    input.className = "paginator-input";
                    input.style.height = "25px";
                    input.style.width = "30px";
                    ul.appendChild(input);
                }

                var onPage = document.createElement("span");
                onPage.innerHTML = Common.bundles.getMessage("common.text.paginator.pageSize");
                onPage.style.margin = "20px";
                ul.appendChild(onPage);

                var inputPageSize = document.createElement("input");
                inputPageSize.className = "paginator-inputPageSize";
                inputPageSize.style.height = "25px";
                inputPageSize.style.width = "30px";
                ul.appendChild(inputPageSize);
            }

            this.delegateEvents();
            return this;
        },
        inputChangePage: function () {
            var col = this.collection;
            var inputValue = this.$el.find('.paginator-input').val();
            if(inputValue > 0 && inputValue <= col.state.lastPage) {
                col.getPage(parseInt(inputValue), {reset: true});
            }
        },
        inputPageSize: function (){
            this.collection.state.pageSize = parseInt(this.$el.find('.paginator-inputPageSize').val());
            this.collection.getPage(1, {reset: true});
        }
    });
});
