$(document).ready(function() {

    $.ajax({
        method: 'GET',
        url: '/posts/adoptions',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0 ; i < response.length ; i++) {
                var a = document.createElement('a')
                var img = document.createElement('img')

                $(img).addClass('images')
                $(img).attr('src', response[i].picPath)
                $(a).attr('href', '/pet/'+response[i].id)

                $(a).append(img)
                $('#content').append(a)
            }
        }
    })

})