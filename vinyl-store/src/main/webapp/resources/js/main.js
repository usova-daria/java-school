function changeElementStyle(cssClass, element) {
    element.addClass(cssClass);
    setTimeout(function () {
        element.removeClass(cssClass);
    }, 1000);
}

$("a.add-to-cart").on('click', function(event) {
    var a = $(this)
    addItemToCart($(this).attr('href'), a);
    return false;
});

function addItemToCart(href, a)  {
    $.ajax({
        type : 'GET',
        url : href,
        success : function() {
            changeElementStyle('element-success', a);
        },
        error : function() {
            changeElementStyle('element-error', a);
        }
    });
}
