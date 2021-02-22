$( document ).ready(function() {
    if ( $('.not-available').length ) {
        $(".alert").prop('hidden', false);
    }
});

$(function () {
    $("[data-toggle='tooltip']").tooltip();
});


$("a.remove-from-cart").on('click', function (event) {
    event.preventDefault();
    var a = $(this)
    removeItemFromCart(a.attr('href'), a);
    return false;
});

function removeItemFromCart(href, a) {
    $.ajax({
        type: 'GET',
        url: href,
        dataType: 'json',
        statusCode: {
            400: function(response) {
                changeElementStyle('element-error', (a).parents('tr'));
            },
            200: function(response) {
                var $row = $(a).parents('tr');
                $row.remove();

                updateTotal(response.newTotal);
            }
        },
        error: function() {
            changeElementStyle('element-error', (a).parents('tr'));
        }
    });
}

$(".plus").on('focus',function () {
    $(this).blur();
})

$(".plus").on('click', function () {
    $(this).blur();
    document.getElementById("quantity-" + getId(this)).stepUp(1);
    changeNumberOfItems(this);
})

$(".minus").on('focus', function () {
    $(this).blur();
})

$(".minus").on('click', function () {
    $(this).blur();
    document.getElementById("quantity-" + getId(this)).stepDown(1);
    changeNumberOfItems(this);
})

$(".quantity").on('blur', function () {
    var max = $(this).prop('max')
    var value = $(this).val()
    $(this).val(Math.min(max, value))
    changeNumberOfItems(this);
})

function getId(element) {
    var row = $(element).closest('tr');
    return $(row).find('td')[0].innerText;
}

function changeNumberOfItems(element) {
    var x = document.getElementById("message");

    var row = $(element).closest('tr');
    var id = $(row).find('td')[0].innerText;
    var quantity = $(row).find('.quantity').val();

    changeNumberOfItemsInTheCart(id, quantity, x);
}

function changeNumberOfItemsInTheCart(productId, quantity, messageElement) {
    $.ajax({
        type : 'GET',
        url : "/vinyl-store/cart/update/" + productId + "/" + quantity,
        dataType: 'json',
        statusCode: {
            400: function(response) {
                var message = JSON.parse(response.responseText).message;
                $("#quantity" + productId).load(location.href + " #quantity" + productId)
                showMessage(messageElement, message);

                var total = JSON.parse(response.responseText).newTotal;
                if (total != null) {
                    updateTotal(total);
                }
            },
            200: function(response) {
                messageElement.innerText = response.message;
                updateTotal( response.newTotal );
            }
        },
        error : function() {
            var message = "The number of items has not been changed. " +
                "Please try again later!";
            $("#quantity" + productId).load(location.href + " #quantity" + productId);
            showMessage(messageElement, message);
        }
    });
}

function showMessage(messageElement, text) {
    messageElement.className = "show";
    messageElement.innerText = text;
    setTimeout(function(){ messageElement.className = messageElement.className.replace("show", ""); }, 3000);
}

function updateTotal(total) {
    if (total === 0) {
        $("#container").load(location.href + " #container");
    }

    $("#total").text("Total: " + total.toFixed(2));
}

$(".not-available").on('click', function (event) {
    var $row = $(this).parents('tr');
    $row.remove();

    if (document.getElementById("cart-table").rows.length === 1) {
        $("#container").load(location.href + " #container");
    }

    return false;
})