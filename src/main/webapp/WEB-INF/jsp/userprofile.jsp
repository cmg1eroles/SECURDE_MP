<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/userprofile-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login-style.css">
    <link rel="icon" href="/resources/img/paw.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/login.js"></script>
    <script>

    </script>

    <style>

    </style>
</head>
<body class = "site">
<jsp:include page="navbar.jsp" />
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
                <div id="useronly">
                    <button class="buttons" id="edit-profile"><a href="/user/manage"> Edit Profile</a> </button>
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
<jsp:include page="login.jsp" />
<jsp:include page="register.jsp" />
</body>
</html>