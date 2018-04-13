$(document).ready(function() {
    var loggedInUser = $("#nav-username").attr("data-uid")
    var profileUser = $("#uname").attr("data-uid")
    if (loggedInUser == profileUser)
        $("#btn-edit-profile").show()

    $.ajax({
        method: 'GET',
        url: '/forums/user/' +profileUser,
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

                $(h6).text(response[i].title)
                $(p).text(response[i].firstname +" " +response[i].lastname)

                $(cardBody).append(h6)
                $(cardBody).append(p)
                $(card).append(cardBody)

                $('#forum-col').append(card)
            }
        }
    })
    $.ajax({
        method: 'GET',
        url: '/adoptions/user/'+profileUser,
        contentType: 'application/json',
        success: function(response) {
            console.log("Past Adoptions: " + response.length)
            for (var i = 0 ; i < response.length ; i++) {
                console.log(response[i])

                var card = document.createElement('div')
                var cardBody = document.createElement('div')
                var h6 = document.createElement('h6')

                $(card).addClass('card')
                $(cardBody).addClass('card-body')
                $(h6).addClass('comment')

                $(h6).text(response[i].dateAdopted)

                $(cardBody).append(h6)
                $(card).append(cardBody)

                $('#adoption-col').append(card)
            }
        }
    })

    $("#confirmForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'id': profileUser,
            'email': $("#edit_email").val(),
            'username': $("#edit_uname").val(),
            'firstname': $("#edit_fname").val(),
            'lastname': $("#edit_lname").val(),
            'description': $("#edit_desc").val(),
            'password': $("#con_psw").val()
        }
        $.ajax({
            method: 'POST',
            url: '/user/'+profileUser,
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                $("#msg-confirm").removeClass()
                if (!response.success)
                    $("#msg-confirm").addClass("msg-error")
                else $("#msg-confirm").addClass("msg-success")
                $("#msg-confirm").text(response.msg)
            }
        })
    })

    $("#changeForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'old': $("#psw_old").val(),
            'new': $("#psw_new").val(),
            'con': $("#psw_con").val()
        }
        $.ajax({
            method: 'POST',
            url: '/changePassword',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                $("#msg-change").removeClass()
                if (!response.success)
                    $("#msg-change").addClass("msg-error")
                else $("#msg-change").addClass("msg-success")
                $("#msg-change").text(response.msg)
            }
        })
    })

    $('#change-modal').on('hidden.bs.modal', function (e) {
        $("#psw_old").val(""),
        $("#psw_new").val(""),
        $("#psw_con").val("")
        $("#msg-change").text("")
    })
    $('#confirm-modal').on('hidden.bs.modal', function (e) {
        $("#con_psw").val("")
        $("#msg-confirm").text("")
        resetEditInput()
    })
    $('#edit-modal').on('hidden.bs.modal', function (e) {
        resetEditInput()
    })
})

function resetEditInput() {
    $("#edit_email").val("")
    $("#edit_uname").val("")
    $("#edit_fname").val("")
    $("#edit_lname").val("")
    $("#edit_desc").val("")
}