$(document).ready(function(){
    $.ajax({
        method: 'GET',
        url: '/animal/types',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0; i < response.length; i++) {
                $("#typeItems").append('<a class="dropdown-item" href="/type/'+ response[i].code
                                        +'" value='
                                        +response[i].code  +
                    ' >' + response[i].animalType + '</a>');
            }
        }
    })
})