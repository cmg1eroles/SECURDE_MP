function showLogin() {
    console.log("CLICKED");
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

var y = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == y) {
        y.style.display = "none";
    }
}

$(document).ready(function() {

    if ($("#h-uname a").text() == "") {
        $("#h-login").show()
        $("#h-reg").show()
    } else {
        $("#h-logout").show()
        $("#h-uname").show()
    }

    $("#loginForm").submit(function(e){
        e.preventDefault()
        var formans = {
            'username': $("#login-uname").val().trim(),
            'password': $("#login-pw").val()
        }
        $.ajax({
            method: 'POST',
            url: 'login',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.success) {
                    location.reload()
                }
                else console.log(response.success)
            }
        })
    })

    $("#regForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'fullname': $("#reg-name").val().trim(),
            'email': $("#reg-email").val().trim(),
            'username': $("#reg-uname").val().trim(),
            'password': $("#reg-pw").val(),
            'confirm': $("#reg-confirm").val()
        }
        $.ajax({
            method: 'POST',
            url: 'register',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.msg == "success") {
                    location.reload()
                }
                else console.log(response.msg)
            }
        })
    })
})

function logout() {
    $.ajax({
        method: 'POST',
        url: 'logout',
        contentType: 'application/json',
        success: function(response) {
            location.reload()
        }
    })
}