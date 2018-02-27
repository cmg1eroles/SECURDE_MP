$(document).ready(function() {


    $('#cancelbtn').click(function() {
        console.log("Cancel Clicked!");
        $('#pname').val('');
        $('#specie').val('');
        $('#breed').val('');
        $('#status').val('');
        $('#desc').val('');
        $('#meds').val('');
    });
});