function getRecords() {
    var params = encodeQueryData(getParams());
    var url = "/vinyl-store/shop/search?" + params;
    console.log(url);

    $.get(url).done(function (fragment) {
        $("#shop-fragment").replaceWith(fragment);
    });

    history.pushState({}, 'Search items by params', '/vinyl-store/shop/filter?' + params);
}

window.addEventListener('popstate', function () {
    location.reload();
})

function encodeQueryData(data) {
    const result = [];
    for (var key in data) {
        result.push(key + '=' + data[key]);
    }

    return result.join('&');
}


$('.accordion').on('show.bs.collapse', function () {
    $(this).find(".fa").addClass("fa-angle-up").removeClass("fa-angle-down");
});

$('.accordion').on('hide.bs.collapse', function () {
    $(this).find(".fa").addClass("fa-angle-down").removeClass("fa-angle-up");
})

$(document).on("submit", "#search-form", function (e) {
    getRecords();
    e.preventDefault();
});

$(document).on("change", ".checkbox-param", function () {
    getRecords();
});

$(document).on("click", "#reset", function () {
    resetGenres();
    resetPrice();
    resetNameContains();
    resetAvailable();
    resetSort();
    getRecords();
});

function resetGenres() {
    $("input[name='genre']:checked").each(function () {
            $(this).prop("checked", false);
            $this = $(this);
            $label = $('label[for="' + $this.attr('id') + '"]');
            $label.removeClass("active");
        }
    );
}

function resetPrice() {
    inputLeft.value = parseInt(inputLeft.min);
    setLeftValue();
    inputRight.value = parseInt(inputRight.max);
    setRightValue();
}

function resetNameContains() {
    $("#search-input").val("");
}

function resetAvailable() {
    $("#available-check").prop('checked', false);
}

function resetSort() {
    $("#sort-price-low-first").prop("checked", true);
}

function getParams() {
    var params = {}
    params["genre"] = getSelectedGenres();
    params["minPrice"] = getMinPrice();
    params["maxPrice"] = getMaxPrice();
    params["available"] = getAvailable();
    params["nameContains"] = getNameContains();
    params["highPriceFirst"] = getHighPriceFirst();

    return params;
}

function getHighPriceFirst() {
    var val = $("input[name='sort-price']:checked").val();
    return val === "high";
}

function getNameContains() {
    return $("#search-input").val();
}

function getMinPrice() {
    return parseInt(inputLeft.value);
}

function getMaxPrice() {
    return parseInt(inputRight.value);
}

function getAvailable() {
    return $("#available-check").prop('checked');
}

function getSelectedGenres() {
    var genres = []
    $("input[name='genre']:checked").each(function () {
            genres.push($(this).val());
        }
    );

    return genres;
}

$(document).on("change", "input[name='sort-price']", function () {
    $(".sort-selected").addClass("sort-not-selected");
    $(".sort-selected").removeClass("sort-selected");

    $this = $(this);
    $label = $('label[for="' + $this.attr('id') + '"]');
    $label.addClass("sort-selected");
    $label.removeClass("sort-not-selected");

    getRecords();
})

// TODO: rewrite using jquery

var inputLeft = document.getElementById("input-left");
var inputRight = document.getElementById("input-right");

var thumbLeft = document.querySelector(".slider > .thumb.left");
var thumbRight = document.querySelector(".slider > .thumb.right");
var range = document.querySelector(".slider > .range");

function setLeftValue() {
    var _this = inputLeft,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.min(parseInt(_this.value), parseInt(inputRight.value) - 1);

    var percent = ((_this.value - min) / (max - min)) * 100;

    thumbLeft.style.left = percent + "%";
    range.style.left = percent + "%";

    document.getElementById("min_value").innerText = "" + _this.value;
}

setLeftValue();

function setRightValue() {
    var _this = inputRight,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.max(parseInt(_this.value), parseInt(inputLeft.value) + 1);

    var percent = ((_this.value - min) / (max - min)) * 100;

    thumbRight.style.right = (100 - percent) + "%";
    range.style.right = (100 - percent) + "%";

    document.getElementById("max_value").innerText = "" + _this.value;
}

setRightValue();

inputLeft.addEventListener("input", setLeftValue);
inputRight.addEventListener("input", setRightValue);

// input left

inputLeft.addEventListener("mouseover", function () {
    thumbLeft.classList.add("hover");
});

inputLeft.addEventListener("mouseout", function () {
    thumbLeft.classList.remove("hover");
});

inputLeft.addEventListener("mousedown", function () {
    thumbLeft.classList.add("slider-active");
});

inputLeft.addEventListener("mouseup", function () {
    thumbLeft.classList.remove("slider-active");
    getRecords();
});

// input right

inputRight.addEventListener("mouseover", function () {
    thumbRight.classList.add("hover");
});

inputRight.addEventListener("mouseout", function () {
    thumbRight.classList.remove("hover");
});

inputRight.addEventListener("mousedown", function () {
    thumbRight.classList.add("slider-active");
});

inputRight.addEventListener("mouseup", function () {
    thumbRight.classList.remove("slider-active");
    getRecords();
});
