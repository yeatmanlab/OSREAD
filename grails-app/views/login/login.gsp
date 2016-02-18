<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log In - App for Literacy</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>


</head>

<body>

<div class="container">

    <h2 class="form-signin-heading">Log In</h2>
    <g:form controller="researcher" action="login">
        <label for="email">Email:</label><g:textField name="email"/><br/>

        <label for="password">Password:</label><g:textField name="password"/><br/>

        <g:actionSubmit value="Log In" action="login"/>

        <g:link controller="Login" action="register">First Time? Register</g:link>

    </g:form>
</div> <!-- /container -->

</body>
</html>

<script>
    function login(){
        alert("Welcome " + document.getElementById("inputEmail").value + "!");
    }
</script>