<!DOCTYPE html>
<html lang="en">
<head>
    <title>Boop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/general.css">
    <link rel="stylesheet" href="/resources/css/userprofile-style.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="jumbotron">
        <div class="text-center">
            <img src="https://images4.alphacoders.com/227/thumb-1920-22714.jpg"class="rounded-circle" id="profile-pic">
            <div class="mx-auto">
                <h3 id="uname"> ${username}</h3>
                <div id="name">
                    <span> ${firstname} </span>
                    <span> ${lastname} </span>
                </div>
                <div id="desc"> I love icecream, donuts, pizza, pasta, and many more....</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col" >
            <div class="card" id="forum-col">
                <!-- forums -->
                <div class="card-header"> Forums Joined </div>
                <div class="card-body">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Cats vs Dogs </h5>
                            <a href="#" class="btn btn-primary">Go to Forum</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">What to feed my cat?</h5>
                            <a href="#" class="btn btn-primary">Go to Forum</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="col">
            <div class="card" id="adoption-col">
                <div class="card-header"> Past Adoptions </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"> <span class="innerlist"> Corgi </span> </li>
                    <li class="list-group-item"> <span class="innerlist"> Husky </span> </li>
                    <li class="list-group-item"> <span class="innerlist"> Beagle </span> </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Login Modal -->
<jsp:include page="login.jsp" />
<!--Register Modal -->
<jsp:include page="register.jsp" />
</body>
</html>
