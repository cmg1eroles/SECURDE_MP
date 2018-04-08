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
    <script src="/resources/js/admin.js"></script>
    <script src="/resources/js/admin-functions.js"></script>
    <link rel="stylesheet" href="/resources/css/admin-style.css">
</head>
<body>
<div class="container-fluid">
    <h2>Administrator</h2>
    <br>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#animals">Animals</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#users">Users</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#forums">Forums</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#transactions">Transactions</a>
        </li>
        <li class="nav-item">
            <button type="button" class="btn btn-primary">Logout</button>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="animals" class="container tab-pane active"><br>
            <h3>Animals
                <img data-toggle="modal" data-target="#add-modal" class="icon"src="/resources/img/plus.png" alt=""/>
            </h3>
            <table id="animal-table" class="table table-hover">
                <thead>
                <tr>
                    <th>ID#</th>
                    <th>Type</th>
                    <th>Breed</th>
                    <th>Weight(lbs)</th>
                    <th>Picture Path</th>
                    <th>Vaccines</th>
                    <th>Special Conditions</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody id="table_body">

                </tbody>
            </table>
        </div>

        <div id="forums" class="container tab-pane fade"><br>
            <h3>Forums</h3>
            <table id="forum-table" class="table table-hover">
                <thead>
                <tr>
                    <th>ID#</th>
                    <th>Title</th>
                    <th>Creator</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody id="forums-body">
                </tbody>
            </table>
        </div>

        <div id="users" class="container tab-pane fade"><br>
            <h3>Users</h3>
            <table id="user-table" class="table table-hover">
                <thead>
                <tr>
                    <th>ID#</th>
                    <th>Username</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Role Code</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody id="users-body">
                </tbody>
            </table>
        </div>

        <div id="transactions" class="container tab-pane fade"><br>
            <h3>Transactions</h3>
            <table id="trans-table" class="table table-hover">
                <thead>
                <tr>
                    <th>ID#</th>
                    <th>Adopter</th>
                    <th>Animal Number</th>
                    <th>Date of Pick Up</th>
                    <th>Status</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody id="trans-body">
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Add Animal Modal -->
<div class="modal fade" id="add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Animal</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="addForm">
                    <div class="form-group">
                        <label > Type </label>
                        <select id="type_dd"class="form-control">
                            <option> -- </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label > Breed </label>
                        <select id="breed_dd" class="form-control">
                            <option> --</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label > Weight </label>
                        <input type="text" class="form-control" id="reg_weight" placeholder="Weight">
                    </div>
                    <div class="form-group">
                        <label >Vaccines </label>
                        <input type="text" class="form-control" id="reg_vaccines" placeholder="Vaccines">
                    </div>
                    <div class="form-group">
                        <label >Special Conditions</label>
                        <input type="text" class="form-control" id="reg_conditions" placeholder="Special Conditions">
                    </div>
                    <div class="form-group">
                        <label>Display Picture</label>
                        <input type="file" class="form-control-file" id="reg_picpath">
                    </div>
                    <input id="btn_register" type="submit"
                           class="btn btn-primary" data-uid="${sessionScope.user.username}"value="Register"/>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Edit Animal Modal -->
<div class="modal fade" id="animal-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editAnimalForm">                                                                                                                       </form>
                    <div class="form-group">
                        <label > Weight </label>
                        <input type="text" class="form-control" id="edit_weight" >
                    </div>
                    <div class="form-group">
                        <label >Vaccines </label>
                        <input type="text" class="form-control" id="edit_vaccines" >
                    </div>
                    <div class="form-group">
                        <label >Special Conditions</label>
                        <input type="text" class="form-control" id="edit_conditions">
                    </div>
                    <button id="btn_edit" type="submit" class="btn btn-primary" /> Save Changes </button>
                </form>
                <div id="reg-form-msg"> </div>
            </div>
        </div>
    </div>
</div>
<!-- Edit Transaction Modal -->
<div class="modal fade" id="editTrans-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label >Status</label>
                        <select id="editstatus_dd" class="form-control">
                            <option> -- </option>
                        </select>
                    </div>
                    <button id="trans_save" type="submit" class="btn btn-primary transUpdate">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Edit User Modal -->
<div class="modal fade" id="editUser-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label> User Status </label>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="enableUser" value=""name="userStatus" class="custom-control-input">
                            <label class="custom-control-label" for="enableUser"> Enable User </label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="disableUser" value="" name="userStatus" class="custom-control-input">
                            <label class="custom-control-label" for="disableUser"> Disable User </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label> User Position</label>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="regular" name="userPosition" value="0" class="custom-control-input">
                            <label class="custom-control-label" for="regular"> Regular User </label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="admin" name="userPosition" value="1" class="custom-control-input">
                            <label class="custom-control-label" for="admin"> Make Admin </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary updateUser">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!--Delete Animal Modal -->
<div class="modal" tabindex="-1" role="dialog" id="delete-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete animal </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p> Are you sure you want to delete? </p>
            </div>
            <div class="modal-footer">
                <button id="animalDelete" type="button" class="btn btn-danger ">Delete</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--Delete Forum Modal -->
<div class="modal" tabindex="-1" role="dialog" id="deleteforum-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete animal </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p> Are you sure you want to delete? </p>
            </div>
            <div class="modal-footer">
                <button id="forumDelete"type="button" class="btn btn-danger">Delete</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
