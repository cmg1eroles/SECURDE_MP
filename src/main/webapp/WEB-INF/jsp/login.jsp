<div class = "modal" id = "id01">
    <div class = "innermodal" >
        <h2> B o o p </h2>
        <form id = "loginForm" action="/action_page.php">

            <div class="container">

                <label for="login-uname"><b>Username</b></label>
                <input id="login-uname" type="text" placeholder="Enter Username" name="uname" required>

                <label for="login-pw"><b>Password</b></label>
                <input id="login-pw" type="password" placeholder="Enter Password" name="pw" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" type="submit"> Login </button>
                <button type="button"  onclick="document.getElementById('id01').style.display='none'"class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>