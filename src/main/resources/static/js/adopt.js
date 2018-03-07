$(document).ready(function(){
    $('#adopt-btn').click(function(){
        console.log("ADOPT CLICKED!")
        alert("You Have Adopted a pet!");
        var formans = {
            'adopter_id': $('#h-uname').attr('data-uid'),
            'pet_id': $('#adopt-btn').attr('data-pid')
        }
        $.ajax({
            method: 'POST',
            url: '/adoptions/new',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {

            }
        })
    })
})