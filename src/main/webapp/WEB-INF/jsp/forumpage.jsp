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
    <style>
        #addBtn{
            margin: 10px;
            float: right;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="jumbotron">
        <div class="text-center">
            <div class="mx-auto">
                <h1 id="title"> Cats vs. Dogs </h1>
                <div id="creator"> <span> image </span>Sean Paragas</div>
                <div id="desc"> <span> created </span> December 2017</div>
            </div>

        </div>
    </div>
    <div class="col" >
        <div class="card">
            <div class="card-body">
                <h6 class="comment"> I think they are equal</h6>
                <p class="commentator"> Franchesca Chong</p>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h6 class="comment"> I think they are equal</h6>
                <p class="commentator"> Franchesca Chong</p>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h6 class="comment"> I think they are equal</h6>
                <p class="commentator"> Franchesca Chong</p>
            </div>
        </div>
    </div>
    <div class="form-group">
        <textarea class="form-control" id="newcomment" rows="4"></textarea>
        <button type="button" class="btn btn-success" id="addBtn">Add Comment</button>
    </div>
</div>
<!-- Login Modal -->
<jsp:include page="login.jsp" />
<!--Register Modal -->
<jsp:include page="register.jsp" />
</body>
</html>
