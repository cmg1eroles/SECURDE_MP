<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/navibar-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/petprofile-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login-style.css">
    <link rel="icon" href="/resources/img/paw.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

</head>
<body class = "site">
<jsp:include page="navbar.jsp" />
<div id = "content">
    <div id = "profile">
        <div id = "profile-picture">
            <img id = "display-picture" src = "${picPath}" />
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
                <button class="buttons" id="adopt-btn" data-pid="${id}"> Adopt Me</button>
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
            <div class="adminonly">
                <button class="buttons" id="edit-profile"><a href="/pet/${id}/manage"> Edit Profile</a> </button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="login.jsp" />
<jsp:include page="register.jsp" />
<script src="/resources/js/login.js"></script>
<script src="/resources/js/adopt.js"></script>
<script>
   $(document).ready(function(){
       var adopter_id  = $('#h-uname').attr('data-uid');
       console.log(adopter_id);
       if(adopter_id == 2) {
           $(".adminonly").show();
           console.log("IM IN!")
       }


   })
</script>
</body>
</html>