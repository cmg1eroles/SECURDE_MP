$(document).ready(function() {
    var word = $('#searchword').attr("data-search")
    $.ajax({
        method: 'GET',
        url: '/search/find/'+word,
        contentType: 'application/json',
        success: function(response) {
            console.log(response)
                for (var i = 0 ; i < response.length ; i++) {
                    var container
                    var deck
                    if (i%3 == 0) {
                        container = document.createElement('div')
                        deck = document.createElement('div')
                        $(container).addClass('cardcontainer')
                        $(deck).addClass('card-deck')
                    }
                    var a = document.createElement('a')
                    var img = document.createElement('img')
                    var div = document.createElement('div')

                    $(div).addClass('card')
                    $(img).addClass('card-img-top')
                    $(img).attr('src', response[i].picPath)
                    $(a).attr('href', '/pet/'+response[i].id)

                    $(a).append(img)
                    $(div).append(a)
                    $(deck).append(div)
                    if (i%3 == 0) {
                        $(container).append(deck)
                        $('#search-body').append(container)
                    }
                }
        }
    })
})