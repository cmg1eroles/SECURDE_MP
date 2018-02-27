$(document).ready(function(){

    var button = document.getElementById("edit-form-submit")
    button.addEventListener("click", function() {
        document.getElementById("id01").style.display = "block"
    })
    var button = document.getElementById("change-form")
    button.addEventListener("click", function() {
        document.getElementById("id02").style.display = "block"
    })

    $('#changeForm').submit(function(evt){
        evt.preventDefault()
        var formans = {
            'old': $('#Opsw').val(),
            'new': $('#Npsw').val(),
            'con': $('#Cpsw').val()
        }
        $.ajax({
            method: 'POST',
            url: '/changePassword',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                $('#changeMsg').removeClass()
                if (response.success) {
                    $('#changeMsg').addClass('success')
                } else {
                    $('#changeMsg').addClass('error')
                }
                $('#changeMsg').text(response.msg)
            }
        })
    })

    $('#confirmForm').submit(function(evt){
        evt.preventDefault()
        var formans = {
            'username': $('#uname').val(),
            'name': $('#fname').val(),
            'email': $('#email').val(),
            'description': $('#desc').val(),
            'password': $('#psw').val()
        }
        $.ajax({
            method: 'POST',
            url: '/user/'+ $('#h-uname').attr('data-uid'),
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                $('#confirmMsg').removeClass()
                if (response.success) {
                    $('#confirmMsg').addClass('success')
                } else {
                    $('#confirmMsg').addClass('error')
                }
                $('#confirmMsg').text(response.msg)
            }
        })
    })

    $('#changeCancel').click(function(){
        resetChange()
    })

    $('#confirmCancel').click(function(){
        resetConfirm()
    })

    $('#cancelbtn').click(function(){
        resetFields()
    })
})

function resetChange() {
    $('#Opsw').val("")
    $('#Npsw').val("")
    $('#Cpsw').val("")
}

function resetConfirm() {
    $('#psw').val("")
}

function resetFields() {
    $('#uname').val("")
    $('#fname').val("")
    $('#email').val("")
    $('#desc').val("")
}