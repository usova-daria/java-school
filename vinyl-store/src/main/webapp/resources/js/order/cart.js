$("a.remove-from-cart").on('click', function (event) {
    var a = $(this)
    removeItemFromCart(a.attr('href'), a);
    return false;
});

function removeItemFromCart(href, a) {
    $.ajax({
        type: 'GET',
        url: href,
        success: function(total) {
            var $row = $(a).parents('tr');
            $row.remove();

            if (total === 0) {
                $("#container").load(location.href + " #container")
            }

            $("#total").text("Total: " + total.toFixed(2));

        },
        error: function() {
            changeElementStyle('element-error', (a).parents('tr'));
        }
    });
}