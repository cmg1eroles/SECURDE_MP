<html>
<head>
    <link rel="icon" href="img/paw.png">
    <link rel="stylesheet" type="text/css" href="css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="css/login-style.css">
    <link rel="stylesheet" type="text/css" href="css/forum-style.css">

</head>
<body class = "site">
<div class = "navbar">
    <ul>
        <li class = "left">
            <img id = "logo" src = 'img/paw.png'/> <a> BOOP </a> </li>
        <li class = "left"><a> BOOP </a> </li>
        <li class = "left"><a class="link" > Home </a></li>
        <li class = "left"><a class="link" > Forum </a></li>
        <li class = "middle">
            <form>
                <input type = "search" id = "searchbar" placeholder = "Search..."/>
            </form>
        </li>
        <li class = "right"> <a> </a></li>
        <li class = "right"><a class="link"  onclick="document.getElementById('id01').style.display='block'" > Login </a></li>
        <li class = "right"><a class="link" onclick="document.getElementById('id02').style.display='block'"> Register </a></li>

    </ul>
</div>
<div id = "content">
    <h1> Forums </h1>
    <div class = "post">
        <div class = "innerpost">
            <div class = "title"> Forum Title </div>
            <div class = "description"> 10 members </div>
        </div>
        <button class = "join"> Join Forum </button>
    </div>
    <div class = "post">
        <div class = "innerpost">
            <div class = "title"> Forum Title </div>
            <div class = "description"> 10 members </div>
        </div>
        <button  class = "join"> Join Forum </button>
    </div>

</div>
<div class = "modal" id = "id01">
    <div class = "innermodal" >
        <h2> B o o p </h2>

        <form id = "loginForm" action="/action_page.php">

            <div class="container">

                <label for="uname"><b>Username</b></label>
                <input id="uname1" type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input id="psw1" type="password" placeholder="Enter Password" name="psw" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" type="submit"> Login </button>
                <button type="button" id="cancel1" onclick="document.getElementById('id01').style.display='none'"class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
<div class = "modal" id = "id02">
    <div class = "innermodal" >
        <h2> B o o p </h2>

        <form id = "loginForm" action="/action_page.php">

            <div class="container">
                <label for="uname"><b>Full Name</b></label>
                <input id="name2" type="text" placeholder="Enter Username" name="uname" required>

                <label for="uname"><b>Username</b></label>
                <input id="uname2"  type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input id="psw2"  type="password" placeholder="Enter Password" name="psw" required>

                <label for="psw"><b>Confirm Password</b></label>
                <input id="cpsw2" type="password" placeholder="Enter Password" name="psw" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" id ="signup" type="submit">Sign up</button>
                <button type="button"  id="cancel2" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/login.js"></script>
<script src="js/cancel.js"></script>
</body>
</html>