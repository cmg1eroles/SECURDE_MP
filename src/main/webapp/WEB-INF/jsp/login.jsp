<!--Login Modal -->
<div class="modal fade" id="login-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="loginForm">
                    <div class="form-group">
                        <label for="login_email">Email address</label>
                        <input type="email" class="form-control" id="login_email" aria-describedby="emailHelp" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="login_password">Password</label>
                        <input type="password" class="form-control" id="login_password" placeholder="Password">
                    </div>
                    <p id="login-form-msg" class="msg-error"></p>
                    <input id="btn_login" type="submit" class="btn btn-primary" value="Login"/>
                </form>
            </div>
        </div>
    </div>
</div>