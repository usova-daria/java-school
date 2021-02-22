$("a.remove-address").on('click', function (event) {
    event.preventDefault();
    var a = $(this)
    removeAddress(a.attr('href'), a);
    return false;
});

function removeAddress(href, a) {
    $.ajax({
        type: 'POST',
        url: href,
        dataType: 'json',
        statusCode: {
            400: function(response) {
                addressNotDeleted(response, a);
            },
            500: function (response) {
              addressNotDeleted(response, a);
            },
            200: function(response) {
                var $row = $(a).parents('.address-div');
                $row.remove();
            }
        }
    });
}

function addressNotDeleted(response, a) {
    changeElementStyle('element-error', (a).parents('tr'));
    var message = JSON.parse(response.responseText).message;

    $("#delete-fail-p").text(message);
    $("#delete-fail").prop('hidden', false);
}

$("#delete-fail").on("close.bs.alert", function (event) {
    event.preventDefault();
    $(this).prop('hidden', true);
})
