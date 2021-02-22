function changeElementStyle(cssClass, element) {
    element.addClass(cssClass);
    setTimeout(function () {
        element.removeClass(cssClass);
    }, 1000);
}

$(document).on('click', 'a.add-to-cart', function (event) {
    var a = $(this)
    addItemToCart($(this).attr('href'), a);
    return false;
} );

function addItemToCart(href, a) {
    $.ajax({
        type: 'GET',
        url: href,
        dataType: 'json',
        statusCode: {
            400: function(response) {
                changeElementStyle('element-error', a);
            },
            200: function(response) {
                changeElementStyle('element-success', a);
            }
        },
        error: function() {
            changeElementStyle('element-error', a);
        }
    });
}
