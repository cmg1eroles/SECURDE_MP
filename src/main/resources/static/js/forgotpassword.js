$(document).ready(function() {
    $("#forgotPwLink").click(function() {
        $("#login-modal").modal("hide")
        $("#forgotpw-modal").modal("show")
    })

    $("#forgotPwForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'email': $("#forgot_email").val().trim()
        }
        $.ajax({
            method: 'POST',
            url: '/password/reset',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                $("#msg-forgotPw").removeClass()
                if (response.success) {
                    $("#msg-forgotPw").addClass("msg-success")
                } else {
                    $("#msg-forgotPw").addClass("msg-error")
                }
                $("#msg-forgotPw").text(response.msg)
            }
        })
    })

    $('#forgotpw-modal').on('hidden.bs.modal', function (e) {
        $("#forgot_email").val("")
        $("#msg-forgotPw").text("")
    })
})