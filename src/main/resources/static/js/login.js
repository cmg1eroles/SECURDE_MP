var time

$(document).ready(function() {

    if ($("#nav-username").text() == "") {
        $("#loggedOut").show()
    } else {
        $("#loggedIn").show()
    }

    $("#loginForm").submit(function(e){
        e.preventDefault()
        var formans = {
            'username': $("#login_email").val().trim(),
            'password': $("#login_password").val()
        }
        $.ajax({
            method: 'POST',
            url: '/login',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.success) {
                    location.reload()
                }
                else {
                    if (response.msg == "timed-out") {
                        time = response.timeout
                        setTimer()
                    } else $("#login-form-msg").text(response.msg)
                }
            }
        })
    })

    $("#regForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'email': $("#reg_email").val().trim(),
            'username': $("#reg_uname").val().trim(),
            'firstname': $("#reg_fname").val().trim(),
            'lastname': $("#reg_lname").val().trim(),
            'password': $("#reg_password").val(),
            'confirm': $("#reg_confirm").val()
        }
        $.ajax({
            method: 'POST',
            url: '/register',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.msg == "success") {
                    location.reload()
                }
                else $("#reg-form-msg").text(response.msg)
            }
        })
    })
})

function logout() {
    $.ajax({
        method: 'POST',
        url: '/logout',
        contentType: 'application/json',
        success: function(response) {
            location.reload()
        }
    })
}

function setTimer() {
    var minutes = Math.floor(time/60)
    var seconds = time % 60
    var msg = "You have too many failed attempts! Try again in"
    if (minutes > 0)
        msg += " " + minutes + "m"
    if (seconds > 0)
        msg += " " + seconds + "s"
    msg += "."
    $("#login-form-msg").text(msg)
    time--
    if (time > 0)
        setTimeout(setTimer, 1000)
    else $("#login-form-msg").text("")
}