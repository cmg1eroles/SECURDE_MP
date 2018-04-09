$(document).ready( function() {
    console.log("FORUM READY!")
    if ($("#nav-username").text() != "") {
        $("#addBtn").show()
    }
    //Get Forums
    $.ajax({
        method: 'GET',
        url: '/forums',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0 ; i < response.length ; i++) {
                console.log("response : " +response)
                //var id = document.createElement('td')
                var card = document.createElement('div')
                var cardBody = document.createElement('div')
                var h5 = document.createElement('h5')
                var h6 = document.createElement('h6')
                var a = document.createElement('a')

                $(card).addClass('card')
                $(cardBody).addClass('card-body')
                $(h5).addClass('card-title')
                $(h6).addClass('members')
                $(a).addClass('btn btn-primary goForum')
                $(a).attr('data-fid', response[i].id)

                $(h5).text(response[i].title)
                $(h6).text(response[i].firstname +" " +response[i].lastname)
                $(a).text("Go to Forum")

                $(cardBody).append(h5)
                $(cardBody).append(h6)
                $(cardBody).append(a)
                $(card).append(cardBody)

                $('#forum-body').append(card)
            }
        }
    })

    $(document).on('click', '#addForum', function() {
        console.log("Create New Forum")
        var userid = $(this).attr('data-uid')
        var formans = {
            'userid':userid,
            'title': $("#add_title").val().trim()
        }
        $.ajax({
            method: 'POST',
            url: '/forums/new',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.success) {
                    location.reload()
                }
                else {
                    console.log(response.msg)
                }
            }
        })
    })


})