$(document).ready( function() {
    if ($("#nav-username").text() != "") {
        $("#addComment").show()
    }
    //Get Forums
    var id = $('#forumPage').attr('data-fid')
    $.ajax({
        method: 'GET',
        url: '/forums/' +id,
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0 ; i < response.length ; i++) {
                console.log("response : " +response)
                var card = document.createElement('div')
                var cardBody = document.createElement('div')
                var h6 = document.createElement('h6')
                var p = document.createElement('p')
                var p2 = document.createElement('p')

                $(card).addClass('card')
                $(cardBody).addClass('card-body')
                $(h6).addClass('comment')
                $(p).addClass('commentator')
                $(p2).addClass('commentator')

                $(h6).text(response[i].msg)
                $(p).text(response[i].firstname +" " +response[i].lastname)
                $(p2).text(response[i].datetime)

                $(cardBody).append(h6)
                $(cardBody).append(p)
                $(cardBody).append(p2)
                $(card).append(cardBody)

                $('#comments-body').append(card)
            }
        }
    })

    $(document).on('click', '#addBtn', function() {

        var userid = $(this).attr('data-uid')
        var formid = $('#newcomment').attr('data-fid')
        console.log("user:" +userid +" forum: " +formid)
        var formans = {
            'userid':userid,
            'formid': formid,
            'msg': $("#newcomment").val().trim()
        }
        $.ajax({
            method: 'POST',
            url: '/forums/comments/new',
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
