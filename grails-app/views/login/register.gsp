<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>


</head>

<body>

<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">Register</h2>
        <label for="inputFName" class="sr-only">First Name</label>
        <input type="text" id="inputFName" class="form-control" placeholder="First Name" required>
        <label for="inputLName" class="sr-only">Last Name</label>
        <input type="text" id="inputLName" class="form-control" placeholder="Last Name" required>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <label for="inputPassword" class="sr-only">Confirm Password</label>
        <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="register()">Register</button>
    </form>

</div> <!-- /container -->


</body>
</html>

<script>
    function register(){
        if (document.getElementById("inputPassword").value != document.getElementById("confirmPassword").value){
            alert("Passwords don't match!");
        } else {
            alert("Welcome " + document.getElementById("inputFName").value + " " + document.getElementById("inputLName").value + "!");
        }
    }
</script>