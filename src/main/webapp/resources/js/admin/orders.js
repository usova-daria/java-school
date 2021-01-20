$(function(){
    $(".dropdown-menu").on('click', 'a', function(){
        var button = $(this).parents('.dropdown').find('button');
        var row = $(this).parents('.dropdown').find('button').closest('tr');
        var id = $(row).find('td')[0].innerText;
        var status = $(this).text();

        var orderStatus = {};
        orderStatus["id"] = id;
        orderStatus["status"] = status;

        $.ajax({
            type : 'POST',
            contentType : 'application/json; charset = UTF-8,',
            url : 'orders/update-status',
            data : JSON.stringify(orderStatus),
            success : function() {
                changeRowStyle('row-success', row);
                $(button).text(status);
            },
            error : function() {
                changeRowStyle('row-error', row);
            }
        });
    });
});