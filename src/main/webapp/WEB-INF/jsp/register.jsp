<div class = "modal" id = "id02">
    <div class = "innermodal" >
        <h2> B o o p </h2>

        <form id = "regForm">

            <div class="container">
                <label for="reg-name"><b>Full Name</b></label>
                <input id="reg-name" type="text" placeholder="Enter Full Name" name="name" required>

                <label for="reg-email"><b>Email</b></label>
                <input id="reg-email" type="email" placeholder="Enter Email" name="email" required>

                <label for="reg-uname"><b>Username</b></label>
                <input id="reg-uname" type="text" placeholder="Enter Username" name="uname" required>

                <label for="reg-pw"><b>Password</b></label>
                <input id="reg-pw" type="password" placeholder="Enter Password" name="pw" required>

                <label for="reg-confirm"><b>Confirm Password</b></label>
                <input id="reg-confirm" type="password" placeholder="Enter Password" name="confirm" required>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button class = "confirmbutton" id ="signup" type="submit">Sign up</button>
                <button id = "admintbutton"> Add Admin</button>
                <button type="button"  onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </div>
</div>