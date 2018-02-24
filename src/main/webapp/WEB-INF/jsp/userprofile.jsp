<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/userprofile-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login-style.css">
    <link rel="icon" href="/resources/img/paw.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/login.js"></script>


    <style>

    </style>
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
        <li id="h-login" class = "right" style="display: none"><a class="link"  onclick="document.getElementById('id01').style.display='block'" > Login </a></li>
        <li id="h-reg" class = "right" style="display: none"><a class="link" onclick="document.getElementById('id02').style.display='block'"> Register </a></li>
        <li id="h-logout" class = "right" style="display: none"><a class="link" onclick="logout()"> Logout </a></li>
        <li id="h-uname" class = "right" style="display: none"><a class="link" href="/profile/${sessionScope.user.id}">${sessionScope.user.username}</a></li>

    </ul>
</div>
<div id = "content">
    <div id = "profile">
        <div id = "profile-picture">
            <img id = "display-picture" src = "/resources/img/corgi.jpg"/>
        </div>
        <div id = "profile-bio">
            <div id = "profile-name"> ${username} </div>
            <div id = "profile-details">
                <div class = "bullets" >
                    <div class = "titles"> Name </div>
                    <div class = "text"> ${name} </div>
                </div>
                <div class = "bullets" >
                    <div class = "titles"> Email </div>
                    <div class = "text"> ${email} </div>
                </div>
                <div class = "bullets" >
                    <div class = "titles"> Description </div>
                    <div class = "text">  ${description} </div>
                </div>
            </div>
        </div>
    </div>
    <div id = "lower_content">
        <div id = "history">
            <div class = "header"> History </div>
            <div class = "post">
                <div class = "caption"> Husky </div>
                <div > 10/20/2015 </div>
            </div>
            <div class = "post">
                <div class = "caption"> Husky </div>
                <div > 10/20/2016 </div>
            </div>
        </div>
        <div id = "forum">
            <div class = "header"> Forum </div>
            <div class = "post">
                <div class = "caption"> Cats Vs. Dogs </div>
            </div>
            <div class = "post">
                <div class = "caption"> Dog food </div>
            </div>
        </div>
    </div>
</div>
<div class = "modal" id = "id01">
    <div class = "innermodal" >
        <h2> B o o p </h2>
        <form id = "loginForm" action="/action_page.php">

            <div class="container">

                <label for="login-uname"><b>Username</b></label>
                <input id="login-uname" type="text" placeholder="Enter Username" name="uname" required>

                <label for="login-pw"><b>Password</b></label>
                <input id="login-pw" type="password" placeholder="Enter Password" name="pw" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" type="submit"> Login </button>
                <button type="button"  onclick="document.getElementById('id01').style.display='none'"class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
<div class = "modal" id = "id02">
    <div class = "innermodal" >
        <h2> B o o p </h2>

        <form id = "regForm">

            <div class="container">
                <label for="reg-name"><b>Full Name</b></label>
                <input id="reg-name" type="text" placeholder="Enter Full Name" name="name" required>

                <label for="reg-email"><b>Email</b></label>
                <input id="reg-email" type="email" placeholder="Enter Email" name="email" required>

                <label for="reg-uname"><b>Username</b></label>
                <input id="reg-uname" type="text" placeholder="Enter Username" name="uname" required>

                <label for="reg-pw"><b>Password</b></label>
                <input id="reg-pw" type="password" placeholder="Enter Password" name="pw" required>

                <label for="reg-confirm"><b>Confirm Password</b></label>
                <input id="reg-confirm" type="password" placeholder="Enter Password" name="confirm" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" id ="signup" type="submit">Sign up</button>
                <button type="button"  onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>