$(document).ready(function() {
    $('#cancel2').click(function() {	
        console.log("Cancel Clicked!");
        $('#name2').val('');
        $('#uname2').val('');			
        $('#psw2').val('');			
        $('#cpsw2').val('');			
    });

    $('#cancel1').click(function() {	
        console.log("Cancel1 Clicked!");
        $('#uname1').val('');			
        $('#psw1').val('');					
    });

});

