(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define('common.util.filter', [ 'common.localStorage', 'common.util.url'], factory);
    } else {
        factory();
    }
})(
    function (Common) {

        Common.filter = {};

        Common.filter.getSavedFilter = function(filterName){
            if(filterName){
                var url = Common.Url.parse();
                var savedFilter = Common.webStorage.get(sessionStorage, filterName);
                if(url.filter && url.filter.clear){
                    var newUrl = Common.Url.getUrlWithoutQueryParams();
                    Common.webStorage.remove(sessionStorage, filterName);
                    history.replaceState(null, null, newUrl);
                    return null;
                }
                return savedFilter;
            }
            return null;
        };
        return Common;
    }
);
