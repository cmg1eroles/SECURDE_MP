$(document).ready(function() {

    var selectedUserId

    $(document).on('click', '.userEdit', function() {
        selectedUserId = $(this).attr("data-uid")
    })

    $("#editUserForm").submit(function(e) {
        e.preventDefault()
        var formans = {
            'enabled': $("input[name=userStatus]:checked").val(),
            'type': $("input[name=userPosition]:checked").val()
        }
        $.ajax({
            method: 'POST',
            url: '/user/' + selectedUserId + '/access',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.success)
                    location.reload()
            }
        })
    })
})