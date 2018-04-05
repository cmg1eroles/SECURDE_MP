<!--Register Modal -->
<div class="modal fade" id="register-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="reg_email">Email address</label>
                        <input type="email" class="form-control" id="reg_email" aria-describedby="emailHelp" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="reg_uname">Username</label>
                        <input type="text" class="form-control" id="reg_uname" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="reg_fname">First Name</label>
                        <input type="text" class="form-control" id="reg_fname" placeholder="First name">
                    </div>
                    <div class="form-group">
                        <label for="reg_lname">Last Name</label>
                        <input type="text" class="form-control" id="reg_lname" placeholder="Last name">
                    </div>
                    <div class="form-group">
                        <label for="reg_password">Password</label>
                        <input type="password" class="form-control" id="reg_password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="reg_confirm">Confirm Password</label>
                        <input type="password" class="form-control" id="reg_confirm" placeholder="Confirm Password">
                    </div>
                    <input id="btn_register" type="submit" class="btn btn-primary" value="Register"/>
                </form>
            </div>
        </div>
    </div>
</div>