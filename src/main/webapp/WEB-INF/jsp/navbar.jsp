<script src="/resources/js/login.js"></script>
<script src="/resources/js/navbar.js"></script>
<nav class="navbar navbar-light bg-light fixed-top ">
    <ul class="nav justify-content">
        <li class="nav-item">
            <a class="nav-link active" href="/home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/forum">Forum</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Categories
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="typeItems">
                <a class="dropdown-item" href="/home">  </a>
            </div>
        </li>
    </ul>
    <div class="inline">
        <div id="loggedOut" class="inline" style="display:none">
            <button class="btn btn-outline-success my-2 my-sm-0" id="loginbtn" type="submit"
                    data-toggle="modal" data-target="#login-modal">Login</button>
            <button class="btn btn-outline-success my-2 my-sm-0" id="regbtn" type="submit"
                    data-toggle="modal" data-target="#register-modal">Register</button>
        </div>
        <div id="loggedIn" class="inline" style="display:none">
            <ul class="nav justify-content inline">
                <li class="nav-item">
                    <a id="nav-username" class="nav-link active" href="/profile/${sessionScope.user.id}" data-uid="${sessionScope.user.id}">${sessionScope.user.username}</a>
                </li>
                <li>
                    <button class="btn btn-outline-success my-2 my-sm-0" id="logoutbtn" type="submit">
                        <a class="link" onclick="logout()"> Logout </a>
                    </button>
                </li>
            </ul>

        </div>
    </div>
</nav>