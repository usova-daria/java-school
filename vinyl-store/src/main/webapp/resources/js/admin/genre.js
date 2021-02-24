var editableTable = new BSTable("genre-table",{
    editableColumns:"2",
    $addButton: $("#new-row-button"),
    onEdit: function(row) {
        var id = $(row).find('td')[0].innerText;
        var name = $(row).find('td')[2].innerText;

        editGenre(id, name, row);
    },
    onBeforeDelete: function(row) {
        var id = $(row).find('td')[0].innerText;
        return deleteGenre(id, row);
    },
    onDelete: function () {
    },
    onAdd: function() { },
});
editableTable.init();

function editGenre(id, name, row) {
    var genre = {};
    genre["id"] = id;
    genre["name"] = name;

    $.ajax({
        type : 'POST',
        contentType : 'application/json; charset = UTF-8,',
        url : 'genre/edit',
        dataType : 'json',
        data : JSON.stringify(genre),
        statusCode : {
            200: function () {
                changeElementStyle('element-success', row);
            },
            503: function () {
                changeElementStyle('element-error', row);
            },
            400: function () {
                changeElementStyle('element-error', row);
            }
        },
        error : function() {
            changeElementStyle('element-error', row);
        },
        complete: function(response) {
            var updatedGenre = JSON.parse(response.responseText);
            $(row).find('td')[0].innerText = updatedGenre.id;
            $(row).find('td')[1].innerText = $(row).index() + 1;
            $(row).find('td')[2].innerText = updatedGenre.name;
        }
    });
}

function deleteGenre(id, row) {
    $.ajax({
        type : 'POST',
        url : 'genre/delete/' + id,
        statusCode: {
            200: function () {
                row.remove();
                return true;
            },
            503: function () {
                changeElementStyle('element-error', row);
                return false;
            },
            400: function () {
                $("#genre-error-message").text(response.responseText);
                $("#genre-not-deleted").click();
                return false;
            }
        }
    });
}