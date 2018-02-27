<div class = "navbar">
    <ul>
        <li class = "left">
            <img id = "logo" src = '/resources/img/paw.png'/> <a> BOOP </a> </li>
        <li class = "left"><a> BOOP </a> </li>
        <li class = "left"><a class="link" href="/home"> Home </a></li>
        <li class = "left"><a class="link"> Forum </a></li>
        <li class = "middle">
            <form>
                <input type = "search" id = "searchbar" placeholder = "Search..."/>
            </form>
        </li>
        <li class = "right"> <a> </a></li>
        <li id="h-login" class = "right" style="display: none"><a class="link"  onclick="document.getElementById('id01').style.display='block'" > Login </a></li>
        <li id="h-reg" class = "right" style="display: none"><a class="link" onclick="document.getElementById('id02').style.display='block'"> Register </a></li>
        <li id="h-logout" class = "right" style="display: none"><a class="link" onclick="logout()"> Logout </a></li>
        <li id="h-uname" class = "right" data-uid="${sessionScope.user.id}" style="display: none"><a class="link" href="/profile/${sessionScope.user.id}">${sessionScope.user.username}</a></li>
    </ul>
</div>