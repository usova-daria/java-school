$(document).ready(function () {
    if ($('.not-available').length) {
        $(".alert").prop('hidden', false);
    }
});

$(function () {
    $("[data-toggle='tooltip']").tooltip();
});

$("#phoneNumber").keyup(function () {
    var number = $(this).val()
    $(this).val(number.replace(/(\d{4})-?(\d{3})-?(\d{2})-?(\d{2})/, '$1-$2-$3-$4'));
});

$("#country").change(function () {
    updateTownList();
});

function updateTownList() {
    var id = $("#country").val();
    if (id === "-1") {
        var $town = $("#town")
        $town.empty();
        $town.append("<option value='-1'>Choose town</option>")
        $town.selectpicker('refresh');
        $town.selectpicker('render');
        return;
    }

    getTownByCountryId(id);
}

function getTownByCountryId(id) {
    $.ajax({
        type: 'GET',
        url: "/vinyl-store/towns/" + id,
        dataType: 'json',
        success: function (towns) {
            var $town = $("#town")
            $town.html('')
            var len = towns.length;

            for (var i = 0; i < len; i++) {
                var townId = towns[i]['id'];
                var name = towns[i]['name'];

                $town.append("<option value='" + townId + "'>" + name + "</option>");
            }

            $town.selectpicker('refresh');
            $town.selectpicker('render');
        }
    });
}

$("#addresses").on('change', function () {
    var addressId = $(this).val();
    if (addressId == -1) return;

    var $addressDataElement = $("#address-data-" + addressId);

    var street = $addressDataElement.find(".street").val();
    var building = $addressDataElement.find(".building").val();
    var apt = $addressDataElement.find(".apartment").val();
    var countryId = $addressDataElement.find(".countryId").val();
    var townId = $addressDataElement.find(".townId").val();
    var postalCode = $addressDataElement.find(".postalCode").val();

    getTownByCountryIdWithSelected(countryId, townId);

    $("#street").val(street);
    $("#building").val(building);
    $("#apartment").val(apt);
    $("#country").val(countryId);
    $("#town").selectpicker('val', townId);
    $("#zip").val(postalCode);

    $(".selectpicker").selectpicker('render');
})

function getTownByCountryIdWithSelected(id, selectedId) {
    $.ajax({
        type: 'GET',
        url: "/vinyl-store/towns/" + id,
        dataType: 'json',
        success: function (towns) {
            var $town = $("#town")
            $town.html('')
            var len = towns.length;

            for (var i = 0; i < len; i++) {
                var townId = towns[i]['id'];
                var name = towns[i]['name'];

                if (townId == selectedId) {
                    $town.append("<option selected value='" + townId + "'>" + name + "</option>");
                } else {
                    $town.append("<option value='" + townId + "'>" + name + "</option>");
                }
            }

            $town.selectpicker('refresh');
            $town.selectpicker('render');
        }
    });
}