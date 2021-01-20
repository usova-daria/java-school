$(document).ready(function() {
    $('.selectpicker').selectpicker({
        style: "btn-primary"
    });
});


$("#generate_name").click(function() {
    generateName();
});

function generateName() {
    var name = musiciansToString() + ". " + $("#album").val()
    $("#name").val(name)
}

function musiciansToString() {
    var musicians = [];
    $.each($("#musician option:selected"), function(){
        musicians.push($(this).text());
    });

    return musicians.join(", ");
}


$('input[type="file"]').change(function(e){
    var fileName = e.target.files[0].name;
    $('.custom-file-label').html(fileName);
});


var text_max = 2000;
$('#count_message').html('0 / ' + text_max );

$('#description').keyup(function() {
    var text_length = $('#description').val().length;

    $('#count_message').html(text_length + ' / ' + text_max);
});