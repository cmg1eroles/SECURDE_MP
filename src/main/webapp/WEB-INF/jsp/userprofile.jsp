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
    <script src="/resources/js/edit-profile.js"></script>
    <link rel="stylesheet" href="/resources/css/general.css">
    <link rel="stylesheet" href="/resources/css/userprofile-style.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="jumbotron">
        <div class="text-center">
            <img src="http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png"class="rounded-circle" id="profile-pic">
            <div class="mx-auto">
                <h3 id="uname" data-uid="${id}"> ${username} <button id="btn-edit-profile"class="btn btn-primary" data-toggle="modal" data-target="#edit-modal">  <img src="/resources/img/svg/pencil.svg" alt="icon name"> </button></h3>
                <div id="name">
                    <span> ${firstname} </span>
                    <span> ${lastname} </span>
                </div>
                <div id="desc">${description}</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col" >
            <div class="card" id="forum-col">
                <!-- forums -->
                <div class="card-header"> Forums Created </div>
            </div>
        </div>
        <div class="col">
            <div class="card" id="adoption-col">
                <div class="card-header"> Past Adoptions Dates</div>

            </div>
        </div>
    </div>
</div>
<!-- Login Modal -->
<jsp:include page="login.jsp" />
<!-- Register Modal -->
<jsp:include page="register.jsp" />
<jsp:include page="forgotpassword.jsp" />
<!-- Edit Profile Modal -->
<div class="modal fade" id="edit-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="edit-modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Profile Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" id="edit_email" aria-describedby="emailHelp" placeholder="${email}" value="${email}">
                    </div>
                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" id="edit_uname" placeholder="${username}" value="${username}">
                    </div>
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" id="edit_fname" placeholder="${firstname}" value="${firstname}">
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control" id="edit_lname" placeholder="${lastname}" value="${lastname}">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" id="edit_desc" placeholder="${description}" value="${description}">
                    </div>
                    <!-- <input id="btn_register" type="submit" class="btn btn-primary" value="Register"/> -->
                </form>
                <button class = "btn btn-primary" id ="btn_edit"
                        data-toggle="modal" data-target="#confirm-modal" data-dismiss="modal">Save Changes</button>
                <button class = "btn btn-success" id ="btn_psw"
                        data-toggle="modal" data-target="#change-modal" data-dismiss="modal">Change Password</button>
            </div>
        </div>
    </div>
</div>
<!-- Confirm Changes Modal -->
<div class="modal fade" id="confirm-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="confirm-modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirmation</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="confirmForm">
                    <div class="form-group">
                        <label>Enter Password</label>
                        <input type="password" class="form-control" id="con_psw" aria-describedby="emailHelp" placeholder="Confirm Password">
                    </div>
                    <p id="msg-confirm"></p>
                    <button class = "btn btn-success" id ="btn_confirm" type="submit">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Change Password Modal -->
<div class="modal fade" id="change-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="change-modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Change Password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="changeForm">
                    <div class="form-group">
                        <label>Old Password</label>
                        <input type="password" class="form-control" id="psw_old" aria-describedby="emailHelp" placeholder="Old Password">
                    </div>
                    <div class="form-group">
                        <label>New Password</label>
                        <input type="password" class="form-control" id="psw_new" placeholder="New Password">
                    </div>
                    <div class="form-group">
                        <label>Confirm Password</label>
                        <input type="password" class="form-control" id="psw_con" placeholder="Confirm Password">
                    </div>
                    <p id="msg-change"></p>
                    <button class = "btn btn-success" id ="edit_psw" type="submit">Save Changes</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
