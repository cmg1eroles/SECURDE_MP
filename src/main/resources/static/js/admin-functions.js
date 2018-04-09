$(document).ready(function() {

    $(document).on('click', '#forumDelete', function() {
        console.log("Forum delete is clicked!")
        var id = $(this).attr('data-fid')
        $.ajax({
            method: 'DELETE',
            url: '/forums/'+id,
            contentType: 'application/json',
            success: function(response) {
                if (response.success) {
                    location.reload()
                }
            }
        })
    })

    $(document).on('click', '#animalDelete', function() {
        console.log("Animal delete is clicked!")
        var id = $(this).attr('data-pid')
        $.ajax({
            method: 'DELETE',
            url: '/animal/'+id,
            contentType: 'application/json',
            success: function(response) {
                if (response.success) {
                    location.reload()
                }
            }
        })
    })
    $(document).on('click', '.animalConfirm', function() {
        console.log("Animal delete is clicked!")
        var id = $(this).attr('data-pid')
        $("#animalDelete").attr('data-pid', id)

    })

    $(document).on('click', '.forumConfirm', function() {
        console.log("Forum is clicked!")
        var id = $(this).attr('data-fid')
        $("#forumDelete").attr('data-fid', id)

    })
    $(document).on('click', '#trans_save', function() {
        var id = $(this).attr('data-tid')
        var formans = {
            'status': $('#editstatus_dd option:selected').val()
        }
        $.ajax({
            method: 'POST',
            url:'/adoptions/'+id,
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
    $(document).on('click', '.transEdit', function() {
        console.log("transaction is clicked!")
        var id = $(this).attr('data-tid')
        $.ajax({
            method: 'GET',
            url: '/adoptions/'+id,
            contentType: 'application/json',
            success: function(response) {
                if (response != null ) {
                    $("#editstatus_dd" ).find('option[value='+response.statusCode +']').attr('selected','selected')
                    $("#trans_save").attr("data-tid", response.id)
                }
            }
        })
    })
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
        console.log("Animal Edit: " + id)
        $.ajax({
            method: 'GET',
            url: '/animal/'+id,
            contentType: 'application/json',
            success: function(response) {
                if (response != null ) {
                    console.log(response)
                    $('#edit_weight').val(response.weight);
                    $('#edit_vaccines').val(response.vaccines);
                    $('#edit_conditions').val(response.specConds);
                    $('#btn_edit').attr('data-pid', id);
                } else {
                    console.log("not success")
                }

            }
        })
    })

    $(document).on('click', '#btn_edit', function() {
        console.log("SAVING ANIMAL EDIT")
        var id = $(this).attr('data-pid')
        var formans = {
            'weight': $("#edit_weight").val().trim(),
            'vaccines': $("#edit_vaccines").val().trim(),
            'speccond': $("#edit_conditions").val().trim(),
            // 'adminId': $("#btn_edit").attr('data-uid').trim(),
        }
        $.ajax({
            method: 'POST',
            url: '/animal/' +id,
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

