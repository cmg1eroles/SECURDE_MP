<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/manageprofile-style.css">
    <link rel="icon" href="/resources/img/paw.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/login.js"></script>
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
        <li id="h-logout" class = "right" style="display: none"><a class="link" onclick="logout()"> Logout </a></li>
        <li id="h-uname" class = "right" style="display: none"><a class="link" href="/profile/${sessionScope.user.id}">${sessionScope.user.username}</a></li>
    </ul>
</div>
<div id = "content">
    <div id = "setting" >
        <div id = "profile-picture">
            <img id = "display-picture" src = "/resources/img/corgi.jpg"/>
        </div>
        <div id="profile-part">
            <div id="profile-details">
                <form id="formitems">
                    <div id="leftside">
                        <label class="titles"> Username </label>
                        <label class="titles"> Fullname </label>
                        <label class="titles"> Email </label>
                        <label class="titles"> Description </label>
                    </div>
                    <div id="rightside">
                        <input type="text" name="uname" id="uname" value="${username}">
                        <input type="text" name="fname" id="fname" value="${name}">
                        <input type="email" name="email" id="email" value="${email}">
                        <input type="text" name="desc" id="desc" value="${description}">
                    </div>
                </form>
            </div>
            <div class="buttons-section" accesskey="n">
                <button class="buttons" id="change-form"> Change Password </button>
                <button class="buttons" id="edit-form-submit"> Submit </button>
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
</body>
</html>