$(document).ready(function() {
    $(document).on('click', '.userEdit', function() {
        var id = $(this).attr('data-uid')
        $.ajax({
            method: 'GET',
            url: '/users/'+id,
            contentType: 'application/json',
            success: function(response) {
                if (response != null ) {
                    if (response.roleCode == 0){
                        $("#regular").prop("checked", true);
                    }
                    else {
                        $("#admin").prop("checked", true);
                    }
                    if (response.enabled) {
                        $("#enableUser").prop("checked", true);
                    }
                    else {
                        $("#disableUser").prop("checked", true);
                    }
                }
            }
        })
    })
    /*
    $(document).on('click', '.updateUser', function() {
        var id = $(this).attr('data-uid')
        var formans = {
            'roleCode':$('input[name=userPosition]:checked').val(),
            'enableuser': $('input[name=userStatus]:checked').val()
        }
        $.ajax({
            method: 'POST',
            url: ,
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.msg == "success") {
                    location.reload()
                }
                else $("#reg-form-msg").text(response.msg)
            }
        })

        $.ajax({
            method: 'Post',
            url: ,
            contentType: 'application/json',
            success: function(response) {

            }
        })
    })
    */
    $(document).on('click', '.animalEdit', function() {
        var id = $(this).attr('data-pid')
        var formans = {
            'weight': $("#edit_weight").val().trim(),
            'vaccines': $("#edit_vaccines").val().trim(),
            'speccond': $("#edit_conditions").val().trim(),
            // 'adminId': $("#btn_edit").attr('data-uid').trim(),
            'picpath': $("#edit_picpath").val().trim()
        }
        $.ajax({
            method: 'POST',
            url: '/animal/' +id,
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
    $(document).on('click', '.btn_edit', function() {
        var id = $(this).attr('data-pid')
        var formans = {
            'weight': $("#edit_weight").val().trim(),
            'vaccines': $("#edit_vaccines").val().trim(),
            'speccond': $("#edit_conditions").val().trim(),
           // 'adminId': $("#btn_edit").attr('data-uid').trim(),
            'picpath': $("#edit_picpath").val().trim()
        }
        $.ajax({
            method: 'POST',
            url: '/animal/' +id,
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
    $("#addForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'type': $('#type_dd').find(":selected").val(),
            'breed': $('#breed_dd').find(":selected").val(),
            'weight': $("#reg_weight").val().trim(),
            'vaccines': $("#reg_vaccines").val().trim(),
            'speccond': $("#reg_conditions").val().trim(),
            'adminId': $("#btn_register").attr('data-uid').trim(),
            'picpath': $("#reg_picpath").val().trim()
         }
         console.log($("#reg_picpath").val().trim())
        $.ajax({
            method: 'POST',
            url: '/animal/register',
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

