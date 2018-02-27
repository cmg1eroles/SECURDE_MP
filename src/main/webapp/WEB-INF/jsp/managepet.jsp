
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/manageprofile-style.css">
    <link rel="icon" href="/resources/img/paw.png">
</head>
<body class = "site">
<jsp:include page="navbar.jsp" />
<div id = "content">
    <div id = "setting" >
        <div id = "profile-picture">
            <img id = "display-picture" src = "${picPath}"/>
        </div>
        <div id="profile-part">
            <div id="profile-details">
                <form id="formitems">
                    <div id="leftside">
                        <label class="titles"> Type </label>
                        <label class="titles"> Breed </label>
                        <label class="titles"> Birthdate </label>
                        <label class="titles"> Rescued </label>
                        <label class="titles"> Weight </label>
                        <label class="titles"> Vaccines </label>
                        <label class="titles"> Special Conditions</label>
                    </div>
                    <div id="rightside">
                        <input type="text" name="type" id="type" value="${type}">
                        <input type="text" name="breed" id="breed" value="${breed}">
                        <input type="text" name="birthday" id="birthday" value="${birthdate}">
                        ${rescued}
                        <input type="checkbox" name="rescued" id="rescued" ${rescued ? "checked='true'" : ""}> Rescued <br>

                        <input type="text" name="weight" id="weight" value="${weight}">
                        <input type="text" name="vaccines" id="vaccines" value="${vaccines}">
                        <input type="text" name="speccond" id="speccond" value="${speccond}">
                    </div>
                </form>
            </div>
            <div class="buttons-section" accesskey="n">
                <button class="buttons" id="addbtn">Add to List</button>
                <button class="buttons" id="edit-form-submit"> Update</button>
                <button class="buttons" id="cancelbtn"> Cancel </button>

            </div>
        </div>
    </div>
</div>

<div class = "modal" id = "id01">
    <div class = "innermodal" >
        <form id = "confirmForm" action="">
            <div class="container">
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
            </div>

            <div class="buttons-section" style="background-color:#f1f1f1">
                <button class="buttons" id ="signup1" type="submit">Sign up</button>
                <button class="buttons" id="cancelbtn" type="button"  onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/petmng.js"></script>
<script>
    $(document).ready(function(){
        console.log(document.getElementById('rescued').checked)

        console.log($('#rescued').val())
        var button = document.getElementById("edit-form-submit")
        button.addEventListener("click", function() {
            document.getElementById("id01").style.display = "block"
        })

        var button = document.getElementById("addbtn")
        button.addEventListener("click", function() {
            document.getElementById("id01").style.display = "block"
        })

        $('#addbtn').click(function(){
            $('#edit-form-submit').removeClass('clicked')
            $('#addbtn').addClass('clicked')
        })

        $('#edit-form-submit').click(function(){
            $('#addbtn').removeClass('clicked')
            $('#edit-form-submit').addClass('clicked')
        })

        $('#confirmForm').submit( function(evt){
            evt.preventDefault()
            var id = window.location.pathname.substring(window.location.pathname.indexOf("/")+1)
            id = id.substring(id.indexOf("/")+1)
            id = id.substring(0, id.indexOf("/"))
            console.log($('#rescued').attr('checked'))
            var formans = {
                'type' : $('#type').val(),
                'breed' : $('#breed').val(),
                'birthday' : $('#birthday').val(),
                'rescue' : document.getElementById('rescued').checked,
                'weight' : $('#weight').val(),
                'vaccines' : $('#vaccines').val(),
                'speccond' : $('#speccond').val()
            }

            var url = '/post/adoptions/'
            if ($('#addbtn').hasClass('clicked'))
                url += 'register'
            else if ($('#edit-form-submit').hasClass('clicked'))
                url += id

            $.ajax({
                method: 'POST',
                url: url,
                contentType: 'application/json',
                data: JSON.stringify(formans),
                success: function (response) {
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
    });
</script>
</body>
</html>