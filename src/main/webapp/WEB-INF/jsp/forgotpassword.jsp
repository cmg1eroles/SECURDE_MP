<!--Login Modal -->
<script src="/resources/js/forgotpassword.js"></script>
<div class="modal fade" id="forgotpw-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Forgot Password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="forgotPwForm">
                    <div class="form-group">
                        <label for="forgot_email">Email address</label>
                        <input type="email" class="form-control" id="forgot_email" aria-describedby="emailHelp" placeholder="Email">
                    </div>
                    <p id="msg-forgotPw"></p>
                    <input id="btn_forgotPw" type="submit" class="btn btn-primary" value="Reset Password"/>
                </form>
            </div>
        </div>
    </div>
</div>