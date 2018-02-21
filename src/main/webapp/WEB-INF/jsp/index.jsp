<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="../../css/index-style.css">
    <link rel="stylesheet" type="text/css" href="../../css/login-style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/login.js"></script>
</head>
<body class = "site">
<div class = "navbar">
    <ul>
        <li class = "left">
            <img id = "logo" src = '../../img/paw.png'/> <a> BOOP </a> </li>
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
        <li id="h-uname" class = "right" style="display: none"><a class="link">${sessionScope.user.username}</a></li>
    </ul>
</div>
<div id = "content">
    <img src = "../../img/pom.jpg" class = "images" />
    <img src = "../../img/husky.jpg" class = "images" />
    <img src = "../../img/corgi.jpg" class = "images" />
    <img src = "../../img/laby.jpg" class = "images" />
    <img src = "../../img/pom.jpg" class = "images" />
    <img src = "../../img/husky.jpg" class = "images" />
    <img src = "../../img/corgi.jpg" class = "images" />
    <img src = "../../img/laby.jpg" class = "images" />
    <img src = "../../img/pom.jpg" class = "images" />
    <img src = "../../img/husky.jpg" class = "images" />
    <img src = "../../img/corgi.jpg" class = "images" />
    <img src = "../../img/laby.jpg" class = "images" />
    <img src = "../../img/pom.jpg" class = "images" />
    <img src = "../../img/husky.jpg" class = "images" />
    <img src = "../../img/corgi.jpg" class = "images" />
    <img src = "../../img/laby.jpg" class = "images" />
    <img src = "../../img/pom.jpg" class = "images" />
    <img src = "../../img/husky.jpg" class = "images" />
    <img src = "../../img/corgi.jpg" class = "images" />
    <img src = "../../img/laby.jpg" class = "images" />
    <img src = "../../img/pom.jpg" class = "images" />
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
