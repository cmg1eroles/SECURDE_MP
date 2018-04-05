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
            <h3>Animals</h3>
            <table id="animal-table" class="table table-hover">
                <thead>
                <tr>
                    <th>ID#</th>
                    <th>Type</th>
                    <th>Breed</th>
                    <th>Age</th>
                    <th>Status</th>
                    <th>Vaccines</th>
                    <th>Special Conditions</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#edit-modal">Edit</button>
                        <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#delete-modal">Delete</button>
                    </td>

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
                    <th>Number of Members</th>
                    <th>Buttons</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1002</td>
                    <td>Cats vs. Dogs </td>
                    <td>Carlo </td>
                    <td>100</td>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#edit-modal">Edit</button>
                        <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#delete-modal">Delete</button>
                    </td>

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
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1001</td>
                    <td>Carlo</td>
                    <td>102001</td>
                    <td>2018-03-06</td>
                    <td>To be Picked up</td>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#edit-modal">Change Status</button>
                        <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#delete-modal">Cancel Transaction</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- Edit Modal -->
<div class="modal fade" id="edit-modal">
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
                        <input type="text" class="form-control" id="status" placeholder="In the Shelter">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!--Delete Modal -->
<div class="modal" tabindex="-1" role="dialog" id="delete-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete animal #1</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p> Are you sure you want to delete? </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger">Delete</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
