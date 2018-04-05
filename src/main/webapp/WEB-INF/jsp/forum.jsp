<!DOCTYPE html>
<html lang="en">
<head>
    <title>Boop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/general.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4"> Forum </h1>
        </div>
    </div>
    <div class="col" >
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Cats vs Dogs </h5>
                <h6 class="members"> <span> image </span>100 members</h6>
                <a href="#" class="btn btn-primary">Go to Forum</a>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">What to feed my cat?</h5>
                <h6 class="members"><span ></span>100 members</h6>
                <a href="#" class="btn btn-primary">Go to Forum</a>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Cats vs Dogs </h5>
                <h6 class="members"> <span> image </span>100 members</h6>
                <a href="#" class="btn btn-primary">Go to Forum</a>
            </div>
        </div>
    </div>
    <div class="text-center">
        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#forum-modal">Add Topic</button>
    </div>
</div>
<!--Add Topic Modal -->
<div class="modal fade" id="forum-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Create Topic</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Topic</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter topic title">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
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
