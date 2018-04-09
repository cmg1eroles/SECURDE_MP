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
    <link rel="stylesheet" href="/resources/css/general.css">
    <link rel="stylesheet" href="/resources/css/index-style.css">
    <script src="/resources/js/home.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <form class="form">
        <input id="search_bar" class="form-control form-control-lg" type="search" placeholder="Search" aria-label="Search">
    </form>

</div>
<jsp:include page="login.jsp" />
<jsp:include page="register.jsp" />
<jsp:include page="forgotpassword.jsp" />
</body>
</html>
