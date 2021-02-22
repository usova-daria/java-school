$(document).ready(function () {
    $town = $("#town option")
    var len = $town.length;

    if (len === 1) {
        updateTownList();
    }
})

$("#country").change(function () {
    updateTownList();
});

function updateTownList() {
    var id = $("#country").val();
    if (id === "-1") {
        $town = $("#town")
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
            $town = $("#town")
            $town.html('')
            var len = towns.length;

            for (var i = 0; i < len; i++) {
                var id = towns[i]['id'];
                var name = towns[i]['name'];

                $town.append("<option value='" + id + "'>" + name + "</option>");
            }

            $town.selectpicker('refresh');
            $town.selectpicker('render');
        }
    });
}