$(".plus").on('focus', function () {
    $(this).blur();
})

$(".plus").on('click', function () {
    $(this).blur();
    document.getElementById("quantity").stepUp(1);

})

$(".minus").on('focus', function () {
    $(this).blur();
})

$(".minus").on('click', function () {
    $(this).blur();
    document.getElementById("quantity").stepDown(1);
})

$("#quantity").on('blur', function () {
    var max = $(this).prop('max')
    var value = $(this).val()
    $(this).val(Math.min(max, value))
})

function showAddItemToCartMessage() {
    var x = document.getElementById("message");
    x.className = "show";
    addItemToCart(x);

    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

function addItemToCart(messageElement)  {
    var record_id = $("#record-id").text();
    var quantity = $("#quantity").val();
    console.log("id = " + record_id);
    console.log("quantity = " + quantity);

    $.ajax({
        type : 'GET',
        url : "/vinyl-store/cart/add/" + record_id + "/" + quantity,
        dataType: 'json',
        statusCode: {
            400: function(response) {
                messageElement.innerText = JSON.parse(response.responseText).message;
            },
            200: function(response) {
                messageElement.innerText = response.message;
            }
        },
        error : function() {
            messageElement.innerText = "The item has not been added to your cart. " +
                "Please try again later!";
        }
    });
}