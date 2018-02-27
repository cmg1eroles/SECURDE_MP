
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/manageprofile-style.css">
    <link rel="icon" href="/resources/img/paw.png">
</head>
<body class = "site">
<div class = "navbar">
    <ul>
        <li class = "left">
            <img id = "logo" src = '/resources/img/paw.png'/> <a> BOOP </a> </li>
        <li class = "left"><a> BOOP </a> </li>
        <li class = "left"><a class="link" > Home </a></li>
        <li class = "left"><a class="link" > Forum </a></li>
        <li class = "middle">
            <form>
                <input type = "search" id = "searchbar" placeholder = "Search..."/>
            </form>
        </li>
        <li class = "right"> <a> </a></li>
        <li class = "right"><a class="link" > Login </a></li>
        <li class = "right"><a class="link" > Register </a></li>
    </ul>
</div>
<div id = "content">
    <div id = "setting" >
        <div id = "profile-picture">
            <img id = "display-picture" src = "img/corgi.jpg"/>
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
                        <input type="text" name="rescue" id="rescue" value="${rescued}">
                        <input type="text" name="weight" id="weight" value="${weight}">
                        <input type="text" name="vaccines" id="vaccines" value="${vaccines}">
                        <input type="text" name="speccond" id="speccond" value="${speccond}">
                    </div>
                </form>
            </div>
            <div class="buttons-section" accesskey="n">
                <button class="buttons" id="edit-form-submit"> Update/Add to List </button>
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
                <button class="buttons" id ="signup" type="submit">Sign up</button>
                <button class="buttons" id="cancelbtn" type="button"  onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
<div class = "modal" id = "id02">
    <div class = "innermodal" >
        <form id = "changeForm" action="">
            <div class="container">
                <label for="Opsw"><b>Old Password</b></label>
                <input type="password" placeholder="Enter Password" name="Opsw" required>
                <label for="Npsw"><b>New Password</b></label>
                <input type="password" placeholder="Enter Password" name="Npsw" required>
                <label for="Cpsw"><b>Confirm Password</b></label>
                <input type="password" placeholder="Enter Password" name="Cpsw" required>
            </div>

            <div class="buttons-section" style="background-color:#f1f1f1">
                <button class="buttons" id ="signup" type="submit">Sign up</button>
                <button class="buttons" id="cancelbtn" type="button"  onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
<script>
    var button = document.getElementById("edit-form-submit")
    button.addEventListener("click", function() {
        document.getElementById("id01").style.display = "block"
    })
    var button = document.getElementById("change-form")
    button.addEventListener("click", function() {
        document.getElementById("id02").style.display = "block"
    })

</script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function() {
        $('#cancelbtn').click(function() {
            console.log("Cancel Clicked!");
            $('#pname').val('');
            $('#specie').val('');
            $('#breed').val('');
            $('#status').val('');
            $('#desc').val('');
            $('#meds').val('');
        });

    });
</script>
</body>
</html>