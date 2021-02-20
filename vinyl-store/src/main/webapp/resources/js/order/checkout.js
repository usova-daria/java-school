$(document).ready(function() {
    updateTownList();
});

$("#phoneNumber").keyup(function() {
    var number = $(this).val()
    $(this).val(number.replace(/(\d{4})-?(\d{3})-?(\d{2})-?(\d{2})/,'$1-$2-$3-$4'));
});

$("#country").change(function() {
    updateTownList();
});

function updateTownList() {
    var id = $("#country").val();
    if (id === "-1") {
        $('#town').empty();
        $("#town").append("<option value='-1'>Choose town</option>")
        return;
    }

    getTownByCountryId(id);
}

function getTownByCountryId(id) {
    $.ajax({
        type: 'GET',
        url: "/vinyl-store/checkout/towns/" + id,
        dataType: 'json',
        success: function (towns) {
            $('#town').empty();
            var len = towns.length;

            for( var i = 0; i < len; i++) {
                var id = towns[i]['id'];
                var name = towns[i]['name'];

                $("#town").append("<option value='" + id + "'>" + name + "</option>");
            }

        }
    });
}