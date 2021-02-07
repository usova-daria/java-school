var editableTable = new BSTable("genre-table",{
    editableColumns:"1",
    $addButton: $("#new-row-button"),
    onEdit: function(row) {
        var id = $(row).find('td')[0].innerText;
        var name = $(row).find('td')[1].innerText;

        editGenre(id, name, row);
    },
    onBeforeDelete: function(row) {
        var id = $(row).find('td')[0].innerText;
        deleteGenre(id, row);
    },
    onDelete: function() { },
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
        data : JSON.stringify(genre),
        dataType : 'json',
        success : function() {
            changeRowStyle('row-success', row);
        },
        error : function() {
            changeRowStyle('row-error', row);
        },
        complete: function(updatedGenre) {
            var genre = JSON.parse(updatedGenre.responseText);
            $(row).find('td')[0].innerText = genre.id;
            $(row).find('td')[1].innerText = genre.name;
        }
    });
}

function deleteGenre(id, row) {
    $.ajax({
        type : 'POST',
        url : 'genre/delete/' + id,
        success : function() { },
        error : function() {
            changeRowStyle('row-error', row);
            process.exit(0); // unresolved on purpose
        }
    });

}