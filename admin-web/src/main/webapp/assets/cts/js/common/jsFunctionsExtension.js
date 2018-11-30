// Check that string is ends with
if (!String.prototype.endsWith) {
    String.prototype.endsWith = function (ends) {
        return this.length && ends.length && this.indexOf(ends, this.length - ends.length) !== -1;
    };
}