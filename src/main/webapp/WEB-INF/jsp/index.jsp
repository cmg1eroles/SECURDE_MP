<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/index-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login-style.css">
    <link rel="icon" href="/resources/img/paw.png">
</head>
<body class = "site">
<jsp:include page="navbar.jsp" />
<div id = "content">
    <!--<a href="/pet/1"><img src = "/resources/img/pom.jpg" class = "images" href=""/></a>
    <img src = "/resources/img/husky.jpg" class = "images" />
    <img src = "/resources/img/corgi.jpg" class = "images" />
    <img src = "/resources/img/laby.jpg" class = "images" />-->

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/resources/js/login.js"></script>
<script src="/resources/js/home.js"></script>
</body>
</html>
