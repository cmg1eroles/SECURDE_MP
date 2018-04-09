$(document).ready(function() {

    if ($("#nav-username").text() != "") {
        $("#adopt-btn").show()
    }

    $(document).on('click', '#rsv-submit', function() {
        console.log('submitting form!')
        var formans = {
            'adopter_id': $('#rsv-form').attr('data-uid'),
            'pet_id': $('#rsv-submit').attr('data-pid'),
            'date': $('#date').val()
        }
        console.log("date: " +$('#date').val())
        $.ajax({
            method: 'POST',
            url: '/adoptions/new',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.msg = "success") {
                    location.reload()
                }
                else console.log(response.success)

            }
        })
    })



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
                else console.log(response.success)
            }
        })
    })

    $("#regForm").submit(function(e) {
        e.preventDefault()
        console.log("register")
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
                else console.log(response.msg)
            }
        })
    })
})

