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
    <script src="/resources/js/forumpage.js"></script>


    <style>
        #addBtn{
            margin: 10px;
            float: right;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container" id="forumPage" data-fid="${forumId}">
    <div class="jumbotron">
        <div class="text-center">
            <div class="mx-auto">
                <h1 id="title"> ${title} </h1>
                <div id="creator"> ${firstname} ${lastname} </div>
                <div id="desc"> <span> created </span> ${date}</div>
            </div>

        </div>
    </div>
    <div class="col" id="comments-body">

    </div>
    <div class="form-group" id="addComment" style="display: none">
        <textarea class="form-control" data-fid="${forumId}" id="newcomment" rows="4" ></textarea>
        <button type="button" class="btn btn-success" id="addBtn" data-fid="${forumId}" data-uid="${sessionScope.user.id}">Add Comment</button>
    </div>
</div>
<!-- Login Modal -->
<jsp:include page="login.jsp" />
<!--Register Modal -->
<jsp:include page="register.jsp" />
<jsp:include page="forgotpassword.jsp" />
</body>
</html>
