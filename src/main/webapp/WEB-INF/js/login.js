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
    $("#loginForm").submit(function(e){
        e.preventDefault()
        var formans = {
            'username': $("#login-uname").val().trim(),
            'password': $("#login-pw").val()
        }
        console.log(JSON.stringify(formans))
        $.ajax({
            method: 'POST',
            url: 'login',
            contentType: 'application/json',
            data: JSON.stringify(formans),
            success: function(response) {
                if (response.success)
                    console.log(response.user)
                else console.log(response.success)
            }
        })
    })
})