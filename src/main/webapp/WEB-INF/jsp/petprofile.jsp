<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/petprofile-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login-style.css">
    <link rel="icon" href="/resources/img/paw.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/login.js"></script>
</head>
<body class = "site">
<div class = "navbar">
    <ul>
        <li class = "left"><img id = "logo" src = '/resources/img/paw.png'/> <a> BOOP </a> </li>
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
    <div id = "profile">
        <div id = "profile-picture">
            <img id = "display-picture" src = ${picPath} />
        </div>
        <div id = "profile-bio">
            <div class = "profile-details">
                <div class = "bullets" >
                    <div class = "titles"> Type  </div>
                    <div class = "text"> ${type} </div>
                </div>
                <div class = "bullets" >
                    <div class = "titles"> Breed </div>
                    <div class = "text"> ${breed}</div>
                </div>
                <div class = "bullets" >
                    <div class = "titles"> Birthday  </div>
                    <div class = "text"> ${birthdate}</div>
                </div>
                <div class = "bullets" >
                    <div class = "titles"> Rescued  </div>
                    <div class = "text"> ${rescued}</div>
                </div>
            </div>
        </div>
    </div>

    <div id = "medical">
        <div id = "profile-name"> Medical Information </div>
        <div class = "profile-details">
            <div class = "bullets" >
                <div class = "titles"> Weight  </div>
                <div class = "text"> ${weight} </div>
            </div>
            <div class = "bullets" >
                <div class = "titles"> Vaccines </div>
                <div class = "text"> ${vaccines}</div>
            </div>
            <div class = "bullets" >
                <div class = "titles"> Conditions  </div>
                <div class = "text"> ${speccond}</div>
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