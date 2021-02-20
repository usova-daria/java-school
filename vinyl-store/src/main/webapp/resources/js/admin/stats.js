$("#year").on('change', function () {
    var year = $(this).val();
    getYearProfit(year);
})

function getYearProfit(year) {
    var url = "/vinyl-store/admin/stats/sales/" + year;
    console.log(url);

    $.get(url).done(function (fragment) {
        $("#year-profit").replaceWith(fragment);
    });
}