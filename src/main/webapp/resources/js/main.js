function changeRowStyle(cssClass, row) {
    row.addClass(cssClass);
    setTimeout(function () {
        row.removeClass(cssClass);
    }, 1000);
}